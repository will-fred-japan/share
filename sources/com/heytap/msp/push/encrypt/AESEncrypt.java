package com.heytap.msp.push.encrypt;

import android.util.Base64;
import com.heytap.mcssdk.utils.e;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p171w.a;

/* JADX INFO: loaded from: classes.dex */
public class AESEncrypt {
    private static final String ALGORITHM = "AES";
    private static final String IV_CONNECT = "%IV1%";
    private static final int KEY_BYTE_SIZE = 256;
    public static final String SDK_APP_SECRET = "isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=";
    private static final String TRANSFORMATION = "AES/CTR/NoPadding";

    public static String decrypt(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String[] strArrSplit = str2.split(IV_CONNECT);
        byte[] bArrDecode = Base64.decode(strArrSplit[0], 0);
        byte[] bArrDecode2 = Base64.decode(strArrSplit[1], 0);
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 0), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArrDecode2));
        return new String(cipher.doFinal(bArrDecode));
    }

    public static String encrypt(String str) {
        try {
            return encrypt(SDK_APP_SECRET, str);
        } catch (Exception e9) {
            e.b(e9.getLocalizedMessage());
            return "";
        }
    }

    public static String genKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(256);
        return Base64.encodeToString(keyGenerator.generateKey().getEncoded(), 2);
    }

    public static String encrypt(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 0), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, secretKeySpec);
        return a.a(Base64.encodeToString(cipher.doFinal(str2.getBytes()), 2), IV_CONNECT, Base64.encodeToString(cipher.getIV(), 2));
    }
}
