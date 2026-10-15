package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import defpackage.f;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes.dex */
public class AesCbcKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15735a = "CBCKS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15736b = "AndroidKeyStore";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15737c = "AES/CBC/PKCS7Padding";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15738d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f15739e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f15740f = 256;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Map<String, SecretKey> f15741g = new ConcurrentHashMap();

    private static boolean a() {
        return true;
    }

    private static SecretKey b(String str, Boolean bool) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f15741g.get(str) == null) {
            synchronized (AesCbcKS.class) {
                try {
                    if (f15741g.get(str) == null) {
                        SecretKey secretKeyA = a(str, bool);
                        if (secretKeyA == null) {
                            throw new AesKsParamException("AES CBC current is decrypt,but alias is null");
                        }
                        f15741g.put(str, secretKeyA);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15741g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f15735a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (AesKsParamException e9) {
            b.b(f15735a, "encrypt: AesKsParamException : " + e9.getMessage());
            return "";
        } catch (UnsupportedEncodingException e10) {
            b.b(f15735a, "encrypt: UnsupportedEncodingException : " + e10.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            b.b(f15735a, "encrypt 1 content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            b.b(f15735a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    private static SecretKey a(String str, Boolean bool) {
        b.c(f15735a, "load key");
        try {
            KeyStore keyStore = KeyStore.getInstance(f15736b);
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key != null && (key instanceof SecretKey)) {
                return (SecretKey) key;
            }
            if (bool.booleanValue()) {
                b.c(f15735a, "generate key");
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", f15736b);
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(256).build());
                return keyGenerator.generateKey();
            }
            return null;
        } catch (IOException e9) {
            b.b(f15735a, "IOException: " + e9.getMessage());
        } catch (InvalidAlgorithmParameterException e10) {
            b.b(f15735a, "InvalidAlgorithmParameterException: " + e10.getMessage());
        } catch (KeyStoreException e11) {
            b.b(f15735a, "KeyStoreException: " + e11.getMessage());
        } catch (NoSuchAlgorithmException e12) {
            b.b(f15735a, "NoSuchAlgorithmException: " + e12.getMessage());
        } catch (NoSuchProviderException e13) {
            b.b(f15735a, "NoSuchProviderException: " + e13.getMessage());
        } catch (UnrecoverableKeyException e14) {
            b.b(f15735a, "UnrecoverableKeyException: " + e14.getMessage());
        } catch (CertificateException e15) {
            b.b(f15735a, "CertificateException: " + e15.getMessage());
        } catch (Exception e16) {
            f.k(e16, new StringBuilder("Exception: "), f15735a);
        }
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f15735a, "sdk version is too low");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(f15737c);
                SecretKey secretKeyB = b(str, Boolean.TRUE);
                if (secretKeyB == null) {
                    b.b(f15735a, "encrypt secret key is null");
                    return bArr2;
                }
                cipher.init(1, secretKeyB);
                byte[] bArrDoFinal = cipher.doFinal(bArr);
                byte[] iv = cipher.getIV();
                if (iv != null && iv.length == 16) {
                    byte[] bArrCopyOf = Arrays.copyOf(iv, iv.length + bArrDoFinal.length);
                    System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv.length, bArrDoFinal.length);
                    return bArrCopyOf;
                }
                b.b(f15735a, "IV is invalid.");
                return bArr2;
            } catch (InvalidKeyException e9) {
                b.b(f15735a, "InvalidKeyException: " + e9.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e10) {
                b.b(f15735a, "NoSuchAlgorithmException: " + e10.getMessage());
                return bArr2;
            } catch (BadPaddingException e11) {
                b.b(f15735a, "BadPaddingException: " + e11.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e12) {
                b.b(f15735a, "IllegalBlockSizeException: " + e12.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e13) {
                b.b(f15735a, "NoSuchPaddingException: " + e13.getMessage());
                return bArr2;
            } catch (Exception e14) {
                f.k(e14, new StringBuilder("Exception: "), f15735a);
                return bArr2;
            }
        }
        b.b(f15735a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f15735a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 16) {
                b.b(f15735a, "Decrypt source data is invalid.");
                return bArr2;
            }
            SecretKey secretKeyB = b(str, Boolean.FALSE);
            if (secretKeyB == null) {
                b.b(f15735a, "decrypt secret key is null");
                return bArr2;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 16);
            try {
                Cipher cipher = Cipher.getInstance(f15737c);
                cipher.init(2, secretKeyB, new IvParameterSpec(bArrCopyOf));
                return cipher.doFinal(bArr, 16, bArr.length - 16);
            } catch (InvalidAlgorithmParameterException e9) {
                b.b(f15735a, "InvalidAlgorithmParameterException: " + e9.getMessage());
                return bArr2;
            } catch (InvalidKeyException e10) {
                b.b(f15735a, "InvalidKeyException: " + e10.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e11) {
                b.b(f15735a, "NoSuchAlgorithmException: " + e11.getMessage());
                return bArr2;
            } catch (BadPaddingException e12) {
                b.b(f15735a, "BadPaddingException: " + e12.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e13) {
                b.b(f15735a, "IllegalBlockSizeException: " + e13.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e14) {
                b.b(f15735a, "NoSuchPaddingException: " + e14.getMessage());
                return bArr2;
            } catch (Exception e15) {
                f.k(e15, new StringBuilder("Exception: "), f15735a);
                return bArr2;
            }
        }
        b.b(f15735a, "alias or encrypt content is null");
        return bArr2;
    }
}
