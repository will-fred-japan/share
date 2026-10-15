package cn.jpush.android.z;

import W5.f;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class a extends JPushResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11798a;

    public a(int i9, long j, long j8, ByteBuffer byteBuffer) {
        super(i9, j, j8, byteBuffer);
        parseBody();
    }

    public int a() {
        return this.f11798a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            this.f11798a = this.body.getShort();
        } catch (Throwable th) {
            f.q(th, new StringBuilder("parse code failed :"), "CommonResponse");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[CommonResponse] - " + this.f11798a;
    }

    public a(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }
}
