package p156u0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: Trace.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f21665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f21666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f21667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f21668d;

    public static void a(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 29) {
            return b.c();
        }
        try {
            if (f21666b == null) {
                f21665a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f21666b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f21666b.invoke(null, Long.valueOf(f21665a))).booleanValue();
        } catch (Exception e9) {
            a("isTagEnabled", e9);
            return false;
        }
    }

    public static String c(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
