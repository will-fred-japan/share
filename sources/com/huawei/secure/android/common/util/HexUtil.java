package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class HexUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15945a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15946b = "HexUtil";

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
        } catch (UnsupportedEncodingException e9) {
            e = e9;
            H2.a.h(e, new StringBuilder("hex string 2 byte UnsupportedEncodingException or NumberFormatException : "), f15946b);
        } catch (NumberFormatException e10) {
            e = e10;
            H2.a.h(e, new StringBuilder("hex string 2 byte UnsupportedEncodingException or NumberFormatException : "), f15946b);
        } catch (Exception e11) {
            H2.a.h(e11, new StringBuilder("byte array 2 hex string exception : "), f15946b);
        }
        return bArr;
    }

    public static String byteArray2HexStr(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return byteArray2HexStr(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e9) {
                Log.e(f15946b, "byte array 2 hex string UnsupportedEncodingException : " + e9.getMessage());
                return "";
            } catch (Exception e10) {
                H2.a.h(e10, new StringBuilder("byte array 2 hex string exception : "), f15946b);
                return "";
            }
        }
        return "";
    }
}
