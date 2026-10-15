package T0;

import V0.m;
import android.annotation.SuppressLint;
import com.bytedance.applog.encryptor.EncryptorUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: NewUserModeUtil.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public final class a {
    public static byte[] a(String str) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                int i9 = Y3.a.f5224e;
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(str.getBytes("UTF-8"));
                    gZIPOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        m.b(th);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        int i10 = Y3.a.f5224e;
                        return EncryptorUtil.a(byteArray.length, byteArray);
                    } catch (Throwable th2) {
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e9) {
                                m.b(e9);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException e10) {
                m.b(e10);
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        int i11 = Y3.a.f5224e;
        return EncryptorUtil.a(byteArray2.length, byteArray2);
    }
}
