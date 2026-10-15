package com.vivo.push.b;

/* JADX INFO: compiled from: OnReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends com.vivo.push.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16539b;

    public u(int i9) {
        super(i9);
        this.f16538a = null;
        this.f16539b = 0;
    }

    @Override // com.vivo.push.w
    public void c(com.vivo.push.d dVar) {
        dVar.a("req_id", this.f16538a);
        dVar.a("status_msg_code", this.f16539b);
    }

    @Override // com.vivo.push.w
    public void d(com.vivo.push.d dVar) {
        this.f16538a = dVar.a("req_id");
        this.f16539b = dVar.b("status_msg_code", this.f16539b);
    }

    public final String i() {
        return this.f16538a;
    }

    public final int j() {
        return this.f16539b;
    }

    @Override // com.vivo.push.w
    public String toString() {
        return "OnReceiveCommand";
    }
}
