package B0;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;

/* JADX INFO: compiled from: WebViewRenderProcessClientAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class U implements WebViewRendererClientBoundaryInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1669b = {"WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InAppWebViewRenderProcessClient f1670a;

    @SuppressLint({"LambdaLast"})
    public U(InAppWebViewRenderProcessClient inAppWebViewRenderProcessClient) {
        this.f1670a = inAppWebViewRenderProcessClient;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return f1669b;
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererResponsive(WebView webView, InvocationHandler invocationHandler) {
        WeakHashMap<WebViewRenderProcess, X> weakHashMap = X.f1673c;
        WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) d8.a.a(WebViewRendererBoundaryInterface.class, invocationHandler);
        this.f1670a.onRenderProcessResponsive(webView, (X) webViewRendererBoundaryInterface.getOrCreatePeer(new W(webViewRendererBoundaryInterface)));
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererUnresponsive(WebView webView, InvocationHandler invocationHandler) {
        WeakHashMap<WebViewRenderProcess, X> weakHashMap = X.f1673c;
        WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) d8.a.a(WebViewRendererBoundaryInterface.class, invocationHandler);
        this.f1670a.onRenderProcessUnresponsive(webView, (X) webViewRendererBoundaryInterface.getOrCreatePeer(new W(webViewRendererBoundaryInterface)));
    }
}
