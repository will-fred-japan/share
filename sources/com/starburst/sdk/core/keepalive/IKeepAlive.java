package com.starburst.sdk.core.keepalive;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface IKeepAlive {
    boolean isIgnoringBatteryOptimizations(Context context);

    void jumpToSettings(Activity activity);

    void setNotificationConfig(NotificationConfig notificationConfig);

    void startKeepAlive(Context context);

    void stopKeepAlive(Context context);
}
