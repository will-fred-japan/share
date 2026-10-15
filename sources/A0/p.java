package A0;

import B0.AbstractC0287a;
import B0.C;
import B0.C0289c;
import B0.C0291e;
import B0.C0295i;
import B0.C0303q;
import B0.H;
import B0.O;
import B0.P;
import B0.Q;
import B0.U;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewRenderProcessClient;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: compiled from: WebViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f1389a = Uri.parse("*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f1390b = Uri.parse("");

    /* JADX INFO: compiled from: WebViewCompat.java */
    public interface a {
    }

    /* JADX INFO: compiled from: WebViewCompat.java */
    public interface b {
        void onPostMessage(WebView webView, k kVar, Uri uri, boolean z8, A0.a aVar);
    }

    public static C a(WebView webView, String str, Set set) {
        if (!O.f1634J.c()) {
            throw O.a();
        }
        Q qC = c(webView);
        return new C((ScriptHandlerBoundaryInterface) d8.a.a(ScriptHandlerBoundaryInterface.class, qC.f1666a.addDocumentStartJavaScript(str, (String[]) set.toArray(new String[0]))));
    }

    public static PackageInfo b(Context context) {
        PackageInfo packageInfoA = C0291e.a();
        if (packageInfoA != null) {
            return packageInfoA;
        }
        try {
            String str = (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", new Class[0]).invoke(null, new Object[0]);
            if (str != null) {
                return context.getPackageManager().getPackageInfo(str, 0);
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return null;
    }

    public static Q c(WebView webView) {
        WebViewProviderBoundaryInterface webViewProviderBoundaryInterfaceCreateWebView = P.b.f1665a.createWebView(webView);
        Q q8 = new Q();
        q8.f1666a = webViewProviderBoundaryInterfaceCreateWebView;
        return q8;
    }

    public static void d(WebView webView, k kVar, Uri uri) {
        if (f1389a.equals(uri)) {
            uri = f1390b;
        }
        AbstractC0287a.b bVar = O.f1660x;
        bVar.getClass();
        int i9 = kVar.f1379d;
        if (i9 == 0) {
            C0289c.j(webView, C0289c.b(kVar), uri);
            return;
        }
        if (!bVar.c() || (i9 != 0 && (i9 != 1 || !O.f1657u.c()))) {
            throw O.a();
        }
        Q qC = c(webView);
        qC.f1666a.postMessageToMainFrame(new d8.a.C0195a(new H(kVar)), uri);
    }

    public static void e(HashSet hashSet, ValueCallback valueCallback) {
        AbstractC0287a.f fVar = O.f1644f;
        AbstractC0287a.f fVar2 = O.f1643e;
        if (fVar.c()) {
            P.b.f1665a.getStatics().setSafeBrowsingAllowlist(hashSet, valueCallback);
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        if (fVar2.b()) {
            C0295i.d(arrayList, valueCallback);
        } else {
            if (!fVar2.c()) {
                throw O.a();
            }
            P.b.f1665a.getStatics().setSafeBrowsingWhitelist(arrayList, valueCallback);
        }
    }

    public static void f(InAppWebView inAppWebView, InAppWebViewRenderProcessClient inAppWebViewRenderProcessClient) {
        AbstractC0287a.h hVar = O.f1627C;
        if (hVar.b()) {
            C0303q.e(inAppWebView, inAppWebViewRenderProcessClient);
        } else {
            if (!hVar.c()) {
                throw O.a();
            }
            c(inAppWebView).f1666a.setWebViewRendererClient(inAppWebViewRenderProcessClient != null ? new d8.a.C0195a(new U(inAppWebViewRenderProcessClient)) : null);
        }
    }
}
