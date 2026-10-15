package com.llfbandit.record.service;

import G.n;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import cn.ikaile.ruoshui.client.R;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: AudioRecordingService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioRecordingService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f16347a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NotificationManager f16348b;

    /* JADX INFO: compiled from: AudioRecordingService.kt */
    public final class a extends Binder {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        k.e(intent, "intent");
        return this.f16347a;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Object systemService = getSystemService(RemoteMessageConst.NOTIFICATION);
        k.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.f16348b = (NotificationManager) systemService;
        NotificationChannel notificationChannel = new NotificationChannel("AudioRecordingChannel", "Audio Capture", 2);
        NotificationManager notificationManager = this.f16348b;
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        } else {
            k.i("notificationManager");
            throw null;
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        stopForeground(1);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i9, int i10) {
        if ((intent != null ? intent.getAction() : null) == null) {
            String stringExtra = intent != null ? intent.getStringExtra("title") : null;
            String stringExtra2 = intent != null ? intent.getStringExtra("content") : null;
            n nVar = new n(this, "AudioRecordingChannel");
            if (stringExtra == null) {
                stringExtra = "Audio Capture";
            }
            nVar.f2124e = n.b(stringExtra);
            nVar.f2125f = n.b(stringExtra2);
            nVar.f2117G.icon = R.drawable.ic_mic;
            nVar.f2118H = true;
            nVar.c(2, true);
            nVar.f2111A = 1;
            Notification notificationA = nVar.a();
            k.d(notificationA, "build(...)");
            startForeground(1, notificationA);
            NotificationManager notificationManager = this.f16348b;
            if (notificationManager == null) {
                k.i("notificationManager");
                throw null;
            }
            notificationManager.notify(1, notificationA);
        }
        return 2;
    }
}
