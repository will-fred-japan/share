package com.bytedance.starburst.vad;

import com.starburst.sdk.req.VoiceChatStartConfig;

/* JADX INFO: loaded from: classes.dex */
public final class StarburstVad implements AutoCloseable {
    public static final int END = 2;
    public static final int FRAME_DURATION_MS = 30;
    public static final int FRAME_SAMPLES = 480;
    private static final Object LOCK = new Object();
    public static final int SAMPLE_RATE = 16000;
    public static final int SILENCE = 0;
    public static final int SPEECH = 1;
    private long handle;

    public static final class Config {
        public final int endSilenceMs;
        public final int energyThreshold;
        public final int longSpeechEndSilenceMs;
        public final int minSpeechMs;
        public final int resetSilenceMs;
        public final int silenceDetectMs;
        public final int silenceThreshold;

        public Config() {
            this(63, 10000, 240, 500, VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE, VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE, VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int[] values() {
            return new int[]{this.silenceThreshold, this.energyThreshold, this.minSpeechMs, this.silenceDetectMs, this.resetSilenceMs, this.endSilenceMs, this.longSpeechEndSilenceMs};
        }

        public Config(int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
            if (i9 < 0 || i9 > 127 || i10 <= 0) {
                throw new IllegalArgumentException("静音阈值须为 0–127，能量阈值须大于 0");
            }
            int[] iArr = {i11, i12, i13, i14, i15};
            for (int i16 = 0; i16 < 5; i16++) {
                int i17 = iArr[i16];
                if (i17 < 20 || i17 > 60000 || i17 % 20 != 0) {
                    throw new IllegalArgumentException("时长须为 20–60000 ms，且为 20 的整数倍");
                }
            }
            if (i11 >= i13) {
                throw new IllegalArgumentException("最短语音时长须小于无语音重置时长");
            }
            this.silenceThreshold = i9;
            this.energyThreshold = i10;
            this.minSpeechMs = i11;
            this.silenceDetectMs = i12;
            this.resetSilenceMs = i13;
            this.endSilenceMs = i14;
            this.longSpeechEndSilenceMs = i15;
        }
    }

    public static final class Result {
        public final int state;
        public final boolean trailingSilence;

        private Result(int i9) {
            this.state = i9 & 3;
            this.trailingSilence = (i9 & 4) != 0;
        }
    }

    static {
        System.loadLibrary("starburst_vad");
    }

    public StarburstVad(Config config) {
        if (config == null) {
            throw new IllegalArgumentException("config == null");
        }
        synchronized (LOCK) {
            this.handle = nativeCreate(config.values());
        }
    }

    private void ensureOpen() {
        if (this.handle == 0) {
            throw new IllegalStateException("VAD 已关闭");
        }
    }

    private static native void nativeClose(long j);

    private static native long nativeCreate(int[] iArr);

    private static native int nativeProcess(long j, short[] sArr);

    private static native void nativeReset(long j);

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (LOCK) {
            try {
                long j = this.handle;
                if (j != 0) {
                    nativeClose(j);
                    this.handle = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Result process(short[] sArr) {
        Result result;
        if (sArr == null || sArr.length != 480) {
            throw new IllegalArgumentException("每帧必须为 480 个 PCM16 采样点");
        }
        synchronized (LOCK) {
            ensureOpen();
            result = new Result(nativeProcess(this.handle, sArr));
        }
        return result;
    }

    public void reset() {
        synchronized (LOCK) {
            ensureOpen();
            nativeReset(this.handle);
        }
    }
}
