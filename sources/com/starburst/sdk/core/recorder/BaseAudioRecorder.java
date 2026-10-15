package com.starburst.sdk.core.recorder;

import com.starburst.sdk.api.AudioSessionStorageConfig;
import com.starburst.sdk.req.VoiceChatStartConfig;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public class BaseAudioRecorder implements IBaseAudioRecorder {
    public static final Companion Companion = new Companion(null);
    public static final String SCENARIO_ASR = "asr";
    public static final String SCENARIO_CONVERSATION = "conversation";
    public static final String SCENARIO_TRANSLATE = "translate";
    private volatile AudioSessionStorageConfig _audioSessionStorageConfig;
    private volatile String _recordingScenario;
    private volatile String _recordingType;
    private volatile boolean automaticGainControlEnabled;
    private boolean isRecoderFromEarphone;
    private VadStateChangeListener vadStateChangeListener;
    private final CopyOnWriteArraySet<AudioDataFiredListener> audioDataFiredListeners = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<IBaseAudioRecorder.RecorderStateListener> recorderStateListeners = new CopyOnWriteArraySet<>();
    private VoiceActivationMode voiceActivationMode = VoiceActivationMode.TYPE_VAD_ACTIVATED_START_END;
    private boolean isForceUseSco = true;
    private volatile float recordAudioGain = 1.0f;
    private volatile int vadSilenceThreshold = 63;
    private volatile int vadEnergyThreshold = 10000;
    private volatile int vadMinSpeechMs = 240;
    private volatile int vadSilenceDetectMs = 500;
    private volatile int vadResetSilenceMs = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;
    private volatile int vadEndSilenceMs = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;
    private volatile int vadLongSpeechEndSilenceMs = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;

    public interface AudioDataFiredListener {
        void onAudioDataFired(byte[] bArr);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    private final byte[] applyConfiguredGain(byte[] bArr) {
        float f6 = this.recordAudioGain;
        if (bArr.length >= 2 && Math.abs(f6 - 1.0f) >= 1.0E-4f) {
            bArr = Arrays.copyOf(bArr, bArr.length);
            k.d(bArr, "copyOf(...)");
            int i9 = 0;
            while (true) {
                int i10 = i9 + 1;
                if (i10 >= bArr.length) {
                    break;
                }
                int iY = O7.k.Y(Math.round(((short) ((bArr[i9] & 255) | (bArr[i10] << 8))) * f6), -32768, 32767);
                bArr[i9] = (byte) (iY & 255);
                bArr[i10] = (byte) ((iY >> 8) & 255);
                i9 += 2;
            }
        }
        return bArr;
    }

    public final void addOnAudioDataFiredListener(AudioDataFiredListener listener) {
        k.e(listener, "listener");
        this.audioDataFiredListeners.add(listener);
    }

    public final void addRecorderStateListener(IBaseAudioRecorder.RecorderStateListener listener) {
        k.e(listener, "listener");
        this.recorderStateListeners.add(listener);
    }

    public final void clearListeners() {
        this.audioDataFiredListeners.clear();
        this.vadStateChangeListener = null;
        this.recorderStateListeners.clear();
    }

    public final void fireAudioData(byte[] data) {
        k.e(data, "data");
        byte[] bArrApplyConfiguredGain = applyConfiguredGain(data);
        Iterator<AudioDataFiredListener> it = this.audioDataFiredListeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioDataFired(bArrApplyConfiguredGain);
        }
    }

    public AudioSessionStorageConfig getAudioSessionStorageConfig() {
        AudioSessionStorageConfig audioSessionStorageConfig = this._audioSessionStorageConfig;
        if (audioSessionStorageConfig != null) {
            return new AudioSessionStorageConfig(audioSessionStorageConfig);
        }
        return null;
    }

    public float getRecordAudioGain() {
        return this.recordAudioGain;
    }

    public final Set<IBaseAudioRecorder.RecorderStateListener> getRecorderStateListenersSnapshot() {
        return new LinkedHashSet(this.recorderStateListeners);
    }

    public String getRecordingScenario() {
        return this._recordingScenario;
    }

    public String getRecordingType() {
        return this._recordingType;
    }

    public final int getVadEndSilenceMs() {
        return this.vadEndSilenceMs;
    }

    public final int getVadEnergyThreshold() {
        return this.vadEnergyThreshold;
    }

    public final int getVadLongSpeechEndSilenceMs() {
        return this.vadLongSpeechEndSilenceMs;
    }

    public final int getVadMinSpeechMs() {
        return this.vadMinSpeechMs;
    }

    public final int getVadResetSilenceMs() {
        return this.vadResetSilenceMs;
    }

    public final int getVadSilenceDetectMs() {
        return this.vadSilenceDetectMs;
    }

    public final int getVadSilenceThreshold() {
        return this.vadSilenceThreshold;
    }

    public VoiceActivationMode getVoiceActivationMode() {
        return this.voiceActivationMode;
    }

    public boolean isAutomaticGainControlEnabled() {
        return this.automaticGainControlEnabled;
    }

    public final boolean isRecoderFromEarphone() {
        return this.isRecoderFromEarphone;
    }

    public boolean isRecordFileSaveEnabled() {
        return false;
    }

    public boolean isRecording() {
        return false;
    }

    public final void notifyError(String message) {
        k.e(message, "message");
        Iterator<T> it = this.recorderStateListeners.iterator();
        while (it.hasNext()) {
            ((IBaseAudioRecorder.RecorderStateListener) it.next()).onError(message);
        }
    }

    public final void notifyFileSaved(String path) {
        k.e(path, "path");
        Iterator<T> it = this.recorderStateListeners.iterator();
        while (it.hasNext()) {
            ((IBaseAudioRecorder.RecorderStateListener) it.next()).onFileSaved(path);
        }
    }

    public final void notifyStarted() {
        Iterator<T> it = this.recorderStateListeners.iterator();
        while (it.hasNext()) {
            ((IBaseAudioRecorder.RecorderStateListener) it.next()).onStarted();
        }
    }

    public final void notifyStopped() {
        Iterator<T> it = this.recorderStateListeners.iterator();
        while (it.hasNext()) {
            ((IBaseAudioRecorder.RecorderStateListener) it.next()).onStopped();
        }
    }

    public final void removeOnAudioDataFiredListener(AudioDataFiredListener listener) {
        k.e(listener, "listener");
        this.audioDataFiredListeners.remove(listener);
    }

    public final void removeRecorderStateListener(IBaseAudioRecorder.RecorderStateListener listener) {
        k.e(listener, "listener");
        this.recorderStateListeners.remove(listener);
    }

    public void setAudioSessionStorageConfig(AudioSessionStorageConfig audioSessionStorageConfig) {
        this._audioSessionStorageConfig = audioSessionStorageConfig != null ? new AudioSessionStorageConfig(audioSessionStorageConfig) : null;
    }

    public void setAutomaticGainControlEnabled(boolean z8) {
        this.automaticGainControlEnabled = z8;
    }

    public final void setForceUseSco(boolean z8) {
        this.isForceUseSco = z8;
    }

    public final void setOnVadStateChangeListener(VadStateChangeListener vadStateChangeListener) {
        this.vadStateChangeListener = vadStateChangeListener;
    }

    public final void setRecoderFromEarphone(boolean z8) {
        this.isRecoderFromEarphone = z8;
    }

    public void setRecordAudioGain(float f6) {
        this.recordAudioGain = O7.k.X(f6, 0.1f, 50.0f);
    }

    public void setRecordingScenario(String str) {
        this._recordingScenario = str;
    }

    public void setRecordingType(String str) {
        this._recordingType = str;
    }

    public final void setVadDetectionConfig(int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.vadSilenceThreshold = i9;
        this.vadEnergyThreshold = i10;
        this.vadMinSpeechMs = i11;
        this.vadSilenceDetectMs = i12;
        this.vadResetSilenceMs = i13;
        this.vadEndSilenceMs = i14;
        this.vadLongSpeechEndSilenceMs = i15;
    }

    public void setVoiceActivationMode(VoiceActivationMode voiceActivationMode) {
        k.e(voiceActivationMode, "voiceActivationMode");
        this.voiceActivationMode = voiceActivationMode;
    }

    public final boolean shouldForceUseSco() {
        return this.isRecoderFromEarphone && this.isForceUseSco;
    }

    @Override // com.starburst.sdk.core.recorder.IBaseAudioRecorder
    public void startRecording(IBaseAudioRecorder.RecorderStateListener recorderStateListener) {
        k.e(recorderStateListener, "recorderStateListener");
    }

    public final void vadPrefetch() {
        VadStateChangeListener vadStateChangeListener = this.vadStateChangeListener;
        if (vadStateChangeListener != null) {
            vadStateChangeListener.onVadPrefetch();
        }
    }

    public final void vadStateChange(boolean z8) {
        VadStateChangeListener vadStateChangeListener = this.vadStateChangeListener;
        if (vadStateChangeListener != null) {
            vadStateChangeListener.onVadStateChange(z8);
        }
    }

    public final void notifyStarted(String format, String codec, int i9, int i10) {
        k.e(format, "format");
        k.e(codec, "codec");
        Iterator<T> it = this.recorderStateListeners.iterator();
        while (it.hasNext()) {
            ((IBaseAudioRecorder.RecorderStateListener) it.next()).onStarted(format, codec, i9, i10);
        }
    }

    @Override // com.starburst.sdk.core.recorder.IBaseAudioRecorder
    public void startRecording(IBaseAudioRecorder.RecorderStateListener recorderStateListener, String str) {
        k.e(recorderStateListener, "recorderStateListener");
        setRecordingScenario(str);
        startRecording(recorderStateListener);
    }

    public void resetVadState() {
    }

    @Override // com.starburst.sdk.core.recorder.IBaseAudioRecorder
    public void stopRecording() {
    }

    public interface VadStateChangeListener {
        void onVadPrefetch();

        void onVadStateChange(boolean z8);

        public static final class DefaultImpls {
            public static void onVadPrefetch(VadStateChangeListener vadStateChangeListener) {
            }
        }
    }

    public void setRecordFileSaveEnabled(boolean z8) {
    }

    public void setRecordFileSavePath(String str) {
    }
}
