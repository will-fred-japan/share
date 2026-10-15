package cn.jiguang.w;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import cn.jiguang.api.JCoreManager;
import com.engagelab.privates.push.constants.MTPushConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f10920a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10922b;

        private a(int i9) {
            this.f10921a = i9;
        }

        public static a a(int i9, long j, long j8) {
            a aVar = new a(i9);
            aVar.a(j, j8);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mode", this.f10921a);
                jSONObject.put("state", this.f10922b);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }

        private void a(long j, long j8) {
            this.f10922b = Math.abs(j - j8) > 300 ? 1 : 0;
        }
    }

    public static void a(Context context) {
        a(context, 1, JCoreManager.getStartId(context), SystemClock.elapsedRealtime());
    }

    public static void b(Context context) {
        if (!a()) {
            cn.jiguang.x.f.c("WakeLaunchHelper", "no cached data to report");
            return;
        }
        if (cn.jiguang.d.a.f(context) <= 0) {
            cn.jiguang.x.f.c("WakeLaunchHelper", "UID not available, skip report cached data");
            return;
        }
        JSONArray jSONArrayC = c(context);
        if (jSONArrayC == null || jSONArrayC.length() == 0) {
            cn.jiguang.x.f.c("WakeLaunchHelper", "no cached data to report");
            return;
        }
        try {
            cn.jiguang.aa.b.a(context, jSONArrayC);
            cn.jiguang.x.f.c("WakeLaunchHelper", "report cached wake launch data, count: " + jSONArrayC.length());
            d(context);
        } catch (Throwable th) {
            cn.jiguang.x.f.b("WakeLaunchHelper", "reportCachedData failed:" + th.getMessage(), th);
        }
    }

    private static JSONArray c(Context context) {
        JSONArray jSONArrayOptJSONArray;
        if (!a()) {
            cn.jiguang.x.f.c("WakeLaunchHelper", "no cached wake launch data");
            return null;
        }
        synchronized ("wake_launch_cache.json") {
            try {
                JSONObject jSONObjectA = cn.jiguang.aw.j.a("wake_launch_cache.json");
                if (jSONObjectA != null && (jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content")) != null && jSONArrayOptJSONArray.length() != 0) {
                    cn.jiguang.x.f.c("WakeLaunchHelper", "get cached wake launch data, count: " + jSONArrayOptJSONArray.length());
                    return jSONArrayOptJSONArray;
                }
                f10920a = Boolean.FALSE;
                cn.jiguang.x.f.c("WakeLaunchHelper", "no cached wake launch data");
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void d(Context context) {
        synchronized ("wake_launch_cache.json") {
            cn.jiguang.aw.j.d("wake_launch_cache.json");
            f10920a = Boolean.FALSE;
            cn.jiguang.x.f.c("WakeLaunchHelper", "clean cached wake launch data");
        }
    }

    public static void a(Context context, int i9, long j, long j8) {
        a aVarA = a.a(i9, j, j8);
        if (cn.jiguang.d.a.f(context) <= 0) {
            a(context, aVarA.a());
            return;
        }
        a(context, "");
        cn.jiguang.aa.b.b(context, aVarA.a(), "wake_launch");
        b(context);
    }

    private static void a(Context context, String str) {
        if (cn.jiguang.d.a.f(context) <= 0) {
            cn.jiguang.x.f.c("WakeLaunchHelper", "triggerSceneCheck aborted: invalid UID");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("scence", 5);
        cn.jiguang.c.b.a(context, str, MTPushConstants.NotificationState.KEY_STATE, bundle);
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectA = cn.jiguang.d.a.a(context, jSONObject, "wake_launch");
            synchronized ("wake_launch_cache.json") {
                try {
                    JSONObject jSONObjectA2 = cn.jiguang.aw.j.a("wake_launch_cache.json");
                    if (jSONObjectA2 == null) {
                        jSONObjectA2 = new JSONObject();
                    }
                    JSONArray jSONArrayOptJSONArray = jSONObjectA2.optJSONArray("content");
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(jSONObjectA);
                    jSONObjectA2.put("content", jSONArrayOptJSONArray);
                    cn.jiguang.aw.j.a("wake_launch_cache.json", jSONObjectA2);
                    f10920a = Boolean.TRUE;
                    cn.jiguang.x.f.c("WakeLaunchHelper", "save wake launch data : " + jSONObjectA2.toString());
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.x.f.b("WakeLaunchHelper", "saveCachedData failed:" + th2.getMessage(), th2);
        }
    }

    private static boolean a() {
        Boolean boolValueOf;
        boolean zBooleanValue;
        if (f10920a != null) {
            return f10920a.booleanValue();
        }
        synchronized ("wake_launch_cache.json") {
            try {
                if (f10920a != null) {
                    zBooleanValue = f10920a.booleanValue();
                } else {
                    JSONObject jSONObjectA = cn.jiguang.aw.j.a("wake_launch_cache.json");
                    if (jSONObjectA != null) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content");
                        boolValueOf = Boolean.valueOf(jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0);
                    } else {
                        boolValueOf = Boolean.FALSE;
                    }
                    f10920a = boolValueOf;
                    zBooleanValue = f10920a.booleanValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }
}
