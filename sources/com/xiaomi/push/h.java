package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import java.util.Set;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f17569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Boolean f534a;

    public interface a {
        int a(Context context);

        int a(String str, Context context);

        int a(String str, String str2, Context context);

        String a();

        String a(Context context, String str);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        Map<String, String> m456a(Context context, String str);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean m457a(Context context);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean m458a(Context context, String str);

        boolean a(Context context, String str, Set<String> set);
    }

    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);


        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final int f536a;

        b(int i9) {
            this.f536a = i9;
        }

        public int a() {
            return this.f536a;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m448a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, Http2.INITIAL_MAX_FRAME_SIZE);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m454b(Context context, String str) {
        a aVar = f17569a;
        return aVar != null && aVar.m458a(context, str);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static boolean m455c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            return m446a(context, str) == null;
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("check package is uninstall error, packageName or context is null");
        return true;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static String m453b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                return packageManager.getApplicationLabel(applicationInfo).toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return str;
    }

    public static String c(Context context, String str) {
        a aVar = f17569a;
        return aVar != null ? aVar.a(context, str) : "";
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, Http2.INITIAL_MAX_FRAME_SIZE);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static boolean a(Context context, String str, String str2) {
        Bundle bundle;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean(str2, false);
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.c.m9a("error occurred while getting metadata switch. throwable:" + th);
            }
            return false;
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("context|pkg|key is invalid while getting metadata switch");
        return false;
    }

    public static int b(Context context, String str) {
        ApplicationInfo applicationInfoM446a = m446a(context, str);
        if (applicationInfoM446a == null) {
            return 0;
        }
        int i9 = applicationInfoM446a.icon;
        return i9 == 0 ? applicationInfoM446a.logo : i9;
    }

    public static boolean b(Context context) {
        if (f534a == null) {
            a aVar = f17569a;
            f534a = Boolean.valueOf(aVar != null && aVar.m457a(context));
        }
        return f534a.booleanValue();
    }

    @TargetApi(19)
    public static b a(Context context, String str, boolean z8) {
        ApplicationInfo applicationInfo;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (str.equals(context.getPackageName())) {
                    applicationInfo = context.getApplicationInfo();
                } else {
                    applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
                }
                b bVarA = a(context, applicationInfo);
                b bVar = b.UNKNOWN;
                if (bVarA != bVar) {
                    return bVarA;
                }
                Integer num = (Integer) bh.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
                if (num == null) {
                    return bVar;
                }
                Integer num2 = (Integer) bh.a(context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
                int i9 = (Integer) bh.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
                int i10 = (Integer) bh.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
                com.xiaomi.channel.commonutils.logger.c.b("get app mode " + num2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i9 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i10);
                if (i9 == null) {
                    i9 = 0;
                }
                if (i10 == null) {
                    i10 = 1;
                }
                if (num2 != null) {
                    if (z8) {
                        return !num2.equals(i10) ? b.ALLOWED : b.NOT_ALLOWED;
                    }
                    return num2.equals(i9) ? b.ALLOWED : b.NOT_ALLOWED;
                }
                return b.UNKNOWN;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.c.m9a("get app op error " + th);
            }
        } else {
            return b.UNKNOWN;
        }
    }

    private static b a(Context context, ApplicationInfo applicationInfo) {
        Object systemService;
        Boolean boolValueOf;
        int i9 = Build.VERSION.SDK_INT;
        if (applicationInfo != null) {
            try {
                if (applicationInfo.packageName.equals(context.getPackageName())) {
                    boolValueOf = Boolean.valueOf(((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled());
                } else {
                    if (i9 >= 29) {
                        systemService = bh.a(context.getSystemService(RemoteMessageConst.NOTIFICATION), "getService", new Object[0]);
                    } else {
                        systemService = context.getSystemService("security");
                    }
                    boolValueOf = systemService != null ? (Boolean) bh.b(systemService, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid)) : null;
                }
                if (boolValueOf != null) {
                    return boolValueOf.booleanValue() ? b.ALLOWED : b.NOT_ALLOWED;
                }
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.m9a("are notifications enabled error " + e9);
            }
            return b.UNKNOWN;
        }
        return b.UNKNOWN;
    }

    public static void a(Context context, ApplicationInfo applicationInfo, boolean z8) {
        Object systemService;
        int i9 = Build.VERSION.SDK_INT;
        if (b.ALLOWED != a(context, applicationInfo)) {
            try {
                if (i9 >= 29) {
                    systemService = bh.a(context.getSystemService(RemoteMessageConst.NOTIFICATION), "getService", new Object[0]);
                } else {
                    systemService = context.getSystemService("security");
                }
                if (systemService != null) {
                    bh.b(systemService, "setNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid), Boolean.valueOf(z8));
                }
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.m9a("set notifications enabled error " + e9);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m452a(Context context, String str) {
        return a(context, str, (Set<String>) null);
    }

    public static boolean a(Context context, String str, Set<String> set) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (!k.m648a()) {
                return context.getPackageName().equals(str);
            }
            a aVar = f17569a;
            if (aVar != null && aVar.a(context, str, set)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m451a(Context context) {
        String strA = a();
        if (TextUtils.isEmpty(strA) || context == null) {
            return false;
        }
        return strA.equals(context.getPackageName());
    }

    public static String a() {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
        } else {
            processName = (String) bh.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        }
        return !TextUtils.isEmpty(processName) ? processName : "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static ApplicationInfo m446a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.c.m9a("not found app info ".concat(str));
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Drawable m447a(Context context, String str) {
        ApplicationInfo applicationInfoM446a = m446a(context, str);
        Drawable drawableLoadIcon = null;
        if (applicationInfoM446a != null) {
            try {
                drawableLoadIcon = applicationInfoM446a.loadIcon(context.getPackageManager());
                if (drawableLoadIcon == null) {
                    drawableLoadIcon = applicationInfoM446a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.m9a("get app icon drawable failed, " + e9);
            }
        }
        return drawableLoadIcon != null ? drawableLoadIcon : new ColorDrawable(0);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Map<String, String> m450a(Context context, String str) {
        a aVar = f17569a;
        if (aVar == null) {
            return null;
        }
        return aVar.m456a(context, str);
    }

    public static int a(Context context) {
        a aVar = f17569a;
        if (aVar == null || context == null) {
            return 0;
        }
        return aVar.a(context);
    }

    public static int a(String str, String str2, String str3, Context context) {
        a aVar;
        if (context == null) {
            return 0;
        }
        if (TextUtils.equals(str3, "com.xiaomi.xmsf") && b(context) && (aVar = f17569a) != null) {
            return aVar.a(str, str2, context);
        }
        return context.getResources().getIdentifier(str, str2, str3);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m449a(String str, Context context) {
        a aVar;
        return (TextUtils.equals(str, "com.xiaomi.xmsf") && b(context) && (aVar = f17569a) != null) ? aVar.a() : str;
    }

    public static int a(String str, Context context) {
        if (f17569a == null || context == null || TextUtils.isEmpty(str)) {
            return 2;
        }
        return f17569a.a(str, context);
    }
}
