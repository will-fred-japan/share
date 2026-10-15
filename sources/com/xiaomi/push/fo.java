package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    public static void a(Context context, int i9, long j, PendingIntent pendingIntent) {
        if (context == null || pendingIntent == null) {
            return;
        }
        try {
            bh.a(context.getSystemService("alarm"), "setExactAndAllowWhileIdle", Integer.valueOf(i9), Long.valueOf(j), pendingIntent);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.d("[IdleState] exception occurred in setting alarm task, exception: " + th);
        }
    }

    public static void a(Context context, PendingIntent pendingIntent) {
        if (context == null || pendingIntent == null) {
            return;
        }
        try {
            ((AlarmManager) context.getSystemService("alarm")).cancel(pendingIntent);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.d("[IdleState] exception occurred in canceling task, exception: " + th);
        }
    }
}
