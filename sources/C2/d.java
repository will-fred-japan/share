package C2;

import org.json.JSONObject;

/* JADX INFO: compiled from: PersistentBuffer.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements p150t2.b {
    @Override // p150t2.b
    public final boolean a() {
        return true;
    }

    @Override // p150t2.b
    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "service_monitor");
            jSONObject.put("service", "apm_error");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "large_data");
            jSONObject.put("category", jSONObject2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // p150t2.b
    public final String c() {
        return "service_monitor";
    }
}
