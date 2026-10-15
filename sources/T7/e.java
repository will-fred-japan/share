package T7;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.k;
import p188x7.f;
import p188x7.g;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static volatile Choreographer choreographer;

    static {
        Object objA;
        try {
            objA = new c(a(Looper.getMainLooper()), false);
        } catch (Throwable th) {
            objA = g.a(th);
        }
        if (objA instanceof f.a) {
            objA = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            k.c(objInvoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) objInvoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
