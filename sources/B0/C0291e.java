package B0;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: renamed from: B0.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApiHelperForO.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0291e {
    public static PackageInfo a() {
        return WebView.getCurrentWebViewPackage();
    }

    public static boolean b(WebSettings webSettings) {
        return webSettings.getSafeBrowsingEnabled();
    }

    public static WebChromeClient c(WebView webView) {
        return webView.getWebChromeClient();
    }

    public static WebViewClient d(WebView webView) {
        return webView.getWebViewClient();
    }

    public static void e(WebSettings webSettings, boolean z8) {
        webSettings.setSafeBrowsingEnabled(z8);
    }
}
