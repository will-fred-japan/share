package com.starburst.sdk.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class AesCbcTools {
    private static final String AES_CBC_PADDING = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM = "AES";

    public static byte[] decodeByCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_CBC_PADDING);
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher.doFinal(bArr3);
    }

    public static byte[] encodeByCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_CBC_PADDING);
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher.doFinal(bArr3);
    }

    public static byte[] getSecretKey(String str, String str2, String str3) throws Exception {
        int i9;
        byte[] bArr = new byte[16];
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int i10 = 8;
        if (bytes.length < 8) {
            throw new Exception("sonce 小于8字节");
        }
        for (int i11 = 0; i11 < 8; i11++) {
            bArr[i11] = bytes[i11];
        }
        byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
        if (bytes2.length < 4) {
            throw new Exception("ts 小于4个字节");
        }
        while (true) {
            if (i10 >= 12) {
                break;
            }
            bArr[i10] = bytes2[i10 - 8];
            i10++;
        }
        byte[] bytes3 = str3.getBytes(StandardCharsets.UTF_8);
        if (bytes3.length < 4) {
            throw new Exception("pk 小于4个字节");
        }
        for (i9 = 12; i9 < 16; i9++) {
            bArr[i9] = bytes3[i9 - 12];
        }
        return bArr;
    }
}
