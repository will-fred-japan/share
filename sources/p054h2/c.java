package p054h2;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import p061i1.h;
import p099n1.d;

/* JADX INFO: compiled from: MainProcessBizTrafficStats.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements p054h2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f19008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap f19009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap f19010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap f19011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap f19012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap f19013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f19014i;
    public HashMap j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f19015k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f19016l;

    /* JADX INFO: compiled from: MainProcessBizTrafficStats.java */
    public class a implements p115p1.b {
        public a() {
        }

        @Override // p115p1.b
        public final void b(String str, JSONObject jSONObject) {
            c cVar = c.this;
            if (cVar.f19006a) {
                if (h.f19230b) {
                    Log.i("BizTrafficStats", p199z2.b.f(new String[]{"deliver ", str, jSONObject.toString()}));
                }
                cVar.b(str, jSONObject);
            }
        }
    }

    /* JADX INFO: compiled from: MainProcessBizTrafficStats.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f19019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f19020c;

        public b(String str, long j, String str2) {
            this.f19018a = str;
            this.f19019b = j;
            this.f19020c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f(this.f19019b, this.f19018a, this.f19020c);
        }
    }

    @Override // p054h2.b
    @Deprecated
    public final void a(JSONObject jSONObject) {
    }

    @Override // p054h2.b
    public final void b(String str) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        this.j.put(str, new HashMap());
    }

    @Override // p054h2.b
    public final void c(double d9) {
    }

    @Override // p054h2.b
    public final void clear() {
        HashMap map = this.f19008c;
        if (map != null) {
            map.clear();
        }
        HashMap map2 = this.f19009d;
        if (map2 != null) {
            map2.clear();
        }
        HashMap map3 = this.f19010e;
        if (map3 != null) {
            map3.clear();
        }
        HashMap map4 = this.f19011f;
        if (map4 != null) {
            map4.clear();
        }
        HashMap map5 = this.f19012g;
        if (map5 != null) {
            map5.clear();
        }
        this.f19014i = 0L;
    }

    @Override // p054h2.b
    public final void d(String str) {
        HashMap map = this.j;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> e() {
        return this.f19010e;
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> f() {
        return this.f19008c;
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> g() {
        return this.f19013h;
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> h() {
        return this.f19011f;
    }

    @Override // p054h2.b
    public final void a() {
        this.f19006a = true;
        this.f19007b = true;
        int i9 = p115p1.c.f20774p;
        p115p1.c cVar = p1.c.a.f20785a;
        a aVar = this.f19016l;
        if (cVar.f20783n.contains(aVar) || aVar == null) {
            return;
        }
        cVar.f20783n.add(aVar);
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> c(String str) {
        if (this.j == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return (Map) this.j.get(str);
    }

    @Override // p054h2.b
    public final void e(double d9) {
        this.f19015k = d9;
    }

    public final void f(long j, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean zB = d.b(h.f19229a);
        boolean zIsForeground = ActivityLifeObserver.getInstance().isForeground();
        if (this.f19007b && j > this.f19015k) {
            String.format("trafficBytes: %d, sourceId: %s, business: %s, isWifi: %b, isFront: %b", Long.valueOf(j), str2, str, Boolean.valueOf(zB), Boolean.valueOf(zIsForeground));
        }
        if (h.f19230b) {
            Log.i("APM-TrafficInfo", p199z2.b.f(new String[]{String.format("trafficBytes: %d, sourceId: %s, business: %s, isWifi: %b, isFront: %b", Long.valueOf(j), str2, str, Boolean.valueOf(zB), Boolean.valueOf(zIsForeground))}));
        }
        if (this.f19008c == null) {
            this.f19008c = new HashMap();
        }
        if (this.f19009d == null) {
            this.f19009d = new HashMap();
        }
        if (this.f19010e == null) {
            this.f19010e = new HashMap();
        }
        if (this.f19011f == null) {
            this.f19011f = new HashMap();
        }
        if (this.f19012g == null) {
            this.f19012g = new HashMap();
        }
        if (this.f19008c.containsKey(str)) {
            ((p054h2.a) this.f19008c.get(str)).c(str2, j);
        } else {
            p054h2.a aVar = new p054h2.a(str);
            aVar.c(str2, j);
            this.f19008c.put(str, aVar);
        }
        if (zB && !zIsForeground) {
            if (this.f19009d.containsKey(str)) {
                ((p054h2.a) this.f19009d.get(str)).c(str2, j);
            } else {
                p054h2.a aVar2 = new p054h2.a(str);
                aVar2.c(str2, j);
                this.f19009d.put(str, aVar2);
            }
        }
        if (zB && zIsForeground) {
            if (this.f19010e.containsKey(str)) {
                ((p054h2.a) this.f19010e.get(str)).c(str2, j);
            } else {
                p054h2.a aVar3 = new p054h2.a(str);
                aVar3.c(str2, j);
                this.f19010e.put(str, aVar3);
            }
        }
        if (!zB && !zIsForeground) {
            if (this.f19011f.containsKey(str)) {
                ((p054h2.a) this.f19011f.get(str)).c(str2, j);
            } else {
                p054h2.a aVar4 = new p054h2.a(str);
                aVar4.c(str2, j);
                this.f19011f.put(str, aVar4);
            }
        }
        if (!zB && zIsForeground) {
            if (this.f19012g.containsKey(str)) {
                ((p054h2.a) this.f19012g.get(str)).c(str2, j);
            } else {
                p054h2.a aVar5 = new p054h2.a(str);
                aVar5.c(str2, j);
                this.f19012g.put(str, aVar5);
            }
        }
        if (this.f19013h == null) {
            this.f19013h = new HashMap();
        }
        if (this.f19013h.containsKey(str)) {
            ((p054h2.a) this.f19013h.get(str)).c(str2, j);
        } else {
            p054h2.a aVar6 = new p054h2.a(str);
            aVar6.c(str2, j);
            this.f19013h.put(str, aVar6);
        }
        HashMap map = this.j;
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map map2 = (Map) ((Map.Entry) it.next()).getValue();
                if (map2.containsKey(str)) {
                    ((p054h2.a) map2.get(str)).c(str2, j);
                } else {
                    p054h2.a aVar7 = new p054h2.a(str);
                    aVar7.c(str2, j);
                    map2.put(str, aVar7);
                }
            }
        }
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> d() {
        return this.f19009d;
    }

    @Override // p054h2.b
    public final long b() {
        return this.f19014i;
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> c() {
        return this.f19012g;
    }

    @Override // p054h2.b
    @SuppressLint({"CI_DefaultLocale"})
    public final void d(long j, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.f19006a) {
            p133r2.b.f21107i.a(new b(str2, j, str));
            boolean zB = d.b(h.f19229a);
            boolean zIsForeground = ActivityLifeObserver.getInstance().isForeground();
            if (this.f19007b && j > this.f19015k) {
                String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s, isWifi: %b, isFront: %b", Long.valueOf(j), str, str2, str3 == null ? "" : str3, jSONObject == null ? "" : jSONObject.toString(), jSONObject2 == null ? "" : jSONObject2.toString(), Boolean.valueOf(zB), Boolean.valueOf(zIsForeground));
            }
            if (h.f19230b) {
                Log.i("APM-TrafficInfo", p199z2.b.f(new String[]{String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s, isWifi: %b, isFront: %b", Long.valueOf(j), str, str2, str3 == null ? "" : str3, jSONObject == null ? "" : jSONObject.toString(), jSONObject2 != null ? jSONObject2.toString() : "", Boolean.valueOf(zB), Boolean.valueOf(zIsForeground))}));
            }
            this.f19014i += j;
        }
    }

    @Override // p054h2.b
    public final void b(String str, JSONObject jSONObject) {
        String strOptString;
        if (!this.f19006a || TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            String path = new URL(str).getPath();
            if (TextUtils.isEmpty(path)) {
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("request_log");
            if (jSONObjectOptJSONObject == null) {
                String strOptString2 = jSONObject.optString("request_log");
                if (!TextUtils.isEmpty(strOptString2)) {
                    jSONObjectOptJSONObject = new JSONObject(strOptString2);
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("response");
            long jOptLong = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optLong("received_bytes") + jSONObjectOptJSONObject2.optLong("sent_bytes") : 0L;
            this.f19014i += jOptLong;
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("other");
            if (jSONObjectOptJSONObject3 != null) {
                strOptString = jSONObjectOptJSONObject3.optString("libcore");
            } else {
                strOptString = "okhttp";
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    str = Uri.parse(str).buildUpon().clearQuery().build().toString();
                } catch (Exception unused) {
                }
            }
            f(jOptLong, strOptString, str);
            g2.b.a.f18852a.a(jOptLong, path);
        } catch (Throwable unused2) {
        }
    }
}
