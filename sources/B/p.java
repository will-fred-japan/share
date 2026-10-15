package B;

/* JADX INFO: compiled from: WidgetRun.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public A.g f1587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f1588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public A.g.a f1589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f1590e = new g(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1591f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1592g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f1593h = new f(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f1594i = new f(this);
    public a j = a.f1595a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: WidgetRun.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f1596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a[] f1597c;

        static {
            a aVar = new a("NONE", 0);
            f1595a = aVar;
            a aVar2 = new a("START", 1);
            a aVar3 = new a("END", 2);
            a aVar4 = new a("CENTER", 3);
            f1596b = aVar4;
            f1597c = new a[]{aVar, aVar2, aVar3, aVar4};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f1597c.clone();
        }
    }

    public p(A.g gVar) {
        this.f1587b = gVar;
    }

    public static void b(f fVar, f fVar2, int i9) {
        fVar.f1563l.add(fVar2);
        fVar.f1558f = i9;
        fVar2.f1562k.add(fVar);
    }

    public static f h(A.e eVar) {
        A.e eVar2 = eVar.f1210f;
        if (eVar2 == null) {
            return null;
        }
        A.g gVar = eVar2.f1208d;
        int iOrdinal = eVar2.f1209e.ordinal();
        if (iOrdinal == 1) {
            return gVar.f1254d.f1593h;
        }
        if (iOrdinal == 2) {
            return gVar.f1256e.f1593h;
        }
        if (iOrdinal == 3) {
            return gVar.f1254d.f1594i;
        }
        if (iOrdinal == 4) {
            return gVar.f1256e.f1594i;
        }
        if (iOrdinal != 5) {
            return null;
        }
        return gVar.f1256e.f1578k;
    }

    public static f i(A.e eVar, int i9) {
        A.e eVar2 = eVar.f1210f;
        if (eVar2 == null) {
            return null;
        }
        A.g gVar = eVar2.f1208d;
        p pVar = i9 == 0 ? gVar.f1254d : gVar.f1256e;
        int iOrdinal = eVar2.f1209e.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            return pVar.f1593h;
        }
        if (iOrdinal == 3 || iOrdinal == 4) {
            return pVar.f1594i;
        }
        return null;
    }

    public final void c(f fVar, f fVar2, int i9, g gVar) {
        fVar.f1563l.add(fVar2);
        fVar.f1563l.add(this.f1590e);
        fVar.f1560h = i9;
        fVar.f1561i = gVar;
        fVar2.f1562k.add(fVar);
        gVar.f1562k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i9, int i10) {
        if (i10 == 0) {
            A.g gVar = this.f1587b;
            int i11 = gVar.f1273p;
            int iMax = Math.max(gVar.f1272o, i9);
            if (i11 > 0) {
                iMax = Math.min(i11, i9);
            }
            if (iMax != i9) {
                return iMax;
            }
        } else {
            A.g gVar2 = this.f1587b;
            int i12 = gVar2.f1276s;
            int iMax2 = Math.max(gVar2.f1275r, i9);
            if (i12 > 0) {
                iMax2 = Math.min(i12, i9);
            }
            if (iMax2 != i9) {
                return iMax2;
            }
        }
        return i9;
    }

    public long j() {
        g gVar = this.f1590e;
        if (gVar.j) {
            return gVar.f1559g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Code duplicated, block: B:29:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    public final void l(A.e eVar, A.e eVar2, int i9) {
        g gVar;
        float f6;
        int i10;
        f fVarH = h(eVar);
        f fVarH2 = h(eVar2);
        if (fVarH.j && fVarH2.j) {
            int iE = eVar.e() + fVarH.f1559g;
            int iE2 = fVarH2.f1559g - eVar2.e();
            int i11 = iE2 - iE;
            g gVar2 = this.f1590e;
            if (!gVar2.j) {
                A.g.a aVar = this.f1589d;
                A.g.a aVar2 = A.g.a.f1285c;
                if (aVar == aVar2) {
                    int i12 = this.f1586a;
                    if (i12 == 0) {
                        gVar2.d(g(i11, i9));
                    } else if (i12 == 1) {
                        gVar2.d(Math.min(g(gVar2.f1573m, i9), i11));
                    } else if (i12 == 2) {
                        A.g gVar3 = this.f1587b;
                        A.g gVar4 = gVar3.f1238P;
                        if (gVar4 != null) {
                            g gVar5 = (i9 == 0 ? gVar4.f1254d : gVar4.f1256e).f1590e;
                            if (gVar5.j) {
                                gVar2.d(g((int) ((gVar5.f1559g * (i9 == 0 ? gVar3.f1274q : gVar3.t)) + 0.5f), i9));
                            }
                        }
                    } else if (i12 == 3) {
                        A.g gVar6 = this.f1587b;
                        p pVar = gVar6.f1254d;
                        if (pVar.f1589d == aVar2 && pVar.f1586a == 3) {
                            n nVar = gVar6.f1256e;
                            if (nVar.f1589d != aVar2 || nVar.f1586a != 3) {
                                if (i9 == 0) {
                                    pVar = gVar6.f1256e;
                                }
                                gVar = pVar.f1590e;
                                if (gVar.j) {
                                    f6 = gVar6.f1241S;
                                    if (i9 == 1) {
                                        i10 = (int) ((gVar.f1559g / f6) + 0.5f);
                                    } else {
                                        i10 = (int) ((f6 * gVar.f1559g) + 0.5f);
                                    }
                                    gVar2.d(i10);
                                }
                            }
                        } else {
                            if (i9 == 0) {
                                pVar = gVar6.f1256e;
                            }
                            gVar = pVar.f1590e;
                            if (gVar.j) {
                                f6 = gVar6.f1241S;
                                if (i9 == 1) {
                                    i10 = (int) ((gVar.f1559g / f6) + 0.5f);
                                } else {
                                    i10 = (int) ((f6 * gVar.f1559g) + 0.5f);
                                }
                                gVar2.d(i10);
                            }
                        }
                    }
                }
            }
            if (gVar2.j) {
                int i13 = gVar2.f1559g;
                f fVar = this.f1594i;
                f fVar2 = this.f1593h;
                if (i13 == i11) {
                    fVar2.d(iE);
                    fVar.d(iE2);
                    return;
                }
                A.g gVar7 = this.f1587b;
                float f9 = i9 == 0 ? gVar7.f1248Z : gVar7.a0;
                if (fVarH == fVarH2) {
                    iE = fVarH.f1559g;
                    iE2 = fVarH2.f1559g;
                    f9 = 0.5f;
                }
                fVar2.d((int) ((((iE2 - iE) - i13) * f9) + iE + 0.5f));
                fVar.d(fVar2.f1559g + gVar2.f1559g);
            }
        }
    }

    @Override // B.d
    public void a(d dVar) {
    }
}
