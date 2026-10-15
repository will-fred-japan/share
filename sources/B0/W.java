package B0;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* JADX INFO: compiled from: WebViewRenderProcessImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class W implements Callable<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewRendererBoundaryInterface f1672a;

    public W(WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) {
        this.f1672a = webViewRendererBoundaryInterface;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        X x8 = new X();
        x8.f1674a = this.f1672a;
        return x8;
    }
}
