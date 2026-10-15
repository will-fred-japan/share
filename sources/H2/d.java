package H2;

import android.os.Process;

/* JADX INFO: compiled from: CpuCollectManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements V2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f2377a;

    public d(e eVar) {
        this.f2377a = eVar;
    }

    @Override // V2.c
    public final void b() {
        this.f2377a.f2381d.edit().putString(N2.a.u1(), Process.myPid() + ",false").apply();
    }

    @Override // V2.c
    public final void c() {
        this.f2377a.f2381d.edit().putString(N2.a.u1(), Process.myPid() + ",true").apply();
    }
}
