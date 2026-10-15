package com.vivo.push.h;

/* JADX INFO: compiled from: OnUnBindAppReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class al implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f16632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ak f16633b;

    public al(ak akVar, com.vivo.push.b.i iVar) {
        this.f16633b = akVar;
        this.f16632a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ak akVar = this.f16633b;
        ((ag) akVar).f16620b.onUnBind(((com.vivo.push.t) akVar).f16804a, this.f16632a.j(), this.f16632a.e());
    }
}
