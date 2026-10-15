package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15930a = "aegis";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f15931b;

    public static long a(String str, long j, Context context) {
        return b(context).getLong(str, j);
    }

    public static synchronized SharedPreferences b(Context context) {
        try {
            if (f15931b == null) {
                f15931b = context.createDeviceProtectedStorageContext().getSharedPreferences(f15930a, 0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15931b;
    }

    public static int a(String str, int i9, Context context) {
        return b(context).getInt(str, i9);
    }

    public static String a(String str, String str2, Context context) {
        return b(context).getString(str, str2);
    }

    public static void a(String str, Context context) {
        b(context).edit().remove(str).apply();
    }

    public static void b(String str, long j, Context context) {
        b(context).edit().putLong(str, j).apply();
    }

    public static void a(Context context) {
        b(context).edit().clear().apply();
    }

    public static void b(String str, int i9, Context context) {
        b(context).edit().putInt(str, i9).apply();
    }

    public static void b(String str, String str2, Context context) {
        b(context).edit().putString(str, str2).apply();
    }
}
