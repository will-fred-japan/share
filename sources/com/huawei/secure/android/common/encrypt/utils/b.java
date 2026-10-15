package com.huawei.secure.android.common.encrypt.utils;

import W5.e;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15799a = "SecurityComp10300301: ";

    public static void a(String str, String str2) {
    }

    public static void b(String str, String str2) {
        Log.e(a(str), str2);
    }

    public static void c(String str, String str2) {
        Log.i(a(str), str2);
    }

    public static void d(String str, String str2) {
        Log.v(a(str), str2);
    }

    public static void e(String str, String str2) {
        Log.w(a(str), str2);
    }

    public static void a(String str, String str2, Throwable th) {
        Log.e(a(str), str2, th);
    }

    private static String a(String str) {
        return e.l(f15799a, str);
    }
}
