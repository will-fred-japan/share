package com.vivo.push;

/* JADX INFO: renamed from: com.vivo.push.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0592r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f16720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f16721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f16722c;

    public RunnableC0592r(n nVar, com.vivo.push.b.b bVar, String str) {
        this.f16722c = nVar;
        this.f16720a = bVar;
        this.f16721b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16722c.a(this.f16720a);
        this.f16722c.c(this.f16721b);
    }
}
