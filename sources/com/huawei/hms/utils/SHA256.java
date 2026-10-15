package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public abstract class SHA256 {
    public static byte[] digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e9) {
            HMSLog.e("SHA256", "NoSuchAlgorithmException" + e9.getMessage());
            return new byte[0];
        }
    }

    public static byte[] digest(File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[4096];
                    int i9 = 0;
                    while (true) {
                        int i10 = bufferedInputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        i9 += i10;
                        messageDigest.update(bArr, 0, i10);
                    }
                    if (i9 > 0) {
                        byte[] bArrDigest = messageDigest.digest();
                        IOUtils.closeQuietly((InputStream) bufferedInputStream);
                        return bArrDigest;
                    }
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                } catch (IOException | NoSuchAlgorithmException unused) {
                    bufferedInputStream2 = bufferedInputStream;
                    HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    throw th;
                }
            } catch (IOException | NoSuchAlgorithmException unused2) {
            }
            return new byte[0];
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
        }
    }
}
