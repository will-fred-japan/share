package p127q4;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class q extends GZIPOutputStream {
    public final void a() throws IOException {
        super.close();
    }

    public final void b() throws IOException {
        super.finish();
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
    public final void finish() {
    }
}
