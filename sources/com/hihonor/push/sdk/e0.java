package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f14479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f14481c;

    public e0(f0 f0Var, HonorPushCallback honorPushCallback, int i9, String str) {
        this.f14479a = honorPushCallback;
        this.f14480b = i9;
        this.f14481c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f14479a;
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(this.f14480b, this.f14481c);
        }
    }
}
