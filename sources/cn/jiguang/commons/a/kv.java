package cn.jiguang.commons.a;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class kv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f10384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f10385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile long f10386c;

    public static Map<String, v> a() {
        List<UsageStats> listQueryUsageStats;
        HashMap map = new HashMap();
        try {
            if (e()) {
                long jB = b();
                long jC = c();
                Context contextA = jg.a();
                UsageStatsManager usageStatsManager = contextA == null ? null : (UsageStatsManager) contextA.getSystemService("usagestats");
                if (usageStatsManager != null && (listQueryUsageStats = usageStatsManager.queryUsageStats(0, jB, jC)) != null && !listQueryUsageStats.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        UsageEvents usageEventsQueryEvents = usageStatsManager.queryEvents(jB, jC);
                        while (usageEventsQueryEvents.hasNextEvent()) {
                            UsageEvents.Event event = new UsageEvents.Event();
                            usageEventsQueryEvents.getNextEvent(event);
                            if (event.getEventType() == 1) {
                                v vVar = new v();
                                vVar.f10414a = event.getPackageName();
                                arrayList.add(vVar);
                            }
                        }
                        for (int i9 = 0; i9 < arrayList.size(); i9++) {
                            v vVar2 = (v) arrayList.get(i9);
                            String str = vVar2.f10414a;
                            if (a(str) && i9 > 0) {
                                v vVar3 = (v) arrayList.get(i9 - 1);
                                String str2 = vVar3.f10414a;
                                if (!a(str2)) {
                                    a(map, str2, vVar3);
                                }
                            }
                            if (i9 == arrayList.size() - 1 && !a(str)) {
                                a(map, str, vVar2);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    for (UsageStats usageStats : listQueryUsageStats) {
                        String packageName = usageStats.getPackageName();
                        long lastTimeStamp = usageStats.getLastTimeStamp();
                        v vVar4 = (v) map.get(packageName);
                        if (vVar4 == null || vVar4.f10418e.isEmpty() || vVar4.f10418e.get(0).longValue() < lastTimeStamp) {
                            v vVar5 = (v) map.get(packageName);
                            if (vVar5 == null) {
                                vVar5 = new v();
                                vVar5.f10414a = packageName;
                                map.put(packageName, vVar5);
                            }
                            vVar5.f10415b = usageStats.getTotalTimeInForeground() / 1000;
                            vVar5.f10418e.add(Long.valueOf(lastTimeStamp));
                            vVar5.f10417d.add(1);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return map;
    }

    private static long b() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 86400000;
        if (f10386c != jCurrentTimeMillis) {
            synchronized (kv.class) {
                try {
                    if (f10386c != jCurrentTimeMillis) {
                        d();
                        f10386c = jCurrentTimeMillis;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10384a;
    }

    private static long c() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 86400000;
        if (f10386c != jCurrentTimeMillis) {
            synchronized (kv.class) {
                try {
                    if (f10386c != jCurrentTimeMillis) {
                        d();
                        f10386c = jCurrentTimeMillis;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10385b;
    }

    private static void d() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        f10384a = calendar.getTimeInMillis();
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        f10385b = calendar.getTimeInMillis();
    }

    @TargetApi(21)
    private static boolean e() {
        try {
            ApplicationInfo applicationInfo = jg.a().getPackageManager().getApplicationInfo(jg.a().getPackageName(), 0);
            return ((AppOpsManager) jg.a().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void a(Map<String, v> map, String str, v vVar) {
        v vVar2 = map.get(str);
        vVar.f10416c = vVar2 != null ? 1 + vVar2.f10416c : 1;
        map.put(str, vVar);
    }

    private static boolean a(String str) {
        return str != null && str.contains("launcher");
    }
}
