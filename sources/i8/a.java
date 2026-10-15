package i8;

import android.media.MediaDataSource;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ByteDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f19318a;

    public a(byte[] bArr) {
        this.f19318a = bArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
    }

    @Override // android.media.MediaDataSource
    public final synchronized long getSize() {
        return this.f19318a.length;
    }

    @Override // android.media.MediaDataSource
    public final synchronized int readAt(long j, byte[] buffer, int i9, int i10) {
        k.e(buffer, "buffer");
        byte[] bArr = this.f19318a;
        if (j >= bArr.length) {
            return -1;
        }
        long length = i10;
        long j8 = j + length;
        if (j8 > bArr.length) {
            length -= j8 - ((long) bArr.length);
        }
        int i11 = (int) length;
        System.arraycopy(bArr, (int) j, buffer, i9, i11);
        return i11;
    }
}
