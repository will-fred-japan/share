package p146s6;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.system.ErrnoException;
import android.system.Os;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: RawContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RandomAccessFile f21291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21293d = -1;

    public e(String str) {
        this.f21290a = str;
        if (str != null) {
            this.f21291b = c.a.a(str);
        }
    }

    @Override // p146s6.c
    public final boolean a() {
        return this.f21290a == null;
    }

    @Override // p146s6.c
    public final int b(MediaFormat mediaFormat) {
        k.e(mediaFormat, "mediaFormat");
        if (this.f21292c) {
            throw new IllegalStateException("Container already started");
        }
        if (this.f21293d >= 0) {
            throw new IllegalStateException("Track already added");
        }
        this.f21293d = 0;
        return 0;
    }

    @Override // p146s6.c
    public final byte[] c(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        k.e(bufferInfo, "bufferInfo");
        int i10 = bufferInfo.size;
        byte[] bArr = new byte[i10];
        byteBuffer.get(bArr, bufferInfo.offset, i10);
        return bArr;
    }

    @Override // p146s6.c
    public final boolean d() {
        return false;
    }

    @Override // p146s6.c
    public final void e(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws ErrnoException, InterruptedIOException {
        k.e(bufferInfo, "bufferInfo");
        if (!this.f21292c) {
            throw new IllegalStateException("Container not started");
        }
        int i10 = this.f21293d;
        if (i10 < 0) {
            throw new IllegalStateException("No track has been added");
        }
        if (i10 != i9) {
            throw new IllegalStateException(W5.e.i(i9, "Invalid track: "));
        }
        RandomAccessFile randomAccessFile = this.f21291b;
        if (randomAccessFile != null) {
            Os.write(randomAccessFile.getFD(), byteBuffer);
        }
    }

    @Override // p146s6.c
    public final void release() throws IOException {
        if (this.f21292c) {
            stop();
        }
    }

    @Override // p146s6.c
    public final void start() {
        if (this.f21292c) {
            throw new IllegalStateException("Container already started");
        }
        this.f21292c = true;
    }

    @Override // p146s6.c
    public final void stop() throws IOException {
        if (!this.f21292c) {
            throw new IllegalStateException("Container not started");
        }
        this.f21292c = false;
        RandomAccessFile randomAccessFile = this.f21291b;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }
}
