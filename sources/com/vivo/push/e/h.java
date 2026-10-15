package com.vivo.push.e;

import android.content.Context;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.w;
import java.util.ArrayList;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f16594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f16595b;

    public h(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.f16595b = dVar;
        this.f16594a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w.e("query all profileIds");
        if (com.vivo.push.restructure.a.a().g().b() != 0) {
            w.e("core not support sync profileInfo");
            IPushRequestCallback iPushRequestCallback = this.f16594a;
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context contextB = com.vivo.push.restructure.a.a().b();
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new com.vivo.push.e.a.a(new com.vivo.push.e.a.b(contextB.getPackageName(), new ArrayList(), 4)), new i(this), 20000L));
    }
}
