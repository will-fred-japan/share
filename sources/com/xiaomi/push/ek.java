package com.xiaomi.push;

import android.app.Notification;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ek extends eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17363b;

    public ek(String str, String str2) {
        this.f17363b = str;
        this.f17362a = str2;
    }

    @Override // com.xiaomi.push.eg
    public int a() {
        return 3;
    }

    @Override // com.xiaomi.push.eg
    public boolean a(StatusBarNotification statusBarNotification) {
        if (statusBarNotification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId())) && statusBarNotification.getNotification() != null && !TextUtils.isEmpty(this.f17362a) && !TextUtils.isEmpty(this.f17363b)) {
            Notification notification = statusBarNotification.getNotification();
            String strA = com.xiaomi.push.service.ao.a(notification);
            String strB = com.xiaomi.push.service.ao.b(notification);
            if (a(strA, this.f17362a) && a(strB, this.f17363b)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str2.contains(str)) ? false : true;
    }
}
