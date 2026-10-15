package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import defpackage.f;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
public abstract class RSAEncrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15772a = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15773b = "RSAEncrypt";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15774c = "UTF-8";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15775d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f15776e = 2048;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f15777f = "RSA";

    public static String decrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return decrypt(str, EncryptUtil.getPrivateKey(str2));
        }
        b.b(f15773b, "content or private key is null");
        return "";
    }

    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return encrypt(str, EncryptUtil.getPublicKey(str2));
        }
        b.b(f15773b, "content or public key is null");
        return "";
    }

    public static Map<String, Key> generateRSAKeyPair(int i9) throws NoSuchAlgorithmException {
        HashMap map = new HashMap(2);
        if (i9 < 2048) {
            b.b(f15773b, "generateRSAKeyPair: key length is too short");
            return map;
        }
        SecureRandom secureRandomGenSecureRandom = EncryptUtil.genSecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(f15777f);
        keyPairGenerator.initialize(i9, secureRandomGenSecureRandom);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPairGenerateKeyPair.getPublic();
        PrivateKey privateKey = keyPairGenerateKeyPair.getPrivate();
        map.put("publicKey", publicKey);
        map.put("privateKey", privateKey);
        return map;
    }

    public static boolean isPrivateKeyLengthRight(RSAPrivateKey rSAPrivateKey) {
        return rSAPrivateKey != null && rSAPrivateKey.getModulus().bitLength() >= 2048;
    }

    public static boolean isPublicKeyLengthRight(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 2048;
    }

    public static String decrypt(String str, PrivateKey privateKey) {
        if (!TextUtils.isEmpty(str) && privateKey != null) {
            try {
                if (!isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
                    b.b(f15773b, "privateKey length is too short");
                    return "";
                }
                return new String(decrypt(Base64.decode(str, 0), privateKey), "UTF-8");
            } catch (UnsupportedEncodingException e9) {
                b.b(f15773b, "RSA decrypt exception : " + e9.getMessage());
                return "";
            } catch (ClassCastException unused) {
                b.b(f15773b, "decrypt: ClassCastException");
                return "";
            } catch (Exception e10) {
                f.k(e10, new StringBuilder("exception : "), f15773b);
                return "";
            }
        }
        b.b(f15773b, "content or privateKey is null.");
        return "";
    }

    public static String encrypt(String str, PublicKey publicKey) {
        if (!TextUtils.isEmpty(str) && publicKey != null) {
            try {
                if (!isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
                    b.b(f15773b, "PublicKey length is too short");
                    return "";
                }
                return Base64.encodeToString(encrypt(str.getBytes("UTF-8"), publicKey), 0);
            } catch (UnsupportedEncodingException unused) {
                b.b(f15773b, "encrypt: UnsupportedEncodingException");
                return "";
            } catch (ClassCastException unused2) {
                b.b(f15773b, "encrypt: ClassCastException");
                return "";
            } catch (Exception e9) {
                f.k(e9, new StringBuilder("exception : "), f15773b);
                return "";
            }
        }
        b.b(f15773b, "content or PublicKey is null");
        return "";
    }

    public static byte[] decrypt(byte[] bArr, PrivateKey privateKey) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && privateKey != null) {
            try {
                if (!isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
                    b.b(f15773b, "privateKey length is too short");
                    return bArr2;
                }
                Cipher cipher = Cipher.getInstance(f15772a);
                cipher.init(2, privateKey);
                return cipher.doFinal(bArr);
            } catch (ClassCastException unused) {
                b.b(f15773b, "decrypt: ClassCastException");
                return bArr2;
            } catch (GeneralSecurityException e9) {
                b.b(f15773b, "RSA decrypt exception : " + e9.getMessage());
                return bArr2;
            }
        }
        b.b(f15773b, "content or privateKey is null.");
        return bArr2;
    }

    public static byte[] encrypt(byte[] bArr, PublicKey publicKey) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && publicKey != null) {
            try {
                if (!isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
                    b.b(f15773b, "publicKey length is too short");
                    return bArr2;
                }
                Cipher cipher = Cipher.getInstance(f15772a);
                cipher.init(1, publicKey);
                return cipher.doFinal(bArr);
            } catch (ClassCastException unused) {
                b.b(f15773b, "RSA encrypt encrypt: ClassCastException");
                return bArr2;
            } catch (GeneralSecurityException e9) {
                b.b(f15773b, "RSA encrypt exception : " + e9.getMessage());
                return bArr2;
            }
        }
        b.b(f15773b, "content or PublicKey is null");
        return bArr2;
    }
}
