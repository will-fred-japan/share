package p145s5;

/* JADX INFO: compiled from: Arrangement.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f21256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f21259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f21260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f21261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f21262h;

    /* JADX WARN: Code duplicated, block: B:43:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ca  */
    public a(int i9, float f6, float f9, float f10, int i10, float f11, int i11, float f12, int i12, float f13) {
        float fAbs;
        this.f21255a = i9;
        float fM = p027d5.a.m(f6, f9, f10);
        this.f21256b = fM;
        this.f21257c = i10;
        this.f21259e = f11;
        this.f21258d = i11;
        this.f21260f = f12;
        this.f21261g = i12;
        float f14 = i12;
        float f15 = (f11 * i11) + (f12 * f14);
        float f16 = i10;
        float f17 = f13 - ((fM * f16) + f15);
        if (i10 > 0 && f17 > 0.0f) {
            this.f21256b = Math.min(f17 / f16, f10 - fM) + fM;
        } else if (i10 > 0 && f17 < 0.0f) {
            this.f21256b = Math.max(f17 / f16, f9 - fM) + fM;
        }
        int i13 = this.f21257c;
        float f18 = i13 > 0 ? this.f21256b : 0.0f;
        this.f21256b = f18;
        int i14 = this.f21258d;
        float f19 = i14;
        float f20 = f19 / 2.0f;
        float f21 = (f13 - ((i13 + f20) * (i13 > 0 ? f18 : 0.0f))) / (f20 + f14);
        this.f21260f = f21;
        float f22 = (f18 + f21) / 2.0f;
        this.f21259e = f22;
        if (i14 > 0 && f21 != f12) {
            float f23 = (f12 - f21) * f14;
            float fMin = Math.min(Math.abs(f23), f22 * 0.1f * f19);
            if (f23 > 0.0f) {
                this.f21259e -= fMin / this.f21258d;
                this.f21260f = (fMin / f14) + this.f21260f;
            } else {
                this.f21259e = (fMin / this.f21258d) + this.f21259e;
                this.f21260f -= fMin / f14;
            }
        }
        if (i12 > 0 && this.f21257c > 0 && this.f21258d > 0) {
            float f24 = this.f21260f;
            float f25 = this.f21259e;
            if (f24 <= f25 || f25 <= this.f21256b) {
                fAbs = Float.MAX_VALUE;
            } else {
                fAbs = i9 * Math.abs(f12 - this.f21260f);
            }
        } else if (i12 <= 0 || this.f21257c <= 0 || this.f21260f > this.f21256b) {
            fAbs = i9 * Math.abs(f12 - this.f21260f);
        } else {
            fAbs = Float.MAX_VALUE;
        }
        this.f21262h = fAbs;
    }

    public static a a(float f6, float f9, float f10, float f11, int[] iArr, float f12, int[] iArr2, float f13, int[] iArr3) {
        a aVar = null;
        int i9 = 1;
        for (int i10 : iArr3) {
            int length = iArr2.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = iArr2[i11];
                int length2 = iArr.length;
                int i13 = 0;
                while (i13 < length2) {
                    int i14 = length;
                    int i15 = i11;
                    int i16 = i9;
                    int i17 = length2;
                    int i18 = i13;
                    a aVar2 = new a(i16, f9, f10, f11, iArr[i13], f12, i12, f13, i10, f6);
                    float f14 = aVar2.f21262h;
                    if (aVar == null || f14 < aVar.f21262h) {
                        if (f14 == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    int i19 = i16 + 1;
                    i13 = i18 + 1;
                    i11 = i15;
                    i9 = i19;
                    length = i14;
                    length2 = i17;
                }
                i11++;
                i9 = i9;
                length = length;
            }
        }
        return aVar;
    }

    public final String toString() {
        return "Arrangement [priority=" + this.f21255a + ", smallCount=" + this.f21257c + ", smallSize=" + this.f21256b + ", mediumCount=" + this.f21258d + ", mediumSize=" + this.f21259e + ", largeCount=" + this.f21261g + ", largeSize=" + this.f21260f + ", cost=" + this.f21262h + "]";
    }
}
