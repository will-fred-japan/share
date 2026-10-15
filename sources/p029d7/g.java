package p029d7;

import android.media.MediaDataSource;

/* JADX INFO: compiled from: MediaMetadataReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f18530a;

    public g(byte[] bArr) {
        this.f18530a = bArr;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f18530a.length;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i9, int i10) {
        byte[] bArr2 = this.f18530a;
        if (j >= bArr2.length) {
            return -1;
        }
        if (((long) i10) + j > bArr2.length) {
            i10 = (int) (((long) bArr2.length) - j);
        }
        System.arraycopy(bArr2, (int) j, bArr, i9, i10);
        return i10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
