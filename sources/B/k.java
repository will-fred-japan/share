package B;

import java.util.Iterator;

/* JADX INFO: compiled from: HelperReferences.java */
/* JADX INFO: loaded from: classes.dex */
public final class k extends p {
    @Override // B.p, B.d
    public final void a(d dVar) {
        A.b bVar = (A.b) this.f1587b;
        int i9 = bVar.f1185n0;
        f fVar = this.f1593h;
        Iterator it = fVar.f1563l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i12 = ((f) it.next()).f1559g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (i9 == 0 || i9 == 2) {
            fVar.d(i11 + bVar.f1187p0);
        } else {
            fVar.d(i10 + bVar.f1187p0);
        }
    }

    @Override // B.p
    public final void d() {
        A.g gVar = this.f1587b;
        if (gVar instanceof A.b) {
            f fVar = this.f1593h;
            fVar.f1554b = true;
            A.b bVar = (A.b) gVar;
            int i9 = bVar.f1185n0;
            boolean z8 = bVar.f1186o0;
            int i10 = 0;
            if (i9 == 0) {
                fVar.f1557e = f.a.f1567d;
                while (i10 < bVar.f1353m0) {
                    A.g gVar2 = bVar.f1352l0[i10];
                    if (z8 || gVar2.f1253c0 != 8) {
                        f fVar2 = gVar2.f1254d.f1593h;
                        fVar2.f1562k.add(fVar);
                        fVar.f1563l.add(fVar2);
                    }
                    i10++;
                }
                m(this.f1587b.f1254d.f1593h);
                m(this.f1587b.f1254d.f1594i);
                return;
            }
            if (i9 == 1) {
                fVar.f1557e = f.a.f1568e;
                while (i10 < bVar.f1353m0) {
                    A.g gVar3 = bVar.f1352l0[i10];
                    if (z8 || gVar3.f1253c0 != 8) {
                        f fVar3 = gVar3.f1254d.f1594i;
                        fVar3.f1562k.add(fVar);
                        fVar.f1563l.add(fVar3);
                    }
                    i10++;
                }
                m(this.f1587b.f1254d.f1593h);
                m(this.f1587b.f1254d.f1594i);
                return;
            }
            if (i9 == 2) {
                fVar.f1557e = f.a.f1569f;
                while (i10 < bVar.f1353m0) {
                    A.g gVar4 = bVar.f1352l0[i10];
                    if (z8 || gVar4.f1253c0 != 8) {
                        f fVar4 = gVar4.f1256e.f1593h;
                        fVar4.f1562k.add(fVar);
                        fVar.f1563l.add(fVar4);
                    }
                    i10++;
                }
                m(this.f1587b.f1256e.f1593h);
                m(this.f1587b.f1256e.f1594i);
                return;
            }
            if (i9 != 3) {
                return;
            }
            fVar.f1557e = f.a.f1570g;
            while (i10 < bVar.f1353m0) {
                A.g gVar5 = bVar.f1352l0[i10];
                if (z8 || gVar5.f1253c0 != 8) {
                    f fVar5 = gVar5.f1256e.f1594i;
                    fVar5.f1562k.add(fVar);
                    fVar.f1563l.add(fVar5);
                }
                i10++;
            }
            m(this.f1587b.f1256e.f1593h);
            m(this.f1587b.f1256e.f1594i);
        }
    }

    @Override // B.p
    public final void e() {
        A.g gVar = this.f1587b;
        if (gVar instanceof A.b) {
            int i9 = ((A.b) gVar).f1185n0;
            f fVar = this.f1593h;
            if (i9 == 0 || i9 == 1) {
                gVar.f1243U = fVar.f1559g;
            } else {
                gVar.f1244V = fVar.f1559g;
            }
        }
    }

    @Override // B.p
    public final void f() {
        this.f1588c = null;
        this.f1593h.c();
    }

    @Override // B.p
    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.f1593h;
        fVar2.f1562k.add(fVar);
        fVar.f1563l.add(fVar2);
    }
}
