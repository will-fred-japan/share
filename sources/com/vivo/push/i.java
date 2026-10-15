package com.vivo.push;

/* JADX INFO: compiled from: CommonRelyManger.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile i f16667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.vivo.push.util.p f16668b;

    private i() {
    }

    public static synchronized i a() {
        try {
            if (f16667a == null) {
                f16667a = new i();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f16667a;
    }

    public final com.vivo.push.util.p b() {
        return this.f16668b;
    }

    public final void a(com.vivo.push.c.a aVar) {
        this.f16668b = aVar;
    }
}
