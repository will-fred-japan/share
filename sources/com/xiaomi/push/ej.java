package com.xiaomi.push;

import android.service.notification.StatusBarNotification;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ej extends eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String f379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17361b;

    public ej(int i9, String str, String str2) {
        this.f17360a = i9;
        this.f379a = str;
        this.f17361b = str2;
    }

    @Override // com.xiaomi.push.eg
    public int a() {
        return 4;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m344a() {
        return this.f379a;
    }

    @Override // com.xiaomi.push.eg
    public boolean a(StatusBarNotification statusBarNotification) {
        if (this.f17360a >= 0 && statusBarNotification != null && !TextUtils.isEmpty(this.f379a)) {
            if (u.b(this.f17361b, this.f17360a) == statusBarNotification.getId() && TextUtils.equals(this.f379a, com.xiaomi.push.service.ao.d(statusBarNotification.getNotification()))) {
                return true;
            }
        }
        return false;
    }
}
