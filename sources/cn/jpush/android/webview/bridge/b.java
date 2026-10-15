package cn.jpush.android.webview.bridge;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class b extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11751a = "InjectedChromeClient";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f11752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11753c;

    public b(String str, Class cls) {
        this.f11752b = new c(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i9) {
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setMixedContentMode(1);
        super.onProgressChanged(webView, i9);
    }
}
