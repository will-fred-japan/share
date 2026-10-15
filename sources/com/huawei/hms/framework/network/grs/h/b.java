package com.huawei.hms.framework.network.grs.h;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15121a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f15122b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    public static String a(String str) {
        return a(str, "SHA-256");
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i9 = 1;
        if (str.length() == 1) {
            return "*";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < str.length(); i10++) {
            String str2 = str.charAt(i10) + "";
            if (f15122b.matcher(str2).matches()) {
                if (i9 % 2 == 0) {
                    str2 = "*";
                }
                i9++;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    private static String a(String str, String str2) {
        String str3;
        String str4;
        try {
            try {
                return a(MessageDigest.getInstance(str2).digest(str.getBytes("UTF-8")));
            } catch (NoSuchAlgorithmException unused) {
                str3 = f15121a;
                str4 = "encrypt NoSuchAlgorithmException";
                Logger.w(str3, str4);
                return null;
            }
        } catch (UnsupportedEncodingException unused2) {
            str3 = f15121a;
            str4 = "encrypt UnsupportedEncodingException";
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b9 : bArr) {
            String hexString = Integer.toHexString(b9 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
