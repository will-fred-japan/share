package com.xiaomi.push;

import android.service.notification.StatusBarNotification;

/* JADX INFO: loaded from: classes2.dex */
public class ei extends eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f378a;

    public ei(int i9, String str) {
        this.f17359a = i9;
        this.f378a = str;
    }

    @Override // com.xiaomi.push.eg
    public int a() {
        return 1;
    }

    @Override // com.xiaomi.push.eg
    public boolean a(StatusBarNotification statusBarNotification) {
        if (this.f17359a >= 0 && statusBarNotification != null) {
            if (u.b(this.f378a, this.f17359a) == statusBarNotification.getId()) {
                return true;
            }
        }
        return false;
    }
}
