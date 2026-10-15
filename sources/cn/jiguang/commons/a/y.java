package cn.jiguang.commons.a;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10439a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10440b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10441c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10442d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10443e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10444f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10445g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10446h = -1;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", this.f10439a);
            jSONObject.put("scale", this.f10440b);
            jSONObject.put("status", this.f10441c);
            jSONObject.put("voltage", this.f10443e);
            jSONObject.put("temperature", this.f10442d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final JSONObject b() {
        JSONObject jSONObjectA = a();
        try {
            jSONObjectA.put("plugged", this.f10446h);
            jSONObjectA.put("isPlugged", this.f10445g);
            jSONObjectA.put("isCharging", this.f10444f);
        } catch (JSONException unused) {
        }
        return jSONObjectA;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JBatteryInfo{level=");
        sb.append(this.f10439a);
        sb.append(", scale=");
        sb.append(this.f10440b);
        sb.append(", status=");
        sb.append(this.f10441c);
        sb.append(", temperature=");
        sb.append(this.f10442d);
        sb.append(", voltage=");
        sb.append(this.f10443e);
        sb.append(", isCharging=");
        sb.append(this.f10444f);
        sb.append(", isPlugged=");
        sb.append(this.f10445g);
        sb.append(", plugged=");
        return H2.a.a(sb, this.f10446h, '}');
    }
}
