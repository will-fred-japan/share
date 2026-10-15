package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: CloseGuard.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CloseGuard {
    public static final Companion Companion = new Companion(null);
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    /* JADX INFO: compiled from: CloseGuard.kt */
    public static final class Companion {
        private Companion() {
        }

        public final CloseGuard get() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new CloseGuard(method, method3, method2);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public CloseGuard(Method method, Method method2, Method method3) {
        this.getMethod = method;
        this.openMethod = method2;
        this.warnIfOpenMethod = method3;
    }

    public final Object createAndOpen(String closer) {
        k.e(closer, "closer");
        Method method = this.getMethod;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, new Object[0]);
                Method method2 = this.openMethod;
                k.b(method2);
                method2.invoke(objInvoke, closer);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean warnIfOpen(Object obj) {
        if (obj != null) {
            try {
                Method method = this.warnIfOpenMethod;
                k.b(method);
                method.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
