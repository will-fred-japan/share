package com.vivo.push.b;

/* JADX INFO: compiled from: OnUndoMsgReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class w extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f16542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16543b;

    public w() {
        super(20);
        this.f16542a = -1L;
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("undo_msg_v1", this.f16542a);
        dVar.a("undo_msg_type_v1", this.f16543b);
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16542a = dVar.b("undo_msg_v1", this.f16542a);
        this.f16543b = dVar.b("undo_msg_type_v1", 0);
    }

    public final long e() {
        return this.f16542a;
    }

    public final String f() {
        long j = this.f16542a;
        if (j != -1) {
            return String.valueOf(j);
        }
        return null;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final String toString() {
        return "OnUndoMsgCommand";
    }
}
