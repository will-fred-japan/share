package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class aa {
    public static byte[] a(int i9) {
        return new byte[]{(byte) (i9 >> 24), (byte) (i9 >> 16), (byte) (i9 >> 8), (byte) i9};
    }

    public static int a(byte[] bArr) {
        if (bArr.length != 4) {
            throw new IllegalArgumentException("the length of bytes must be 4");
        }
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }
}
