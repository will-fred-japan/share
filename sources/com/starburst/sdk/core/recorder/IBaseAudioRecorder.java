package com.starburst.sdk.core.recorder;

/* JADX INFO: loaded from: classes.dex */
public interface IBaseAudioRecorder {

    public interface RecorderStateListener {

        public static final class DefaultImpls {
            public static void onStarted(RecorderStateListener recorderStateListener) {
                recorderStateListener.onStarted("raw", "raw", 0, 0);
            }
        }

        void onError(String str);

        void onFileSaved(String str);

        void onStarted();

        void onStarted(String str, String str2, int i9, int i10);

        void onStopped();
    }

    void startRecording(RecorderStateListener recorderStateListener);

    void startRecording(RecorderStateListener recorderStateListener, String str);

    void stopRecording();
}
