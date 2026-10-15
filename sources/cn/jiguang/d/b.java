package cn.jiguang.d;

import android.content.Context;
import cn.jiguang.e.d;
import cn.jiguang.e.f;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Long f10458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Long f10459b;

    public static long a(Context context, long j) {
        return (c(context) + j) / 1000;
    }

    public static long b(Context context) {
        return a(context, System.currentTimeMillis());
    }

    public static long c(Context context) {
        if (f10458a != null && f10459b != null) {
            return f10458a.longValue() - f10459b.longValue();
        }
        Long l8 = (Long) f.a(context, d.T());
        long jLongValue = l8.longValue();
        Long l9 = (Long) f.a(context, d.U());
        long jLongValue2 = l9.longValue();
        if (jLongValue == 0 || jLongValue2 == 0) {
            return 0L;
        }
        f10458a = l9;
        f10459b = l8;
        return jLongValue2 - jLongValue;
    }

    public static boolean a(Context context) {
        return cn.jiguang.e.b.f(context);
    }

    public static void b(Context context, long j) {
        if (j > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            f10458a = Long.valueOf(j);
            f10459b = Long.valueOf(jCurrentTimeMillis);
            f.a(context, (d<?>[]) new d[]{d.U().a(Long.valueOf(j)), d.T().a(Long.valueOf(jCurrentTimeMillis))});
        }
    }
}
