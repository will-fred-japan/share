package p146s6;

import W5.e;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.starburst.sdk.core.tts.EventType;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: WaveContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f implements c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f21294g = {82, 73, 70, 70};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f21295h = {87, 65, 86, 69};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f21296i = {102, 109, 116, 32};
    public static final byte[] j = {EventType.ERROR, 97, 116, 97};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RandomAccessFile f21298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21302f;

    public f(String path, int i9) {
        k.e(path, "path");
        this.f21297a = i9;
        this.f21298b = c.a.a(path);
        this.f21300d = -1;
    }

    public static byte[] f(long j8) {
        return new byte[]{(byte) (j8 & 255), (byte) ((j8 >> 8) & 255), (byte) ((j8 >> 16) & 255), (byte) ((j8 >> 24) & 255)};
    }

    @Override // p146s6.c
    public final boolean a() {
        return false;
    }

    @Override // p146s6.c
    public final int b(MediaFormat mediaFormat) {
        k.e(mediaFormat, "mediaFormat");
        if (this.f21299c) {
            throw new IllegalStateException("Container already started");
        }
        if (this.f21300d >= 0) {
            throw new IllegalStateException("Track already added");
        }
        this.f21300d = 0;
        this.f21301e = mediaFormat.getInteger("channel-count");
        this.f21302f = mediaFormat.getInteger("sample-rate");
        return this.f21300d;
    }

    @Override // p146s6.c
    public final byte[] c(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        c.a.b(byteBuffer, bufferInfo);
        throw null;
    }

    @Override // p146s6.c
    public final boolean d() {
        return false;
    }

    @Override // p146s6.c
    public final void e(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws ErrnoException, InterruptedIOException {
        k.e(bufferInfo, "bufferInfo");
        if (!this.f21299c) {
            throw new IllegalStateException("Container not started");
        }
        int i10 = this.f21300d;
        if (i10 < 0) {
            throw new IllegalStateException("No track has been added");
        }
        if (i10 != i9) {
            throw new IllegalStateException(e.i(i9, "Invalid track: "));
        }
        Os.write(this.f21298b.getFD(), byteBuffer);
    }

    @Override // p146s6.c
    public final void release() throws IOException, ErrnoException {
        if (this.f21299c) {
            stop();
        }
    }

    @Override // p146s6.c
    public final void start() throws ErrnoException {
        if (this.f21299c) {
            throw new IllegalStateException("Container already started");
        }
        RandomAccessFile randomAccessFile = this.f21298b;
        Os.ftruncate(randomAccessFile.getFD(), 0L);
        Os.lseek(randomAccessFile.getFD(), 44L, OsConstants.SEEK_SET);
        this.f21299c = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p146s6.c
    public final void stop() throws IOException, ErrnoException {
        p188x7.e eVar;
        if (!this.f21299c) {
            throw new IllegalStateException("Container not started");
        }
        this.f21299c = false;
        int i9 = this.f21300d;
        RandomAccessFile randomAccessFile = this.f21298b;
        if (i9 >= 0) {
            long jLseek = Os.lseek(randomAccessFile.getFD(), 0L, OsConstants.SEEK_CUR);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(44);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            if (jLseek > 4294967251L) {
                Log.w("f", "File is oversized! WAV files can only fit in 4GB max.");
                eVar = new p188x7.e(4294967287L, 4294967251L);
            } else {
                eVar = new p188x7.e(Long.valueOf(jLseek - ((long) 8)), Long.valueOf(jLseek - ((long) 44)));
            }
            long jLongValue = ((Number) eVar.f22353a).longValue();
            long jLongValue2 = ((Number) eVar.f22354b).longValue();
            byteBufferAllocate.put(f21294g);
            byteBufferAllocate.put(f(jLongValue));
            byteBufferAllocate.put(f21295h);
            byteBufferAllocate.put(f21296i);
            byteBufferAllocate.putInt(16);
            byteBufferAllocate.putShort((short) 1);
            byteBufferAllocate.putShort((short) this.f21301e);
            byteBufferAllocate.putInt(this.f21302f);
            int i10 = this.f21302f;
            int i11 = this.f21297a;
            byteBufferAllocate.putInt(i10 * i11);
            byteBufferAllocate.putShort((short) i11);
            byteBufferAllocate.putShort((short) ((i11 / this.f21301e) * 8));
            byteBufferAllocate.put(j);
            byteBufferAllocate.put(f(jLongValue2));
            byteBufferAllocate.flip();
            Os.lseek(randomAccessFile.getFD(), 0L, OsConstants.SEEK_SET);
            Os.write(randomAccessFile.getFD(), byteBufferAllocate);
        }
        randomAccessFile.close();
    }
}
