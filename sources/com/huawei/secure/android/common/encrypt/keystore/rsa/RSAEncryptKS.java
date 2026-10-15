package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.b;
import defpackage.f;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class RSAEncryptKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15749a = "RSAEncryptKS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15750b = "AndroidKeyStore";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15751c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15752d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f15753e = 2048;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f15754f = 3072;

    private static boolean a() {
        return true;
    }

    private static PublicKey b(String str, boolean z8) {
        if (!b(str)) {
            a(str, z8);
        }
        Certificate certificateC = c(str);
        if (certificateC != null) {
            return certificateC.getPublicKey();
        }
        return null;
    }

    private static Certificate c(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(f15750b);
            keyStore.load(null);
            return keyStore.getCertificate(str);
        } catch (IOException e9) {
            b.b(f15749a, "IOException: " + e9.getMessage());
            return null;
        } catch (KeyStoreException e10) {
            b.b(f15749a, "KeyStoreException: " + e10.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e11) {
            b.b(f15749a, "NoSuchAlgorithmException: " + e11.getMessage());
            return null;
        } catch (CertificateException e12) {
            b.b(f15749a, "CertificateException: " + e12.getMessage());
            return null;
        } catch (Exception e13) {
            f.k(e13, new StringBuilder("Exception: "), f15749a);
            return null;
        }
    }

    @Deprecated
    public static String decrpyt(String str, String str2) {
        try {
            return new String(decrpyt(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e9) {
            b.b(f15749a, "UnsupportedEncodingException: " + e9.getMessage());
            return "";
        } catch (Exception e10) {
            f.k(e10, new StringBuilder("Exception: "), f15749a);
            return "";
        }
    }

    public static String decrpytNew(String str, String str2) {
        try {
            return new String(decrpytNew(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e9) {
            b.b(f15749a, "UnsupportedEncodingException: " + e9.getMessage());
            return "";
        } catch (Exception e10) {
            f.k(e10, new StringBuilder("Exception: "), f15749a);
            return "";
        }
    }

    @Deprecated
    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e9) {
            b.b(f15749a, "UnsupportedEncodingException: " + e9.getMessage());
            return "";
        }
    }

    public static String encryptNew(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encryptNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e9) {
            b.b(f15749a, "UnsupportedEncodingException: " + e9.getMessage());
            return "";
        }
    }

    private static byte[] a(String str, byte[] bArr, boolean z8) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(f15749a, "alias or content is null");
            return bArr2;
        }
        if (!a()) {
            b.b(f15749a, "sdk version is too low");
            return bArr2;
        }
        PublicKey publicKeyB = b(str, z8);
        if (publicKeyB == null) {
            b.b(f15749a, "Public key is null");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(f15751c);
            cipher.init(1, publicKeyB, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e9) {
            b.b(f15749a, "InvalidAlgorithmParameterException: " + e9.getMessage());
            return bArr2;
        } catch (InvalidKeyException e10) {
            b.b(f15749a, "InvalidKeyException: " + e10.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e11) {
            b.b(f15749a, "NoSuchAlgorithmException: " + e11.getMessage());
            return bArr2;
        } catch (BadPaddingException e12) {
            b.b(f15749a, "BadPaddingException: " + e12.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e13) {
            b.b(f15749a, "IllegalBlockSizeException: " + e13.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e14) {
            b.b(f15749a, "NoSuchPaddingException: " + e14.getMessage());
            return bArr2;
        } catch (Exception e15) {
            f.k(e15, new StringBuilder("Exception: "), f15749a);
            return bArr2;
        }
    }

    @Deprecated
    public static byte[] encrypt(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    public static byte[] encryptNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    private static boolean b(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(f15750b);
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e9) {
            b.b(f15749a, "IOException: " + e9.getMessage());
            return false;
        } catch (KeyStoreException e10) {
            b.b(f15749a, "KeyStoreException: " + e10.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e11) {
            b.b(f15749a, "NoSuchAlgorithmException: " + e11.getMessage());
            return false;
        } catch (UnrecoverableKeyException e12) {
            b.b(f15749a, "UnrecoverableKeyException: " + e12.getMessage());
            return false;
        } catch (CertificateException e13) {
            b.b(f15749a, "CertificateException: " + e13.getMessage());
            return false;
        } catch (Exception e14) {
            f.k(e14, new StringBuilder("Exception: "), f15749a);
            return false;
        }
    }

    @Deprecated
    public static byte[] decrpyt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f15749a, "sdk version is too low");
                return bArr2;
            }
            PrivateKey privateKeyA = a(str);
            if (privateKeyA == null) {
                b.b(f15749a, "Private key is null");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(f15751c);
                cipher.init(2, privateKeyA, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e9) {
                b.b(f15749a, "InvalidAlgorithmParameterException: " + e9.getMessage());
                return bArr2;
            } catch (InvalidKeyException e10) {
                b.b(f15749a, "InvalidKeyException: " + e10.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e11) {
                b.b(f15749a, "NoSuchAlgorithmException: " + e11.getMessage());
                return bArr2;
            } catch (BadPaddingException e12) {
                b.b(f15749a, "BadPaddingException: " + e12.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e13) {
                b.b(f15749a, "IllegalBlockSizeException: " + e13.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e14) {
                b.b(f15749a, "NoSuchPaddingException: " + e14.getMessage());
                return bArr2;
            } catch (Exception e15) {
                f.k(e15, new StringBuilder("Exception: "), f15749a);
                return bArr2;
            }
        }
        b.b(f15749a, "alias or encrypted content is null");
        return bArr2;
    }

    public static byte[] decrpytNew(String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    private static synchronized KeyPair a(String str, boolean z8) {
        KeyPair keyPairGenerateKeyPair = null;
        if (b(str)) {
            b.b(f15749a, "Key pair exits");
            return null;
        }
        b.c(f15749a, "generate key pair.");
        try {
            try {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", f15750b);
                    if (!z8) {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(2048).build());
                    } else {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(f15754f).build());
                    }
                    keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
                } catch (NoSuchAlgorithmException e9) {
                    b.b(f15749a, "NoSuchAlgorithmException: " + e9.getMessage());
                }
            } catch (NoSuchProviderException e10) {
                b.b(f15749a, "NoSuchProviderException: " + e10.getMessage());
            }
        } catch (InvalidAlgorithmParameterException e11) {
            b.b(f15749a, "InvalidAlgorithmParameterException: " + e11.getMessage());
        } catch (Exception e12) {
            b.b(f15749a, "Exception: " + e12.getMessage());
        }
        return keyPairGenerateKeyPair;
    }

    private static PrivateKey a(String str) {
        if (!b(str)) {
            return null;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(f15750b);
            keyStore.load(null);
            return (PrivateKey) keyStore.getKey(str, null);
        } catch (IOException e9) {
            b.b(f15749a, "IOException: " + e9.getMessage());
            return null;
        } catch (KeyStoreException e10) {
            b.b(f15749a, "KeyStoreException: " + e10.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e11) {
            b.b(f15749a, "NoSuchAlgorithmException: " + e11.getMessage());
            return null;
        } catch (UnrecoverableKeyException e12) {
            b.b(f15749a, "UnrecoverableKeyException: " + e12.getMessage());
            return null;
        } catch (CertificateException e13) {
            b.b(f15749a, "CertificateException: " + e13.getMessage());
            return null;
        } catch (Exception e14) {
            f.k(e14, new StringBuilder("Exception: "), f15749a);
            return null;
        }
    }
}
