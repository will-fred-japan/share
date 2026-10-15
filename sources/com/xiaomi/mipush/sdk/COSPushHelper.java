package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class COSPushHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f16939a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile boolean f26a = false;

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = f16939a;
            if (j <= 0 || j + 300000 <= jElapsedRealtime) {
                f16939a = jElapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f26a;
    }

    public static boolean hasNetwork(Context context) {
        return f.m58a(context);
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager abstractPushManagerA = e.a(context).a(d.ASSEMBLE_PUSH_COS);
        if (abstractPushManagerA != null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH :  register cos when network change!");
            abstractPushManagerA.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z8) {
        f26a = z8;
    }

    public static void uploadToken(Context context, String str) {
        f.m57a(context, d.ASSEMBLE_PUSH_COS, str);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }
}
