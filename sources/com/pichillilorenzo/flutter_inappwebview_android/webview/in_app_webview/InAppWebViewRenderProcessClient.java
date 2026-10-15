package com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview;

import A0.q;
import A0.r;
import W5.f;
import android.webkit.WebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate;

/* JADX INFO: loaded from: classes.dex */
public class InAppWebViewRenderProcessClient extends r {
    protected static final String LOG_TAG = "IAWRenderProcessClient";

    @Override // A0.r
    public void onRenderProcessResponsive(WebView webView, final q qVar) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        WebViewChannelDelegate.RenderProcessResponsiveCallback renderProcessResponsiveCallback = new WebViewChannelDelegate.RenderProcessResponsiveCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewRenderProcessClient.2
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public void defaultBehaviour(Integer num) {
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, m7.l.d
            public void error(String str, String str2, Object obj) {
                StringBuilder sbC = p171w.a.c(str, ", ");
                if (str2 == null) {
                    str2 = "";
                }
                f.n(sbC, str2, InAppWebViewRenderProcessClient.LOG_TAG);
                defaultBehaviour((Integer) null);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public boolean nonNullSuccess(Integer num) {
                if (qVar == null) {
                    return true;
                }
                if (num.intValue() != 0 || !p027d5.a.s("WEB_VIEW_RENDERER_TERMINATE")) {
                    return false;
                }
                qVar.a();
                return false;
            }
        };
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onRenderProcessResponsive(inAppWebView.getUrl(), renderProcessResponsiveCallback);
        } else {
            renderProcessResponsiveCallback.defaultBehaviour(null);
        }
    }

    @Override // A0.r
    public void onRenderProcessUnresponsive(WebView webView, final q qVar) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        WebViewChannelDelegate.RenderProcessUnresponsiveCallback renderProcessUnresponsiveCallback = new WebViewChannelDelegate.RenderProcessUnresponsiveCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewRenderProcessClient.1
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public void defaultBehaviour(Integer num) {
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, m7.l.d
            public void error(String str, String str2, Object obj) {
                StringBuilder sbC = p171w.a.c(str, ", ");
                if (str2 == null) {
                    str2 = "";
                }
                f.n(sbC, str2, InAppWebViewRenderProcessClient.LOG_TAG);
                defaultBehaviour((Integer) null);
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public boolean nonNullSuccess(Integer num) {
                if (qVar == null) {
                    return true;
                }
                if (num.intValue() != 0 || !p027d5.a.s("WEB_VIEW_RENDERER_TERMINATE")) {
                    return false;
                }
                qVar.a();
                return false;
            }
        };
        WebViewChannelDelegate webViewChannelDelegate = inAppWebView.channelDelegate;
        if (webViewChannelDelegate != null) {
            webViewChannelDelegate.onRenderProcessUnresponsive(inAppWebView.getUrl(), renderProcessUnresponsiveCallback);
        } else {
            renderProcessUnresponsiveCallback.defaultBehaviour(null);
        }
    }

    public void dispose() {
    }
}
