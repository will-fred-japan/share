package cn.jiguang.commons.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public final class jv {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static byte[] a(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int i9 = gZIPInputStream.read(bArr2);
                    if (i9 < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a(byteArrayOutputStream);
                        a(byteArrayInputStream);
                        a(gZIPInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i9);
                }
            } catch (Throwable th2) {
                th = th2;
                a(byteArrayOutputStream);
                a(byteArrayInputStream);
                a(gZIPInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            gZIPInputStream = null;
            th = th3;
        }
    }
}
