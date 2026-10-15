package com.huawei.secure.android.common.encrypt.aes;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class CipherUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15705a = "CipherUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15706b = "AES/GCM/NoPadding";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15707c = "AES/CBC/PKCS5Padding";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15708d = "AES";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15709e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f15710f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f15711g = 12;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f15712h = 16;

    private static Cipher a(byte[] bArr, byte[] bArr2, int i9) {
        if (bArr2 != null && bArr2.length >= 16) {
            return a(bArr, bArr2, i9, f15707c);
        }
        b.b(f15705a, "cbc iv param is not right");
        return null;
    }

    private static Cipher b(byte[] bArr, byte[] bArr2, int i9) {
        if (bArr2 != null && bArr2.length >= 12) {
            return a(bArr, bArr2, i9, f15706b);
        }
        b.b(f15705a, "gcm iv param is not right");
        return null;
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesCbcDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr) {
        return getAesCbcEncryptCipher(bArr, EncryptUtil.generateSecureRandom(16));
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesCbcEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(16));
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesGcmDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr) {
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(12);
        b.a(f15705a, "getEncryptCipher: iv is : " + HexUtil.byteArray2HexStr(bArrGenerateSecureRandom));
        return getAesGcmEncryptCipher(bArr, bArrGenerateSecureRandom);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesGcmEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(12));
    }

    public static int getContent(Cipher cipher, byte[] bArr, byte[] bArr2) {
        if (cipher == null || bArr == null) {
            b.b(f15705a, "getEncryptCOntent: cipher is null or content is null");
            return -1;
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length, bArr2);
        } catch (BadPaddingException unused) {
            b.b(f15705a, "getContent: BadPaddingException");
            return -1;
        } catch (IllegalBlockSizeException unused2) {
            b.b(f15705a, "getContent: IllegalBlockSizeException");
            return -1;
        } catch (ShortBufferException unused3) {
            b.b(f15705a, "getContent: ShortBufferException");
            return -1;
        }
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 2);
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 1);
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(getAesCbcEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 2);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(getAesGcmEncryptCipher(bArr2, bArr3), bArr);
    }

    private static Cipher a(byte[] bArr, byte[] bArr2, int i9, String str) {
        AlgorithmParameterSpec ivParameterSpec;
        if (bArr != null && bArr.length >= 16 && AesGcm.isBuildVersionHigherThan19()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f15708d);
                Cipher cipher = Cipher.getInstance(str);
                if (f15706b.equals(str)) {
                    ivParameterSpec = AesGcm.getGcmAlgorithmParams(bArr2);
                } else {
                    ivParameterSpec = new IvParameterSpec(bArr2);
                }
                cipher.init(i9, secretKeySpec, ivParameterSpec);
                return cipher;
            } catch (GeneralSecurityException e9) {
                b.b(f15705a, "GCM encrypt data error" + e9.getMessage());
                return null;
            }
        }
        b.b(f15705a, "gcm encrypt param is not right");
        return null;
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 1);
    }

    @Deprecated
    public static int getContent(Cipher cipher, byte[] bArr, int i9, int i10, byte[] bArr2, int i11) {
        if (cipher != null && bArr != null) {
            return cipher.doFinal(bArr, i9, i10, bArr2, i11);
        }
        b.b(f15705a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    public static int getContent(CipherConfig cipherConfig) {
        if (cipherConfig == null) {
            return -1;
        }
        return getContent(cipherConfig.getCipher(), cipherConfig.getInput(), cipherConfig.getInputOffset(), cipherConfig.getInputLen(), cipherConfig.getOutput(), cipherConfig.getOutputOffset());
    }

    public static byte[] getContent(Cipher cipher, byte[] bArr) {
        if (cipher != null && bArr != null) {
            try {
                return cipher.doFinal(bArr, 0, bArr.length);
            } catch (BadPaddingException unused) {
                b.b(f15705a, "getContent: BadPaddingException");
                return new byte[0];
            } catch (IllegalBlockSizeException unused2) {
                b.b(f15705a, "getContent: IllegalBlockSizeException");
                return new byte[0];
            }
        }
        b.b(f15705a, "getEncryptCOntent: cipher is null or content is null");
        return new byte[0];
    }

    private static int a(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            return -1;
        }
        return cipher.getOutputSize(bArr.length);
    }
}
