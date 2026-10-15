package com.vivo.push.h;

/* JADX INFO: compiled from: OnListTagReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.n f16663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ u f16664b;

    public v(u uVar, com.vivo.push.b.n nVar) {
        this.f16664b = uVar;
        this.f16663a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u uVar = this.f16664b;
        ((ag) uVar).f16620b.onListTags(((com.vivo.push.t) uVar).f16804a, this.f16663a.j(), this.f16663a.e(), this.f16663a.i());
    }
}
