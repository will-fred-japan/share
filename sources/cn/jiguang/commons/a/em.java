package cn.jiguang.commons.a;

import android.text.TextUtils;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class em {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SecureRandom f9968a = new SecureRandom();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Integer, Integer> f9969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Integer, Integer> f9970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, Long> f9971d;

    static {
        HashMap map = new HashMap();
        f9969b = map;
        HashMap map2 = new HashMap();
        f9970c = map2;
        f9971d = new ConcurrentHashMap();
        map.put(0, 600000);
        map.put(1, 480000);
        map.put(2, 360000);
        map.put(3, 240000);
        map.put(4, 180000);
        map.put(5, 60000);
        map.put(6, 30000);
        map.put(7, 10000);
        map.put(8, 5000);
        map2.put(0, 300000);
        map2.put(1, 240000);
        map2.put(2, 180000);
        map2.put(3, 120000);
        map2.put(4, 60000);
        map2.put(5, 30000);
        map2.put(6, Integer.valueOf(BluetoothConstant.RECEIVE_OTA_CMD_TIMEOUT));
        map2.put(7, 10000);
        map2.put(8, 5000);
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return kq.a().b(str + "_blc", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void a(String str) {
        a(str, 0);
    }

    private static void a(String str, int i9) {
        if (TextUtils.isEmpty(str) || i9 < 0) {
            return;
        }
        try {
            kq.a().a(str + "_blc", i9);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(String str, long j, long j8) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j <= 0) {
            ee.a(str, "lt<=0 no need check");
            return true;
        }
        long jAbs = Math.abs(jCurrentTimeMillis - j);
        if (jAbs >= j8) {
            return true;
        }
        ee.a(str, "skip elapsed:" + (jAbs / 1000) + "s, limit:" + (j8 / 1000) + "s");
        return false;
    }

    public static boolean a(String str, long j, long j8, Runnable runnable) {
        String str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j <= 0) {
            str2 = "lt<=0 no need delay";
        } else {
            long jAbs = Math.abs(jCurrentTimeMillis - j);
            if (jAbs >= 2 * j8) {
                js.a();
                if (js.a(str)) {
                    Long l8 = f9971d.get(str);
                    ee.a(str, "in delaying, after:" + ((l8 == null ? -1L : Math.max(0L, l8.longValue() - jCurrentTimeMillis)) / 1000) + "s, to real execute");
                    return true;
                }
                int iB = b(str);
                if (iB > 8) {
                    iB = 8;
                }
                Integer num = (TextUtils.equals(str, "ServerConfigManager") ? f9970c : f9969b).get(Integer.valueOf(iB));
                if (num == null || num.intValue() <= 0) {
                    num = 5000;
                }
                long jNextInt = num.intValue() > 1 ? f9968a.nextInt(num.intValue()) : 0L;
                f9971d.put(str, Long.valueOf(jCurrentTimeMillis + jNextInt));
                js.a();
                js.a(str, new en(str, runnable), jNextInt);
                ee.a(str, "need delay,  delayTime:" + (jNextInt / 1000) + "s, currentRetryCount:" + iB);
                a(str, iB < 8 ? iB + 1 : 8);
                return true;
            }
            str2 = "not reach 2x, elapsed:" + (jAbs / 1000) + "s, limit:" + (j8 / 1000) + "s";
        }
        ee.a(str, str2);
        a(str, 0);
        return false;
    }
}
