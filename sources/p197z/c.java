package p197z;

import A.e;
import java.util.ArrayList;
import java.util.Arrays;
import p049g6.f;
import z.d.b;

/* JADX INFO: compiled from: LinearSystem.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f22425p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f22426q = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f22429c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b[] f22432f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f22437l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f22440o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22427a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22428b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22430d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22431e = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22433g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean[] f22434h = new boolean[32];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22435i = 1;
    public int j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22436k = 32;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e[] f22438m = new e[f22426q];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f22439n = 0;

    /* JADX INFO: compiled from: LinearSystem.java */
    public interface a {
        e a(boolean[] zArr);
    }

    public c() {
        this.f22432f = null;
        this.f22432f = new b[32];
        s();
        f fVar = new f();
        fVar.f18913a = new S.c();
        fVar.f18914b = new S.c();
        fVar.f18915c = new e[32];
        this.f22437l = fVar;
        d dVar = new d(fVar);
        dVar.f22441f = new e[128];
        dVar.f22442g = new e[128];
        dVar.f22443h = 0;
        dVar.f22444i = dVar.new b();
        this.f22429c = dVar;
        this.f22440o = new b(fVar);
    }

    public static int n(Object obj) {
        e eVar = ((e) obj).f1213i;
        if (eVar != null) {
            return (int) (eVar.f22451e + 0.5f);
        }
        return 0;
    }

    public final e a(e.a aVar) {
        S.c cVar = (S.c) this.f22437l.f18914b;
        int i9 = cVar.f4090b;
        Object obj = null;
        if (i9 > 0) {
            int i10 = i9 - 1;
            Object[] objArr = (Object[]) cVar.f4089a;
            Object obj2 = objArr[i10];
            objArr[i10] = null;
            cVar.f4090b = i10;
            obj = obj2;
        }
        e eVar = (e) obj;
        if (eVar == null) {
            eVar = new e(aVar);
            eVar.f22455i = aVar;
        } else {
            eVar.c();
            eVar.f22455i = aVar;
        }
        int i11 = this.f22439n;
        int i12 = f22426q;
        if (i11 >= i12) {
            int i13 = i12 * 2;
            f22426q = i13;
            this.f22438m = (e[]) Arrays.copyOf(this.f22438m, i13);
        }
        e[] eVarArr = this.f22438m;
        int i14 = this.f22439n;
        this.f22439n = i14 + 1;
        eVarArr[i14] = eVar;
        return eVar;
    }

    public final void b(e eVar, e eVar2, int i9, float f6, e eVar3, e eVar4, int i10, int i11) {
        b bVarL = l();
        if (eVar2 == eVar3) {
            bVarL.f22423d.b(eVar, 1.0f);
            bVarL.f22423d.b(eVar4, 1.0f);
            bVarL.f22423d.b(eVar2, -2.0f);
        } else if (f6 == 0.5f) {
            bVarL.f22423d.b(eVar, 1.0f);
            bVarL.f22423d.b(eVar2, -1.0f);
            bVarL.f22423d.b(eVar3, -1.0f);
            bVarL.f22423d.b(eVar4, 1.0f);
            if (i9 > 0 || i10 > 0) {
                bVarL.f22421b = (-i9) + i10;
            }
        } else if (f6 <= 0.0f) {
            bVarL.f22423d.b(eVar, -1.0f);
            bVarL.f22423d.b(eVar2, 1.0f);
            bVarL.f22421b = i9;
        } else if (f6 >= 1.0f) {
            bVarL.f22423d.b(eVar4, -1.0f);
            bVarL.f22423d.b(eVar3, 1.0f);
            bVarL.f22421b = -i10;
        } else {
            float f9 = 1.0f - f6;
            bVarL.f22423d.b(eVar, f9 * 1.0f);
            bVarL.f22423d.b(eVar2, f9 * (-1.0f));
            bVarL.f22423d.b(eVar3, (-1.0f) * f6);
            bVarL.f22423d.b(eVar4, 1.0f * f6);
            if (i9 > 0 || i10 > 0) {
                bVarL.f22421b = (i10 * f6) + ((-i9) * f9);
            }
        }
        if (i11 != 8) {
            bVarL.b(this, i11);
        }
        c(bVarL);
    }

    /* JADX WARN: Code duplicated, block: B:116:0x019e  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e3  */
    public final void c(b bVar) {
        boolean z8;
        e.a aVar;
        boolean z9;
        e eVarF;
        ArrayList<e> arrayList;
        boolean z10 = true;
        if (this.j + 1 >= this.f22436k || this.f22435i + 1 >= this.f22431e) {
            o();
        }
        if (bVar.f22424e) {
            z8 = false;
        } else {
            if (this.f22432f.length != 0) {
                boolean z11 = false;
                while (!z11) {
                    int iE = bVar.f22423d.e();
                    int i9 = 0;
                    while (true) {
                        arrayList = bVar.f22422c;
                        if (i9 >= iE) {
                            break;
                        }
                        e eVarG = bVar.f22423d.g(i9);
                        if (eVarG.f22449c != -1 || eVarG.f22452f) {
                            arrayList.add(eVarG);
                        }
                        i9++;
                    }
                    int size = arrayList.size();
                    if (size > 0) {
                        for (int i10 = 0; i10 < size; i10++) {
                            e eVar = arrayList.get(i10);
                            if (eVar.f22452f) {
                                bVar.h(this, eVar, true);
                            } else {
                                bVar.i(this, this.f22432f[eVar.f22449c], true);
                            }
                        }
                        arrayList.clear();
                    } else {
                        z11 = true;
                    }
                }
                if (bVar.f22420a != null && bVar.f22423d.e() == 0) {
                    bVar.f22424e = true;
                    this.f22427a = true;
                }
            }
            if (bVar.e()) {
                return;
            }
            float f6 = bVar.f22421b;
            float f9 = 0.0f;
            if (f6 < 0.0f) {
                bVar.f22421b = f6 * (-1.0f);
                bVar.f22423d.k();
            }
            int iE2 = bVar.f22423d.e();
            float f10 = 0.0f;
            float f11 = 0.0f;
            e eVar2 = null;
            e eVar3 = null;
            int i11 = 0;
            boolean z12 = false;
            boolean z13 = false;
            while (true) {
                aVar = e.a.f22458a;
                if (i11 >= iE2) {
                    break;
                }
                float fA = bVar.f22423d.a(i11);
                float f12 = f9;
                e eVarG2 = bVar.f22423d.g(i11);
                if (eVarG2.f22455i == aVar) {
                    if (eVar2 == null) {
                        if (eVarG2.f22457l <= 1) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        f10 = fA;
                        eVar2 = eVarG2;
                    } else {
                        if (f10 > fA) {
                            if (eVarG2.f22457l > 1) {
                                z12 = false;
                            }
                            f10 = fA;
                            eVar2 = eVarG2;
                        } else if (z12 || eVarG2.f22457l > 1) {
                        }
                        z12 = true;
                        f10 = fA;
                        eVar2 = eVarG2;
                    }
                } else if (eVar2 == null && fA < f12) {
                    if (eVar3 == null) {
                        if (eVarG2.f22457l <= 1) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        f11 = fA;
                        eVar3 = eVarG2;
                    } else {
                        if (f11 > fA) {
                            if (eVarG2.f22457l > 1) {
                                z13 = false;
                            }
                            f11 = fA;
                            eVar3 = eVarG2;
                        } else if (z13 || eVarG2.f22457l > 1) {
                        }
                        z13 = true;
                        f11 = fA;
                        eVar3 = eVarG2;
                    }
                }
                i11++;
                f9 = f12;
            }
            float f13 = f9;
            if (eVar2 == null) {
                eVar2 = eVar3;
            }
            if (eVar2 == null) {
                z9 = true;
            } else {
                bVar.g(eVar2);
                z9 = false;
            }
            if (bVar.f22423d.e() == 0) {
                bVar.f22424e = true;
            }
            if (z9) {
                if (this.f22435i + 1 >= this.f22431e) {
                    o();
                }
                e eVarA = a(e.a.f22459b);
                int i12 = this.f22428b + 1;
                this.f22428b = i12;
                this.f22435i++;
                eVarA.f22448b = i12;
                f fVar = this.f22437l;
                ((e[]) fVar.f18915c)[i12] = eVarA;
                bVar.f22420a = eVarA;
                int i13 = this.j;
                h(bVar);
                if (this.j == i13 + 1) {
                    b bVar2 = this.f22440o;
                    bVar2.getClass();
                    bVar2.f22420a = null;
                    bVar2.f22423d.clear();
                    for (int i14 = 0; i14 < bVar.f22423d.e(); i14++) {
                        bVar2.f22423d.c(bVar.f22423d.g(i14), bVar.f22423d.a(i14), true);
                    }
                    r(this.f22440o);
                    if (eVarA.f22449c == -1) {
                        if (bVar.f22420a == eVarA && (eVarF = bVar.f(null, eVarA)) != null) {
                            bVar.g(eVarF);
                        }
                        if (!bVar.f22424e) {
                            bVar.f22420a.e(this, bVar);
                        }
                        ((S.c) fVar.f18913a).e(bVar);
                        this.j--;
                    }
                } else {
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            e eVar4 = bVar.f22420a;
            if (eVar4 == null) {
                return;
            }
            if (eVar4.f22455i != aVar && bVar.f22421b < f13) {
                return;
            } else {
                z8 = z10;
            }
        }
        if (z8) {
            return;
        }
        h(bVar);
    }

    public final void d(e eVar, int i9) {
        int i10 = eVar.f22449c;
        if (i10 == -1) {
            eVar.d(this, i9);
            for (int i11 = 0; i11 < this.f22428b + 1; i11++) {
                e eVar2 = ((e[]) this.f22437l.f18915c)[i11];
            }
            return;
        }
        if (i10 == -1) {
            b bVarL = l();
            bVarL.f22420a = eVar;
            float f6 = i9;
            eVar.f22451e = f6;
            bVarL.f22421b = f6;
            bVarL.f22424e = true;
            c(bVarL);
            return;
        }
        b bVar = this.f22432f[i10];
        if (bVar.f22424e) {
            bVar.f22421b = i9;
            return;
        }
        if (bVar.f22423d.e() == 0) {
            bVar.f22424e = true;
            bVar.f22421b = i9;
            return;
        }
        b bVarL2 = l();
        if (i9 < 0) {
            bVarL2.f22421b = i9 * (-1);
            bVarL2.f22423d.b(eVar, 1.0f);
        } else {
            bVarL2.f22421b = i9;
            bVarL2.f22423d.b(eVar, -1.0f);
        }
        c(bVarL2);
    }

    public final void e(e eVar, e eVar2, int i9, int i10) {
        if (i10 == 8 && eVar2.f22452f && eVar.f22449c == -1) {
            eVar.d(this, eVar2.f22451e + i9);
            return;
        }
        b bVarL = l();
        boolean z8 = false;
        if (i9 != 0) {
            if (i9 < 0) {
                i9 *= -1;
                z8 = true;
            }
            bVarL.f22421b = i9;
        }
        if (z8) {
            bVarL.f22423d.b(eVar, 1.0f);
            bVarL.f22423d.b(eVar2, -1.0f);
        } else {
            bVarL.f22423d.b(eVar, -1.0f);
            bVarL.f22423d.b(eVar2, 1.0f);
        }
        if (i10 != 8) {
            bVarL.b(this, i10);
        }
        c(bVarL);
    }

    public final void f(e eVar, e eVar2, int i9, int i10) {
        b bVarL = l();
        e eVarM = m();
        eVarM.f22450d = 0;
        bVarL.c(eVar, eVar2, eVarM, i9);
        if (i10 != 8) {
            bVarL.f22423d.b(j(i10), (int) (bVarL.f22423d.j(eVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void g(e eVar, e eVar2, int i9, int i10) {
        b bVarL = l();
        e eVarM = m();
        eVarM.f22450d = 0;
        bVarL.d(eVar, eVar2, eVarM, i9);
        if (i10 != 8) {
            bVarL.f22423d.b(j(i10), (int) (bVarL.f22423d.j(eVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void h(b bVar) {
        int i9;
        if (bVar.f22424e) {
            bVar.f22420a.d(this, bVar.f22421b);
        } else {
            b[] bVarArr = this.f22432f;
            int i10 = this.j;
            bVarArr[i10] = bVar;
            e eVar = bVar.f22420a;
            eVar.f22449c = i10;
            this.j = i10 + 1;
            eVar.e(this, bVar);
        }
        if (this.f22427a) {
            int i11 = 0;
            while (i11 < this.j) {
                if (this.f22432f[i11] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f22432f[i11];
                if (bVar2 != null && bVar2.f22424e) {
                    bVar2.f22420a.d(this, bVar2.f22421b);
                    ((S.c) this.f22437l.f18913a).e(bVar2);
                    this.f22432f[i11] = null;
                    int i12 = i11 + 1;
                    int i13 = i12;
                    while (true) {
                        i9 = this.j;
                        if (i12 >= i9) {
                            break;
                        }
                        b[] bVarArr2 = this.f22432f;
                        int i14 = i12 - 1;
                        b bVar3 = bVarArr2[i12];
                        bVarArr2[i14] = bVar3;
                        e eVar2 = bVar3.f22420a;
                        if (eVar2.f22449c == i12) {
                            eVar2.f22449c = i14;
                        }
                        i13 = i12;
                        i12++;
                    }
                    if (i13 < i9) {
                        this.f22432f[i13] = null;
                    }
                    this.j = i9 - 1;
                    i11--;
                }
                i11++;
            }
            this.f22427a = false;
        }
    }

    public final void i() {
        for (int i9 = 0; i9 < this.j; i9++) {
            b bVar = this.f22432f[i9];
            bVar.f22420a.f22451e = bVar.f22421b;
        }
    }

    public final e j(int i9) {
        if (this.f22435i + 1 >= this.f22431e) {
            o();
        }
        e eVarA = a(e.a.f22460c);
        int i10 = this.f22428b + 1;
        this.f22428b = i10;
        this.f22435i++;
        eVarA.f22448b = i10;
        eVarA.f22450d = i9;
        ((e[]) this.f22437l.f18915c)[i10] = eVarA;
        d dVar = this.f22429c;
        dVar.f22444i.f22445a = eVarA;
        float[] fArr = eVarA.f22454h;
        Arrays.fill(fArr, 0.0f);
        fArr[eVarA.f22450d] = 1.0f;
        dVar.j(eVarA);
        return eVarA;
    }

    public final e k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.f22435i + 1 >= this.f22431e) {
            o();
        }
        if (!(obj instanceof e)) {
            return null;
        }
        e eVar = (e) obj;
        e eVar2 = eVar.f1213i;
        if (eVar2 == null) {
            eVar.k();
            eVar2 = eVar.f1213i;
        }
        int i9 = eVar2.f22448b;
        f fVar = this.f22437l;
        if (i9 != -1 && i9 <= this.f22428b && ((e[]) fVar.f18915c)[i9] != null) {
            return eVar2;
        }
        if (i9 != -1) {
            eVar2.c();
        }
        int i10 = this.f22428b + 1;
        this.f22428b = i10;
        this.f22435i++;
        eVar2.f22448b = i10;
        eVar2.f22455i = e.a.f22458a;
        ((e[]) fVar.f18915c)[i10] = eVar2;
        return eVar2;
    }

    public final b l() {
        Object obj;
        f fVar = this.f22437l;
        S.c cVar = (S.c) fVar.f18913a;
        int i9 = cVar.f4090b;
        if (i9 > 0) {
            int i10 = i9 - 1;
            Object[] objArr = (Object[]) cVar.f4089a;
            obj = objArr[i10];
            objArr[i10] = null;
            cVar.f4090b = i10;
        } else {
            obj = null;
        }
        b bVar = (b) obj;
        if (bVar == null) {
            return new b(fVar);
        }
        bVar.f22420a = null;
        bVar.f22423d.clear();
        bVar.f22421b = 0.0f;
        bVar.f22424e = false;
        return bVar;
    }

    public final e m() {
        if (this.f22435i + 1 >= this.f22431e) {
            o();
        }
        e eVarA = a(e.a.f22459b);
        int i9 = this.f22428b + 1;
        this.f22428b = i9;
        this.f22435i++;
        eVarA.f22448b = i9;
        ((e[]) this.f22437l.f18915c)[i9] = eVarA;
        return eVarA;
    }

    public final void o() {
        int i9 = this.f22430d * 2;
        this.f22430d = i9;
        this.f22432f = (b[]) Arrays.copyOf(this.f22432f, i9);
        f fVar = this.f22437l;
        fVar.f18915c = (e[]) Arrays.copyOf((e[]) fVar.f18915c, this.f22430d);
        int i10 = this.f22430d;
        this.f22434h = new boolean[i10];
        this.f22431e = i10;
        this.f22436k = i10;
    }

    public final void p() {
        d dVar = this.f22429c;
        if (dVar.e()) {
            i();
            return;
        }
        if (!this.f22433g) {
            q(dVar);
            return;
        }
        for (int i9 = 0; i9 < this.j; i9++) {
            if (!this.f22432f[i9].f22424e) {
                q(dVar);
                return;
            }
        }
        i();
    }

    public final void q(d dVar) {
        for (int i9 = 0; i9 < this.j; i9++) {
            b bVar = this.f22432f[i9];
            e.a aVar = bVar.f22420a.f22455i;
            e.a aVar2 = e.a.f22458a;
            if (aVar != aVar2) {
                float f6 = 0.0f;
                if (bVar.f22421b < 0.0f) {
                    boolean z8 = false;
                    int i10 = 0;
                    while (!z8) {
                        i10++;
                        float f9 = Float.MAX_VALUE;
                        int i11 = 0;
                        int i12 = -1;
                        int i13 = -1;
                        int i14 = 0;
                        while (i11 < this.j) {
                            b bVar2 = this.f22432f[i11];
                            if (bVar2.f22420a.f22455i != aVar2 && !bVar2.f22424e && bVar2.f22421b < f6) {
                                int iE = bVar2.f22423d.e();
                                int i15 = 0;
                                while (i15 < iE) {
                                    e eVarG = bVar2.f22423d.g(i15);
                                    float f10 = f6;
                                    float fJ = bVar2.f22423d.j(eVarG);
                                    if (fJ > f10) {
                                        for (int i16 = 0; i16 < 9; i16++) {
                                            float f11 = eVarG.f22453g[i16] / fJ;
                                            if ((f11 < f9 && i16 == i14) || i16 > i14) {
                                                i14 = i16;
                                                i13 = eVarG.f22448b;
                                                i12 = i11;
                                                f9 = f11;
                                            }
                                        }
                                    }
                                    i15++;
                                    f6 = f10;
                                }
                            }
                            i11++;
                            f6 = f6;
                        }
                        float f12 = f6;
                        if (i12 != -1) {
                            b bVar3 = this.f22432f[i12];
                            bVar3.f22420a.f22449c = -1;
                            bVar3.g(((e[]) this.f22437l.f18915c)[i13]);
                            e eVar = bVar3.f22420a;
                            eVar.f22449c = i12;
                            eVar.e(this, bVar3);
                        } else {
                            z8 = true;
                        }
                        if (i10 > this.f22435i / 2) {
                            z8 = true;
                        }
                        f6 = f12;
                    }
                    break;
                }
            }
        }
        r(dVar);
        i();
    }

    public final void r(b bVar) {
        for (int i9 = 0; i9 < this.f22435i; i9++) {
            this.f22434h[i9] = false;
        }
        boolean z8 = false;
        int i10 = 0;
        while (!z8) {
            i10++;
            if (i10 >= this.f22435i * 2) {
                return;
            }
            e eVar = bVar.f22420a;
            if (eVar != null) {
                this.f22434h[eVar.f22448b] = true;
            }
            e eVarA = bVar.a(this.f22434h);
            if (eVarA != null) {
                boolean[] zArr = this.f22434h;
                int i11 = eVarA.f22448b;
                if (zArr[i11]) {
                    return;
                } else {
                    zArr[i11] = true;
                }
            }
            if (eVarA != null) {
                float f6 = Float.MAX_VALUE;
                int i12 = -1;
                for (int i13 = 0; i13 < this.j; i13++) {
                    b bVar2 = this.f22432f[i13];
                    if (bVar2.f22420a.f22455i != e.a.f22458a && !bVar2.f22424e && bVar2.f22423d.f(eVarA)) {
                        float fJ = bVar2.f22423d.j(eVarA);
                        if (fJ < 0.0f) {
                            float f9 = (-bVar2.f22421b) / fJ;
                            if (f9 < f6) {
                                i12 = i13;
                                f6 = f9;
                            }
                        }
                    }
                }
                if (i12 > -1) {
                    b bVar3 = this.f22432f[i12];
                    bVar3.f22420a.f22449c = -1;
                    bVar3.g(eVarA);
                    e eVar2 = bVar3.f22420a;
                    eVar2.f22449c = i12;
                    eVar2.e(this, bVar3);
                }
            } else {
                z8 = true;
            }
        }
    }

    public final void s() {
        for (int i9 = 0; i9 < this.j; i9++) {
            b bVar = this.f22432f[i9];
            if (bVar != null) {
                ((S.c) this.f22437l.f18913a).e(bVar);
            }
            this.f22432f[i9] = null;
        }
    }

    public final void t() {
        f fVar;
        int i9 = 0;
        while (true) {
            fVar = this.f22437l;
            e[] eVarArr = (e[]) fVar.f18915c;
            if (i9 >= eVarArr.length) {
                break;
            }
            e eVar = eVarArr[i9];
            if (eVar != null) {
                eVar.c();
            }
            i9++;
        }
        S.c cVar = (S.c) fVar.f18914b;
        e[] eVarArr2 = this.f22438m;
        int length = this.f22439n;
        cVar.getClass();
        if (length > eVarArr2.length) {
            length = eVarArr2.length;
        }
        for (int i10 = 0; i10 < length; i10++) {
            e eVar2 = eVarArr2[i10];
            int i11 = cVar.f4090b;
            Object[] objArr = (Object[]) cVar.f4089a;
            if (i11 < objArr.length) {
                objArr[i11] = eVar2;
                cVar.f4090b = i11 + 1;
            }
        }
        this.f22439n = 0;
        Arrays.fill((e[]) fVar.f18915c, (Object) null);
        this.f22428b = 0;
        d dVar = this.f22429c;
        dVar.f22443h = 0;
        dVar.f22421b = 0.0f;
        this.f22435i = 1;
        for (int i12 = 0; i12 < this.j; i12++) {
            b bVar = this.f22432f[i12];
        }
        s();
        this.j = 0;
        this.f22440o = new b(fVar);
    }
}
