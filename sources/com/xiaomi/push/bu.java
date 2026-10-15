package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class bu extends ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17105a;

    public bu(Context context) {
        this.f17105a = context;
    }

    @Override // com.xiaomi.push.ah.a
    /* JADX INFO: renamed from: a */
    public String mo133a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.f17105a).c();
                com.xiaomi.channel.commonutils.logger.c.c(this.f17105a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.d("fail to send perf data. " + e9);
        }
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f17105a).m20a().isPerfUploadSwitchOpen();
    }
}
