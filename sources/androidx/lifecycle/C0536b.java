package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ClassesInfoCache.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class C0536b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0536b f7720c = new C0536b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f7721a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f7722b = new HashMap();

    /* JADX INFO: renamed from: androidx.lifecycle.b$a */
    /* JADX INFO: compiled from: ClassesInfoCache.java */
    @Deprecated
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap f7723a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f7724b;

        public a(HashMap map) {
            this.f7724b = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0544j.a aVar = (AbstractC0544j.a) entry.getValue();
                List arrayList = (List) this.f7723a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f7723a.put(aVar, arrayList);
                }
                arrayList.add((C0107b) entry.getKey());
            }
        }

        public static void a(List list, InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar, InterfaceC0547m interfaceC0547m) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    C0107b c0107b = (C0107b) list.get(size);
                    c0107b.getClass();
                    try {
                        int i9 = c0107b.f7725a;
                        Method method = c0107b.f7726b;
                        if (i9 == 0) {
                            method.invoke(interfaceC0547m, new Object[0]);
                        } else if (i9 == 1) {
                            method.invoke(interfaceC0547m, interfaceC0548n);
                        } else if (i9 == 2) {
                            method.invoke(interfaceC0547m, interfaceC0548n, aVar);
                        }
                    } catch (IllegalAccessException e9) {
                        throw new RuntimeException(e9);
                    } catch (InvocationTargetException e10) {
                        throw new RuntimeException("Failed to call observer method", e10.getCause());
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClassesInfoCache.java */
    @Deprecated
    public static final class C0107b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f7726b;

        public C0107b(Method method, int i9) {
            this.f7725a = i9;
            this.f7726b = method;
            method.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0107b)) {
                return false;
            }
            C0107b c0107b = (C0107b) obj;
            return this.f7725a == c0107b.f7725a && this.f7726b.getName().equals(c0107b.f7726b.getName());
        }

        public final int hashCode() {
            return this.f7726b.getName().hashCode() + (this.f7725a * 31);
        }
    }

    public static void b(HashMap map, C0107b c0107b, AbstractC0544j.a aVar, Class cls) {
        AbstractC0544j.a aVar2 = (AbstractC0544j.a) map.get(c0107b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0107b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0107b.f7726b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    public final a a(Class<?> cls, Method[] methodArr) {
        int i9;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.f7721a;
        if (superclass != null) {
            a aVarA = (a) map2.get(superclass);
            if (aVarA == null) {
                aVarA = a(superclass, null);
            }
            map.putAll(aVarA.f7724b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            a aVarA2 = (a) map2.get(cls2);
            if (aVarA2 == null) {
                aVarA2 = a(cls2, null);
            }
            for (Map.Entry entry : aVarA2.f7724b.entrySet()) {
                b(map, (C0107b) entry.getKey(), (AbstractC0544j.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e9) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e9);
            }
        }
        boolean z8 = false;
        for (Method method : methodArr) {
            t tVar = (t) method.getAnnotation(t.class);
            if (tVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i9 = 0;
                } else {
                    if (!InterfaceC0548n.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i9 = 1;
                }
                AbstractC0544j.a aVarValue = tVar.value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC0544j.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != AbstractC0544j.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i9 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b(map, new C0107b(method, i9), aVarValue, cls);
                z8 = true;
            }
        }
        a aVar = new a(map);
        map2.put(cls, aVar);
        this.f7722b.put(cls, Boolean.valueOf(z8));
        return aVar;
    }
}
