package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callable f14464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f14465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f0 f14466c;

    public c0(f0 f0Var, Callable callable, HonorPushCallback honorPushCallback) {
        this.f14466c = f0Var;
        this.f14464a = callable;
        this.f14465b = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        j e9;
        f0 f0Var;
        HonorPushCallback honorPushCallback;
        int i9;
        try {
            Object objCall = this.f14464a.call();
            f0 f0Var2 = this.f14466c;
            f0Var2.f14487b.execute(new d0(f0Var2, this.f14465b, objCall));
        } catch (j e10) {
            e9 = e10;
            f0Var = this.f14466c;
            honorPushCallback = this.f14465b;
            i9 = e9.f14502a;
            f0.a(f0Var, honorPushCallback, i9, e9.f14503b);
        } catch (Exception e11) {
            if (!(e11.getCause() instanceof j)) {
                f0 f0Var3 = this.f14466c;
                HonorPushCallback honorPushCallback2 = this.f14465b;
                k kVar = k.SUCCESS;
                f0.a(f0Var3, honorPushCallback2, 8003003, e11.getMessage());
                return;
            }
            e9 = (j) e11.getCause();
            f0Var = this.f14466c;
            honorPushCallback = this.f14465b;
            i9 = e9.f14502a;
            f0.a(f0Var, honorPushCallback, i9, e9.f14503b);
        }
    }
}
