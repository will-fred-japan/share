package com.huawei.hms.support.log.common;

import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public final class Base64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f15566a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f15567b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private Base64() {
    }

    private static int a(String str) {
        int length = str.length();
        for (int i9 = 0; i9 < str.length(); i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt > 255 || f15567b[cCharAt] < 0) {
                length--;
            }
        }
        return length;
    }

    public static byte[] decode(String str) {
        if (str == null) {
            return new byte[0];
        }
        int iA = a(str);
        int i9 = (iA / 4) * 3;
        int i10 = iA % 4;
        if (i10 == 3) {
            i9 += 2;
        }
        if (i10 == 2) {
            i9++;
        }
        byte[] bArr = new byte[i9];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char cCharAt = str.charAt(i14);
            byte b9 = cCharAt > 255 ? (byte) -1 : f15567b[cCharAt];
            if (b9 >= 0) {
                int i15 = i13 + 6;
                i12 = (i12 << 6) | b9;
                if (i15 >= 8) {
                    i13 -= 2;
                    bArr[i11] = (byte) (255 & (i12 >> i13));
                    i11++;
                } else {
                    i13 = i15;
                }
            }
        }
        return i11 != i9 ? new byte[0] : bArr;
    }

    public static String encode(byte[] bArr) {
        return bArr == null ? "" : encode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, int i9) {
        boolean z8;
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[((i9 + 2) / 3) * 4];
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = (bArr[i10] & 255) << 8;
            int i13 = i10 + 1;
            boolean z9 = true;
            if (i13 < i9) {
                i12 |= bArr[i13] & 255;
                z8 = true;
            } else {
                z8 = false;
            }
            int i14 = i12 << 8;
            int i15 = i10 + 2;
            if (i15 < i9) {
                i14 |= bArr[i15] & 255;
            } else {
                z9 = false;
            }
            int i16 = i11 + 3;
            char[] cArr2 = f15566a;
            int i17 = 64;
            cArr[i16] = cArr2[z9 ? i14 & 63 : 64];
            int i18 = i14 >> 6;
            int i19 = i11 + 2;
            if (z8) {
                i17 = i18 & 63;
            }
            cArr[i19] = cArr2[i17];
            cArr[i11 + 1] = cArr2[(i14 >> 12) & 63];
            cArr[i11] = cArr2[(i14 >> 18) & 63];
            i10 += 3;
            i11 += 4;
        }
        return new String(cArr);
    }
}
