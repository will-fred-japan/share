package X7;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final T7.d f5165a;

    static {
        String property;
        int i9 = u.f5171a;
        Object next = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = Arrays.asList(new T7.a()).iterator();
            kotlin.jvm.internal.k.e(it, "<this>");
            Iterator it2 = Q7.h.B(new Q7.a(new Q7.i(it))).iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    ((n) next).getClass();
                    do {
                        ((n) it2.next()).getClass();
                    } while (it2.hasNext());
                }
            }
            n nVar = (n) next;
            if (nVar == null) {
                throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
            }
            f5165a = nVar.a();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
