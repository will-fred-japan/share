package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class y0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f14569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a1 f14570b;

    public y0(a1 a1Var, d1 d1Var) {
        this.f14570b = a1Var;
        this.f14569a = d1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f14570b.f14453c) {
            try {
                t0<TResult> t0Var = this.f14570b.f14452b;
                if (t0Var != 0) {
                    t0Var.a(this.f14569a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
