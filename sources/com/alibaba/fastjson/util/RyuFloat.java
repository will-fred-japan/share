package com.alibaba.fastjson.util;

import defpackage.f;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes.dex */
public final class RyuFloat {
    private static final int[][] POW5_SPLIT = {new int[]{536870912, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{Http2Connection.DEGRADED_PONG_TIMEOUT_NS, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};
    private static final int[][] POW5_INV_SPLIT = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};

    public static String toString(float f6) {
        char[] cArr = new char[15];
        return new String(cArr, 0, toString(f6, cArr, 0));
    }

    /* JADX WARN: Failed to calculate best type for var: r35v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r35v0 ??, new type: char[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r35v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r35v0 ??, new type: char[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to set immutable type for var: r35v0 char[]
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r35v0 char[], new type: char[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToForceImmutableTypes(FixTypesVisitor.java:946)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    public static int toString(float f6, char[] cArr, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z8;
        boolean z9;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        char c5;
        long j;
        int i22;
        int i23;
        int i24;
        int i25;
        if (!Float.isNaN(f6)) {
            if (f6 == Float.POSITIVE_INFINITY) {
                cArr[i9] = 'I';
                cArr[i9 + 1] = 'n';
                cArr[i9 + 2] = 'f';
                cArr[i9 + 3] = 'i';
                cArr[i9 + 4] = 'n';
                cArr[i9 + 5] = 'i';
                cArr[i9 + 6] = 't';
                i24 = i9 + 8;
                cArr[i9 + 7] = 'y';
            } else if (f6 == Float.NEGATIVE_INFINITY) {
                cArr[i9] = '-';
                cArr[i9 + 1] = 'I';
                cArr[i9 + 2] = 'n';
                cArr[i9 + 3] = 'f';
                cArr[i9 + 4] = 'i';
                cArr[i9 + 5] = 'n';
                cArr[i9 + 6] = 'i';
                cArr[i9 + 7] = 't';
                i25 = i9 + 9;
                cArr[i9 + 8] = 'y';
            } else {
                int iFloatToIntBits = Float.floatToIntBits(f6);
                if (iFloatToIntBits == 0) {
                    cArr[i9] = '0';
                    cArr[i9 + 1] = '.';
                    i25 = i9 + 3;
                    cArr[i9 + 2] = '0';
                } else if (iFloatToIntBits == Integer.MIN_VALUE) {
                    cArr[i9] = '-';
                    cArr[i9 + 1] = '0';
                    cArr[i9 + 2] = '.';
                    i24 = i9 + 4;
                    cArr[i9 + 3] = '0';
                } else {
                    int i26 = (iFloatToIntBits >> 23) & 255;
                    int i27 = 8388607 & iFloatToIntBits;
                    if (i26 == 0) {
                        i10 = -149;
                    } else {
                        i10 = i26 - 150;
                        i27 |= 8388608;
                    }
                    boolean z10 = iFloatToIntBits < 0;
                    boolean z11 = (i27 & 1) == 0;
                    int i28 = i27 * 4;
                    int i29 = i28 + 2;
                    int i30 = i28 - ((((long) i27) != 8388608 || i26 <= 1) ? 2 : 1);
                    int i31 = i10 - 2;
                    if (i31 >= 0) {
                        i16 = (int) ((((long) i31) * 3010299) / 10000000);
                        if (i16 == 0) {
                            i22 = 1;
                            c5 = 2;
                            j = 9999999;
                        } else {
                            c5 = 2;
                            j = 9999999;
                            i22 = (int) (((((long) i16) * 23219280) + 9999999) / 10000000);
                        }
                        int i32 = (-i31) + i16;
                        int[][] iArr = POW5_INV_SPLIT;
                        int[] iArr2 = iArr[i16];
                        long j8 = iArr2[0];
                        long j9 = iArr2[1];
                        i12 = 10;
                        long j10 = i28;
                        int i33 = ((i22 + 58) + i32) - 31;
                        i11 = 0;
                        int i34 = (int) (((j10 * j8) + ((j10 * j9) >> 31)) >> i33);
                        long j11 = i29;
                        int i35 = (int) (((j11 * j8) + ((j11 * j9) >> 31)) >> i33);
                        long j12 = i30;
                        int i36 = (int) (((j8 * j12) + ((j12 * j9) >> 31)) >> i33);
                        if (i16 == 0 || (i35 - 1) / 10 > i36 / 10) {
                            i23 = 0;
                        } else {
                            int i37 = i16 - 1;
                            int i38 = (i32 - 1) + (i37 == 0 ? 1 : (int) (((((long) i37) * 23219280) + j) / 10000000)) + 58;
                            int[] iArr3 = iArr[i37];
                            i23 = (int) ((((((long) iArr3[0]) * j10) + ((j10 * ((long) iArr3[1])) >> 31)) >> (i38 - 31)) % 10);
                        }
                        int i39 = 0;
                        while (i29 > 0 && i29 % 5 == 0) {
                            i29 /= 5;
                            i39++;
                        }
                        int i40 = 0;
                        while (i28 > 0 && i28 % 5 == 0) {
                            i28 /= 5;
                            i40++;
                        }
                        int i41 = 0;
                        while (i30 > 0 && i30 % 5 == 0) {
                            i30 /= 5;
                            i41++;
                        }
                        boolean z12 = i39 >= i16;
                        boolean z13 = i40 >= i16;
                        i17 = i41 >= i16 ? 1 : 0;
                        z9 = z13;
                        i14 = i36;
                        i13 = i34;
                        z8 = z12;
                        i18 = i23;
                        i19 = i35;
                    } else {
                        i11 = 0;
                        i12 = 10;
                        int i42 = -i31;
                        int i43 = (int) ((((long) i42) * 6989700) / 10000000);
                        int i44 = i42 - i43;
                        int i45 = i44 == 0 ? 1 : (int) (((((long) i44) * 23219280) + 9999999) / 10000000);
                        int[][] iArr4 = POW5_SPLIT;
                        int[] iArr5 = iArr4[i44];
                        long j13 = iArr5[0];
                        long j14 = iArr5[1];
                        int i46 = (i43 - (i45 - 61)) - 31;
                        long j15 = i28;
                        i13 = (int) (((j15 * j13) + ((j15 * j14) >> 31)) >> i46);
                        long j16 = i29;
                        int i47 = (int) (((j16 * j13) + ((j16 * j14) >> 31)) >> i46);
                        long j17 = i30;
                        i14 = (int) (((j13 * j17) + ((j17 * j14) >> 31)) >> i46);
                        if (i43 == 0 || (i47 - 1) / 10 > i14 / 10) {
                            i15 = 0;
                        } else {
                            int i48 = i44 + 1;
                            int i49 = (i43 - 1) - ((i48 == 0 ? 1 : (int) (((((long) i48) * 23219280) + 9999999) / 10000000)) - 61);
                            int[] iArr6 = iArr4[i48];
                            i15 = (int) ((((((long) iArr6[0]) * j15) + ((((long) iArr6[1]) * j15) >> 31)) >> (i49 - 31)) % 10);
                        }
                        i16 = i43 + i31;
                        z8 = 1 >= i43;
                        z9 = i43 < 23 && (((1 << (i43 + (-1))) - 1) & i28) == 0;
                        i17 = (i30 % 2 == 1 ? 0 : 1) >= i43 ? 1 : 0;
                        i18 = i15;
                        i19 = i47;
                    }
                    int i50 = Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
                    int i51 = i12;
                    while (i51 > 0 && i19 < i50) {
                        i50 /= 10;
                        i51--;
                    }
                    int i52 = i16 + i51;
                    int i53 = i52 - 1;
                    int i54 = (i53 < -3 || i53 >= 7) ? 1 : i11;
                    if (z8 && !z11) {
                        i19--;
                    }
                    int i55 = i11;
                    while (true) {
                        int i56 = i19 / 10;
                        int i57 = i14 / 10;
                        if (i56 <= i57 || (i19 < 100 && i54 != 0)) {
                            break;
                        }
                        i17 &= i14 % 10 == 0 ? 1 : i11;
                        i18 = i13 % 10;
                        i13 /= 10;
                        i55++;
                        i19 = i56;
                        i14 = i57;
                    }
                    if (i17 != 0 && z11) {
                        while (i14 % 10 == 0 && (i19 >= 100 || i54 == 0)) {
                            i19 /= 10;
                            i18 = i13 % 10;
                            i13 /= 10;
                            i14 /= 10;
                            i55++;
                        }
                    }
                    int i58 = i13;
                    if (z9 && i18 == 5 && i58 % 2 == 0) {
                        i18 = 4;
                    }
                    int i59 = i58 + (((i58 != i14 || (i17 != 0 && z11)) && i18 < 5) ? i11 : 1);
                    int i60 = i51 - i55;
                    if (z10) {
                        i20 = i9 + 1;
                        cArr[i9] = 45;
                    } else {
                        i20 = i9;
                    }
                    if (i54 != 0) {
                        for (int i61 = i11; i61 < i60 - 1; i61++) {
                            int i62 = i59 % 10;
                            i59 /= 10;
                            cArr[(i20 + i60) - i61] = (char) (i62 + 48);
                        }
                        cArr[i20] = (char) ((i59 % 10) + 48);
                        cArr[i20 + 1] = '.';
                        int i63 = i60 + 1 + i20;
                        if (i60 == 1) {
                            cArr[i63] = 48;
                            i63++;
                        }
                        int i64 = i63 + 1;
                        cArr[i63] = 'E';
                        if (i53 < 0) {
                            cArr[i64] = r5;
                            i53 = -i53;
                            i64 = i63 + 2;
                        }
                        if (i53 >= i12) {
                            cArr[i64] = (char) ((i53 / 10) + 48);
                            i64++;
                        }
                        i21 = i64 + 1;
                        cArr[i64] = (char) ((i53 % 10) + 48);
                    } else if (i53 < 0) {
                        int i65 = i20 + 1;
                        cArr[i20] = r2;
                        int i66 = i20 + 2;
                        cArr[i65] = '.';
                        int i67 = -1;
                        while (i67 > i53) {
                            cArr[i66] = r2;
                            i67--;
                            i66++;
                        }
                        int i68 = i66;
                        for (int i69 = i11; i69 < i60; i69++) {
                            cArr[f.a(i66, i60, i69, 1)] = (char) ((i59 % 10) + 48);
                            i59 /= 10;
                            i68++;
                        }
                        i21 = i68;
                    } else if (i52 >= i60) {
                        for (int i70 = i11; i70 < i60; i70++) {
                            cArr[f.a(i20, i60, i70, 1)] = (char) ((i59 % 10) + 48);
                            i59 /= 10;
                        }
                        int i71 = i20 + i60;
                        while (i60 < i52) {
                            cArr[i71] = r2;
                            i60++;
                            i71++;
                        }
                        cArr[i71] = '.';
                        cArr[i71 + 1] = r2;
                        i21 = i71 + 2;
                    } else {
                        int i72 = i20 + 1;
                        for (int i73 = i11; i73 < i60; i73++) {
                            if ((i60 - i73) - 1 == i53) {
                                cArr[f.a(i72, i60, i73, 1)] = '.';
                                i72--;
                            }
                            cArr[f.a(i72, i60, i73, 1)] = (char) ((i59 % 10) + 48);
                            i59 /= 10;
                        }
                        i21 = i60 + 1 + i20;
                    }
                    return i21 - i9;
                }
            }
            return i24 - i9;
        }
        cArr[i9] = 'N';
        cArr[i9 + 1] = 'a';
        i25 = i9 + 3;
        cArr[i9 + 2] = 'N';
        return i25 - i9;
    }
}
