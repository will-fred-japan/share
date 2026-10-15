package com.xiaomi.push.service;

import android.content.Context;
import android.util.Pair;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.ia;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ap extends com.xiaomi.push.ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f18236a;

    public ap(Context context) {
        this.f18236a = context;
    }

    @Override // com.xiaomi.push.ah.a
    /* JADX INFO: renamed from: a */
    public String mo133a() {
        return "28";
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context = this.f18236a;
        if (context == null) {
            return;
        }
        if (!com.xiaomi.push.k.m649a(context)) {
            com.xiaomi.channel.commonutils.logger.c.m13a("OcUpdateReportJob", "not xmsf package, not run");
            return;
        }
        aq.a(this.f18236a).a(0, (List<Pair<ia, Integer>>) null, -1);
        try {
            this.f18236a.getSharedPreferences("mipush_oc_update_cache", 0).edit().putLong("oc_last_schedule_report_time", System.currentTimeMillis()).apply();
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.b("OcUpdateReportJob", "update oc schedule report time error", e9.getMessage());
        }
        com.xiaomi.push.ah.a(this.f18236a).m90a(mo133a());
        com.xiaomi.push.ah.a(this.f18236a).b(this, RemoteMessageConst.MAX_TTL);
    }
}
