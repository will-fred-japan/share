package com.bytedance.android.monitor.webview;

import B0.N;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.android.monitor.logger.MonitorLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p045g1.e;
import p045g1.f;
import p045g1.i;

/* JADX INFO: loaded from: classes.dex */
public class WebViewMonitorHelper implements ITTLiveWebViewMonitorHelper, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ITTLiveWebViewMonitorHelper f12032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f12033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, String> f12034c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ITTLiveWebViewMonitorHelper.a f12035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ITTLiveWebViewMonitorHelper.a> f12036e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, ITTLiveWebViewMonitorHelper.a> f12037f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set<String> f12038g = new HashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f12039h = new d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f12040i = new Handler(Looper.getMainLooper());
    public c j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ITTLiveWebViewMonitorHelper iTTLiveWebViewMonitorHelper = WebViewMonitorHelper.f12032a;
            WebViewMonitorHelper.this.getClass();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f12042a;

        public b(WebView webView) {
            this.f12042a = webView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                WebViewMonitorHelper webViewMonitorHelper = WebViewMonitorHelper.this;
                WebView webView = this.f12042a;
                ITTLiveWebViewMonitorHelper iTTLiveWebViewMonitorHelper = WebViewMonitorHelper.f12032a;
                webViewMonitorHelper.a(webView, true);
            } catch (Exception unused) {
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WebView f12044a;

        public c(WebView webView) {
            this.f12044a = webView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebViewMonitorHelper.this.reportTruly(this.f12044a);
        }
    }

    static {
        WebViewMonitorHelper webViewMonitorHelper = new WebViewMonitorHelper();
        f12032a = webViewMonitorHelper;
        f12033b = webViewMonitorHelper;
    }

    public static ITTLiveWebViewMonitorHelper getInstance() {
        return f12032a;
    }

    public final boolean a(WebView webView) {
        p045g1.d dVar;
        ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
        if (aVarB == null || (dVar = aVarB.f12008a) == null) {
            return false;
        }
        return dVar.b(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void addConfig(ITTLiveWebViewMonitorHelper.a aVar) {
        try {
            ITTLiveWebViewMonitorHelper.a aVarA = a(aVar);
            aVarA.getClass();
            String[] strArr = aVarA.f12009b;
            if (strArr == null || strArr.length == 0) {
                return;
            }
            for (String str : strArr) {
                this.f12036e.put(str, aVarA);
            }
        } catch (Exception unused) {
        }
    }

    public final ITTLiveWebViewMonitorHelper.a b(WebView webView) {
        Class<?> cls;
        ITTLiveWebViewMonitorHelper.a aVar;
        if (webView == null) {
            return f12035d;
        }
        ITTLiveWebViewMonitorHelper.a aVar2 = this.f12037f.get(createWebViewKey(webView));
        if (aVar2 != null) {
            return aVar2;
        }
        String name = webView.getClass().getName();
        ITTLiveWebViewMonitorHelper.a aVar3 = this.f12036e.get(name);
        if (aVar3 != null) {
            return aVar3;
        }
        if (this.f12038g.contains(name)) {
            return f12035d;
        }
        for (String str : new HashSet(this.f12036e.keySet())) {
            Class<?> cls2 = null;
            try {
                cls = Class.forName(name);
            } catch (Throwable unused) {
                cls = null;
            }
            try {
                cls2 = Class.forName(str);
            } catch (Throwable unused2) {
            }
            if (((cls == null || cls2 == null) ? false : cls2.isAssignableFrom(cls)) && (aVar = this.f12036e.get(str)) != null) {
                this.f12036e.put(name, aVar);
                return aVar;
            }
        }
        this.f12038g.add(name);
        return f12035d;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public ITTLiveWebViewMonitorHelper.a buildConfig() {
        return new ITTLiveWebViewMonitorHelper.a();
    }

    @Override // p045g1.e
    public void cover(WebView webView, String str, String str2, String str3) {
        p045g1.d dVar;
        try {
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f12008a) != null) {
                dVar.cover(webView, str, str2, str3);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public String createWebViewKey(WebView webView) {
        if (webView == null) {
            return "";
        }
        return webView.hashCode() + "";
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void customParams(WebView webView, String str) {
        p045g1.d dVar;
        try {
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f12008a) != null) {
                dVar.p(webView, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void customParseKey(WebView webView, Set<String> set) {
        p045g1.d dVar;
        try {
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f12008a) != null) {
                dVar.a(webView, set);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void customReport(WebView webView, String str, String str2, String str3, String str4) {
        try {
            customReport(webView, null, null, str, str2, str3, str4);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void destroy(WebView webView) {
        try {
            if (isNeedMonitor(webView)) {
                a(webView, false);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void dispatchTouchEvent(WebView webView, MotionEvent motionEvent) {
        if (webView == null || motionEvent == null) {
            return;
        }
        try {
            if (motionEvent.getAction() == 1) {
                updateClickStartTime(webView);
            }
        } catch (Exception unused) {
        }
    }

    @Override // p045g1.e
    public p045g1.c getCustomCallback(WebView webView) {
        try {
            b(webView);
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // p045g1.e
    public p045g1.b getMonitor(WebView webView) {
        try {
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB == null) {
                return null;
            }
            return aVarB.f12011d;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // p045g1.e
    public f getTTWebviewDetect(WebView webView) {
        b(webView).getClass();
        return null;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void goBack(WebView webView) {
        try {
            if (isNeedMonitor(webView)) {
                a(webView, false);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void handleFetchError(WebView webView, p053h1.a aVar) {
        ITTLiveWebViewMonitorHelper.a aVarB;
        p045g1.d dVar;
        if (webView == null) {
            return;
        }
        try {
            if (isNeedMonitor(webView) && a(webView) && (aVarB = b(webView)) != null && (dVar = aVarB.f12008a) != null) {
                dVar.d();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void handleJSBError(WebView webView, p053h1.b bVar) {
        ITTLiveWebViewMonitorHelper.a aVarB;
        p045g1.d dVar;
        if (webView == null) {
            return;
        }
        try {
            if (isNeedMonitor(webView) && a(webView) && (aVarB = b(webView)) != null && (dVar = aVarB.f12008a) != null) {
                dVar.k();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void handleRequestError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        ITTLiveWebViewMonitorHelper.a aVarB;
        p045g1.d dVar;
        if (webView == null || webResourceRequest == null || webResourceError == null) {
            return;
        }
        try {
            if (isNeedMonitor(webView) && a(webView) && webResourceRequest.isForMainFrame() && (aVarB = b(webView)) != null && (dVar = aVarB.f12008a) != null) {
                dVar.l(webView, webResourceError.getErrorCode(), webResourceRequest.getUrl().toString(), webResourceError.getDescription().toString());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void initConfig(ITTLiveWebViewMonitorHelper.a aVar) {
        try {
            addConfig(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // p045g1.e
    public void initTime(WebView webView, String str) {
        p045g1.d dVar;
        try {
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f12008a) != null) {
                dVar.c(webView, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // p045g1.e
    public boolean isNeedAutoReport(WebView webView) {
        try {
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            return aVarB != null && aVarB.f12014g;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // p045g1.e
    public boolean isNeedMonitor(WebView webView) {
        try {
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB == null) {
                return false;
            }
            return aVarB.f12013f;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // p045g1.e
    public String mapService(WebView webView, String str) {
        if (webView != null) {
            try {
                ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
                if (aVarB != null && !TextUtils.isEmpty(str)) {
                    if ("custom".equals(str)) {
                        return "tt" + aVarB.j + "_webview_timing_monitor_custom_service";
                    }
                    return "bd_hybrid_monitor_service_" + str + "_web_" + aVarB.j;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onClientOffline(WebView webView, String str, boolean z8) {
        p045g1.d dVar;
        try {
            String strA = a(str);
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f12008a) != null) {
                dVar.q(webView, strA, z8);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onLoadUrl(WebView webView, String str) {
        try {
            if (isNeedMonitor(webView)) {
                b(webView, "ttlive_web_view_last_url_tag");
                MonitorLog.d("TTLiveWebViewMonitorHelper", "onLoadUrl : " + str);
                updateClickStartTime(webView);
                if (!isNeedMonitor(webView) || "ttlive_web_view_tag".equals(a(webView, "ttlive_web_view_tag"))) {
                    return;
                }
                TTLiveWebViewMonitorJsBridge tTLiveWebViewMonitorJsBridge = new TTLiveWebViewMonitorJsBridge(webView);
                if (!webView.getSettings().getJavaScriptEnabled()) {
                    webView.getSettings().setJavaScriptEnabled(true);
                }
                webView.addJavascriptInterface(tTLiveWebViewMonitorJsBridge, "JsBridgeTransferMonitor");
                a(webView, "ttlive_web_view_tag", "ttlive_web_view_tag");
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onOffline(WebView webView, String str, boolean z8) {
        p045g1.d dVar;
        try {
            String strA = a(str);
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f12008a) != null) {
                dVar.m(webView, strA, z8);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onOfflineInfoExtra(WebView webView, String str, String str2, String str3, String str4, String str5) {
        p045g1.d dVar;
        try {
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f12008a) != null) {
                dVar.f(webView, str, str2, str3, str4, str5);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onPageFinished(WebView webView, String str) {
        ITTLiveWebViewMonitorHelper.a aVarB;
        p045g1.d dVar;
        try {
            if (isNeedMonitor(webView) && (aVarB = b(webView)) != null && (dVar = aVarB.f12008a) != null) {
                dVar.o(webView);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        try {
            onPageStarted(webView, str);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onProgressChanged(WebView webView, int i9) {
        ITTLiveWebViewMonitorHelper.a aVarB;
        p045g1.d dVar;
        try {
            a(webView, i9);
            if (webView != null && isNeedMonitor(webView) && a(webView) && (aVarB = b(webView)) != null && (dVar = aVarB.f12008a) != null) {
                dVar.g(webView, i9);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void reload(WebView webView) {
        try {
            if (isNeedMonitor(webView)) {
                b(webView, "ttlive_web_view_last_url_tag");
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void removeWebViewKey(String str) {
        try {
            Map<String, ITTLiveWebViewMonitorHelper.a> map = this.f12037f;
            if (map != null) {
                map.remove(str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void report(WebView webView) {
        try {
            this.f12040i.post(new b(webView));
            c cVar = new c(webView);
            this.j = cVar;
            this.f12040i.postDelayed(cVar, 200L);
        } catch (Exception unused) {
        }
    }

    @Override // p045g1.e
    public void reportDirectly(WebView webView, String str, String str2) {
        p045g1.d dVar;
        try {
            ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f12008a) != null) {
                dVar.reportDirectly(webView, str, str2);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void reportTruly(WebView webView) {
        p045g1.d dVar;
        p045g1.d dVar2;
        try {
            c cVar = this.j;
            if (cVar != null) {
                this.f12040i.removeCallbacks(cVar);
                this.j = null;
            }
            try {
                ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
                if (aVarB != null && (dVar2 = aVarB.f12008a) != null) {
                    dVar2.e(webView);
                }
            } catch (Exception unused) {
            }
            ITTLiveWebViewMonitorHelper.a aVarB2 = b(webView);
            if (aVarB2 != null && (dVar = aVarB2.f12008a) != null) {
                dVar.report(webView);
            }
            b(webView, "ttlive_web_view_last_url_tag");
            b(webView, "ttlive_web_view_auto_report_tag");
            b(webView, "ttlive_web_view_tag");
            d dVar3 = this.f12039h;
            if (dVar3 == null || webView == null) {
                return;
            }
            webView.removeOnAttachStateChangeListener(dVar3);
        } catch (Exception unused2) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void setDefaultConfig(ITTLiveWebViewMonitorHelper.a aVar) {
        try {
            f12035d = a(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void setGeckoClient(p045g1.a aVar) {
        this.f12040i.postDelayed(new a(), 20000L);
    }

    public void updateClickStartTime(WebView webView) {
        ITTLiveWebViewMonitorHelper.a aVarB;
        p045g1.d dVar;
        if (webView == null || !isNeedMonitor(webView) || (aVarB = b(webView)) == null || (dVar = aVarB.f12008a) == null) {
            return;
        }
        dVar.j(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void customReport(WebView webView, String str, String str2, String str3, String str4, String str5, String str6) {
        ITTLiveWebViewMonitorHelper.a aVarB;
        p045g1.d dVar;
        p045g1.d dVar2;
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObjectO0 = A1.b.o0(str5);
                try {
                    jSONObjectO0.put("event_name", str2);
                } catch (JSONException unused) {
                }
                str5 = jSONObjectO0.toString();
            }
            String str7 = str5;
            if ("0".equals(str6)) {
                ITTLiveWebViewMonitorHelper.a aVarB2 = b(webView);
                if (aVarB2 != null && (dVar2 = aVarB2.f12008a) != null) {
                    dVar2.n(webView, str, str3, str4, str7);
                    return;
                }
                return;
            }
            if ("1".equals(str6) && (aVarB = b(webView)) != null && (dVar = aVarB.f12008a) != null) {
                dVar.i(webView, str, str3, str4, str7);
            }
        } catch (Exception unused2) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onPageStarted(WebView webView, String str) {
        p045g1.d dVar;
        try {
            if (isNeedMonitor(webView)) {
                if (isNeedAutoReport(webView) && !"ttlive_web_view_auto_report_tag".equals(a(webView, "ttlive_web_view_auto_report_tag"))) {
                    if (this.f12039h != null && isNeedAutoReport(webView)) {
                        d dVar2 = this.f12039h;
                        dVar2.getClass();
                        if (webView != null) {
                            webView.removeOnAttachStateChangeListener(dVar2);
                            webView.addOnAttachStateChangeListener(dVar2);
                        }
                    }
                    a(webView, "ttlive_web_view_auto_report_tag", "ttlive_web_view_auto_report_tag");
                }
                ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
                if (aVarB != null && (dVar = aVarB.f12008a) != null) {
                    dVar.h(webView, str);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(WebView webView, boolean z8) {
        if (b(webView) == null) {
            return;
        }
        String strI = A.a.i(" javascript: (function () {\n    var target = {}\n    if (typeof SlardarHybrid !== 'undefined' && typeof jsIESLiveTimingMonitor !== 'undefined'){\n    var performacess = SlardarHybrid('getLatestPerformance');\n    var resourcess = SlardarHybrid('getLatestResource');\n    target.performance = performacess;\n    target.resource = resourcess;\n    target.needReport = ", z8 ? "true" : "false", ";\n    jsIESLiveTimingMonitor.reportPageLatestData(target);}\n })()");
        if (webView != null) {
            webView.evaluateJavascript(strI, null);
        }
    }

    public final ITTLiveWebViewMonitorHelper.a a(ITTLiveWebViewMonitorHelper.a aVar) {
        String[] strArr;
        JSONArray jSONArrayOptJSONArray;
        boolean zOptBoolean;
        String strI;
        ITTLiveWebViewMonitorHelper.a aVar2 = new ITTLiveWebViewMonitorHelper.a();
        aVar.j = aVar.j;
        if (aVar.f12012e) {
            aVar.j = "live";
        }
        p045g1.d dVar = aVar.f12008a;
        if (dVar == null) {
            if (i.f18845a == null) {
                synchronized (i.class) {
                    try {
                        if (i.f18845a == null) {
                            i.f18845a = new i();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            dVar = i.f18845a;
        }
        aVar2.f12008a = dVar;
        String str = aVar.f12010c;
        if (str == null) {
            str = "WebViewMonitor";
        }
        aVar2.f12010c = str;
        p045g1.b bVar = aVar.f12011d;
        N n8 = new N(12, false);
        n8.f1624b = bVar;
        aVar2.f12011d = n8;
        aVar2.f12012e = aVar.f12012e;
        aVar2.f12014g = aVar.f12014g;
        aVar2.f12016i = null;
        aVar2.f12013f = aVar.f12013f;
        aVar2.f12009b = aVar.f12009b;
        aVar2.j = aVar.j;
        aVar2.f12015h = TextUtils.isEmpty(aVar.f12015h) ? "" : aVar.f12015h;
        if (A1.b.o0("").opt("webview_classes") == null) {
            strArr = aVar2.f12009b;
        } else {
            String[] strArr2 = new String[0];
            if (!TextUtils.isEmpty("") && (jSONArrayOptJSONArray = A1.b.o0("").optJSONArray("webview_classes")) != null) {
                strArr2 = new String[jSONArrayOptJSONArray.length()];
                for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                    try {
                        strArr2[i9] = jSONArrayOptJSONArray.getString(i9);
                    } catch (JSONException unused) {
                    }
                }
            }
            strArr = strArr2;
        }
        aVar2.f12009b = strArr;
        if (A1.b.o0("").opt("webview_is_need_monitor") == null) {
            zOptBoolean = aVar2.f12013f;
        } else {
            zOptBoolean = A1.b.o0("").optBoolean("webview_is_need_monitor", false);
        }
        aVar2.f12013f = zOptBoolean;
        if (TextUtils.isEmpty("")) {
            strI = aVar2.f12015h;
        } else {
            JSONObject jSONObjectO0 = A1.b.o0("");
            JSONObject jSONObjectOptJSONObject = jSONObjectO0.optJSONObject("apmReportConfig");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectO0.optJSONObject("performanceReportConfig");
            JSONObject jSONObjectOptJSONObject3 = jSONObjectO0.optJSONObject("errorMsgReportConfig");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectO0.optJSONObject("resourceTimingReportConfig");
            JSONObject jSONObjectOptJSONObject5 = jSONObjectO0.optJSONObject("commonReportConfig");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("monitors", jSONObject2);
            } catch (JSONException unused2) {
            }
            try {
                jSONObject.put("sendCommonParams", jSONObjectOptJSONObject5);
            } catch (JSONException unused3) {
            }
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject2.put(next, jSONObjectOptJSONObject.opt(next));
                    } catch (JSONException unused4) {
                    }
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    try {
                        jSONObject2.put(next2, jSONObjectOptJSONObject2.opt(next2));
                    } catch (JSONException unused5) {
                    }
                }
            }
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys3 = jSONObjectOptJSONObject3.keys();
                while (itKeys3.hasNext()) {
                    String next3 = itKeys3.next();
                    try {
                        jSONObject2.put(next3, jSONObjectOptJSONObject3.opt(next3));
                    } catch (JSONException unused6) {
                    }
                }
            }
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys4 = jSONObjectOptJSONObject4.keys();
                while (itKeys4.hasNext()) {
                    String next4 = itKeys4.next();
                    try {
                        jSONObject2.put(next4, jSONObjectOptJSONObject4.opt(next4));
                    } catch (JSONException unused7) {
                    }
                }
            }
            strI = A.a.i("RangersSiteHybridSDK('config', ", jSONObject.toString(), ")");
        }
        aVar2.f12015h = strI;
        return aVar2;
    }

    public final void b(WebView webView, String str) {
        f12034c.remove(W5.e.u(str, createWebViewKey(webView)));
    }

    public static class d implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            if (view instanceof WebView) {
                WebView webView = (WebView) view;
                if (WebViewMonitorHelper.f12033b.isNeedAutoReport(webView)) {
                    WebViewMonitorHelper.getInstance().report(webView);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void handleFetchSuccess(WebView webView) {
    }

    public final String a(String str) {
        int iIndexOf;
        return (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf("?")) == -1) ? str : str.substring(0, iIndexOf);
    }

    public final void a(WebView webView, int i9) {
        if (isNeedMonitor(webView) && i9 >= 15 && webView != null) {
            if (!webView.getSettings().getJavaScriptEnabled()) {
                webView.getSettings().setJavaScriptEnabled(true);
            }
            try {
                String url = webView.getUrl();
                if (url == null || !url.equals("about:blank")) {
                    String strA = a(webView, "ttlive_web_view_last_url_tag");
                    if (TextUtils.isEmpty(url) || url.equals(strA)) {
                        return;
                    }
                    ITTLiveWebViewMonitorHelper.a aVarB = b(webView);
                    String str = "";
                    String str2 = aVarB == null ? "" : aVarB.f12015h;
                    if (aVarB != null) {
                        str = aVarB.f12016i;
                    }
                    webView.evaluateJavascript(A1.b.j(webView.getContext(), str, str2, true), null);
                    a(webView, "ttlive_web_view_last_url_tag", url);
                    MonitorLog.d("WebViewMonitorHelper", "injectJsScript : ".concat(url));
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(WebView webView, String str, String str2) {
        f12034c.put(W5.e.u(str, createWebViewKey(webView)), str2);
    }

    public final String a(WebView webView, String str) {
        String strCreateWebViewKey = createWebViewKey(webView);
        String str2 = f12034c.get(W5.e.u(str, strCreateWebViewKey));
        if (str2 == null) {
            return null;
        }
        return str2.replaceAll(strCreateWebViewKey, "");
    }
}
