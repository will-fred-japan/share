package okio;

import java.util.zip.Deflater;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink sink, Deflater deflater) {
        k.e(sink, "sink");
        k.e(deflater, "deflater");
        this.sink = sink;
        this.deflater = deflater;
    }

    private final void deflate(boolean z8) {
        Segment segmentWritableSegment$okio;
        int iDeflate;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            if (z8) {
                Deflater deflater = this.deflater;
                byte[] bArr = segmentWritableSegment$okio.data;
                int i9 = segmentWritableSegment$okio.limit;
                iDeflate = deflater.deflate(bArr, i9, 8192 - i9, 2);
            } else {
                Deflater deflater2 = this.deflater;
                byte[] bArr2 = segmentWritableSegment$okio.data;
                int i10 = segmentWritableSegment$okio.limit;
                iDeflate = deflater2.deflate(bArr2, i10, 8192 - i10);
            }
            if (iDeflate > 0) {
                segmentWritableSegment$okio.limit += iDeflate;
                buffer.setSize$okio(buffer.size() + ((long) iDeflate));
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
            buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        finishDeflate$okio();
        th = null;
        try {
            this.deflater.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        deflate(true);
        this.sink.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    @Override // okio.Sink
    public void write(Buffer source, long j) {
        k.e(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            Segment segment = source.head;
            k.b(segment);
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, iMin);
            deflate(false);
            long j8 = iMin;
            source.setSize$okio(source.size() - j8);
            int i9 = segment.pos + iMin;
            segment.pos = i9;
            if (i9 == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j -= j8;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        k.e(sink, "sink");
        k.e(deflater, "deflater");
    }
}
