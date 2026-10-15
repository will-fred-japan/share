package com.xiaomi.push;

import android.content.Context;
import android.content.IntentFilter;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.push.service.receivers.PowerConnectionReceiver;

/* JADX INFO: loaded from: classes2.dex */
public final class fk {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String f432a = XMJobService.class.getCanonicalName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f17423a = 0;

    public interface a {
        long a();

        /* JADX INFO: renamed from: a */
        void mo388a();

        void a(boolean z8);

        /* JADX INFO: renamed from: a */
        boolean mo389a();

        /* JADX INFO: renamed from: b */
        void mo390b();
    }

    public static void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f431a = new fl(applicationContext);
            return;
        }
        if (t.m842d()) {
            b(applicationContext);
            f431a = new fm(applicationContext);
        } else if (t.m841c()) {
            f431a = new fn(applicationContext);
        } else {
            f431a = new fl(applicationContext);
        }
    }

    private static void b(Context context) {
        PowerConnectionReceiver powerConnectionReceiver = new PowerConnectionReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        n.a(context, powerConnectionReceiver, intentFilter, 2);
    }

    public static synchronized void b() {
        a aVar = f431a;
        if (aVar != null) {
            aVar.mo390b();
        }
    }

    public static synchronized void a(Context context, int i9) {
        try {
            if (!t.m841c() && !t.m842d()) {
                int i10 = f17423a;
                if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                    if (i9 == 2) {
                        f17423a = 2;
                    } else {
                        f17423a = 0;
                    }
                }
                int i11 = f17423a;
                if (i10 != i11 && i11 == 2) {
                    m391a();
                    f431a = new fr(context);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized long a() {
        a aVar = f431a;
        if (aVar == null) {
            return 0L;
        }
        return aVar.a();
    }

    public static synchronized void a(boolean z8) {
        if (f431a == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("timer is not initialized");
            return;
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("[Alarm] register alarm. (" + z8 + ")");
        f431a.a(z8);
        er.a().c();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized void m391a() {
        if (f431a == null) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("[Alarm] stop alarm.");
        f431a.mo388a();
        er.a().d();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized boolean m392a() {
        a aVar = f431a;
        if (aVar == null) {
            return false;
        }
        return aVar.mo389a();
    }
}
