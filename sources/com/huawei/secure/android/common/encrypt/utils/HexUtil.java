package com.huawei.secure.android.common.encrypt.utils;

import android.text.TextUtils;
import defpackage.f;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class HexUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15793a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15794b = "HexUtil";

    private HexUtil() {
    }

    public static String byteArray2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b9 : bArr) {
            String hexString = Integer.toHexString(b9 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] hexStr2ByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length = upperCase.length() / 2;
            byte[] bArr = new byte[length];
            try {
                byte[] bytes = upperCase.getBytes("UTF-8");
                for (int i9 = 0; i9 < length; i9++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("0x");
                    int i10 = i9 * 2;
                    sb.append(new String(new byte[]{bytes[i10]}, "UTF-8"));
                    bArr[i9] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i10 + 1]}, "UTF-8")).byteValue());
                }
                return bArr;
            } catch (UnsupportedEncodingException | NumberFormatException e9) {
                f.k(e9, new StringBuilder("hex string 2 byte array exception : "), f15794b);
                return new byte[0];
            }
        } catch (Throwable th) {
            b.b(f15794b, "hex string toUpperCase exception : " + th.getMessage());
            return new byte[0];
        }
    }

    public static String byteArray2HexStr(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return byteArray2HexStr(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e9) {
                b.b(f15794b, "byte array 2 hex string exception : " + e9.getMessage());
                return "";
            }
        }
        return "";
    }
}
