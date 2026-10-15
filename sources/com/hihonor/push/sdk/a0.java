package com.hihonor.push.sdk;

import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a0 f14448c = new a0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f14449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f14450b;

    public a0() {
        e1.b();
        e1.a();
        Executor executorB = e1.b();
        Executor executorA = e1.a();
        f0 f0Var = new f0();
        f0Var.f14486a = executorB;
        f0Var.f14487b = executorA;
        this.f14449a = f0Var;
    }

    public static Object a(a0 a0Var, d1 d1Var) throws TimeoutException {
        boolean z8;
        a0Var.getClass();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("await must not be called on the UI thread");
        }
        synchronized (d1Var.f14474a) {
            z8 = d1Var.f14475b;
        }
        if (!z8) {
            b1 b1Var = new b1();
            d1Var.a(new z0(b1Var));
            if (!b1Var.f14457a.await(10000L, timeUnit)) {
                throw new TimeoutException("Timed out waiting for Task");
            }
        }
        return h.b(d1Var);
    }

    public boolean a(Context context) {
        if (context != null) {
            a aVarB = h.b(context);
            k kVar = k.SUCCESS;
            return h.a(context, aVarB) == 0;
        }
        throw new NullPointerException("context must not be null.");
    }

    public Context a() {
        b0 b0Var;
        synchronized (f14448c) {
            b0Var = this.f14450b;
            if (b0Var == null) {
                m.a("verifySdkInitialized sdk not initialized");
                throw new RuntimeException(k.ERROR_NOT_INITIALIZED.a());
            }
        }
        return b0Var.f14455a;
    }
}
