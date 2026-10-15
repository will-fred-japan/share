package okio;

import defpackage.f;
import java.io.Closeable;
import java.io.EOFException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: FileHandle.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FileHandle implements Closeable {
    private boolean closed;
    private final ReentrantLock lock = _JvmPlatformKt.newLock();
    private int openStreamCount;
    private final boolean readWrite;

    /* JADX INFO: compiled from: FileHandle.kt */
    public static final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle fileHandle, long j) {
            k.e(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock lock = this.fileHandle.getLock();
            lock.lock();
            try {
                this.fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    p188x7.k kVar = p188x7.k.f22364a;
                    lock.unlock();
                    this.fileHandle.protectedClose();
                    return;
                }
                lock.unlock();
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.fileHandle.protectedFlush();
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setClosed(boolean z8) {
            this.closed = z8;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(Buffer source, long j) {
            k.e(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.fileHandle.writeNoCloseCheck(this.position, source, j);
            this.position += j;
        }
    }

    /* JADX INFO: compiled from: FileHandle.kt */
    public static final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(FileHandle fileHandle, long j) {
            k.e(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock lock = this.fileHandle.getLock();
            lock.lock();
            try {
                this.fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    p188x7.k kVar = p188x7.k.f22364a;
                    lock.unlock();
                    this.fileHandle.protectedClose();
                    return;
                }
                lock.unlock();
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        @Override // okio.Source
        public long read(Buffer sink, long j) {
            k.e(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long noCloseCheck = this.fileHandle.readNoCloseCheck(this.position, sink, j);
            if (noCloseCheck != -1) {
                this.position += noCloseCheck;
            }
            return noCloseCheck;
        }

        public final void setClosed(boolean z8) {
            this.closed = z8;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    public FileHandle(boolean z8) {
        this.readWrite = z8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readNoCloseCheck(long j, Buffer buffer, long j8) {
        if (j8 < 0) {
            throw new IllegalArgumentException(f.d(j8, "byteCount < 0: ").toString());
        }
        long j9 = j8 + j;
        long j10 = j;
        while (j10 < j9) {
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i9 = segmentWritableSegment$okio.limit;
            int iProtectedRead = protectedRead(j10, bArr, i9, (int) Math.min(j9 - j10, 8192 - i9));
            if (iProtectedRead == -1) {
                if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                    buffer.head = segmentWritableSegment$okio.pop();
                    SegmentPool.recycle(segmentWritableSegment$okio);
                }
                if (j != j10) {
                    break;
                }
                return -1L;
            }
            segmentWritableSegment$okio.limit += iProtectedRead;
            long j11 = iProtectedRead;
            j10 += j11;
            buffer.setSize$okio(buffer.size() + j11);
        }
        return j10 - j;
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i9 & 1) != 0) {
            j = 0;
        }
        return fileHandle.sink(j);
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
        }
        if ((i9 & 1) != 0) {
            j = 0;
        }
        return fileHandle.source(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeNoCloseCheck(long j, Buffer buffer, long j8) {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, j8);
        long j9 = j + j8;
        long j10 = j;
        while (j10 < j9) {
            Segment segment = buffer.head;
            k.b(segment);
            int iMin = (int) Math.min(j9 - j10, segment.limit - segment.pos);
            protectedWrite(j10, segment.data, segment.pos, iMin);
            segment.pos += iMin;
            long j11 = iMin;
            j10 += j11;
            buffer.setSize$okio(buffer.size() - j11);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final Sink appendingSink() {
        return sink(size());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                reentrantLock.unlock();
                return;
            }
            this.closed = true;
            if (this.openStreamCount != 0) {
                reentrantLock.unlock();
                return;
            }
            p188x7.k kVar = p188x7.k.f22364a;
            reentrantLock.unlock();
            protectedClose();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void flush() {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            p188x7.k kVar = p188x7.k.f22364a;
            reentrantLock.unlock();
            protectedFlush();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final long position(Source source) {
        long size;
        k.e(source, "source");
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            size = realBufferedSource.bufferField.size();
            source = realBufferedSource.source;
        } else {
            size = 0;
        }
        if (!(source instanceof FileHandleSource) || ((FileHandleSource) source).getFileHandle() != this) {
            throw new IllegalArgumentException("source was not created by this FileHandle");
        }
        FileHandleSource fileHandleSource = (FileHandleSource) source;
        if (fileHandleSource.getClosed()) {
            throw new IllegalStateException("closed");
        }
        return fileHandleSource.getPosition() - size;
    }

    public abstract void protectedClose();

    public abstract void protectedFlush();

    public abstract int protectedRead(long j, byte[] bArr, int i9, int i10);

    public abstract void protectedResize(long j);

    public abstract long protectedSize();

    public abstract void protectedWrite(long j, byte[] bArr, int i9, int i10);

    public final int read(long j, byte[] array, int i9, int i10) {
        k.e(array, "array");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            p188x7.k kVar = p188x7.k.f22364a;
            reentrantLock.unlock();
            return protectedRead(j, array, i9, i10);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void reposition(Source source, long j) throws EOFException {
        k.e(source, "source");
        if (!(source instanceof RealBufferedSource)) {
            if (!(source instanceof FileHandleSource) || ((FileHandleSource) source).getFileHandle() != this) {
                throw new IllegalArgumentException("source was not created by this FileHandle");
            }
            FileHandleSource fileHandleSource = (FileHandleSource) source;
            if (fileHandleSource.getClosed()) {
                throw new IllegalStateException("closed");
            }
            fileHandleSource.setPosition(j);
            return;
        }
        RealBufferedSource realBufferedSource = (RealBufferedSource) source;
        Source source2 = realBufferedSource.source;
        if (!(source2 instanceof FileHandleSource) || ((FileHandleSource) source2).getFileHandle() != this) {
            throw new IllegalArgumentException("source was not created by this FileHandle");
        }
        FileHandleSource fileHandleSource2 = (FileHandleSource) source2;
        if (fileHandleSource2.getClosed()) {
            throw new IllegalStateException("closed");
        }
        long size = realBufferedSource.bufferField.size();
        long position = j - (fileHandleSource2.getPosition() - size);
        if (0 <= position && position < size) {
            realBufferedSource.skip(position);
        } else {
            realBufferedSource.bufferField.clear();
            fileHandleSource2.setPosition(j);
        }
    }

    public final void resize(long j) {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            p188x7.k kVar = p188x7.k.f22364a;
            reentrantLock.unlock();
            protectedResize(j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final Sink sink(long j) {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSink(this, j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            p188x7.k kVar = p188x7.k.f22364a;
            reentrantLock.unlock();
            return protectedSize();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final Source source(long j) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSource(this, j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void write(long j, byte[] array, int i9, int i10) {
        k.e(array, "array");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            p188x7.k kVar = p188x7.k.f22364a;
            reentrantLock.unlock();
            protectedWrite(j, array, i9, i10);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long read(long j, Buffer sink, long j8) {
        k.e(sink, "sink");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.closed) {
                p188x7.k kVar = p188x7.k.f22364a;
                reentrantLock.unlock();
                return readNoCloseCheck(j, sink, j8);
            }
            throw new IllegalStateException("closed");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long position(Sink sink) {
        long size;
        k.e(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            size = realBufferedSink.bufferField.size();
            sink = realBufferedSink.sink;
        } else {
            size = 0;
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            FileHandleSink fileHandleSink = (FileHandleSink) sink;
            if (!fileHandleSink.getClosed()) {
                return fileHandleSink.getPosition() + size;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle");
    }

    public final void write(long j, Buffer source, long j8) {
        k.e(source, "source");
        if (this.readWrite) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.closed) {
                    p188x7.k kVar = p188x7.k.f22364a;
                    reentrantLock.unlock();
                    writeNoCloseCheck(j, source, j8);
                    return;
                }
                throw new IllegalStateException("closed");
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        throw new IllegalStateException("file handle is read-only");
    }

    public final void reposition(Sink sink, long j) {
        k.e(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            Sink sink2 = realBufferedSink.sink;
            if ((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).getFileHandle() == this) {
                FileHandleSink fileHandleSink = (FileHandleSink) sink2;
                if (!fileHandleSink.getClosed()) {
                    realBufferedSink.emit();
                    fileHandleSink.setPosition(j);
                    return;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("sink was not created by this FileHandle");
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            FileHandleSink fileHandleSink2 = (FileHandleSink) sink;
            if (!fileHandleSink2.getClosed()) {
                fileHandleSink2.setPosition(j);
                return;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle");
    }
}
