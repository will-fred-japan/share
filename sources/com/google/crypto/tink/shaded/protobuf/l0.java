package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;

/* JADX INFO: compiled from: UnknownFieldSetLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l0 f14119f = new l0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f14121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f14122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14124e;

    public l0() {
        this(0, new int[8], new Object[8], true);
    }

    public final void a(int i9) {
        int[] iArr = this.f14121b;
        if (i9 > iArr.length) {
            int i10 = this.f14120a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i9) {
                i9 = i11;
            }
            if (i9 < 8) {
                i9 = 8;
            }
            this.f14121b = Arrays.copyOf(iArr, i9);
            this.f14122c = Arrays.copyOf(this.f14122c, i9);
        }
    }

    public final int b() {
        int iC;
        int iE;
        int iC2;
        int i9 = this.f14123d;
        if (i9 != -1) {
            return i9;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f14120a; i11++) {
            int i12 = this.f14121b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f14122c[i11]).getClass();
                    iC2 = AbstractC0572k.C(i13) + 8;
                } else if (i14 == 2) {
                    iC2 = AbstractC0572k.w(i13, (AbstractC0569h) this.f14122c[i11]);
                } else if (i14 == 3) {
                    iC = AbstractC0572k.C(i13) * 2;
                    iE = ((l0) this.f14122c[i11]).b();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(C0586z.c());
                    }
                    ((Integer) this.f14122c[i11]).getClass();
                    iC2 = AbstractC0572k.C(i13) + 4;
                }
                i10 = iC2 + i10;
            } else {
                long jLongValue = ((Long) this.f14122c[i11]).longValue();
                iC = AbstractC0572k.C(i13);
                iE = AbstractC0572k.E(jLongValue);
            }
            i10 = iE + iC + i10;
        }
        this.f14123d = i10;
        return i10;
    }

    public final void c(int i9, Object obj) {
        if (!this.f14124e) {
            throw new UnsupportedOperationException();
        }
        a(this.f14120a + 1);
        int[] iArr = this.f14121b;
        int i10 = this.f14120a;
        iArr[i10] = i9;
        this.f14122c[i10] = obj;
        this.f14120a = i10 + 1;
    }

    public final void d(r0 r0Var) throws AbstractC0572k.b {
        if (this.f14120a == 0) {
            return;
        }
        r0Var.getClass();
        for (int i9 = 0; i9 < this.f14120a; i9++) {
            int i10 = this.f14121b[i9];
            Object obj = this.f14122c[i9];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                ((C0573l) r0Var).f14118a.T(i11, ((Long) obj).longValue());
            } else if (i12 == 1) {
                ((C0573l) r0Var).f14118a.L(i11, ((Long) obj).longValue());
            } else if (i12 == 2) {
                ((C0573l) r0Var).f14118a.I(i11, (AbstractC0569h) obj);
            } else if (i12 == 3) {
                AbstractC0572k.a aVar = ((C0573l) r0Var).f14118a;
                aVar.Q(i11, 3);
                ((l0) obj).d(r0Var);
                aVar.Q(i11, 4);
            } else {
                if (i12 != 5) {
                    throw new RuntimeException(C0586z.c());
                }
                ((C0573l) r0Var).f14118a.J(i11, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        int i9 = this.f14120a;
        if (i9 == l0Var.f14120a) {
            int[] iArr = this.f14121b;
            int[] iArr2 = l0Var.f14121b;
            for (int i10 = 0; i10 < i9; i10++) {
                if (iArr[i10] == iArr2[i10]) {
                }
            }
            Object[] objArr = this.f14122c;
            Object[] objArr2 = l0Var.f14122c;
            int i11 = this.f14120a;
            for (int i12 = 0; i12 < i11; i12++) {
                if (objArr[i12].equals(objArr2[i12])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i9 = this.f14120a;
        int i10 = (527 + i9) * 31;
        int[] iArr = this.f14121b;
        int iHashCode = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i9; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = (i10 + i11) * 31;
        Object[] objArr = this.f14122c;
        int i14 = this.f14120a;
        for (int i15 = 0; i15 < i14; i15++) {
            iHashCode = (iHashCode * 31) + objArr[i15].hashCode();
        }
        return i13 + iHashCode;
    }

    public l0(int i9, int[] iArr, Object[] objArr, boolean z8) {
        this.f14123d = -1;
        this.f14120a = i9;
        this.f14121b = iArr;
        this.f14122c = objArr;
        this.f14124e = z8;
    }
}
