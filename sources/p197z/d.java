package p197z;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: PriorityGoalRow.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p197z.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e[] f22441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e[] f22442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22443h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f22444i;

    /* JADX INFO: compiled from: PriorityGoalRow.java */
    public class a implements Comparator<e> {
        @Override // java.util.Comparator
        public final int compare(e eVar, e eVar2) {
            return eVar.f22448b - eVar2.f22448b;
        }
    }

    /* JADX INFO: compiled from: PriorityGoalRow.java */
    public class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f22445a;

        public b() {
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f22445a.f22448b - ((e) obj).f22448b;
        }

        public final String toString() {
            String string = "[ ";
            if (this.f22445a != null) {
                for (int i9 = 0; i9 < 9; i9++) {
                    StringBuilder sbB = p171w.a.b(string);
                    sbB.append(this.f22445a.f22454h[i9]);
                    sbB.append(" ");
                    string = sbB.toString();
                }
            }
            StringBuilder sbC = p171w.a.c(string, "] ");
            sbC.append(this.f22445a);
            return sbC.toString();
        }
    }

    @Override // p197z.b, z.c.a
    public final e a(boolean[] zArr) {
        int i9 = -1;
        for (int i10 = 0; i10 < this.f22443h; i10++) {
            e[] eVarArr = this.f22441f;
            e eVar = eVarArr[i10];
            if (!zArr[eVar.f22448b]) {
                b bVar = this.f22444i;
                bVar.f22445a = eVar;
                int i11 = 8;
                if (i9 != -1) {
                    e eVar2 = eVarArr[i9];
                    while (i11 >= 0) {
                        float f6 = eVar2.f22454h[i11];
                        float f9 = bVar.f22445a.f22454h[i11];
                        if (f9 != f6) {
                            if (f9 >= f6) {
                                break;
                            }
                            i9 = i10;
                            break;
                            break;
                        }
                        i11--;
                    }
                } else {
                    while (i11 >= 0) {
                        float f10 = bVar.f22445a.f22454h[i11];
                        if (f10 > 0.0f) {
                            break;
                        }
                        if (f10 < 0.0f) {
                            i9 = i10;
                            break;
                        }
                        i11--;
                    }
                }
            }
        }
        if (i9 == -1) {
            return null;
        }
        return this.f22441f[i9];
    }

    @Override // p197z.b
    public final boolean e() {
        return this.f22443h == 0;
    }

    @Override // p197z.b
    public final void i(c cVar, p197z.b bVar, boolean z8) {
        e eVar = bVar.f22420a;
        if (eVar == null) {
            return;
        }
        z.b.a aVar = bVar.f22423d;
        int iE = aVar.e();
        for (int i9 = 0; i9 < iE; i9++) {
            e eVarG = aVar.g(i9);
            float fA = aVar.a(i9);
            b bVar2 = this.f22444i;
            bVar2.f22445a = eVarG;
            boolean z9 = eVarG.f22447a;
            float[] fArr = eVar.f22454h;
            if (z9) {
                boolean z10 = true;
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr2 = bVar2.f22445a.f22454h;
                    float f6 = (fArr[i10] * fA) + fArr2[i10];
                    fArr2[i10] = f6;
                    if (Math.abs(f6) < 1.0E-4f) {
                        bVar2.f22445a.f22454h[i10] = 0.0f;
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    d.this.k(bVar2.f22445a);
                }
            } else {
                for (int i11 = 0; i11 < 9; i11++) {
                    float f9 = fArr[i11];
                    if (f9 != 0.0f) {
                        float f10 = f9 * fA;
                        if (Math.abs(f10) < 1.0E-4f) {
                            f10 = 0.0f;
                        }
                        bVar2.f22445a.f22454h[i11] = f10;
                    } else {
                        bVar2.f22445a.f22454h[i11] = 0.0f;
                    }
                }
                j(eVarG);
            }
            this.f22421b = (bVar.f22421b * fA) + this.f22421b;
        }
        k(eVar);
    }

    public final void j(e eVar) {
        int i9;
        int i10 = this.f22443h + 1;
        e[] eVarArr = this.f22441f;
        if (i10 > eVarArr.length) {
            e[] eVarArr2 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
            this.f22441f = eVarArr2;
            this.f22442g = (e[]) Arrays.copyOf(eVarArr2, eVarArr2.length * 2);
        }
        e[] eVarArr3 = this.f22441f;
        int i11 = this.f22443h;
        eVarArr3[i11] = eVar;
        int i12 = i11 + 1;
        this.f22443h = i12;
        if (i12 > 1 && eVarArr3[i11].f22448b > eVar.f22448b) {
            int i13 = 0;
            while (true) {
                i9 = this.f22443h;
                if (i13 >= i9) {
                    break;
                }
                this.f22442g[i13] = this.f22441f[i13];
                i13++;
            }
            Arrays.sort(this.f22442g, 0, i9, new a());
            for (int i14 = 0; i14 < this.f22443h; i14++) {
                this.f22441f[i14] = this.f22442g[i14];
            }
        }
        eVar.f22447a = true;
        eVar.a(this);
    }

    public final void k(e eVar) {
        int i9 = 0;
        while (i9 < this.f22443h) {
            if (this.f22441f[i9] == eVar) {
                while (true) {
                    int i10 = this.f22443h;
                    if (i9 >= i10 - 1) {
                        this.f22443h = i10 - 1;
                        eVar.f22447a = false;
                        return;
                    } else {
                        e[] eVarArr = this.f22441f;
                        int i11 = i9 + 1;
                        eVarArr[i9] = eVarArr[i11];
                        i9 = i11;
                    }
                }
            } else {
                i9++;
            }
        }
    }

    @Override // p197z.b
    public final String toString() {
        String str = " goal -> (" + this.f22421b + ") : ";
        for (int i9 = 0; i9 < this.f22443h; i9++) {
            e eVar = this.f22441f[i9];
            b bVar = this.f22444i;
            bVar.f22445a = eVar;
            str = str + bVar + " ";
        }
        return str;
    }
}
