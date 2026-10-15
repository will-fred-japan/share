package okio;

import defpackage.f;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource source, Inflater inflater) {
        k.e(source, "source");
        k.e(inflater, "inflater");
        this.source = source;
        this.inflater = inflater;
    }

    private final void releaseBytesAfterInflate() {
        int i9 = this.bufferBytesHeldByInflater;
        if (i9 == 0) {
            return;
        }
        int remaining = i9 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public long read(Buffer sink, long j) throws IOException {
        k.e(sink, "sink");
        do {
            long orInflate = readOrInflate(sink, j);
            if (orInflate > 0) {
                return orInflate;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(Buffer sink, long j) throws IOException {
        k.e(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(f.d(j, "byteCount < 0: ").toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        try {
            Segment segmentWritableSegment$okio = sink.writableSegment$okio(1);
            int iMin = (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit);
            refill();
            int iInflate = this.inflater.inflate(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            releaseBytesAfterInflate();
            if (iInflate > 0) {
                segmentWritableSegment$okio.limit += iInflate;
                long j8 = iInflate;
                sink.setSize$okio(sink.size() + j8);
                return j8;
            }
            if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                sink.head = segmentWritableSegment$okio.pop();
                SegmentPool.recycle(segmentWritableSegment$okio);
            }
            return 0L;
        } catch (DataFormatException e9) {
            throw new IOException(e9);
        }
    }

    public final boolean refill() {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        k.b(segment);
        int i9 = segment.limit;
        int i10 = segment.pos;
        int i11 = i9 - i10;
        this.bufferBytesHeldByInflater = i11;
        this.inflater.setInput(segment.data, i10, i11);
        return false;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
        k.e(source, "source");
        k.e(inflater, "inflater");
    }
}
