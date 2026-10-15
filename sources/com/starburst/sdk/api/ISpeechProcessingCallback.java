package com.starburst.sdk.api;

import com.starburst.sdk.core.asr.AsrRes;

/* JADX INFO: loaded from: classes.dex */
public interface ISpeechProcessingCallback {
    void onClose();

    void onError(int i9, String str);

    void onFileSaved(String str);

    void onLastPackage();

    void onRecognizeText(AsrRes asrRes);

    void onSpeakerResult(AsrRes asrRes);

    void onStop(String str);

    void onTranslateText(AsrRes asrRes);

    void onTtsResult(int i9, byte[] bArr, int i10, String str);

    void onVoiceRecord(byte[] bArr);

    default void onIntensityData(int i9, float[][] fArr) {
    }

    default void onStereoFileSaved(String str, String str2) {
    }

    default void onStereoRecognizeText(int i9, AsrRes asrRes) {
    }

    default void onStereoSpeakerResult(int i9, AsrRes asrRes) {
    }

    default void onStereoTranslateText(int i9, AsrRes asrRes) {
    }

    default void onDetectedLanguage(String str, String str2, AsrRes asrRes) {
    }

    default void onStereoTtsResult(int i9, int i10, byte[] bArr) {
    }

    default void onStereoDetectedLanguage(int i9, String str, String str2, AsrRes asrRes) {
    }
}
