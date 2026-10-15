package com.engagelab.privates.common;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, SharedPreferences> f12193a = new HashMap();

    public static void a(Context context, long j) {
        b(context).edit().putLong("key_in_app_last_show_time", j).apply();
    }

    public static SharedPreferences b(Context context) {
        String str = "com.engagelab.privates.push.prefs.in_app." + b0.a(context);
        SharedPreferences sharedPreferences = f12193a.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        f12193a.put(str, sharedPreferences2);
        return sharedPreferences2;
    }

    public static long a(Context context) {
        return b(context).getLong("key_in_app_last_show_time", -1L);
    }
}
