package com.vivo.push;

/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes.dex */
final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f16716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f16717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f16718c;

    public p(n nVar, com.vivo.push.b.b bVar, String str) {
        this.f16718c = nVar;
        this.f16716a = bVar;
        this.f16717b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16718c.a(this.f16716a);
        this.f16718c.c(this.f16717b);
    }
}
