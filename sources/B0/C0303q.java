package B0;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: B0.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApiHelperForQ.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0303q {
    @Deprecated
    public static int a(WebSettings webSettings) {
        return webSettings.getForceDark();
    }

    public static WebViewRenderProcess b(WebView webView) {
        return webView.getWebViewRenderProcess();
    }

    public static WebViewRenderProcessClient c(WebView webView) {
        return webView.getWebViewRenderProcessClient();
    }

    @Deprecated
    public static void d(WebSettings webSettings, int i9) {
        webSettings.setForceDark(i9);
    }

    public static void e(WebView webView, A0.r rVar) {
        webView.setWebViewRenderProcessClient(rVar != null ? new V(rVar) : null);
    }

    public static void f(WebView webView, Executor executor, A0.r rVar) {
        webView.setWebViewRenderProcessClient(executor, rVar != null ? new V(rVar) : null);
    }

    public static boolean g(WebViewRenderProcess webViewRenderProcess) {
        return webViewRenderProcess.terminate();
    }
}
