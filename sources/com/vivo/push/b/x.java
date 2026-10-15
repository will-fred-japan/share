package com.vivo.push.b;

import com.engagelab.privates.push.constants.MTPushConstants;

/* JADX INFO: compiled from: OnVerifyReceiveCommand.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class x extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16545b;

    public x(int i9) {
        super(i9);
    }

    public final void c(long j) {
        this.f16545b = j;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16544a = dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f16545b = dVar.b(MTPushConstants.Notification.KEY_NOTIFY_ID, -1L);
    }

    public final long k() {
        return this.f16545b;
    }

    public final String l() {
        return this.f16544a;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f16544a);
        dVar.a(MTPushConstants.Notification.KEY_NOTIFY_ID, this.f16545b);
    }
}
