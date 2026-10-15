package com.xiaomi.push;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class bm {
    public static String a(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return a(objArr, str, 0, objArr.length);
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(m128a(str));
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static String a(Object[] objArr, String str, int i9, int i10) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i11 = i10 - i9;
        if (i11 <= 0) {
            return "";
        }
        Object obj = objArr[i9];
        StringBuffer stringBuffer = new StringBuffer((str.length() + (obj == null ? 16 : obj.toString().length())) * i11);
        for (int i12 = i9; i12 < i10; i12++) {
            if (i12 > i9) {
                stringBuffer.append(str);
            }
            Object obj2 = objArr[i12];
            if (obj2 != null) {
                stringBuffer.append(obj2);
            }
        }
        return stringBuffer.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static String a(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next.toString();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                stringBuffer.append(next2);
            }
        }
        return stringBuffer.toString();
    }

    public static String a(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        return a(collection.iterator(), str);
    }

    public static String a(int i9) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < i9; i10++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(m128a(str));
                return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
            } catch (NoSuchAlgorithmException unused) {
                return str;
            }
        }
        return "";
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            str = String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (Exception unused) {
            str = "";
        }
        return str.toLowerCase();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m128a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m127a(String str) {
        if (str == null) {
            return true;
        }
        for (int i9 = 0; i9 < str.length(); i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt < 0 || cCharAt > 127) {
                return false;
            }
        }
        return true;
    }

    public static String a(String str, int i9) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (i9 <= 0 || length < i9) {
            i9 = length / 3;
            if (i9 <= 1) {
                i9 = 1;
            }
            if (i9 > 3) {
                i9 = 3;
            }
        }
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            if (i11 % i9 == 0) {
                sb.append("*");
            } else {
                sb.append(str.charAt(i10));
            }
            i10 = i11;
        }
        return sb.toString();
    }
}
