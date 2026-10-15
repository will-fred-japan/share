package com.apm.insight.log.a;

import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f11972a;

    public static void a(a aVar) {
        f11972a = aVar;
        a.a(aVar == null ? 0L : aVar.j());
    }

    public static void b() {
        a aVar = f11972a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static void c(String str, String str2) {
        a(2, str, str2);
    }

    public static void d(String str, String str2) {
        a(3, str, str2);
    }

    public static void e(String str, String str2) {
        a(4, str, str2);
    }

    public static long f() {
        a aVar = f11972a;
        if (aVar != null) {
            return aVar.e();
        }
        return 0L;
    }

    public static long g() {
        a aVar = f11972a;
        if (aVar != null) {
            return aVar.f();
        }
        return 0L;
    }

    public static long h() {
        a aVar = f11972a;
        if (aVar != null) {
            return aVar.g();
        }
        return 0L;
    }

    public static HashMap<String, String> c() {
        if (f11972a != null) {
            return a.h();
        }
        return null;
    }

    public static String d() {
        a aVar = f11972a;
        return aVar != null ? aVar.i() : "default log instance is null";
    }

    public static long e() {
        a aVar = f11972a;
        if (aVar != null) {
            return aVar.d();
        }
        return 0L;
    }

    public static void b(String str, String str2) {
        a(1, str, str2);
    }

    public static void a() {
        a.a(0L);
        f11972a.a();
        f11972a = null;
    }

    private static void a(int i9, String str, String str2) {
        a aVar = f11972a;
        if (aVar != null) {
            aVar.a(i9, str, str2);
        }
    }

    public static void a(int i9, String str, String str2, long j, long j8) {
        a aVar = f11972a;
        if (aVar != null) {
            aVar.a(i9, str, str2, j, j8);
        }
    }

    public static void a(int i9) {
        a aVar = f11972a;
        if (aVar != null) {
            aVar.b(i9);
        }
    }

    public static void a(boolean z8) {
        a aVar = f11972a;
        if (aVar != null) {
            aVar.a(z8);
        }
    }

    public static void a(String str, String str2) {
        a(0, str, str2);
    }

    public static File[] a(String str, String str2, long j, long j8) {
        a aVar = f11972a;
        if (aVar != null) {
            return aVar.a((String) null, (String) null, j, j8);
        }
        return new File[0];
    }

    public static File[] a(boolean z8, long j, long j8, int i9) {
        a aVar = f11972a;
        if (aVar != null) {
            return aVar.a(z8, j, j8, i9);
        }
        return new File[0];
    }
}
