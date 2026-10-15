package com.starburst.sdk.api;

import com.starburst.sdk.core.model.FileTaskResult;

/* JADX INFO: loaded from: classes.dex */
public interface ITaskProcessStatusListener {
    void onFailure(String str, String str2);

    void onProcessing(String str, int i9);

    void onSuccess(String str, FileTaskResult fileTaskResult);
}
