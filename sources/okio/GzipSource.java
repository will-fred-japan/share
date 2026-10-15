package okio;

import defpackage.f;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: GzipSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source source) {
        k.e(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource((BufferedSource) realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    private final void checkEqual(String str, int i9, int i10) throws IOException {
        if (i10 != i9) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i10), Integer.valueOf(i9)}, 3)));
        }
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10L);
        byte b9 = this.source.bufferField.getByte(3L);
        boolean z8 = ((b9 >> 1) & 1) == 1;
        if (z8) {
            updateCrc(this.source.bufferField, 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b9 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z8) {
                updateCrc(this.source.bufferField, 0L, 2L);
            }
            long shortLe = this.source.bufferField.readShortLe() & 65535;
            this.source.require(shortLe);
            if (z8) {
                updateCrc(this.source.bufferField, 0L, shortLe);
            }
            this.source.skip(shortLe);
        }
        if (((b9 >> 3) & 1) == 1) {
            long jIndexOf = this.source.indexOf((byte) 0);
            if (jIndexOf == -1) {
                throw new EOFException();
            }
            if (z8) {
                updateCrc(this.source.bufferField, 0L, jIndexOf + 1);
            }
            this.source.skip(jIndexOf + 1);
        }
        if (((b9 >> 4) & 1) == 1) {
            long jIndexOf2 = this.source.indexOf((byte) 0);
            if (jIndexOf2 == -1) {
                throw new EOFException();
            }
            if (z8) {
                updateCrc(this.source.bufferField, 0L, jIndexOf2 + 1);
            }
            this.source.skip(jIndexOf2 + 1);
        }
        if (z8) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long j, long j8) {
        Segment segment = buffer.head;
        k.b(segment);
        while (true) {
            int i9 = segment.limit;
            int i10 = segment.pos;
            if (j < i9 - i10) {
                break;
            }
            j -= (long) (i9 - i10);
            segment = segment.next;
            k.b(segment);
        }
        while (j8 > 0) {
            int i11 = (int) (((long) segment.pos) + j);
            int iMin = (int) Math.min(segment.limit - i11, j8);
            this.crc.update(segment.data, i11, iMin);
            j8 -= (long) iMin;
            segment = segment.next;
            k.b(segment);
            j = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public long read(Buffer sink, long j) throws IOException {
        GzipSource gzipSource;
        k.e(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(f.d(j, "byteCount < 0: ").toString());
        }
        if (j == 0) {
            return 0L;
        }
        if (this.section == 0) {
            consumeHeader();
            this.section = (byte) 1;
        }
        if (this.section == 1) {
            long size = sink.size();
            long j8 = this.inflaterSource.read(sink, j);
            if (j8 != -1) {
                updateCrc(sink, size, j8);
                return j8;
            }
            gzipSource = this;
            gzipSource.section = (byte) 2;
        } else {
            gzipSource = this;
        }
        if (gzipSource.section == 2) {
            consumeTrailer();
            gzipSource.section = (byte) 3;
            if (!gzipSource.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
