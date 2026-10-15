package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.heytap.msp.push.encrypt.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14371b = "Y29tLm5lYXJtZS5tY3M=";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f14372c = "";

    private static String a() {
        if (TextUtils.isEmpty(f14372c)) {
            f14372c = new String(Base64.decode(f14371b, 0));
        }
        byte[] bArrA = a(a(f14372c));
        return bArrA != null ? new String(bArrA, Charset.forName("UTF-8")) : "";
    }

    public static String b(String str) {
        boolean z8;
        String strDecrypt = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            strDecrypt = c.a(str, a());
            e.b("sdkDecrypt desDecrypt des data " + strDecrypt);
            z8 = true;
        } catch (Exception e9) {
            e.b("sdkDecrypt DES exception " + e9.toString());
            z8 = false;
        }
        if (TextUtils.isEmpty(strDecrypt) ? false : z8) {
            return strDecrypt;
        }
        try {
            strDecrypt = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            f14370a = "AES";
            g.f().a(f14370a);
            e.b("sdkDecrypt desDecrypt aes data " + strDecrypt);
            return strDecrypt;
        } catch (Exception e10) {
            e.b("sdkDecrypt AES exception " + e10.toString());
            return strDecrypt;
        }
    }

    public static String c(String str) {
        boolean z8;
        String strA = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        boolean z9 = false;
        try {
            strA = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            e.b("sdkDecrypt aesDecrypt aes data " + strA);
            z8 = true;
        } catch (Exception e9) {
            e.b("sdkDecrypt AES exception " + e9.toString());
            z8 = false;
        }
        if (TextUtils.isEmpty(strA)) {
            e.b("sdkDecrypt AES empty");
        } else {
            z9 = z8;
        }
        if (z9) {
            return strA;
        }
        try {
            strA = c.a(str, a());
            f14370a = "DES";
            g.f().a(f14370a);
            e.b("sdkDecrypt aesDecrypt des data " + strA);
            return strA;
        } catch (Exception e10) {
            e.b("sdkDecrypt DES excepiton " + e10.toString());
            return strA;
        }
    }

    public static String d(String str) {
        e.b("sdkDecrypt start data " + str);
        if (TextUtils.isEmpty(f14370a)) {
            f14370a = g.f().b();
        }
        if ("DES".equals(f14370a)) {
            e.b("sdkDecrypt start DES");
            return b(str);
        }
        e.b("sdkDecrypt start AES");
        return c(str);
    }

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i9 = 0; i9 < length; i9 += 2) {
            byte b9 = bArr[i9];
            int i10 = i9 + 1;
            bArr[i9] = bArr[i10];
            bArr[i10] = b9;
        }
        return bArr;
    }
}
