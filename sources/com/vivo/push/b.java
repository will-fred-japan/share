package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;

/* JADX INFO: compiled from: BasePushClient.java */
/* JADX INFO: loaded from: classes.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushQueryActionListener f16486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f16487b;

    public b(a aVar, IPushQueryActionListener iPushQueryActionListener) {
        this.f16487b = aVar;
        this.f16486a = iPushQueryActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strB = com.vivo.push.restructure.a.a().h().b();
        IPushQueryActionListener iPushQueryActionListener = this.f16486a;
        if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onSuccess(strB);
        }
    }
}
