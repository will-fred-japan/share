package cn.jiguang.commons.a;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ke {
    public static <K, V> int a(ConcurrentHashMap<K, V> concurrentHashMap, int i9, double d9) {
        if (concurrentHashMap.size() <= 1000) {
            return 0;
        }
        try {
            int size = (int) (((double) concurrentHashMap.size()) * 0.5d);
            Iterator<K> it = concurrentHashMap.keySet().iterator();
            int i10 = 0;
            while (it.hasNext() && i10 < size) {
                if (concurrentHashMap.remove(it.next()) != null) {
                    i10++;
                }
            }
            ee.a("MapCompatUtils", "cleanup " + i10 + "/" + concurrentHashMap.size());
            return i10;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("cleanup err:"), "MapCompatUtils");
            return 0;
        }
    }

    public static <K, V> V a(ConcurrentHashMap<K, V> concurrentHashMap, K k7, Callable<V> callable) {
        V v5 = concurrentHashMap.get(k7);
        if (v5 != null) {
            return v5;
        }
        synchronized (concurrentHashMap) {
            V v8 = concurrentHashMap.get(k7);
            if (v8 != null) {
                return v8;
            }
            try {
                V vCall = callable.call();
                if (vCall != null) {
                    concurrentHashMap.put(k7, vCall);
                }
                return vCall;
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
