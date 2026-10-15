package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bh;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f16979a = -1;

    public static q a(Context context) {
        if (m63a(context)) {
            return q.HUAWEI;
        }
        if (c(context)) {
            return q.OPPO;
        }
        return d(context) ? q.VIVO : q.OTHER;
    }

    public static boolean b(Context context) {
        Object objA = bh.a(bh.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object objA2 = bh.a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (objA2 == null || !(objA2 instanceof Integer)) {
            com.xiaomi.channel.commonutils.logger.c.c("google service is not avaliable");
            f16979a = 0;
            return false;
        }
        int iIntValue = ((Integer) Integer.class.cast(objA2)).intValue();
        if (objA != null) {
            if (objA instanceof Integer) {
                f16979a = ((Integer) Integer.class.cast(objA)).intValue() == iIntValue ? 1 : 0;
            } else {
                f16979a = 0;
                com.xiaomi.channel.commonutils.logger.c.c("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder("is google service can be used");
        sb.append(f16979a > 0);
        com.xiaomi.channel.commonutils.logger.c.c(sb.toString());
        return f16979a > 0;
    }

    public static boolean c(Context context) {
        Object objA = bh.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        boolean zBooleanValue = (objA == null || !(objA instanceof Boolean)) ? false : ((Boolean) Boolean.class.cast(objA)).booleanValue();
        com.xiaomi.channel.commonutils.logger.c.c("color os push  is avaliable ? :" + zBooleanValue);
        return zBooleanValue;
    }

    public static boolean d(Context context) {
        Object objA = bh.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        boolean zBooleanValue = (objA == null || !(objA instanceof Boolean)) ? false : ((Boolean) Boolean.class.cast(objA)).booleanValue();
        com.xiaomi.channel.commonutils.logger.c.c("fun touch os push  is avaliable ? :" + zBooleanValue);
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m63a(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) != null && a();
        } catch (Throwable unused) {
        }
    }

    private static boolean a() {
        try {
            String str = (String) bh.a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            return !TextUtils.isEmpty(str) && Integer.parseInt(str) >= 9;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            return false;
        }
    }
}
