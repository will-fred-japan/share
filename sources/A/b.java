package A;

/* JADX INFO: compiled from: Barrier.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends k {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f1185n0 = 0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f1186o0 = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f1187p0 = 0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f1188q0 = false;

    public final boolean M() {
        int i9;
        int i10;
        int i11;
        boolean z8 = true;
        int i12 = 0;
        while (true) {
            i9 = this.f1353m0;
            if (i12 >= i9) {
                break;
            }
            g gVar = this.f1352l0[i12];
            if ((this.f1186o0 || gVar.c()) && ((((i10 = this.f1185n0) == 0 || i10 == 1) && !gVar.w()) || (((i11 = this.f1185n0) == 2 || i11 == 3) && !gVar.x()))) {
                z8 = false;
            }
            i12++;
        }
        if (!z8 || i9 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z9 = false;
        for (int i13 = 0; i13 < this.f1353m0; i13++) {
            g gVar2 = this.f1352l0[i13];
            if (this.f1186o0 || gVar2.c()) {
                e.a aVar = e.a.f1217d;
                e.a aVar2 = e.a.f1215b;
                e.a aVar3 = e.a.f1216c;
                e.a aVar4 = e.a.f1214a;
                if (!z9) {
                    int i14 = this.f1185n0;
                    if (i14 == 0) {
                        iMax = gVar2.i(aVar4).d();
                    } else if (i14 == 1) {
                        iMax = gVar2.i(aVar3).d();
                    } else if (i14 == 2) {
                        iMax = gVar2.i(aVar2).d();
                    } else if (i14 == 3) {
                        iMax = gVar2.i(aVar).d();
                    }
                    z9 = true;
                }
                int i15 = this.f1185n0;
                if (i15 == 0) {
                    iMax = Math.min(iMax, gVar2.i(aVar4).d());
                } else if (i15 == 1) {
                    iMax = Math.max(iMax, gVar2.i(aVar3).d());
                } else if (i15 == 2) {
                    iMax = Math.min(iMax, gVar2.i(aVar2).d());
                } else if (i15 == 3) {
                    iMax = Math.max(iMax, gVar2.i(aVar).d());
                }
            }
        }
        int i16 = iMax + this.f1187p0;
        int i17 = this.f1185n0;
        if (i17 == 0 || i17 == 1) {
            C(i16, i16);
        } else {
            D(i16, i16);
        }
        this.f1188q0 = true;
        return true;
    }

    public final int N() {
        int i9 = this.f1185n0;
        if (i9 == 0 || i9 == 1) {
            return 0;
        }
        return (i9 == 2 || i9 == 3) ? 1 : -1;
    }

    @Override // A.g
    public final void b(p197z.c cVar, boolean z8) {
        boolean z9;
        int i9;
        e[] eVarArr = this.f1235L;
        e eVar = this.f1227D;
        eVarArr[0] = eVar;
        e eVar2 = this.f1228E;
        int i10 = 2;
        eVarArr[2] = eVar2;
        e eVar3 = this.f1229F;
        eVarArr[1] = eVar3;
        e eVar4 = this.f1230G;
        eVarArr[3] = eVar4;
        for (e eVar5 : eVarArr) {
            eVar5.f1213i = cVar.k(eVar5);
        }
        int i11 = this.f1185n0;
        if (i11 < 0 || i11 >= 4) {
            return;
        }
        e eVar6 = eVarArr[i11];
        if (!this.f1188q0) {
            M();
        }
        if (this.f1188q0) {
            this.f1188q0 = false;
            int i12 = this.f1185n0;
            if (i12 == 0 || i12 == 1) {
                cVar.d(eVar.f1213i, this.f1243U);
                cVar.d(eVar3.f1213i, this.f1243U);
                return;
            } else {
                if (i12 == 2 || i12 == 3) {
                    cVar.d(eVar2.f1213i, this.f1244V);
                    cVar.d(eVar4.f1213i, this.f1244V);
                    return;
                }
                return;
            }
        }
        int i13 = 0;
        while (true) {
            if (i13 >= this.f1353m0) {
                z9 = false;
                break;
            }
            g gVar = this.f1352l0[i13];
            if (this.f1186o0 || gVar.c()) {
                int i14 = this.f1185n0;
                g.a aVar = g.a.f1285c;
                if (((i14 == 0 || i14 == 1) && gVar.O[0] == aVar && gVar.f1227D.f1210f != null && gVar.f1229F.f1210f != null) || ((i14 == 2 || i14 == 3) && gVar.O[1] == aVar && gVar.f1228E.f1210f != null && gVar.f1230G.f1210f != null)) {
                    z9 = true;
                    break;
                }
            }
            i13++;
        }
        boolean z10 = eVar.g() || eVar3.g();
        boolean z11 = eVar2.g() || eVar4.g();
        int i15 = (z9 || !(((i9 = this.f1185n0) == 0 && z10) || ((i9 == 2 && z11) || ((i9 == 1 && z10) || (i9 == 3 && z11))))) ? 4 : 5;
        int i16 = 0;
        while (i16 < this.f1353m0) {
            g gVar2 = this.f1352l0[i16];
            if (this.f1186o0 || gVar2.c()) {
                p197z.e eVarK = cVar.k(gVar2.f1235L[this.f1185n0]);
                int i17 = this.f1185n0;
                e eVar7 = gVar2.f1235L[i17];
                eVar7.f1213i = eVarK;
                e eVar8 = eVar7.f1210f;
                int i18 = (eVar8 == null || eVar8.f1208d != this) ? 0 : eVar7.f1211g;
                if (i17 == 0 || i17 == i10) {
                    p197z.e eVar9 = eVar6.f1213i;
                    int i19 = this.f1187p0 - i18;
                    p197z.b bVarL = cVar.l();
                    p197z.e eVarM = cVar.m();
                    eVarM.f22450d = 0;
                    bVarL.d(eVar9, eVarK, eVarM, i19);
                    cVar.c(bVarL);
                } else {
                    p197z.e eVar10 = eVar6.f1213i;
                    int i20 = this.f1187p0 + i18;
                    p197z.b bVarL2 = cVar.l();
                    p197z.e eVarM2 = cVar.m();
                    eVarM2.f22450d = 0;
                    bVarL2.c(eVar10, eVarK, eVarM2, i20);
                    cVar.c(bVarL2);
                }
                cVar.e(eVar6.f1213i, eVarK, this.f1187p0 + i18, i15);
            }
            i16++;
            i10 = 2;
        }
        int i21 = this.f1185n0;
        if (i21 == 0) {
            cVar.e(eVar3.f1213i, eVar.f1213i, 0, 8);
            cVar.e(eVar.f1213i, this.f1238P.f1229F.f1213i, 0, 4);
            cVar.e(eVar.f1213i, this.f1238P.f1227D.f1213i, 0, 0);
            return;
        }
        if (i21 == 1) {
            cVar.e(eVar.f1213i, eVar3.f1213i, 0, 8);
            cVar.e(eVar.f1213i, this.f1238P.f1227D.f1213i, 0, 4);
            cVar.e(eVar.f1213i, this.f1238P.f1229F.f1213i, 0, 0);
        } else if (i21 == 2) {
            cVar.e(eVar4.f1213i, eVar2.f1213i, 0, 8);
            cVar.e(eVar2.f1213i, this.f1238P.f1230G.f1213i, 0, 4);
            cVar.e(eVar2.f1213i, this.f1238P.f1228E.f1213i, 0, 0);
        } else if (i21 == 3) {
            cVar.e(eVar2.f1213i, eVar4.f1213i, 0, 8);
            cVar.e(eVar2.f1213i, this.f1238P.f1228E.f1213i, 0, 4);
            cVar.e(eVar2.f1213i, this.f1238P.f1230G.f1213i, 0, 0);
        }
    }

    @Override // A.g
    public final boolean c() {
        return true;
    }

    @Override // A.g
    public final String toString() {
        String strJ = a.j(new StringBuilder("[Barrier] "), this.f1255d0, " {");
        for (int i9 = 0; i9 < this.f1353m0; i9++) {
            g gVar = this.f1352l0[i9];
            if (i9 > 0) {
                strJ = W5.e.u(strJ, ", ");
            }
            StringBuilder sbB = p171w.a.b(strJ);
            sbB.append(gVar.f1255d0);
            strJ = sbB.toString();
        }
        return W5.e.u(strJ, "}");
    }

    @Override // A.g
    public final boolean w() {
        return this.f1188q0;
    }

    @Override // A.g
    public final boolean x() {
        return this.f1188q0;
    }
}
