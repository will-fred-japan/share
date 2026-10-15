package com.vivo.push.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* JADX INFO: loaded from: classes.dex */
public class NotifyUtil {
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String TAG = "NotifyUtil";
    private static BaseNotifyDataAdapter sNotifyData = null;
    private static String sNotifyDataAdapter = "com.vivo.push.util.NotifyDataAdapter";
    private static BaseNotifyLayoutAdapter sNotifyLayout = null;
    private static String sNotifyLayoutAdapter = "com.vivo.push.util.NotifyLayoutAdapter";

    public static int checkNotificationBarSwitch(Context context) {
        if (context == null) {
            w.a(TAG, "checkNotificationBarSwitch context is null");
            return 0;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
            return 2104;
        }
        if (notificationManager != null) {
            try {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("vivo_push_channel");
                if (notificationChannel != null && notificationChannel.getImportance() == 0) {
                    return 2121;
                }
            } catch (Exception unused) {
                w.b(TAG, "判断通知通道出现系统错误");
            }
        }
        return 0;
    }

    public static BaseNotifyDataAdapter getNotifyDataAdapter(Context context) {
        initAdapter(context);
        return sNotifyData;
    }

    public static BaseNotifyLayoutAdapter getNotifyLayoutAdapter(Context context) {
        initAdapter(context);
        return sNotifyLayout;
    }

    private static Object getObjectByReflect(String str, Object obj) {
        Class<?> cls;
        Object objNewInstance = null;
        try {
            cls = Class.forName(str);
        } catch (Exception unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                objNewInstance = cls.newInstance();
            } catch (Exception unused2) {
            }
        }
        return objNewInstance == null ? obj : objNewInstance;
    }

    private static synchronized void initAdapter(Context context) {
        try {
            if (sNotifyData == null) {
                BaseNotifyDataAdapter baseNotifyDataAdapter = (BaseNotifyDataAdapter) getObjectByReflect(sNotifyDataAdapter, new m());
                sNotifyData = baseNotifyDataAdapter;
                baseNotifyDataAdapter.init(context);
            }
            if (sNotifyLayout == null) {
                BaseNotifyLayoutAdapter baseNotifyLayoutAdapter = (BaseNotifyLayoutAdapter) getObjectByReflect(sNotifyLayoutAdapter, new n());
                sNotifyLayout = baseNotifyLayoutAdapter;
                baseNotifyLayoutAdapter.init(context);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
