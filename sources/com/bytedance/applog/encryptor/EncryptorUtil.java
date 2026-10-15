package com.bytedance.applog.encryptor;

/* JADX INFO: loaded from: classes.dex */
public class EncryptorUtil {
    static {
        try {
            System.loadLibrary("EncryptorP");
        } catch (UnsatisfiedLinkError e9) {
            e9.printStackTrace();
        }
    }

    public static byte[] a(int i9, byte[] bArr) {
        if (bArr != null && i9 > 0) {
            try {
                if (bArr.length == i9) {
                    return ttEncrypt(bArr, i9);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static native byte[] ttEncrypt(byte[] bArr, int i9);
}
