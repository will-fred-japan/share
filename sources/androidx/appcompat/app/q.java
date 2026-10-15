package androidx.appcompat.app;

/* JADX INFO: compiled from: TwilightCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static q f5999d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6002c;

    public final void a(long j, double d9, double d10) {
        float f6 = (j - 946728000000L) / 8.64E7f;
        float f9 = (0.01720197f * f6) + 6.24006f;
        double d11 = f9;
        double dSin = (Math.sin(f9 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * f9) * 3.4906598739326E-4d) + (Math.sin(d11) * 0.03341960161924362d) + d11 + 1.796593063d + 3.141592653589793d;
        double d12 = (-d10) / 360.0d;
        double dSin2 = (Math.sin(2.0d * dSin) * (-0.0069d)) + (Math.sin(d11) * 0.0053d) + ((double) (Math.round(((double) (f6 - 9.0E-4f)) - d12) + 9.0E-4f)) + d12;
        double dAsin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(dSin));
        double d13 = 0.01745329238474369d * d9;
        double dSin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(dAsin) * Math.sin(d13))) / (Math.cos(dAsin) * Math.cos(d13));
        if (dSin3 >= 1.0d) {
            this.f6002c = 1;
            this.f6000a = -1L;
            this.f6001b = -1L;
        } else {
            if (dSin3 <= -1.0d) {
                this.f6002c = 0;
                this.f6000a = -1L;
                this.f6001b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin3) / 6.283185307179586d);
            this.f6000a = Math.round((dSin2 + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dSin2 - dAcos) * 8.64E7d) + 946728000000L;
            this.f6001b = jRound;
            if (jRound >= j || this.f6000a <= j) {
                this.f6002c = 1;
            } else {
                this.f6002c = 0;
            }
        }
    }
}
