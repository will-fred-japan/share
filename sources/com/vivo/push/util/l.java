package com.vivo.push.util;

/* JADX INFO: compiled from: CryptographicTool.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i9 = 0; i9 < length; i9++) {
            cArr[i9] = (char) (bArr[i9] ^ 16);
        }
        return new String(cArr);
    }
}
