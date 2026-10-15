package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.framework.common.BundleUtil;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f18436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f1173a;

    public static void a(Context context) {
        f18436a = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m840b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.c.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            return false;
        }
    }

    private static String c() {
        String strA = C0593r.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(strA) && !strA.startsWith("ColorOS_")) {
            f1173a = "ColorOS_".concat(strA);
        }
        return f1173a;
    }

    private static String d() {
        String strA = C0593r.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(strA) && !strA.startsWith("FuntouchOS_")) {
            f1173a = "FuntouchOS_".concat(strA);
        }
        return f1173a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Context m835a() {
        return f18436a;
    }

    public static int a() {
        try {
            Class<?> clsA = a(null, "miui.os.Build");
            if (clsA.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return clsA.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String b() {
        String strA = C0593r.a("ro.build.version.emui", "");
        f1173a = strA;
        return strA;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static boolean m841c() {
        return "tv".equals(C0593r.a(com.heytap.mcssdk.utils.d.f14376d));
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public static boolean m842d() {
        return "XiaoAiTongXue".equals(Build.BRAND);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m839a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            return false;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m838a() {
        return TextUtils.equals((String) bh.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized String m836a() {
        try {
            String str = f1173a;
            if (str != null) {
                return str;
            }
            String strE = k.e();
            if (a() <= 0) {
                String strB = b();
                if (TextUtils.isEmpty(strB)) {
                    strB = c();
                    if (TextUtils.isEmpty(strB)) {
                        strB = d();
                        if (TextUtils.isEmpty(strB)) {
                            strE = String.valueOf(C0593r.a(SystemUtils.PRODUCT_BRAND, "Android") + BundleUtil.UNDERLINE_TAG + strE);
                        }
                    }
                    strE = strB;
                } else {
                    strE = strB;
                }
            }
            f1173a = strE;
            return strE;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static Class<?> a(Context context, String str) throws ClassNotFoundException {
        if (str != null && str.trim().length() != 0) {
            boolean z8 = context != null;
            if (z8 && Build.VERSION.SDK_INT >= 29) {
                try {
                    return context.getClassLoader().loadClass(str);
                } catch (Throwable unused) {
                }
            }
            try {
                return Class.forName(str);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.c.m9a("loadClass fail hasContext= " + z8 + ", errMsg = " + th.getLocalizedMessage());
                throw new ClassNotFoundException("loadClass fail ", th);
            }
        }
        throw new ClassNotFoundException("class is empty");
    }

    public static void a(Context context, int i9, String str, long j) {
        try {
            ((PowerManager) context.getSystemService("power")).newWakeLock(i9, str).acquire(j);
        } catch (Throwable th) {
            defpackage.f.q("Failed to acquire a wake lock, caused by ", "WakeLock", th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m837a() {
        final Context context = f18436a;
        if (context == null) {
            return;
        }
        if (!k.m649a(context)) {
            com.xiaomi.channel.commonutils.logger.c.m10a("Wi-Fi", "Cannot trigger wifi broadcast without xmsf");
        } else {
            ah.a(context).a(new Runnable() { // from class: com.xiaomi.push.t.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.xiaomi.channel.commonutils.logger.c.m9a("try to trigger the wifi digest broadcast.");
                        Object systemService = context.getSystemService("MiuiWifiService");
                        if (systemService != null) {
                            bh.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                        }
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.c.m10a("Wi-Fi", "Failed to trigger DIGEST_INFORMATION_CHANGED broadcast, because: " + th);
                    }
                }
            });
        }
    }
}
