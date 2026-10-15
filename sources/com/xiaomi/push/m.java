package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {
    public static void a(Context context) {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m659a(Context context, String str, boolean z8) {
        a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z8);
    }

    public static void a(Context context, String str, boolean z8) {
        a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z8).commit();
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        map.put(str, str2);
    }
}
