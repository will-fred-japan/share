package p124q1;

import org.json.JSONException;
import org.json.JSONObject;
import p011b4.h;
import p107o1.b;

/* JADX INFO: compiled from: EventData.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f20888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f20889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f20890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f20891f;

    public c(String str, int i9, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.f20886a = str;
        this.f20887b = i9;
        this.f20888c = jSONObject;
        this.f20889d = jSONObject2;
        this.f20890e = jSONObject3;
        this.f20891f = jSONObject4;
    }

    @Override // p107o1.b
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", "event_log");
            jSONObject.put("service", "event_log");
            jSONObject.put("event_name", this.f20886a);
            jSONObject.put("status", this.f20887b);
            JSONObject jSONObject2 = this.f20888c;
            if (jSONObject2 != null) {
                jSONObject.put("value", jSONObject2);
            }
            JSONObject jSONObject3 = this.f20889d;
            if (jSONObject3 != null) {
                jSONObject.put("dimension", jSONObject3);
            }
            JSONObject jSONObject4 = this.f20890e;
            if (jSONObject4 != null) {
                jSONObject.put("metrics", jSONObject4);
            }
            JSONObject jSONObject5 = this.f20891f;
            if (jSONObject5 != null) {
                jSONObject.put("extraValue", jSONObject5);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // p107o1.b
    public final boolean b() {
        return h.f8542b.getServiceSwitch(this.f20886a);
    }

    @Override // p107o1.b
    public final String d() {
        return "event_log";
    }

    @Override // p107o1.b
    public final String g() {
        return "event_log";
    }
}
