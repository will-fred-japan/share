package p192y2;

import org.json.JSONArray;
import org.json.JSONObject;
import p150t2.b;

/* JADX INFO: compiled from: TracingData.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f22371a;

    @Override // p150t2.b
    public final boolean a() {
        return true;
    }

    @Override // p150t2.b
    public final JSONObject b() {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("wrapper_array_data", this.f22371a);
            jSONObjectPut.put("log_type", "tracing");
            jSONObjectPut.put("wrapper_type_description", 1);
            return jSONObjectPut;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // p150t2.b
    public final String c() {
        return "tracing";
    }
}
