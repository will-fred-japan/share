package com.hihonor.push.sdk;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class b1 implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f14457a = new CountDownLatch(1);

    @Override // com.hihonor.push.sdk.t0
    public final void a(d1 d1Var) {
        this.f14457a.countDown();
    }
}
