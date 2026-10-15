package com.vivo.push;

/* JADX INFO: compiled from: BasePushClient.java */
/* JADX INFO: loaded from: classes.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushActionListener f16549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f16550b;

    public c(a aVar, IPushActionListener iPushActionListener) {
        this.f16550b = aVar;
        this.f16549a = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int iA = com.vivo.push.restructure.a.a().h().a();
        IPushActionListener iPushActionListener = this.f16549a;
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(iA);
        }
    }
}
