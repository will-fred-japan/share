package cn.ikaile.ruoshui.client.foreground;

import G.m;
import G.n;
import R3.a;
import R3.h;
import S3.b;
import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import cn.ikaile.ruoshui.client.MainActivity;
import java.util.HashMap;
import p096m7.d;

/* JADX INFO: loaded from: classes.dex */
public final class TaskForegroundService extends Service {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f8794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f8795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f8796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static TaskForegroundService f8797g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f8801l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8802a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f8792b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f8793c = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f8798h = "RoseLink";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f8799i = "";
    public static String j = "Device status";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f8800k = "Earphone battery and active device tasks";

    public static Notification b(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        NotificationChannel notificationChannel = new NotificationChannel("device_status", j, 2);
        notificationChannel.setDescription(f8800k);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        notificationChannel.setShowBadge(false);
        notificationManager.createNotificationChannel(notificationChannel);
        PendingIntent activity = PendingIntent.getActivity(context, 1001, new Intent(context, (Class<?>) MainActivity.class).addFlags(603979776), 201326592);
        int identifier = context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName());
        n nVar = new n(context, "device_status");
        if (identifier == 0) {
            identifier = R.drawable.stat_sys_upload_done;
        }
        nVar.f2117G.icon = identifier;
        nVar.f2124e = n.b(f8798h);
        nVar.f2125f = n.b(f8799i);
        nVar.f2126g = activity;
        m mVar = new m();
        mVar.f2110e = n.b(f8799i);
        nVar.d(mVar);
        nVar.c(2, true);
        nVar.c(16, false);
        nVar.c(8, true);
        nVar.f2130l = false;
        nVar.f2129k = -1;
        nVar.f2118H = true;
        nVar.f2141x = "status";
        return nVar.a();
    }

    public static boolean c(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        if (!notificationManager.areNotificationsEnabled()) {
            return false;
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("device_status");
        return notificationChannel == null || notificationChannel.getImportance() != 0;
    }

    public static void d(Context context, long j8) {
        long j9 = f8794d;
        if (j8 != j9) {
            return;
        }
        f8796f = null;
        f8795e = false;
        f8794d = j9 + 1;
        f8801l = false;
        g(context);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).cancel(1001);
        b bVar = f8793c;
        bVar.f4114e = false;
        bVar.f4115f = false;
        bVar.f4111b = "stopped";
    }

    public static void e(Context context, long j8, String str, String str2) {
        b bVar = f8793c;
        if (bVar.f4110a == j8) {
            bVar.f4111b = "failed";
            bVar.f4116g = str;
            bVar.f4117h = str2;
            bVar.f4112c = bVar.f4114e;
            bVar.f4113d = bVar.f4115f;
        }
        f();
        b bVar2 = f8793c;
        if (bVar2.f4114e || bVar2.f4115f) {
            return;
        }
        g(context);
        h(context);
    }

    public static void f() {
        a aVar = f8796f;
        if (aVar != null) {
            HashMap mapA = f8793c.a();
            d.b.a aVar2 = ((h) aVar.f3990b).f4005d;
            if (aVar2 != null) {
                aVar2.success(mapA);
            }
        }
    }

    public static void g(Context context) {
        TaskForegroundService taskForegroundService = f8797g;
        if (taskForegroundService != null) {
            f8797g = null;
            taskForegroundService.stopForeground(1);
            taskForegroundService.stopSelf();
        }
        context.stopService(new Intent(context, (Class<?>) TaskForegroundService.class));
    }

    public static void h(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        if (f8801l && c(context)) {
            notificationManager.notify(1001, b(context));
        } else {
            notificationManager.cancel(1001);
        }
    }

    public final void a() {
        if (this.f8802a == f8794d && "starting".equals(f8793c.f4111b)) {
            long j8 = f8793c.f4110a;
            try {
                Notification notificationB = b(this);
                b bVar = f8793c;
                int i9 = bVar.f4112c ? 16 : 0;
                if (bVar.f4113d && Build.VERSION.SDK_INT >= 30) {
                    i9 |= 128;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    startForeground(1001, notificationB, i9);
                } else {
                    startForeground(1001, notificationB);
                }
                b bVar2 = f8793c;
                if (bVar2.f4110a == j8 && "starting".equals(bVar2.f4111b)) {
                    bVar2.f4114e = bVar2.f4112c;
                    bVar2.f4115f = bVar2.f4113d;
                    bVar2.f4111b = "running";
                }
                f();
            } catch (RuntimeException e9) {
                e(this, j8, "FOREGROUND_START_FAILED", e9.toString());
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        if (f8797g == this) {
            f8797g = null;
            if (this.f8802a == f8794d) {
                b bVar = f8793c;
                bVar.f4114e = false;
                bVar.f4115f = false;
                bVar.f4111b = "stopped";
                f();
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i9, int i10) {
        long longExtra = intent != null ? intent.getLongExtra("engine", -1L) : -1L;
        if (longExtra != f8794d || !"starting".equals(f8793c.f4111b)) {
            if (f8797g != this) {
                stopSelfResult(i10);
            }
            return 2;
        }
        this.f8802a = longExtra;
        f8797g = this;
        a();
        return 2;
    }
}
