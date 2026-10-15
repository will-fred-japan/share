package B0;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: renamed from: B0.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApiHelperForM.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0289c {

    /* JADX INFO: renamed from: B0.c$a */
    /* JADX INFO: compiled from: ApiHelperForM.java */
    public class a extends WebMessagePort.WebMessageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ A0.l.a f1680a;

        public a(A0.l.a aVar) {
            this.f1680a = aVar;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public final void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            this.f1680a.onMessage(new L(webMessagePort), C0289c.d(webMessage));
        }
    }

    /* JADX INFO: renamed from: B0.c$b */
    /* JADX INFO: compiled from: ApiHelperForM.java */
    public class b extends WebMessagePort.WebMessageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ A0.l.a f1681a;

        public b(A0.l.a aVar) {
            this.f1681a = aVar;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public final void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            this.f1681a.onMessage(new L(webMessagePort), C0289c.d(webMessage));
        }
    }

    /* JADX INFO: renamed from: B0.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApiHelperForM.java */
    public class C0004c extends WebView.VisualStateCallback {
        @Override // android.webkit.WebView.VisualStateCallback
        public final void onComplete(long j) {
            throw null;
        }
    }

    public static void a(WebMessagePort webMessagePort) {
        webMessagePort.close();
    }

    public static WebMessage b(A0.k kVar) {
        WebMessagePort[] webMessagePortArr;
        kVar.a(0);
        A0.l[] lVarArr = kVar.f1376a;
        if (lVarArr == null) {
            webMessagePortArr = null;
        } else {
            int length = lVarArr.length;
            WebMessagePort[] webMessagePortArr2 = new WebMessagePort[length];
            for (int i9 = 0; i9 < length; i9++) {
                webMessagePortArr2[i9] = lVarArr[i9].b();
            }
            webMessagePortArr = webMessagePortArr2;
        }
        return new WebMessage(kVar.f1377b, webMessagePortArr);
    }

    public static WebMessagePort[] c(WebView webView) {
        return webView.createWebMessageChannel();
    }

    public static A0.k d(WebMessage webMessage) {
        A0.l[] lVarArr;
        String data = webMessage.getData();
        WebMessagePort[] ports = webMessage.getPorts();
        if (ports == null) {
            lVarArr = null;
        } else {
            A0.l[] lVarArr2 = new A0.l[ports.length];
            for (int i9 = 0; i9 < ports.length; i9++) {
                lVarArr2[i9] = new L(ports[i9]);
            }
            lVarArr = lVarArr2;
        }
        return new A0.k(data, lVarArr);
    }

    public static CharSequence e(WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    public static int f(WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }

    public static boolean g(WebSettings webSettings) {
        return webSettings.getOffscreenPreRaster();
    }

    public static void h(WebMessagePort webMessagePort, WebMessage webMessage) {
        webMessagePort.postMessage(webMessage);
    }

    public static void i(WebView webView, long j, A0.p.a aVar) {
        webView.postVisualStateCallback(j, new C0004c());
    }

    public static void j(WebView webView, WebMessage webMessage, Uri uri) {
        webView.postWebMessage(webMessage, uri);
    }

    public static void k(WebSettings webSettings, boolean z8) {
        webSettings.setOffscreenPreRaster(z8);
    }

    public static void l(WebMessagePort webMessagePort, A0.l.a aVar) {
        webMessagePort.setWebMessageCallback(new a(aVar));
    }

    public static void m(WebMessagePort webMessagePort, A0.l.a aVar, Handler handler) {
        webMessagePort.setWebMessageCallback(new b(aVar), handler);
    }
}
