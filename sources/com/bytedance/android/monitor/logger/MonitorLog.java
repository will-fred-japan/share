package com.bytedance.android.monitor.logger;

import android.text.TextUtils;
import android.util.Log;
import e1.a;

/* JADX INFO: loaded from: classes.dex */
public class MonitorLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f12006a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f12007b = false;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "hybrid_monitor";
        }
        return !str.startsWith("hybrid_monitor_") ? "hybrid_monitor_".concat(str) : str;
    }

    public static void d(String str, String str2) {
        if (isLogEnable()) {
            Log.d(a(str), str2);
        }
    }

    public static void e(String str, String str2) {
        Log.e(a(str), str2);
    }

    public static void i(String str, String str2) {
        if (isLogEnable()) {
            Log.i(a(str), str2);
        }
    }

    public static boolean isLogEnable() {
        return f12007b;
    }

    public static void setLogEnable(boolean z8) {
        f12007b = z8;
    }

    public static void v(String str, String str2) {
        if (isLogEnable()) {
            Log.v(a(str), str2);
        }
    }

    public static void w(String str, String str2) {
        if (isLogEnable()) {
            Log.w(a(str), str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isLogEnable()) {
            Log.e(a(str), str2, th);
        }
    }

    public static void setLogger(a aVar) {
    }
}
