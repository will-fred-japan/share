package io.flutter.plugin.editing;

/* JADX INFO: compiled from: TextInputPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f19568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double[] f19569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double[] f19570c;

    public g(boolean z8, double[] dArr, double[] dArr2) {
        this.f19568a = z8;
        this.f19569b = dArr;
        this.f19570c = dArr2;
    }

    public final void a(double d9, double d10) {
        boolean z8 = this.f19568a;
        double[] dArr = this.f19569b;
        double d11 = 1.0d;
        if (!z8) {
            d11 = 1.0d / (((dArr[7] * d10) + (dArr[3] * d9)) + dArr[15]);
        }
        double d12 = ((dArr[4] * d10) + (dArr[0] * d9) + dArr[12]) * d11;
        double d13 = ((dArr[5] * d10) + (dArr[1] * d9) + dArr[13]) * d11;
        double[] dArr2 = this.f19570c;
        if (d12 < dArr2[0]) {
            dArr2[0] = d12;
        } else if (d12 > dArr2[1]) {
            dArr2[1] = d12;
        }
        if (d13 < dArr2[2]) {
            dArr2[2] = d13;
        } else if (d13 > dArr2[3]) {
            dArr2[3] = d13;
        }
    }
}
