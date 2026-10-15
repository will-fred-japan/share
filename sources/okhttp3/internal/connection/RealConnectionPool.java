package okhttp3.internal.connection;

import A.a;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: RealConnectionPool.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    /* JADX INFO: compiled from: RealConnectionPool.kt */
    public static final class Companion {
        private Companion() {
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            k.e(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, int i9, long j, TimeUnit timeUnit) {
        k.e(taskRunner, "taskRunner");
        k.e(timeUnit, "timeUnit");
        this.maxIdleConnections = i9;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        this.cleanupQueue = taskRunner.newQueue();
        final String strJ = a.j(new StringBuilder(), Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new Task(strJ) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return this.this$0.cleanup(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (!(j > 0)) {
            throw new IllegalArgumentException(defpackage.f.d(j, "keepAliveDuration <= 0: ").toString());
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            StringBuilder sb = new StringBuilder("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            k.d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(realConnection);
            throw new AssertionError(sb.toString());
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i9 = 0;
        while (i9 < calls.size()) {
            Reference<RealCall> reference = calls.get(i9);
            if (reference.get() != null) {
                i9++;
            } else {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i9);
                realConnection.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(j - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:8:0x0024, B:15:0x0033, B:13:0x002d, B:18:0x0037), top: B:26:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0037 A[SYNTHETIC] */
    public final boolean callAcquirePooledConnection(Address address, RealCall call, List<Route> list, boolean z8) {
        k.e(address, "address");
        k.e(call, "call");
        for (RealConnection connection : this.connections) {
            k.d(connection, "connection");
            synchronized (connection) {
                if (z8) {
                    try {
                        if (connection.isMultiplexed$okhttp()) {
                            if (connection.isEligible$okhttp(address, list)) {
                                call.acquireConnectionNoEvents(connection);
                                return true;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (connection.isEligible$okhttp(address, list)) {
                    call.acquireConnectionNoEvents(connection);
                    return true;
                }
                p188x7.k kVar = p188x7.k.f22364a;
            }
        }
        return false;
    }

    public final long cleanup(long j) {
        int i9 = 0;
        long j8 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i10 = 0;
        for (RealConnection connection : this.connections) {
            k.d(connection, "connection");
            synchronized (connection) {
                try {
                    if (pruneAndGetAllocationCount(connection, j) > 0) {
                        i10++;
                    } else {
                        i9++;
                        long idleAtNs$okhttp = j - connection.getIdleAtNs$okhttp();
                        if (idleAtNs$okhttp > j8) {
                            p188x7.k kVar = p188x7.k.f22364a;
                            realConnection = connection;
                            j8 = idleAtNs$okhttp;
                        } else {
                            p188x7.k kVar2 = p188x7.k.f22364a;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        long j9 = this.keepAliveDurationNs;
        if (j8 < j9 && i9 <= this.maxIdleConnections) {
            if (i9 > 0) {
                return j9 - j8;
            }
            if (i10 > 0) {
                return j9;
            }
            return -1L;
        }
        k.b(realConnection);
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs$okhttp() + j8 != j) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(RealConnection connection) {
        k.e(connection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(connection)) {
            StringBuilder sb = new StringBuilder("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            k.d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(connection);
            throw new AssertionError(sb.toString());
        }
        if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        }
        connection.setNoNewExchanges(true);
        this.connections.remove(connection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        k.d(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection connection = it.next();
            k.d(connection, "connection");
            synchronized (connection) {
                if (connection.getCalls().isEmpty()) {
                    it.remove();
                    connection.setNoNewExchanges(true);
                    socket = connection.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean zIsEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i9 = 0;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.isEmpty()) {
            return 0;
        }
        for (RealConnection it : concurrentLinkedQueue) {
            k.d(it, "it");
            synchronized (it) {
                zIsEmpty = it.getCalls().isEmpty();
            }
            if (zIsEmpty && (i9 = i9 + 1) < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i9;
    }

    public final void put(RealConnection connection) {
        k.e(connection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(connection)) {
            this.connections.add(connection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return;
        }
        StringBuilder sb = new StringBuilder("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        k.d(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(connection);
        throw new AssertionError(sb.toString());
    }
}
