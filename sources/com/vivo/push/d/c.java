package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.IPushActionListener;
import com.vivo.push.util.y;

/* JADX INFO: compiled from: NotifyGuideDialogManager.java */
/* JADX INFO: loaded from: classes.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f16558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushActionListener f16559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ b f16560c;

    public c(b bVar, Context context, IPushActionListener iPushActionListener) {
        this.f16560c = bVar;
        this.f16558a = context;
        this.f16559b = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int iA = b.a(this.f16558a);
        if (iA != 0) {
            this.f16559b.onStateChanged(iA);
            return;
        }
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new a(new g(y.a(), b.b(this.f16558a))), new d(this), 3000L));
    }
}
