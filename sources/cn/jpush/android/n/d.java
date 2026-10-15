package cn.jpush.android.n;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends JPushResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f11456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONArray f11457c;

    public d(int i9, long j, long j8, ByteBuffer byteBuffer) {
        super(i9, j, j8, byteBuffer);
        this.f11455a = -1;
        parseBody();
    }

    public JSONObject a() {
        return this.f11456b;
    }

    public JSONArray b() {
        return this.f11457c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        String str;
        try {
            ByteBuffer byteBuffer = this.body;
            if (byteBuffer == null) {
                str = "geo pull response empty";
            } else {
                short s8 = byteBuffer.getShort();
                this.f11455a = s8;
                if (s8 == 0) {
                    byte[] bArr = new byte[this.body.getShort()];
                    this.body.get(bArr);
                    String str2 = new String(bArr, "UTF-8");
                    Logger.d("GeoPullResponse", "receive content：".concat(str2));
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str2);
                    this.f11457c = jSONObject.getJSONArray("geofence");
                    jSONObject.remove("geofence");
                    this.f11456b = jSONObject;
                    return;
                }
                str = "geo pull response error code :" + this.f11455a;
            }
            Logger.ww("GeoPullResponse", str);
        } catch (Throwable unused) {
            Logger.ww("GeoPullResponse", "parse geo pull response failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[GeoPullResponse] - limit:" + this.f11456b + " - geoArray:" + this.f11457c + " - " + super.toString();
    }

    public d(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }
}
