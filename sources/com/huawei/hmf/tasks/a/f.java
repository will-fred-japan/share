package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class f<TResult> implements ExecuteResult<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnFailureListener f14671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f14672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14673c = new Object();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f14674a;

        public a(Task task) {
            this.f14674a = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.f14673c) {
                try {
                    OnFailureListener onFailureListener = f.this.f14671a;
                    if (onFailureListener != null) {
                        onFailureListener.onFailure(this.f14674a.getException());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public f(Executor executor, OnFailureListener onFailureListener) {
        this.f14671a = onFailureListener;
        this.f14672b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        synchronized (this.f14673c) {
            this.f14671a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isSuccessful() || ((i) task).f14685c) {
            return;
        }
        this.f14672b.execute(new a(task));
    }
}
