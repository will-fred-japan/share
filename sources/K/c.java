package K;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: compiled from: PathParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static float[] a(float[] fArr, int i9) {
        if (i9 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i9, length);
        float[] fArr2 = new float[i9];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:41:0x0091  */
    /* JADX WARN: Code duplicated, block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d7 A[SYNTHETIC] */
    public static a[] b(String str) {
        int i9;
        String strTrim;
        float[] fArrA;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i12 < str.length()) {
            while (i12 < str.length()) {
                char cCharAt = str.charAt(i12);
                if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                    if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                        continue;
                    } else if (cCharAt != 'e' && cCharAt != 'E') {
                        strTrim = str.substring(i11, i12).trim();
                        if (strTrim.isEmpty()) {
                            if (strTrim.charAt(i10) != 'z' || strTrim.charAt(i10) == 'Z') {
                                fArrA = new float[i10];
                            } else {
                                try {
                                    float[] fArr = new float[strTrim.length()];
                                    int length = strTrim.length();
                                    int i13 = i10;
                                    int i14 = 1;
                                    while (i14 < length) {
                                        int i15 = i10;
                                        int i16 = i15;
                                        int i17 = i16;
                                        int i18 = i17;
                                        for (int i19 = i14; i19 < strTrim.length(); i19++) {
                                            char cCharAt2 = strTrim.charAt(i19);
                                            if (cCharAt2 == ' ') {
                                                i15 = 0;
                                                i17 = 1;
                                            } else if (cCharAt2 != 'E' && cCharAt2 != 'e') {
                                                switch (cCharAt2) {
                                                    case ',':
                                                        i15 = 0;
                                                        i17 = 1;
                                                        break;
                                                    case '-':
                                                        if (i19 == i14 || i15 != 0) {
                                                            i15 = 0;
                                                        } else {
                                                            i15 = 0;
                                                            i17 = 1;
                                                            i18 = 1;
                                                        }
                                                        break;
                                                    case '.':
                                                        if (i16 == 0) {
                                                            i15 = 0;
                                                            i16 = 1;
                                                        } else {
                                                            i15 = 0;
                                                            i17 = 1;
                                                            i18 = 1;
                                                        }
                                                        break;
                                                    default:
                                                        i15 = 0;
                                                        break;
                                                }
                                            } else {
                                                i15 = 1;
                                            }
                                            if (i17 != 0) {
                                                if (i14 < i19) {
                                                    fArr[i13] = Float.parseFloat(strTrim.substring(i14, i19));
                                                    i13++;
                                                }
                                                if (i18 != 0) {
                                                    i14 = i19;
                                                } else {
                                                    i14 = i19 + 1;
                                                }
                                                i10 = 0;
                                            }
                                        }
                                        if (i14 < i19) {
                                            fArr[i13] = Float.parseFloat(strTrim.substring(i14, i19));
                                            i13++;
                                        }
                                        if (i18 != 0) {
                                            i14 = i19;
                                        } else {
                                            i14 = i19 + 1;
                                        }
                                        i10 = 0;
                                    }
                                    fArrA = a(fArr, i13);
                                    i10 = 0;
                                } catch (NumberFormatException e9) {
                                    throw new RuntimeException(A.a.i("error in parsing \"", strTrim, "\""), e9);
                                }
                            }
                            arrayList.add(new a(strTrim.charAt(i10), fArrA));
                        }
                        i11 = i12;
                        i12++;
                        i10 = 0;
                    }
                } else if (cCharAt != 'e') {
                    continue;
                }
                i12++;
            }
            strTrim = str.substring(i11, i12).trim();
            if (strTrim.isEmpty()) {
                if (strTrim.charAt(i10) != 'z') {
                    fArrA = new float[i10];
                } else {
                    fArrA = new float[i10];
                }
                arrayList.add(new a(strTrim.charAt(i10), fArrA));
            }
            i11 = i12;
            i12++;
            i10 = 0;
        }
        if (i12 - i11 != 1 || i11 >= str.length()) {
            i9 = 0;
        } else {
            i9 = 0;
            arrayList.add(new a(str.charAt(i11), new float[0]));
        }
        return (a[]) arrayList.toArray(new a[i9]);
    }

    public static a[] c(a[] aVarArr) {
        a[] aVarArr2 = new a[aVarArr.length];
        for (int i9 = 0; i9 < aVarArr.length; i9++) {
            aVarArr2[i9] = new a(aVarArr[i9]);
        }
        return aVarArr2;
    }

    /* JADX INFO: compiled from: PathParser.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public char f2748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f2749b;

        public a(char c5, float[] fArr) {
            this.f2748a = c5;
            this.f2749b = fArr;
        }

        public static void a(Path path, float f6, float f9, float f10, float f11, float f12, float f13, float f14, boolean z8, boolean z9) {
            double d9;
            double d10;
            double radians = Math.toRadians(f14);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d11 = f6;
            double d12 = f9;
            double d13 = f12;
            double d14 = ((d12 * dSin) + (d11 * dCos)) / d13;
            double d15 = f13;
            double d16 = ((d12 * dCos) + (((double) (-f6)) * dSin)) / d15;
            double d17 = f11;
            double d18 = ((d17 * dSin) + (((double) f10) * dCos)) / d13;
            double d19 = ((d17 * dCos) + (((double) (-f10)) * dSin)) / d15;
            double d20 = d14 - d18;
            double d21 = d16 - d19;
            double d22 = (d14 + d18) / 2.0d;
            double d23 = (d16 + d19) / 2.0d;
            double d24 = (d21 * d21) + (d20 * d20);
            if (d24 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d25 = (1.0d / d24) - 0.25d;
            if (d25 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d24);
                float fSqrt = (float) (Math.sqrt(d24) / 1.99999d);
                a(path, f6, f9, f10, f11, f12 * fSqrt, fSqrt * f13, f14, z8, z9);
                return;
            }
            double dSqrt = Math.sqrt(d25);
            double d26 = dSqrt * d20;
            double d27 = dSqrt * d21;
            if (z8 == z9) {
                d9 = d22 - d27;
                d10 = d23 + d26;
            } else {
                d9 = d22 + d27;
                d10 = d23 - d26;
            }
            double dAtan2 = Math.atan2(d16 - d10, d14 - d9);
            double dAtan3 = Math.atan2(d19 - d10, d18 - d9) - dAtan2;
            if (z9 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d28 = d9 * d13;
            double d29 = d10 * d15;
            double d30 = (d28 * dCos) - (d29 * dSin);
            double d31 = (d29 * dCos) + (d28 * dSin);
            int iCeil = (int) Math.ceil(Math.abs((dAtan3 * 4.0d) / 3.141592653589793d));
            double dCos2 = Math.cos(radians);
            double dSin2 = Math.sin(radians);
            double dCos3 = Math.cos(dAtan2);
            double dSin3 = Math.sin(dAtan2);
            double d32 = -d13;
            double d33 = d32 * dCos2;
            double d34 = d15 * dSin2;
            double d35 = (d33 * dSin3) - (d34 * dCos3);
            double d36 = d32 * dSin2;
            double d37 = d15 * dCos2;
            double d38 = dAtan3 / ((double) iCeil);
            double d39 = (dCos3 * d37) + (dSin3 * d36);
            double d40 = d11;
            double d41 = d12;
            int i9 = 0;
            double d42 = dAtan2;
            while (i9 < iCeil) {
                double d43 = d42 + d38;
                double dSin4 = Math.sin(d43);
                double dCos4 = Math.cos(d43);
                int i10 = iCeil;
                double d44 = (((d13 * dCos2) * dCos4) + d30) - (d34 * dSin4);
                double d45 = (d37 * dSin4) + (d13 * dSin2 * dCos4) + d31;
                double d46 = (d33 * dSin4) - (d34 * dCos4);
                double d47 = (dCos4 * d37) + (dSin4 * d36);
                double d48 = d43 - d42;
                double dTan = Math.tan(d48 / 2.0d);
                double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d48)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d35 * dSqrt2) + d40), (float) ((d39 * dSqrt2) + d41), (float) (d44 - (dSqrt2 * d46)), (float) (d45 - (dSqrt2 * d47)), (float) d44, (float) d45);
                i9++;
                d41 = d45;
                dCos2 = dCos2;
                d36 = d36;
                d42 = d43;
                d39 = d47;
                d40 = d44;
                iCeil = i10;
                d35 = d46;
                d38 = d38;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated
        public static void b(a[] aVarArr, Path path) {
            int i9;
            int i10;
            float f6;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float[] fArr = new float[6];
            int length = aVarArr.length;
            char c5 = 'm';
            int i11 = 0;
            char c9 = 'm';
            int i12 = 0;
            while (i12 < length) {
                a aVar = aVarArr[i12];
                char c10 = aVar.f2748a;
                float f20 = fArr[i11];
                float f21 = fArr[1];
                float f22 = fArr[2];
                float f23 = fArr[3];
                float f24 = fArr[4];
                float f25 = fArr[5];
                switch (c10) {
                    case 'A':
                    case 'a':
                        i9 = 7;
                        break;
                    case 'C':
                    case 'c':
                        i9 = 6;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i9 = 1;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i9 = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path.moveTo(f24, f25);
                        f20 = f24;
                        f22 = f20;
                        f21 = f25;
                        f23 = f21;
                    default:
                        i9 = 2;
                        break;
                }
                float f26 = f21;
                float f27 = f24;
                float f28 = f25;
                float f29 = f20;
                int i13 = i11;
                while (true) {
                    float[] fArr2 = aVar.f2749b;
                    if (i13 < fArr2.length) {
                        int i14 = i11;
                        if (c10 == 'A') {
                            i10 = i13;
                            aVar = aVar;
                            float f30 = f29;
                            float f31 = f26;
                            i12 = i12;
                            c10 = c10;
                            int i15 = i10 + 5;
                            int i16 = i10 + 6;
                            a(path, f30, f31, fArr2[i15], fArr2[i16], fArr2[i10], fArr2[i10 + 1], fArr2[i10 + 2], fArr2[i10 + 3] != 0.0f ? 1 : i14, fArr2[i10 + 4] != 0.0f ? 1 : i14);
                            f22 = fArr2[i15];
                            f6 = fArr2[i16];
                            f23 = f6;
                            f9 = f22;
                        } else if (c10 == 'C') {
                            i10 = i13;
                            i12 = i12;
                            aVar = aVar;
                            c10 = c10;
                            int i17 = i10 + 2;
                            int i18 = i10 + 3;
                            int i19 = i10 + 4;
                            int i20 = i10 + 5;
                            path.cubicTo(fArr2[i10], fArr2[i10 + 1], fArr2[i17], fArr2[i18], fArr2[i19], fArr2[i20]);
                            float f32 = fArr2[i19];
                            float f33 = fArr2[i20];
                            f22 = fArr2[i17];
                            f23 = fArr2[i18];
                            f6 = f33;
                            f9 = f32;
                        } else if (c10 != 'H') {
                            if (c10 == 'Q') {
                                i10 = i13;
                                int i21 = i10 + 1;
                                int i22 = i10 + 2;
                                int i23 = i10 + 3;
                                path.quadTo(fArr2[i10], fArr2[i21], fArr2[i22], fArr2[i23]);
                                f10 = fArr2[i10];
                                float f34 = fArr2[i21];
                                f11 = fArr2[i22];
                                f23 = f34;
                                f6 = fArr2[i23];
                            } else if (c10 == 'V') {
                                i10 = i13;
                                i12 = i12;
                                aVar = aVar;
                                f9 = f29;
                                c10 = c10;
                                path.lineTo(f9, fArr2[i10]);
                                f6 = fArr2[i10];
                            } else if (c10 != 'a') {
                                if (c10 == 'c') {
                                    i10 = i13;
                                    int i24 = i10 + 2;
                                    int i25 = i10 + 3;
                                    int i26 = i10 + 4;
                                    int i27 = i10 + 5;
                                    path.rCubicTo(fArr2[i10], fArr2[i10 + 1], fArr2[i24], fArr2[i25], fArr2[i26], fArr2[i27]);
                                    float f35 = fArr2[i24] + f29;
                                    float f36 = f26 + fArr2[i25];
                                    f29 += fArr2[i26];
                                    f26 += fArr2[i27];
                                    f22 = f35;
                                    f23 = f36;
                                } else if (c10 != 'h') {
                                    if (c10 != 'q') {
                                        if (c10 != 'v') {
                                            if (c10 != 'L') {
                                                if (c10 == 'M') {
                                                    i10 = i13;
                                                    f9 = fArr2[i10];
                                                    f6 = fArr2[i10 + 1];
                                                    if (i10 > 0) {
                                                        path.lineTo(f9, f6);
                                                    } else {
                                                        path.moveTo(f9, f6);
                                                        f27 = f9;
                                                        f28 = f6;
                                                    }
                                                } else if (c10 == 'S') {
                                                    i10 = i13;
                                                    if (c9 == 'c' || c9 == 's' || c9 == 'C' || c9 == 'S') {
                                                        f29 = (f29 * 2.0f) - f22;
                                                        f26 = (f26 * 2.0f) - f23;
                                                    }
                                                    float f37 = f29;
                                                    float f38 = f26;
                                                    int i28 = i10 + 1;
                                                    int i29 = i10 + 2;
                                                    int i30 = i10 + 3;
                                                    path.cubicTo(f37, f38, fArr2[i10], fArr2[i28], fArr2[i29], fArr2[i30]);
                                                    f10 = fArr2[i10];
                                                    float f39 = fArr2[i28];
                                                    f11 = fArr2[i29];
                                                    f23 = f39;
                                                    f6 = fArr2[i30];
                                                } else if (c10 == 'T') {
                                                    i10 = i13;
                                                    if (c9 == 'q' || c9 == 't' || c9 == 'Q' || c9 == 'T') {
                                                        f29 = (f29 * 2.0f) - f22;
                                                        f26 = (f26 * 2.0f) - f23;
                                                    }
                                                    float f40 = f26;
                                                    float f41 = fArr2[i10];
                                                    int i31 = i10 + 1;
                                                    path.quadTo(f29, f40, f41, fArr2[i31]);
                                                    f23 = f40;
                                                    f9 = fArr2[i10];
                                                    f6 = fArr2[i31];
                                                    aVar = aVar;
                                                    f22 = f29;
                                                } else if (c10 == 'l') {
                                                    i10 = i13;
                                                    int i32 = i10 + 1;
                                                    path.rLineTo(fArr2[i10], fArr2[i32]);
                                                    f29 += fArr2[i10];
                                                    f15 = fArr2[i32];
                                                } else if (c10 != c5) {
                                                    if (c10 == 's') {
                                                        if (c9 == 'c' || c9 == 's' || c9 == 'C' || c9 == 'S') {
                                                            f16 = f26 - f23;
                                                            f17 = f29 - f22;
                                                        } else {
                                                            f17 = 0.0f;
                                                            f16 = 0.0f;
                                                        }
                                                        int i33 = i13 + 1;
                                                        int i34 = i13 + 2;
                                                        int i35 = i13 + 3;
                                                        i10 = i13;
                                                        path.rCubicTo(f17, f16, fArr2[i13], fArr2[i33], fArr2[i34], fArr2[i35]);
                                                        f12 = fArr2[i10] + f29;
                                                        f13 = f26 + fArr2[i33];
                                                        f29 += fArr2[i34];
                                                        f14 = fArr2[i35];
                                                    } else if (c10 != 't') {
                                                        i10 = i13;
                                                    } else {
                                                        if (c9 == 'q' || c9 == 't' || c9 == 'Q' || c9 == 'T') {
                                                            f18 = f29 - f22;
                                                            f19 = f26 - f23;
                                                        } else {
                                                            f19 = 0.0f;
                                                            f18 = 0.0f;
                                                        }
                                                        int i36 = i13 + 1;
                                                        path.rQuadTo(f18, f19, fArr2[i13], fArr2[i36]);
                                                        float f42 = f18 + f29;
                                                        float f43 = f26 + f19;
                                                        float f44 = f29 + fArr2[i13];
                                                        f26 += fArr2[i36];
                                                        f23 = f43;
                                                        i10 = i13;
                                                        f9 = f44;
                                                        f22 = f42;
                                                    }
                                                    f6 = f26;
                                                } else {
                                                    i10 = i13;
                                                    float f45 = fArr2[i10];
                                                    f29 += f45;
                                                    float f46 = fArr2[i10 + 1];
                                                    f26 += f46;
                                                    if (i10 > 0) {
                                                        path.rLineTo(f45, f46);
                                                    } else {
                                                        path.rMoveTo(f45, f46);
                                                        aVar = aVar;
                                                        f9 = f29;
                                                        f27 = f9;
                                                        f6 = f26;
                                                        f28 = f6;
                                                    }
                                                }
                                                c10 = c10;
                                            } else {
                                                i10 = i13;
                                                int i37 = i10 + 1;
                                                path.lineTo(fArr2[i10], fArr2[i37]);
                                                f9 = fArr2[i10];
                                                f6 = fArr2[i37];
                                            }
                                            aVar = aVar;
                                            c10 = c10;
                                        } else {
                                            i10 = i13;
                                            path.rLineTo(0.0f, fArr2[i10]);
                                            f15 = fArr2[i10];
                                        }
                                        f26 += f15;
                                    } else {
                                        i10 = i13;
                                        int i38 = i10 + 1;
                                        int i39 = i10 + 2;
                                        int i40 = i10 + 3;
                                        path.rQuadTo(fArr2[i10], fArr2[i38], fArr2[i39], fArr2[i40]);
                                        f12 = fArr2[i10] + f29;
                                        f13 = f26 + fArr2[i38];
                                        f29 += fArr2[i39];
                                        f14 = fArr2[i40];
                                    }
                                    f26 += f14;
                                    f22 = f12;
                                    f23 = f13;
                                } else {
                                    i10 = i13;
                                    path.rLineTo(fArr2[i10], 0.0f);
                                    f29 += fArr2[i10];
                                }
                                f9 = f29;
                                f6 = f26;
                                c10 = c10;
                            } else {
                                i10 = i13;
                                int i41 = i10 + 5;
                                float f47 = fArr2[i41] + f29;
                                int i42 = i10 + 6;
                                float f48 = fArr2[i42] + f26;
                                aVar = aVar;
                                float f49 = f29;
                                c10 = c10;
                                float f50 = f26;
                                i12 = i12;
                                a(path, f49, f50, f47, f48, fArr2[i10], fArr2[i10 + 1], fArr2[i10 + 2], fArr2[i10 + 3] != 0.0f ? 1 : i14, fArr2[i10 + 4] != 0.0f ? 1 : i14);
                                f9 = f49 + fArr2[i41];
                                f6 = f50 + fArr2[i42];
                                f22 = f9;
                                f23 = f6;
                            }
                            f22 = f10;
                            f9 = f11;
                        } else {
                            i10 = i13;
                            aVar = aVar;
                            c10 = c10;
                            f6 = f26;
                            i12 = i12;
                            path.lineTo(fArr2[i10], f6);
                            f9 = fArr2[i10];
                        }
                        c10 = c10;
                        aVar = aVar;
                        i12 = i12;
                        i11 = i14;
                        c5 = 'm';
                        f29 = f9;
                        f26 = f6;
                        c9 = c10;
                        i13 = i10 + i9;
                        path = path;
                    }
                }
                int i43 = i11;
                fArr[i43] = f29;
                fArr[1] = f26;
                fArr[2] = f22;
                fArr[3] = f23;
                fArr[4] = f27;
                fArr[5] = f28;
                c9 = aVar.f2748a;
                i12++;
                i11 = i43;
                c5 = 'm';
            }
        }

        public a(a aVar) {
            this.f2748a = aVar.f2748a;
            float[] fArr = aVar.f2749b;
            this.f2749b = c.a(fArr, fArr.length);
        }
    }
}
