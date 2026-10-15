package cn.jpush.android.helper;

import cn.jiguang.api.JCoreManager;

/* JADX INFO: loaded from: classes.dex */
public class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11402a = "[key-step]";

    private static void a(int i9, boolean z8, String str, String str2, Throwable th) {
        JCoreManager.onEvent(null, "JPush", 18, str, null, Integer.valueOf(i9), Boolean.valueOf(z8), str2, th);
    }

    public static void d(String str, String str2) {
        a(3, true, str, str2, null);
    }

    public static void dd(String str, String str2) {
        a(3, false, str, str2, null);
    }

    public static void e(String str, String str2) {
        a(6, true, str, str2, null);
    }

    public static void ee(String str, String str2) {
        a(6, false, str, str2, null);
    }

    public static void i(String str, String str2) {
        a(4, true, str, str2, null);
    }

    public static void ii(String str, String str2) {
        a(4, false, str, str2, null);
    }

    public static void kd(String str, String str2) {
        a(3, false, str, A.a.j(new StringBuilder(), f11402a, str2), null);
    }

    public static void ke(String str, String str2) {
        a(6, false, str, A.a.j(new StringBuilder(), f11402a, str2), null);
    }

    public static void ki(String str, String str2) {
        a(4, false, str, A.a.j(new StringBuilder(), f11402a, str2), null);
    }

    public static void kv(String str, String str2) {
        a(2, false, str, A.a.j(new StringBuilder(), f11402a, str2), null);
    }

    public static void kw(String str, String str2) {
        a(5, false, str, A.a.j(new StringBuilder(), f11402a, str2), null);
    }

    public static void v(String str, String str2) {
        a(2, true, str, str2, null);
    }

    public static void vv(String str, String str2) {
        a(2, false, str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void ww(String str, String str2) {
        a(5, false, str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        a(6, true, str, str2, th);
    }

    public static void ee(String str, String str2, Throwable th) {
        a(6, false, str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        a(5, true, str, str2, th);
    }

    public static void ww(String str, String str2, Throwable th) {
        a(5, false, str, str2, th);
    }

    public static void ke(String str, String str2, Throwable th) {
        a(6, false, str, A.a.j(new StringBuilder(), f11402a, str2), th);
    }

    public static void kw(String str, String str2, Throwable th) {
        a(5, false, str, A.a.j(new StringBuilder(), f11402a, str2), th);
    }
}
