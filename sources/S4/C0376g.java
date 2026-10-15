package S4;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: S4.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0376g {
    public static void a(String str, boolean z8) {
        if (!z8) {
            throw new IllegalArgumentException(String.valueOf(str));
        }
    }

    public static void b(boolean z8, String str, Object... objArr) {
        if (!z8) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void c(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            throw new IllegalStateException("Must be called on " + handler.getLooper().getThread().getName() + " thread, but got " + name + ".");
        }
    }

    @EnsuresNonNull({"#1"})
    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
    }

    @EnsuresNonNull({"#1"})
    public static void e(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    @EnsuresNonNull({"#1"})
    public static void f(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void g(String str, boolean z8) {
        if (!z8) {
            throw new IllegalStateException(str);
        }
    }
}
