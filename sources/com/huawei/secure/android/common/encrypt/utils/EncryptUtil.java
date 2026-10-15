package com.huawei.secure.android.common.encrypt.utils;

import android.util.Base64;
import defpackage.f;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

/* JADX INFO: loaded from: classes.dex */
public class EncryptUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15789a = "EncryptUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15790b = "RSA";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f15791c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f15792d = true;

    private static SecureRandom a() {
        SecureRandom secureRandom;
        b.a(f15789a, "generateSecureRandomNew ");
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            b.b(f15789a, "getSecureRandomBytes: NoSuchAlgorithmException");
            secureRandom = null;
        }
        if (secureRandom == null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                b.b(f15789a, "NoSuchAlgorithmException");
                return secureRandom;
            } catch (Throwable th) {
                if (f15792d) {
                    b.b(f15789a, "exception : " + th.getMessage() + " , you should implementation bcprov-jdk15on library");
                    f15792d = false;
                }
                return secureRandom;
            }
        }
        AESEngine aESEngine = new AESEngine();
        byte[] bArr = new byte[32];
        secureRandom.nextBytes(bArr);
        return new SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(384).buildCTR(aESEngine, 256, bArr, false);
    }

    public static SecureRandom genSecureRandom() {
        if (f15791c) {
            return a();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            b.b(f15789a, "genSecureRandom: NoSuchAlgorithmException");
            return null;
        }
    }

    public static byte[] generateSecureRandom(int i9) {
        SecureRandom secureRandom;
        if (f15791c) {
            return a(i9);
        }
        byte[] bArr = new byte[i9];
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            b.b(f15789a, "getSecureRandomBytes: NoSuchAlgorithmException");
            secureRandom = null;
        }
        if (secureRandom == null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                b.b(f15789a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                return new byte[0];
            } catch (Exception e9) {
                f.k(e9, new StringBuilder("getSecureRandomBytes getInstance: exception : "), f15789a);
                return new byte[0];
            }
        }
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static String generateSecureRandomStr(int i9) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i9));
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(f15790b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e9) {
                b.b(f15789a, "load Key Exception:" + e9.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f15789a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e10) {
            f.k(e10, new StringBuilder("base64 decode Exception"), f15789a);
            return null;
        }
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(f15790b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e9) {
                b.b(f15789a, "load Key Exception:" + e9.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f15789a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e10) {
            f.k(e10, new StringBuilder("base64 decode Exception"), f15789a);
            return null;
        }
    }

    public static boolean isBouncycastleFlag() {
        return f15791c;
    }

    public static void setBouncycastleFlag(boolean z8) {
        b.c(f15789a, "setBouncycastleFlag: " + z8);
        f15791c = z8;
    }

    private static byte[] a(int i9) {
        SecureRandom secureRandomA = a();
        if (secureRandomA == null) {
            return new byte[0];
        }
        try {
            byte[] bArr = new byte[i9];
            secureRandomA.nextBytes(bArr);
            return bArr;
        } catch (NullPointerException e9) {
            b.b(f15789a, "secureRandom nextBytes error is : " + e9.getMessage());
            return new byte[0];
        }
    }
}
