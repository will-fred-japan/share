package com.hihonor.push.sdk;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class w implements Callable<List<HonorPushDataMsg>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f14563a;

    public w(a0 a0Var) {
        this.f14563a = a0Var;
    }

    @Override // java.util.concurrent.Callable
    public List<HonorPushDataMsg> call() {
        a0 a0Var = this.f14563a;
        w0 w0Var = new w0(a0Var.a());
        d1 d1Var = new d1();
        try {
            List<HonorPushDataMsg> listCall = w0Var.call();
            synchronized (d1Var.f14474a) {
                try {
                    if (!d1Var.f14475b) {
                        d1Var.f14475b = true;
                        d1Var.f14476c = listCall;
                        d1Var.f14474a.notifyAll();
                        d1Var.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e9) {
            try {
                synchronized (d1Var.f14474a) {
                    try {
                        if (!d1Var.f14475b) {
                            d1Var.f14475b = true;
                            d1Var.f14477d = e9;
                            d1Var.f14474a.notifyAll();
                            d1Var.a();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Exception e10) {
                synchronized (d1Var.f14474a) {
                    try {
                        if (!d1Var.f14475b) {
                            d1Var.f14475b = true;
                            d1Var.f14477d = e10;
                            d1Var.f14474a.notifyAll();
                            d1Var.a();
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }
        return (List) a0.a(a0Var, d1Var);
    }
}
