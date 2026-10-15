package Z7;

import S7.AbstractC0410w;
import S7.Q;
import X7.u;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends Q implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f5649c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC0410w f5650d;

    static {
        j jVar = j.f5663c;
        int i9 = u.f5171a;
        if (64 >= i9) {
            i9 = 64;
        }
        f5650d = jVar.s(X7.g.c(i9, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        g(B7.i.f1761a, runnable);
    }

    @Override // S7.AbstractC0410w
    public final void g(B7.h hVar, Runnable runnable) {
        f5650d.g(hVar, runnable);
    }

    @Override // S7.AbstractC0410w
    public final String toString() {
        return "Dispatchers.IO";
    }
}
