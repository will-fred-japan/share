package cn.jiguang.aw;

import android.util.Pair;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<Object, Pair<Long, Integer>> f9527a = new HashMap<>();

    public static boolean a(Object obj, long j) {
        return a(obj, j, 0);
    }

    public static boolean a(Object obj, long j, int i9) {
        int iIntValue;
        Pair<Long, Integer> pair;
        if (j <= 0) {
            j = 3600000;
        }
        if (i9 <= 0) {
            i9 = Integer.MAX_VALUE;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!f9527a.containsKey(obj) || (pair = f9527a.get(obj)) == null) {
                iIntValue = 0;
            } else {
                long jLongValue = ((Long) pair.first).longValue();
                iIntValue = ((Integer) pair.second).intValue();
                long jAbs = Math.abs(jCurrentTimeMillis - jLongValue);
                cn.jiguang.x.f.c("ApiFrequency", "check api frequency, functionName: " + obj + "; callApiInternalTimeLimit: " + j + ", diffInternalTime: " + jAbs + "; callApiTimesLimit： " + i9 + ", currentApiCallTimes: " + iIntValue);
                if (jAbs <= j || iIntValue >= i9) {
                    return true;
                }
            }
            f9527a.put(obj, new Pair<>(Long.valueOf(jCurrentTimeMillis), Integer.valueOf(iIntValue + 1)));
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("isFrequency failed: "), "ApiFrequency");
        }
        return false;
    }
}
