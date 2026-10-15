package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class b<TResult> implements ExecuteResult<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnCanceledListener f14653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f14654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14655c = new Object();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this.f14655c) {
                try {
                    OnCanceledListener onCanceledListener = b.this.f14653a;
                    if (onCanceledListener != null) {
                        onCanceledListener.onCanceled();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public b(Executor executor, OnCanceledListener onCanceledListener) {
        this.f14653a = onCanceledListener;
        this.f14654b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        synchronized (this.f14655c) {
            this.f14653a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (((i) task).f14685c) {
            this.f14654b.execute(new a());
        }
    }
}
