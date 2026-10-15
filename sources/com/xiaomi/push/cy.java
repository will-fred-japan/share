package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class cy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile cy f17181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PendingIntent f229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final BroadcastReceiver f230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ConnectivityManager.NetworkCallback f232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private da f233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private WeakReference<gp> f234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final AtomicBoolean f235a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f17182b;

    private cy(Context context) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f17182b = atomicBoolean;
        this.f228a = -1;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.xiaomi.push.cy.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null || context2 == null) {
                    return;
                }
                try {
                    if ("com.xiaomi.push.PING_TIMER_TASK_trigger_cnt_stat".equals(intent.getAction()) && cy.this.f17182b.get()) {
                        cx.m185a().c(context2);
                        cy.this.m193a(context2);
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "Failed to trigger connect stat alarm: " + th.getMessage());
                }
            }
        };
        this.f230a = broadcastReceiver;
        try {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.c.m10a("ConnectStatsHelper", "init failed, context is null");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            this.f231a = applicationContext;
            atomicBoolean.set(m195a(applicationContext));
            if (atomicBoolean.get()) {
                b();
                cx.m185a().c(this.f231a);
                n.a(this.f231a, broadcastReceiver, new IntentFilter("com.xiaomi.push.PING_TIMER_TASK_trigger_cnt_stat"));
                m193a(this.f231a);
            }
            com.xiaomi.push.service.aq.a(this.f231a).a(new com.xiaomi.push.service.aq.a(hz.ConnectStatSwitch.a(), "connect_stat_switch") { // from class: com.xiaomi.push.cy.1
                @Override // com.xiaomi.push.service.aq.a
                public void onCallback() {
                    try {
                        cy cyVar = cy.this;
                        boolean zM195a = cyVar.m195a(cyVar.f231a);
                        if (cy.this.f17182b.compareAndSet(!zM195a, zM195a)) {
                            if (!zM195a) {
                                cy.this.c();
                                cy.this.b((gp) null);
                                cy.this.f231a.unregisterReceiver(cy.this.f230a);
                                cy cyVar2 = cy.this;
                                cyVar2.b(cyVar2.f231a);
                                return;
                            }
                            cy.this.b();
                            cx.m185a().m188a();
                            cy.this.a((gp) null);
                            n.a(cy.this.f231a, cy.this.f230a, new IntentFilter("com.xiaomi.push.PING_TIMER_TASK_trigger_cnt_stat"));
                            cy cyVar3 = cy.this;
                            cyVar3.m193a(cyVar3.f231a);
                        }
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "Failed to update connect stat switch: " + th.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "Failed to init connect stats helper: " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Context context = this.f231a;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                ConnectivityManager.NetworkCallback networkCallback = this.f232a;
                if (networkCallback != null) {
                    connectivityManager.unregisterNetworkCallback(networkCallback);
                    this.f232a = null;
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "exception occurred in removing network callback :" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        PendingIntent pendingIntent;
        if (context == null || (pendingIntent = this.f229a) == null) {
            return;
        }
        try {
            fo.a(context, pendingIntent);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "Failed to stop connect stat timer task: " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m193a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (this.f229a == null) {
                Intent intent = new Intent("com.xiaomi.push.PING_TIMER_TASK_trigger_cnt_stat");
                intent.setPackage("com.xiaomi.xmsf");
                if (Build.VERSION.SDK_INT >= 30) {
                    this.f229a = PendingIntent.getBroadcast(context, 0, intent, 167772160);
                } else {
                    this.f229a = PendingIntent.getBroadcast(context, 0, intent, 134217728);
                }
            }
            PendingIntent pendingIntent = this.f229a;
            if (pendingIntent == null) {
                return;
            }
            fo.a(context, pendingIntent);
            fo.a(context, 3, SystemClock.elapsedRealtime() + 2940000, this.f229a);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "Failed to start connect stat timer task: " + th.getMessage());
        }
    }

    public void b(gp gpVar) {
        if (gpVar == null) {
            try {
                WeakReference<gp> weakReference = this.f234a;
                gpVar = weakReference == null ? null : weakReference.get();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.c.b("ConnectStatsHelper", "stop connect stats error", th.getMessage());
                return;
            }
        }
        da daVar = this.f233a;
        if (daVar != null) {
            if (gpVar != null) {
                gpVar.b(daVar);
            }
            this.f233a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context context = this.f231a;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                    this.f235a.set(true);
                }
                if (this.f232a == null) {
                    ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.xiaomi.push.cy.3
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities2) {
                            super.onCapabilitiesChanged(network, networkCapabilities2);
                            boolean zB = ax.b(cy.this.f231a);
                            if (cy.this.f235a.compareAndSet(!zB, zB)) {
                                if (zB) {
                                    cx.m185a().m190b(cy.this.f231a);
                                } else {
                                    cx.m185a().m189a(cy.this.f231a);
                                }
                            }
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network) {
                            super.onLost(network);
                            if (cy.this.f235a.getAndSet(false)) {
                                cx.m185a().m189a(cy.this.f231a);
                            }
                        }
                    };
                    this.f232a = networkCallback;
                    connectivityManager.registerDefaultNetworkCallback(networkCallback);
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "exception occurred in adding network callback :" + th.getMessage());
            }
        }
    }

    public static cy a(Context context) {
        if (f17181a == null) {
            synchronized (cy.class) {
                try {
                    if (f17181a == null) {
                        f17181a = new cy(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17181a;
    }

    public void a(gp gpVar) {
        try {
            if (gpVar == null) {
                WeakReference<gp> weakReference = this.f234a;
                gpVar = weakReference == null ? null : weakReference.get();
            } else {
                this.f234a = new WeakReference<>(gpVar);
            }
            Context context = this.f231a;
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.c.m10a("ConnectStatsHelper", "start connect stats error, context is null");
                return;
            }
            if (m195a(context)) {
                if (this.f233a == null) {
                    this.f233a = new da(context);
                }
                if (gpVar != null) {
                    gpVar.a(this.f233a);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.b("ConnectStatsHelper", "start connect stats error", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m195a(Context context) {
        return context != null && k.m649a(context) && com.xiaomi.push.service.aq.a(context).a(hz.ConnectStatSwitch.a(), false);
    }

    public void a(int i9) {
        try {
            if (m195a(this.f231a)) {
                cx.m185a().a(this.f231a, System.currentTimeMillis(), i9, a(), this.f228a);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "onDisconnection occurred error: " + th.getMessage());
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m198a() {
        try {
            if (m195a(this.f231a)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                int iA = a();
                this.f228a = iA;
                cx.m185a().a(this.f231a, jCurrentTimeMillis, iA);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "onReconnection occurred error: " + th.getMessage());
        }
    }

    private int a() {
        try {
            ay ayVarM104a = ax.m104a();
            if (ayVarM104a != null) {
                return ayVarM104a.a();
            }
            return -1;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.c("ConnectStatsHelper", "getNetType occurred error: " + th.getMessage());
            return -1;
        }
    }
}
