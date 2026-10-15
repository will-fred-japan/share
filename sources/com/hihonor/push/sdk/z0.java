package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public final class z0<TResult> implements r0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t0<TResult> f14573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14574b = new Object();

    public z0(t0<TResult> t0Var) {
        this.f14573a = t0Var;
    }

    @Override // com.hihonor.push.sdk.r0
    public final void a(d1 d1Var) {
        synchronized (this.f14574b) {
            try {
                t0<TResult> t0Var = this.f14573a;
                if (t0Var != null) {
                    t0Var.a(d1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
