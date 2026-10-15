package cn.jiguang.ag;

import cn.jiguang.api.JCoreManager;
import cn.jiguang.x.f;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f9131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ByteBuffer f9132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f9133i;
    private String j;

    public e(c cVar, ByteBuffer byteBuffer) {
        this.f9131g = cVar;
        if (byteBuffer == null) {
            f.i("RegisterResponse", "No body to parse.");
        } else {
            this.f9132h = byteBuffer;
            a();
        }
    }

    private void a() {
        try {
            this.f9125a = this.f9132h.getShort();
        } catch (Throwable unused) {
            this.f9125a = 10000;
        }
        if (this.f9125a > 0) {
            f.l("RegisterResponse", "Response error - code:" + this.f9125a);
        }
        ByteBuffer byteBuffer = this.f9132h;
        int i9 = this.f9125a;
        try {
            if (i9 == 0) {
                this.f9126b = byteBuffer.getLong();
                this.f9127c = b.a(byteBuffer);
                this.f9128d = b.a(byteBuffer);
                if (byteBuffer.remaining() >= 4) {
                    this.f9130f = byteBuffer.getInt();
                }
            } else {
                if (i9 != 1007) {
                    if (i9 == 1012) {
                        try {
                            this.j = b.a(byteBuffer);
                        } catch (Throwable unused2) {
                            this.f9125a = 10000;
                        }
                        cn.jiguang.ab.a.a(JCoreManager.getAppContext(null), this.j);
                        return;
                    }
                    return;
                }
                this.f9133i = b.a(byteBuffer);
            }
        } catch (Throwable unused3) {
            this.f9125a = 10000;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[RegisterResponse] - code:");
        sb.append(this.f9125a);
        sb.append(", juid:");
        sb.append(this.f9126b);
        sb.append(", hasPassword:");
        sb.append(!a(this.f9127c));
        sb.append(", regId:");
        sb.append(this.f9128d);
        sb.append(", hasDeviceId:");
        sb.append(!a(this.f9129e));
        sb.append(", ridAssignCode:");
        sb.append(this.f9130f);
        sb.append(", connectInfo:");
        sb.append(this.j);
        return sb.toString();
    }

    private boolean a(String str) {
        return str == null || str.length() == 0;
    }
}
