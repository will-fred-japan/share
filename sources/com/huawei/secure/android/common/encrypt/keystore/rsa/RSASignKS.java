package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
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
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes.dex */
public abstract class RSASignKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15755a = "RSASignKS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15756b = "AndroidKeyStore";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15757c = "SHA256withRSA/PSS";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15758d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f15759e = 2048;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f15760f = 3072;

    private static byte[] a(String str, byte[] bArr, boolean z8) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(f15755a, "alias or content is null");
            return bArr2;
        }
        if (!isBuildVersionHigherThan22()) {
            b.b(f15755a, "sdk version is too low");
            return bArr2;
        }
        KeyStore.Entry entryB = b(str, z8);
        if (!(entryB instanceof KeyStore.PrivateKeyEntry)) {
            b.b(f15755a, "Not an instance of a PrivateKeyEntry");
            return bArr2;
        }
        try {
            Signature signature = Signature.getInstance(f15757c);
            signature.initSign(((KeyStore.PrivateKeyEntry) entryB).getPrivateKey());
            signature.update(bArr);
            return signature.sign();
        } catch (InvalidKeyException e9) {
            b.b(f15755a, "InvalidKeyException: " + e9.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e10) {
            b.b(f15755a, "NoSuchAlgorithmException: " + e10.getMessage());
            return bArr2;
        } catch (SignatureException e11) {
            b.b(f15755a, "SignatureException: " + e11.getMessage());
            return bArr2;
        } catch (Exception e12) {
            f.k(e12, new StringBuilder("Exception: "), f15755a);
            return bArr2;
        }
    }

    private static KeyStore.Entry b(String str, boolean z8) {
        if (!a(str)) {
            a(str, z8);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(f15756b);
            keyStore.load(null);
            return keyStore.getEntry(str, null);
        } catch (IOException e9) {
            b.b(f15755a, "IOException: " + e9.getMessage());
            return null;
        } catch (KeyStoreException e10) {
            b.b(f15755a, "KeyStoreException: " + e10.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e11) {
            b.b(f15755a, "NoSuchAlgorithmException: " + e11.getMessage());
            return null;
        } catch (UnrecoverableEntryException e12) {
            b.b(f15755a, "UnrecoverableEntryException: " + e12.getMessage());
            return null;
        } catch (CertificateException e13) {
            b.b(f15755a, "CertificateException: " + e13.getMessage());
            return null;
        }
    }

    public static boolean isBuildVersionHigherThan22() {
        return true;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        try {
            return Base64.encodeToString(sign(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e9) {
            Log.e(f15755a, "sign UnsupportedEncodingException : " + e9.getMessage());
            return "";
        }
    }

    public static String signNew(String str, String str2) {
        try {
            return Base64.encodeToString(signNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e9) {
            Log.e(f15755a, "sign UnsupportedEncodingException : " + e9.getMessage());
            return "";
        }
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        try {
            return verifySign(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e9) {
            Log.e(f15755a, "verifySign UnsupportedEncodingException: " + e9.getMessage());
            return false;
        } catch (Exception e10) {
            f.k(e10, new StringBuilder("base64 decode Exception"), f15755a);
            return false;
        }
    }

    public static boolean verifySignNew(String str, String str2, String str3) {
        try {
            return verifySignNew(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e9) {
            Log.e(f15755a, "verifySign UnsupportedEncodingException: " + e9.getMessage());
            return false;
        } catch (Exception e10) {
            f.k(e10, new StringBuilder("base64 decode Exception"), f15755a);
            return false;
        }
    }

    @Deprecated
    public static byte[] sign(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    public static byte[] signNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    @Deprecated
    public static boolean verifySign(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, false);
    }

    public static boolean verifySignNew(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, true);
    }

    private static boolean a(String str, byte[] bArr, byte[] bArr2, boolean z8) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr2 != null) {
            if (!isBuildVersionHigherThan22()) {
                b.b(f15755a, "sdk version is too low");
                return false;
            }
            KeyStore.Entry entryB = b(str, z8);
            if (!(entryB instanceof KeyStore.PrivateKeyEntry)) {
                b.b(f15755a, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            try {
                Signature signature = Signature.getInstance(f15757c);
                signature.initVerify(((KeyStore.PrivateKeyEntry) entryB).getCertificate());
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (InvalidKeyException e9) {
                b.b(f15755a, "InvalidKeyException: " + e9.getMessage());
                return false;
            } catch (NoSuchAlgorithmException e10) {
                b.b(f15755a, "NoSuchAlgorithmException: " + e10.getMessage());
                return false;
            } catch (SignatureException e11) {
                b.b(f15755a, "SignatureException: " + e11.getMessage());
                return false;
            } catch (Exception e12) {
                f.k(e12, new StringBuilder("Exception: "), f15755a);
                return false;
            }
        }
        b.b(f15755a, "alias or content or sign value is null");
        return false;
    }

    private static synchronized KeyPair a(String str, boolean z8) {
        KeyPair keyPairGenerateKeyPair = null;
        if (a(str)) {
            b.b(f15755a, "Key pair exits");
            return null;
        }
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", f15756b);
            if (!z8) {
                keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512").setSignaturePaddings("PSS").setKeySize(2048).build());
            } else {
                keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512").setSignaturePaddings("PSS").setKeySize(f15760f).build());
            }
            keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        } catch (InvalidAlgorithmParameterException e9) {
            b.b(f15755a, "InvalidAlgorithmParameterException: " + e9.getMessage());
        } catch (NoSuchAlgorithmException e10) {
            b.b(f15755a, "NoSuchAlgorithmException: " + e10.getMessage());
        } catch (NoSuchProviderException e11) {
            b.b(f15755a, "NoSuchProviderException: " + e11.getMessage());
        }
        return keyPairGenerateKeyPair;
    }

    private static boolean a(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(f15756b);
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e9) {
            b.b(f15755a, "IOException: " + e9.getMessage());
            return false;
        } catch (KeyStoreException e10) {
            b.b(f15755a, "KeyStoreException: " + e10.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e11) {
            b.b(f15755a, "NoSuchAlgorithmException: " + e11.getMessage());
            return false;
        } catch (UnrecoverableKeyException e12) {
            b.b(f15755a, "UnrecoverableKeyException: " + e12.getMessage());
            return false;
        } catch (CertificateException e13) {
            b.b(f15755a, "CertificateException: " + e13.getMessage());
            return false;
        }
    }
}
