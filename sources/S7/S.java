package S7;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class S extends Q implements F {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f4246c;

    public S(Executor executor) {
        this.f4246c = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f4246c;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof S) && ((S) obj).f4246c == this.f4246c;
    }

    @Override // S7.AbstractC0410w
    public final void g(B7.h hVar, Runnable runnable) {
        try {
            this.f4246c.execute(runnable);
        } catch (RejectedExecutionException e9) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e9);
            X x8 = (X) hVar.i(X.a.f4251a);
            if (x8 != null) {
                x8.b(cancellationException);
            }
            Z7.c cVar = J.f4233a;
            Z7.b.f5649c.g(hVar, runnable);
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.f4246c);
    }

    @Override // S7.AbstractC0410w
    public final String toString() {
        return this.f4246c.toString();
    }
}
