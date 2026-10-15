package com.huawei.secure.android.common.util;

import android.util.Base64;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class SafeBase64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15957a = "SafeBase64";

    private SafeBase64() {
    }

    public static byte[] decode(byte[] bArr, int i9) {
        try {
            return Base64.decode(bArr, i9);
        } catch (Exception e9) {
            Log.e(f15957a, e9.getClass().getSimpleName() + " , message0 : " + e9.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i9) {
        try {
            return Base64.encode(bArr, i9);
        } catch (Exception e9) {
            Log.e(f15957a, e9.getClass().getSimpleName() + " , message3 : " + e9.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i9) {
        try {
            return Base64.encodeToString(bArr, i9);
        } catch (Exception e9) {
            Log.e(f15957a, e9.getClass().getSimpleName() + " , message5 : " + e9.getMessage());
            return "";
        }
    }

    public static String encodeToString(byte[] bArr, int i9, int i10, int i11) {
        try {
            return Base64.encodeToString(bArr, i9, i10, i11);
        } catch (Exception e9) {
            Log.e(f15957a, e9.getClass().getSimpleName() + " , message6 : " + e9.getMessage());
            return "";
        }
    }

    public static byte[] decode(byte[] bArr, int i9, int i10, int i11) {
        try {
            return Base64.decode(bArr, i9, i10, i11);
        } catch (Exception e9) {
            Log.e(f15957a, e9.getClass().getSimpleName() + " , message1 : " + e9.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i9, int i10, int i11) {
        try {
            return Base64.encode(bArr, i9, i10, i11);
        } catch (Exception e9) {
            Log.e(f15957a, e9.getClass().getSimpleName() + " , message4 : " + e9.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decode(String str, int i9) {
        try {
            return Base64.decode(str, i9);
        } catch (Exception e9) {
            Log.e(f15957a, e9.getClass().getSimpleName() + " , message2 : " + e9.getMessage());
            return new byte[0];
        }
    }
}
