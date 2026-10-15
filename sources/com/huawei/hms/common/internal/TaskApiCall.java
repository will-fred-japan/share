package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Parcelable f14984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CancellationToken f14986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14987f;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.f14987f = 1;
        this.f14982a = str;
        this.f14983b = str2;
        this.f14984c = null;
        this.f14985d = null;
    }

    public abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.f14987f;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.f14984c;
    }

    public String getRequestJson() {
        return this.f14983b;
    }

    public CancellationToken getToken() {
        return this.f14986e;
    }

    public String getTransactionId() {
        return this.f14985d;
    }

    public String getUri() {
        return this.f14982a;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.f14986e;
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.f14982a + ", transactionId:" + this.f14985d);
            return;
        }
        HMSLog.i("TaskApiCall", "doExecute, uri:" + this.f14982a + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.f14985d);
        doExecute(clientt, responseErrorCode, str, taskCompletionSource);
    }

    public void setApiLevel(int i9) {
        this.f14987f = i9;
    }

    public void setParcelable(Parcelable parcelable) {
        this.f14984c = parcelable;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.f14986e = cancellationToken;
    }

    public void setTransactionId(String str) {
        this.f14985d = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.f14987f = 1;
        this.f14982a = str;
        this.f14983b = str2;
        this.f14984c = null;
        this.f14985d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i9) {
        this.f14982a = str;
        this.f14983b = str2;
        this.f14984c = null;
        this.f14985d = str3;
        this.f14987f = i9;
    }
}
