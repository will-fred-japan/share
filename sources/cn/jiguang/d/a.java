package cn.jiguang.d;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ae.c;
import cn.jiguang.analytics.page.ActivityLifecycle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.aw.h;
import cn.jiguang.aw.t;
import cn.jiguang.e.d;
import cn.jiguang.e.g;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.x.e;
import cn.jiguang.x.f;
import cn.jpush.android.local.JPushConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ActivityLifecycle f10457a = new ActivityLifecycle();

    public static ActivityLifecycle a() {
        return f10457a;
    }

    public static Object b() {
        return ActionManager.getActionMap();
    }

    public static int c() {
        try {
            Map<Integer, Bundle> mapD = c.a().d();
            f.c("JBridgeHelper", "map is " + mapD.toString());
            if (!mapD.containsKey(2)) {
                return 0;
            }
            String string = mapD.get(2).getString("code");
            if (TextUtils.isDigitsOnly(string)) {
                return Integer.parseInt(string);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String d(Context context) {
        return (String) cn.jiguang.e.f.a(context, d.ab());
    }

    public static String e(Context context) {
        return cn.jiguang.w.a.a(context);
    }

    public static long f(Context context) {
        return cn.jiguang.e.b.a(context);
    }

    public static long g(Context context) {
        return cn.jiguang.e.b.d(context);
    }

    public static String h(Context context) {
        return cn.jiguang.w.a.c(context);
    }

    public static String i(Context context) {
        return h.b(context);
    }

    public static String j(Context context) {
        return cn.jiguang.e.b.c(context);
    }

    public static int k(Context context) {
        return ((Integer) cn.jiguang.e.f.a(context, d.S())).intValue();
    }

    public static boolean l(Context context) {
        f.c("JBridgeHelper", "canShowLbsPermissionDialog");
        Boolean bool = (Boolean) cn.jiguang.e.f.a(context, d.aq());
        if (bool != null && !bool.booleanValue()) {
            f.d("JBridgeHelper", "lbs disable");
            return false;
        }
        long jLongValue = ((Long) cn.jiguang.e.f.a(context, d.ap())).longValue();
        long jLongValue2 = ((Long) cn.jiguang.e.f.a(context, d.an())).longValue();
        StringBuilder sbH = defpackage.f.h(jLongValue2, "lbs permission dialog shield, firstInit=", ", delay=");
        sbH.append(jLongValue);
        f.c("JBridgeHelper", sbH.toString());
        if (jLongValue2 > 0) {
            return jLongValue <= 0 || System.currentTimeMillis() > jLongValue2 + jLongValue;
        }
        cn.jiguang.e.f.a(context, (d<?>[]) new d[]{d.an().a(Long.valueOf(System.currentTimeMillis()))});
        return jLongValue <= 0;
    }

    public static Integer m(Context context) {
        Object objA = c.a().a(context, JPushConstants.SDK_TYPE, 30006);
        if (objA instanceof Integer) {
            return (Integer) objA;
        }
        return null;
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        String str2;
        long jB;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.equals(str, "app_list")) {
                str2 = "it";
                jB = b.b(context);
            } else {
                str2 = "itime";
                jB = b.b(context);
            }
            jSONObject.put(str2, jB);
            jSONObject.put("type", str);
            String str3 = (String) cn.jiguang.e.f.a(context, d.ab());
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("account_id", str3);
                return jSONObject;
            }
        } catch (JSONException e9) {
            f.i("JBridgeHelper", "fillBase exception:" + e9);
        }
        return jSONObject;
    }

    public static String b(Context context) {
        return cn.jiguang.e.b.b(context);
    }

    public static String c(Context context) {
        return (String) cn.jiguang.e.f.b(context, d.aa());
    }

    public static void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        f10457a.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static String b(String str) {
        return t.a(str, cn.jiguang.i.c.a.j);
    }

    public static String c(String str) {
        return t.b(str, cn.jiguang.i.c.a.j);
    }

    public static synchronized void a(Context context) {
        a(context, true);
    }

    public static void b(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        f10457a.removeActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 14, null, null, obj);
    }

    public static void a(Context context, JSONObject jSONObject) {
        a(context, jSONObject, false);
    }

    public static void a(Context context, JSONObject jSONObject, boolean z8) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("content");
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("log_enable");
                int iOptInt2 = jSONObjectOptJSONObject.optInt("log_print");
                int iOptInt3 = jSONObjectOptJSONObject.optInt("upload_enable");
                if (z8) {
                    int iOptInt4 = jSONObjectOptJSONObject.optInt("server_upload_state", 1);
                    g.b(context, iOptInt4);
                    f.c("JBridgeHelper", "server_upload_state: " + iOptInt4 + ", sp state: " + g.e(context));
                }
                cn.jiguang.e.f.a(context, (d<?>[]) new d[]{d.aM().a(Integer.valueOf(iOptInt))});
                JConstants.CMD_TO_PRINT_ALL_LOG = iOptInt2 == 1;
                cn.jiguang.e.f.a(context, (d<?>[]) new d[]{d.aN().a(Integer.valueOf(iOptInt2))});
                int iOptInt5 = jSONObjectOptJSONObject.optInt("expire");
                if (iOptInt5 <= 0) {
                    iOptInt5 = 7;
                }
                cn.jiguang.e.f.a(context, (d<?>[]) new d[]{d.aO().a(Long.valueOf(cn.jiguang.aw.f.a(iOptInt5)))});
                f.c("JBridgeHelper", "dealCommandInternalDebug: content: " + jSONObjectOptJSONObject + ", fromCmd: " + z8);
                if (iOptInt == 1) {
                    cn.jiguang.a.a.f8810h = true;
                    cn.jiguang.e.f.a(context, (d<?>[]) new d[]{d.aP().a(Integer.valueOf(Math.max(jSONObjectOptJSONObject.optInt("delay_upload"), 10)))});
                    if (iOptInt3 == 1) {
                        cn.jiguang.x.b.a(context);
                    }
                    if (!z8 || g.e(context) != 1) {
                        return;
                    } else {
                        f.c("JBridgeHelper", "dealCommandInternalDebug: server cmd upload log to server");
                    }
                } else {
                    cn.jiguang.a.a.f8810h = false;
                    if (!cn.jiguang.x.d.c(context)) {
                        return;
                    }
                    if (!g.d(context)) {
                        cn.jiguang.av.d.a("FUTURE_TASK", new cn.jiguang.av.b() { // from class: cn.jiguang.d.a.1
                            @Override // cn.jiguang.av.b
                            public void a() {
                                e.a();
                            }
                        });
                        return;
                    }
                }
                cn.jiguang.x.b.b(context);
            }
        } catch (Throwable th) {
            f.l("JBridgeHelper", "dealCommandInternalDebug failed: " + th.getMessage());
        }
    }

    public static synchronized void a(Context context, boolean z8) {
        String str;
        String str2;
        try {
            if (JConstants.isInstrumentationHookFailed) {
                Context applicationContext = context.getApplicationContext();
                String packageName = applicationContext.getPackageName();
                String strA = z8 ? cn.jiguang.aw.a.a(applicationContext) : packageName;
                if (TextUtils.isEmpty(strA) || !TextUtils.equals(packageName, strA)) {
                    str = "JBridgeHelper";
                    str2 = "need not registerActivityLifecycleCallbacks in other process :" + strA;
                } else {
                    try {
                        JConstants.isInstrumentationHookFailed = false;
                        ((Application) applicationContext).registerActivityLifecycleCallbacks(f10457a);
                        f.c("JBridgeHelper", "registerActivityLifecycleCallbacks in main process,packageName:" + packageName + ",processName:" + strA);
                    } catch (Throwable th) {
                        f.j("JBridgeHelper", "initPageLifecycle throwable=" + th);
                    }
                }
            } else {
                str = "JBridgeHelper";
                str2 = "need not registerActivityLifecycleCallbacks";
            }
            f.c(str, str2);
        } catch (Throwable th2) {
            f.j("JBridgeHelper", "registerActivityLifecycleCallbacks failed:" + th2);
            JConstants.isInstrumentationHookFailed = true;
        }
    }

    public static void a(String str, String str2) {
        ActionManager.addAction(str, str2);
    }

    public static boolean a(String str) {
        return c.a().a(str);
    }
}
