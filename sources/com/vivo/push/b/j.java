package com.vivo.push.b;

/* JADX INFO: compiled from: OnChangePushStatusReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16510b;

    public j() {
        super(12);
        this.f16509a = -1;
        this.f16510b = -1;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f16509a);
        dVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f16510b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16509a = dVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f16509a);
        this.f16510b = dVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f16510b);
    }

    public final int e() {
        return this.f16509a;
    }

    public final int f() {
        return this.f16510b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final String toString() {
        return "OnChangePushStatusCommand";
    }
}
