package p192y2;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;
import p150t2.b;

/* JADX INFO: compiled from: CommonEvent.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f22368b;

    @Override // p150t2.b
    public final boolean a() {
        return !TextUtils.isEmpty(this.f22367a);
    }

    @Override // p150t2.b
    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "service_monitor");
            jSONObject.put("service", this.f22367a);
            jSONObject.put("status", 0);
            JSONObject jSONObject2 = this.f22368b;
            if (jSONObject2 == null) {
                return jSONObject;
            }
            jSONObject.put("value", jSONObject2);
            return jSONObject;
        } catch (Exception e9) {
            if (!A1.b.f1393A || p010b3.b.f8497a == null || !A1.b.f1393A) {
                return null;
            }
            Log.w("APM-CommonEvent", "toJsonObject Error.", e9);
            return null;
        }
    }

    @Override // p150t2.b
    public final String c() {
        return "service_monitor";
    }

    public final String toString() {
        return A.a.j(new StringBuilder("CommonEvent{serviceName='"), this.f22367a, "'}");
    }
}
