package com.vivo.push.restructure.request;

import com.engagelab.privates.common.constants.MTCommonConstants;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f16796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f16797b;

    public f(e eVar, b bVar) {
        this.f16797b = eVar;
        this.f16796a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f16796a;
        if (bVar == null || bVar.b() == null) {
            return;
        }
        this.f16796a.b().a(MTCommonConstants.MainWhat.ON_NETWORK_CONNECTED);
    }
}
