package com.vivo.push.b;

/* JADX INFO: compiled from: DefaultCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends com.vivo.push.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16502a;

    public f() {
        super(0);
    }

    public final void a(int i9) {
        this.f16502a = i9;
    }

    @Override // com.vivo.push.w
    public final void c(com.vivo.push.d dVar) {
        if (dVar != null) {
            dVar.a("APP_CLIENT_SWITCH_FLAG", this.f16502a);
        }
    }

    @Override // com.vivo.push.w
    public final void d(com.vivo.push.d dVar) {
        if (dVar != null) {
            this.f16502a = dVar.b("APP_CLIENT_SWITCH_FLAG", 0);
        }
    }

    @Override // com.vivo.push.w
    public final String toString() {
        return "DefaultCommand";
    }
}
