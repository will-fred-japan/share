package B0;

import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

/* JADX INFO: compiled from: WebMessageAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class H implements WebMessageBoundaryInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1611b = {"WEB_MESSAGE_ARRAY_BUFFER"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A0.k f1612a;

    public H(A0.k kVar) {
        this.f1612a = kVar;
    }

    public static A0.k a(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        InvocationHandler[] ports = webMessageBoundaryInterface.getPorts();
        A0.l[] lVarArr = new A0.l[ports.length];
        for (int i9 = 0; i9 < ports.length; i9++) {
            lVarArr[i9] = new L(ports[i9]);
        }
        if (!O.f1657u.c()) {
            return new A0.k(webMessageBoundaryInterface.getData(), lVarArr);
        }
        WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) d8.a.a(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
        int type = webMessagePayloadBoundaryInterface.getType();
        if (type == 0) {
            return new A0.k(webMessagePayloadBoundaryInterface.getAsString(), lVarArr);
        }
        if (type != 1) {
            return null;
        }
        return new A0.k(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), lVarArr);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    @Deprecated
    public final String getData() {
        A0.k kVar = this.f1612a;
        kVar.a(0);
        return kVar.f1377b;
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public final InvocationHandler getMessagePayload() {
        K k7;
        A0.k kVar = this.f1612a;
        int i9 = kVar.f1379d;
        if (i9 == 0) {
            kVar.a(0);
            k7 = new K(kVar.f1377b);
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("Unknown web message payload type: " + i9);
            }
            kVar.a(1);
            byte[] bArr = kVar.f1378c;
            Objects.requireNonNull(bArr);
            k7 = new K(bArr);
        }
        return new d8.a.C0195a(k7);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public final InvocationHandler[] getPorts() {
        A0.l[] lVarArr = this.f1612a.f1376a;
        if (lVarArr == null) {
            return null;
        }
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[lVarArr.length];
        for (int i9 = 0; i9 < lVarArr.length; i9++) {
            invocationHandlerArr[i9] = lVarArr[i9].c();
        }
        return invocationHandlerArr;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return f1611b;
    }
}
