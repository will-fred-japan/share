package cn.jpush.android.t;

import W5.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11572c;

    public static b a(String str, String str2, long j) {
        b bVar = new b();
        bVar.f11570a = str;
        bVar.f11571b = str2;
        bVar.f11572c = j;
        return bVar;
    }

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.f11570a = jSONObject.optString("tpl_id");
        bVar.f11571b = jSONObject.optString("tpl_file_name");
        bVar.f11572c = jSONObject.optLong("tpl_recent_use_time");
        return bVar;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tpl_id", this.f11570a);
            jSONObject.put("tpl_file_name", this.f11571b);
            jSONObject.put("tpl_recent_use_time", this.f11572c);
            return jSONObject;
        } catch (Throwable th) {
            f.r(th, new StringBuilder("notify inapp toJSON failed. "), "InAppTemplate");
            return null;
        }
    }
}
