package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import java.net.Socket;

/* JADX INFO: loaded from: classes2.dex */
public class ex extends ew {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PendingIntent f413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f412a = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17408a = 540000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final BroadcastReceiver f414a = new BroadcastReceiver() { // from class: com.xiaomi.push.ex.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.xiaomi.push.PING_TIMER_TASK_trigger_md_ka".equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[IdleState] trigger task running.");
                if (ex.this.m366a().a(ex.class)) {
                    ex.this.a(new fb(), "intervalTrigger");
                }
            }
        }
    };

    private void i() {
        Context contextM835a = t.m835a();
        if (contextM835a == null) {
            return;
        }
        try {
            if (Math.abs(System.currentTimeMillis() - this.f412a) < 60000) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[IdleState] repeated trigger requests within 60 second.");
                return;
            }
            this.f412a = System.currentTimeMillis();
            if (this.f413a == null) {
                Intent intent = new Intent("com.xiaomi.push.PING_TIMER_TASK_trigger_md_ka");
                intent.setPackage("com.xiaomi.xmsf");
                if (Build.VERSION.SDK_INT >= 31) {
                    this.f413a = PendingIntent.getBroadcast(contextM835a, 0, intent, 1241513984);
                } else {
                    this.f413a = PendingIntent.getBroadcast(contextM835a, 0, intent, 134217728);
                }
            }
            if (this.f413a == null) {
                return;
            }
            j();
            int iC = ew.c();
            if (iC > 540000) {
                iC = 540000;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() + ((long) iC);
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[IdleState] reschedule delayed trigger task.delay time:" + (iC / 1000) + "s");
            fo.a(contextM835a, 2, jElapsedRealtime, this.f413a);
        } catch (Throwable th) {
            defpackage.f.q("[IdleState] exception occurred in executing trigger task, exception: ", "HwKaMgr", th);
        }
    }

    private void j() {
        PendingIntent pendingIntent;
        Context contextM835a = t.m835a();
        if (contextM835a == null || (pendingIntent = this.f413a) == null) {
            return;
        }
        try {
            fo.a(contextM835a, pendingIntent);
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[IdleState] cancel delayed trigger task.");
        } catch (Throwable th) {
            defpackage.f.q("[IdleState] exception occurred in canceling old trigger task, exception: ", "HwKaMgr", th);
        }
    }

    @Override // com.xiaomi.push.ew
    public void a(Socket socket) {
        i();
    }

    @Override // com.xiaomi.push.ew
    /* JADX INFO: renamed from: b */
    public void mo370b() {
        i();
    }

    @Override // com.xiaomi.push.ew
    /* JADX INFO: renamed from: c */
    public void mo372c() {
        i();
    }

    @Override // com.xiaomi.push.ew
    public void d() {
        i();
    }

    @Override // com.xiaomi.push.ew
    public void e() {
        a(new fc(), "stopPing");
    }

    @Override // com.xiaomi.push.ew
    public void f() {
        a(new fc(), "failTooMuch");
    }

    @Override // com.xiaomi.push.ew
    public void a(int i9, Exception exc, boolean z8) {
        a(new fc(), z8 ? "socketClosedHasMobileNet" : "socketClosedNoMobileNet");
    }

    @Override // com.xiaomi.push.ew
    public void b(boolean z8) {
        if (z8) {
            return;
        }
        a(new fc(), "configChange");
    }

    @Override // com.xiaomi.push.ew
    public void c(boolean z8) {
        if (z8) {
            return;
        }
        a(new fc(), "mobileNetworkDisconnected");
    }

    @Override // com.xiaomi.push.ew
    public void d(boolean z8) {
        if (z8) {
            a(new fc(), "fallDownChange");
        }
    }

    @Override // com.xiaomi.push.ew
    public void b(ew ewVar) {
        try {
            Context contextM835a = t.m835a();
            if (contextM835a == null) {
                return;
            }
            n.a(contextM835a, this.f414a, new IntentFilter("com.xiaomi.push.PING_TIMER_TASK_trigger_md_ka"));
            i();
        } catch (Throwable th) {
            defpackage.f.q("[IdleState] exception occurred in state switch from, exception: ", "HwKaMgr", th);
        }
    }

    @Override // com.xiaomi.push.ew
    public void a(boolean z8) {
        if (z8) {
            a(new fc(), "superPowerModeChange");
        }
    }

    @Override // com.xiaomi.push.ew
    public void a(ew ewVar) {
        BroadcastReceiver broadcastReceiver;
        try {
            j();
            Context contextM835a = t.m835a();
            if (contextM835a != null && (broadcastReceiver = this.f414a) != null) {
                contextM835a.unregisterReceiver(broadcastReceiver);
            }
        } catch (Throwable th) {
            defpackage.f.q("[IdleState] exception occurred in state switch to, exception: ", "HwKaMgr", th);
        }
    }

    @Override // com.xiaomi.push.ew
    /* JADX INFO: renamed from: a */
    public String mo367a() {
        return "IdleState";
    }
}
