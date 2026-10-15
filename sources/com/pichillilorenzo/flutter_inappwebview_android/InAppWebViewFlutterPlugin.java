package com.pichillilorenzo.flutter_inappwebview_android;

import Z6.e;
import android.app.Activity;
import android.content.Context;
import com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeSafariBrowserManager;
import com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.NoHistoryCustomTabsActivityCallbacks;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.CredentialDatabaseHandler;
import com.pichillilorenzo.flutter_inappwebview_android.headless_in_app_webview.HeadlessInAppWebViewManager;
import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserManager;
import com.pichillilorenzo.flutter_inappwebview_android.print_job.PrintJobManager;
import com.pichillilorenzo.flutter_inappwebview_android.process_global_config.ProcessGlobalConfigManager;
import com.pichillilorenzo.flutter_inappwebview_android.proxy.ProxyManager;
import com.pichillilorenzo.flutter_inappwebview_android.service_worker.ServiceWorkerManager;
import com.pichillilorenzo.flutter_inappwebview_android.tracing.TracingControllerManager;
import com.pichillilorenzo.flutter_inappwebview_android.webview.FlutterWebViewFactory;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewManager;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.platform.g;
import java.util.HashMap;
import p042f7.a;
import p050g7.b;
import p096m7.c;

/* JADX INFO: loaded from: classes.dex */
public class InAppWebViewFlutterPlugin implements a, p050g7.a {
    protected static final String LOG_TAG = "InAppWebViewFlutterPL";
    public Activity activity;
    public b activityPluginBinding;
    public Context applicationContext;
    public ChromeSafariBrowserManager chromeSafariBrowserManager;
    public CredentialDatabaseHandler credentialDatabaseHandler;
    public a.InterfaceC0199a flutterAssets;
    public FlutterView flutterView;
    public FlutterWebViewFactory flutterWebViewFactory;
    public HeadlessInAppWebViewManager headlessInAppWebViewManager;
    public InAppBrowserManager inAppBrowserManager;
    public InAppWebViewManager inAppWebViewManager;
    public c messenger;
    public MyCookieManager myCookieManager;
    public MyWebStorage myWebStorage;
    public NoHistoryCustomTabsActivityCallbacks noHistoryCustomTabsActivityCallbacks;
    public PlatformUtil platformUtil;
    public PrintJobManager printJobManager;
    public ProcessGlobalConfigManager processGlobalConfigManager;
    public ProxyManager proxyManager;
    public ServiceWorkerManager serviceWorkerManager;
    public TracingControllerManager tracingControllerManager;
    public WebViewFeatureManager webViewFeatureManager;

    private void onAttachedToEngine(Context context, c cVar, Activity activity, g gVar, FlutterView flutterView) {
        this.applicationContext = context;
        this.activity = activity;
        this.messenger = cVar;
        this.flutterView = flutterView;
        this.inAppBrowserManager = new InAppBrowserManager(this);
        this.headlessInAppWebViewManager = new HeadlessInAppWebViewManager(this);
        this.chromeSafariBrowserManager = new ChromeSafariBrowserManager(this);
        this.noHistoryCustomTabsActivityCallbacks = new NoHistoryCustomTabsActivityCallbacks(this);
        FlutterWebViewFactory flutterWebViewFactory = new FlutterWebViewFactory(this);
        this.flutterWebViewFactory = flutterWebViewFactory;
        HashMap map = (HashMap) ((J6.a) gVar).f2691b;
        if (!map.containsKey(FlutterWebViewFactory.VIEW_TYPE_ID)) {
            map.put(FlutterWebViewFactory.VIEW_TYPE_ID, flutterWebViewFactory);
        }
        this.platformUtil = new PlatformUtil(this);
        this.inAppWebViewManager = new InAppWebViewManager(this);
        this.myCookieManager = new MyCookieManager(this);
        this.myWebStorage = new MyWebStorage(this);
        this.serviceWorkerManager = new ServiceWorkerManager(this);
        this.credentialDatabaseHandler = new CredentialDatabaseHandler(this);
        this.webViewFeatureManager = new WebViewFeatureManager(this);
        this.proxyManager = new ProxyManager(this);
        this.printJobManager = new PrintJobManager(this);
        this.tracingControllerManager = new TracingControllerManager(this);
        this.processGlobalConfigManager = new ProcessGlobalConfigManager(this);
    }

    @Override // p050g7.a
    public void onAttachedToActivity(b bVar) {
        this.activityPluginBinding = bVar;
        e eVar = ((a7.a.b) bVar).f5737a;
        this.activity = eVar;
        if (this.noHistoryCustomTabsActivityCallbacks != null) {
            eVar.getApplication().registerActivityLifecycleCallbacks(this.noHistoryCustomTabsActivityCallbacks.activityLifecycleCallbacks);
        }
    }

    @Override // p050g7.a
    public void onDetachedFromActivity() {
        Activity activity = this.activity;
        if (activity != null && this.noHistoryCustomTabsActivityCallbacks != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this.noHistoryCustomTabsActivityCallbacks.activityLifecycleCallbacks);
        }
        this.activityPluginBinding = null;
        this.activity = null;
    }

    @Override // p050g7.a
    public void onDetachedFromActivityForConfigChanges() {
        Activity activity = this.activity;
        if (activity != null && this.noHistoryCustomTabsActivityCallbacks != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this.noHistoryCustomTabsActivityCallbacks.activityLifecycleCallbacks);
        }
        this.activityPluginBinding = null;
        this.activity = null;
    }

    @Override // p042f7.a
    public void onDetachedFromEngine(a.b bVar) {
        PlatformUtil platformUtil = this.platformUtil;
        if (platformUtil != null) {
            platformUtil.dispose();
            this.platformUtil = null;
        }
        InAppBrowserManager inAppBrowserManager = this.inAppBrowserManager;
        if (inAppBrowserManager != null) {
            inAppBrowserManager.dispose();
            this.inAppBrowserManager = null;
        }
        HeadlessInAppWebViewManager headlessInAppWebViewManager = this.headlessInAppWebViewManager;
        if (headlessInAppWebViewManager != null) {
            headlessInAppWebViewManager.dispose();
            this.headlessInAppWebViewManager = null;
        }
        ChromeSafariBrowserManager chromeSafariBrowserManager = this.chromeSafariBrowserManager;
        if (chromeSafariBrowserManager != null) {
            chromeSafariBrowserManager.dispose();
            this.chromeSafariBrowserManager = null;
        }
        NoHistoryCustomTabsActivityCallbacks noHistoryCustomTabsActivityCallbacks = this.noHistoryCustomTabsActivityCallbacks;
        if (noHistoryCustomTabsActivityCallbacks != null) {
            noHistoryCustomTabsActivityCallbacks.dispose();
            this.noHistoryCustomTabsActivityCallbacks = null;
        }
        MyCookieManager myCookieManager = this.myCookieManager;
        if (myCookieManager != null) {
            myCookieManager.dispose();
            this.myCookieManager = null;
        }
        MyWebStorage myWebStorage = this.myWebStorage;
        if (myWebStorage != null) {
            myWebStorage.dispose();
            this.myWebStorage = null;
        }
        CredentialDatabaseHandler credentialDatabaseHandler = this.credentialDatabaseHandler;
        if (credentialDatabaseHandler != null) {
            credentialDatabaseHandler.dispose();
            this.credentialDatabaseHandler = null;
        }
        InAppWebViewManager inAppWebViewManager = this.inAppWebViewManager;
        if (inAppWebViewManager != null) {
            inAppWebViewManager.dispose();
            this.inAppWebViewManager = null;
        }
        ServiceWorkerManager serviceWorkerManager = this.serviceWorkerManager;
        if (serviceWorkerManager != null) {
            serviceWorkerManager.dispose();
            this.serviceWorkerManager = null;
        }
        WebViewFeatureManager webViewFeatureManager = this.webViewFeatureManager;
        if (webViewFeatureManager != null) {
            webViewFeatureManager.dispose();
            this.webViewFeatureManager = null;
        }
        ProxyManager proxyManager = this.proxyManager;
        if (proxyManager != null) {
            proxyManager.dispose();
            this.proxyManager = null;
        }
        PrintJobManager printJobManager = this.printJobManager;
        if (printJobManager != null) {
            printJobManager.dispose();
            this.printJobManager = null;
        }
        TracingControllerManager tracingControllerManager = this.tracingControllerManager;
        if (tracingControllerManager != null) {
            tracingControllerManager.dispose();
            this.tracingControllerManager = null;
        }
        ProcessGlobalConfigManager processGlobalConfigManager = this.processGlobalConfigManager;
        if (processGlobalConfigManager != null) {
            processGlobalConfigManager.dispose();
            this.processGlobalConfigManager = null;
        }
    }

    @Override // p050g7.a
    public void onReattachedToActivityForConfigChanges(b bVar) {
        this.activityPluginBinding = bVar;
        e eVar = ((a7.a.b) bVar).f5737a;
        this.activity = eVar;
        if (this.noHistoryCustomTabsActivityCallbacks != null) {
            eVar.getApplication().registerActivityLifecycleCallbacks(this.noHistoryCustomTabsActivityCallbacks.activityLifecycleCallbacks);
        }
    }

    @Override // p042f7.a
    public void onAttachedToEngine(a.b bVar) {
        this.flutterAssets = bVar.f18715e;
        Activity activity = this.activity;
        onAttachedToEngine(bVar.f18711a, bVar.f18713c, activity, bVar.f18714d, null);
    }
}
