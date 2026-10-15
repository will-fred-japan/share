package okio.internal;

import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.k;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

/* JADX INFO: compiled from: FixedLengthSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(Source delegate, long j, boolean z8) {
        super(delegate);
        k.e(delegate, "delegate");
        this.size = j;
        this.truncate = z8;
    }

    private final void truncateToSize(Buffer buffer, long j) throws EOFException {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll(buffer);
        buffer.write(buffer2, j);
        buffer2.clear();
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer sink, long j) throws IOException {
        k.e(sink, "sink");
        long j8 = this.bytesReceived;
        long j9 = this.size;
        if (j8 > j9) {
            j = 0;
        } else if (this.truncate) {
            long j10 = j9 - j8;
            if (j10 == 0) {
                return -1L;
            }
            j = Math.min(j, j10);
        }
        long j11 = super.read(sink, j);
        if (j11 != -1) {
            this.bytesReceived += j11;
        }
        long j12 = this.bytesReceived;
        long j13 = this.size;
        if ((j12 >= j13 || j11 != -1) && j12 <= j13) {
            return j11;
        }
        if (j11 > 0 && j12 > j13) {
            truncateToSize(sink, sink.size() - (this.bytesReceived - this.size));
        }
        throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
    }
}
