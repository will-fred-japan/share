package com.xiaomi.push;

import android.os.SystemClock;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f17013a = TimeZone.getTimeZone("Asia/Shanghai");

    public static final long a() {
        return Calendar.getInstance(f17013a).getTimeInMillis();
    }

    public static final long b() {
        long jA = (a() + 28800000) % 86400000;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime > jA) {
            return jElapsedRealtime - jA;
        }
        return -1L;
    }

    public static long c() {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        if (localDateTimeNow == null) {
            return 0L;
        }
        return (((long) localDateTimeNow.getMonthValue()) * 100) + (((long) localDateTimeNow.getYear()) * 10000) + ((long) localDateTimeNow.getDayOfMonth());
    }
}
