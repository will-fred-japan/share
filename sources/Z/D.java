package Z;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class D extends kotlin.jvm.internal.l implements K7.p<U.a<Object>, Throwable, p188x7.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f5283a = new D(2);

    @Override // K7.p
    public final p188x7.k invoke(U.a<Object> aVar, Throwable th) {
        U.a<Object> msg = aVar;
        Throwable cancellationException = th;
        kotlin.jvm.internal.k.e(msg, "msg");
        if (cancellationException == null) {
            cancellationException = new CancellationException("DataStore scope was cancelled before updateData could complete");
        }
        msg.f5338b.k(cancellationException);
        return p188x7.k.f22364a;
    }
}
