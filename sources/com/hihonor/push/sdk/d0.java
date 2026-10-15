package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f14472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14473b;

    public d0(f0 f0Var, HonorPushCallback honorPushCallback, Object obj) {
        this.f14472a = honorPushCallback;
        this.f14473b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f14472a;
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(this.f14473b);
        }
    }
}
