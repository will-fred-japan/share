package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewActivity extends Activity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f19686e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f19689c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f19687a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f19688b = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IntentFilter f19690d = new IntentFilter("close action");

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("close action".equals(intent.getAction())) {
                WebViewActivity.this.finish();
            }
        }
    }

    public class b extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            webView.loadUrl(webResourceRequest.getUrl().toString());
            return false;
        }
    }

    public class c extends WebChromeClient {

        public class a extends WebViewClient {
            public a() {
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                WebViewActivity.this.f19689c.loadUrl(webResourceRequest.getUrl().toString());
                return true;
            }
        }

        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onCreateWindow(WebView webView, boolean z8, boolean z9, Message message) {
            a aVar = new a();
            WebView webView2 = new WebView(WebViewActivity.this.f19689c.getContext());
            webView2.setWebViewClient(aVar);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Map<String, String> map;
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.f19689c = webView;
        setContentView(webView);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(RemoteMessageConst.Notification.URL);
        boolean booleanExtra = intent.getBooleanExtra("enableJavaScript", false);
        boolean booleanExtra2 = intent.getBooleanExtra("enableDomStorage", false);
        Bundle bundleExtra = intent.getBundleExtra("com.android.browser.headers");
        if (bundleExtra == null) {
            map = Collections.EMPTY_MAP;
        } else {
            HashMap map2 = new HashMap();
            for (String str : bundleExtra.keySet()) {
                map2.put(str, bundleExtra.getString(str));
            }
            map = map2;
        }
        this.f19689c.loadUrl(stringExtra, map);
        this.f19689c.getSettings().setJavaScriptEnabled(booleanExtra);
        this.f19689c.getSettings().setDomStorageEnabled(booleanExtra2);
        this.f19689c.setWebViewClient(this.f19688b);
        this.f19689c.getSettings().setSupportMultipleWindows(true);
        this.f19689c.setWebChromeClient(new c());
        I.a.c(this, this.f19687a, this.f19690d);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f19687a);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i9, KeyEvent keyEvent) {
        if (i9 != 4 || !this.f19689c.canGoBack()) {
            return super.onKeyDown(i9, keyEvent);
        }
        this.f19689c.goBack();
        return true;
    }
}
