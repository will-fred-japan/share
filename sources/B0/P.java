package B0;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: WebViewGlueCommunicator.java */
/* JADX INFO: loaded from: classes.dex */
public final class P {

    /* JADX INFO: compiled from: WebViewGlueCommunicator.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final T f1664a = new T(1, b.f1665a.getWebkitToCompatConverter());
    }

    /* JADX INFO: compiled from: WebViewGlueCommunicator.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final S f1665a;

        static {
            S c0309x;
            try {
                c0309x = new T(0, (WebViewProviderFactoryBoundaryInterface) d8.a.a(WebViewProviderFactoryBoundaryInterface.class, P.a()));
            } catch (ClassNotFoundException unused) {
                c0309x = new C0309x();
            } catch (IllegalAccessException e9) {
                throw new RuntimeException(e9);
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
            f1665a = c0309x;
        }
    }

    public static InvocationHandler a() {
        ClassLoader classLoader;
        if (Build.VERSION.SDK_INT >= 28) {
            classLoader = C0299m.b();
        } else {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", new Class[0]);
                declaredMethod.setAccessible(true);
                classLoader = declaredMethod.invoke(null, new Object[0]).getClass().getClassLoader();
            } catch (IllegalAccessException e9) {
                throw new RuntimeException(e9);
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
        }
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, classLoader).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke(null, new Object[0]);
    }
}
