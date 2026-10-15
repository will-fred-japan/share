package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import cn.jiguang.q.g;
import cn.jiguang.x.f;

/* JADX INFO: loaded from: classes.dex */
public class DaemonService extends Service {
    private static final String TAG = "DaemonService";

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        g.a(getApplicationContext(), intent != null ? intent.getExtras() : null, 2);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f.c(TAG, "action onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        f.c(TAG, "action onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i9, int i10) {
        g.a(getApplicationContext(), intent != null ? intent.getExtras() : null, 1);
        return 2;
    }
}
