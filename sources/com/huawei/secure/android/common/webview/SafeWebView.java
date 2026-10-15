package com.huawei.secure.android.common.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.LogsUtil;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SafeWebView extends WebView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f15990f = "SafeWebView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String[] f15992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f15993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f15994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WebViewLoadCallBack f15995e;

    public final class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WebViewClient f15996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15997b;

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z8) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z8);
            } else {
                super.doUpdateVisitedHistory(webView, str, z8);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            } else {
                super.onPageCommitVisible(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null && !this.f15997b) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else if (SafeWebView.this.isWhiteListUrl(str)) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                SafeWebView.this.onCheckError(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i9, String str, String str2) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i9, str, str2);
            } else {
                super.onReceivedError(webView, i9, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(12)
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WebViewClient webViewClient = this.f15996a;
            return webViewClient != null ? webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail) : super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i9, SafeBrowsingResponse safeBrowsingResponse) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i9, safeBrowsingResponse);
            } else {
                super.onSafeBrowsingHit(webView, webResourceRequest, i9, safeBrowsingResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f6, float f9) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f6, f9);
            } else {
                super.onScaleChanged(webView, f6, f9);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f15996a;
            return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, webResourceRequest) : super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f15996a;
            return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null && !this.f15997b) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            if (SafeWebView.this.isWhiteListUrl(str)) {
                WebViewClient webViewClient2 = this.f15996a;
                return webViewClient2 != null ? webViewClient2.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
            }
            SafeWebView.this.onCheckError(webView, str);
            return false;
        }

        private b(WebViewClient webViewClient, boolean z8) {
            this.f15996a = webViewClient;
            this.f15997b = z8;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f15996a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    public SafeWebView(Context context) {
        super(context);
        a();
    }

    private boolean a(String str) {
        return URLUtil.isHttpUrl(str);
    }

    public String getDefaultErrorPage() {
        return this.f15991a;
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.f15995e;
    }

    @TargetApi(9)
    @Deprecated
    public String[] getWhitelist() {
        String[] strArr = this.f15992b;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String[] getWhitelistNotMatchSubDomain() {
        String[] strArr = this.f15993c;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public String[] getWhitelistNotMathcSubDomain() {
        String[] strArr = this.f15993c;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public String[] getWhitelistWithPath() {
        String[] strArr = this.f15994d;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public boolean isWhiteListUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.e(f15990f, "url is null");
            return false;
        }
        if (!URLUtil.isNetworkUrl(str)) {
            return true;
        }
        String[] whitelistWithPath = getWhitelistWithPath();
        String[] whitelistNotMatchSubDomain = getWhitelistNotMatchSubDomain();
        String[] whitelist = getWhitelist();
        boolean z8 = whitelistWithPath == null || whitelistWithPath.length == 0;
        boolean z9 = whitelistNotMatchSubDomain == null || whitelistNotMatchSubDomain.length == 0;
        boolean z10 = whitelist == null || whitelist.length == 0;
        if (z8 && z9 && z10) {
            return true;
        }
        if (whitelistWithPath == null || whitelistWithPath.length == 0) {
            return (whitelistNotMatchSubDomain == null || whitelistNotMatchSubDomain.length == 0) ? UriUtil.isUrlHostInWhitelist(str, whitelist) : UriUtil.isUrlHostSameWhitelist(str, whitelistNotMatchSubDomain);
        }
        return UriUtil.isUrlHostAndPathInWhitelist(str, whitelistWithPath);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!a(str)) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            return;
        }
        Log.e(f15990f, "loadDataWithBaseURL: http url , not safe");
        if (!TextUtils.isEmpty(this.f15991a)) {
            super.loadDataWithBaseURL(this.f15991a, str2, str3, str4, str5);
        } else if (getWebViewLoadCallBack() != null) {
            Log.e(f15990f, "WebViewLoadCallBack");
            getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (isWhiteListUrl(str) && !a(str)) {
            super.loadUrl(str);
            return;
        }
        Log.e(f15990f, "loadUrl: url is not in white list or http url not safe");
        if (!TextUtils.isEmpty(this.f15991a)) {
            super.loadUrl(this.f15991a);
        } else if (getWebViewLoadCallBack() != null) {
            Log.e(f15990f, "WebViewLoadCallBack");
            getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
        }
    }

    public final void onCheckError(WebView webView, String str) {
        LogsUtil.e(f15990f, "onCheckError url is not in white list ", str);
        webView.stopLoading();
        String defaultErrorPage = getDefaultErrorPage();
        if (!TextUtils.isEmpty(defaultErrorPage)) {
            webView.loadUrl(defaultErrorPage);
        } else if (getWebViewLoadCallBack() != null) {
            Log.e(f15990f, "onPageStarted WebViewLoadCallBack");
            getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        if (isWhiteListUrl(str) && !a(str)) {
            super.postUrl(str, bArr);
            return;
        }
        Log.e(f15990f, "postUrl: url is not in white list or http url not safe");
        if (!TextUtils.isEmpty(this.f15991a)) {
            super.postUrl(this.f15991a, bArr);
        } else if (getWebViewLoadCallBack() != null) {
            Log.e(f15990f, "WebViewLoadCallBack");
            getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
        }
    }

    public void setDefaultErrorPage(String str) {
        this.f15991a = str;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new b(webViewClient, true));
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack webViewLoadCallBack) {
        this.f15995e = webViewLoadCallBack;
    }

    @TargetApi(9)
    @Deprecated
    public void setWhitelist(String[] strArr) {
        this.f15992b = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setWhitelistNotMatchSubDomain(String[] strArr) {
        this.f15993c = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public void setWhitelistNotMathcSubDomain(String[] strArr) {
        this.f15993c = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public void setWhitelistWithPath(String[] strArr) {
        this.f15994d = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    private void a() {
        SafeWebSettings.initWebviewAndSettings(this);
        setWebViewClient(null);
    }

    public void setWebViewClient(WebViewClient webViewClient, boolean z8) {
        super.setWebViewClient(new b(webViewClient, z8));
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        a();
    }

    @TargetApi(21)
    public SafeWebView(Context context, AttributeSet attributeSet, int i9, int i10) {
        super(context, attributeSet, i9, i10);
        a();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (isWhiteListUrl(str) && !a(str)) {
            super.loadUrl(str, map);
            return;
        }
        Log.e(f15990f, "loadUrl: url is not in white list or http url not safe");
        if (!TextUtils.isEmpty(this.f15991a)) {
            super.loadUrl(this.f15991a, map);
        } else if (getWebViewLoadCallBack() != null) {
            Log.e(f15990f, "WebViewLoadCallBack");
            getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
        }
    }
}
