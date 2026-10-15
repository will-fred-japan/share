package B0;

import android.webkit.WebMessagePort;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: WebMessagePortImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class L extends A0.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebMessagePort f1618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebMessagePortBoundaryInterface f1619b;

    public L(WebMessagePort webMessagePort) {
        this.f1618a = webMessagePort;
    }

    @Override // A0.l
    public final void a() {
        O.t.getClass();
        C0289c.a(g());
    }

    @Override // A0.l
    public final WebMessagePort b() {
        return g();
    }

    @Override // A0.l
    public final InvocationHandler c() {
        return Proxy.getInvocationHandler(f());
    }

    @Override // A0.l
    public final void d(A0.k kVar) {
        AbstractC0287a.b bVar = O.f1656s;
        bVar.getClass();
        int i9 = kVar.f1379d;
        if (i9 == 0) {
            C0289c.h(g(), C0289c.b(kVar));
        } else {
            if (!bVar.c() || (i9 != 0 && (i9 != 1 || !O.f1657u.c()))) {
                throw O.a();
            }
            f().postMessage(new d8.a.C0195a(new H(kVar)));
        }
    }

    @Override // A0.l
    public final void e(A0.l.a aVar) {
        if (O.f1658v.c()) {
            f().setWebMessageCallback(new d8.a.C0195a(new I(aVar)));
        } else {
            C0289c.l(g(), aVar);
        }
    }

    public final WebMessagePortBoundaryInterface f() {
        if (this.f1619b == null) {
            T t = P.a.f1664a;
            this.f1619b = (WebMessagePortBoundaryInterface) d8.a.a(WebMessagePortBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) t.f1668b).convertWebMessagePort(this.f1618a));
        }
        return this.f1619b;
    }

    public final WebMessagePort g() {
        if (this.f1618a == null) {
            T t = P.a.f1664a;
            this.f1618a = (WebMessagePort) ((WebkitToCompatConverterBoundaryInterface) t.f1668b).convertWebMessagePort(Proxy.getInvocationHandler(this.f1619b));
        }
        return this.f1618a;
    }

    public L(InvocationHandler invocationHandler) {
        this.f1619b = (WebMessagePortBoundaryInterface) d8.a.a(WebMessagePortBoundaryInterface.class, invocationHandler);
    }
}
