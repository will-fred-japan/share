package cn.jpush.android.ad;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f11129a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f11130b = new ConcurrentHashMap<>();

    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11131a;

        public a(String str) {
            this.f11131a = str;
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f11131a, Locale.ENGLISH);
        }
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> aVar = f11130b.get(str);
        if (aVar == null) {
            synchronized (f11129a) {
                try {
                    aVar = f11130b.get(str);
                    if (aVar == null) {
                        aVar = new a(str);
                        f11130b.put(str, aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aVar.get();
    }

    public static long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return a("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }
}
