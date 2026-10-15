package com.vivo.push.b;

/* JADX INFO: compiled from: OnDispatcherReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16512b;

    public l() {
        super(2016);
        this.f16511a = -1;
        this.f16512b = -1;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("key_dispatch_environment", this.f16511a);
        dVar.a("key_dispatch_area", this.f16512b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16511a = dVar.b("key_dispatch_environment", 1);
        this.f16512b = dVar.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.f16511a;
    }

    public final int f() {
        return this.f16512b;
    }
}
