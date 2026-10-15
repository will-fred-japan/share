package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f14988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource<TResult> f14989b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.f14988a = taskApiCall;
        this.f14989b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f14988a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.f14989b;
    }
}
