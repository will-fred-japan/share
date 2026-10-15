package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ResolutionFlagUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ResolutionFlagUtil f15653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f15654b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f15655c = new Object();

    private ResolutionFlagUtil() {
    }

    private void a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        for (String str : f15654b.keySet()) {
            Map<String, Long> map = f15654b;
            Long l8 = map.get(str);
            if (l8 == null || l8.longValue() == 0) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + str);
            } else if (time >= l8.longValue()) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because aging time: " + str);
            }
        }
    }

    public static ResolutionFlagUtil getInstance() {
        if (f15653a != null) {
            return f15653a;
        }
        synchronized (f15655c) {
            try {
                if (f15653a == null) {
                    f15653a = new ResolutionFlagUtil();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f15653a;
    }

    public long getResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
            return 0L;
        }
        Map<String, Long> map = f15654b;
        if (map.get(str) != null) {
            return map.get(str).longValue();
        }
        return 0L;
    }

    public void removeResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
        } else {
            f15654b.remove(str);
            HMSLog.i("ResolutionFlagUtil", "remove resolution flag");
        }
    }

    public void saveResolutionFlag(String str, long j) {
        if (!TextUtils.isEmpty(str) && j != 0) {
            a(str, j);
            return;
        }
        HMSLog.e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + str + ", timestamp: " + j);
    }

    private void a(String str, long j) {
        Map<String, Long> map = f15654b;
        synchronized (map) {
            a();
            map.put(str, Long.valueOf(j));
            HMSLog.i("ResolutionFlagUtil", "save resolution flag");
        }
    }
}
