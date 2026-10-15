package com.xiaomi.push;

import android.service.notification.StatusBarNotification;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class eh extends eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17358a;

    public eh(String str) {
        this.f17358a = str;
    }

    @Override // com.xiaomi.push.eg
    public int a() {
        return 2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m343a() {
        return this.f17358a;
    }

    @Override // com.xiaomi.push.eg
    public boolean a(StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null || statusBarNotification.getNotification() == null || TextUtils.isEmpty(this.f17358a)) {
            return false;
        }
        return TextUtils.equals(this.f17358a, com.xiaomi.push.service.ao.d(statusBarNotification.getNotification()));
    }
}
