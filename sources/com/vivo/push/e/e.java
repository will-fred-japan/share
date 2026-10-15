package com.vivo.push.e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.w;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f16586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f16587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f16588c;

    public e(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f16588c = dVar;
        this.f16586a = str;
        this.f16587b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w.e("add profileId");
        d.a(this.f16588c, this.f16586a, this.f16587b, 1);
    }
}
