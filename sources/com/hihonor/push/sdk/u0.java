package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class u0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f14558a = new d1();

    public void a(Exception exc) {
        d1 d1Var = this.f14558a;
        synchronized (d1Var.f14474a) {
            try {
                if (!d1Var.f14475b) {
                    d1Var.f14475b = true;
                    d1Var.f14477d = exc;
                    d1Var.f14474a.notifyAll();
                    d1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(TResult tresult) {
        d1 d1Var = this.f14558a;
        synchronized (d1Var.f14474a) {
            try {
                if (!d1Var.f14475b) {
                    d1Var.f14475b = true;
                    d1Var.f14476c = tresult;
                    d1Var.f14474a.notifyAll();
                    d1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
