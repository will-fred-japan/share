package com.engagelab.privates.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class DateUtil {
    private static final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static volatile b dateFormatThreadLocal;
    private static final Object lock = new Object();
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> sdfMap = new ConcurrentHashMap<>();
    public static String PATTERN_DATETIME_FILENAME = "yyyyMMdd_HHmm";
    private static final String UTC = "UTC";
    private static final TimeZone UTC_TIMEZONE = TimeZone.getTimeZone(UTC);
    private static final ThreadLocal<SimpleDateFormat> SDF_ISO_FORMAT_UTC = new a();

    public static class a extends ThreadLocal<SimpleDateFormat> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.ISO_FORMAT, Locale.ROOT);
            simpleDateFormat.setTimeZone(DateUtil.UTC_TIMEZONE);
            return simpleDateFormat;
        }
    }

    public static class b extends ThreadLocal<SimpleDateFormat> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12381a;

        public b(String str) {
            this.f12381a = str;
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f12381a, Locale.ENGLISH);
        }
    }

    public static String defaultFormat() {
        return getSdf("yyyyMMdd HH:mm:ss.SSS").format(new Date());
    }

    public static Date getCurrentDateTime() {
        return Calendar.getInstance(UTC_TIMEZONE).getTime();
    }

    public static SimpleDateFormat getSdf(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = sdfMap.get(str);
        if (threadLocal == null) {
            synchronized (lock) {
                try {
                    threadLocal = sdfMap.get(str);
                    if (threadLocal == null) {
                        dateFormatThreadLocal = new b(str);
                        sdfMap.put(str, dateFormatThreadLocal);
                        dateFormatThreadLocal = null;
                        threadLocal = sdfMap.get(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return threadLocal.get();
    }

    public static String getTimestamp(Date date) {
        return SDF_ISO_FORMAT_UTC.get().format(date);
    }

    public static String getTodayDateTime() {
        return getSdf("yyyyMMddHHmmss").format(new Date());
    }

    public static String getTodayDateTimeForFilename() {
        return getSdf(PATTERN_DATETIME_FILENAME).format(new Date());
    }

    public static String getTodayDateTimeForReport() {
        return getSdf("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static boolean isDaysAgo(Date date, int i9) {
        if (date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(date.getTime());
        calendar.roll(6, -i9);
        return calendar.after(calendar2);
    }

    public static Date parseDateInFilename(String str) {
        try {
            return getSdf(PATTERN_DATETIME_FILENAME).parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
