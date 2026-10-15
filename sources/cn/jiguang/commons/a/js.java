package cn.jiguang.commons.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f10320a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f10321b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ju> f10322c = new ConcurrentHashMap<>(32);

    private js() {
    }

    public static js a() {
        return jt.f10323a;
    }

    public /* synthetic */ js(byte b9) {
        this();
    }

    public static void a(String str, en enVar, long j) {
        if (str == null || j < 0) {
            return;
        }
        ConcurrentHashMap<String, ju> concurrentHashMap = f10322c;
        ju juVar = concurrentHashMap.get(str);
        if (juVar != null) {
            juVar.a();
            f10321b.removeCallbacks(juVar);
        }
        ju juVar2 = new ju(enVar, str);
        concurrentHashMap.put(str, juVar2);
        f10321b.postDelayed(juVar2, j);
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && f10322c.containsKey(str);
    }
}
