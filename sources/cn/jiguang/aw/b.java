package cn.jiguang.aw;

import android.content.Context;
import android.os.Bundle;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f9492a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f9493b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f9494c = false;

    public static void a(final Context context) {
        cn.jiguang.x.f.c("AuthUtils", " sync status");
        cn.jiguang.av.d.a("DELAY_TASK", new cn.jiguang.av.b() { // from class: cn.jiguang.aw.b.1
            @Override // cn.jiguang.av.b
            public void a() {
                try {
                    if (Math.abs(System.currentTimeMillis() - ((Long) cn.jiguang.e.f.a(context, cn.jiguang.e.d.V())).longValue()) < 432000000) {
                        cn.jiguang.x.f.c("AuthUtils", "sync status no need report");
                        return;
                    }
                    cn.jiguang.x.f.c("AuthUtils", "start sync status");
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(System.currentTimeMillis());
                    jSONArray2.put(System.currentTimeMillis());
                    jSONObject2.put("duration", jSONArray2);
                    jSONObject2.put("c_type", "set_auth");
                    JSONArray jSONArray3 = new JSONArray();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("result", "" + (!b.f9494c ? 1 : 0));
                    jSONObject3.put("s_type", "set_auth");
                    jSONArray3.put(jSONObject3);
                    jSONObject2.put("statistics", jSONArray3);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("slice_index", 1);
                    jSONObject.put("slice_count", 1);
                    jSONObject.put("data", jSONArray);
                    jSONObject.put("sequence", UUID.randomUUID().toString());
                    cn.jiguang.x.f.c("AuthUtils", "reportJSON=" + jSONObject);
                    cn.jiguang.e.f.a(context, (cn.jiguang.e.d<?>[]) new cn.jiguang.e.d[]{cn.jiguang.e.d.V().a(Long.valueOf(System.currentTimeMillis()))});
                    cn.jiguang.aa.b.a(context, jSONObject, "collect_statistic");
                } catch (Throwable th) {
                    cn.jiguang.x.f.c("AuthUtils", "sync status  throwable=" + th);
                }
            }
        }, 8000L);
    }

    public static void b(Context context, boolean z8) {
        cn.jiguang.x.f.c("AuthUtils", "enableipv6 priority status: " + z8);
        f(context, z8);
        Bundle bundle = new Bundle();
        bundle.putBoolean("enable_ci_priority", z8);
        cn.jiguang.a.a.a(context, "a11", bundle);
    }

    public static void c(Context context, boolean z8) {
    }

    public static void d(Context context, boolean z8) {
        cn.jiguang.x.f.c("AuthUtils", "enableAutoWakeup config status: " + z8);
        cn.jiguang.e.f.a(context, (cn.jiguang.e.d<?>[]) new cn.jiguang.e.d[]{cn.jiguang.e.d.h().a(Boolean.valueOf(z8))});
    }

    public static void e(Context context, boolean z8) {
        cn.jiguang.x.f.c("AuthUtils", "setDynamicLoad config enable: " + z8);
        cn.jiguang.e.f.a(context, (cn.jiguang.e.d<?>[]) new cn.jiguang.e.d[]{cn.jiguang.e.d.j().a(Boolean.valueOf(z8))});
    }

    public static void f(Context context, boolean z8) {
        cn.jiguang.x.f.c("AuthUtils", "IPV6First config enable: " + z8);
        f9493b = Boolean.valueOf(z8);
        cn.jiguang.e.f.a(context, (cn.jiguang.e.d<?>[]) new cn.jiguang.e.d[]{cn.jiguang.e.d.i().a(Boolean.valueOf(z8))});
    }

    public static void g(Context context, boolean z8) {
        cn.jiguang.x.f.c("AuthUtils", "setAppTerminate config enable: " + z8);
        cn.jiguang.e.f.a(context, (cn.jiguang.e.d<?>[]) new cn.jiguang.e.d[]{cn.jiguang.e.d.k().a(Boolean.valueOf(z8))});
    }

    public static void a(Context context, boolean z8) {
        cn.jiguang.x.f.c("AuthUtils", "enableAutoWakeup status: " + z8);
        d(context, z8);
        cn.jiguang.ae.a.a(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("enable_auto_wakeup", z8);
        cn.jiguang.a.a.a(context, "a8", bundle);
    }

    public static boolean b() {
        return f9494c;
    }

    public static boolean d(Context context) {
        try {
            return ((Boolean) cn.jiguang.e.f.a(context, cn.jiguang.e.d.k())).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean e(Context context) {
        try {
            if (f9493b == null) {
                f9493b = (Boolean) cn.jiguang.e.f.a(context, cn.jiguang.e.d.i());
            }
            return f9493b.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(boolean z8, boolean z9) {
        f9494c = z9;
        f9492a = z8;
    }

    public static boolean b(Context context) {
        try {
            return ((Boolean) cn.jiguang.e.f.a(context, cn.jiguang.e.d.h())).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean c(Context context) {
        try {
            return ((Boolean) cn.jiguang.e.f.a(context, cn.jiguang.e.d.j())).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean a() {
        return f9492a;
    }
}
