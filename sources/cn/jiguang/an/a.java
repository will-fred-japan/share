package cn.jiguang.an;

import android.content.Context;
import cn.jiguang.d.b;
import cn.jiguang.x.f;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f9350b = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9351a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9352c = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9353d;

    public a(Context context, String str) {
        this.f9351a = str;
        this.f9353d = context == null ? System.currentTimeMillis() / 1000 : b.b(context);
    }

    public abstract JSONObject a();

    public JSONObject b() {
        JSONObject jSONObjectA = a();
        if (jSONObjectA == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("moniter_type", this.f9351a);
            jSONObject.put("uuid", f9350b);
            jSONObject.put("moniter_id", this.f9352c);
            jSONObject.put("timestamp", this.f9353d);
            jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, jSONObjectA);
            return jSONObject;
        } catch (JSONException e9) {
            f.c("BaseMoniter", "build baseMoniter data error" + e9.getMessage());
            return null;
        }
    }

    public String c() {
        return this.f9352c;
    }
}
