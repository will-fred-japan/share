package com.starburst.sdk.core.asr;

import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.starburst.sdk.core.device.bt.BleMsgManager;
import com.starburst.sdk.core.opus.BaseOpusEncoder;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import com.starburst.sdk.req.DeviceRecordConfig;
import com.starburst.sdk.utils.j;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class CallTranslationTtsSender {
    private static final int CHANNEL_LEFT = 1;
    private static final int CHANNEL_RIGHT = 2;
    private static final int CODEC_OPUS_RAW = 1;
    private static final int DATA_TYPE_APP_TO_DEVICE_AUDIO = 25;
    private static final String TAG = "CallTranslationTts";
    private boolean active;
    private final int channelCount;
    private final OpusCodecConfig codecConfig;
    private final BaseOpusEncoder encoder;
    private final ErrorListener errorListener;
    private boolean failed;
    private ChannelState leftState;
    private final Object lock = new Object();
    private final DeviceRecordConfig.PacketPolicy packetPolicy;
    private ChannelState rightState;
    private ScheduledExecutorService sendExecutor;

    public static final class ChannelState {
        final BaseOpusEncoder.EncoderSession session;
        byte[] pcmCache = new byte[0];
        byte[] opusCache = new byte[0];
        final Queue<byte[]> packetQueue = new ArrayDeque();
        int translateIndex = -1;

        public ChannelState(BaseOpusEncoder.EncoderSession encoderSession) {
            this.session = encoderSession;
        }
    }

    public interface ErrorListener {
        void onError(int i9, String str);
    }

    public CallTranslationTtsSender(BaseOpusEncoder baseOpusEncoder, OpusCodecConfig opusCodecConfig, DeviceRecordConfig.PacketPolicy packetPolicy, int i9, ErrorListener errorListener) {
        this.encoder = baseOpusEncoder;
        this.codecConfig = new OpusCodecConfig(opusCodecConfig);
        this.packetPolicy = packetPolicy;
        this.channelCount = i9;
        this.errorListener = errorListener;
    }

    private static byte[] append(byte[] bArr, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, bArrCopyOf, bArr.length, bArr2.length);
        return bArrCopyOf;
    }

    private void encodeFrame(ChannelState channelState, byte[] bArr) {
        try {
            byte[] bArrEncode = channelState.session.encode(bArr);
            int encodedBytesPerFrame = this.codecConfig.getEncodedBytesPerFrame();
            if (bArrEncode != null && bArrEncode.length == encodedBytesPerFrame) {
                channelState.opusCache = append(channelState.opusCache, bArrEncode);
                queueFullPackets(channelState);
                return;
            }
            StringBuilder sb = new StringBuilder("Unexpected Opus frame length, expected ");
            sb.append(encodedBytesPerFrame);
            sb.append(" but was ");
            sb.append(bArrEncode == null ? 0 : bArrEncode.length);
            failLocked(INotificationPermissionCallback.CODE_FREQUENT, sb.toString());
        } catch (Throwable th) {
            failLocked(INotificationPermissionCallback.CODE_UNSUPPORT, "Opus encoding failed: " + th.getMessage());
        }
    }

    private void encodePaddedRemainder(ChannelState channelState) {
        if (channelState.pcmCache.length == 0) {
            return;
        }
        byte[] bArr = new byte[this.codecConfig.getPcmBytesPerFrame()];
        byte[] bArr2 = channelState.pcmCache;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        channelState.pcmCache = new byte[0];
        encodeFrame(channelState, bArr);
    }

    private void failLocked(int i9, String str) {
        this.failed = true;
        reportError(i9, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$start$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "CallTranslationTtsSender");
        thread.setDaemon(true);
        return thread;
    }

    private void queueFullPackets(ChannelState channelState) {
        int packetSizeBytes = this.packetPolicy.getPacketSizeBytes();
        while (true) {
            byte[] bArr = channelState.opusCache;
            if (bArr.length < packetSizeBytes) {
                return;
            }
            channelState.packetQueue.offer(Arrays.copyOfRange(bArr, 0, packetSizeBytes));
            byte[] bArr2 = channelState.opusCache;
            channelState.opusCache = Arrays.copyOfRange(bArr2, packetSizeBytes, bArr2.length);
        }
    }

    private void queueOpusRemainder(ChannelState channelState) {
        queueFullPackets(channelState);
        byte[] bArr = channelState.opusCache;
        if (bArr.length > 0) {
            channelState.packetQueue.offer(bArr);
            channelState.opusCache = new byte[0];
        }
    }

    private static void release(ChannelState channelState) {
        BaseOpusEncoder.EncoderSession encoderSession;
        if (channelState == null || (encoderSession = channelState.session) == null) {
            return;
        }
        try {
            encoderSession.release();
        } catch (Throwable unused) {
        }
    }

    private void reportError(int i9, String str) {
        j.f(TAG, str);
        ErrorListener errorListener = this.errorListener;
        if (errorListener != null) {
            errorListener.onError(i9, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAvailablePackets() {
        synchronized (this.lock) {
            try {
                if (this.active && !this.failed) {
                    sendChannelPacket(1, this.leftState);
                    if (this.channelCount == 2) {
                        sendChannelPacket(2, this.rightState);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void sendChannelPacket(int i9, ChannelState channelState) {
        if (channelState == null || channelState.packetQueue.isEmpty()) {
            return;
        }
        byte[] bArrPoll = channelState.packetQueue.poll();
        byte[] bArr = new byte[bArrPoll.length + 3];
        bArr[0] = 25;
        bArr[1] = (byte) i9;
        bArr[2] = 1;
        System.arraycopy(bArrPoll, 0, bArr, 3, bArrPoll.length);
        b89.a56(BleMsgManager.getInstance(), 72, bArr);
    }

    private void stopLocked() {
        this.active = false;
        ScheduledExecutorService scheduledExecutorService = this.sendExecutor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.sendExecutor = null;
        }
        release(this.leftState);
        release(this.rightState);
        this.leftState = null;
        this.rightState = null;
    }

    public void enqueuePcm(int i9, int i10, byte[] bArr) {
        ChannelState channelState;
        int i11;
        if (bArr == null || bArr.length == 0) {
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.active && !this.failed) {
                    if (i9 == 1) {
                        channelState = this.leftState;
                    } else {
                        channelState = i9 == 2 ? this.rightState : null;
                    }
                    if (channelState == null) {
                        reportError(2003, "Unsupported TTS channel: " + i9);
                    } else {
                        if (i10 >= 0 && (i11 = channelState.translateIndex) >= 0 && i10 != i11) {
                            encodePaddedRemainder(channelState);
                            queueOpusRemainder(channelState);
                        }
                        if (i10 >= 0) {
                            channelState.translateIndex = i10;
                        }
                        channelState.pcmCache = append(channelState.pcmCache, bArr);
                        int pcmBytesPerFrame = this.codecConfig.getPcmBytesPerFrame();
                        while (true) {
                            byte[] bArr2 = channelState.pcmCache;
                            if (bArr2.length < pcmBytesPerFrame || !this.active || this.failed) {
                                break;
                            }
                            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, 0, pcmBytesPerFrame);
                            byte[] bArr3 = channelState.pcmCache;
                            channelState.pcmCache = Arrays.copyOfRange(bArr3, pcmBytesPerFrame, bArr3.length);
                            encodeFrame(channelState, bArrCopyOfRange);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void flushPcm(int i9) {
        ChannelState channelState;
        synchronized (this.lock) {
            try {
                if (this.active && !this.failed) {
                    if (i9 == 1) {
                        channelState = this.leftState;
                    } else {
                        channelState = i9 == 2 ? this.rightState : null;
                    }
                    if (channelState != null) {
                        encodePaddedRemainder(channelState);
                        queueOpusRemainder(channelState);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean start() {
        synchronized (this.lock) {
            stopLocked();
            try {
                this.leftState = new ChannelState(this.encoder.createSession(new OpusCodecConfig(this.codecConfig)));
                if (this.channelCount == 2) {
                    this.rightState = new ChannelState(this.encoder.createSession(new OpusCodecConfig(this.codecConfig)));
                }
                if (this.leftState.session == null || (this.channelCount == 2 && this.rightState.session == null)) {
                    throw new IllegalStateException("createSession returned null");
                }
                this.active = true;
                this.failed = false;
                ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new e());
                this.sendExecutor = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.starburst.sdk.core.asr.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16403a.sendAvailablePackets();
                    }
                }, this.packetPolicy.getIntervalMs(), this.packetPolicy.getIntervalMs(), TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                stopLocked();
                reportError(2002, "Failed to create Opus encoder session: " + th.getMessage());
                return false;
            }
        }
        return true;
    }

    public void stop() {
        synchronized (this.lock) {
            stopLocked();
        }
    }
}
