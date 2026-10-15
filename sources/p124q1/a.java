package p124q1;

import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;
import p107o1.b;

/* JADX INFO: compiled from: ApiData.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f20881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f20883g;

    @Override // p107o1.b
    public final JSONObject a() {
        String str = this.f20881e;
        String str2 = this.f20880d;
        if (TextUtils.isEmpty("network")) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "network");
            jSONObject.put("service", "network");
            jSONObject.put("duration", this.f20877a);
            jSONObject.put("uri", Uri.parse(this.f20879c));
            long j = this.f20878b;
            if (j > 0) {
                jSONObject.put("timestamp", j);
            }
            jSONObject.put("status", this.f20882f);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ip", str2);
            }
            if (TextUtils.isEmpty(str)) {
                jSONObject.put("trace_code", "");
                return jSONObject;
            }
            jSONObject.put("trace_code", str);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // p107o1.b
    public final boolean b() {
        return false;
    }

    @Override // p107o1.b
    public final String d() {
        return null;
    }

    @Override // p107o1.b
    public final String g() {
        return null;
    }
}
