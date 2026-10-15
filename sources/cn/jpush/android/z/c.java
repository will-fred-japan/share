package cn.jpush.android.z;

import W5.f;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class c extends JPushResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f11800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f11801c;

    public c(int i9, long j, long j8, ByteBuffer byteBuffer) {
        super(i9, j, j8, byteBuffer);
        parseBody();
    }

    public int a() {
        return this.f11799a;
    }

    public long b() {
        return this.f11800b;
    }

    public String c() {
        return this.f11801c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.body.array());
            this.f11799a = byteBufferWrap.get();
            this.f11800b = byteBufferWrap.getLong();
            byte[] bArr = new byte[byteBufferWrap.getShort()];
            byteBufferWrap.get(bArr);
            this.f11801c = new String(bArr, "UTF-8");
        } catch (Throwable th) {
            f.q(th, new StringBuilder("parse msg content failed, e: "), "MessagePush");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[MessagePush] - msgType:" + this.f11799a + ", msgId:" + this.f11800b + ", msgContent:" + this.f11801c + " - " + super.toString();
    }

    public c(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }
}
