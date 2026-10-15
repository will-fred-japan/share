package com.vivo.push.b;

/* JADX INFO: compiled from: OnNotifyGuideDialogResultCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class s extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f16536a = "notify_guide_dialog_result";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16537b;

    public s() {
        super(2023);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(f16536a, this.f16537b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f16537b = dVar.b(f16536a, -1);
    }

    public final int e() {
        return this.f16537b;
    }
}
