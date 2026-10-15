package com.xiaomi.push;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class bl {
    private static String a(byte b9) {
        int i9 = (b9 & 127) + (b9 < 0 ? 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i9 < 16 ? "0" : "");
        sb.append(Integer.toHexString(i9).toLowerCase());
        return sb.toString();
    }

    public static String b(String str) {
        return a(str).subSequence(8, 24).toString();
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            for (byte b9 : messageDigest.digest()) {
                stringBuffer.append(a(b9));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m126a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}
