package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: loaded from: classes2.dex */
public class dd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f17192a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static dg.a f239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static dh f240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f241a;

    public static void a(XMPushService xMPushService, gp gpVar) {
        if (m223a((Context) xMPushService)) {
            if (f240a == null) {
                f240a = new dh(xMPushService);
            }
            gpVar.a(f240a);
            if (f239a == null) {
                f239a = new dg.a(xMPushService);
            }
            xMPushService.a(f239a);
            a("startStats");
        }
    }

    public static void b(XMPushService xMPushService, gp gpVar) {
        dh dhVar = f240a;
        if (dhVar != null) {
            gpVar.b(dhVar);
            f240a = null;
        }
        dg.a aVar = f239a;
        if (aVar != null) {
            xMPushService.b(aVar);
            f239a = null;
        }
        a("stopStats");
    }

    public static void b(Context context) {
        dg.m233a(context);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m223a(Context context) {
        return cz.a(context) || "com.mitv.tvhome".equals(context.getPackageName()) || "com.xiaomi.micolauncher".equals(context.getPackageName());
    }

    private static synchronized void b(String str) {
        try {
            if ("WIFI-ID-UNKNOWN".equals(str)) {
                String str2 = f241a;
                if (str2 == null || !str2.startsWith("W-")) {
                    f241a = null;
                }
            } else {
                f241a = str;
            }
            a("updateNetId new networkId = " + str + ", finally netId = " + f241a);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void a(Context context, String str, int i9) {
        if (!m223a(context)) {
            a("onDisconnection shouldSampling = false");
            return;
        }
        dg.a(context, str, ax.b(context), System.currentTimeMillis(), i9, fk.a(), com.xiaomi.push.service.p.a(context).m807a(), a(context), m221a(), f17192a);
        a("onDisconnection");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m222a(Context context) {
        if (!m223a(context)) {
            a("onReconnection shouldSampling = false");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        f17192a = a(context);
        dg.a(context, jCurrentTimeMillis);
        a("onReconnection connectedNetworkType = " + f17192a);
    }

    public static void a(Context context, String str) {
        if (!m223a(context)) {
            a("onWifiChanged shouldSampling = false");
            return;
        }
        a("onWifiChanged wifiDigest = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(W5.e.l("W-", str));
    }

    public static int a() {
        return f17192a;
    }

    public static int a(Context context) {
        String str;
        try {
            ay ayVarM104a = ax.m104a();
            if (ayVarM104a != null) {
                if (ayVarM104a.a() == 0) {
                    String strM118b = ayVarM104a.m118b();
                    if (TextUtils.isEmpty(strM118b) || GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(strM118b)) {
                        str = null;
                    } else {
                        str = "M-" + strM118b;
                    }
                    b(str);
                    return 0;
                }
                if (ayVarM104a.a() != 1 && ayVarM104a.a() != 6) {
                    b((String) null);
                    return -1;
                }
                b("WIFI-ID-UNKNOWN");
                return 1;
            }
            b((String) null);
            return -1;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.d("DisconnectStatsHelper getNetType occurred error: " + e9.getMessage());
            b((String) null);
            return -1;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static synchronized String m221a() {
        return f241a;
    }

    public static void a(String str) {
        cz.a("Push-DiscntStats", str);
    }
}
