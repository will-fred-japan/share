package com.engagelab.privates.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.engagelab.privates.common.global.MTGlobal;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, SharedPreferences> f12243a = new HashMap();

    public static String a(Context context) {
        return c(context).getString("platform_token_fail", "");
    }

    public static int b(Context context) {
        return c(context).getInt("platform_token_fail_from", 0);
    }

    public static SharedPreferences c(Context context) {
        String str = "com.engagelab.privates.push.prefs.platform." + MTGlobal.getAppKey(context);
        SharedPreferences sharedPreferences = f12243a.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        f12243a.put(str, sharedPreferences2);
        return sharedPreferences2;
    }

    public static void a(Context context, String str) {
        c(context).edit().putString("platform_token_fail", str).commit();
    }

    public static void a(Context context, int i9) {
        c(context).edit().putInt("platform_token_fail_from", i9).commit();
    }
}
