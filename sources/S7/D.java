package S7;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class D extends O implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final D j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f4229k;

    static {
        Long l8;
        D d9 = new D();
        j = d9;
        d9.z(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l8 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l8 = 1000L;
        }
        f4229k = timeUnit.toNanos(l8.longValue());
    }

    @Override // S7.P
    public final Thread D() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(j.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // S7.P
    public final void E(long j8, O.a aVar) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // S7.O
    public final void F(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.F(runnable);
    }

    public final synchronized void J() {
        int i9 = debugStatus;
        if (i9 == 2 || i9 == 3) {
            debugStatus = 3;
            O.f4240g.set(this, null);
            O.f4241h.set(this, null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        m0.f4290a.set(this);
        try {
            synchronized (this) {
                int i9 = debugStatus;
                if (i9 == 2 || i9 == 3) {
                    _thread = null;
                    J();
                    if (I()) {
                        return;
                    }
                    D();
                    return;
                }
                debugStatus = 1;
                notifyAll();
                long j8 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jB = B();
                    if (jB == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j8 == Long.MAX_VALUE) {
                            j8 = f4229k + jNanoTime;
                        }
                        long j9 = j8 - jNanoTime;
                        if (j9 <= 0) {
                            _thread = null;
                            J();
                            if (I()) {
                                return;
                            }
                            D();
                            return;
                        }
                        if (jB > j9) {
                            jB = j9;
                        }
                    } else {
                        j8 = Long.MAX_VALUE;
                    }
                    if (jB > 0) {
                        int i10 = debugStatus;
                        if (i10 == 2 || i10 == 3) {
                            _thread = null;
                            J();
                            if (I()) {
                                return;
                            }
                            D();
                            return;
                        }
                        LockSupport.parkNanos(this, jB);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            J();
            if (!I()) {
                D();
            }
            throw th;
        }
    }

    @Override // S7.O, S7.N
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // S7.AbstractC0410w
    public final String toString() {
        return "DefaultExecutor";
    }
}
