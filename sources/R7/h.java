package R7;

import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: StringNumberConversions.kt */
/* JADX INFO: loaded from: classes2.dex */
public class h extends g {
    /* JADX WARN: Code duplicated, block: B:105:0x0126  */
    /* JADX WARN: Code duplicated, block: B:108:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x012d A[PHI: r4
  0x012d: PHI (r4v5 int) = (r4v4 int), (r4v18 int) binds: [B:69:0x00cf, B:108:0x012a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:112:0x0137  */
    /* JADX WARN: Code duplicated, block: B:113:0x013a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0142  */
    /* JADX WARN: Code duplicated, block: B:117:0x0144 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:121:0x014b  */
    /* JADX WARN: Code duplicated, block: B:123:0x014e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0161  */
    /* JADX WARN: Code duplicated, block: B:136:0x016f  */
    /* JADX WARN: Code duplicated, block: B:137:0x0171  */
    /* JADX WARN: Code duplicated, block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:89:0x0104  */
    /* JADX WARN: Code duplicated, block: B:92:0x0108 A[ADDED_TO_REGION] */
    public static final boolean D(String str) {
        char c5;
        boolean z8;
        boolean z9;
        int i9;
        int iCharAt;
        int i10;
        int iCharAt2;
        int i11;
        boolean z10;
        int i12;
        boolean z11;
        String str2;
        int i13;
        boolean z12;
        boolean z13 = true;
        int length = str.length() - 1;
        int i14 = 0;
        while (true) {
            c5 = ' ';
            if (i14 > length || str.charAt(i14) > ' ') {
                break;
            }
            i14++;
        }
        if (i14 <= length) {
            while (length > i14 && str.charAt(length) <= ' ') {
                length--;
            }
            if (str.charAt(i14) == '+' || str.charAt(i14) == '-') {
                i14++;
            }
            if (i14 <= length) {
                if (str.charAt(i14) != '0') {
                    z8 = true;
                    z9 = false;
                    if (z9) {
                        i9 = i14 + 1;
                        iCharAt = str.charAt(i14) | ' ';
                        if (z9) {
                            i10 = 112;
                        } else {
                            i10 = 101;
                        }
                        if (iCharAt != i10) {
                            if (z9) {
                            }
                        } else if (i9 <= length) {
                            while (i9 <= length) {
                                i9++;
                            }
                            if (i9 > length) {
                                return z8;
                            }
                            if (i9 != length) {
                            }
                        }
                    } else {
                        i11 = i14;
                        while (i11 <= length && ((str.charAt(i11) - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10) {
                            i11++;
                        }
                        if (i14 != i11) {
                            z10 = z8;
                        } else {
                            z10 = false;
                        }
                        if (i11 > length) {
                            i14 = i11;
                        } else {
                            if (str.charAt(i11) == '.') {
                                i13 = i11 + 1;
                                i12 = i13;
                                while (i12 <= length && ((str.charAt(i12) - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10) {
                                    i12++;
                                }
                                if (i13 != i12) {
                                    z11 = z8;
                                }
                                if (!z10 || z11) {
                                    i14 = i12;
                                } else {
                                    if (length == i12 + 2) {
                                        str2 = "NaN";
                                    } else {
                                        str2 = length == i12 + 7 ? "Infinity" : null;
                                    }
                                    i14 = (str2 != null && l.R(str, str2, i12, false) == i12) ? length + 1 : -1;
                                }
                            } else {
                                i12 = i11;
                            }
                            z11 = false;
                            if (z10) {
                                i14 = i12;
                            } else {
                                i14 = i12;
                            }
                        }
                        if (i14 != -1) {
                            if (i14 > length) {
                                return z8;
                            }
                            i9 = i14 + 1;
                            iCharAt = str.charAt(i14) | ' ';
                            if (z9) {
                                i10 = 112;
                            } else {
                                i10 = 101;
                            }
                            if (iCharAt != i10) {
                                if (z9 && ((iCharAt == 102 || iCharAt == 100) && i9 > length)) {
                                    return z8;
                                }
                            } else if (i9 <= length && ((str.charAt(i9) != '+' && str.charAt(i9) != '-') || (i9 = i14 + 2) <= length)) {
                                while (i9 <= length && ((str.charAt(i9) - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10) {
                                    i9++;
                                }
                                if (i9 > length) {
                                    return z8;
                                }
                                if (i9 != length && ((iCharAt2 = str.charAt(i9) | ' ') == 102 || iCharAt2 == 100)) {
                                    return z8;
                                }
                            }
                        }
                    }
                } else {
                    int i15 = i14 + 1;
                    if (i15 > length) {
                        return true;
                    }
                    if ((str.charAt(i15) | ' ') == 120) {
                        int i16 = i14 + 2;
                        int i17 = i16;
                        while (true) {
                            if (i17 > length) {
                                z8 = z13;
                                break;
                            }
                            char cCharAt = str.charAt(i17);
                            z8 = z13;
                            if (((cCharAt - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 10 && (((cCharAt | ' ') - 97) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 6) {
                                break;
                            }
                            i17++;
                            z13 = z8;
                        }
                        boolean z14 = i16 != i17 ? z8 : false;
                        if (i17 <= length) {
                            if (str.charAt(i17) == '.') {
                                int i18 = i17 + 1;
                                int i19 = i18;
                                while (i19 <= length) {
                                    char cCharAt2 = str.charAt(i19);
                                    char c9 = c5;
                                    if (((cCharAt2 - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 10 && (((cCharAt2 | ' ') - 97) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 6) {
                                        break;
                                    }
                                    i19++;
                                    c5 = c9;
                                }
                                z12 = i18 != i19 ? z8 : false;
                                i17 = i19;
                            } else {
                                z12 = false;
                            }
                            if (z14 || z12) {
                                i14 = i17;
                            }
                            if (i14 != -1 && i14 <= length) {
                                z9 = z8;
                            }
                        }
                        i14 = -1;
                        if (i14 != -1) {
                            z9 = z8;
                        }
                    } else {
                        z8 = true;
                        z9 = false;
                    }
                    if (z9) {
                        i11 = i14;
                        while (i11 <= length) {
                            i11++;
                        }
                        if (i14 != i11) {
                            z10 = z8;
                        } else {
                            z10 = false;
                        }
                        if (i11 > length) {
                            i14 = i11;
                        } else {
                            if (str.charAt(i11) == '.') {
                                i13 = i11 + 1;
                                i12 = i13;
                                while (i12 <= length) {
                                    i12++;
                                }
                                if (i13 != i12) {
                                    z11 = z8;
                                }
                                if (z10) {
                                    i14 = i12;
                                } else {
                                    i14 = i12;
                                }
                            } else {
                                i12 = i11;
                            }
                            z11 = false;
                            if (z10) {
                                i14 = i12;
                            } else {
                                i14 = i12;
                            }
                        }
                        if (i14 != -1) {
                            if (i14 > length) {
                                return z8;
                            }
                            i9 = i14 + 1;
                            iCharAt = str.charAt(i14) | ' ';
                            if (z9) {
                                i10 = 112;
                            } else {
                                i10 = 101;
                            }
                            if (iCharAt != i10) {
                                if (z9) {
                                }
                            } else if (i9 <= length) {
                                while (i9 <= length) {
                                    i9++;
                                }
                                if (i9 > length) {
                                    return z8;
                                }
                                if (i9 != length) {
                                }
                            }
                        }
                    } else {
                        i9 = i14 + 1;
                        iCharAt = str.charAt(i14) | ' ';
                        if (z9) {
                            i10 = 112;
                        } else {
                            i10 = 101;
                        }
                        if (iCharAt != i10) {
                            if (z9) {
                            }
                        } else if (i9 <= length) {
                            while (i9 <= length) {
                                i9++;
                            }
                            if (i9 > length) {
                                return z8;
                            }
                            if (i9 != length) {
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static Integer E(int i9, String str) {
        boolean z8;
        int i10;
        int i11;
        p199z2.b.q(i9);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char cCharAt = str.charAt(0);
        int i13 = -2147483647;
        if (kotlin.jvm.internal.k.f(cCharAt, 48) < 0) {
            i10 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z8 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i13 = Integer.MIN_VALUE;
                z8 = true;
            }
        } else {
            z8 = false;
            i10 = 0;
        }
        int i14 = -59652323;
        while (i10 < length) {
            int iDigit = Character.digit((int) str.charAt(i10), i9);
            if (iDigit < 0) {
                return null;
            }
            if ((i12 < i14 && (i14 != -59652323 || i12 < (i14 = i13 / i9))) || (i11 = i12 * i9) < i13 + iDigit) {
                return null;
            }
            i12 = i11 - iDigit;
            i10++;
        }
        return z8 ? Integer.valueOf(i12) : Integer.valueOf(-i12);
    }
}
