package cn.jpush.android.n;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class b extends JPushResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11453a;

    public b(int i9, long j, long j8, ByteBuffer byteBuffer) {
        super(i9, j, j8, byteBuffer);
        this.f11453a = 0;
        parseBody();
    }

    public int a() {
        return this.f11453a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            ByteBuffer byteBuffer = this.body;
            if (byteBuffer != null) {
                this.f11453a = byteBuffer.get();
                Logger.ww("GeoControl", "control type:" + this.f11453a);
            }
        } catch (Throwable unused) {
            Logger.ww("GeoControl", "parse geoContorl failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[GeoControl] - type:" + this.f11453a + " - " + super.toString();
    }

    public b(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }
}
