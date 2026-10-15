package B0;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: WebViewRenderProcessClientFrameworkAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class V extends WebViewRenderProcessClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A0.r f1671a;

    public V(A0.r rVar) {
        this.f1671a = rVar;
    }

    public final void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        A0.r rVar = this.f1671a;
        WeakHashMap<WebViewRenderProcess, X> weakHashMap = X.f1673c;
        X x8 = weakHashMap.get(webViewRenderProcess);
        if (x8 == null) {
            x8 = new X();
            x8.f1675b = new WeakReference<>(webViewRenderProcess);
            weakHashMap.put(webViewRenderProcess, x8);
        }
        rVar.onRenderProcessResponsive(webView, x8);
    }

    public final void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        A0.r rVar = this.f1671a;
        WeakHashMap<WebViewRenderProcess, X> weakHashMap = X.f1673c;
        X x8 = weakHashMap.get(webViewRenderProcess);
        if (x8 == null) {
            x8 = new X();
            x8.f1675b = new WeakReference<>(webViewRenderProcess);
            weakHashMap.put(webViewRenderProcess, x8);
        }
        rVar.onRenderProcessUnresponsive(webView, x8);
    }
}
