package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Throttler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private final Condition condition;
    private final ReentrantLock lock;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j) {
        this.allocatedUntil = j;
        this.waitByteCount = 8192L;
        this.maxByteCount = 262144L;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        k.d(conditionNewCondition, "lock.newCondition()");
        this.condition = conditionNewCondition;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j, long j8, long j9, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            j8 = throttler.waitByteCount;
        }
        long j10 = j8;
        if ((i9 & 4) != 0) {
            j9 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j, j10, j9);
    }

    private final long bytesToNanos(long j) {
        return (j * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j) {
        return (j * this.bytesPerSecond) / 1000000000;
    }

    public final long byteCountOrWaitNanos$okio(long j, long j8) {
        if (this.bytesPerSecond == 0) {
            return j8;
        }
        long jMax = Math.max(this.allocatedUntil - j, 0L);
        long jNanosToBytes = this.maxByteCount - nanosToBytes(jMax);
        if (jNanosToBytes >= j8) {
            this.allocatedUntil = j + jMax + bytesToNanos(j8);
            return j8;
        }
        long j9 = this.waitByteCount;
        if (jNanosToBytes >= j9) {
            this.allocatedUntil = j + bytesToNanos(this.maxByteCount);
            return jNanosToBytes;
        }
        long jMin = Math.min(j9, j8);
        long jBytesToNanos = jMax + bytesToNanos(jMin - this.maxByteCount);
        if (jBytesToNanos != 0) {
            return -jBytesToNanos;
        }
        this.allocatedUntil = j + bytesToNanos(this.maxByteCount);
        return jMin;
    }

    public final void bytesPerSecond(long j) {
        bytesPerSecond$default(this, j, 0L, 0L, 6, null);
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final Sink sink(Sink sink) {
        k.e(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler.sink.1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer source, long j) throws InterruptedIOException {
                k.e(source, "source");
                while (j > 0) {
                    try {
                        long jTake$okio = this.take$okio(j);
                        super.write(source, jTake$okio);
                        j -= jTake$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    public final Source source(Source source) {
        k.e(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler.source.1
            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer sink, long j) throws InterruptedIOException {
                k.e(sink, "sink");
                try {
                    return super.read(sink, this.take$okio(j));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                long jByteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j);
                if (jByteCountOrWaitNanos$okio >= 0) {
                    reentrantLock.unlock();
                    return jByteCountOrWaitNanos$okio;
                }
                this.condition.awaitNanos(-jByteCountOrWaitNanos$okio);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final void bytesPerSecond(long j, long j8) {
        bytesPerSecond$default(this, j, j8, 0L, 4, null);
    }

    public final void bytesPerSecond(long j, long j8, long j9) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (j < 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (j8 <= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (j9 >= j8) {
                this.bytesPerSecond = j;
                this.waitByteCount = j8;
                this.maxByteCount = j9;
                this.condition.signalAll();
                p188x7.k kVar = p188x7.k.f22364a;
                reentrantLock.unlock();
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
