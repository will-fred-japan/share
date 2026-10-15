package com.heytap.mcssdk.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14377a = "mcssdk---";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f14378b = "MCS";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f14379c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f14380d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f14381e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f14382f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f14383g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f14384h = "-->";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f14385i = true;

    public static String a() {
        return f14378b;
    }

    public static void b(String str) {
        if (f14381e && f14385i) {
            Log.d(f14377a, f14378b + f14384h + str);
        }
    }

    public static void c(String str) {
        if (f14380d && f14385i) {
            Log.i(f14377a, f14378b + f14384h + str);
        }
    }

    public static void d(String str) {
        if (f14382f && f14385i) {
            Log.w(f14377a, f14378b + f14384h + str);
        }
    }

    public static void e(String str) {
        if (f14383g && f14385i) {
            Log.e(f14377a, f14378b + f14384h + str);
        }
    }

    public static void f(String str) {
        f14378b = str;
    }

    public static void g(String str) {
        f14384h = str;
    }

    public static String h() {
        return f14384h;
    }

    public static void a(Exception exc) {
        if (!f14383g || exc == null) {
            return;
        }
        Log.e(f14377a, exc.getMessage());
    }

    public static void b(String str, String str2) {
        if (f14381e && f14385i) {
            Log.d(str, f14378b + f14384h + str2);
        }
    }

    public static void c(String str, String str2) {
        if (f14380d && f14385i) {
            Log.i(str, f14378b + f14384h + str2);
        }
    }

    public static void d(String str, String str2) {
        if (f14382f && f14385i) {
            Log.w(str, f14378b + f14384h + str2);
        }
    }

    public static void e(String str, String str2) {
        if (f14383g && f14385i) {
            Log.e(str, f14378b + f14384h + str2);
        }
    }

    public static void f(boolean z8) {
        f14385i = z8;
        boolean z9 = z8;
        f14379c = z9;
        f14381e = z9;
        f14380d = z9;
        f14382f = z9;
        f14383g = z9;
    }

    public static boolean g() {
        return f14385i;
    }

    public static void a(String str) {
        if (f14379c && f14385i) {
            Log.v(f14377a, f14378b + f14384h + str);
        }
    }

    public static void b(boolean z8) {
        f14381e = z8;
    }

    public static void c(boolean z8) {
        f14380d = z8;
    }

    public static void d(boolean z8) {
        f14382f = z8;
    }

    public static void e(boolean z8) {
        f14383g = z8;
    }

    public static boolean f() {
        return f14383g;
    }

    public static void a(String str, String str2) {
        if (f14379c && f14385i) {
            Log.v(str, f14378b + f14384h + str2);
        }
    }

    public static boolean b() {
        return f14379c;
    }

    public static boolean c() {
        return f14381e;
    }

    public static boolean d() {
        return f14380d;
    }

    public static boolean e() {
        return f14382f;
    }

    public static void a(String str, Throwable th) {
        if (f14383g) {
            Log.e(str, th.toString());
        }
    }

    public static void a(boolean z8) {
        f14379c = z8;
    }
}
