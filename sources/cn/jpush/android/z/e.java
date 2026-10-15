package cn.jpush.android.z;

import W5.f;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class e extends JPushResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f11808c;

    public e(int i9, long j, long j8, ByteBuffer byteBuffer) {
        super(i9, j, j8, byteBuffer);
        parseBody();
    }

    public String a() {
        return this.f11808c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            int i9 = this.cmd;
            if (i9 == 10 || i9 == 38 || i9 == 40) {
                this.f11806a = this.body.getShort();
            }
            int i10 = this.cmd;
            if (i10 == 40) {
                this.f11807b = this.body.get();
                return;
            }
            if (i10 == 38 || this.f11806a <= 0) {
                byte[] bArr = new byte[this.body.getShort()];
                this.body.get(bArr);
                this.f11808c = new String(bArr, "UTF-8");
            } else {
                Logger.e("TagaliasResponse", "Response error - code:" + this.f11806a);
            }
        } catch (Throwable th) {
            f.q(th, new StringBuilder("parse failed:"), "TagaliasResponse");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[TagaliasResponse] - action:" + this.f11808c + " - " + super.toString();
    }

    public e(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }
}
