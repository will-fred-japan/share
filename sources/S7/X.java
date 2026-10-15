package S7;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface X extends B7.h.a {

    /* JADX INFO: compiled from: Job.kt */
    public static final class a implements B7.h.b<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f4251a = new a();
    }

    boolean a();

    void b(CancellationException cancellationException);

    K m(boolean z8, boolean z9, a0 a0Var);

    CancellationException q();

    boolean start();

    InterfaceC0400l u(c0 c0Var);

    K x(K7.l<? super Throwable, p188x7.k> lVar);
}
