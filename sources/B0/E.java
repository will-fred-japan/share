package B0;

import android.webkit.ServiceWorkerWebSettings;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: ServiceWorkerWebSettingsImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class E extends A0.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ServiceWorkerWebSettings f1605b;

    public final ServiceWorkerWebSettings w() {
        if (this.f1605b == null) {
            T t = P.a.f1664a;
            this.f1605b = (ServiceWorkerWebSettings) ((WebkitToCompatConverterBoundaryInterface) t.f1668b).convertServiceWorkerSettings(Proxy.getInvocationHandler(null));
        }
        return this.f1605b;
    }
}
