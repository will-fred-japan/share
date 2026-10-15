package com.hihonor.push.sdk;

import android.util.Log;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class q implements HonorPushCallback<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean[] f14550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f14551b;

    public q(a0 a0Var, boolean[] zArr, CountDownLatch countDownLatch) {
        this.f14550a = zArr;
        this.f14551b = countDownLatch;
    }

    @Override // com.hihonor.push.sdk.HonorPushCallback
    public void onFailure(int i9, String str) {
        Log.w("PUSHSupport", "isPushSupport onFailure() code :" + i9 + ", msg=" + str);
        this.f14550a[0] = false;
        this.f14551b.countDown();
    }

    @Override // com.hihonor.push.sdk.HonorPushCallback
    public void onSuccess(Boolean bool) {
        this.f14550a[0] = bool.booleanValue();
        this.f14551b.countDown();
    }
}
