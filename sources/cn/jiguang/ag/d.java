package cn.jiguang.ag;

import cn.jiguang.api.JCoreManager;
import cn.jiguang.x.f;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f9120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteBuffer f9121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f9123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f9124i;

    public d(c cVar, ByteBuffer byteBuffer) {
        this.f9120e = cVar;
        if (byteBuffer == null) {
            f.i("LoginResponse", "No body to parse.");
        } else {
            this.f9121f = byteBuffer;
            a();
        }
    }

    private void a() {
        try {
            this.f9116a = this.f9121f.getShort();
        } catch (Throwable unused) {
            this.f9116a = 10000;
        }
        if (this.f9116a > 0) {
            f.l("LoginResponse", "Response error - code:" + this.f9116a);
        }
        ByteBuffer byteBuffer = this.f9121f;
        this.f9119d = -1;
        int i9 = this.f9116a;
        if (i9 != 0) {
            if (i9 == 1012) {
                try {
                    this.f9124i = b.a(byteBuffer);
                } catch (Throwable unused2) {
                    this.f9116a = 10000;
                }
                cn.jiguang.ab.a.a(JCoreManager.getAppContext(null), this.f9124i);
                return;
            }
            return;
        }
        try {
            this.f9117b = byteBuffer.getInt();
            this.f9122g = byteBuffer.getShort();
            this.f9123h = b.a(byteBuffer);
            this.f9118c = byteBuffer.getInt();
        } catch (Throwable unused3) {
            this.f9116a = 10000;
        }
        try {
            this.f9119d = byteBuffer.get();
            f.c("LoginResponse", "idc parse success, value:" + this.f9119d);
        } catch (Throwable th) {
            defpackage.f.l("parse idc failed, error:", "LoginResponse", th);
        }
    }

    public String toString() {
        return "[LoginResponse] - code:" + this.f9116a + ",sid:" + this.f9117b + ", serverVersion:" + this.f9122g + ", sessionKey:" + this.f9123h + ", serverTime:" + this.f9118c + ", idc:" + this.f9119d + ", connectInfo:" + this.f9124i;
    }
}
