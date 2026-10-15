package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;

/* JADX INFO: loaded from: classes2.dex */
public class bv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f156a;

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f156a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.xiaomi.clientreport.processor.c cVar = this.f156a;
            if (cVar != null) {
                cVar.a();
            }
            com.xiaomi.channel.commonutils.logger.c.c("begin read and send perf / event");
            com.xiaomi.clientreport.processor.c cVar2 = this.f156a;
            if (cVar2 instanceof IEventProcessor) {
                bx.a(this.f17106a).m137a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (cVar2 instanceof IPerfProcessor) {
                bx.a(this.f17106a).m137a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
        }
    }

    public void a(Context context) {
        this.f17106a = context;
    }
}
