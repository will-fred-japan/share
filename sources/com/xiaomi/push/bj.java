package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class bj {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static byte[] f147a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f17083a = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static char[] f148a = new char[64];

    static {
        char c5 = 'A';
        int i9 = 0;
        while (c5 <= 'Z') {
            f148a[i9] = c5;
            c5 = (char) (c5 + 1);
            i9++;
        }
        char c9 = 'a';
        while (c9 <= 'z') {
            f148a[i9] = c9;
            c9 = (char) (c9 + 1);
            i9++;
        }
        char c10 = '0';
        while (c10 <= '9') {
            f148a[i9] = c10;
            c10 = (char) (c10 + 1);
            i9++;
        }
        char[] cArr = f148a;
        cArr[i9] = '+';
        cArr[i9 + 1] = '/';
        f147a = new byte[128];
        int i10 = 0;
        while (true) {
            byte[] bArr = f147a;
            if (i10 >= bArr.length) {
                break;
            }
            bArr[i10] = -1;
            i10++;
        }
        for (int i11 = 0; i11 < 64; i11++) {
            f147a[f148a[i11]] = (byte) i11;
        }
    }

    public static String a(String str) {
        return new String(a(str.getBytes()));
    }

    public static String b(String str) {
        return new String(m125a(str));
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static char[] a(byte[] bArr, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = ((i10 * 4) + 2) / 3;
        char[] cArr = new char[((i10 + 2) / 3) * 4];
        int i16 = i10 + i9;
        int i17 = 0;
        while (i9 < i16) {
            int i18 = i9 + 1;
            byte b9 = bArr[i9];
            int i19 = b9 & 255;
            if (i18 < i16) {
                i11 = i9 + 2;
                i12 = bArr[i18] & 255;
            } else {
                i11 = i18;
                i12 = 0;
            }
            if (i11 < i16) {
                i13 = i11 + 1;
                i14 = bArr[i11] & 255;
            } else {
                i13 = i11;
                i14 = 0;
            }
            int i20 = ((b9 & 3) << 4) | (i12 >>> 4);
            int i21 = ((i12 & 15) << 2) | (i14 >>> 6);
            int i22 = i14 & 63;
            char[] cArr2 = f148a;
            cArr[i17] = cArr2[i19 >>> 2];
            int i23 = i17 + 2;
            cArr[i17 + 1] = cArr2[i20];
            char c5 = '=';
            cArr[i23] = i23 < i15 ? cArr2[i21] : '=';
            int i24 = i17 + 3;
            if (i24 < i15) {
                c5 = cArr2[i22];
            }
            cArr[i24] = c5;
            i17 += 4;
            i9 = i13;
        }
        return cArr;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m125a(String str) {
        return a(str.toCharArray());
    }

    public static byte[] a(char[] cArr) {
        return a(cArr, 0, cArr.length);
    }

    public static byte[] a(char[] cArr, int i9, int i10) {
        char c5;
        if (i10 % 4 == 0) {
            while (i10 > 0 && cArr[(i9 + i10) - 1] == '=') {
                i10--;
            }
            int i11 = (i10 * 3) / 4;
            byte[] bArr = new byte[i11];
            int i12 = i10 + i9;
            int i13 = 0;
            while (i9 < i12) {
                char c9 = cArr[i9];
                int i14 = i9 + 2;
                char c10 = cArr[i9 + 1];
                char c11 = 'A';
                if (i14 < i12) {
                    i9 += 3;
                    c5 = cArr[i14];
                } else {
                    i9 = i14;
                    c5 = 'A';
                }
                if (i9 < i12) {
                    c11 = cArr[i9];
                    i9++;
                }
                if (c9 <= 127 && c10 <= 127 && c5 <= 127 && c11 <= 127) {
                    byte[] bArr2 = f147a;
                    byte b9 = bArr2[c9];
                    byte b10 = bArr2[c10];
                    byte b11 = bArr2[c5];
                    byte b12 = bArr2[c11];
                    if (b9 >= 0 && b10 >= 0 && b11 >= 0 && b12 >= 0) {
                        int i15 = (b9 << 2) | (b10 >>> 4);
                        int i16 = ((b10 & 15) << 4) | (b11 >>> 2);
                        int i17 = ((b11 & 3) << 6) | b12;
                        int i18 = i13 + 1;
                        bArr[i13] = (byte) i15;
                        if (i18 < i11) {
                            bArr[i18] = (byte) i16;
                            i18 = i13 + 2;
                        }
                        if (i18 < i11) {
                            i13 = i18 + 1;
                            bArr[i18] = (byte) i17;
                        } else {
                            i13 = i18;
                        }
                    } else {
                        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                    }
                } else {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }
}
