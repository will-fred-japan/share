package H2;

import android.util.Log;
import androidx.datastore.preferences.protobuf.C0524s;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: CpuReportEvent.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends p166v2.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p184x3.b f2401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f2403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f2404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f2405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f2406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2407i;
    public String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f2408k;

    public i() {
        throw null;
    }

    @Override // p150t2.b
    public final boolean a() {
        return true;
    }

    @Override // p166v2.a
    public final JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("process_name", p061i1.h.c());
            jSONObject.put("is_main_process", p061i1.h.h());
            jSONObject.put("scene", this.f2402d);
            int iB = C0524s.b(this.f2400b);
            if (iB == 0) {
                jSONObject.put("data_type", "mix");
                return jSONObject;
            }
            if (iB == 1) {
                jSONObject.put("data_type", "front");
                return jSONObject;
            }
            if (iB != 2) {
                return jSONObject;
            }
            jSONObject.put("data_type", "back");
            return jSONObject;
        } catch (Throwable th) {
            Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p166v2.a
    public final JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            double d9 = this.f2403e;
            if (d9 > -1.0d) {
                double d10 = this.f2404f;
                if (d10 > -1.0d) {
                    jSONObject.put("app_usage_rate", d9);
                    jSONObject.put("app_max_usage_rate", d10);
                }
            }
            double d11 = this.f2405g;
            if (d11 > -1.0d) {
                double d12 = this.f2406h;
                if (d12 > -1.0d) {
                    jSONObject.put("app_stat_speed", d11);
                    jSONObject.put("app_max_stat_speed", d12);
                }
            }
            ArrayList<p099n1.e> arrayList = this.f2408k;
            if (arrayList != null && !arrayList.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject();
                for (p099n1.e eVar : arrayList) {
                    if (eVar != null) {
                        Number number = eVar.f20559b;
                        F f6 = eVar.f20558a;
                        if (f6 != 0 && !((String) f6).isEmpty() && number != null && ((Double) number).doubleValue() >= 0.0d) {
                            jSONObject2.put((String) f6, number);
                        }
                    }
                }
                jSONObject.put("thread_cpu_usage", jSONObject2);
            }
            return jSONObject;
        } catch (Throwable th) {
            Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
            return null;
        }
    }

    @Override // p166v2.a
    public final JSONObject f() {
        try {
            JSONObject jSONObjectB = p158u2.a.a().b();
            jSONObjectB.put("is_auto_sample", true);
            p184x3.b bVar = this.f2401c;
            if (bVar == null) {
                return jSONObjectB;
            }
            jSONObjectB.put("network_type", A4.b.b(p061i1.h.f19229a));
            jSONObjectB.put("battery_level", bVar.f22280c);
            jSONObjectB.put("cpu_hardware", bVar.f22278a);
            jSONObjectB.put("is_charging", bVar.f22279b);
            jSONObjectB.put("power_save_mode", bVar.f22282e);
            jSONObjectB.put("thermal_status", bVar.f22281d);
            jSONObjectB.put("battery_thermal", bVar.f22283f);
            jSONObjectB.put("is_normal_sample_state", this.f2407i);
            return jSONObjectB;
        } catch (Throwable th) {
            Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
            return null;
        }
    }
}
