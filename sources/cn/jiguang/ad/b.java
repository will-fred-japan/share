package cn.jiguang.ad;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteBuffer f8953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8954b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8955c = -1;

    public b(byte[] bArr) {
        this.f8953a = ByteBuffer.wrap(bArr);
    }

    public int a() {
        return this.f8953a.position();
    }

    public int b() {
        return this.f8953a.remaining();
    }

    public void c() {
        ByteBuffer byteBuffer = this.f8953a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void d() {
        this.f8954b = this.f8953a.position();
        this.f8955c = this.f8953a.limit();
    }

    public void e() {
        int i9 = this.f8954b;
        if (i9 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.f8953a.position(i9);
        this.f8953a.limit(this.f8955c);
        this.f8954b = -1;
        this.f8955c = -1;
    }

    public int f() throws IOException {
        c(1);
        return this.f8953a.get() & 255;
    }

    public int g() throws IOException {
        c(2);
        return this.f8953a.getShort() & 65535;
    }

    public long h() throws IOException {
        c(4);
        return ((long) this.f8953a.getInt()) & 4294967295L;
    }

    private void c(int i9) throws IOException {
        if (i9 > b()) {
            throw new IOException("end of input");
        }
    }

    public void a(int i9) {
        if (i9 > this.f8953a.capacity() - this.f8953a.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.f8953a;
        byteBuffer.limit(byteBuffer.position() + i9);
    }

    public void b(int i9) {
        if (i9 >= this.f8953a.capacity()) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.f8953a.position(i9);
        ByteBuffer byteBuffer = this.f8953a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void a(byte[] bArr, int i9, int i10) throws IOException {
        c(i10);
        this.f8953a.get(bArr, i9, i10);
    }
}
