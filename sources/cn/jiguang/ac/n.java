package cn.jiguang.ac;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f8926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f8927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8929i = 0;
    private int j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8930k = 0;

    public n(int i9, String str, String str2, long j, String str3, double d9, double d10, long j8) {
        this.f8921a = i9;
        this.f8922b = str;
        this.f8923c = str2;
        this.f8924d = j;
        this.f8925e = str3;
        this.f8926f = d9;
        this.f8927g = d10;
        this.f8928h = j8;
    }

    public n a(int i9) {
        this.f8930k = i9;
        return this;
    }

    public JSONObject a(Set<String> set) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f8921a);
            jSONObject.put("appkey", this.f8922b);
            jSONObject.put("sdkver", this.f8923c);
            jSONObject.put("platform", 0);
            long j = this.f8924d;
            if (j != 0) {
                jSONObject.put("uid", j);
            }
            String str = this.f8925e;
            if (str != null) {
                jSONObject.put("opera", str);
            }
            if (a(this.f8926f, this.f8927g)) {
                jSONObject.put("lat", this.f8926f);
                jSONObject.put("lng", this.f8927g);
                jSONObject.put(CrashHianalyticsData.TIME, this.f8928h);
            }
            if (set != null && !set.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("fail_ips", jSONArray);
            }
            int i9 = this.f8929i;
            if (i9 != 0) {
                jSONObject.put("ips_flag", i9);
            }
            int i10 = this.j;
            if (i10 != 0) {
                jSONObject.put("report_flag", i10);
            }
            int i11 = this.f8930k;
            if (i11 >= 0) {
                if (i11 == 0) {
                    i11 = 1;
                }
                jSONObject.put("cert_ver", i11);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static boolean a(double d9, double d10) {
        return d9 > -90.0d && d9 < 90.0d && d10 > -180.0d && d10 < 180.0d;
    }
}
