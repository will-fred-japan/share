package B0;

import android.os.Looper;
import android.webkit.TracingController;
import android.webkit.WebView;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: B0.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApiHelperForP.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0299m {
    public static TracingController a() {
        return TracingController.getInstance();
    }

    public static ClassLoader b() {
        return WebView.getWebViewClassLoader();
    }

    public static Looper c(WebView webView) {
        return webView.getWebViewLooper();
    }

    public static boolean d(TracingController tracingController) {
        return tracingController.isTracing();
    }

    public static void e(String str) {
        WebView.setDataDirectorySuffix(str);
    }

    public static void f(TracingController tracingController, A0.i iVar) {
        tracingController.start(C0298l.o().addCategories(iVar.f1372a).addCategories(iVar.f1373b).setTracingMode(iVar.f1374c).build());
    }

    public static boolean g(TracingController tracingController, OutputStream outputStream, Executor executor) {
        return tracingController.stop(outputStream, executor);
    }
}
