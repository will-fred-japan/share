package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* JADX INFO: compiled from: UnknownFieldSetLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n0 f7286f = new n0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f7288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f7289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7291e;

    public n0() {
        this(0, new int[8], new Object[8], true);
    }

    public final void a(int i9) {
        int[] iArr = this.f7288b;
        if (i9 > iArr.length) {
            int i10 = this.f7287a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i9) {
                i9 = i11;
            }
            if (i9 < 8) {
                i9 = 8;
            }
            this.f7288b = Arrays.copyOf(iArr, i9);
            this.f7289c = Arrays.copyOf(this.f7289c, i9);
        }
    }

    public final int b() {
        int iC;
        int iE;
        int iC2;
        int i9 = this.f7290d;
        if (i9 != -1) {
            return i9;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f7287a; i11++) {
            int i12 = this.f7288b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f7289c[i11]).getClass();
                    iC2 = AbstractC0516j.C(i13) + 8;
                } else if (i14 == 2) {
                    iC2 = AbstractC0516j.w(i13, (AbstractC0513g) this.f7289c[i11]);
                } else if (i14 == 3) {
                    iC = AbstractC0516j.C(i13) * 2;
                    iE = ((n0) this.f7289c[i11]).b();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(C0531z.b());
                    }
                    ((Integer) this.f7289c[i11]).getClass();
                    iC2 = AbstractC0516j.C(i13) + 4;
                }
                i10 = iC2 + i10;
            } else {
                long jLongValue = ((Long) this.f7289c[i11]).longValue();
                iC = AbstractC0516j.C(i13);
                iE = AbstractC0516j.E(jLongValue);
            }
            i10 = iE + iC + i10;
        }
        this.f7290d = i10;
        return i10;
    }

    public final void c(int i9, Object obj) {
        if (!this.f7291e) {
            throw new UnsupportedOperationException();
        }
        a(this.f7287a + 1);
        int[] iArr = this.f7288b;
        int i10 = this.f7287a;
        iArr[i10] = i9;
        this.f7289c[i10] = obj;
        this.f7287a = i10 + 1;
    }

    public final void d(t0 t0Var) {
        if (this.f7287a == 0) {
            return;
        }
        t0Var.getClass();
        for (int i9 = 0; i9 < this.f7287a; i9++) {
            int i10 = this.f7288b[i9];
            Object obj = this.f7289c[i9];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                ((C0517k) t0Var).f7277a.a0(i11, ((Long) obj).longValue());
            } else if (i12 == 1) {
                ((C0517k) t0Var).f7277a.N(i11, ((Long) obj).longValue());
            } else if (i12 == 2) {
                ((C0517k) t0Var).f7277a.J(i11, (AbstractC0513g) obj);
            } else if (i12 == 3) {
                AbstractC0516j abstractC0516j = ((C0517k) t0Var).f7277a;
                abstractC0516j.X(i11, 3);
                ((n0) obj).d(t0Var);
                abstractC0516j.X(i11, 4);
            } else {
                if (i12 != 5) {
                    throw new RuntimeException(C0531z.b());
                }
                ((C0517k) t0Var).f7277a.L(i11, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        int i9 = this.f7287a;
        if (i9 == n0Var.f7287a) {
            int[] iArr = this.f7288b;
            int[] iArr2 = n0Var.f7288b;
            for (int i10 = 0; i10 < i9; i10++) {
                if (iArr[i10] == iArr2[i10]) {
                }
            }
            Object[] objArr = this.f7289c;
            Object[] objArr2 = n0Var.f7289c;
            int i11 = this.f7287a;
            for (int i12 = 0; i12 < i11; i12++) {
                if (objArr[i12].equals(objArr2[i12])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i9 = this.f7287a;
        int i10 = (527 + i9) * 31;
        int[] iArr = this.f7288b;
        int iHashCode = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i9; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = (i10 + i11) * 31;
        Object[] objArr = this.f7289c;
        int i14 = this.f7287a;
        for (int i15 = 0; i15 < i14; i15++) {
            iHashCode = (iHashCode * 31) + objArr[i15].hashCode();
        }
        return i13 + iHashCode;
    }

    public n0(int i9, int[] iArr, Object[] objArr, boolean z8) {
        this.f7290d = -1;
        this.f7287a = i9;
        this.f7288b = iArr;
        this.f7289c = objArr;
        this.f7291e = z8;
    }
}
