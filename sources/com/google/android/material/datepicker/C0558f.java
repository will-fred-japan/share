package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.material.datepicker.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DateStrings.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0558f {
    public static S.b<String, String> a(Long l8, Long l9) {
        if (l8 == null && l9 == null) {
            return new S.b<>(null, null);
        }
        if (l8 == null) {
            return new S.b<>(null, b(l9.longValue()));
        }
        if (l9 == null) {
            return new S.b<>(b(l8.longValue()), null);
        }
        Calendar calendarF = G.f();
        Calendar calendarG = G.g(null);
        calendarG.setTimeInMillis(l8.longValue());
        Calendar calendarG2 = G.g(null);
        calendarG2.setTimeInMillis(l9.longValue());
        if (calendarG.get(1) == calendarG2.get(1)) {
            return calendarG.get(1) == calendarF.get(1) ? new S.b<>(c(l8.longValue(), Locale.getDefault()), c(l9.longValue(), Locale.getDefault())) : new S.b<>(c(l8.longValue(), Locale.getDefault()), d(l9.longValue(), Locale.getDefault()));
        }
        return new S.b<>(d(l8.longValue(), Locale.getDefault()), d(l9.longValue(), Locale.getDefault()));
    }

    public static String b(long j) {
        Calendar calendarF = G.f();
        Calendar calendarG = G.g(null);
        calendarG.setTimeInMillis(j);
        return calendarF.get(1) == calendarG.get(1) ? c(j, Locale.getDefault()) : d(j, Locale.getDefault());
    }

    public static String c(long j, Locale locale) {
        return G.b("MMMd", locale).format(new Date(j));
    }

    public static String d(long j, Locale locale) {
        return G.b("yMMMd", locale).format(new Date(j));
    }
}
