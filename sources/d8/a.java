package d8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface;

/* JADX INFO: compiled from: BoundaryInterfaceReflectionUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BoundaryInterfaceReflectionUtil.java */
    public static class C0195a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FeatureFlagHolderBoundaryInterface f18538a;

        public C0195a(FeatureFlagHolderBoundaryInterface featureFlagHolderBoundaryInterface) {
            this.f18538a = featureFlagHolderBoundaryInterface;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            FeatureFlagHolderBoundaryInterface featureFlagHolderBoundaryInterface = this.f18538a;
            try {
                return Class.forName(method.getDeclaringClass().getName(), true, featureFlagHolderBoundaryInterface.getClass().getClassLoader()).getDeclaredMethod(method.getName(), method.getParameterTypes()).invoke(featureFlagHolderBoundaryInterface, objArr);
            } catch (InvocationTargetException e9) {
                throw e9.getTargetException();
            } catch (ReflectiveOperationException e10) {
                throw new RuntimeException("Reflection failed for method " + method, e10);
            }
        }
    }

    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
