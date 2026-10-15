package cn.jiguang.ac;

import android.text.TextUtils;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LinkedHashSet<g> f8901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LinkedHashSet<g> f8902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LinkedHashSet<g> f8903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    LinkedHashSet<g> f8904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    LinkedHashSet<g> f8905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    JSONObject f8906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    transient g f8907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f8908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f8909i;
    int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f8910k;

    public l(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f8901a = a(jSONObject, "ips");
            this.f8902b = a(jSONObject, "ssl_ips");
            this.f8903c = a(jSONObject, "http_report");
            this.f8904d = a(jSONObject, "https_report");
            this.f8905e = a(jSONObject, "sis_ips");
            this.f8908h = jSONObject.optBoolean("data_report");
            this.f8906f = jSONObject.optJSONObject("tcp_report");
            this.f8909i = jSONObject.optInt("cert_ver", 0);
            this.j = jSONObject.optInt("r_cert_ver", 0);
            this.f8910k = jSONObject.optInt("c_cert_ver", 0);
            cn.jiguang.x.f.c(TCPTimingCache.P_SIS, "get sis=" + jSONObject.toString(2));
        } catch (Throwable unused) {
        }
    }

    private LinkedHashSet<g> a(JSONObject jSONObject, String str) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
            if (jSONArrayOptJSONArray != null) {
                for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                    g gVarA = g.a(jSONArrayOptJSONArray.optString(i9, null));
                    if (gVarA != null && gVarA.a()) {
                        linkedHashSet.add(gVarA);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return linkedHashSet;
    }

    public boolean a() {
        LinkedHashSet<g> linkedHashSet = this.f8901a;
        if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
            return false;
        }
        LinkedHashSet<g> linkedHashSet2 = this.f8902b;
        return linkedHashSet2 == null || linkedHashSet2.isEmpty();
    }
}
