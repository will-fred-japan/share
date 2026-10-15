package com.engagelab.privates.common.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes.dex */
public class AESUtil {
    public static String decryptWithKeystoreAesGcm(String str) {
        return SecurePrefs.decrypt(str);
    }

    public static String encryptWithKeystoreAesGcm(String str) {
        return SecurePrefs.encrypt(str);
    }

    private static byte[] generateKeyBytes(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }

    public static int generateSeed() {
        return Math.abs(new SecureRandom().nextInt()) & 16777215;
    }

    public static String get16Md5AesKey(long j) {
        long j8;
        long j9;
        switch ((int) (j % 10)) {
            case 1:
                j8 = 5 * j;
                j9 = j % 88;
                break;
            case 2:
                j8 = 23 * j;
                j9 = j % 15;
                break;
            case 3:
                j8 = 3 * j;
                j9 = j % 73;
                break;
            case 4:
                j8 = 13 * j;
                j9 = j % 96;
                break;
            case 5:
                j8 = 17 * j;
                j9 = j % 49;
                break;
            case 6:
                j8 = 7 * j;
                j9 = j % 68;
                break;
            case 7:
                j8 = 31 * j;
                j9 = j % 39;
                break;
            case 8:
                j8 = 29 * j;
                j9 = j % 41;
                break;
            case 9:
                j8 = 37 * j;
                j9 = j % 91;
                break;
            default:
                j8 = 8 * j;
                j9 = j % 74;
                break;
        }
        return StringUtil.get16MD5String("JCKP" + (j9 + j8));
    }

    public static String getIv(String str, char c5) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        for (int i9 = 0; i9 < bytes.length; i9++) {
            bytes[i9] = (byte) (bytes[i9] ^ c5);
        }
        return new String(bytes, 0, bytes.length);
    }

    public static String getMd5AesKey(long j) {
        long j8;
        long j9;
        switch ((int) (j % 10)) {
            case 1:
                j8 = 5 * j;
                j9 = j % 88;
                break;
            case 2:
                j8 = 23 * j;
                j9 = j % 15;
                break;
            case 3:
                j8 = 3 * j;
                j9 = j % 73;
                break;
            case 4:
                j8 = 13 * j;
                j9 = j % 96;
                break;
            case 5:
                j8 = 17 * j;
                j9 = j % 49;
                break;
            case 6:
                j8 = 7 * j;
                j9 = j % 68;
                break;
            case 7:
                j8 = 31 * j;
                j9 = j % 39;
                break;
            case 8:
                j8 = 29 * j;
                j9 = j % 41;
                break;
            case 9:
                j8 = 37 * j;
                j9 = j % 91;
                break;
            default:
                j8 = 8 * j;
                j9 = j % 74;
                break;
        }
        return StringUtil.get32MD5String("JCKP" + (j9 + j8));
    }

    private static IvParameterSpec reflectGetIv(byte[] bArr) {
        return (IvParameterSpec) ReflectUtil.invokeConstructor(IvParameterSpec.class, new Object[]{bArr}, new Class[]{byte[].class});
    }
}
