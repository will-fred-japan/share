package cn.jiguang.commons.a;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicBoolean f10391d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f10393f;

    public m() {
    }

    public static m a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            m mVar = new m();
            mVar.f10393f = jSONObject.optString("value", "");
            mVar.f10388a = jSONObject.optLong("expiredTime", 0L);
            mVar.f10389b = jSONObject.optLong("cacheTime", 0L);
            return mVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            Object objValueOf = this.f10393f;
            if (objValueOf == null) {
                objValueOf = "";
            } else if (!(objValueOf instanceof String) && !(objValueOf instanceof Number) && !(objValueOf instanceof Boolean)) {
                objValueOf = String.valueOf(objValueOf);
            }
            jSONObject.put("value", objValueOf);
            jSONObject.put("expiredTime", this.f10388a);
            jSONObject.put("cacheTime", this.f10389b);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", "");
            jSONObject.put("expiredTime", this.f10388a);
            jSONObject.put("cacheTime", this.f10389b);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public final Object d() {
        return this.f10393f;
    }

    public final String toString() {
        return "CacheValue{value=" + this.f10393f + ", expiredTime=" + this.f10388a + ", cacheTime=" + this.f10389b + '}';
    }

    public m(Object obj, long j, long j8) {
        this.f10393f = obj;
        this.f10388a = j;
        this.f10389b = j8;
    }

    public final void a(Object obj, long j, long j8) {
        this.f10393f = obj;
        this.f10388a = j;
        this.f10389b = j8;
    }

    public final boolean a() {
        return this.f10388a <= 0 || Math.abs(System.currentTimeMillis() - this.f10389b) < this.f10388a;
    }
}
