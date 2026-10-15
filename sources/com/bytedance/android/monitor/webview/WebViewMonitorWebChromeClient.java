package com.bytedance.android.monitor.webview;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class WebViewMonitorWebChromeClient extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i9) {
        super.onProgressChanged(webView, i9);
        WebViewMonitorHelper.getInstance().onProgressChanged(webView, i9);
    }
}
