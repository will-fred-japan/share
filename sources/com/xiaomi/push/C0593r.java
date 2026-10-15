package com.xiaomi.push;

import android.text.TextUtils;

/* JADX INFO: renamed from: com.xiaomi.push.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0593r {
    public static String a(String str, String str2) {
        try {
            return (String) t.a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("SystemProperties.get: " + e9);
            return str2;
        }
    }

    public static String a(String str) {
        return a(str, "");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m661a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            t.a(null, "android.os.SystemProperties").getMethod("set", String.class, String.class).invoke(null, str, str2);
            return true;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("SystemProperties.set: " + e9);
            return false;
        }
    }
}
