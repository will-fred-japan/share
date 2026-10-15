package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseService extends Service {
    private a mHandler;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<BaseService> f16938a;

        public a(WeakReference<BaseService> weakReference) {
            this.f16938a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what != 1001 || (weakReference = this.f16938a) == null || (baseService = weakReference.get()) == null) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.c.c("TimeoutHandler " + baseService.toString() + " kill self");
            if (!baseService.hasJob()) {
                baseService.stopSelf();
            } else {
                com.xiaomi.channel.commonutils.logger.c.c("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000L);
            }
        }
    }

    public abstract boolean hasJob();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i9) {
        super.onStart(intent, i9);
        if (this.mHandler == null) {
            this.mHandler = new a(new WeakReference(this));
        }
        this.mHandler.a();
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
