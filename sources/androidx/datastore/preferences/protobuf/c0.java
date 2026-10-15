package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Protobuf.java */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f7206c = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7208b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f7207a = new I();

    public final <T> f0<T> a(Class<T> cls) {
        AbstractC0521o<?> abstractC0521o;
        f0<T> f0VarX;
        Class<?> cls2;
        C0530y.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f7208b;
        f0<T> f0Var = (f0) concurrentHashMap.get(cls);
        if (f0Var != null) {
            return f0Var;
        }
        I i9 = this.f7207a;
        i9.getClass();
        Class<?> cls3 = g0.f7229a;
        if (!AbstractC0528w.class.isAssignableFrom(cls) && (cls2 = g0.f7229a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        O oA = i9.f7168a.a(cls);
        if (oA.a()) {
            if (AbstractC0528w.class.isAssignableFrom(cls)) {
                f0VarX = new V<>(g0.f7231c, C0523q.f7300a, oA.c());
            } else {
                m0<?, ?> m0Var = g0.f7230b;
                AbstractC0521o<?> abstractC0521o2 = C0523q.f7301b;
                if (abstractC0521o2 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                f0VarX = new V<>(m0Var, abstractC0521o2, oA.c());
            }
        } else if (AbstractC0528w.class.isAssignableFrom(cls)) {
            X x8 = Y.f7200b;
            F f6 = G.f7164b;
            o0 o0Var = g0.f7231c;
            C0522p c0522p = oA.b().ordinal() != 1 ? C0523q.f7300a : null;
            M m8 = N.f7177b;
            int[] iArr = U.f7179p;
            if (!(oA instanceof e0)) {
                throw null;
            }
            f0VarX = U.x((e0) oA, x8, f6, o0Var, c0522p, m8);
        } else {
            W w8 = Y.f7199a;
            E e9 = G.f7163a;
            m0<?, ?> m0Var2 = g0.f7230b;
            if (oA.b().ordinal() != 1) {
                AbstractC0521o<?> abstractC0521o3 = C0523q.f7301b;
                if (abstractC0521o3 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                abstractC0521o = abstractC0521o3;
            } else {
                abstractC0521o = null;
            }
            L l8 = N.f7176a;
            int[] iArr2 = U.f7179p;
            if (!(oA instanceof e0)) {
                throw null;
            }
            f0VarX = U.x((e0) oA, w8, e9, m0Var2, abstractC0521o, l8);
        }
        f0<T> f0Var2 = (f0) concurrentHashMap.putIfAbsent(cls, f0VarX);
        return f0Var2 != null ? f0Var2 : f0VarX;
    }
}
