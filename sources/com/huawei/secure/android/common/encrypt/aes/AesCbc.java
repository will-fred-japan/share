package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import defpackage.f;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class AesCbc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15684a = "security:";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15685b = "AES/CBC/PKCS5Padding";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15686c = "AES";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15687d = "CBC";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15688e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f15689f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f15690g = 16;

    private AesCbc() {
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f15687d, "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            b.b(f15687d, "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            b.b(f15687d, "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            b.b(f15687d, "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            b.b(f15687d, "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e9) {
            b.b(f15687d, " cbc encrypt data error" + e9.getMessage());
            return new byte[0];
        }
    }

    private static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            b.b(f15687d, "get content error, because bt length is less than 16");
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    private static byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            b.b(f15687d, "get iv error, because bt length is less than 16");
            return new byte[0];
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    public static byte[] d(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e9) {
            b.b(f15687d, "stripCryptHead: exception : " + e9.getMessage());
            str = "";
        }
        if (!str.startsWith(f15684a)) {
            return new byte[0];
        }
        if (bArr.length <= 9) {
            return new byte[0];
        }
        int length = bArr.length - 9;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 9, bArr2, 0, length);
        return bArr2;
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f15687d, "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            b.b(f15687d, "decrypt 1 key is null");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (bArrHexStr2ByteArray.length >= 16) {
            return decrypt(str, bArrHexStr2ByteArray);
        }
        b.b(f15687d, "decrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String strC = c(str);
            if ("".equals(strC)) {
                return "";
            }
            int iIndexOf = strC.indexOf(58);
            if (iIndexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(strC.substring(iIndexOf + 1))), bArr, HexUtil.hexStr2ByteArray(strC.substring(0, iIndexOf)));
            }
            b.b(f15687d, " cbc cipherText data missing colon");
        }
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] bArrD = d(bArr);
        if (bArrD.length == 0) {
            return new byte[0];
        }
        int iA = a(bArrD);
        if (iA < 0) {
            b.b(f15687d, " cbc cipherText data missing colon");
            return new byte[0];
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArrD, iA);
        int length = (bArrD.length - bArrCopyOf.length) - 1;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArrD, iA + 1, bArr3, 0, length);
        return decrypt(bArr3, bArr2, bArrCopyOf);
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f15687d, "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            b.b(f15687d, "encrypt 1 key is null");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (bArrHexStr2ByteArray.length >= 16) {
            return encrypt(str, bArrHexStr2ByteArray);
        }
        b.b(f15687d, "encrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e9) {
            f.k(e9, new StringBuilder("getIv exception : "), f15687d);
            return "";
        }
    }

    public static String c(String str) {
        return (TextUtils.isEmpty(str) || str.indexOf(f15684a) == -1) ? "" : str.substring(9);
    }

    public static String decrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.b(f15687d, "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            b.b(f15687d, "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            b.b(f15687d, "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        String strB = b(str);
        String strA = a(str);
        if (TextUtils.isEmpty(strB)) {
            b.b(f15687d, "decrypt 2 iv is null");
            return "";
        }
        if (TextUtils.isEmpty(strA)) {
            b.b(f15687d, "decrypt 2 encrypt content is null");
            return "";
        }
        return decrypt(strA, bArr, HexUtil.hexStr2ByteArray(strB));
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            b.b(f15687d, "decryptWithCryptHead UnsupportedEncodingException ");
            return "";
        }
    }

    public static String encrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.b(f15687d, "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            b.b(f15687d, "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            b.b(f15687d, "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(16);
        byte[] bArrA = a(str, bArr, bArrGenerateSecureRandom);
        return (bArrA == null || bArrA.length == 0) ? "" : a(HexUtil.byteArray2HexStr(bArrGenerateSecureRandom), HexUtil.byteArray2HexStr(bArrA));
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e9) {
                f.k(e9, new StringBuilder("mix exception: "), f15687d);
            }
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b.b(f15687d, "encrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            b.b(f15687d, "encrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            b.b(f15687d, "encrypt 3 iv is null");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (bArrHexStr2ByteArray.length < 16) {
            b.b(f15687d, "encrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (bArrHexStr2ByteArray2.length < 16) {
            b.b(f15687d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return encrypt(str, bArrHexStr2ByteArray, bArrHexStr2ByteArray2);
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b.b(f15687d, "decrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            b.b(f15687d, "decrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            b.b(f15687d, "decrypt 3 iv is null");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (bArrHexStr2ByteArray.length < 16) {
            b.b(f15687d, "decrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (bArrHexStr2ByteArray2.length < 16) {
            b.b(f15687d, "decrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return decrypt(str, bArrHexStr2ByteArray, bArrHexStr2ByteArray2);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f15687d, "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            b.b(f15687d, "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            b.b(f15687d, "encrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            b.b(f15687d, "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            b.b(f15687d, "encrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        return HexUtil.byteArray2HexStr(a(str, bArr, bArr2));
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f15687d, "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            b.b(f15687d, "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            b.b(f15687d, "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            b.b(f15687d, "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            b.b(f15687d, "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        try {
            return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e9) {
            b.b(f15687d, " cbc decrypt data error" + e9.getMessage());
            return "";
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e9) {
            f.k(e9, new StringBuilder("get encryptword exception : "), f15687d);
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.b(f15687d, "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            b.b(f15687d, "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            b.b(f15687d, "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            b.b(f15687d, "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            b.b(f15687d, "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            b.b(f15687d, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f15686c);
        try {
            Cipher cipher = Cipher.getInstance(f15685b);
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e9) {
            b.b(f15687d, "NullPointerException: " + e9.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e10) {
            b.b(f15687d, "InvalidAlgorithmParameterException: " + e10.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e11) {
            b.b(f15687d, "InvalidKeyException: " + e11.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e12) {
            b.b(f15687d, "NoSuchAlgorithmException: " + e12.getMessage());
            return new byte[0];
        } catch (BadPaddingException e13) {
            b.b(f15687d, "BadPaddingException: " + e13.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e14) {
            b.b(f15687d, "IllegalBlockSizeException: " + e14.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e15) {
            b.b(f15687d, "NoSuchPaddingException: " + e15.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.b(f15687d, "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            b.b(f15687d, "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            b.b(f15687d, "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            b.b(f15687d, "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            b.b(f15687d, "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            b.b(f15687d, "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f15686c);
        try {
            Cipher cipher = Cipher.getInstance(f15685b);
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e9) {
            b.b(f15687d, "NullPointerException: " + e9.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e10) {
            b.b(f15687d, "InvalidAlgorithmParameterException: " + e10.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e11) {
            b.b(f15687d, "InvalidKeyException: " + e11.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e12) {
            b.b(f15687d, "NoSuchAlgorithmException: " + e12.getMessage());
            return new byte[0];
        } catch (BadPaddingException e13) {
            b.b(f15687d, "BadPaddingException: " + e13.getMessage());
            b.b(f15687d, "key is not right");
            return new byte[0];
        } catch (IllegalBlockSizeException e14) {
            b.b(f15687d, "IllegalBlockSizeException: " + e14.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e15) {
            b.b(f15687d, "NoSuchPaddingException: " + e15.getMessage());
            return new byte[0];
        }
    }

    private static int a(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(16);
        byte[] bArrEncrypt = encrypt(bArr, bArr2, bArrGenerateSecureRandom);
        if (Arrays.equals(bArrEncrypt, new byte[0])) {
            b.b(f15687d, "encrypt encryptContent is null");
            return new byte[0];
        }
        return a(bArrGenerateSecureRandom, bArrEncrypt);
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(b(bArr), bArr2, c(bArr));
    }
}
