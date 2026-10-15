package p165v1;

import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: CountingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final J6.a f21877f = p191y1.a.f22366a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f21878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f21879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f21880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ByteBuffer f21881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f21882e;

    public a(InputStream inputStream) {
        this.f21879b = 0L;
        this.f21880c = new e();
        this.f21882e = false;
        this.f21878a = inputStream;
        this.f21881d = null;
    }

    public final int a(byte[] bArr, int i9, int i10) {
        ByteBuffer byteBuffer = this.f21881d;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int iRemaining = byteBuffer.remaining();
        byteBuffer.get(bArr, i9, i10);
        return iRemaining - byteBuffer.remaining();
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        try {
            return (this.f21882e ? this.f21881d.remaining() : 0) + this.f21878a.available();
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    public final void b(IOException iOException) {
        e eVar = this.f21880c;
        if (eVar.d()) {
            return;
        }
        eVar.c(new c(this, this.f21879b, iOException));
    }

    public final boolean c(long j) {
        return ((long) this.f21881d.remaining()) >= j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            this.f21878a.close();
            d();
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    public final void d() {
        e eVar = this.f21880c;
        if (eVar.d()) {
            return;
        }
        eVar.a(new c(this, this.f21879b, null));
    }

    @Override // java.io.InputStream
    public final void mark(int i9) {
        InputStream inputStream = this.f21878a;
        if (inputStream.markSupported()) {
            inputStream.mark(i9);
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f21878a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f21882e) {
            synchronized (this.f21881d) {
                try {
                    if (c(1L)) {
                        byte b9 = !this.f21881d.hasRemaining() ? (byte) -1 : this.f21881d.get();
                        if (b9 >= 0) {
                            this.f21879b++;
                        }
                        return b9;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        try {
            int i9 = this.f21878a.read();
            if (i9 >= 0) {
                this.f21879b++;
                return i9;
            }
            d();
            return i9;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        InputStream inputStream = this.f21878a;
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
            } catch (IOException e9) {
                b(e9);
                throw e9;
            }
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        if (this.f21882e) {
            synchronized (this.f21881d) {
                try {
                    if (c(j)) {
                        this.f21881d.position((int) j);
                        this.f21879b += j;
                        return j;
                    }
                    j -= (long) this.f21881d.remaining();
                    if (j <= 0) {
                        throw new IOException("partial read from buffer (skip) failed");
                    }
                    ByteBuffer byteBuffer = this.f21881d;
                    byteBuffer.position(byteBuffer.remaining());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        try {
            long jSkip = this.f21878a.skip(j);
            this.f21879b += jSkip;
            return jSkip;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }

    public a(InputStream inputStream, int i9) {
        int i10;
        this.f21879b = 0L;
        this.f21880c = new e();
        this.f21878a = inputStream;
        this.f21882e = true;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(OpusCodecConfig.APPLICATION_VOIP);
        this.f21881d = byteBufferAllocate;
        if (byteBufferAllocate == null || !byteBufferAllocate.hasArray()) {
            return;
        }
        synchronized (byteBufferAllocate) {
            try {
                i10 = inputStream.read(byteBufferAllocate.array(), 0, byteBufferAllocate.capacity());
            } catch (IOException e9) {
                J6.a aVar = f21877f;
                e9.toString();
                aVar.d();
                i10 = 0;
            }
            if (i10 <= 0) {
                this.f21881d.limit(0);
            } else if (i10 < this.f21881d.capacity()) {
                this.f21881d.limit(i10);
            }
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int length = bArr.length;
        int iA = 0;
        if (this.f21882e) {
            synchronized (this.f21881d) {
                try {
                    if (c(length)) {
                        int iA2 = a(bArr, 0, bArr.length);
                        if (iA2 >= 0) {
                            this.f21879b += (long) iA2;
                            return iA2;
                        }
                        throw new IOException("readBufferBytes failed");
                    }
                    int iRemaining = this.f21881d.remaining();
                    if (iRemaining > 0) {
                        iA = a(bArr, 0, iRemaining);
                        if (iA >= 0) {
                            length -= iA;
                            this.f21879b += (long) iA;
                        } else {
                            throw new IOException("partial read from buffer failed");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        try {
            int i9 = this.f21878a.read(bArr, iA, length);
            if (i9 >= 0) {
                this.f21879b += (long) i9;
                return i9 + iA;
            }
            if (iA > 0) {
                return iA;
            }
            d();
            return i9;
        } catch (IOException e9) {
            J6.a aVar = f21877f;
            e9.toString();
            aVar.d();
            System.out.println("NOTIFY STREAM ERROR: " + e9);
            e9.printStackTrace();
            b(e9);
            throw e9;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i9, int i10) throws IOException {
        int iA = 0;
        if (this.f21882e) {
            synchronized (this.f21881d) {
                try {
                    if (c(i10)) {
                        int iA2 = a(bArr, i9, i10);
                        if (iA2 >= 0) {
                            this.f21879b += (long) iA2;
                            return iA2;
                        }
                        throw new IOException("readBufferBytes failed");
                    }
                    int iRemaining = this.f21881d.remaining();
                    if (iRemaining > 0) {
                        iA = a(bArr, i9, iRemaining);
                        if (iA >= 0) {
                            i10 -= iA;
                            this.f21879b += (long) iA;
                        } else {
                            throw new IOException("partial read from buffer failed");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        try {
            int i11 = this.f21878a.read(bArr, i9 + iA, i10);
            if (i11 >= 0) {
                this.f21879b += (long) i11;
                return i11 + iA;
            }
            if (iA > 0) {
                return iA;
            }
            d();
            return i11;
        } catch (IOException e9) {
            b(e9);
            throw e9;
        }
    }
}
