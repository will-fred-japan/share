package B0;

import android.content.Context;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import java.io.File;

/* JADX INFO: renamed from: B0.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApiHelperForN.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0290d {
    public static boolean a(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowContentAccess();
    }

    public static boolean b(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowFileAccess();
    }

    public static boolean c(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getBlockNetworkLoads();
    }

    public static int d(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getCacheMode();
    }

    public static File e(Context context) {
        return context.getDataDir();
    }

    public static int f(WebSettings webSettings) {
        return webSettings.getDisabledActionModeMenuItems();
    }

    public static ServiceWorkerController g() {
        return ServiceWorkerController.getInstance();
    }

    public static ServiceWorkerWebSettings h(ServiceWorkerController serviceWorkerController) {
        return serviceWorkerController.getServiceWorkerWebSettings();
    }

    public static E i(ServiceWorkerController serviceWorkerController) {
        ServiceWorkerWebSettings serviceWorkerWebSettingsH = h(serviceWorkerController);
        E e9 = new E(0);
        e9.f1605b = serviceWorkerWebSettingsH;
        return e9;
    }

    public static boolean j(WebResourceRequest webResourceRequest) {
        return webResourceRequest.isRedirect();
    }

    public static void k(ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z8) {
        serviceWorkerWebSettings.setAllowContentAccess(z8);
    }

    public static void l(ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z8) {
        serviceWorkerWebSettings.setAllowFileAccess(z8);
    }

    public static void m(ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z8) {
        serviceWorkerWebSettings.setBlockNetworkLoads(z8);
    }

    public static void n(ServiceWorkerWebSettings serviceWorkerWebSettings, int i9) {
        serviceWorkerWebSettings.setCacheMode(i9);
    }

    public static void o(WebSettings webSettings, int i9) {
        webSettings.setDisabledActionModeMenuItems(i9);
    }

    public static void p(ServiceWorkerController serviceWorkerController, ServiceWorkerClient serviceWorkerClient) {
        serviceWorkerController.setServiceWorkerClient(serviceWorkerClient);
    }

    public static void q(ServiceWorkerController serviceWorkerController, A0.f fVar) {
        serviceWorkerController.setServiceWorkerClient(new C0308w(fVar));
    }
}
