package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class h<TResult> implements ExecuteResult<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnSuccessListener<TResult> f14678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f14679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14680c = new Object();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f14681a;

        public a(Task task) {
            this.f14681a = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (h.this.f14680c) {
                try {
                    OnSuccessListener<TResult> onSuccessListener = h.this.f14678a;
                    if (onSuccessListener != null) {
                        onSuccessListener.onSuccess((TResult) this.f14681a.getResult());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f14678a = onSuccessListener;
        this.f14679b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        synchronized (this.f14680c) {
            this.f14678a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (!task.isSuccessful() || ((i) task).f14685c) {
            return;
        }
        this.f14679b.execute(new a(task));
    }
}
