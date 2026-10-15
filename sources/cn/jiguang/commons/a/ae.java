package cn.jiguang.commons.a;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Boolean> f9634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f9635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Integer> f9636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<String> f9637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<String> f9638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Long> f9639f;

    public ae() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f9634a = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.f9635b = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        this.f9636c = concurrentHashMap3;
        this.f9637d = new CopyOnWriteArrayList();
        this.f9638e = new CopyOnWriteArrayList();
        this.f9639f = new CopyOnWriteArrayList();
        Boolean bool = Boolean.FALSE;
        concurrentHashMap.put("gps_enabled", bool);
        concurrentHashMap.put("wifi_enabled", bool);
        concurrentHashMap.put("cell_enabled", bool);
        concurrentHashMap2.put("gps_interval", 800000L);
        concurrentHashMap2.put("wifi_interval", 800000L);
        concurrentHashMap2.put("cell_interval", 800000L);
        concurrentHashMap2.put("report_interval", 3600000L);
        concurrentHashMap2.put("gps_update_interval", Long.valueOf(com.heytap.mcssdk.constant.a.j));
        concurrentHashMap3.put("wifi_count", 20);
        concurrentHashMap3.put("wifi_min_level", -90);
        concurrentHashMap3.put("new_wifi_percent", 30);
        concurrentHashMap3.put("gps_update_distance", 800);
    }

    public final List<Long> a() {
        return Collections.unmodifiableList(this.f9639f);
    }

    public final long b(String str) {
        Long l8 = this.f9635b.get(str);
        if (l8 != null) {
            return l8.longValue();
        }
        if ("gps_interval".equals(str) || "wifi_interval".equals(str) || "cell_interval".equals(str)) {
            return 800000L;
        }
        if ("report_interval".equals(str)) {
            return 3600000L;
        }
        if ("gps_update_interval".equals(str)) {
            return com.heytap.mcssdk.constant.a.j;
        }
        return 0L;
    }

    public final int c(String str) {
        Integer num = this.f9636c.get(str);
        if (num != null) {
            return num.intValue();
        }
        if ("wifi_min_level".equals(str)) {
            return -90;
        }
        if ("wifi_count".equals(str)) {
            return 20;
        }
        if ("new_wifi_percent".equals(str)) {
            return 30;
        }
        return "gps_update_distance".equals(str) ? 800 : 0;
    }

    public final void d(String str) {
        this.f9637d.clear();
        if (str == null || str.isEmpty()) {
            return;
        }
        for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f9637d.add(str2);
            }
        }
    }

    public final boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f9637d.contains(str.trim());
    }

    public final void f(String str) {
        this.f9638e.clear();
        if (str == null || str.isEmpty()) {
            return;
        }
        for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f9638e.add(str2);
            }
        }
    }

    public final boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f9638e.contains(str.trim());
    }

    public final String toString() {
        return "LocationConfig{featureFlags=" + this.f9634a + ", intervals=" + this.f9635b + ", thresholds=" + this.f9636c + ", packageBlacklist=" + this.f9637d + ", serviceBlacklist=" + this.f9638e + '}';
    }

    public final void a(String str, int i9) {
        this.f9636c.put(str, Integer.valueOf(i9));
    }

    public final void a(String str, long j) {
        if (j > 0) {
            this.f9635b.put(str, Long.valueOf(j));
        }
    }

    public final void a(String str, boolean z8) {
        this.f9634a.put(str, Boolean.valueOf(z8));
    }

    public final void a(List<Long> list) {
        this.f9639f.clear();
        this.f9639f.addAll(list);
    }

    public final boolean a(String str) {
        Boolean bool = this.f9634a.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
