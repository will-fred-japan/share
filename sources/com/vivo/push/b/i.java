package com.vivo.push.b;

/* JADX INFO: compiled from: OnAppReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16508d;

    public i(int i9) {
        super(i9);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("app_id", this.f16505a);
        dVar.a("client_id", this.f16506b);
        dVar.a("client_token", this.f16507c);
        dVar.a("client_token_validity_period", this.f16508d);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16505a = dVar.a("app_id");
        this.f16506b = dVar.a("client_id");
        this.f16507c = dVar.a("client_token");
        this.f16508d = dVar.a("client_token_validity_period");
    }

    public final String e() {
        return this.f16505a;
    }

    public final String f() {
        return this.f16507c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final String toString() {
        return "OnBindCommand";
    }
}
