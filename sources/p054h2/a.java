package p054h2;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BizData.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19003a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19005c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f19004b = new HashMap();

    public a(String str) {
        this.f19003a = str;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("biz", this.f19003a);
            jSONObject.put("usage", this.f19005c);
            JSONArray jSONArray = new JSONArray();
            HashMap map = this.f19004b;
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("source_id", entry.getKey());
                    jSONObject2.put("usage", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("detail", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final JSONObject b(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("biz", this.f19003a);
            jSONObject.put("usage", this.f19005c);
            JSONArray jSONArray = new JSONArray();
            HashMap map = this.f19004b;
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    if (((Long) entry.getValue()).longValue() >= j) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("source_id", entry.getKey());
                        jSONObject2.put("usage", entry.getValue());
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("detail", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void c(String str, long j) {
        HashMap map = this.f19004b;
        if (map.containsKey(str)) {
            map.put(str, Long.valueOf(((Long) map.get(str)).longValue() + j));
        } else {
            map.put(str, Long.valueOf(j));
        }
        this.f19005c += j;
    }
}
