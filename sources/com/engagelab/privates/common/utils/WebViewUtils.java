package com.engagelab.privates.common.utils;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class WebViewUtils {
    private static final byte[] WEB_SETTINGS = {105, 120, 117, 66, 79, 112, 108, 56, 102, 85, 66, 114, 97, 98, Utf8.REPLACEMENT_BYTE, 103, 69, 123, 91, 115, 101, 68, 73, 119, 111, 101};
    private static final byte[] SET_ALLOW_FILE_ACCESS = {83, 124, 124, 87, 125, 92, 79, 110, 78, 127, 125, 85, 97, 122, 107, 115, 98, 67};
    private static final byte[] SET_JAVA_SCRIPT_ENABLED = {123, 115, 101, 122, 65, 111, 105, 69, 114, 66, 73, 105, 124, 83, 127, 81, 66, 117, 109, 114};

    public static void fixSecure(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.getSettings().setMixedContentMode(0);
        } catch (Throwable unused) {
            webView.addOnAttachStateChangeListener(new a(webView));
        }
    }

    public static void setAllowFileAccess(WebSettings webSettings) {
        try {
            webSettings.setAllowFileAccess(false);
            Class.forName(Guard.string(WEB_SETTINGS)).getMethod(Guard.string(SET_ALLOW_FILE_ACCESS), Boolean.TYPE).invoke(webSettings, Boolean.TRUE);
        } catch (Throwable unused) {
        }
    }

    public static void setJavaScriptEnabled(WebSettings webSettings) {
        try {
            Class.forName(Guard.string(WEB_SETTINGS)).getMethod(Guard.string(SET_JAVA_SCRIPT_ENABLED), Boolean.TYPE).invoke(webSettings, Boolean.TRUE);
        } catch (Throwable unused) {
        }
    }

    public static void webSettings(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        setJavaScriptEnabled(webSettings);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setCacheMode(2);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
    }

    public static class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f12383a;

        public a(WebView webView) {
            this.f12383a = webView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            WebSettings settings = this.f12383a.getSettings();
            if (settings != null) {
                try {
                    Method declaredMethod = settings.getClass().getDeclaredMethod("removeJavascriptInterface", String.class);
                    if (declaredMethod != null) {
                        declaredMethod.invoke(this.f12383a, "searchBoxJavaBridge_");
                        declaredMethod.invoke(this.f12383a, "accessibility");
                        declaredMethod.invoke(this.f12383a, "accessibilityTraversal");
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
