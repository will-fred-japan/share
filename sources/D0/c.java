package D0;

import android.annotation.SuppressLint;
import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ConsumerAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanUncheckedReflection"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f1815a;

    /* JADX INFO: compiled from: ConsumerAdapter.kt */
    public static final class a<T> implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kotlin.jvm.internal.d f1816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final I0.b f1817b;

        public a(kotlin.jvm.internal.d dVar, I0.b bVar) {
            this.f1816a = dVar;
            this.f1817b = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            k.e(obj, "obj");
            k.e(method, "method");
            boolean zA = k.a(method.getName(), "accept");
            I0.b bVar = this.f1817b;
            if (zA && objArr != null && objArr.length == 1) {
                Object obj2 = objArr[0];
                p142s2.j.o(this.f1816a, obj2);
                bVar.invoke(obj2);
                return p188x7.k.f22364a;
            }
            if (k.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(obj == objArr[0]);
            }
            if (k.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) {
                return Integer.valueOf(bVar.hashCode());
            }
            if (k.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null) {
                return bVar.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    /* JADX INFO: compiled from: ConsumerAdapter.kt */
    public interface b {
        void dispose();
    }

    public c(ClassLoader classLoader) {
        this.f1815a = classLoader;
    }

    public final d a(Object obj, kotlin.jvm.internal.d dVar, Activity activity, I0.b bVar) throws IllegalAccessException, InvocationTargetException {
        a aVar = new a(dVar, bVar);
        Object objNewProxyInstance = Proxy.newProxyInstance(this.f1815a, new Class[]{b()}, aVar);
        k.d(objNewProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        obj.getClass().getMethod("addWindowLayoutInfoListener", Activity.class, b()).invoke(obj, activity, objNewProxyInstance);
        return new d(obj.getClass().getMethod("removeWindowLayoutInfoListener", b()), obj, objNewProxyInstance);
    }

    public final Class<?> b() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f1815a.loadClass("java.util.function.Consumer");
        k.d(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }
}
