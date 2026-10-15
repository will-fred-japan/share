package com.starburst.sdk.api;

import com.starburst.sdk.req.AsrSse;

/* JADX INFO: loaded from: classes.dex */
public interface ISplitRequestCallback {
    void onClose();

    default void onError(int i9, String str) {
        onError(str);
    }

    void onError(String str);

    void onResult(AsrSse asrSse);
}
