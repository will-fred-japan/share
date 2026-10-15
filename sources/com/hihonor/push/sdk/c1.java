package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class c1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f14467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f14468b;

    public c1(u0 u0Var, Callable callable) {
        this.f14467a = u0Var;
        this.f14468b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f14467a.a(this.f14468b.call());
        } catch (Exception e9) {
            this.f14467a.a(e9);
        }
    }
}
