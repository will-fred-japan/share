package com.xiaomi.push;

import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class eg {
    public abstract int a();

    public StatusBarNotification a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (StatusBarNotification statusBarNotification : com.xiaomi.push.service.ai.a(context, str)) {
                if (a(statusBarNotification)) {
                    return statusBarNotification;
                }
            }
        }
        return null;
    }

    public abstract boolean a(StatusBarNotification statusBarNotification);

    public void a(XMPushService xMPushService, String str, it itVar, iq iqVar, boolean z8) {
        StatusBarNotification statusBarNotificationA = a(xMPushService, str);
        int iA = a();
        if (statusBarNotificationA != null) {
            com.xiaomi.push.service.aa.j(com.xiaomi.push.service.ao.d(statusBarNotificationA.getNotification()));
            com.xiaomi.push.service.ai.a(statusBarNotificationA, str, xMPushService, itVar, iqVar, z8, iA);
            return;
        }
        com.xiaomi.push.service.ai.a(xMPushService, iqVar, itVar, 0, "", 3, iA, z8);
        if (this instanceof ej) {
            com.xiaomi.push.service.aa.j(((ej) this).m344a());
        } else if (this instanceof eh) {
            com.xiaomi.push.service.aa.j(((eh) this).m343a());
        }
    }
}
