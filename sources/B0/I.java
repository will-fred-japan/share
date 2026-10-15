package B0;

import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface;

/* JADX INFO: compiled from: WebMessageCallbackAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class I implements WebMessageCallbackBoundaryInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A0.l.a f1613a;

    public I(A0.l.a aVar) {
        this.f1613a = aVar;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_CALLBACK_ON_MESSAGE"};
    }

    @Override // org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface
    public final void onMessage(InvocationHandler invocationHandler, InvocationHandler invocationHandler2) {
        A0.k kVarA = H.a((WebMessageBoundaryInterface) d8.a.a(WebMessageBoundaryInterface.class, invocationHandler2));
        if (kVarA != null) {
            this.f1613a.onMessage(new L(invocationHandler), kVarA);
        }
    }
}
