package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
abstract class fj implements fk.a {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Context f429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected final fq f430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PendingIntent f428a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile long f17421a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f17422b = 0;

    public fj(Context context, fq fqVar) {
        this.f429a = null;
        this.f429a = context;
        this.f430a = fqVar;
    }

    private long b() {
        return this.f430a.a();
    }

    public void a(boolean z8, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (z8 || this.f17421a == 0) {
            this.f17421a = (j - (jElapsedRealtime % j)) + jElapsedRealtime;
        } else if (this.f17421a <= jElapsedRealtime) {
            this.f17421a += j;
            if (this.f17421a < jElapsedRealtime) {
                this.f17421a = jElapsedRealtime + j;
            }
        }
    }

    @Override // com.xiaomi.push.fk.a
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void mo390b() {
        long jA = a();
        StringBuilder sbH = defpackage.f.h(jA, "refreshPingInterval, newInterval=", ", former mHBInterval= ");
        sbH.append(this.f17422b);
        com.xiaomi.channel.commonutils.logger.c.e(sbH.toString());
        if (this.f17422b != jA) {
            com.xiaomi.channel.commonutils.logger.c.e("HB interval change from " + this.f17422b + " to " + jA + ", force restart");
            a(true);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Intent mo387a() {
        Intent intent = new Intent(com.xiaomi.push.service.ay.t);
        intent.setPackage(this.f429a.getPackageName());
        return intent;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f429a.getSystemService("alarm");
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 31) {
            this.f428a = PendingIntent.getBroadcast(this.f429a, 0, intent, 33554432);
        } else {
            this.f428a = PendingIntent.getBroadcast(this.f429a, 0, intent, 0);
        }
        if (i9 >= 31 && !k.m649a(this.f429a)) {
            alarmManager.set(2, j, this.f428a);
        } else {
            bh.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f428a);
        }
        StringBuilder sbH = defpackage.f.h(j, "[Alarm] register timer ", ", delta=");
        sbH.append(j - SystemClock.elapsedRealtime());
        sbH.append("ms");
        com.xiaomi.channel.commonutils.logger.c.c(sbH.toString());
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.d("[Alarm] invoke setExact method meet error. " + e9);
        }
    }

    @Override // com.xiaomi.push.fk.a
    public final long a() {
        return this.f430a.mo795b();
    }

    @Override // com.xiaomi.push.fk.a
    public final void a(boolean z8) {
        long jB = b();
        if (z8 || this.f17421a != 0) {
            this.f17422b = jB;
            if (z8) {
                mo388a();
            }
            a(z8, jB);
            com.xiaomi.channel.commonutils.logger.c.e("registerPing, firstPing=" + z8 + ", interval=" + jB + ", nextTime=" + this.f17421a);
            a(mo387a(), this.f17421a);
        }
    }

    @Override // com.xiaomi.push.fk.a
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void mo388a() {
        if (this.f428a != null) {
            try {
                ((AlarmManager) this.f429a.getSystemService("alarm")).cancel(this.f428a);
            } catch (Exception unused) {
            } finally {
                this.f428a = null;
                com.xiaomi.channel.commonutils.logger.c.c("[Alarm] unregister timer");
                this.f17421a = 0L;
            }
        }
        this.f17421a = 0L;
    }

    @Override // com.xiaomi.push.fk.a
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean mo389a() {
        return this.f17421a != 0;
    }
}
