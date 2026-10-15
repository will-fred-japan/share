package cn.jiguang.ag;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f9111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9115h;

    public c(boolean z8, byte[] bArr) {
        try {
            this.f9115h = z8;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.f9108a = byteBufferWrap.getShort() & Short.MAX_VALUE;
            this.f9109b = byteBufferWrap.get();
            this.f9110c = byteBufferWrap.get();
            this.f9111d = byteBufferWrap.get();
            byteBufferWrap.get();
            byteBufferWrap.getInt();
            this.f9112e = byteBufferWrap.getShort();
            if (z8) {
                this.f9113f = byteBufferWrap.getInt();
            }
            this.f9114g = byteBufferWrap.getLong();
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[JHead] - len:");
        sb.append(this.f9108a);
        sb.append(", version:");
        sb.append(this.f9109b);
        sb.append(", command:");
        sb.append(this.f9110c);
        sb.append(", rid:");
        sb.append(this.f9112e);
        if (this.f9115h) {
            str = ", sid:" + this.f9113f;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f9114g);
        return sb.toString();
    }
}
