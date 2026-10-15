package okhttp3.internal.cache;

import K7.l;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import p188x7.k;

/* JADX INFO: compiled from: FaultHidingSink.kt */
/* JADX INFO: loaded from: classes2.dex */
public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;
    private final l<IOException, k> onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(Sink delegate, l<? super IOException, k> onException) {
        super(delegate);
        kotlin.jvm.internal.k.e(delegate, "delegate");
        kotlin.jvm.internal.k.e(onException, "onException");
        this.onException = onException;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e9) {
            this.hasErrors = true;
            this.onException.invoke(e9);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e9) {
            this.hasErrors = true;
            this.onException.invoke(e9);
        }
    }

    public final l<IOException, k> getOnException() {
        return this.onException;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer source, long j) throws EOFException {
        kotlin.jvm.internal.k.e(source, "source");
        if (this.hasErrors) {
            source.skip(j);
            return;
        }
        try {
            super.write(source, j);
        } catch (IOException e9) {
            this.hasErrors = true;
            this.onException.invoke(e9);
        }
    }
}
