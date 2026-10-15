package okio;

import java.io.EOFException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Okio.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BlackholeSink implements Sink {
    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer source, long j) throws EOFException {
        k.e(source, "source");
        source.skip(j);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }
}
