package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class e<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14665a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<Void> f14667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Exception f14669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14670f;

    public e(int i9, i<Void> iVar) {
        this.f14666b = i9;
        this.f14667c = iVar;
    }

    public final void a() {
        if (this.f14668d >= this.f14666b) {
            if (this.f14669e != null) {
                this.f14667c.a(new ExecutionException("a task failed", this.f14669e));
            } else if (this.f14670f) {
                this.f14667c.a();
            } else {
                this.f14667c.a((Void) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public void onCanceled() {
        synchronized (this.f14665a) {
            this.f14668d++;
            this.f14670f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        synchronized (this.f14665a) {
            this.f14668d++;
            this.f14669e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public void onSuccess(TResult tresult) {
        synchronized (this.f14665a) {
            this.f14668d++;
            a();
        }
    }
}
