package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.vivo.push.PushClientConstants;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f18137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static long f935a;

    public static int a(Context context) {
        Bundle bundle;
        if (context != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - f935a) > 86400000) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(PushClientConstants.COM_ANDROID_SYSTEMUI, 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        f18137a = bundle.getInt("SupportForPushVersionCode");
                        f935a = jCurrentTimeMillis;
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.c.d("exception occurred in getting systemui support version, exception: " + th);
                }
            }
        }
        return f18137a;
    }

    public static boolean b(Context context) {
        return a(context) >= 3;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m662a(Context context) {
        return a(context) >= 2;
    }
}
