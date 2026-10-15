package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.h.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15036e = "a";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, Map<String, Map<String, String>>> f15037f = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f15038a = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f15039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f15040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f15041d;

    public a(c cVar, c cVar2, g gVar) {
        this.f15040c = cVar2;
        this.f15039b = cVar;
        this.f15041d = gVar;
        gVar.a(this);
    }

    public c a() {
        return this.f15039b;
    }

    public g b() {
        return this.f15041d;
    }

    public c c() {
        return this.f15040c;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        Map<String, Map<String, Map<String, String>>> map = f15037f;
        Map<String, Map<String, String>> map2 = map.get(grsParasKey);
        if (map2 != null && !map2.isEmpty()) {
            a(grsBaseInfo, bVar, context, str);
            return map2.get(str);
        }
        Logger.d(f15036e, "Cache size is: " + map.size());
        return new HashMap();
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String strA = this.f15039b.a(grsParasKey, "");
        String strA2 = this.f15039b.a(grsParasKey + CrashHianalyticsData.TIME, "0");
        long j = 0;
        if (!TextUtils.isEmpty(strA2) && strA2.matches("\\d+")) {
            try {
                j = Long.parseLong(strA2);
            } catch (NumberFormatException e9) {
                Logger.w(f15036e, "convert urlParamKey from String to Long catch NumberFormatException.", e9);
            }
        }
        Map<String, Map<String, Map<String, String>>> map = f15037f;
        map.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(strA));
        Logger.d(f15036e, "Cache size is: " + map.size());
        this.f15038a.put(grsParasKey, Long.valueOf(j));
        a(grsBaseInfo, grsParasKey, context);
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.f15039b.b(grsParasKey + CrashHianalyticsData.TIME, "0");
        this.f15038a.remove(grsParasKey + CrashHianalyticsData.TIME);
        Map<String, Map<String, Map<String, String>>> map = f15037f;
        map.remove(grsParasKey);
        Logger.d(f15036e, "Cache size is: " + map.size());
        this.f15041d.a(grsParasKey);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l8 = this.f15038a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l8)) {
            bVar.a(2);
            return;
        }
        if (e.a(l8, 300000L)) {
            this.f15041d.a(new com.huawei.hms.framework.network.grs.g.j.c(grsBaseInfo, context), null, str, this.f15040c, -1);
        }
        bVar.a(1);
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, com.huawei.hms.framework.network.grs.g.j.c cVar) {
        if (dVar.f() == 2) {
            Logger.w(f15036e, "update cache from server failed");
            return;
        }
        if (cVar.d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (dVar.m()) {
                f15037f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.f15039b.a(grsParasKey, "")));
            } else {
                this.f15039b.b(grsParasKey, dVar.j());
                f15037f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
            }
            if (!TextUtils.isEmpty(dVar.e())) {
                this.f15039b.b(W5.e.u(grsParasKey, "ETag"), dVar.e());
            }
            this.f15039b.b(W5.e.u(grsParasKey, CrashHianalyticsData.TIME), dVar.a());
            this.f15038a.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
        } else {
            this.f15039b.b("geoipCountryCode", dVar.j());
            this.f15039b.b("geoipCountryCodetime", dVar.a());
        }
        Logger.d(f15036e, "Cache size is: " + f15037f.size());
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.f15038a.get(str), 300000L)) {
            this.f15041d.a(new com.huawei.hms.framework.network.grs.g.j.c(grsBaseInfo, context), null, null, this.f15040c, -1);
        }
    }
}
