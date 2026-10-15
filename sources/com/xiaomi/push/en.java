package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class en {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f17364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Map<String, ie> f380a;

    public interface a {
        void uploader(Context context, hy hyVar);
    }

    public static int a(int i9) {
        if (i9 > 0) {
            return i9 + 1000;
        }
        return -1;
    }

    public static void a(a aVar) {
        f17364a = aVar;
    }

    private static void a(Context context, hy hyVar) {
        if (m348a(context.getApplicationContext())) {
            com.xiaomi.push.service.bm.a(context.getApplicationContext(), hyVar);
            return;
        }
        a aVar = f17364a;
        if (aVar != null) {
            aVar.uploader(context, hyVar);
        }
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static EventClientReport a(Context context, String str, String str2, int i9, long j, String str3) {
        EventClientReport eventClientReportA = a(str);
        eventClientReportA.eventId = str2;
        eventClientReportA.eventType = i9;
        eventClientReportA.eventTime = j;
        eventClientReportA.eventContent = str3;
        return eventClientReportA;
    }

    public static PerfClientReport a(Context context, int i9, long j, long j8) {
        PerfClientReport perfClientReportA = a();
        perfClientReportA.code = i9;
        perfClientReportA.perfCounts = j;
        perfClientReportA.perfLatencies = j8;
        return perfClientReportA;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m346a(int i9) {
        if (i9 == 1000) {
            return "E100000";
        }
        if (i9 == 3000) {
            return "E100002";
        }
        if (i9 == 2000) {
            return "E100001";
        }
        if (i9 == 6000) {
            return "E100003";
        }
        return "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m348a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                hy hyVarA = a(context, it.next());
                if (!com.xiaomi.push.service.bl.a(hyVarA, false)) {
                    a(context, hyVarA);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.d(th.getMessage());
        }
    }

    public static hy a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hy hyVar = new hy();
        hyVar.d("category_client_report_data");
        hyVar.a("push_sdk_channel");
        hyVar.a(1L);
        hyVar.b(str);
        hyVar.a(true);
        hyVar.b(System.currentTimeMillis());
        hyVar.g(context.getPackageName());
        hyVar.e("com.xiaomi.xmsf");
        hyVar.f(com.xiaomi.push.service.bl.a());
        hyVar.c("quality_support");
        return hyVar;
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new el(context), new em(context));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m347a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static Config a(Context context) {
        boolean zA = com.xiaomi.push.service.aq.a(context).a(hz.PerfUploadSwitch.a(), false);
        boolean zA2 = com.xiaomi.push.service.aq.a(context).a(hz.EventUploadNewSwitch.a(), false);
        return Config.getBuilder().setEventUploadSwitchOpen(zA2).setEventUploadFrequency(com.xiaomi.push.service.aq.a(context).a(hz.EventUploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)).setPerfUploadSwitchOpen(zA).setPerfUploadFrequency(com.xiaomi.push.service.aq.a(context).a(hz.PerfUploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)).build(context);
    }

    public static int a(Enum r8) {
        if (r8 == null) {
            return -1;
        }
        if (r8 instanceof hu) {
            return r8.ordinal() + 1001;
        }
        if (r8 instanceof ie) {
            return r8.ordinal() + 2001;
        }
        if (r8 instanceof fs) {
            return r8.ordinal() + 3001;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static ie m345a(String str) {
        if (f380a == null) {
            synchronized (ie.class) {
                try {
                    if (f380a == null) {
                        f380a = new HashMap();
                        for (ie ieVar : ie.values()) {
                            f380a.put(ieVar.f611a.toLowerCase(), ieVar);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ie ieVar2 = f380a.get(str.toLowerCase());
        return ieVar2 != null ? ieVar2 : ie.Invalid;
    }
}
