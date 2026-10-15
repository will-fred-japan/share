package p165v1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: CountingOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f21883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f21884b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f21885c = new e();

    public b(OutputStream outputStream) {
        this.f21883a = outputStream;
    }

    public final void a(IOException iOException) {
        e eVar = this.f21885c;
        if (eVar.d()) {
            return;
        }
        eVar.c(new c(this, this.f21884b, iOException));
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        e eVar = this.f21885c;
        try {
            this.f21883a.close();
            if (eVar.d()) {
                return;
            }
            eVar.a(new c(this, this.f21884b, null));
        } catch (IOException e9) {
            a(e9);
            throw e9;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        try {
            this.f21883a.flush();
        } catch (IOException e9) {
            a(e9);
            throw e9;
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i9) throws IOException {
        try {
            this.f21883a.write(i9);
            this.f21884b++;
        } catch (IOException e9) {
            a(e9);
            throw e9;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        try {
            this.f21883a.write(bArr);
            this.f21884b += (long) bArr.length;
        } catch (IOException e9) {
            a(e9);
            throw e9;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i9, int i10) throws IOException {
        try {
            this.f21883a.write(bArr, i9, i10);
            this.f21884b += (long) i10;
        } catch (IOException e9) {
            a(e9);
            throw e9;
        }
    }
}
