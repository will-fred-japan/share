package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    private static final String TAG = "ResultCallbacks";

    public abstract void onFailure(Status status);

    public abstract void onSuccess(R r8);

    @Override // com.huawei.hms.support.api.client.ResultCallback
    public final void onResult(R r8) {
        try {
            Status status = r8.getStatus();
            if (status.isSuccess()) {
                onSuccess(r8);
                return;
            }
            onFailure(status);
            if (r8 instanceof Releasable) {
                ((Releasable) r8).release();
            }
        } catch (Exception e9) {
            HMSLog.w(TAG, "Failed to release " + r8 + ", reason: " + e9);
        }
    }
}
