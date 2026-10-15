package cn.jiguang.commons.a;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes.dex */
public final class ee {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile Class<?> f9947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile Method f9948g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicLong f9942a = new AtomicLong(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, Long> f9943b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f9944c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<Object[]> f9945d = new ef();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f9946e = "[key-step]";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f9949h = new Object();

    private static Object a(Context context, String str, int i9, String str2, Bundle bundle, Object... objArr) {
        try {
            if (f9947f == null) {
                synchronized (f9949h) {
                    try {
                        if (f9947f == null) {
                            int i10 = JCoreManager.f9369a;
                            f9947f = JCoreManager.class;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (f9948g == null) {
                f9948g = f9947f.getDeclaredMethod("onEvent", Context.class, String.class, Integer.TYPE, String.class, Bundle.class, Object[].class);
            }
            if (f9948g == null) {
                return null;
            }
            Object[] objArr2 = f9945d.get();
            objArr2[0] = null;
            objArr2[1] = str;
            objArr2[2] = 18;
            objArr2[3] = str2;
            objArr2[4] = null;
            objArr2[5] = objArr;
            return f9948g.invoke(null, objArr2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(String str, String str2) {
        a(3, false, str, A.a.j(new StringBuilder(), f9946e, str2), null);
    }

    public static void c(String str, String str2) {
        a(4, true, str, str2, null);
    }

    public static void d(String str, String str2) {
        a(5, true, str, str2, null);
    }

    public static void e(String str, String str2) {
        a(6, true, str, str2, null);
    }

    public static void a() {
        f9942a.incrementAndGet();
        f9943b.clear();
    }

    private static void a(int i9, boolean z8, String str, String str2, Throwable th) {
        String message;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str == null ? "" : str;
        int iHashCode = str3.hashCode();
        int iHashCode2 = str2.hashCode();
        int iHashCode3 = 0;
        if (th != null && (message = th.getMessage()) != null) {
            iHashCode3 = message.hashCode();
        }
        Long lValueOf = Long.valueOf(((long) (((iHashCode >>> 16) | (iHashCode2 >>> 24)) | (iHashCode3 >>> 16))) ^ ((((((long) (iHashCode & Settings.DEFAULT_INITIAL_WINDOW_SIZE)) << 48) | (((long) (i9 & 255)) << 40)) | (((long) (16777215 & iHashCode2)) << 16)) | ((long) (65535 & iHashCode3))));
        if (!f9944c) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ConcurrentHashMap<Long, Long> concurrentHashMap = f9943b;
            Long l8 = concurrentHashMap.get(lValueOf);
            if (l8 == null) {
                l8 = null;
            }
            Long l9 = l8;
            if (l9 != null && jCurrentTimeMillis - l9.longValue() <= 285000) {
                return;
            }
            if (concurrentHashMap.size() >= 1000) {
                ke.a(concurrentHashMap, 1000, 0.5d);
            }
            concurrentHashMap.put(lValueOf, Long.valueOf(jCurrentTimeMillis));
        }
        if (th != null) {
            str2 = str2 + Constants.COLON_SEPARATOR + th;
        }
        a(null, "JCommon", 18, str3, null, Integer.valueOf(i9), Boolean.valueOf(z8), str2, th);
    }

    public static void a(String str, String str2) {
        a(3, true, str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        a(5, true, str, str2, th);
    }

    public static void b(String str, String str2, Throwable th) {
        a(6, true, str, str2, th);
    }
}
