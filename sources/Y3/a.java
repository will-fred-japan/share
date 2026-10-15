package Y3;

import R0.f;
import R0.g;
import U0.l;
import V0.m;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AppLog.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f5224e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile P0.a f5225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Application f5226g;
    public static Z3.a j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public volatile f f5237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public volatile g f5238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Q0.b f5239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f5240d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f5227h = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final p199z2.b f5228i = new p199z2.b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f5229k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f5230l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f5231m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f5232n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f5233o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final boolean f5234p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final boolean f5235q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final boolean f5236r = true;

    public a() {
        m.b(null);
    }

    public static a c(String str) {
        return f5227h.get(str);
    }

    public static a d(Context context, c cVar, Map<String, String> map) {
        a aVar = f5227h.get(cVar.f5241a);
        if (aVar != null) {
            Map<String, String> map2 = aVar.f5240d;
            if (map2 == null) {
                aVar.f5240d = map;
                return aVar;
            }
            if (map != null) {
                map2.putAll(map);
            }
            return aVar;
        }
        a aVar2 = new a();
        aVar2.f5240d = map;
        T1.d.a aVar3 = cVar.f5244d;
        if (aVar3 != null) {
            T1.d.a aVar4 = m.f4821a;
            try {
                m.f4822b = (context.getApplicationInfo().flags & 2) != 0;
            } catch (Throwable unused) {
                m.f4822b = true;
            }
            m.f4821a = aVar3;
        }
        m.a("Inited Begin", null);
        if (f5226g == null) {
            f5226g = (Application) context.getApplicationContext();
        }
        f5227h.put(cVar.f5241a, aVar2);
        aVar2.f5237a = new f(f5226g, cVar);
        aVar2.f5238b = new g(f5226g, aVar2.f5237a);
        aVar2.f5239c = new Q0.b(f5226g, aVar2.f5237a, aVar2.f5238b);
        f5225f = new P0.a();
        f5226g.registerActivityLifecycleCallbacks(f5225f);
        StringBuilder sbF = p027d5.a.f("Inited Config Did:");
        sbF.append(cVar.f5251l);
        sbF.append(" aid:");
        sbF.append(cVar.f5241a);
        m.a(sbF.toString(), null);
        return aVar2;
    }

    public static boolean e() {
        return f5232n;
    }

    public static void f(l lVar) {
        ConcurrentHashMap<String, a> concurrentHashMap = f5227h;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return;
        }
        Iterator<a> it = concurrentHashMap.values().iterator();
        while (it.hasNext()) {
            Q0.b bVar = it.next().f5239c;
            if (bVar != null) {
                bVar.c(lVar);
            }
        }
    }

    public final String a() {
        if (this.f5238b == null) {
            return null;
        }
        g gVar = this.f5238b;
        if (gVar.f3934a) {
            return gVar.f3937d.optString("ab_sdk_version", "");
        }
        f fVar = gVar.f3936c;
        return fVar != null ? fVar.f3923c.getString("ab_sdk_version", "") : "";
    }

    public final String b() {
        return this.f5238b != null ? this.f5238b.f3937d.optString("bd_did", "") : "";
    }
}
