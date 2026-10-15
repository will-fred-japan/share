package cn.jiguang.ac;

import android.text.TextUtils;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g f8867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f8868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f8869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f8870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f8871e;

    public d(g gVar) {
        this.f8867a = gVar;
    }

    public static d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d(new g(jSONObject.getString("ip"), jSONObject.getInt(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT)));
            dVar.f8868b = jSONObject.optInt("status");
            dVar.f8869c = jSONObject.optLong("fetch_time");
            dVar.f8870d = jSONObject.optLong("cost");
            dVar.f8871e = jSONObject.optInt("prefer");
            return dVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f8868b != dVar.f8868b || this.f8869c != dVar.f8869c || this.f8870d != dVar.f8870d || this.f8871e != dVar.f8871e) {
            return false;
        }
        g gVar = this.f8867a;
        g gVar2 = dVar.f8867a;
        if (gVar != null) {
            return gVar.equals(gVar2);
        }
        return gVar2 == null;
    }

    public int hashCode() {
        g gVar = this.f8867a;
        int iHashCode = (((gVar != null ? gVar.hashCode() : 0) * 31) + this.f8868b) * 31;
        long j = this.f8869c;
        int i9 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j8 = this.f8870d;
        return ((i9 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + this.f8871e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IpInfo{ipPort=");
        sb.append(this.f8867a);
        sb.append(", status=");
        sb.append(this.f8868b);
        sb.append(", fetchTime=");
        sb.append(this.f8869c);
        sb.append(", cost=");
        sb.append(this.f8870d);
        sb.append(", prefer=");
        return H2.a.a(sb, this.f8871e, '}');
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", this.f8867a.f8876a);
            jSONObject.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT, this.f8867a.f8877b);
            jSONObject.put("status", this.f8868b);
            jSONObject.put("fetch_time", this.f8869c);
            jSONObject.put("cost", this.f8870d);
            jSONObject.put("prefer", this.f8871e);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }
}
