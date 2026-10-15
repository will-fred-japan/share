package com.starburst.sdk.core.asr.callback;

/* JADX INFO: loaded from: classes.dex */
public interface IVoiceRecordCallback {
    void onFileSaved(String str);

    void onRecordError(int i9, String str);

    void onStop();

    void onVoiceRecord(byte[] bArr);
}
