package com.starburst.sdk.core.asr.callback;

/* JADX INFO: loaded from: classes.dex */
public interface IWsAsrCallback {
    void onAsrResult(String str);

    void onClose();

    void onEnd();

    void onError(int i9, String str);
}
