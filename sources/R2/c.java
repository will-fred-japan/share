package R2;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ServiceManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f3986a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, a<?>> f3987b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, b> f3988c = new ConcurrentHashMap<>();

    public static <T> T a(Class<T> cls) {
        ConcurrentHashMap<Class, Object> concurrentHashMap = f3986a;
        T t = (T) concurrentHashMap.get(cls);
        if (t != null) {
            return t;
        }
        synchronized (c.class) {
            try {
                ConcurrentHashMap<Class, a<?>> concurrentHashMap2 = f3987b;
                a<?> aVar = concurrentHashMap2.get(cls);
                if (aVar != null) {
                    t = (T) aVar.a();
                    concurrentHashMap2.remove(cls);
                    if (t != null) {
                        concurrentHashMap.put(cls, t);
                        ConcurrentHashMap<Class, b> concurrentHashMap3 = f3988c;
                        b bVar = concurrentHashMap3.get(cls);
                        if (bVar != null) {
                            bVar.a();
                            concurrentHashMap3.remove(cls);
                        }
                        return t;
                    }
                }
                return t;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
