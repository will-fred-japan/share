package B0;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;

/* JADX INFO: compiled from: JavaScriptReplyProxyImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Callable<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JsReplyProxyBoundaryInterface f1685a;

    public y(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.f1685a = jsReplyProxyBoundaryInterface;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        z zVar = new z();
        zVar.f1686a = this.f1685a;
        return zVar;
    }
}
