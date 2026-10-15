package O7;

/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes2.dex */
public class k extends p199z2.b {
    public static float X(float f6, float f9, float f10) {
        if (f9 <= f10) {
            if (f6 < f9) {
                return f9;
            }
            return f6 > f10 ? f10 : f6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f10 + " is less than minimum " + f9 + '.');
    }

    public static int Y(int i9, int i10, int i11) {
        if (i10 <= i11) {
            if (i9 < i10) {
                return i10;
            }
            return i9 > i11 ? i11 : i9;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i11 + " is less than minimum " + i10 + '.');
    }

    public static f Z(f fVar, int i9) {
        kotlin.jvm.internal.k.e(fVar, "<this>");
        boolean z8 = i9 > 0;
        Integer numValueOf = Integer.valueOf(i9);
        if (z8) {
            if (fVar.f3587c <= 0) {
                i9 = -i9;
            }
            return new f(fVar.f3585a, fVar.f3586b, i9);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
    }

    public static h a0(int i9, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new h(i9, i10 - 1, 1);
        }
        h hVar = h.f3592d;
        return h.f3592d;
    }
}
