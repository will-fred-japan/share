package com.vivo.push.b;

/* JADX INFO: compiled from: PushModeCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class y extends com.vivo.push.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16546a;

    public y() {
        super(2011);
        this.f16546a = 0;
    }

    @Override // com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        dVar.a("com.bbk.push.ikey.MODE_TYPE", this.f16546a);
    }

    @Override // com.vivo.push.w
    public final boolean d() {
        return true;
    }

    public final int e() {
        return this.f16546a;
    }

    @Override // com.vivo.push.w
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        this.f16546a = dVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
