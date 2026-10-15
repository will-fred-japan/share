package E4;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ServiceManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f1984a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, a<?>> f1985b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, b> f1986c = new ConcurrentHashMap<>();

    public static <T> T a(Class<T> cls) {
        ConcurrentHashMap<Class, Object> concurrentHashMap = f1984a;
        T t = (T) concurrentHashMap.get(cls);
        if (t != null) {
            return t;
        }
        synchronized (c.class) {
            try {
                ConcurrentHashMap<Class, a<?>> concurrentHashMap2 = f1985b;
                a<?> aVar = concurrentHashMap2.get(cls);
                if (aVar != null) {
                    T t6 = (T) aVar.a();
                    concurrentHashMap2.remove(cls);
                    if (t6 != null) {
                        concurrentHashMap.put(cls, t6);
                        ConcurrentHashMap<Class, b> concurrentHashMap3 = f1986c;
                        b bVar = concurrentHashMap3.get(cls);
                        if (bVar != null) {
                            bVar.a();
                            concurrentHashMap3.remove(cls);
                        }
                        return t6;
                    }
                }
                synchronized (cls) {
                    try {
                        T t8 = (T) b(cls);
                        if (t8 == null) {
                            return t8;
                        }
                        concurrentHashMap.put(cls, t8);
                        ConcurrentHashMap<Class, b> concurrentHashMap4 = f1986c;
                        b bVar2 = concurrentHashMap4.get(cls);
                        if (bVar2 != null) {
                            bVar2.a();
                            concurrentHashMap4.remove(cls);
                        }
                        return t8;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static <T> T b(Class<T> cls) {
        synchronized (cls) {
        }
        try {
            Object objNewInstance = Class.forName(cls.getName().concat("__ServiceProxy")).newInstance();
            if (objNewInstance instanceof IServiceProxy) {
                return (T) ((IServiceProxy) objNewInstance).newInstance();
            }
            return null;
        } catch (ClassNotFoundException e9) {
            e9.printStackTrace();
            return null;
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return null;
        } catch (InstantiationException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
