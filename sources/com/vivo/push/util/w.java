package com.vivo.push.util;

/* JADX INFO: compiled from: LogUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f16904a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f16905b = ak.b("persist.sys.log.ctrl", "no").equals("yes");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f16906c;

    public static boolean a() {
        return f16905b;
    }

    public static boolean b() {
        return f16905b && f16906c;
    }

    public static int c(String str, String str2) {
        return f16904a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f16904a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f16904a.e(str, str2);
    }

    public static int a(String str, String str2) {
        return f16904a.a(str, str2);
    }

    public static void c(String str) {
        f16904a.c(str);
    }

    public static void d(String str) {
        if (f16905b) {
            f16904a.c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    public static void e(String str) {
        if (f16905b) {
            f16904a.c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    public static int a(String str, Throwable th) {
        return f16904a.a(str, th);
    }

    public static int b(String str, String str2) {
        return f16904a.b(str, str2);
    }

    public static int a(String str, String str2, Throwable th) {
        return f16904a.a(str, str2, th);
    }

    public static int b(String str, String str2, Throwable th) {
        return f16904a.b(str, str2, th);
    }

    public static void a(String str) {
        f16904a.a(str);
    }

    public static void b(String str) {
        f16904a.b(str);
    }

    public static void a(int i9, String str) {
        a("RunTimeException", "code: " + i9 + ", exceptionMsg: " + str);
    }
}
