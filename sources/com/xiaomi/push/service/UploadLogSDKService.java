package com.xiaomi.push.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.by;
import com.xiaomi.push.bz;
import com.xiaomi.push.service.logupload.LogUploadFileProvider;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class UploadLogSDKService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.logupload.b f945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final AtomicBoolean f946a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final by.a f18142a = new by.a() { // from class: com.xiaomi.push.service.UploadLogSDKService.2
        @Override // com.xiaomi.push.by
        public void a(final Bundle bundle, final bz bzVar) {
            if (!UploadLogSDKService.this.f946a.compareAndSet(false, true)) {
                com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "New request come when another log retrieval is in progress.");
            } else {
                final int callingUid = Binder.getCallingUid();
                com.xiaomi.push.ba.a("uploadLog", new Runnable() { // from class: com.xiaomi.push.service.UploadLogSDKService.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UploadLogSDKService.this.a(bundle, bzVar, callingUid);
                    }
                }, false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            c();
            stopSelf();
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.c("UploadLogSDKService", "cleanup failed: " + e9.getMessage() + "when cleanupTemporaryFiles.");
        } finally {
            Process.killProcess(Process.myPid());
        }
    }

    private void c() {
        try {
            File cacheDir = getCacheDir();
            if (cacheDir != null && cacheDir.exists()) {
                File file = new File(cacheDir, "push_log_upload");
                if (!file.exists()) {
                    com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "uploadDir not exist when cleanupTemporaryFiles.");
                    return;
                } else {
                    if (com.xiaomi.push.service.logupload.a.a(file)) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "Failed to clear upload directory when cleanupTemporaryFiles.");
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "cacheDir not exist when cleanupTemporaryFiles.");
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.c("UploadLogSDKService", "cleanup temporary files failed: " + e9.getMessage() + "when cleanupTemporaryFiles.");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a();
        return this.f18142a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f945a = new com.xiaomi.push.service.logupload.b(getApplicationContext());
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        com.xiaomi.push.ba.a("delayFiveSeconds", new Runnable() { // from class: com.xiaomi.push.service.UploadLogSDKService.1
            @Override // java.lang.Runnable
            public void run() {
                com.xiaomi.channel.commonutils.logger.c.c("UploadLogSDKService", "unbind timeout when upload log, clean up resources and kill process");
                UploadLogSDKService.this.b();
            }
        }, 2L, TimeUnit.SECONDS);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle, bz bzVar, int i9) {
        Exception exc;
        try {
            try {
                if (!com.xiaomi.push.service.logupload.c.a(this, i9)) {
                    com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "Caller is not market when handleGetCompressedLogUri.");
                    a(bzVar, (Uri) null, 302);
                    return;
                }
                a(bzVar, 3002);
                if (bundle == null) {
                    com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "bundle is null when handleGetCompressedLogUri.");
                    a(bzVar, (Uri) null, 301);
                    return;
                }
                String string = bundle.getString("retrievalId");
                long j = bundle.getLong("timestamp", 0L);
                long j8 = bundle.getLong("maxFileSize", 5242880L);
                try {
                    if (TextUtils.isEmpty(string) || j <= 0) {
                        com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "retrievalId or timestamp is invalid when handleGetCompressedLogUri.");
                        a(bzVar, (Uri) null, 301);
                        return;
                    }
                    File fileA = this.f945a.a(string, j, j8, bzVar);
                    if (fileA == null) {
                        int iM789a = this.f945a.m789a();
                        com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "compress logs failed, errorCode: " + iM789a);
                        a(bzVar, (Uri) null, iM789a);
                        return;
                    }
                    Uri uriA = a(fileA);
                    if (uriA == null) {
                        com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "get uri failed when handleGetCompressedLogUri.");
                        return;
                    } else {
                        a(uriA);
                        a(bzVar, uriA, 0);
                        return;
                    }
                } catch (Exception e9) {
                    e = e9;
                }
            } catch (Exception e10) {
                exc = e10;
            }
        } catch (Exception e11) {
            e = e11;
        }
        exc = e;
        com.xiaomi.channel.commonutils.logger.c.c("UploadLogSDKService", "handleGetCompressedLogUri exception: " + exc.getMessage());
        a(bzVar, (Uri) null, 306);
    }

    private Uri a(File file) {
        try {
            return LogUploadFileProvider.a(this, file);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.c("UploadLogSDKService", "getUriForFile failed: " + e9.getMessage());
            return null;
        }
    }

    private void a(Uri uri) {
        try {
            grantUriPermission("com.xiaomi.market", uri, 1);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.c("UploadLogSDKService", "grant permission failed: " + e9.getMessage());
        }
    }

    private void a(bz bzVar, int i9) {
        if (bzVar == null) {
            com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "callback is null when reportStatus");
            return;
        }
        try {
            bzVar.b(i9);
        } catch (RemoteException e9) {
            com.xiaomi.channel.commonutils.logger.c.c("UploadLogSDKService", "report status failed: " + e9.getMessage());
        }
    }

    private void a(bz bzVar, Uri uri, int i9) {
        if (bzVar == null) {
            com.xiaomi.channel.commonutils.logger.c.m10a("UploadLogSDKService", "callback is null");
            return;
        }
        try {
            if (i9 == 0 && uri != null) {
                bzVar.a(uri);
            } else {
                bzVar.a(i9);
            }
        } catch (RemoteException e9) {
            com.xiaomi.channel.commonutils.logger.c.c("UploadLogSDKService", "callback failed, market process died: " + e9.getMessage());
            b();
        }
    }

    private void a() {
        com.xiaomi.push.ba.a("delayTwoMinutes", new Runnable() { // from class: com.xiaomi.push.service.UploadLogSDKService.3
            @Override // java.lang.Runnable
            public void run() {
                com.xiaomi.channel.commonutils.logger.c.c("UploadLogSDKService", "Auto kill timer timeout, clean up resources and kill process");
                UploadLogSDKService.this.b();
            }
        }, 2L, TimeUnit.MINUTES);
    }
}
