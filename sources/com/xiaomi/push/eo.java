package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;

/* JADX INFO: loaded from: classes2.dex */
public class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile eo f17365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f381a;

    private eo(Context context) {
        this.f381a = context;
    }

    public static eo a(Context context) {
        if (f17365a == null) {
            synchronized (eo.class) {
                try {
                    if (f17365a == null) {
                        f17365a = new eo(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17365a;
    }

    public void b(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    public void c(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }

    public void a(String str, String str2, String str3, int i9, long j, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        EventClientReport eventClientReportA = en.a(this.f381a, str2, str3, i9, j, str4);
        eventClientReportA.setAppPackageName(str);
        eventClientReportA.setSdkVersion(BuildConfig.VERSION_NAME);
        a(eventClientReportA);
    }

    public void a(String str, String str2, String str3, int i9, String str4) {
        a(str, str2, str3, i9, System.currentTimeMillis(), str4);
    }

    public void a(String str, Intent intent, int i9, String str2) {
        if (intent == null) {
            return;
        }
        a(str, en.m346a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i9, System.currentTimeMillis(), str2);
    }

    public void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public void a(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        a(str, en.m346a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
    }

    public void a(String str, int i9, long j, long j8) {
        if (i9 < 0 || j8 < 0 || j <= 0) {
            return;
        }
        PerfClientReport perfClientReportA = en.a(this.f381a, i9, j, j8);
        perfClientReportA.setAppPackageName(str);
        perfClientReportA.setSdkVersion(BuildConfig.VERSION_NAME);
        a(perfClientReportA);
    }

    private void a(com.xiaomi.clientreport.data.a aVar) {
        if (aVar instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.f381a, (PerfClientReport) aVar);
        } else if (aVar instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.f381a, (EventClientReport) aVar);
        }
    }
}
