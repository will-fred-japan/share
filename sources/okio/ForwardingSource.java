package okio;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ForwardingSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source delegate) {
        k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final Source m1000deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(Buffer sink, long j) {
        k.e(sink, "sink");
        return this.delegate.read(sink, j);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
