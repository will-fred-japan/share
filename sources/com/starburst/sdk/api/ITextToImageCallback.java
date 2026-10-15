package com.starburst.sdk.api;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ITextToImageCallback {
    void onCanceled(String str, boolean z8);

    void onCreated(String str);

    void onError(String str, int i9, String str2);

    void onProcessing(String str, int i9);

    void onSuccess(String str, List<String> list);
}
