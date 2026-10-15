package com.huawei.agconnect.config.impl;

/* JADX INFO: loaded from: classes.dex */
public class Hex {
    private static final char[] HEX_CODE = "0123456789ABCDEF".toCharArray();

    private static byte[] decodeHex(char[] cArr) {
        if ((cArr.length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        byte[] bArr = new byte[cArr.length >> 1];
        int i9 = 0;
        int i10 = 0;
        while (i9 < cArr.length) {
            int iDigit = Character.digit(cArr[i9], 16);
            if (iDigit == -1) {
                throw new IllegalArgumentException(W5.e.i(i9, "Illegal hexadecimal character at index "));
            }
            int i11 = i9 + 1;
            int iDigit2 = Character.digit(cArr[i11], 16);
            if (iDigit2 == -1) {
                throw new IllegalArgumentException(W5.e.i(i11, "Illegal hexadecimal character at index "));
            }
            i9 += 2;
            bArr[i10] = (byte) (((iDigit << 4) | iDigit2) & 255);
            i10++;
        }
        return bArr;
    }

    public static byte[] decodeHexString(String str) {
        return decodeHex(str.toCharArray());
    }

    public static String encodeHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b9 : bArr) {
            char[] cArr = HEX_CODE;
            sb.append(cArr[(b9 >> 4) & 15]);
            sb.append(cArr[b9 & 15]);
        }
        return sb.toString();
    }
}
