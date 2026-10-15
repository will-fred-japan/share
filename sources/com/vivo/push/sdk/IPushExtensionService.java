package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.model.RemoteNotificationInfo;

/* JADX INFO: loaded from: classes.dex */
public interface IPushExtensionService {
    void onExtensionTimeWillExpire(Context context, RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback);

    void onReceiveRemoteNotification(Context context, RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback);
}
