package X7;

import S7.InterfaceC0411x;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collection<InterfaceC0411x> f5135a;

    static {
        try {
            Iterator it = Arrays.asList(new T7.b()).iterator();
            kotlin.jvm.internal.k.e(it, "<this>");
            f5135a = Q7.h.B(new Q7.a(new Q7.i(it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
