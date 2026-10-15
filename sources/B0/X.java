package B0;

import android.webkit.WebViewRenderProcess;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* JADX INFO: compiled from: WebViewRenderProcessImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class X extends A0.q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap<WebViewRenderProcess, X> f1673c = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebViewRendererBoundaryInterface f1674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<WebViewRenderProcess> f1675b;

    @Override // A0.q
    public final boolean a() {
        AbstractC0287a.h hVar = O.f1661y;
        if (hVar.b()) {
            WebViewRenderProcess webViewRenderProcessP = C0302p.p(this.f1675b.get());
            return webViewRenderProcessP != null && C0303q.g(webViewRenderProcessP);
        }
        if (hVar.c()) {
            return this.f1674a.terminate();
        }
        throw O.a();
    }
}
