package cn.jiguang.v;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f10794a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f10795b = new ConcurrentHashMap<>();

    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10796a;

        public a(String str) {
            this.f10796a = str;
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f10796a, Locale.ENGLISH);
        }
    }

    public static String a(long j) {
        return a("yyyyMMdd HH:mm:ss.SSS").format(new Date(j));
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> aVar = f10795b.get(str);
        if (aVar == null) {
            synchronized (f10794a) {
                try {
                    aVar = f10795b.get(str);
                    if (aVar == null) {
                        aVar = new a(str);
                        f10795b.put(str, aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aVar.get();
    }
}
