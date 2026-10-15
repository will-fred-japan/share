package p197z;

import W5.e;
import java.util.ArrayList;
import p049g6.f;

/* JADX INFO: compiled from: ArrayRow.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements c.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f22423d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f22420a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f22421b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<e> f22422c = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22424e = false;

    /* JADX INFO: compiled from: ArrayRow.java */
    public interface a {
        float a(int i9);

        void b(e eVar, float f6);

        void c(e eVar, float f6, boolean z8);

        void clear();

        float d(e eVar, boolean z8);

        int e();

        boolean f(e eVar);

        e g(int i9);

        void h(float f6);

        float i(b bVar, boolean z8);

        float j(e eVar);

        void k();
    }

    public b() {
    }

    @Override // z.c.a
    public e a(boolean[] zArr) {
        return f(zArr, null);
    }

    public final void b(c cVar, int i9) {
        this.f22423d.b(cVar.j(i9), 1.0f);
        this.f22423d.b(cVar.j(i9), -1.0f);
    }

    public final void c(e eVar, e eVar2, e eVar3, int i9) {
        boolean z8 = false;
        if (i9 != 0) {
            if (i9 < 0) {
                i9 *= -1;
                z8 = true;
            }
            this.f22421b = i9;
        }
        if (z8) {
            this.f22423d.b(eVar, 1.0f);
            this.f22423d.b(eVar2, -1.0f);
            this.f22423d.b(eVar3, -1.0f);
        } else {
            this.f22423d.b(eVar, -1.0f);
            this.f22423d.b(eVar2, 1.0f);
            this.f22423d.b(eVar3, 1.0f);
        }
    }

    public final void d(e eVar, e eVar2, e eVar3, int i9) {
        boolean z8 = false;
        if (i9 != 0) {
            if (i9 < 0) {
                i9 *= -1;
                z8 = true;
            }
            this.f22421b = i9;
        }
        if (z8) {
            this.f22423d.b(eVar, 1.0f);
            this.f22423d.b(eVar2, -1.0f);
            this.f22423d.b(eVar3, 1.0f);
        } else {
            this.f22423d.b(eVar, -1.0f);
            this.f22423d.b(eVar2, 1.0f);
            this.f22423d.b(eVar3, -1.0f);
        }
    }

    public boolean e() {
        return this.f22420a == null && this.f22421b == 0.0f && this.f22423d.e() == 0;
    }

    public final e f(boolean[] zArr, e eVar) {
        e.a aVar;
        int iE = this.f22423d.e();
        e eVar2 = null;
        float f6 = 0.0f;
        for (int i9 = 0; i9 < iE; i9++) {
            float fA = this.f22423d.a(i9);
            if (fA < 0.0f) {
                e eVarG = this.f22423d.g(i9);
                if ((zArr == null || !zArr[eVarG.f22448b]) && eVarG != eVar && (((aVar = eVarG.f22455i) == e.a.f22459b || aVar == e.a.f22460c) && fA < f6)) {
                    f6 = fA;
                    eVar2 = eVarG;
                }
            }
        }
        return eVar2;
    }

    public final void g(e eVar) {
        e eVar2 = this.f22420a;
        if (eVar2 != null) {
            this.f22423d.b(eVar2, -1.0f);
            this.f22420a.f22449c = -1;
            this.f22420a = null;
        }
        float fD = this.f22423d.d(eVar, true) * (-1.0f);
        this.f22420a = eVar;
        if (fD == 1.0f) {
            return;
        }
        this.f22421b /= fD;
        this.f22423d.h(fD);
    }

    public final void h(c cVar, e eVar, boolean z8) {
        if (eVar.f22452f) {
            float fJ = this.f22423d.j(eVar);
            this.f22421b = (eVar.f22451e * fJ) + this.f22421b;
            this.f22423d.d(eVar, z8);
            if (z8) {
                eVar.b(this);
            }
            if (this.f22423d.e() == 0) {
                this.f22424e = true;
                cVar.f22427a = true;
            }
        }
    }

    public void i(c cVar, b bVar, boolean z8) {
        float fI = this.f22423d.i(bVar, z8);
        this.f22421b = (bVar.f22421b * fI) + this.f22421b;
        if (z8) {
            bVar.f22420a.b(this);
        }
        if (this.f22420a == null || this.f22423d.e() != 0) {
            return;
        }
        this.f22424e = true;
        cVar.f22427a = true;
    }

    public String toString() {
        boolean z8;
        String strU = e.u(this.f22420a == null ? "0" : "" + this.f22420a, " = ");
        if (this.f22421b != 0.0f) {
            StringBuilder sbB = p171w.a.b(strU);
            sbB.append(this.f22421b);
            strU = sbB.toString();
            z8 = true;
        } else {
            z8 = false;
        }
        int iE = this.f22423d.e();
        for (int i9 = 0; i9 < iE; i9++) {
            e eVarG = this.f22423d.g(i9);
            if (eVarG != null) {
                float fA = this.f22423d.a(i9);
                if (fA != 0.0f) {
                    String string = eVarG.toString();
                    if (z8) {
                        if (fA > 0.0f) {
                            strU = e.u(strU, " + ");
                        } else {
                            strU = e.u(strU, " - ");
                            fA *= -1.0f;
                        }
                    } else if (fA < 0.0f) {
                        strU = e.u(strU, "- ");
                        fA *= -1.0f;
                    }
                    strU = fA == 1.0f ? e.u(strU, string) : strU + fA + " " + string;
                    z8 = true;
                }
            }
        }
        return !z8 ? e.u(strU, "0.0") : strU;
    }

    public b(f fVar) {
        this.f22423d = new p197z.a(this, fVar);
    }
}
