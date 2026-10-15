package F7;

import java.lang.reflect.Method;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: F7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    public static final class C0014a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f2050a;

        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            k.b(methods);
            int length = methods.length;
            int i9 = 0;
            while (true) {
                method = null;
                if (i9 >= length) {
                    break;
                }
                Method method2 = methods[i9];
                if (k.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    k.d(parameterTypes, "getParameterTypes(...)");
                    if (k.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                        method = method2;
                        break;
                    }
                }
                i9++;
            }
            f2050a = method;
            int length2 = methods.length;
            for (int i10 = 0; i10 < length2 && !k.a(methods[i10].getName(), "getSuppressed"); i10++) {
            }
        }
    }

    public void a(Throwable cause, Throwable exception) {
        k.e(cause, "cause");
        k.e(exception, "exception");
        Method method = C0014a.f2050a;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }
}
