package com.vivo.push.h;

/* JADX INFO: compiled from: OnLogReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.o f16665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ w f16666b;

    public x(w wVar, com.vivo.push.b.o oVar) {
        this.f16666b = wVar;
        this.f16665a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w wVar = this.f16666b;
        ((ag) wVar).f16620b.onLog(((com.vivo.push.t) wVar).f16804a, this.f16665a.e(), this.f16665a.f(), this.f16665a.g());
    }
}
