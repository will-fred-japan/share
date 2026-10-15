package cn.jiguang.internal;

import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class JNAction {
    public static native boolean a(String str, String str2);

    public static native boolean d(String str);

    public static native String gs(String str);

    public static native void i(String str, long j, int i9);

    public static boolean load() {
        try {
            System.loadLibrary("jutils");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean loadPath(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        if (Build.VERSION.SDK_INT >= 34 && file.canWrite()) {
                            file.setReadOnly();
                        }
                        System.load(str);
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static native void mi(int i9, Object obj);

    public static native byte[] r(String str);

    public static native void s(String str, long j, int i9, String str2);

    public static native String v();

    public static native boolean w(String str, String str2);
}
