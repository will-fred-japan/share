package com.vivo.push.h;

/* JADX INFO: compiled from: OnPublishReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class af implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.t f16618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ae f16619b;

    public af(ae aeVar, com.vivo.push.b.t tVar) {
        this.f16619b = aeVar;
        this.f16618a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ae aeVar = this.f16619b;
        ((ag) aeVar).f16620b.onPublish(((com.vivo.push.t) aeVar).f16804a, this.f16618a.j(), this.f16618a.i());
    }
}
