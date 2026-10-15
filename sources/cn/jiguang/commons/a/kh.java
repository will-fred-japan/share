package cn.jiguang.commons.a;

import android.app.AppOpsManager;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class kh {
    public static boolean a() {
        if (Build.VERSION.SDK_INT <= 28) {
            return a("android.permission.READ_EXTERNAL_STORAGE") || a("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return false;
    }

    public static boolean b() {
        try {
            return Build.VERSION.SDK_INT < 30 || jg.a().getApplicationInfo().targetSdkVersion < 30 || b("android.permission.QUERY_ALL_PACKAGES");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c() {
        return a("android.permission.ACCESS_FINE_LOCATION") || a("android.permission.ACCESS_COARSE_LOCATION");
    }

    public static boolean a(String str) {
        try {
            if (jg.a().getApplicationInfo().targetSdkVersion >= 23) {
                return jg.a().checkSelfPermission(str) == 0;
            }
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            return strPermissionToOp == null || ((AppOpsManager) jg.a().getSystemService("appops")).noteProxyOpNoThrow(strPermissionToOp, jg.a().getPackageName()) == 0;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("checkPermission error: "), "PermissionUtils");
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            PackageInfo packageInfoA = kg.a();
            if (packageInfoA != null) {
                for (String str2 : packageInfoA.requestedPermissions) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("hasPermissionDefined error: "), "PermissionUtils");
        }
        return false;
    }
}
