package com.starburst.sdk.core.keepalive;

import G.C0316g;
import G.E;
import G.n;
import W5.e;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.starburst.sdk.utils.j;

/* JADX INFO: loaded from: classes.dex */
public class KeepAliveManager implements IKeepAlive {
    public static final String ACTION_KEEPALIVE_TICK = "com.starburst.sdk.keepalive.ACTION_TICK";
    private static final String ALARM_ACTION = "com.common.keepalive.ALARM_TRIGGER";
    private static final String CHANNEL_ID = "KeepAliveChannel";
    private static final String KEY_KEEP_ALIVE_ENABLED = "keep_alive_enabled";
    private static final String KEY_USER_CONFIRMED = "user_confirmed_auto_start";
    private static final int NOTIFICATION_ID = 1001;
    private static final String PREF_NAME = "keep_alive_pref";
    private static final String TAG = "KeepAliveManager";
    private static final long WAKE_LOCK_RENEW_INTERVAL_MS = 480000;
    private static final long WAKE_LOCK_TIMEOUT_MS = 600000;
    private static volatile KeepAliveManager instance;
    private volatile boolean foregroundServiceRunning;
    private volatile boolean foregroundServiceStartPending;
    private volatile boolean keepAliveEnabled;
    private NotificationConfig notificationConfig;
    private PowerManager.WakeLock wakeLock;
    private long wakeLockAcquiredAtElapsed;

    public static class AlarmReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (KeepAliveManager.ALARM_ACTION.equals(intent.getAction())) {
                try {
                    j.k(KeepAliveManager.TAG, "AlarmReceiver onReceive: ALARM_ACTION fired");
                } catch (Throwable unused) {
                }
                KeepAliveManager keepAliveManager = KeepAliveManager.getInstance();
                if (keepAliveManager.keepAliveEnabled) {
                    keepAliveManager.acquireWakeLock(context);
                    keepAliveManager.scheduleAlarms(context);
                    try {
                        Intent intent2 = new Intent(KeepAliveManager.ACTION_KEEPALIVE_TICK);
                        intent2.setPackage(context.getPackageName());
                        context.sendBroadcast(intent2);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public static class KeepAliveService extends Service {
        private static final long HEARTBEAT_INTERVAL_MS = 10000;
        private volatile boolean foregroundStarted;
        private Thread heartbeatThread;
        private volatile boolean heartbeatThreadRunning;

        private Notification buildEmergencyForegroundNotification() {
            NotificationChannel notificationChannel = new NotificationChannel("KeepAliveChannel_fb", "KeepAlive", 2);
            NotificationManager notificationManager = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
            n nVar = new n(this, "KeepAliveChannel_fb");
            nVar.f2117G.icon = R.drawable.stat_notify_sync;
            nVar.f2124e = n.b("Service");
            nVar.f2125f = n.b("Running");
            nVar.f2129k = -2;
            nVar.c(2, true);
            nVar.f2118H = true;
            Notification notificationA = nVar.a();
            notificationA.flags |= 2;
            return notificationA;
        }

        private Notification buildNotification(NotificationConfig notificationConfig, boolean z8) {
            PendingIntent activity;
            Intent launchIntentForPackage;
            if (!z8 || (launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName())) == null) {
                activity = null;
            } else {
                launchIntentForPackage.addFlags(805306368);
                activity = PendingIntent.getActivity(this, 0, launchIntentForPackage, 201326592);
            }
            n nVar = new n(this, notificationConfig.getChannelId());
            nVar.f2117G.icon = notificationConfig.getIconResId();
            nVar.f2124e = n.b(notificationConfig.getTitle());
            nVar.f2125f = n.b(notificationConfig.getContent());
            nVar.f2129k = -1;
            nVar.f2141x = "service";
            nVar.c(2, true);
            nVar.c(8, true);
            nVar.c(16, false);
            nVar.f2118H = true;
            nVar.f2130l = false;
            if (activity != null) {
                nVar.f2126g = activity;
            }
            Notification notificationA = nVar.a();
            notificationA.flags |= 34;
            return notificationA;
        }

        private void createNotificationChannel(NotificationConfig notificationConfig) {
            NotificationChannel notificationChannel = new NotificationChannel(notificationConfig.getChannelId(), notificationConfig.getChannelName(), notificationConfig.getImportance());
            NotificationManager notificationManager = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }

        private boolean ensureForegroundStarted() {
            if (this.foregroundStarted) {
                return true;
            }
            NotificationConfig safeNotificationConfig = KeepAliveManager.getInstance().getSafeNotificationConfig();
            createNotificationChannel(safeNotificationConfig);
            Notification notificationBuildNotification = buildNotification(safeNotificationConfig, true);
            int[] iArrForegroundServiceTypeCandidates = foregroundServiceTypeCandidates();
            for (int i9 : iArrForegroundServiceTypeCandidates) {
                if (tryStartForegroundWithTypes(notificationBuildNotification, i9)) {
                    this.foregroundStarted = true;
                    return true;
                }
            }
            Notification notificationBuildEmergencyForegroundNotification = buildEmergencyForegroundNotification();
            for (int i10 : iArrForegroundServiceTypeCandidates) {
                if (tryStartForegroundWithTypes(notificationBuildEmergencyForegroundNotification, i10)) {
                    this.foregroundStarted = true;
                    return true;
                }
            }
            try {
                j.i(KeepAliveManager.TAG, "ensureForegroundStarted: all startForeground attempts failed");
            } catch (Throwable unused) {
            }
            return false;
        }

        private void ensureHeartbeat() {
            if (this.heartbeatThreadRunning) {
                return;
            }
            this.heartbeatThreadRunning = true;
            Thread thread = new Thread(new D6.a(16, this), "KeepAliveHeartbeatThread");
            this.heartbeatThread = thread;
            thread.start();
        }

        @SuppressLint({"InlinedApi"})
        private static int[] foregroundServiceTypeCandidates() {
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 34) {
                return new int[]{145, 17, 1, 0};
            }
            if (i9 >= 30) {
                return new int[]{129, 1, 0};
            }
            return i9 >= 29 ? new int[]{1, 0} : new int[]{0};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$ensureHeartbeat$0() {
            while (this.heartbeatThreadRunning && KeepAliveManager.getInstance().keepAliveEnabled) {
                KeepAliveManager.getInstance().acquireWakeLock(getApplicationContext());
                try {
                    j.k(KeepAliveManager.TAG, "KeepAliveService heartbeat(thread): enabled=true");
                } catch (Throwable unused) {
                }
                try {
                    Intent intent = new Intent(KeepAliveManager.ACTION_KEEPALIVE_TICK);
                    intent.setPackage(getPackageName());
                    sendBroadcast(intent);
                } catch (Throwable unused2) {
                }
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException unused3) {
                } catch (Throwable unused4) {
                }
            }
            try {
                j.x(KeepAliveManager.TAG, "KeepAliveService heartbeat(thread) stopped, lastAlive=" + System.currentTimeMillis());
            } catch (Throwable unused5) {
            }
        }

        private boolean tryStartForegroundWithTypes(Notification notification, int i9) {
            try {
                if (i9 == 0) {
                    startForeground(1001, notification);
                    return true;
                }
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 34) {
                    C0316g.b(this, notification, i9);
                    return true;
                }
                if (i10 >= 29) {
                    E.a(this, notification, i9);
                    return true;
                }
                startForeground(1001, notification);
                return true;
            } catch (Throwable th) {
                try {
                    j.i(KeepAliveManager.TAG, "startForeground failed (typed): " + th.getMessage());
                } catch (Throwable unused) {
                }
                if (i9 == 0) {
                    return false;
                }
                try {
                    startForeground(1001, notification);
                    return true;
                } catch (Throwable th2) {
                    try {
                        j.i(KeepAliveManager.TAG, "startForeground failed (fallback 2-arg): " + th2.getMessage());
                        return false;
                    } catch (Throwable unused2) {
                        return false;
                    }
                }
            }
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            KeepAliveManager.getInstance().restoreKeepAliveEnabled(getApplicationContext());
            try {
                if (ensureForegroundStarted()) {
                    KeepAliveManager.getInstance().onServiceForegroundStarted();
                    j.k(KeepAliveManager.TAG, "KeepAliveService onCreate done foregroundStarted=" + this.foregroundStarted);
                } else {
                    KeepAliveManager.getInstance().onServiceStopped();
                    try {
                        j.i(KeepAliveManager.TAG, "KeepAliveService onCreate: all startForeground attempts failed, stopSelf to avoid ANR/crash");
                    } catch (Throwable unused) {
                    }
                    stopSelf();
                }
            } catch (Throwable unused2) {
            }
        }

        @Override // android.app.Service
        public void onDestroy() {
            KeepAliveManager.getInstance().onServiceStopped();
            try {
                j.k(KeepAliveManager.TAG, "KeepAliveService onDestroy keepAliveEnabled=" + KeepAliveManager.getInstance().keepAliveEnabled);
            } catch (Throwable unused) {
            }
            this.heartbeatThreadRunning = false;
            Thread thread = this.heartbeatThread;
            if (thread != null) {
                try {
                    thread.interrupt();
                } catch (Throwable unused2) {
                }
            }
            if (KeepAliveManager.getInstance().keepAliveEnabled) {
                KeepAliveManager.getInstance().scheduleAlarms(getApplicationContext());
            }
            super.onDestroy();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i9, int i10) {
            if (!ensureForegroundStarted()) {
                try {
                    j.i(KeepAliveManager.TAG, "KeepAliveService onStartCommand: startForeground failed, stopSelfResult");
                } catch (Throwable unused) {
                }
                stopSelfResult(i10);
                return 2;
            }
            try {
                j.k(KeepAliveManager.TAG, "KeepAliveService onStartCommand keepAliveEnabled=" + KeepAliveManager.getInstance().keepAliveEnabled);
            } catch (Throwable unused2) {
            }
            if (KeepAliveManager.getInstance().keepAliveEnabled) {
                ensureHeartbeat();
                return 1;
            }
            stopForeground(1);
            stopSelfResult(i10);
            return 2;
        }

        @Override // android.app.Service
        public void onTaskRemoved(Intent intent) {
            super.onTaskRemoved(intent);
            try {
                j.k(KeepAliveManager.TAG, "KeepAliveService onTaskRemoved keepAliveEnabled=" + KeepAliveManager.getInstance().keepAliveEnabled);
            } catch (Throwable unused) {
            }
            if (KeepAliveManager.getInstance().keepAliveEnabled) {
                KeepAliveManager.getInstance().scheduleAlarms(getApplicationContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"InvalidWakeLockTag"})
    public synchronized void acquireWakeLock(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") != 0) {
            j.f(TAG, "WAKE_LOCK 权限未授予，跳过 WakeLock 获取");
            return;
        }
        if (this.wakeLock == null) {
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "KeepAliveLock");
            this.wakeLock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.wakeLock.isHeld() && jElapsedRealtime - this.wakeLockAcquiredAtElapsed >= WAKE_LOCK_RENEW_INTERVAL_MS) {
            this.wakeLock.release();
        }
        if (!this.wakeLock.isHeld()) {
            this.wakeLock.acquire(600000L);
            this.wakeLockAcquiredAtElapsed = jElapsedRealtime;
            try {
                j.k(TAG, "acquireWakeLock: acquired/renewed for 10min");
            } catch (Throwable unused) {
            }
        }
    }

    private void cancelAlarms(Context context) {
        j.k(TAG, "cancelAlarms: no-op");
    }

    public static void checkAndPrompt(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (!getInstance().isIgnoringBatteryOptimizations(activity)) {
            showBatteryOptimizationDialog(activity);
        } else {
            if (activity.getSharedPreferences(PREF_NAME, 0).getBoolean(KEY_USER_CONFIRMED, false)) {
                return;
            }
            showConfirmDialog(activity);
        }
    }

    private static p177w5.b dialogBuilder(Activity activity) {
        return new p177w5.b(activity);
    }

    public static KeepAliveManager getInstance() {
        if (instance == null) {
            synchronized (KeepAliveManager.class) {
                try {
                    if (instance == null) {
                        instance = new KeepAliveManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NotificationConfig getSafeNotificationConfig() {
        NotificationConfig notificationConfig = this.notificationConfig;
        return notificationConfig != null ? notificationConfig : new NotificationConfig.Builder().setChannelId(CHANNEL_ID).setChannelName("Background Service").setTitle("Service Running").setContent("Keeping app alive").setIconResId(R.drawable.stat_notify_sync).build();
    }

    private static void jumpToAppDetailSetting(Activity activity) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(activity, "无法打开设置页面", 0).show();
        }
    }

    private static void jumpToAutoStartSetting(Activity activity) {
        String str;
        String str2;
        try {
            Intent intent = new Intent();
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(MTPushConstants.Manufacturer.XIAOMI)) {
                str = "com.miui.securitycenter";
                str2 = "com.miui.permcenter.autostart.AutoStartManagementActivity";
            } else if (lowerCase.contains(MTPushConstants.Manufacturer.HUAWEI)) {
                str = "com.huawei.systemmanager";
                str2 = "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity";
            } else {
                if (!lowerCase.contains(MTPushConstants.Manufacturer.OPPO)) {
                    if (lowerCase.contains(MTPushConstants.Manufacturer.VIVO)) {
                        str = "com.vivo.abe";
                        str2 = "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity";
                    }
                    jumpToAppDetailSetting(activity);
                }
                str = "com.coloros.safecenter";
                str2 = "com.coloros.safecenter.permission.startup.StartupAppListActivity";
            }
            intent.setClassName(str, str2);
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent);
                return;
            }
            jumpToAppDetailSetting(activity);
        } catch (Exception unused) {
            jumpToAppDetailSetting(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showBatteryOptimizationDialog$0(Activity activity, DialogInterface dialogInterface, int i9) {
        requestIgnoreBatteryOptimizations(activity);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showConfirmDialog$1(Activity activity, DialogInterface dialogInterface, int i9) {
        activity.getSharedPreferences(PREF_NAME, 0).edit().putBoolean(KEY_USER_CONFIRMED, true).apply();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showConfirmDialog$2(Activity activity, DialogInterface dialogInterface, int i9) {
        try {
            jumpToAutoStartSetting(activity);
        } catch (Exception unused) {
            jumpToAppDetailSetting(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onServiceForegroundStarted() {
        this.foregroundServiceRunning = true;
        this.foregroundServiceStartPending = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onServiceStopped() {
        this.foregroundServiceRunning = false;
        this.foregroundServiceStartPending = false;
    }

    private void persistKeepAliveEnabled(Context context, boolean z8) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(PREF_NAME, 0).edit().putBoolean(KEY_KEEP_ALIVE_ENABLED, z8).apply();
    }

    private synchronized void releaseWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null) {
            try {
                if (wakeLock.isHeld()) {
                    this.wakeLock.release();
                }
            } catch (Exception e9) {
                p199z2.b.l(e9, new StringBuilder("Release wake lock failed"), TAG);
            }
            this.wakeLock = null;
            this.wakeLockAcquiredAtElapsed = 0L;
        }
    }

    private static void requestIgnoreBatteryOptimizations(Activity activity) {
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivity(intent);
        } catch (Throwable unused) {
            jumpToAppDetailSetting(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreKeepAliveEnabled(Context context) {
        if (this.keepAliveEnabled || context == null) {
            return;
        }
        this.keepAliveEnabled = context.getSharedPreferences(PREF_NAME, 0).getBoolean(KEY_KEEP_ALIVE_ENABLED, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAlarms(Context context) {
        j.k(TAG, "scheduleAlarms: disabled for store compliance");
    }

    private static void showBatteryOptimizationDialog(Activity activity) {
        p177w5.b bVarDialogBuilder = dialogBuilder(activity);
        AlertController.b bVar = bVarDialogBuilder.f5947a;
        bVar.f5841d = "允许后台会议录音";
        bVar.f5843f = "为避免锁屏或长时间后台运行时 BLE 连接和录音被系统暂停，请允许应用忽略电池优化。";
        bVarDialogBuilder.e("去开启", new a(0, activity));
        bVarDialogBuilder.d("稍后", null);
        bVarDialogBuilder.a().show();
    }

    private static void showConfirmDialog(final Activity activity) {
        p177w5.b bVarDialogBuilder = dialogBuilder(activity);
        AlertController.b bVar = bVarDialogBuilder.f5947a;
        bVar.f5841d = "后台运行提示";
        bVar.f5843f = "为了保证应用在后台持续运行，请开启自动启动和忽略电池优化。\n您已经开启了吗？点击“已开启”将不再提示。";
        bVarDialogBuilder.e("已开启", new DialogInterface.OnClickListener() { // from class: com.starburst.sdk.core.keepalive.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i9) {
                KeepAliveManager.lambda$showConfirmDialog$1(activity, dialogInterface, i9);
            }
        });
        bVarDialogBuilder.d("去开启", new c(0, activity));
        bVarDialogBuilder.a().show();
    }

    private void startKeepAliveService(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        synchronized (this) {
            if (!this.foregroundServiceStartPending && !this.foregroundServiceRunning) {
                this.foregroundServiceStartPending = true;
                try {
                    context.startForegroundService(new Intent(context, (Class<?>) KeepAliveService.class));
                } catch (Throwable th) {
                    this.foregroundServiceStartPending = false;
                    j.i(TAG, "startKeepAliveService failed completely: " + th.getMessage());
                }
            }
        }
    }

    private void stopForegroundService(Context context) {
        try {
            context.stopService(new Intent(context, (Class<?>) KeepAliveService.class));
        } catch (Exception e9) {
            e.q(e9, "Stop foreground service failed", TAG);
        }
    }

    @Override // com.starburst.sdk.core.keepalive.IKeepAlive
    public boolean isIgnoringBatteryOptimizations(Context context) {
        return ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    @Override // com.starburst.sdk.core.keepalive.IKeepAlive
    public void jumpToSettings(Activity activity) {
        if (isIgnoringBatteryOptimizations(activity)) {
            jumpToAutoStartSetting(activity);
        } else {
            requestIgnoreBatteryOptimizations(activity);
        }
    }

    @Override // com.starburst.sdk.core.keepalive.IKeepAlive
    public void setNotificationConfig(NotificationConfig notificationConfig) {
        this.notificationConfig = notificationConfig;
    }

    @Override // com.starburst.sdk.core.keepalive.IKeepAlive
    public void startKeepAlive(Context context) {
        this.keepAliveEnabled = true;
        persistKeepAliveEnabled(context, true);
        try {
            StringBuilder sb = new StringBuilder("startKeepAlive: keepAliveEnabled=true, pkg=");
            sb.append(context != null ? context.getPackageName() : "null");
            j.k(TAG, sb.toString());
        } catch (Throwable unused) {
        }
        startKeepAliveService(context);
        acquireWakeLock(context);
        scheduleAlarms(context);
    }

    @Override // com.starburst.sdk.core.keepalive.IKeepAlive
    public void stopKeepAlive(Context context) {
        this.keepAliveEnabled = false;
        persistKeepAliveEnabled(context, false);
        try {
            StringBuilder sb = new StringBuilder("stopKeepAlive: keepAliveEnabled=false, pkg=");
            sb.append(context != null ? context.getPackageName() : "null");
            j.k(TAG, sb.toString());
        } catch (Throwable unused) {
        }
        if (!this.foregroundServiceStartPending) {
            stopForegroundService(context);
        }
        releaseWakeLock();
        cancelAlarms(context);
    }
}
