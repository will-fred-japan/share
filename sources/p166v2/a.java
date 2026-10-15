package p166v2;

import H2.i;
import org.json.JSONException;
import org.json.JSONObject;
import p150t2.b;

/* JADX INFO: compiled from: PerfBaseEvent.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f21890a;

    @Override // p150t2.b
    public final JSONObject b() {
        try {
            if (this.f21890a == null) {
                this.f21890a = new JSONObject();
            }
            this.f21890a.put("log_type", "performance_monitor");
            this.f21890a.put("service", ((i) this).j);
            JSONObject jSONObjectE = e();
            if (!A1.b.E0(jSONObjectE)) {
                this.f21890a.put("extra_values", jSONObjectE);
            }
            JSONObject jSONObjectD = d();
            if (!A1.b.E0(jSONObjectD)) {
                this.f21890a.put("extra_status", jSONObjectD);
            }
            JSONObject jSONObjectF = f();
            if (!A1.b.E0(jSONObjectF)) {
                this.f21890a.put("filters", jSONObjectF);
            }
            return this.f21890a;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // p150t2.b
    public final String c() {
        return "performance_monitor";
    }

    public abstract JSONObject d();

    public abstract JSONObject e();

    public abstract JSONObject f();
}
