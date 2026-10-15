package p045g1;

import android.webkit.WebView;

/* JADX INFO: compiled from: ITTLiveWebViewMonitorInnerHelper.java */
/* JADX INFO: loaded from: classes.dex */
public interface e {
    void cover(WebView webView, String str, String str2, String str3);

    c getCustomCallback(WebView webView);

    b getMonitor(WebView webView);

    f getTTWebviewDetect(WebView webView);

    void initTime(WebView webView, String str);

    boolean isNeedAutoReport(WebView webView);

    boolean isNeedMonitor(WebView webView);

    String mapService(WebView webView, String str);

    void reportDirectly(WebView webView, String str, String str2);
}
