package com.vivo.push.e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.w;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f16592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f16593b;

    public g(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.f16593b = dVar;
        this.f16592a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w.e("delete all profileIds");
        d.a(this.f16593b, "", this.f16592a, 3);
    }
}
