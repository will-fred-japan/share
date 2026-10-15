package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

/* JADX INFO: loaded from: classes.dex */
public class BaseKeyUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15783a = "BaseKeyUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f15784b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f15785c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f15786d = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f15787e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f15788f = 1;

    private static int a(int i9, int i10, int i11) {
        if (i10 < i9) {
            i9 = i10;
        }
        return i11 < i9 ? i11 : i9;
    }

    private static boolean b(int i9) {
        return i9 >= 16;
    }

    public static String exportHexRootKey(String str, String str2, String str3, byte[] bArr, int i9, boolean z8) {
        return HexUtil.byteArray2HexStr(exportRootKey(str, str2, str3, bArr, i9, z8));
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, boolean z8) {
        return exportRootKey(str, str2, str3, bArr, 16, z8);
    }

    public static byte[] exportRootKey32(String str, String str2, String str3, byte[] bArr, boolean z8) {
        return exportRootKey(str, str2, str3, bArr, 32, z8);
    }

    public static byte[] exportRootKey32Iteration1(String str, String str2, String str3, byte[] bArr, boolean z8) {
        return exportRootKey(str, str2, str3, bArr, 1, 32, z8);
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKeyIteration1(String str, String str2, String str3, byte[] bArr, boolean z8) {
        return exportRootKey(str, str2, str3, bArr, 1, 16, z8);
    }

    private static boolean a(int i9) {
        return i9 >= 16;
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i9, boolean z8) {
        return exportRootKey(str, str2, str3, bArr, 10000, i9, z8);
    }

    private static boolean a(int i9, byte[] bArr) {
        return b(i9) & a(bArr);
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i9, int i10, boolean z8) {
        if (!a(i10)) {
            b.b(f15783a, "exportLen length must be more than 128bit.");
            return new byte[0];
        }
        if (!a(i10, str)) {
            b.b(f15783a, "material(first) length must be Greater than or equal to export length.");
            return new byte[0];
        }
        if (!a(i10, str2)) {
            b.b(f15783a, "material(second) length must be Greater than or equal to export length.");
            return new byte[0];
        }
        if (!a(i10, str3)) {
            b.b(f15783a, "material(third) length must be Greater than or equal to export length.");
            return new byte[0];
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        int iA = a(bArrHexStr2ByteArray.length, bArrHexStr2ByteArray2.length, bArrHexStr2ByteArray3.length);
        if (a(iA, bArr)) {
            char[] cArr = new char[iA];
            for (int i11 = 0; i11 < iA; i11++) {
                cArr[i11] = (char) ((bArrHexStr2ByteArray[i11] ^ bArrHexStr2ByteArray2[i11]) ^ bArrHexStr2ByteArray3[i11]);
            }
            if (!z8) {
                b.c(f15783a, "exportRootKey: sha1");
                return PBKDF2.pbkdfBottom(cArr, bArr, i9, i10 * 8, false);
            }
            b.c(f15783a, "exportRootKey: sha256");
            return PBKDF2.pbkdfBottom(cArr, bArr, i9, i10 * 8, true);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 16;
    }

    private static boolean a(int i9, String str) {
        return str != null && str.length() >= i9;
    }

    public static byte[] exportRootKey(String str, String str2, String str3, String str4, int i9, boolean z8) {
        return exportRootKey(str, str2, str3, HexUtil.hexStr2ByteArray(str4), i9, z8);
    }
}
