package A;

import java.util.ArrayList;

/* JADX INFO: compiled from: Guideline.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends g {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f1346l0 = -1.0f;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f1347m0 = -1;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f1348n0 = -1;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public e f1349o0 = this.f1228E;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f1350p0 = 0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f1351q0;

    public j() {
        this.f1236M.clear();
        this.f1236M.add(this.f1349o0);
        int length = this.f1235L.length;
        for (int i9 = 0; i9 < length; i9++) {
            this.f1235L[i9] = this.f1349o0;
        }
    }

    @Override // A.g
    public final void J(p197z.c cVar, boolean z8) {
        if (this.f1238P == null) {
            return;
        }
        e eVar = this.f1349o0;
        cVar.getClass();
        int iN = p197z.c.n(eVar);
        if (this.f1350p0 == 1) {
            this.f1243U = iN;
            this.f1244V = 0;
            E(this.f1238P.k());
            H(0);
            return;
        }
        this.f1243U = 0;
        this.f1244V = iN;
        H(this.f1238P.n());
        E(0);
    }

    public final void K(int i9) {
        this.f1349o0.l(i9);
        this.f1351q0 = true;
    }

    public final void L(int i9) {
        if (this.f1350p0 == i9) {
            return;
        }
        this.f1350p0 = i9;
        ArrayList<e> arrayList = this.f1236M;
        arrayList.clear();
        if (this.f1350p0 == 1) {
            this.f1349o0 = this.f1227D;
        } else {
            this.f1349o0 = this.f1228E;
        }
        arrayList.add(this.f1349o0);
        e[] eVarArr = this.f1235L;
        int length = eVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            eVarArr[i10] = this.f1349o0;
        }
    }

    @Override // A.g
    public final void b(p197z.c cVar, boolean z8) {
        h hVar = (h) this.f1238P;
        if (hVar == null) {
            return;
        }
        Object objI = hVar.i(e.a.f1214a);
        Object objI2 = hVar.i(e.a.f1216c);
        g gVar = this.f1238P;
        g.a aVar = g.a.f1284b;
        boolean z9 = gVar != null && gVar.O[0] == aVar;
        if (this.f1350p0 == 0) {
            objI = hVar.i(e.a.f1215b);
            objI2 = hVar.i(e.a.f1217d);
            g gVar2 = this.f1238P;
            z9 = gVar2 != null && gVar2.O[1] == aVar;
        }
        if (this.f1351q0) {
            e eVar = this.f1349o0;
            if (eVar.f1207c) {
                p197z.e eVarK = cVar.k(eVar);
                cVar.d(eVarK, this.f1349o0.d());
                if (this.f1347m0 != -1) {
                    if (z9) {
                        cVar.f(cVar.k(objI2), eVarK, 0, 5);
                    }
                } else if (this.f1348n0 != -1 && z9) {
                    p197z.e eVarK2 = cVar.k(objI2);
                    cVar.f(eVarK, cVar.k(objI), 0, 5);
                    cVar.f(eVarK2, eVarK, 0, 5);
                }
                this.f1351q0 = false;
                return;
            }
        }
        if (this.f1347m0 != -1) {
            p197z.e eVarK3 = cVar.k(this.f1349o0);
            cVar.e(eVarK3, cVar.k(objI), this.f1347m0, 8);
            if (z9) {
                cVar.f(cVar.k(objI2), eVarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.f1348n0 != -1) {
            p197z.e eVarK4 = cVar.k(this.f1349o0);
            p197z.e eVarK5 = cVar.k(objI2);
            cVar.e(eVarK4, eVarK5, -this.f1348n0, 8);
            if (z9) {
                cVar.f(eVarK4, cVar.k(objI), 0, 5);
                cVar.f(eVarK5, eVarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.f1346l0 != -1.0f) {
            p197z.e eVarK6 = cVar.k(this.f1349o0);
            p197z.e eVarK7 = cVar.k(objI2);
            float f6 = this.f1346l0;
            p197z.b bVarL = cVar.l();
            bVarL.f22423d.b(eVarK6, -1.0f);
            bVarL.f22423d.b(eVarK7, f6);
            cVar.c(bVarL);
        }
    }

    @Override // A.g
    public final boolean c() {
        return true;
    }

    @Override // A.g
    public final e i(e.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.f1350p0 == 1) {
                    return this.f1349o0;
                }
                break;
            case 2:
            case 4:
                if (this.f1350p0 == 0) {
                    return this.f1349o0;
                }
                break;
        }
        throw new AssertionError(aVar.name());
    }

    @Override // A.g
    public final boolean w() {
        return this.f1351q0;
    }

    @Override // A.g
    public final boolean x() {
        return this.f1351q0;
    }
}
