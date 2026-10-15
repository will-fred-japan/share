package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.xiaomi.push.fk;

/* JADX INFO: loaded from: classes2.dex */
public class XMJobService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Service f18147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private IBinder f950a = null;

    @TargetApi(21)
    public static class a extends JobService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Binder f18148a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Handler f951a;

        /* JADX INFO: renamed from: com.xiaomi.push.service.XMJobService$a$a, reason: collision with other inner class name */
        public static class HandlerC0188a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            JobService f18149a;

            public HandlerC0188a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f18149a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                com.xiaomi.channel.commonutils.logger.c.m9a("Job finished " + jobParameters.getJobId());
                this.f18149a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    fk.a(false);
                }
            }
        }

        public a(Service service) {
            this.f18148a = null;
            this.f18148a = (Binder) com.xiaomi.push.bh.a((Object) this, "onBind", new Intent());
            com.xiaomi.push.bh.a((Object) this, AppAgent.ATTACH_BASE_CONTEXT, service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.c.m9a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f951a == null) {
                this.f951a = new HandlerC0188a(this);
            }
            Handler handler = this.f951a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.c.m9a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f950a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f950a = new a(this).f18148a;
        f18147a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f18147a = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i9, int i10) {
        int iOnStartCommand = super.onStartCommand(intent, i9, i10);
        if (com.xiaomi.push.k.m649a((Context) this)) {
            return iOnStartCommand;
        }
        return 2;
    }
}
