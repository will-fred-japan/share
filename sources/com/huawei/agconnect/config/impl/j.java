package com.huawei.agconnect.config.impl;

import android.util.Log;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static SecretKey a(d dVar) throws InvalidKeySpecException {
        if (dVar == null || !dVar.a()) {
            throw new IllegalArgumentException("invalid data for generating the key.");
        }
        Log.d("AGC_Keys", "build aes key, iterationCount:" + dVar.g());
        SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance(dVar.f()).generateSecret(new PBEKeySpec(Hex.encodeHexString(a(Hex.decodeHexString(dVar.b()), Hex.decodeHexString(dVar.c()), Hex.decodeHexString(dVar.d()))).toCharArray(), Hex.decodeHexString(dVar.e()), dVar.g(), dVar.h() * 8));
        Log.d("AGC_Keys", "build aes key end");
        return new SecretKeySpec(secretKeyGenerateSecret.getEncoded(), "AES");
    }

    public static byte[] a(SecretKey secretKey, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(bArrCopyOfRange));
        return cipher.doFinal(bArr, bArrCopyOfRange.length + 1, (bArr.length - bArrCopyOfRange.length) - 1);
    }

    private static byte[] a(byte[] bArr, int i9) {
        if (bArr == null) {
            throw new NullPointerException("bytes must not be null.");
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (i9 < 0) {
                bArr[i10] = (byte) (bArr[i10] << (-i9));
            } else {
                bArr[i10] = (byte) (bArr[i10] >> i9);
            }
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        }
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i9 = 0; i9 < bArr.length; i9++) {
            bArr3[i9] = (byte) (bArr[i9] ^ bArr2[i9]);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(a(a(a(bArr, -4), bArr2), 6), bArr3);
    }
}
