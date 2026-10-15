package Z;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: UncloseableOutputStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileOutputStream f5406a;

    public j0(FileOutputStream fileOutputStream) {
        this.f5406a = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f5406a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i9) throws IOException {
        this.f5406a.write(i9);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] b9) throws IOException {
        kotlin.jvm.internal.k.e(b9, "b");
        this.f5406a.write(b9);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bytes, int i9, int i10) throws IOException {
        kotlin.jvm.internal.k.e(bytes, "bytes");
        this.f5406a.write(bytes, i9, i10);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
