package com.huawei.hms.utils;

/* JADX INFO: loaded from: classes.dex */
public final class HEX {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f15606a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f15607b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private HEX() {
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        if (bArr == null) {
            return new char[0];
        }
        char[] cArr2 = new char[bArr.length << 1];
        int i9 = 0;
        for (byte b9 : bArr) {
            int i10 = i9 + 1;
            cArr2[i9] = cArr[(b9 & 240) >>> 4];
            i9 += 2;
            cArr2[i10] = cArr[b9 & 15];
        }
        return cArr2;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, false);
    }

    public static String encodeHexString(byte[] bArr, boolean z8) {
        return new String(encodeHex(bArr, z8));
    }

    public static char[] encodeHex(byte[] bArr, boolean z8) {
        return a(bArr, z8 ? f15607b : f15606a);
    }
}
