package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.mipush.sdk.aidl.IExtensionCallback;
import com.xiaomi.mipush.sdk.aidl.IExtensionInterface;
import com.xiaomi.mipush.sdk.aidl.RemoteNotificationInfo;
import com.xiaomi.push.ba;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseExtensionService extends Service {
    public static final String REMOTE_NOTIFY_TASK = "BaseExtensionService_remote_notify";
    public static final String REMOTE_NOTIFY_TIME_WILL_TASK = "BaseExtensionService_remote_notify_time_will";
    private final IExtensionInterface.Stub binder = new IExtensionInterface.Stub() { // from class: com.xiaomi.mipush.sdk.BaseExtensionService.1
        @Override // com.xiaomi.mipush.sdk.aidl.IExtensionInterface
        public void baseExtensionTimeWillExpire(final RemoteNotificationInfo remoteNotificationInfo, final IExtensionCallback iExtensionCallback) {
            ba.a(BaseExtensionService.REMOTE_NOTIFY_TIME_WILL_TASK + remoteNotificationInfo.getMsgId(), new Runnable() { // from class: com.xiaomi.mipush.sdk.BaseExtensionService.1.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        BaseExtensionService.this.onExtensionTimeWillExpire(com.xiaomi.push.t.m835a(), remoteNotificationInfo, iExtensionCallback);
                    } catch (RemoteException e9) {
                        com.xiaomi.channel.commonutils.logger.c.d("BaseExtensionService.baseExtensionTimeWillExpire exception : " + e9.getMessage());
                    }
                }
            }, false);
        }

        @Override // com.xiaomi.mipush.sdk.aidl.IExtensionInterface
        public void baseReceiveRemoteNotification(final RemoteNotificationInfo remoteNotificationInfo, final IExtensionCallback iExtensionCallback) {
            ba.a(BaseExtensionService.REMOTE_NOTIFY_TASK + remoteNotificationInfo.getMsgId(), new Runnable() { // from class: com.xiaomi.mipush.sdk.BaseExtensionService.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        BaseExtensionService.this.onReceiveRemoteNotification(com.xiaomi.push.t.m835a(), remoteNotificationInfo, iExtensionCallback);
                    } catch (RemoteException e9) {
                        com.xiaomi.channel.commonutils.logger.c.d("BaseExtensionService.baseReceiveRemoteNotification exception : " + e9.getMessage());
                    }
                }
            }, false);
        }
    };

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.binder;
    }

    public abstract void onExtensionTimeWillExpire(Context context, RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback);

    public abstract void onReceiveRemoteNotification(Context context, RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback);
}
