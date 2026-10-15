package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.vivo.push.n;
import com.vivo.push.sdk.a;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.o;
import com.vivo.push.util.w;

/* JADX INFO: loaded from: classes.dex */
public class CommandService extends Service {
    public boolean a(String str) {
        return "com.vivo.pushservice.action.RECEIVE".equals(str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        w.c("CommandService", "onBind initSuc: ");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        w.c("CommandService", getClass().getSimpleName() + " -- oncreate " + getPackageName());
        super.onCreate();
        if (!a()) {
            w.b("CommandService", getClass().getSimpleName() + " -- onCreate " + getPackageName() + " device not match ");
            stopSelf();
        }
        a.a().a(ContextDelegate.getContext(getApplicationContext()));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i9, int i10) {
        w.c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
        if (intent == null) {
            stopSelf();
            return 2;
        }
        if (!a()) {
            w.b("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName() + " device not match ");
            stopSelf();
            return 2;
        }
        if (a(intent.getAction())) {
            try {
                a.a().a(getClass().getName());
                a.a().a(intent);
            } catch (Exception e9) {
                w.a("CommandService", "onStartCommand -- error", e9);
            }
            stopSelf();
            return 2;
        }
        w.a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    private boolean a() {
        try {
            if (n.a().k()) {
                return o.b();
            }
            w.c("CommandService", getClass().getSimpleName().concat(" -- isProcessingTasks isClose "));
            return true;
        } catch (Throwable th) {
            w.a("CommandService", "isProcessingTasks -- error", th);
            return true;
        }
    }
}
