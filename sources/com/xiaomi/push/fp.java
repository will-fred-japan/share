package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.service.XMJobService;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class fp implements fk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    JobScheduler f17425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Context f433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f434a = false;

    public fp(Context context) {
        this.f433a = context;
        this.f17425a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    public void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f433a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        com.xiaomi.channel.commonutils.logger.c.c("schedule Job = " + builder.build().getId() + " in " + j);
        this.f17425a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.fk.a
    public long a() {
        return gv.b();
    }

    @Override // com.xiaomi.push.fk.a
    public void a(boolean z8) {
        if (z8 || this.f434a) {
            long jB = gv.b();
            if (z8) {
                mo388a();
                jB -= SystemClock.elapsedRealtime() % jB;
            }
            this.f434a = true;
            a(jB);
        }
    }

    @Override // com.xiaomi.push.fk.a
    /* JADX INFO: renamed from: a */
    public void mo388a() {
        this.f434a = false;
        this.f17425a.cancel(1);
    }

    @Override // com.xiaomi.push.fk.a
    /* JADX INFO: renamed from: a */
    public boolean mo389a() {
        return this.f434a;
    }

    @Override // com.xiaomi.push.fk.a
    /* JADX INFO: renamed from: b */
    public void mo390b() {
    }
}
