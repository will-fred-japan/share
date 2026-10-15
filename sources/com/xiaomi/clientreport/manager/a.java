package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.c;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ah;
import com.xiaomi.push.bm;
import com.xiaomi.push.bt;
import com.xiaomi.push.bu;
import com.xiaomi.push.bv;
import com.xiaomi.push.bw;
import com.xiaomi.push.bx;
import com.xiaomi.push.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f16923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile a f8a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f9a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Config f10a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private IEventProcessor f11a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private IPerfProcessor f12a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f13a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ExecutorService f15a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f14a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f16924b = new HashMap<>();

    static {
        f16923a = k.m648a() ? 30 : 10;
    }

    private a(Context context) {
        this.f9a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f11a.b();
        } catch (Exception e9) {
            c.d("we: " + e9.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f12a.b();
        } catch (Exception e9) {
            c.d("wp: " + e9.getMessage());
        }
    }

    private void f() {
        if (a(this.f9a).m20a().isEventUploadSwitchOpen()) {
            final bt btVar = new bt(this.f9a);
            int eventUploadFrequency = (int) a(this.f9a).m20a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bx.a(this.f9a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                ah.a(this.f9a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        btVar.run();
                    }
                }, 10);
            }
            synchronized (a.class) {
                try {
                    if (!ah.a(this.f9a).a((ah.a) btVar, eventUploadFrequency)) {
                        ah.a(this.f9a).m90a("100886");
                        ah.a(this.f9a).a((ah.a) btVar, eventUploadFrequency);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void g() {
        if (a(this.f9a).m20a().isPerfUploadSwitchOpen()) {
            final bu buVar = new bu(this.f9a);
            int perfUploadFrequency = (int) a(this.f9a).m20a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bx.a(this.f9a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                ah.a(this.f9a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        buVar.run();
                    }
                }, 15);
            }
            synchronized (a.class) {
                try {
                    if (!ah.a(this.f9a).a((ah.a) buVar, perfUploadFrequency)) {
                        ah.a(this.f9a).m90a("100887");
                        ah.a(this.f9a).a((ah.a) buVar, perfUploadFrequency);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void c() {
        if (m20a().isPerfUploadSwitchOpen()) {
            bv bvVar = new bv();
            bvVar.a(this.f12a);
            bvVar.a(this.f9a);
            this.f15a.execute(bvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f11a;
        if (iEventProcessor != null) {
            iEventProcessor.mo23a(eventClientReport);
            if (a() >= 10) {
                d();
                ah.a(this.f9a).m90a("100888");
            } else {
                a(new ah.a() { // from class: com.xiaomi.clientreport.manager.a.3
                    @Override // com.xiaomi.push.ah.a
                    /* JADX INFO: renamed from: a */
                    public String mo133a() {
                        return "100888";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.a() > 0) {
                            a.this.f15a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.d();
                                }
                            });
                        }
                    }
                }, f16923a);
            }
        }
    }

    public static a a(Context context) {
        if (f8a == null) {
            synchronized (a.class) {
                try {
                    if (f8a == null) {
                        f8a = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f12a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo23a(perfClientReport);
            if (b() >= 10) {
                e();
                ah.a(this.f9a).m90a("100889");
            } else {
                a(new ah.a() { // from class: com.xiaomi.clientreport.manager.a.4
                    @Override // com.xiaomi.push.ah.a
                    /* JADX INFO: renamed from: a */
                    public String mo133a() {
                        return "100889";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.b() > 0) {
                            a.this.f15a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.e();
                                }
                            });
                        }
                    }
                }, f16923a);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Config m20a() {
        try {
            if (this.f10a == null) {
                this.f10a = Config.defaultConfig(this.f9a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> map = this.f14a;
        int i9 = 0;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, com.xiaomi.clientreport.data.a> map2 = this.f14a.get(it.next());
                if (map2 != null) {
                    Iterator<String> it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        com.xiaomi.clientreport.data.a aVar = map2.get(it2.next());
                        if (aVar instanceof PerfClientReport) {
                            i9 = (int) (((long) i9) + ((PerfClientReport) aVar).perfCounts);
                        }
                    }
                }
            }
        }
        return i9;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m21a() {
        a(this.f9a).f();
        a(this.f9a).g();
    }

    public void a(String str) {
        this.f13a = str;
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f10a = config;
        this.f11a = iEventProcessor;
        this.f12a = iPerfProcessor;
        iEventProcessor.setEventMap(this.f16924b);
        this.f12a.setPerfMap(this.f14a);
    }

    public void a(boolean z8, boolean z9, long j, long j8) {
        Config config = this.f10a;
        if (config != null) {
            if (z8 == config.isEventUploadSwitchOpen() && z9 == this.f10a.isPerfUploadSwitchOpen() && j == this.f10a.getEventUploadFrequency() && j8 == this.f10a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f10a.getEventUploadFrequency();
            long perfUploadFrequency = this.f10a.getPerfUploadFrequency();
            Config configBuild = Config.getBuilder().setAESKey(bw.a(this.f9a)).setEventEncrypted(this.f10a.isEventEncrypted()).setEventUploadSwitchOpen(z8).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z9).setPerfUploadFrequency(j8).build(this.f9a);
            this.f10a = configBuild;
            if (!configBuild.isEventUploadSwitchOpen()) {
                ah.a(this.f9a).m90a("100886");
            } else if (eventUploadFrequency != configBuild.getEventUploadFrequency()) {
                c.c(this.f9a.getPackageName() + "reset event job " + configBuild.getEventUploadFrequency());
                f();
            }
            if (!this.f10a.isPerfUploadSwitchOpen()) {
                ah.a(this.f9a).m90a("100887");
                return;
            }
            if (perfUploadFrequency != configBuild.getPerfUploadFrequency()) {
                c.c(this.f9a.getPackageName() + " reset perf job " + configBuild.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m22b() {
        if (m20a().isEventUploadSwitchOpen()) {
            bv bvVar = new bv();
            bvVar.a(this.f9a);
            bvVar.a(this.f11a);
            this.f15a.execute(bvVar);
        }
    }

    private void a(ah.a aVar, int i9) {
        ah.a(this.f9a).b(aVar, i9);
    }

    public void a(final EventClientReport eventClientReport) {
        if (m20a().isEventUploadSwitchOpen()) {
            this.f15a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(eventClientReport);
                }
            });
        }
    }

    public void a(final PerfClientReport perfClientReport) {
        if (m20a().isPerfUploadSwitchOpen()) {
            this.f15a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(perfClientReport);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map = this.f16924b;
        if (map == null) {
            return 0;
        }
        Iterator<String> it = map.keySet().iterator();
        int size = 0;
        while (it.hasNext()) {
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f16924b.get(it.next());
            size += arrayList != null ? arrayList.size() : 0;
        }
        return size;
    }

    public EventClientReport a(int i9, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i9;
        eventClientReport.eventId = bm.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f9a.getPackageName());
        eventClientReport.setSdkVersion(this.f13a);
        return eventClientReport;
    }
}
