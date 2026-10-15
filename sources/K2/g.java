package K2;

/* JADX INFO: compiled from: NormalProcessDetectState.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a {
    @Override // J2.a
    public final int e() {
        return 1;
    }

    @Override // K2.a
    public final boolean f(boolean z8) {
        if (!z8) {
            return z8;
        }
        J2.b.a.f2666a.getClass();
        J2.c cVar = this.f2663a;
        synchronized (cVar) {
            cVar.a(cVar.f2675i);
        }
        return z8;
    }

    @Override // K2.a
    public final long g() {
        return this.f2803d ? 600000L : 30000L;
    }

    @Override // K2.a
    public final boolean h() {
        return false;
    }
}
