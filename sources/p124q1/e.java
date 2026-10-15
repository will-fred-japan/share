package p124q1;

import org.json.JSONException;
import org.json.JSONObject;
import p107o1.b;

/* JADX INFO: compiled from: FlutterData.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f20894a;

    @Override // p107o1.b
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", "flutter");
            jSONObject.put("service", "flutter");
            jSONObject.put("flutter_module", this.f20894a);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // p107o1.b
    public final boolean b() {
        return true;
    }

    @Override // p107o1.b
    public final String d() {
        return "flutter";
    }

    @Override // p107o1.b
    public final String g() {
        return "flutter";
    }
}
