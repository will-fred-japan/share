package cn.jiguang.y;

import androidx.datastore.preferences.protobuf.C0524s;
import cn.jiguang.aw.t;
import cn.jiguang.x.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<Cipher> f10941d;

    static {
        String str = t.f9548d;
        f10938a = str;
        f10939b = t.f9549e;
        f10940c = str;
        f10941d = new ThreadLocal<Cipher>() { // from class: cn.jiguang.y.a.1
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Cipher initialValue() {
                try {
                    return Cipher.getInstance(a.f10939b);
                } catch (Exception e9) {
                    f.i("CryptoUtils", "Failed to create Cipher: " + e9.getMessage());
                    return null;
                }
            }
        };
    }

    private static Cipher a() {
        ThreadLocal<Cipher> threadLocal = f10941d;
        Cipher cipher = threadLocal.get();
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance(f10939b);
                threadLocal.set(cipher);
                return cipher;
            } catch (Exception e9) {
                f.i("CryptoUtils", "Failed to recreate Cipher: " + e9.getMessage());
            }
        }
        return cipher;
    }

    private static void a(int i9, String str, File file, File file2) {
        String strSubstring = str.substring(0, 16);
        StringBuilder sbA = C0524s.a(i9, "doCrypto cipherMode is ", ", key length is ");
        sbA.append(str.length());
        sbA.append(", IvParameterSpec length is ");
        sbA.append(strSubstring.length());
        sbA.append(", inputFile is ");
        sbA.append(file.getAbsolutePath());
        sbA.append(", outputFile is ");
        sbA.append(file2.getAbsolutePath());
        f.c("CryptoUtils", sbA.toString());
        try {
            Charset charset = StandardCharsets.UTF_8;
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(charset), f10940c);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(strSubstring.getBytes(charset));
            Cipher cipherA = a();
            if (cipherA == null) {
                cipherA = Cipher.getInstance(f10939b);
            }
            cipherA.init(i9, secretKeySpec, ivParameterSpec);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i10 = fileInputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        byte[] bArrUpdate = cipherA.update(bArr, 0, i10);
                        if (bArrUpdate != null) {
                            byteArrayOutputStream.write(bArrUpdate);
                        }
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                    byte[] bArrDoFinal = cipherA.doFinal();
                    if (bArrDoFinal != null) {
                        byteArrayOutputStream.write(bArrDoFinal);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        byteArrayOutputStream.writeTo(fileOutputStream);
                        fileOutputStream.close();
                        byteArrayOutputStream.close();
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                    throw th4;
                }
            } catch (Throwable th6) {
                fileInputStream.close();
                throw th6;
            }
        } catch (Exception e9) {
            f.b("CryptoUtils", "Error encrypting/decrypting file, error message is " + e9.getMessage(), e9);
        }
    }

    public static void a(String str, File file, File file2) {
        a(1, str, file, file2);
    }
}
