package Z2;

import android.os.Handler;
import android.os.Looper;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: Tools.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    static {
        new Handler(Looper.getMainLooper());
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() > 0) {
                return str.getBytes("UTF-8");
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }
}
