package J;

import android.graphics.Color;

/* JADX INFO: compiled from: CamColor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f2599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f2600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f2601f;

    public a(float f6, float f9, float f10, float f11, float f12, float f13) {
        this.f2596a = f6;
        this.f2597b = f9;
        this.f2598c = f10;
        this.f2599d = f11;
        this.f2600e = f12;
        this.f2601f = f13;
    }

    public static a a(int i9) {
        l lVar = l.f2636k;
        float fB = b.b(Color.red(i9));
        float fB2 = b.b(Color.green(i9));
        float fB3 = b.b(Color.blue(i9));
        float[][] fArr = b.f2605d;
        float[] fArr2 = fArr[0];
        float f6 = (fArr2[2] * fB3) + (fArr2[1] * fB2) + (fArr2[0] * fB);
        float[] fArr3 = fArr[1];
        float f9 = (fArr3[2] * fB3) + (fArr3[1] * fB2) + (fArr3[0] * fB);
        float[] fArr4 = fArr[2];
        float f10 = (fB3 * fArr4[2]) + (fB2 * fArr4[1]) + (fB * fArr4[0]);
        float[][] fArr5 = b.f2602a;
        float[] fArr6 = fArr5[0];
        float f11 = (fArr6[2] * f10) + (fArr6[1] * f9) + (fArr6[0] * f6);
        float[] fArr7 = fArr5[1];
        float f12 = (fArr7[2] * f10) + (fArr7[1] * f9) + (fArr7[0] * f6);
        float[] fArr8 = fArr5[2];
        float f13 = (f10 * fArr8[2]) + (f9 * fArr8[1]) + (f6 * fArr8[0]);
        float[] fArr9 = lVar.f2643g;
        float f14 = fArr9[0] * f11;
        float f15 = fArr9[1] * f12;
        float f16 = fArr9[2] * f13;
        float fAbs = Math.abs(f14);
        float f17 = lVar.f2644h;
        float fPow = (float) Math.pow(((double) (fAbs * f17)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f15) * f17)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f16) * f17)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f14) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f15) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f16) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d9 = fSignum3;
        float f18 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d9)) / 11.0f;
        float f19 = ((float) (((double) (fSignum + fSignum2)) - (d9 * 2.0d))) / 9.0f;
        float f20 = fSignum2 * 20.0f;
        float f21 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f20)) / 20.0f;
        float f22 = (((fSignum * 40.0f) + f20) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f19, f18)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f23 = fAtan2;
        float f24 = (3.1415927f * f23) / 180.0f;
        float f25 = f22 * lVar.f2638b;
        float f26 = lVar.f2637a;
        float f27 = lVar.f2640d;
        float fPow4 = ((float) Math.pow(f25 / f26, lVar.j * f27)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f28 = f26 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, lVar.f2642f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) f23) < 20.14d ? f23 + 360.0f : f23)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * lVar.f2641e) * lVar.f2639c) * ((float) Math.sqrt((f19 * f19) + (f18 * f18)))) / (f21 + 0.305f), 0.9d));
        float fSqrt = fPow5 * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        float f29 = lVar.f2645i * fSqrt;
        Math.sqrt((fPow5 * f27) / f28);
        float f30 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f29 * 0.0228f) + 1.0f)) * 43.85965f;
        double d10 = f24;
        return new a(f23, fSqrt, fPow4, f30, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    public static a b(float f6, float f9, float f10) {
        l lVar = l.f2636k;
        float f11 = lVar.f2640d;
        double d9 = ((double) f6) / 100.0d;
        Math.sqrt(d9);
        float f12 = lVar.f2637a + 4.0f;
        float f13 = lVar.f2645i * f9;
        Math.sqrt(((f9 / ((float) Math.sqrt(d9))) * lVar.f2640d) / f12);
        float f14 = (1.7f * f6) / ((0.007f * f6) + 1.0f);
        float fLog = ((float) Math.log((((double) f13) * 0.0228d) + 1.0d)) * 43.85965f;
        double d10 = (3.1415927f * f10) / 180.0f;
        return new a(f10, f9, f6, f14, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    public final int c(l lVar) {
        float fSqrt;
        float f6 = this.f2597b;
        double d9 = f6;
        float f9 = this.f2598c;
        if (d9 != 0.0d) {
            double d10 = f9;
            if (d10 == 0.0d) {
                fSqrt = 0.0f;
            } else {
                fSqrt = f6 / ((float) Math.sqrt(d10 / 100.0d));
            }
        } else {
            fSqrt = 0.0f;
        }
        float fPow = (float) Math.pow(((double) fSqrt) / Math.pow(1.64d - Math.pow(0.29d, lVar.f2642f), 0.73d), 1.1111111111111112d);
        double d11 = (this.f2596a * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + d11) + 3.8d)) * 0.25f;
        float fPow2 = lVar.f2637a * ((float) Math.pow(((double) f9) / 100.0d, (1.0d / ((double) lVar.f2640d)) / ((double) lVar.j)));
        float f10 = fCos * 3846.1538f * lVar.f2641e * lVar.f2639c;
        float f11 = fPow2 / lVar.f2638b;
        float fSin = (float) Math.sin(d11);
        float fCos2 = (float) Math.cos(d11);
        float f12 = (((0.305f + f11) * 23.0f) * fPow) / (((fPow * 108.0f) * fSin) + (((11.0f * fPow) * fCos2) + (f10 * 23.0f)));
        float f13 = fCos2 * f12;
        float f14 = f12 * fSin;
        float f15 = f11 * 460.0f;
        float f16 = ((288.0f * f14) + ((451.0f * f13) + f15)) / 1403.0f;
        float f17 = ((f15 - (891.0f * f13)) - (261.0f * f14)) / 1403.0f;
        float f18 = ((f15 - (f13 * 220.0f)) - (f14 * 6300.0f)) / 1403.0f;
        float fMax = (float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16))));
        float fSignum = Math.signum(f16);
        float f19 = 100.0f / lVar.f2644h;
        float fPow3 = fSignum * f19 * ((float) Math.pow(fMax, 2.380952380952381d));
        float fSignum2 = Math.signum(f17) * f19 * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f17)) * 27.13d) / (400.0d - ((double) Math.abs(f17)))), 2.380952380952381d));
        float fSignum3 = Math.signum(f18) * f19 * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f18)) * 27.13d) / (400.0d - ((double) Math.abs(f18)))), 2.380952380952381d));
        float[] fArr = lVar.f2643g;
        float f20 = fPow3 / fArr[0];
        float f21 = fSignum2 / fArr[1];
        float f22 = fSignum3 / fArr[2];
        float[][] fArr2 = b.f2603b;
        float[] fArr3 = fArr2[0];
        float f23 = (fArr3[2] * f22) + (fArr3[1] * f21) + (fArr3[0] * f20);
        float[] fArr4 = fArr2[1];
        float f24 = (fArr4[2] * f22) + (fArr4[1] * f21) + (fArr4[0] * f20);
        float[] fArr5 = fArr2[2];
        return K.a.a(f23, f24, (f22 * fArr5[2]) + (f21 * fArr5[1]) + (f20 * fArr5[0]));
    }
}
