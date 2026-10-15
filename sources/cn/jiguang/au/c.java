package cn.jiguang.au;

import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f9452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f9453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Long f9454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f9455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f9456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9457g;

    public c(boolean z8, int i9, int i10, int i11, long j, int i12, long j8) {
        this.f9457g = z8;
        this.f9451a = i9;
        this.f9452b = i10;
        this.f9453c = i11;
        this.f9454d = Long.valueOf(j);
        this.f9455e = i12;
        this.f9456f = j8;
    }

    public int a() {
        return this.f9453c;
    }

    public Long b() {
        return this.f9454d;
    }

    public long c() {
        return this.f9456f;
    }

    public int d() {
        return this.f9455e;
    }

    public int e() {
        return this.f9452b;
    }

    public byte[] f() {
        if (this.f9451a == 0) {
            throw new IllegalStateException("The head is not initialized yet.");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.putShort((short) this.f9451a);
        byteBufferAllocate.put((byte) this.f9452b);
        byteBufferAllocate.put((byte) this.f9453c);
        byteBufferAllocate.putLong(this.f9454d.longValue());
        if (this.f9457g) {
            byteBufferAllocate.putInt(this.f9455e);
        }
        byteBufferAllocate.putLong(this.f9456f);
        byteBufferAllocate.flip();
        return ProtocolUtil.getBytesConsumed(byteBufferAllocate);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[JHead] - len:");
        sb.append(this.f9451a);
        sb.append(", version:");
        sb.append(this.f9452b);
        sb.append(", command:");
        sb.append(this.f9453c);
        sb.append(", rid:");
        sb.append(this.f9454d);
        if (this.f9457g) {
            str = ", sid:" + this.f9455e;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f9456f);
        return sb.toString();
    }

    public c(boolean z8, int i9, int i10, long j) {
        this(z8, 0, i9, i10, j, 0, 0L);
    }

    public void a(int i9) {
        this.f9451a = i9;
    }

    public void b(int i9) {
        this.f9455e = i9;
    }

    public c(boolean z8, byte[] bArr) {
        this.f9457g = z8;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f9451a = byteBufferWrap.getShort() & Short.MAX_VALUE;
        this.f9452b = byteBufferWrap.get();
        this.f9453c = byteBufferWrap.get();
        Long lValueOf = Long.valueOf(byteBufferWrap.getLong());
        this.f9454d = lValueOf;
        this.f9454d = Long.valueOf(lValueOf.longValue() & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        if (z8) {
            this.f9455e = byteBufferWrap.getInt();
        }
        this.f9456f = byteBufferWrap.getLong();
    }

    public void a(long j) {
        this.f9456f = j;
    }
}
