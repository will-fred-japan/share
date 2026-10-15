package com.xiaomi.push;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes2.dex */
public class ag {
    public static boolean a(Context context) {
        try {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            return false;
        }
    }

    public static boolean b(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent intentRegisterReceiver = null;
        try {
            intentRegisterReceiver = Build.VERSION.SDK_INT >= 33 ? context.registerReceiver(null, intentFilter, null, null, 2) : context.registerReceiver(null, intentFilter, null, null);
        } catch (Exception unused) {
        }
        if (intentRegisterReceiver == null) {
            return false;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static boolean c(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            defpackage.f.q("Failed to get screen status, caused by ", "MobileStatus", th);
            return false;
        }
    }
}
