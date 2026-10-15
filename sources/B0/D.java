package B0;

import android.webkit.ServiceWorkerController;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;

/* JADX INFO: compiled from: ServiceWorkerControllerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class D extends A0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ServiceWorkerController f1602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServiceWorkerControllerBoundaryInterface f1603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E f1604c;

    public D() {
        O.f1646h.getClass();
        ServiceWorkerController serviceWorkerControllerG = C0290d.g();
        this.f1602a = serviceWorkerControllerG;
        this.f1603b = null;
        if (serviceWorkerControllerG == null) {
            this.f1602a = C0290d.g();
        }
        this.f1604c = C0290d.i(this.f1602a);
    }
}
