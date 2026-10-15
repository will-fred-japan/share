package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static byte[] a(byte[] bArr, int i9) {
        if (bArr == null) {
            return bArr;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (i9 < 0) {
                bArr[i10] = (byte) (bArr[i10] << (-i9));
            } else {
                bArr[i10] = (byte) (bArr[i10] >> i9);
            }
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null || bArr2.length != (length = bArr.length)) {
            return null;
        }
        byte[] bArr3 = new byte[length];
        for (int i9 = 0; i9 < length; i9++) {
            bArr3[i9] = (byte) (bArr[i9] ^ bArr2[i9]);
        }
        return bArr3;
    }
}
