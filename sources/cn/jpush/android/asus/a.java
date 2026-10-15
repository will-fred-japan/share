package cn.jpush.android.asus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.e.c;
import cn.jpush.android.f.e;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import defpackage.f;
import java.lang.reflect.Field;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f11224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f11225d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11222a = "asus".toLowerCase();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f11223b = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f11226e = null;

    private static ActivityInfo a(Context context, String str, Class<? extends BroadcastReceiver> cls) {
        ActivityInfo[] activityInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("AsusPushHelper", "Action - hasComponent, invalid param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            PackageInfo packageInfo = JCoreHelper.getPackageInfo(context, str, 2);
            if (packageInfo != null && (activityInfoArr = packageInfo.receivers) != null && activityInfoArr.length != 0) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    try {
                        if (cls.isAssignableFrom(Class.forName(activityInfo.name, false, cls.getClassLoader())) && activityInfo.enabled) {
                            return activityInfo;
                        }
                    } catch (Throwable unused) {
                    }
                }
                return null;
            }
            Logger.d("AsusPushHelper", "pkgInfo info is null");
            return null;
        } catch (Throwable th) {
            f.p("getReceiver error:", "AsusPushHelper", th);
        }
    }

    private static String b() {
        try {
            Field declaredField = e.class.getDeclaredField("SDK_VERSION");
            declaredField.setAccessible(true);
            return (String) declaredField.get(e.class);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void c(final Context context) {
        try {
            b(context);
            if (f11224c) {
                cn.jpush.android.c.b.a(context, e(context), new c() { // from class: cn.jpush.android.asus.a.1
                    @Override // cn.jpush.android.e.a
                    public void a(cn.jpush.android.e.b bVar) {
                        try {
                            Logger.dd("AsusPushHelper", "tokenResult:" + bVar);
                            a.a(context, bVar.a());
                            cn.jpush.android.ac.f.a().a(context, (byte) 6, bVar.b(), 1);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th) {
            W5.f.r(th, new StringBuilder("register error:"), "AsusPushHelper");
        }
    }

    public static byte d(Context context) {
        return (byte) 6;
    }

    public static String e(Context context) {
        return !TextUtils.isEmpty(f11223b) ? f11223b : JCoreHelper.getAppKey(context);
    }

    public static String f(Context context) {
        return "";
    }

    public static String g(Context context) {
        return cn.jpush.android.c.b.d(context);
    }

    public static boolean h(Context context) {
        String str;
        String strE = e(context);
        if (TextUtils.isEmpty(strE)) {
            str = f11222a + " appkey or appid is empty,need not clear plugin rid";
        } else {
            String appKey = JCoreHelper.getAppKey(context);
            if (!TextUtils.isEmpty(appKey)) {
                String str2 = (String) Sp.get(context, Key.ThirdPush_ClearFlag());
                StringBuilder sbC = p171w.a.c(strE, appKey);
                sbC.append(JCoreHelper.getJCoreSDKVersionInt());
                sbC.append(JCoreHelper.getJPushSDKVersionInt());
                String hash = JThirdPlatFormInterface.toHash(sbC.toString());
                if (TextUtils.isEmpty(str2)) {
                    Sp.set(context, Key.ThirdPush_ClearFlag().set(hash));
                    return true;
                }
                if (TextUtils.isEmpty(hash)) {
                    return true;
                }
                if (TextUtils.equals(str2, hash)) {
                    return false;
                }
                Logger.d("AsusPushHelper", "local set changed,re bind token");
                Sp.set(context, Key.ThirdPush_ClearFlag().set(hash));
                return true;
            }
            str = "jpush appkey is empty,need not clear plugin rid";
        }
        Logger.ii("AsusPushHelper", str);
        return false;
    }

    private static boolean i(Context context) {
        ActivityInfo activityInfoA = a(context, context.getPackageName(), AsusPushMessageReceiver.class);
        if (activityInfoA == null) {
            Logger.ww("AsusPushHelper", "AndroidManifest.xml missing receiver extends asus's AsusPushMessageReceiver");
            return false;
        }
        Logger.d("AsusPushHelper", "found receiver:" + activityInfoA.name);
        return true;
    }

    public static synchronized void b(Context context) {
        if (f11225d) {
            return;
        }
        if (context == null) {
            Logger.ww("AsusPushHelper", "context is null");
            return;
        }
        if (a() && i(context) && cn.jpush.android.c.b.a(context)) {
            f11224c = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f11224c ? "support " : "not support ");
        sb.append(f11222a);
        Logger.d("AsusPushHelper", sb.toString());
        f11225d = true;
    }

    public static void a(Context context, int i9) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("code", i9 + "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, String.valueOf(6));
            jSONObject.put(JThirdPlatFormInterface.KEY_PLUGIN_SDK_VER, JPushConstants.SDK_VERSION_NAME);
            jSONObject.put(JThirdPlatFormInterface.KEY_VENDOR_SDK_VER, b());
            bundle.putString(JThirdPlatFormInterface.KEY_EXTRA, jSONObject.toString());
            JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_SEND_EXCEPTION, bundle);
        } catch (Throwable unused) {
        }
    }

    private static boolean a() {
        boolean zEqualsIgnoreCase = "asus".equalsIgnoreCase(Build.BRAND);
        return !zEqualsIgnoreCase ? "asus".equalsIgnoreCase(Build.MANUFACTURER) : zEqualsIgnoreCase;
    }

    public static boolean a(Context context) {
        b(context);
        return f11224c;
    }
}
