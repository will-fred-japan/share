package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p044g0.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class FileSHA256 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f15713a = 8192;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15715c = "FileSHA256";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15716d = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15714b = "SHA-256";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f15717e = {f15714b, "SHA-384", "SHA-512"};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, f15714b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String fileSHAEncrypt(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str) || !a(str)) {
            b.b(f15715c, "algorithm is empty or not safe");
            return "";
        }
        if (!a(file)) {
            b.b(f15715c, "file is not valid");
            return "";
        }
        a.g gVar = 0;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    boolean z8 = false;
                    while (true) {
                        int i9 = fileInputStream.read(bArr);
                        if (i9 <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i9);
                        z8 = true;
                    }
                    String strByteArray2HexStr = z8 ? HexUtil.byteArray2HexStr(messageDigest.digest()) : null;
                    com.huawei.secure.android.common.encrypt.utils.a.a((InputStream) fileInputStream);
                    return strByteArray2HexStr;
                } catch (IOException e9) {
                    e = e9;
                    b.b(f15715c, "IOException" + e.getMessage());
                    com.huawei.secure.android.common.encrypt.utils.a.a((InputStream) fileInputStream);
                    return null;
                } catch (NoSuchAlgorithmException e10) {
                    e = e10;
                    b.b(f15715c, "NoSuchAlgorithmException" + e.getMessage());
                    com.huawei.secure.android.common.encrypt.utils.a.a((InputStream) fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                gVar = "";
                com.huawei.secure.android.common.encrypt.utils.a.a((InputStream) gVar);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e12) {
            e = e12;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.huawei.secure.android.common.encrypt.utils.a.a((InputStream) gVar);
            throw th;
        }
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        return inputStream == null ? "" : inputStreamSHAEncrypt(inputStream, f15714b);
    }

    public static String inputStreamSHAEncrypt(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        if (TextUtils.isEmpty(str) || !a(str)) {
            b.b(f15715c, "algorithm is empty or not safe");
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            while (true) {
                int i9 = inputStream.read(bArr);
                if (i9 < 0) {
                    return HexUtil.byteArray2HexStr(messageDigest.digest());
                }
                if (i9 > 0) {
                    messageDigest.update(bArr, 0, i9);
                }
                com.huawei.secure.android.common.encrypt.utils.a.a(inputStream);
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            b.b(f15715c, "inputstraem exception");
            return "";
        } finally {
            com.huawei.secure.android.common.encrypt.utils.a.a(inputStream);
        }
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(fileSHAEncrypt(file, str2));
        }
        b.b(f15715c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(inputStreamSHAEncrypt(inputStream, str2));
        }
        b.b(f15715c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }

    private static boolean a(String str) {
        for (String str2 : f15717e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
