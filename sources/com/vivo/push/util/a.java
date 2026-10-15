package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: AESParseManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f16820c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f16821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f16822b;

    private a(Context context) {
        ag.c().a(ContextDelegate.getContext(context));
    }

    public static synchronized a a(Context context) {
        try {
            if (f16820c == null) {
                synchronized (a.class) {
                    try {
                        if (f16820c == null) {
                            f16820c = new a(context.getApplicationContext());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f16820c;
    }

    private synchronized byte[] b() {
        byte[] bArr = this.f16822b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bArrE = ag.c().e();
        this.f16822b = bArrE;
        return bArrE;
    }

    public final String a(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String strA = l.a(a());
        String strA2 = l.a(b());
        byte[] bArrDecode = Base64.decode(str, 2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(strA2.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(strA.getBytes("utf-8")));
        return new String(cipher.doFinal(bArrDecode), "utf-8");
    }

    private synchronized byte[] a() {
        try {
            byte[] bArr = this.f16821a;
            if (bArr == null || bArr.length <= 0) {
                this.f16821a = ag.c().d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f16821a;
    }
}
