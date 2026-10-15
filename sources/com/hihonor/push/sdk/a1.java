package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class a1<TResult> implements r0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f14451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t0<TResult> f14452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14453c = new Object();

    public a1(Executor executor, t0<TResult> t0Var) {
        this.f14452b = t0Var;
        this.f14451a = executor;
    }

    @Override // com.hihonor.push.sdk.r0
    public final void a(d1 d1Var) {
        this.f14451a.execute(new y0(this, d1Var));
    }
}
