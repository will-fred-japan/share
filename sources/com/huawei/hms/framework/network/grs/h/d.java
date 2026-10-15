package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f15124a = new ConcurrentHashMap(16);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f15125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f15126b;

        public a(long j, long j8) {
            this.f15125a = j;
            this.f15126b = j8;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.f15126b <= this.f15125a;
        }
    }

    public static a a(String str) {
        StringBuilder sb = new StringBuilder("map size of get is before: ");
        Map<String, a> map = f15124a;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        a aVar = map.get(str);
        Logger.v("RequestUtil", "map size of get is after: " + map.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        StringBuilder sb = new StringBuilder("map size of put is before: ");
        Map<String, a> map = f15124a;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        map.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after: " + map.size());
    }
}
