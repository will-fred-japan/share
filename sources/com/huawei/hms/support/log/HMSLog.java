package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AndroidException;
import com.huawei.hms.base.log.a;
import com.huawei.hms.base.log.b;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public class HMSLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f15565a = new b();

    private static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), Http2.INITIAL_MAX_FRAME_SIZE);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (AndroidException | RuntimeException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    public static void d(String str, String str2) {
        f15565a.a(3, str, str2);
    }

    public static void e(String str, String str2) {
        f15565a.a(6, str, str2);
    }

    public static void i(String str, String str2) {
        f15565a.a(4, str, str2);
    }

    public static void init(Context context, int i9, String str) {
        b bVar = f15565a;
        bVar.a(context, i9, str);
        bVar.a(str, "============================================================================\n====== " + a(context) + "\n============================================================================");
    }

    public static boolean isErrorEnable() {
        return f15565a.a(6);
    }

    public static boolean isInfoEnable() {
        return f15565a.a(4);
    }

    public static boolean isWarnEnable() {
        return f15565a.a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z8) {
        if (hMSExtLogger == null) {
            throw new IllegalArgumentException("extLogger is not able to be null");
        }
        a aVar = new a(hMSExtLogger);
        if (z8) {
            f15565a.a(aVar);
        } else {
            f15565a.a().a(aVar);
        }
    }

    public static void w(String str, String str2) {
        f15565a.a(5, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        f15565a.b(6, str, str2, th);
    }

    public static void e(String str, long j, String str2) {
        f15565a.a(6, str, "[" + j + "] " + str2);
    }

    public static void e(String str, long j, String str2, Throwable th) {
        f15565a.b(6, str, "[" + j + "] " + str2, th);
    }
}
