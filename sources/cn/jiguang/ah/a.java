package cn.jiguang.ah;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Closeable {
    private static AtomicInteger j = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected SocketChannel f9135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f9136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Selector f9137d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9142i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f9139f = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ByteBuffer f9134a = ByteBuffer.allocate(49152);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected volatile boolean f9138e = false;

    public a() {
        this.f9140g = 0;
        this.f9140g = j.incrementAndGet();
    }

    public int a(String str, int i9) {
        if (this.f9134a == null) {
            this.f9134a = ByteBuffer.allocate(49152);
        }
        this.f9134a.clear();
        this.f9136c = 0;
        this.f9138e = true;
        this.f9141h = str;
        this.f9142i = i9;
        return 0;
    }

    public abstract int a(byte[] bArr);

    public abstract ByteBuffer a(int i9);

    public ByteBuffer b(int i9) {
        int i10 = this.f9136c;
        if (i10 < i9) {
            return null;
        }
        this.f9136c = i10 - i9;
        byte[] bArr = new byte[i9];
        this.f9134a.flip();
        this.f9134a.get(bArr, 0, i9);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f9134a.compact();
        return byteBufferWrap;
    }

    public int c() {
        if (this.f9136c < this.f9139f) {
            return 0;
        }
        int iPosition = this.f9134a.position();
        this.f9134a.position(0);
        int i9 = this.f9134a.getShort() & Short.MAX_VALUE;
        this.f9134a.position(iPosition);
        return i9;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9138e = false;
        ByteBuffer byteBuffer = this.f9134a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f9136c = 0;
    }

    public ByteBuffer a() {
        return a(0);
    }

    public boolean b() {
        SocketChannel socketChannel;
        return this.f9138e && (socketChannel = this.f9135b) != null && socketChannel.isConnected();
    }
}
