package com.vivo.push.b;

/* JADX INFO: compiled from: OnLogReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class o extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16522c;

    public o() {
        super(7);
        this.f16521b = 0;
        this.f16522c = false;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.f16520a);
        dVar.a("log_level", this.f16521b);
        dVar.a("is_server_log", this.f16522c);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16520a = dVar.a("content");
        this.f16521b = dVar.b("log_level", 0);
        this.f16522c = dVar.e("is_server_log");
    }

    public final String e() {
        return this.f16520a;
    }

    public final int f() {
        return this.f16521b;
    }

    public final boolean g() {
        return this.f16522c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final String toString() {
        return "OnLogCommand";
    }
}
