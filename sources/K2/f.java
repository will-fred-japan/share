package K2;

/* JADX INFO: compiled from: NormalIdleState.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends J2.a {
    @Override // J2.a
    public final void b(I2.c cVar, boolean z8) {
        super.b(cVar, z8);
        J2.c cVar2 = this.f2663a;
        synchronized (cVar2) {
            cVar2.a(cVar2.f2674h);
        }
    }

    @Override // J2.a
    public final void d(boolean z8) {
        super.d(z8);
        c("life cycle change when state is idle, lifecycle change to back?: " + z8);
        J2.c cVar = this.f2663a;
        synchronized (cVar) {
            cVar.a(cVar.f2674h);
        }
    }

    @Override // J2.a
    public final int e() {
        return 5;
    }
}
