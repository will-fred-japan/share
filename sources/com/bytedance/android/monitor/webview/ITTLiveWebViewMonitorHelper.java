package com.bytedance.android.monitor.webview;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import java.util.Set;
import p045g1.b;
import p045g1.d;

/* JADX INFO: loaded from: classes.dex */
public interface ITTLiveWebViewMonitorHelper {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f12008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f12009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f12011d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12012e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f12013f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f12014g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f12015h = "";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f12016i = "";
        public String j = "";
    }

    void addConfig(a aVar);

    a buildConfig();

    String createWebViewKey(WebView webView);

    void customParams(WebView webView, String str);

    void customParseKey(WebView webView, Set<String> set);

    void customReport(WebView webView, String str, String str2, String str3, String str4);

    void customReport(WebView webView, String str, String str2, String str3, String str4, String str5, String str6);

    void destroy(WebView webView);

    void dispatchTouchEvent(WebView webView, MotionEvent motionEvent);

    void goBack(WebView webView);

    void handleFetchError(WebView webView, p053h1.a aVar);

    void handleFetchSuccess(WebView webView);

    void handleJSBError(WebView webView, p053h1.b bVar);

    void handleRequestError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

    @Deprecated
    void initConfig(a aVar);

    void onClientOffline(WebView webView, String str, boolean z8);

    void onLoadUrl(WebView webView, String str);

    void onOffline(WebView webView, String str, boolean z8);

    void onOfflineInfoExtra(WebView webView, String str, String str2, String str3, String str4, String str5);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str);

    @Deprecated
    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onProgressChanged(WebView webView, int i9);

    void reload(WebView webView);

    void removeWebViewKey(String str);

    void report(WebView webView);

    void reportTruly(WebView webView);

    void setDefaultConfig(a aVar);

    void setGeckoClient(p045g1.a aVar);
}
