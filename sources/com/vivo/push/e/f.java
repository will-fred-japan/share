package com.vivo.push.e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.w;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f16589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f16590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f16591c;

    public f(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f16591c = dVar;
        this.f16589a = str;
        this.f16590b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w.e("delete profileId");
        d.a(this.f16591c, this.f16589a, this.f16590b, 2);
    }
}
