package cn.jiguang.au;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f9458a;

    private static long a(long j) {
        return (j + (j % 2 == 0 ? 1L : 2L)) % 32767;
    }

    public static synchronized long b(Context context) {
        long jA;
        jA = a(context, -1L);
        if (jA == -1) {
            jA = a(Math.abs(new SecureRandom().nextInt(32767)));
            c(context).edit().putLong("next_rid", jA).apply();
        }
        return jA;
    }

    private static SharedPreferences c(Context context) {
        if (f9458a == null) {
            a(context);
        }
        return f9458a;
    }

    private static long a(Context context, long j) {
        long j8 = c(context).getLong("next_rid", j);
        if (j8 == j) {
            return j8;
        }
        long jA = a(j8);
        c(context).edit().putLong("next_rid", jA).apply();
        return jA;
    }

    public static void a(Context context) {
        f9458a = context.getSharedPreferences("cn.jpush.preferences.support.rid", 0);
    }
}
