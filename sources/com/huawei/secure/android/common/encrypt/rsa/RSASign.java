package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import defpackage.f;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class RSASign {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15778a = "SHA256WithRSA";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15779b = "SHA256WithRSA/PSS";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15780c = "RSASign";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15781d = "UTF-8";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15782e = "";

    private static String a(String str, String str2, boolean z8) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f15780c, "sign content or key is null");
            return "";
        }
        PrivateKey privateKey = EncryptUtil.getPrivateKey(str2);
        return z8 ? newSign(str, privateKey) : sign(str, privateKey);
    }

    public static boolean isBuildVersionHigherThan23() {
        return true;
    }

    public static String newSign(String str, String str2) {
        if (isBuildVersionHigherThan23()) {
            return a(str, str2, true);
        }
        b.b(f15780c, "sdk version is too low");
        return "";
    }

    public static boolean newVerifySign(String str, String str2, String str3) {
        if (isBuildVersionHigherThan23()) {
            return a(str, str2, str3, true);
        }
        b.b(f15780c, "sdk version is too low");
        return false;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        return a(str, str2, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        return a(str, str2, str3, false);
    }

    @Deprecated
    public static String sign(String str, PrivateKey privateKey) {
        return a(str, privateKey, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, PublicKey publicKey) {
        return a(str, str2, publicKey, false);
    }

    public static byte[] sign(byte[] bArr, PrivateKey privateKey, boolean z8) {
        Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr != null && privateKey != null) {
            try {
                if (!RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
                    b.b(f15780c, "privateKey length is too short");
                    return bArr2;
                }
                if (z8) {
                    signature = Signature.getInstance(f15779b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f15778a);
                }
                signature.initSign(privateKey);
                signature.update(bArr);
                return signature.sign();
            } catch (ClassCastException unused) {
                b.b(f15780c, "sign: ClassCastException");
                return bArr2;
            } catch (InvalidAlgorithmParameterException e9) {
                b.b(f15780c, "sign InvalidAlgorithmParameterException: " + e9.getMessage());
                return bArr2;
            } catch (InvalidKeyException e10) {
                b.b(f15780c, "sign InvalidKeyException: " + e10.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e11) {
                b.b(f15780c, "sign NoSuchAlgorithmException: " + e11.getMessage());
                return bArr2;
            } catch (SignatureException e12) {
                b.b(f15780c, "sign SignatureException: " + e12.getMessage());
                return bArr2;
            } catch (Exception e13) {
                f.k(e13, new StringBuilder("sign Exception: "), f15780c);
                return bArr2;
            }
        }
        b.b(f15780c, "content or privateKey is null.");
        return bArr2;
    }

    public static boolean verifySign(byte[] bArr, byte[] bArr2, PublicKey publicKey, boolean z8) {
        Signature signature;
        if (bArr != null && publicKey != null && bArr2 != null) {
            try {
                if (!RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
                    b.b(f15780c, "publicKey length is too short");
                    return false;
                }
                if (z8) {
                    signature = Signature.getInstance(f15779b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f15778a);
                }
                signature.initVerify(publicKey);
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (ClassCastException unused) {
                b.b(f15780c, "verifySign: ClassCastException");
                return false;
            } catch (GeneralSecurityException e9) {
                b.b(f15780c, "check sign exception: " + e9.getMessage());
                return false;
            } catch (Exception e10) {
                f.k(e10, new StringBuilder("exception : "), f15780c);
                return false;
            }
        }
        b.b(f15780c, "content or publicKey is null.");
        return false;
    }

    public static String newSign(String str, PrivateKey privateKey) {
        if (!isBuildVersionHigherThan23()) {
            b.b(f15780c, "sdk version is too low");
            return "";
        }
        return a(str, privateKey, true);
    }

    public static boolean newVerifySign(String str, String str2, PublicKey publicKey) {
        if (!isBuildVersionHigherThan23()) {
            b.b(f15780c, "sdk version is too low");
            return false;
        }
        return a(str, str2, publicKey, true);
    }

    private static String a(String str, PrivateKey privateKey, boolean z8) {
        try {
            return Base64.encodeToString(sign(str.getBytes("UTF-8"), privateKey, z8), 0);
        } catch (UnsupportedEncodingException e9) {
            b.b(f15780c, "sign UnsupportedEncodingException: " + e9.getMessage());
            return "";
        }
    }

    private static boolean a(String str, String str2, String str3, boolean z8) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            RSAPublicKey publicKey = EncryptUtil.getPublicKey(str3);
            if (z8) {
                return newVerifySign(str, str2, publicKey);
            }
            return verifySign(str, str2, publicKey);
        }
        b.b(f15780c, "content or public key or sign value is null");
        return false;
    }

    private static boolean a(String str, String str2, PublicKey publicKey, boolean z8) {
        try {
            return verifySign(str.getBytes("UTF-8"), Base64.decode(str2, 0), publicKey, z8);
        } catch (UnsupportedEncodingException e9) {
            b.b(f15780c, "verifySign UnsupportedEncodingException: " + e9.getMessage());
            return false;
        } catch (Exception e10) {
            f.k(e10, new StringBuilder("base64 decode Exception : "), f15780c);
            return false;
        }
    }

    public static boolean verifySign(ByteBuffer byteBuffer, byte[] bArr, PublicKey publicKey, boolean z8) {
        Signature signature;
        if (byteBuffer != null && publicKey != null && bArr != null) {
            try {
                if (!RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
                    b.b(f15780c, "publicKey length is too short");
                    return false;
                }
                if (z8) {
                    signature = Signature.getInstance(f15779b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f15778a);
                }
                signature.initVerify(publicKey);
                signature.update(byteBuffer);
                return signature.verify(bArr);
            } catch (ClassCastException unused) {
                b.b(f15780c, "verifySign: ClassCastException");
                return false;
            } catch (GeneralSecurityException e9) {
                b.b(f15780c, "check sign exception: " + e9.getMessage());
                return false;
            } catch (Exception e10) {
                f.k(e10, new StringBuilder("exception : "), f15780c);
                return false;
            }
        }
        b.b(f15780c, "content or publicKey is null.");
        return false;
    }

    public static byte[] sign(ByteBuffer byteBuffer, PrivateKey privateKey, boolean z8) {
        Signature signature;
        byte[] bArr = new byte[0];
        if (byteBuffer != null && privateKey != null) {
            try {
                if (!RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
                    b.b(f15780c, "privateKey length is too short");
                    return bArr;
                }
                if (z8) {
                    signature = Signature.getInstance(f15779b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f15778a);
                }
                signature.initSign(privateKey);
                signature.update(byteBuffer);
                byte[] bArrSign = signature.sign();
                b.c(f15780c, "result is : " + Arrays.toString(bArrSign));
                return bArrSign;
            } catch (ClassCastException unused) {
                b.b(f15780c, "sign: ClassCastException");
                return bArr;
            } catch (InvalidAlgorithmParameterException e9) {
                b.b(f15780c, "sign InvalidAlgorithmParameterException: " + e9.getMessage());
                return bArr;
            } catch (InvalidKeyException e10) {
                b.b(f15780c, "sign InvalidKeyException: " + e10.getMessage());
                return bArr;
            } catch (NoSuchAlgorithmException e11) {
                b.b(f15780c, "sign NoSuchAlgorithmException: " + e11.getMessage());
                return bArr;
            } catch (SignatureException e12) {
                b.b(f15780c, "sign SignatureException: " + e12.getMessage());
                return bArr;
            } catch (Exception e13) {
                f.k(e13, new StringBuilder("sign Exception: "), f15780c);
                return bArr;
            }
        }
        b.b(f15780c, "content or privateKey is null.");
        return bArr;
    }
}
