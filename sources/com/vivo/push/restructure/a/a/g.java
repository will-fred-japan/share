package com.vivo.push.restructure.a.a;

import android.os.SystemClock;

/* JADX INFO: compiled from: IPCNode.java */
/* JADX INFO: loaded from: classes.dex */
final class g extends a<com.vivo.push.restructure.a.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16745b;

    public g(com.vivo.push.restructure.a.a aVar, j jVar) {
        super("IPCNode", aVar, jVar);
        this.f16745b = 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jD = aVar.d();
        if (jD <= 0 || jElapsedRealtime <= jD) {
            return;
        }
        this.f16745b = jElapsedRealtime - jD;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return 0;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final synchronized String b() {
        a(this.f16745b);
        return super.b();
    }
}
