package okio;

import W5.e;
import androidx.datastore.preferences.protobuf.C0524s;
import com.alibaba.fastjson.asm.Opcodes;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import defpackage.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.k;
import okhttp3.internal.connection.RealConnection;
import p171w.a;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    private long size;

    /* JADX INFO: compiled from: Buffer.kt */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i9) {
            if (i9 <= 0) {
                throw new IllegalArgumentException(e.i(i9, "minByteCount <= 0: ").toString());
            }
            if (i9 > 8192) {
                throw new IllegalArgumentException(e.i(i9, "minByteCount > Segment.SIZE: ").toString());
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long size = buffer.size();
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i9);
            int i10 = 8192 - segmentWritableSegment$okio.limit;
            segmentWritableSegment$okio.limit = 8192;
            long j = i10;
            buffer.setSize$okio(size + j);
            setSegment$okio(segmentWritableSegment$okio);
            this.offset = size;
            this.data = segmentWritableSegment$okio.data;
            this.start = 8192 - i10;
            this.end = 8192;
            return j;
        }

        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            long j = this.offset;
            Buffer buffer = this.buffer;
            k.b(buffer);
            if (j == buffer.size()) {
                throw new IllegalStateException("no more bytes");
            }
            long j8 = this.offset;
            return seek(j8 == -1 ? 0L : j8 + ((long) (this.end - this.start)));
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long size = buffer.size();
            if (j <= size) {
                if (j < 0) {
                    throw new IllegalArgumentException(f.d(j, "newSize < 0: ").toString());
                }
                long j8 = size - j;
                while (j8 > 0) {
                    Segment segment = buffer.head;
                    k.b(segment);
                    Segment segment2 = segment.prev;
                    k.b(segment2);
                    int i9 = segment2.limit;
                    long j9 = i9 - segment2.pos;
                    if (j9 > j8) {
                        segment2.limit = i9 - ((int) j8);
                        break;
                    }
                    buffer.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                    j8 -= j9;
                }
                setSegment$okio(null);
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > size) {
                long j10 = j - size;
                boolean z8 = true;
                while (j10 > 0) {
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                    int iMin = (int) Math.min(j10, 8192 - segmentWritableSegment$okio.limit);
                    segmentWritableSegment$okio.limit += iMin;
                    j10 -= (long) iMin;
                    if (z8) {
                        setSegment$okio(segmentWritableSegment$okio);
                        this.offset = size;
                        this.data = segmentWritableSegment$okio.data;
                        int i10 = segmentWritableSegment$okio.limit;
                        this.start = i10 - iMin;
                        this.end = i10;
                        z8 = false;
                    }
                }
            }
            buffer.setSize$okio(j);
            return size;
        }

        public final int seek(long j) {
            Segment segmentPush;
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j < -1 || j > buffer.size()) {
                StringBuilder sbH = f.h(j, "offset=", " > size=");
                sbH.append(buffer.size());
                throw new ArrayIndexOutOfBoundsException(sbH.toString());
            }
            if (j == -1 || j == buffer.size()) {
                setSegment$okio(null);
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long size = buffer.size();
            Segment segment$okio = buffer.head;
            long j8 = 0;
            if (getSegment$okio() != null) {
                long j9 = this.offset;
                int i9 = this.start;
                Segment segment$okio2 = getSegment$okio();
                k.b(segment$okio2);
                long j10 = j9 - ((long) (i9 - segment$okio2.pos));
                if (j10 > j) {
                    segmentPush = segment$okio;
                    segment$okio = getSegment$okio();
                    size = j10;
                } else {
                    segmentPush = getSegment$okio();
                    j8 = j10;
                }
            } else {
                segmentPush = segment$okio;
            }
            if (size - j > j - j8) {
                while (true) {
                    k.b(segmentPush);
                    int i10 = segmentPush.limit;
                    int i11 = segmentPush.pos;
                    if (j < ((long) (i10 - i11)) + j8) {
                        break;
                    }
                    j8 += (long) (i10 - i11);
                    segmentPush = segmentPush.next;
                }
            } else {
                while (size > j) {
                    k.b(segment$okio);
                    segment$okio = segment$okio.prev;
                    k.b(segment$okio);
                    size -= (long) (segment$okio.limit - segment$okio.pos);
                }
                j8 = size;
                segmentPush = segment$okio;
            }
            if (this.readWrite) {
                k.b(segmentPush);
                if (segmentPush.shared) {
                    Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                    if (buffer.head == segmentPush) {
                        buffer.head = segmentUnsharedCopy;
                    }
                    segmentPush = segmentPush.push(segmentUnsharedCopy);
                    Segment segment = segmentPush.prev;
                    k.b(segment);
                    segment.pop();
                }
            }
            setSegment$okio(segmentPush);
            this.offset = j;
            k.b(segmentPush);
            this.data = segmentPush.data;
            int i12 = segmentPush.pos + ((int) (j - j8));
            this.start = i12;
            int i13 = segmentPush.limit;
            this.end = i13;
            return i13 - i12;
        }

        public final void setSegment$okio(Segment segment) {
            this.segment = segment;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            j = 0;
        }
        long j9 = j;
        if ((i9 & 4) != 0) {
            j8 = buffer.size - j9;
        }
        return buffer.copyTo(outputStream, j9, j8);
    }

    private final ByteString digest(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i9 = segment.pos;
            messageDigest.update(bArr, i9, segment.limit - i9);
            Segment segment2 = segment.next;
            k.b(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i10 = segment2.pos;
                messageDigest.update(bArr2, i10, segment2.limit - i10);
                segment2 = segment2.next;
                k.b(segment2);
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        k.d(bArrDigest, "messageDigest.digest()");
        return new ByteString(bArrDigest);
    }

    private final ByteString hmac(String str, ByteString byteString) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i9 = segment.pos;
                mac.update(bArr, i9, segment.limit - i9);
                Segment segment2 = segment.next;
                k.b(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i10 = segment2.pos;
                    mac.update(bArr2, i10, segment2.limit - i10);
                    segment2 = segment2.next;
                    k.b(segment2);
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            k.d(bArrDoFinal, "mac.doFinal()");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e9) {
            throw new IllegalArgumentException(e9);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m984deprecated_getByte(long j) {
        return getByte(j);
    }

    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final long m985deprecated_size() {
        return this.size;
    }

    public final void clear() throws EOFException {
        skip(size());
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        k.b(segment);
        Segment segment2 = segment.prev;
        k.b(segment2);
        int i9 = segment2.limit;
        return (i9 >= 8192 || !segment2.owner) ? size : size - ((long) (i9 - segment2.pos));
    }

    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() == 0) {
            return buffer;
        }
        Segment segment = this.head;
        k.b(segment);
        Segment segmentSharedCopy = segment.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = segmentSharedCopy.prev;
            k.b(segment3);
            k.b(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer.setSize$okio(size());
        return buffer;
    }

    public final Buffer copyTo(OutputStream out) {
        k.e(out, "out");
        return copyTo$default(this, out, 0L, 0L, 6, (Object) null);
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (size() != buffer.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        Segment segment = this.head;
        k.b(segment);
        Segment segment2 = buffer.head;
        k.b(segment2);
        int i9 = segment.pos;
        int i10 = segment2.pos;
        long j = 0;
        while (j < size()) {
            long jMin = Math.min(segment.limit - i9, segment2.limit - i10);
            long j8 = 0;
            while (j8 < jMin) {
                int i11 = i9 + 1;
                int i12 = i10 + 1;
                if (segment.data[i9] != segment2.data[i10]) {
                    return false;
                }
                j8++;
                i9 = i11;
                i10 = i12;
            }
            if (i9 == segment.limit) {
                segment = segment.next;
                k.b(segment);
                i9 = segment.pos;
            }
            if (i10 == segment2.limit) {
                segment2 = segment2.next;
                k.b(segment2);
                i10 = segment2.pos;
            }
            j += jMin;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    public final byte getByte(long j) {
        SegmentedByteString.checkOffsetAndCount(size(), j, 1L);
        Segment segment = this.head;
        if (segment == null) {
            k.b(null);
            throw null;
        }
        if (size() - j < j) {
            long size = size();
            while (size > j) {
                segment = segment.prev;
                k.b(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            return segment.data[(int) ((((long) segment.pos) + j) - size)];
        }
        long j8 = 0;
        while (true) {
            int i9 = segment.limit;
            int i10 = segment.pos;
            long j9 = ((long) (i9 - i10)) + j8;
            if (j9 > j) {
                return segment.data[(int) ((((long) i10) + j) - j8)];
            }
            segment = segment.next;
            k.b(segment);
            j8 = j9;
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i9 = 1;
        do {
            int i10 = segment.limit;
            for (int i11 = segment.pos; i11 < i10; i11++) {
                i9 = (i9 * 31) + segment.data[i11];
            }
            segment = segment.next;
            k.b(segment);
        } while (segment != this.head);
        return i9;
    }

    public final ByteString hmacSha1(ByteString key) {
        k.e(key, "key");
        return hmac("HmacSHA1", key);
    }

    public final ByteString hmacSha256(ByteString key) {
        k.e(key, "key");
        return hmac("HmacSHA256", key);
    }

    public final ByteString hmacSha512(ByteString key) {
        k.e(key, "key");
        return hmac("HmacSHA512", key);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b9) {
        return indexOf(b9, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes) {
        k.e(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.inputStream.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] sink, int i9, int i10) {
                k.e(sink, "sink");
                return Buffer.this.read(sink, i9, i10);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.outputStream.1
            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i9) {
                Buffer.this.writeByte(i9);
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int i9, int i10) {
                k.e(data, "data");
                Buffer.this.write(data, i9, i10);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }
        };
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString bytes) {
        k.e(bytes, "bytes");
        return rangeEquals(j, bytes, 0, bytes.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        k.e(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, iMin);
        int i9 = segment.pos + iMin;
        segment.pos = i9;
        this.size -= (long) iMin;
        if (i9 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) {
        k.e(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        k.b(segment);
        int i9 = segment.pos;
        int i10 = segment.limit;
        int i11 = i9 + 1;
        byte b9 = segment.data[i9];
        setSize$okio(size() - 1);
        if (i11 != i10) {
            segment.pos = i11;
            return b9;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return b9;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        long j;
        byte b9;
        long j8 = 0;
        if (size() == 0) {
            throw new EOFException();
        }
        int i9 = 0;
        boolean z8 = false;
        long j9 = 0;
        long j10 = -7;
        boolean z9 = false;
        loop0: while (true) {
            Segment segment = this.head;
            k.b(segment);
            byte[] bArr = segment.data;
            int i10 = segment.pos;
            int i11 = segment.limit;
            while (true) {
                if (i10 >= i11) {
                    j = j8;
                    break;
                }
                b9 = bArr[i10];
                if (b9 >= 48 && b9 <= 57) {
                    int i12 = 48 - b9;
                    if (j9 < okio.internal.Buffer.OVERFLOW_ZONE) {
                        break loop0;
                    }
                    j = j8;
                    if (j9 == okio.internal.Buffer.OVERFLOW_ZONE && i12 < j10) {
                        break loop0;
                    }
                    j9 = (j9 * 10) + ((long) i12);
                } else {
                    j = j8;
                    if (b9 != 45 || i9 != 0) {
                        z9 = true;
                        break;
                    }
                    j10--;
                    z8 = true;
                }
                i10++;
                i9++;
                j8 = j;
            }
            if (i10 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i10;
            }
            if (z9 || this.head == null) {
                setSize$okio(size() - ((long) i9));
                if (i9 >= (z8 ? 2 : 1)) {
                    return z8 ? j9 : -j9;
                }
                if (size() == j) {
                    throw new EOFException();
                }
                StringBuilder sbC = a.c(z8 ? "Expected a digit" : "Expected a digit or '-'", " but was 0x");
                sbC.append(SegmentedByteString.toHexString(getByte(j)));
                throw new NumberFormatException(sbC.toString());
            }
            j8 = j;
        }
        Buffer bufferWriteByte = new Buffer().writeDecimalLong(j9).writeByte((int) b9);
        if (!z8) {
            bufferWriteByte.readByte();
        }
        throw new NumberFormatException("Number too large: " + bufferWriteByte.readUtf8());
    }

    public final Buffer readFrom(InputStream input) throws IOException {
        k.e(input, "input");
        readFrom(input, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer sink, long j) throws EOFException {
        k.e(sink, "sink");
        if (size() >= j) {
            sink.write(this, j);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        int i9;
        if (size() == 0) {
            throw new EOFException();
        }
        int i10 = 0;
        boolean z8 = false;
        long j = 0;
        do {
            Segment segment = this.head;
            k.b(segment);
            byte[] bArr = segment.data;
            int i11 = segment.pos;
            int i12 = segment.limit;
            while (i11 < i12) {
                byte b9 = bArr[i11];
                if (b9 >= 48 && b9 <= 57) {
                    i9 = b9 - 48;
                } else if (b9 >= 97 && b9 <= 102) {
                    i9 = b9 - 87;
                } else {
                    if (b9 < 65 || b9 > 70) {
                        if (i10 != 0) {
                            z8 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + SegmentedByteString.toHexString(b9));
                    }
                    i9 = b9 - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b9).readUtf8());
                }
                j = (j << 4) | ((long) i9);
                i11++;
                i10++;
            }
            if (i11 == i12) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i11;
            }
            if (z8) {
                break;
            }
        } while (this.head != null);
        setSize$okio(size() - ((long) i10));
        return j;
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        k.b(segment);
        int i9 = segment.pos;
        int i10 = segment.limit;
        if (i10 - i9 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i11 = i9 + 3;
        int i12 = ((bArr[i9 + 1] & 255) << 16) | ((bArr[i9] & 255) << 24) | ((bArr[i9 + 2] & 255) << 8);
        int i13 = i9 + 4;
        int i14 = (bArr[i11] & 255) | i12;
        setSize$okio(size() - 4);
        if (i13 != i10) {
            segment.pos = i13;
            return i14;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return i14;
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return SegmentedByteString.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment = this.head;
        k.b(segment);
        int i9 = segment.pos;
        int i10 = segment.limit;
        if (i10 - i9 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = segment.data;
        int i11 = i9 + 7;
        long j = ((((long) bArr[i9]) & 255) << 56) | ((((long) bArr[i9 + 1]) & 255) << 48) | ((((long) bArr[i9 + 2]) & 255) << 40) | ((((long) bArr[i9 + 3]) & 255) << 32) | ((((long) bArr[i9 + 4]) & 255) << 24) | ((((long) bArr[i9 + 5]) & 255) << 16) | ((((long) bArr[i9 + 6]) & 255) << 8);
        int i12 = i9 + 8;
        long j8 = j | (((long) bArr[i11]) & 255);
        setSize$okio(size() - 8);
        if (i12 != i10) {
            segment.pos = i12;
            return j8;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return j8;
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return SegmentedByteString.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        k.b(segment);
        int i9 = segment.pos;
        int i10 = segment.limit;
        if (i10 - i9 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i11 = i9 + 1;
        int i12 = (bArr[i9] & 255) << 8;
        int i13 = i9 + 2;
        int i14 = (bArr[i11] & 255) | i12;
        setSize$okio(size() - 2);
        if (i13 == i10) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i13;
        }
        return (short) i14;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return SegmentedByteString.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        k.e(charset, "charset");
        return readString(this.size, charset);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, R7.a.f4067b);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i9;
        int i10;
        int i11;
        if (size() == 0) {
            throw new EOFException();
        }
        byte b9 = getByte(0L);
        if ((b9 & 128) == 0) {
            i9 = b9 & 127;
            i11 = 0;
            i10 = 1;
        } else if ((b9 & 224) == 192) {
            i9 = b9 & 31;
            i10 = 2;
            i11 = 128;
        } else if ((b9 & 240) == 224) {
            i9 = b9 & 15;
            i10 = 3;
            i11 = OpusCodecConfig.APPLICATION_VOIP;
        } else {
            if ((b9 & 248) != 240) {
                skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i9 = b9 & 7;
            i10 = 4;
            i11 = 65536;
        }
        long j = i10;
        if (size() < j) {
            StringBuilder sbA = C0524s.a(i10, "size < ", ": ");
            sbA.append(size());
            sbA.append(" (to read code point prefixed 0x");
            sbA.append(SegmentedByteString.toHexString(b9));
            sbA.append(')');
            throw new EOFException(sbA.toString());
        }
        for (int i12 = 1; i12 < i10; i12++) {
            long j8 = i12;
            byte b10 = getByte(j8);
            if ((b10 & 192) != 128) {
                skip(j8);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i9 = (i9 << 6) | (b10 & Utf8.REPLACEMENT_BYTE);
        }
        skip(j);
        if (i9 > 1114111) {
            return Utf8.REPLACEMENT_CODE_POINT;
        }
        return ((55296 > i9 || i9 >= 57344) && i9 >= i11) ? i9 : Utf8.REPLACEMENT_CODE_POINT;
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this, jIndexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) throws EOFException {
        k.e(options, "options");
        int iSelectPrefix$default = okio.internal.Buffer.selectPrefix$default(this, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            long j8 = iMin;
            setSize$okio(size() - j8);
            j -= j8;
            int i9 = segment.pos + iMin;
            segment.pos = i9;
            if (i9 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Segment writableSegment$okio(int i9) {
        if (i9 < 1 || i9 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = this.head;
        if (segment != null) {
            k.b(segment);
            Segment segment2 = segment.prev;
            k.b(segment2);
            return (segment2.limit + i9 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment segmentTake = SegmentPool.take();
        this.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) {
        k.e(source, "source");
        long j = 0;
        while (true) {
            long j8 = source.read(this, 8192L);
            if (j8 == -1) {
                return j;
            }
            j += j8;
        }
    }

    public final Buffer writeTo(OutputStream out) {
        k.e(out, "out");
        return writeTo$default(this, out, 0L, 2, null);
    }

    public Buffer clone() {
        return copy();
    }

    public final Buffer copyTo(OutputStream out, long j) {
        k.e(out, "out");
        return copyTo$default(this, out, j, 0L, 4, (Object) null);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b9, long j) {
        return indexOf(b9, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes, long j) {
        int i9;
        int i10;
        k.e(targetBytes, "targetBytes");
        long size = 0;
        if (j < 0) {
            throw new IllegalArgumentException(f.d(j, "fromIndex < 0: ").toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        if (size() - j < j) {
            size = size();
            while (size > j) {
                segment = segment.prev;
                k.b(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            if (targetBytes.size() == 2) {
                byte b9 = targetBytes.getByte(0);
                byte b10 = targetBytes.getByte(1);
                while (size < size()) {
                    byte[] bArr = segment.data;
                    i9 = (int) ((((long) segment.pos) + j) - size);
                    int i11 = segment.limit;
                    while (true) {
                        if (i9 >= i11) {
                            size += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            k.b(segment);
                            j = size;
                        } else {
                            byte b11 = bArr[i9];
                            if (b11 == b9 || b11 == b10) {
                                i10 = segment.pos;
                            } else {
                                i9++;
                            }
                        }
                    }
                }
            } else {
                byte[] bArrInternalArray$okio = targetBytes.internalArray$okio();
                while (size < size()) {
                    byte[] bArr2 = segment.data;
                    i9 = (int) ((((long) segment.pos) + j) - size);
                    int i12 = segment.limit;
                    while (true) {
                        if (i9 < i12) {
                            byte b12 = bArr2[i9];
                            int length = bArrInternalArray$okio.length;
                            int i13 = 0;
                            while (true) {
                                if (i13 >= length) {
                                    i9++;
                                } else if (b12 == bArrInternalArray$okio[i13]) {
                                    i10 = segment.pos;
                                } else {
                                    i13++;
                                }
                            }
                        } else {
                            size += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            k.b(segment);
                            j = size;
                        }
                    }
                }
            }
            return -1L;
        }
        while (true) {
            long j8 = ((long) (segment.limit - segment.pos)) + size;
            if (j8 > j) {
                break;
            }
            segment = segment.next;
            k.b(segment);
            size = j8;
        }
        if (targetBytes.size() == 2) {
            byte b13 = targetBytes.getByte(0);
            byte b14 = targetBytes.getByte(1);
            while (size < size()) {
                byte[] bArr3 = segment.data;
                i9 = (int) ((((long) segment.pos) + j) - size);
                int i14 = segment.limit;
                while (true) {
                    if (i9 >= i14) {
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        k.b(segment);
                        j = size;
                    } else {
                        byte b15 = bArr3[i9];
                        if (b15 == b13 || b15 == b14) {
                            i10 = segment.pos;
                        } else {
                            i9++;
                        }
                    }
                }
            }
        } else {
            byte[] bArrInternalArray$okio2 = targetBytes.internalArray$okio();
            while (size < size()) {
                byte[] bArr4 = segment.data;
                i9 = (int) ((((long) segment.pos) + j) - size);
                int i15 = segment.limit;
                while (true) {
                    if (i9 < i15) {
                        byte b16 = bArr4[i9];
                        int length2 = bArrInternalArray$okio2.length;
                        int i16 = 0;
                        while (true) {
                            if (i16 >= length2) {
                                i9++;
                            } else if (b16 == bArrInternalArray$okio2[i16]) {
                                i10 = segment.pos;
                            } else {
                                i16++;
                            }
                        }
                    } else {
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        k.b(segment);
                        j = size;
                    }
                }
            }
        }
        return -1L;
        return ((long) (i9 - i10)) + size;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString bytes, int i9, int i10) {
        k.e(bytes, "bytes");
        if (j < 0 || i9 < 0 || i10 < 0 || size() - j < i10 || bytes.size() - i9 < i10) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (getByte(((long) i11) + j) != bytes.getByte(i9 + i11)) {
                return false;
            }
        }
        return true;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        k.e(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(f.d(j, "byteCount: ").toString());
        }
        if (size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(f.d(j, "byteCount: ").toString());
        }
        if (size() < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(readByteArray(j));
        }
        ByteString byteStringSnapshot = snapshot((int) j);
        skip(j);
        return byteStringSnapshot;
    }

    public final Buffer readFrom(InputStream input, long j) throws IOException {
        k.e(input, "input");
        if (j < 0) {
            throw new IllegalArgumentException(f.d(j, "byteCount < 0: ").toString());
        }
        readFrom(input, j, false);
        return this;
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        k.e(charset, "charset");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(f.d(j, "byteCount: ").toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.head;
        k.b(segment);
        int i9 = segment.pos;
        if (((long) i9) + j > segment.limit) {
            return new String(readByteArray(j), charset);
        }
        int i10 = (int) j;
        String str = new String(segment.data, i9, i10, charset);
        int i11 = segment.pos + i10;
        segment.pos = i11;
        this.size -= j;
        if (i11 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        k.e(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.commonReadUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, R7.a.f4067b);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(f.d(j, "limit < 0: ").toString());
        }
        long j8 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j8);
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this, jIndexOf);
        }
        if (j8 < size() && getByte(j8 - 1) == 13 && getByte(j8) == 10) {
            return okio.internal.Buffer.readUtf8Line(this, j8);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i9) {
        Segment segmentWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i10 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i10 + 1;
        bArr[i10] = (byte) i9;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        boolean z8;
        if (j == 0) {
            return writeByte(48);
        }
        int i9 = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z8 = true;
        } else {
            z8 = false;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j >= 100) {
                    i9 = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i9 = 2;
                }
            } else if (j < 1000000) {
                i9 = j < 100000 ? 5 : 6;
            } else {
                i9 = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                i9 = j < 1000000000 ? 9 : 10;
            } else {
                i9 = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i9 = 13;
            } else {
                i9 = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i9 = j < 10000000000000000L ? 16 : 17;
        } else {
            i9 = j < 1000000000000000000L ? 18 : 19;
        }
        if (z8) {
            i9++;
        }
        Segment segmentWritableSegment$okio = writableSegment$okio(i9);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i10 = segmentWritableSegment$okio.limit + i9;
        while (j != 0) {
            long j8 = 10;
            i10--;
            bArr[i10] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (j % j8)];
            j /= j8;
        }
        if (z8) {
            bArr[i10 - 1] = 45;
        }
        segmentWritableSegment$okio.limit += i9;
        setSize$okio(size() + ((long) i9));
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j8 = (j >>> 1) | j;
        long j9 = j8 | (j8 >>> 2);
        long j10 = j9 | (j9 >>> 4);
        long j11 = j10 | (j10 >>> 8);
        long j12 = j11 | (j11 >>> 16);
        long j13 = j12 | (j12 >>> 32);
        long j14 = j13 - ((j13 >>> 1) & 6148914691236517205L);
        long j15 = ((j14 >>> 2) & 3689348814741910323L) + (j14 & 3689348814741910323L);
        long j16 = ((j15 >>> 4) + j15) & 1085102592571150095L;
        long j17 = j16 + (j16 >>> 8);
        long j18 = j17 + (j17 >>> 16);
        int i9 = (int) ((((j18 & 63) + ((j18 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = writableSegment$okio(i9);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i10 = segmentWritableSegment$okio.limit;
        for (int i11 = (i10 + i9) - 1; i11 >= i10; i11--) {
            bArr[i11] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment$okio.limit += i9;
        setSize$okio(size() + ((long) i9));
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i9) {
        Segment segmentWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i10 = segmentWritableSegment$okio.limit;
        bArr[i10] = (byte) ((i9 >>> 24) & 255);
        bArr[i10 + 1] = (byte) ((i9 >>> 16) & 255);
        bArr[i10 + 2] = (byte) ((i9 >>> 8) & 255);
        bArr[i10 + 3] = (byte) (i9 & 255);
        segmentWritableSegment$okio.limit = i10 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i9) {
        return writeInt(SegmentedByteString.reverseBytes(i9));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment segmentWritableSegment$okio = writableSegment$okio(8);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i9 = segmentWritableSegment$okio.limit;
        bArr[i9] = (byte) ((j >>> 56) & 255);
        bArr[i9 + 1] = (byte) ((j >>> 48) & 255);
        bArr[i9 + 2] = (byte) ((j >>> 40) & 255);
        bArr[i9 + 3] = (byte) ((j >>> 32) & 255);
        bArr[i9 + 4] = (byte) ((j >>> 24) & 255);
        bArr[i9 + 5] = (byte) ((j >>> 16) & 255);
        bArr[i9 + 6] = (byte) ((j >>> 8) & 255);
        bArr[i9 + 7] = (byte) (j & 255);
        segmentWritableSegment$okio.limit = i9 + 8;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(SegmentedByteString.reverseBytes(j));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i9) {
        Segment segmentWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i10 = segmentWritableSegment$okio.limit;
        bArr[i10] = (byte) ((i9 >>> 8) & 255);
        bArr[i10 + 1] = (byte) (i9 & 255);
        segmentWritableSegment$okio.limit = i10 + 2;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i9) {
        return writeShort((int) SegmentedByteString.reverseBytes((short) i9));
    }

    public final Buffer writeTo(OutputStream out, long j) throws IOException {
        k.e(out, "out");
        SegmentedByteString.checkOffsetAndCount(this.size, 0L, j);
        Segment segment = this.head;
        long j8 = j;
        while (j8 > 0) {
            k.b(segment);
            int iMin = (int) Math.min(j8, segment.limit - segment.pos);
            out.write(segment.data, segment.pos, iMin);
            int i9 = segment.pos + iMin;
            segment.pos = i9;
            long j9 = iMin;
            this.size -= j9;
            j8 -= j9;
            if (i9 == segment.limit) {
                Segment segmentPop = segment.pop();
                this.head = segmentPop;
                SegmentPool.recycle(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i9) {
        if (i9 < 128) {
            writeByte(i9);
            return this;
        }
        if (i9 < 2048) {
            Segment segmentWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i10 = segmentWritableSegment$okio.limit;
            bArr[i10] = (byte) ((i9 >> 6) | Opcodes.CHECKCAST);
            bArr[i10 + 1] = (byte) ((i9 & 63) | 128);
            segmentWritableSegment$okio.limit = i10 + 2;
            setSize$okio(size() + 2);
            return this;
        }
        if (55296 <= i9 && i9 < 57344) {
            writeByte(63);
            return this;
        }
        if (i9 < 65536) {
            Segment segmentWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i11 = segmentWritableSegment$okio2.limit;
            bArr2[i11] = (byte) ((i9 >> 12) | 224);
            bArr2[i11 + 1] = (byte) (((i9 >> 6) & 63) | 128);
            bArr2[i11 + 2] = (byte) ((i9 & 63) | 128);
            segmentWritableSegment$okio2.limit = i11 + 3;
            setSize$okio(size() + 3);
            return this;
        }
        if (i9 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i9));
        }
        Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
        byte[] bArr3 = segmentWritableSegment$okio3.data;
        int i12 = segmentWritableSegment$okio3.limit;
        bArr3[i12] = (byte) ((i9 >> 18) | 240);
        bArr3[i12 + 1] = (byte) (((i9 >> 12) & 63) | 128);
        bArr3[i12 + 2] = (byte) (((i9 >> 6) & 63) | 128);
        bArr3[i12 + 3] = (byte) ((i9 & 63) | 128);
        segmentWritableSegment$okio3.limit = i12 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j, j8);
    }

    public final Buffer copyTo(OutputStream out, long j, long j8) throws IOException {
        k.e(out, "out");
        long j9 = j;
        SegmentedByteString.checkOffsetAndCount(this.size, j9, j8);
        if (j8 != 0) {
            Segment segment = this.head;
            while (true) {
                k.b(segment);
                int i9 = segment.limit;
                int i10 = segment.pos;
                if (j9 < i9 - i10) {
                    break;
                }
                j9 -= (long) (i9 - i10);
                segment = segment.next;
            }
            Segment segment2 = segment;
            long j10 = j8;
            while (j10 > 0) {
                k.b(segment2);
                int i11 = (int) (((long) segment2.pos) + j9);
                int iMin = (int) Math.min(segment2.limit - i11, j10);
                out.write(segment2.data, i11, iMin);
                j10 -= (long) iMin;
                segment2 = segment2.next;
                j9 = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes) {
        k.e(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, Charset charset) {
        k.e(string, "string");
        k.e(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string) {
        k.e(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b9, long j, long j8) {
        Segment segment;
        int i9;
        long size = 0;
        if (0 > j || j > j8) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j + " toIndex=" + j8).toString());
        }
        if (j8 > size()) {
            j8 = size();
        }
        if (j == j8 || (segment = this.head) == null) {
            return -1L;
        }
        if (size() - j < j) {
            size = size();
            while (size > j) {
                segment = segment.prev;
                k.b(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            while (size < j8) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j8) - size);
                i9 = (int) ((((long) segment.pos) + j) - size);
                while (i9 < iMin) {
                    if (bArr[i9] != b9) {
                        i9++;
                    }
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                k.b(segment);
                j = size;
            }
            return -1L;
        }
        while (true) {
            long j9 = ((long) (segment.limit - segment.pos)) + size;
            if (j9 > j) {
                break;
            }
            segment = segment.next;
            k.b(segment);
            size = j9;
        }
        while (size < j8) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j8) - size);
            i9 = (int) ((((long) segment.pos) + j) - size);
            while (i9 < iMin2) {
                if (bArr2[i9] != b9) {
                    i9++;
                }
            }
            size += (long) (segment.limit - segment.pos);
            segment = segment.next;
            k.b(segment);
            j = size;
        }
        return -1L;
        return ((long) (i9 - segment.pos)) + size;
    }

    public final ByteString snapshot(int i9) {
        if (i9 == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(size(), 0L, i9);
        Segment segment = this.head;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            k.b(segment);
            int i13 = segment.limit;
            int i14 = segment.pos;
            if (i13 != i14) {
                i11 += i13 - i14;
                i12++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i12][];
        int[] iArr = new int[i12 * 2];
        Segment segment2 = this.head;
        int i15 = 0;
        while (i10 < i9) {
            k.b(segment2);
            bArr[i15] = segment2.data;
            i10 += segment2.limit - segment2.pos;
            iArr[i15] = Math.min(i10, i9);
            iArr[i15 + i12] = segment2.pos;
            segment2.shared = true;
            i15++;
            segment2 = segment2.next;
        }
        return new C0627SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string, int i9, int i10) {
        char cCharAt;
        k.e(string, "string");
        if (i9 < 0) {
            throw new IllegalArgumentException(e.i(i9, "beginIndex < 0: ").toString());
        }
        if (i10 >= i9) {
            if (i10 > string.length()) {
                StringBuilder sbA = C0524s.a(i10, "endIndex > string.length: ", " > ");
                sbA.append(string.length());
                throw new IllegalArgumentException(sbA.toString().toString());
            }
            while (i9 < i10) {
                char cCharAt2 = string.charAt(i9);
                if (cCharAt2 < 128) {
                    Segment segmentWritableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = segmentWritableSegment$okio.data;
                    int i11 = segmentWritableSegment$okio.limit - i9;
                    int iMin = Math.min(i10, 8192 - i11);
                    int i12 = i9 + 1;
                    bArr[i9 + i11] = (byte) cCharAt2;
                    while (true) {
                        i9 = i12;
                        if (i9 >= iMin || (cCharAt = string.charAt(i9)) >= 128) {
                            break;
                        }
                        i12 = i9 + 1;
                        bArr[i9 + i11] = (byte) cCharAt;
                    }
                    int i13 = segmentWritableSegment$okio.limit;
                    int i14 = (i11 + i9) - i13;
                    segmentWritableSegment$okio.limit = i13 + i14;
                    setSize$okio(size() + ((long) i14));
                } else {
                    if (cCharAt2 < 2048) {
                        Segment segmentWritableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = segmentWritableSegment$okio2.data;
                        int i15 = segmentWritableSegment$okio2.limit;
                        bArr2[i15] = (byte) ((cCharAt2 >> 6) | Opcodes.CHECKCAST);
                        bArr2[i15 + 1] = (byte) ((cCharAt2 & '?') | 128);
                        segmentWritableSegment$okio2.limit = i15 + 2;
                        setSize$okio(size() + 2);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i16 = i9 + 1;
                        char cCharAt3 = i16 < i10 ? string.charAt(i16) : (char) 0;
                        if (cCharAt2 <= 56319 && 56320 <= cCharAt3 && cCharAt3 < 57344) {
                            int i17 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = segmentWritableSegment$okio3.data;
                            int i18 = segmentWritableSegment$okio3.limit;
                            bArr3[i18] = (byte) ((i17 >> 18) | 240);
                            bArr3[i18 + 1] = (byte) (((i17 >> 12) & 63) | 128);
                            bArr3[i18 + 2] = (byte) (((i17 >> 6) & 63) | 128);
                            bArr3[i18 + 3] = (byte) ((i17 & 63) | 128);
                            segmentWritableSegment$okio3.limit = i18 + 4;
                            setSize$okio(size() + 4);
                            i9 += 2;
                        } else {
                            writeByte(63);
                            i9 = i16;
                        }
                    } else {
                        Segment segmentWritableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i19 = segmentWritableSegment$okio4.limit;
                        bArr4[i19] = (byte) ((cCharAt2 >> '\f') | 224);
                        bArr4[i19 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                        bArr4[i19 + 2] = (byte) ((cCharAt2 & '?') | 128);
                        segmentWritableSegment$okio4.limit = i19 + 3;
                        setSize$okio(size() + 3);
                    }
                    i9++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(e.h(i10, i9, "endIndex < beginIndex: ", " < ").toString());
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        k.e(sink, "sink");
        int i9 = 0;
        while (i9 < sink.length) {
            int i10 = read(sink, i9, sink.length - i9);
            if (i10 == -1) {
                throw new EOFException();
            }
            i9 += i10;
        }
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, int i9, int i10, Charset charset) {
        k.e(string, "string");
        k.e(charset, "charset");
        if (i9 < 0) {
            throw new IllegalArgumentException(e.i(i9, "beginIndex < 0: ").toString());
        }
        if (i10 >= i9) {
            if (i10 <= string.length()) {
                if (charset.equals(R7.a.f4067b)) {
                    return writeUtf8(string, i9, i10);
                }
                String strSubstring = string.substring(i9, i10);
                k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                byte[] bytes = strSubstring.getBytes(charset);
                k.d(bytes, "this as java.lang.String).getBytes(charset)");
                return write(bytes, 0, bytes.length);
            }
            StringBuilder sbA = C0524s.a(i10, "endIndex > string.length: ", " > ");
            sbA.append(string.length());
            throw new IllegalArgumentException(sbA.toString().toString());
        }
        throw new IllegalArgumentException(e.h(i10, i9, "endIndex < beginIndex: ", " < ").toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        k.e(source, "source");
        int iRemaining = source.remaining();
        int i9 = iRemaining;
        while (i9 > 0) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i9, 8192 - segmentWritableSegment$okio.limit);
            source.get(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            i9 -= iMin;
            segmentWritableSegment$okio.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink) {
        k.e(sink, "sink");
        return read(sink, 0, sink.length);
    }

    private final void readFrom(InputStream inputStream, long j, boolean z8) throws IOException {
        while (true) {
            if (j <= 0 && !z8) {
                return;
            }
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int i9 = inputStream.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit));
            if (i9 == -1) {
                if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                    this.head = segmentWritableSegment$okio.pop();
                    SegmentPool.recycle(segmentWritableSegment$okio);
                }
                if (!z8) {
                    throw new EOFException();
                }
                return;
            }
            segmentWritableSegment$okio.limit += i9;
            long j8 = i9;
            this.size += j8;
            j -= j8;
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink, int i9, int i10) {
        k.e(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, i9, i10);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i10, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i11 = segment.pos;
        y7.f.c(bArr, i9, sink, i11, i11 + iMin);
        segment.pos += iMin;
        setSize$okio(size() - ((long) iMin));
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public final Buffer copyTo(Buffer out, long j) {
        k.e(out, "out");
        return copyTo(out, j, this.size - j);
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        k.e(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    public final Buffer copyTo(Buffer out, long j, long j8) {
        k.e(out, "out");
        long j9 = j;
        SegmentedByteString.checkOffsetAndCount(size(), j9, j8);
        if (j8 != 0) {
            out.setSize$okio(out.size() + j8);
            Segment segment = this.head;
            while (true) {
                k.b(segment);
                int i9 = segment.limit;
                int i10 = segment.pos;
                if (j9 < i9 - i10) {
                    break;
                }
                j9 -= (long) (i9 - i10);
                segment = segment.next;
            }
            Segment segment2 = segment;
            long j10 = j8;
            while (j10 > 0) {
                k.b(segment2);
                Segment segmentSharedCopy = segment2.sharedCopy();
                int i11 = segmentSharedCopy.pos + ((int) j9);
                segmentSharedCopy.pos = i11;
                segmentSharedCopy.limit = Math.min(i11 + ((int) j10), segmentSharedCopy.limit);
                Segment segment3 = out.head;
                if (segment3 == null) {
                    segmentSharedCopy.prev = segmentSharedCopy;
                    segmentSharedCopy.next = segmentSharedCopy;
                    out.head = segmentSharedCopy;
                } else {
                    k.b(segment3);
                    Segment segment4 = segment3.prev;
                    k.b(segment4);
                    segment4.push(segmentSharedCopy);
                }
                j10 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
                segment2 = segment2.next;
                j9 = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString, int i9, int i10) {
        k.e(byteString, "byteString");
        byteString.write$okio(this, i9, i10);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source) {
        k.e(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source, int i9, int i10) {
        k.e(source, "source");
        long j = i10;
        SegmentedByteString.checkOffsetAndCount(source.length, i9, j);
        int i11 = i10 + i9;
        while (i9 < i11) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i11 - i9, 8192 - segmentWritableSegment$okio.limit);
            int i12 = i9 + iMin;
            y7.f.c(source, segmentWritableSegment$okio.limit, segmentWritableSegment$okio.data, i9, i12);
            segmentWritableSegment$okio.limit += iMin;
            i9 = i12;
        }
        setSize$okio(size() + j);
        return this;
    }

    @Override // okio.Source
    public long read(Buffer sink, long j) {
        k.e(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(f.d(j, "byteCount < 0: ").toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j > size()) {
            j = size();
        }
        sink.write(this, j);
        return j;
    }

    @Override // okio.BufferedSink
    public Buffer write(Source source, long j) throws EOFException {
        k.e(source, "source");
        while (j > 0) {
            long j8 = source.read(this, j);
            if (j8 == -1) {
                throw new EOFException();
            }
            j -= j8;
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes, long j) {
        int i9;
        long j8 = j;
        k.e(bytes, "bytes");
        if (bytes.size() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long size = 0;
        if (j8 >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1L;
            }
            if (size() - j8 < j8) {
                size = size();
                while (size > j8) {
                    segment = segment.prev;
                    k.b(segment);
                    size -= (long) (segment.limit - segment.pos);
                }
                byte[] bArrInternalArray$okio = bytes.internalArray$okio();
                byte b9 = bArrInternalArray$okio[0];
                int size2 = bytes.size();
                long size3 = (size() - ((long) size2)) + 1;
                while (size < size3) {
                    byte[] bArr = segment.data;
                    long j9 = size3;
                    int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + size3) - size);
                    i9 = (int) ((((long) segment.pos) + j8) - size);
                    while (i9 < iMin) {
                        if (bArr[i9] != b9 || !okio.internal.Buffer.rangeEquals(segment, i9 + 1, bArrInternalArray$okio, 1, size2)) {
                            i9++;
                        }
                    }
                    size += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    k.b(segment);
                    j8 = size;
                    size3 = j9;
                }
                return -1L;
            }
            while (true) {
                long j10 = ((long) (segment.limit - segment.pos)) + size;
                if (j10 > j8) {
                    break;
                }
                segment = segment.next;
                k.b(segment);
                size = j10;
            }
            byte[] bArrInternalArray$okio2 = bytes.internalArray$okio();
            byte b10 = bArrInternalArray$okio2[0];
            int size4 = bytes.size();
            long size5 = (size() - ((long) size4)) + 1;
            while (size < size5) {
                byte[] bArr2 = segment.data;
                int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + size5) - size);
                i9 = (int) ((((long) segment.pos) + j8) - size);
                while (i9 < iMin2) {
                    if (bArr2[i9] == b10 && okio.internal.Buffer.rangeEquals(segment, i9 + 1, bArrInternalArray$okio2, 1, size4)) {
                    }
                    i9++;
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                k.b(segment);
                j8 = size;
            }
            return -1L;
            return ((long) (i9 - segment.pos)) + size;
        }
        throw new IllegalArgumentException(f.d(j8, "fromIndex < 0: ").toString());
    }

    @Override // okio.Sink
    public void write(Buffer source, long j) {
        Segment segment;
        k.e(source, "source");
        if (source != this) {
            SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
            while (j > 0) {
                Segment segment2 = source.head;
                k.b(segment2);
                int i9 = segment2.limit;
                Segment segment3 = source.head;
                k.b(segment3);
                if (j < i9 - segment3.pos) {
                    Segment segment4 = this.head;
                    if (segment4 != null) {
                        k.b(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= 8192) {
                            Segment segment5 = source.head;
                            k.b(segment5);
                            segment5.writeTo(segment, (int) j);
                            source.setSize$okio(source.size() - j);
                            setSize$okio(size() + j);
                            return;
                        }
                    }
                    Segment segment6 = source.head;
                    k.b(segment6);
                    source.head = segment6.split((int) j);
                }
                Segment segment7 = source.head;
                k.b(segment7);
                long j8 = segment7.limit - segment7.pos;
                source.head = segment7.pop();
                Segment segment8 = this.head;
                if (segment8 == null) {
                    this.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    k.b(segment8);
                    Segment segment9 = segment8.prev;
                    k.b(segment9);
                    segment9.push(segment7).compact();
                }
                source.setSize$okio(source.size() - j8);
                setSize$okio(size() + j8);
                j -= j8;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this;
    }
}
