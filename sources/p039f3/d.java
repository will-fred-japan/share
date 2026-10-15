package p039f3;

import android.content.Context;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: LogLib.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f18687a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f18688b;

    /* JADX INFO: compiled from: LogLib.java */
    public static class a implements b {
        @Override // f3.d.b
        public final boolean a(Context context) {
            return false;
        }
    }

    /* JADX INFO: compiled from: LogLib.java */
    public interface b {
        boolean a(Context context);
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
