package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.IPushActionListener;
import com.vivo.push.util.y;

/* JADX INFO: compiled from: NotifyGuideDialogManager.java */
/* JADX INFO: loaded from: classes.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f16562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushActionListener f16563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f16564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f16565d;

    public e(b bVar, Context context, IPushActionListener iPushActionListener, long j) {
        this.f16565d = bVar;
        this.f16562a = context;
        this.f16563b = iPushActionListener;
        this.f16564c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int iA = b.a(this.f16562a);
        if (iA != 0) {
            this.f16563b.onStateChanged(iA);
            return;
        }
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new a(new g(this.f16564c, y.a(), b.b(this.f16562a))), new f(this), 3000L));
    }
}
