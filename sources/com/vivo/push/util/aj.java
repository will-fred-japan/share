package com.vivo.push.util;

import java.util.Calendar;

/* JADX INFO: compiled from: TimeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class aj {
    public static long a() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            return calendar.getTimeInMillis();
        } catch (Exception e9) {
            w.a("TimeUtils", "getTodayStartTime error", e9);
            return 0L;
        }
    }
}
