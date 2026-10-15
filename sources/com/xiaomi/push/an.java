package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f17040a = false;

    private static void a(Class<?> cls, Context context) {
        if (f17040a) {
            return;
        }
        try {
            f17040a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.m9a("mdid:load lib error " + th);
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> clsA = t.a(context, "com.bun.miitmdid.core.JLibrary");
            if (clsA == null) {
                return false;
            }
            a(clsA, context);
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.m9a("mdid:check error " + th);
            return false;
        }
    }
}
