package cn.jiguang.x;

import cn.jiguang.internal.JConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Integer, Set<String>> f10935a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f10936b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10937c = "[key-step]";

    public static void a(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 2, str2, null);
    }

    public static void b(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 2, str2, null);
    }

    public static void c(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 3, str2, null);
    }

    public static void d(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 3, str2, null);
    }

    public static void e(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 3, A.a.j(new StringBuilder(), f10937c, str2), null);
    }

    public static void f(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 4, str2, null);
    }

    public static void g(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 4, str2, null);
    }

    public static void h(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 4, A.a.j(new StringBuilder(), f10937c, str2), null);
    }

    public static void i(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 5, str2, null);
    }

    public static void j(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 5, str2, null);
    }

    public static void k(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 5, A.a.j(new StringBuilder(), f10937c, str2), null);
    }

    public static void l(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 6, str2, null);
    }

    public static void m(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 6, str2, null);
    }

    public static void n(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 6, A.a.j(new StringBuilder(), f10937c, str2), null);
    }

    public static void a(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, false, 3, str2, th);
    }

    public static void b(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, true, 5, str2, th);
    }

    public static void c(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, false, 5, str2, th);
    }

    public static void d(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, true, 6, str2, th);
    }

    public static void f(String str, String str2, Throwable th) {
        e(str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, false, 6, str2, th);
    }
}
