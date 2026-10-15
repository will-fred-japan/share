package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class d<TResult> implements ExecuteResult<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnCompleteListener<TResult> f14660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f14661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14662c = new Object();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f14663a;

        public a(Task task) {
            this.f14663a = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this.f14662c) {
                try {
                    OnCompleteListener<TResult> onCompleteListener = d.this.f14660a;
                    if (onCompleteListener != null) {
                        onCompleteListener.onComplete(this.f14663a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f14660a = onCompleteListener;
        this.f14661b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        synchronized (this.f14662c) {
            this.f14660a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        this.f14661b.execute(new a(task));
    }
}
