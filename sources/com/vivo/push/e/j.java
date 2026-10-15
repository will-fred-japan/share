package com.vivo.push.e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.w;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class j implements com.vivo.push.restructure.request.c<com.vivo.push.e.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f16597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f16598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f16599c;

    public j(d dVar, IPushRequestCallback iPushRequestCallback, int i9) {
        this.f16599c = dVar;
        this.f16597a = iPushRequestCallback;
        this.f16598b = i9;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b bVar) {
        if (this.f16597a != null) {
            w.e(this.f16598b + " sync success");
            this.f16597a.onSuccess(0);
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i9) {
        if (this.f16597a != null) {
            w.e(this.f16598b + " sync err : " + i9);
            this.f16597a.onError(i9);
        }
    }
}
