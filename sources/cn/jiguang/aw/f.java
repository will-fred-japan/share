package cn.jiguang.aw;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f9500b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f9501c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9499a = "yyyyMMdd_HHmm";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TimeZone f9502d = TimeZone.getTimeZone("UTC");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f9503e = new ThreadLocal<SimpleDateFormat>() { // from class: cn.jiguang.aw.f.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
            simpleDateFormat.setTimeZone(f.f9502d);
            return simpleDateFormat;
        }
    };

    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9504a;

        public a(String str) {
            this.f9504a = str;
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f9504a, Locale.ENGLISH);
        }
    }

    public static long a(int i9) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, i9);
        return calendar.getTime().getTime();
    }

    public static String b() {
        return a("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static Date c() {
        return Calendar.getInstance(f9502d).getTime();
    }

    public static String a() {
        return a("yyyyMMdd HH:mm:ss.SSS").format(new Date());
    }

    public static String a(Date date) {
        return f9503e.get().format(date);
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> aVar = f9501c.get(str);
        if (aVar == null) {
            synchronized (f9500b) {
                try {
                    aVar = f9501c.get(str);
                    if (aVar == null) {
                        aVar = new a(str);
                        f9501c.put(str, aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aVar.get();
    }
}
