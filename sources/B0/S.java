package B0;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: WebViewProviderFactory.java */
/* JADX INFO: loaded from: classes.dex */
public interface S {
    String[] a();

    WebViewProviderBoundaryInterface createWebView(WebView webView);

    DropDataContentProviderBoundaryInterface getDropDataProvider();

    ProxyControllerBoundaryInterface getProxyController();

    StaticsBoundaryInterface getStatics();

    TracingControllerBoundaryInterface getTracingController();

    WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter();
}
