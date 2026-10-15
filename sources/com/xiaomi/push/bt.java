package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class bt extends ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17104a;

    public bt(Context context) {
        this.f17104a = context;
    }

    @Override // com.xiaomi.push.ah.a
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo133a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.c.c(this.f17104a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.f17104a).m22b();
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
        }
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f17104a).m20a().isEventUploadSwitchOpen();
    }
}
