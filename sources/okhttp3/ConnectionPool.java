package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: compiled from: ConnectionPool.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionPool {
    private final RealConnectionPool delegate;

    public ConnectionPool(RealConnectionPool delegate) {
        k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i9, long j, TimeUnit timeUnit) {
        this(new RealConnectionPool(TaskRunner.INSTANCE, i9, j, timeUnit));
        k.e(timeUnit, "timeUnit");
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
