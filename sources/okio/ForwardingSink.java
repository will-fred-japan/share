package okio;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ForwardingSink.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingSink implements Sink {
    private final Sink delegate;

    public ForwardingSink(Sink delegate) {
        k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final Sink m999deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // okio.Sink
    public void write(Buffer source, long j) {
        k.e(source, "source");
        this.delegate.write(source, j);
    }
}
