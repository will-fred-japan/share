package com.huawei.secure.android.common.util;

import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EncryptUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15943a = "EncryptUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15944b = "RSA";

    @Deprecated
    public static byte[] generateSecureRandom(int i9) {
        SecureRandom secureRandom;
        byte[] bArr = new byte[i9];
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            LogsUtil.e(f15943a, "getSecureRandomBytes: NoSuchAlgorithmException");
            secureRandom = null;
        }
        if (secureRandom == null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                LogsUtil.e(f15943a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                return new byte[0];
            } catch (Exception e9) {
                LogsUtil.e(f15943a, "getSecureRandomBytes getInstance: exception : " + e9.getMessage());
                return new byte[0];
            }
        }
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    @Deprecated
    public static String generateSecureRandomStr(int i9) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i9));
    }

    @Deprecated
    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(f15944b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e9) {
                LogsUtil.e(f15943a, "load Key Exception:" + e9.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.e(f15943a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.e(f15943a, "base64 decode Exception", true);
            return null;
        }
    }

    @Deprecated
    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(f15944b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e9) {
                LogsUtil.e(f15943a, "load Key Exception:" + e9.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.e(f15943a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.e(f15943a, "base64 decode Exception", true);
            return null;
        }
    }
}
