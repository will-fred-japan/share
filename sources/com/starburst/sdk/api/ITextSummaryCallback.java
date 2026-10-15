package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface ITextSummaryCallback {
    void onError(String str);

    void onSummaryResult(String str);

    void onTranslateResult(String str);
}
