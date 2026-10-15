package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class v0 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15323a = q0.i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15326d;

    public v0(String str, String str2, String str3) {
        this.f15324b = str;
        this.f15325c = str2;
        this.f15326d = str3;
    }

    private void a(String str, List<b1> list) {
        Pair<String, String> pairA = n1.a(str);
        new u(list, (String) pairA.first, (String) pairA.second, this.f15326d).a();
    }

    @Override // java.lang.Runnable
    public void run() {
        v.a("hmsSdk", "eventReportTask is running");
        boolean zA = c0.a(this.f15323a);
        if (zA) {
            v.c("hmsSdk", "workKey is refresh,begin report all data");
            this.f15325c = "alltype";
        }
        try {
            try {
                Map<String, List<b1>> mapA = c1.a(this.f15323a, this.f15324b, this.f15325c);
                if (mapA.size() == 0) {
                    v.b("hmsSdk", "no events to report, tag: %s, type: %s", this.f15324b, this.f15325c);
                    if ("alltype".equals(this.f15325c)) {
                        d.a(this.f15323a, "stat_v2_1", new String[0]);
                        d.a(this.f15323a, "cached_v2_1", new String[0]);
                        return;
                    } else {
                        String strA = n1.a(this.f15324b, this.f15325c);
                        d.a(this.f15323a, "stat_v2_1", strA);
                        d.a(this.f15323a, "cached_v2_1", strA);
                        return;
                    }
                }
                for (Map.Entry<String, List<b1>> entry : mapA.entrySet()) {
                    a(entry.getKey(), entry.getValue());
                }
                if ("alltype".equals(this.f15325c)) {
                    d.a(this.f15323a, "stat_v2_1", new String[0]);
                    d.a(this.f15323a, "cached_v2_1", new String[0]);
                } else {
                    String strA2 = n1.a(this.f15324b, this.f15325c);
                    d.a(this.f15323a, "stat_v2_1", strA2);
                    d.a(this.f15323a, "cached_v2_1", strA2);
                }
                if (zA) {
                    v.c("hmsSdk", "refresh local key");
                    o0.d().b();
                }
            } catch (IllegalArgumentException e9) {
                v.e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e9.getMessage());
                if ("alltype".equals(this.f15325c)) {
                    d.a(this.f15323a, "stat_v2_1", new String[0]);
                    d.a(this.f15323a, "cached_v2_1", new String[0]);
                } else {
                    String strA3 = n1.a(this.f15324b, this.f15325c);
                    d.a(this.f15323a, "stat_v2_1", strA3);
                    d.a(this.f15323a, "cached_v2_1", strA3);
                }
            } catch (Exception e10) {
                v.e("hmsSdk", "readEventRecords handData Exception:" + e10.getMessage());
                if ("alltype".equals(this.f15325c)) {
                    d.a(this.f15323a, "stat_v2_1", new String[0]);
                    d.a(this.f15323a, "cached_v2_1", new String[0]);
                } else {
                    String strA4 = n1.a(this.f15324b, this.f15325c);
                    d.a(this.f15323a, "stat_v2_1", strA4);
                    d.a(this.f15323a, "cached_v2_1", strA4);
                }
            }
        } catch (Throwable th) {
            if ("alltype".equals(this.f15325c)) {
                d.a(this.f15323a, "stat_v2_1", new String[0]);
                d.a(this.f15323a, "cached_v2_1", new String[0]);
            } else {
                String strA5 = n1.a(this.f15324b, this.f15325c);
                d.a(this.f15323a, "stat_v2_1", strA5);
                d.a(this.f15323a, "cached_v2_1", strA5);
            }
            throw th;
        }
    }
}
