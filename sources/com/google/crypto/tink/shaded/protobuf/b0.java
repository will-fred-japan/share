package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Protobuf.java */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f14041c = new b0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f14043b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f14042a = new I();

    public final <T> e0<T> a(Class<T> cls) {
        AbstractC0577p<?> abstractC0577p;
        e0<T> e0VarA;
        Class<?> cls2;
        C0585y.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f14043b;
        e0<T> e0Var = (e0) concurrentHashMap.get(cls);
        if (e0Var != null) {
            return e0Var;
        }
        I i9 = this.f14042a;
        i9.getClass();
        Class<?> cls3 = f0.f14063a;
        if (!AbstractC0583w.class.isAssignableFrom(cls) && (cls2 = f0.f14063a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        O oA = i9.f14008a.a(cls);
        if (oA.a()) {
            if (AbstractC0583w.class.isAssignableFrom(cls)) {
                e0VarA = new V<>(f0.f14065c, r.f14155a, oA.c());
            } else {
                k0<?, ?> k0Var = f0.f14064b;
                AbstractC0577p<?> abstractC0577p2 = r.f14156b;
                if (abstractC0577p2 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                e0VarA = new V<>(k0Var, abstractC0577p2, oA.c());
            }
        } else if (AbstractC0583w.class.isAssignableFrom(cls)) {
            X x8 = Y.f14036b;
            F f6 = G.f14003b;
            m0 m0Var = f0.f14065c;
            C0578q c0578q = oA.b().ordinal() != 1 ? r.f14155a : null;
            M m8 = N.f14013b;
            int[] iArr = U.f14015p;
            if (!(oA instanceof d0)) {
                throw null;
            }
            e0VarA = U.A((d0) oA, x8, f6, m0Var, c0578q, m8);
        } else {
            W w8 = Y.f14035a;
            E e9 = G.f14002a;
            k0<?, ?> k0Var2 = f0.f14064b;
            if (oA.b().ordinal() != 1) {
                AbstractC0577p<?> abstractC0577p3 = r.f14156b;
                if (abstractC0577p3 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                abstractC0577p = abstractC0577p3;
            } else {
                abstractC0577p = null;
            }
            L l8 = N.f14012a;
            int[] iArr2 = U.f14015p;
            if (!(oA instanceof d0)) {
                throw null;
            }
            e0VarA = U.A((d0) oA, w8, e9, k0Var2, abstractC0577p, l8);
        }
        e0<T> e0Var2 = (e0) concurrentHashMap.putIfAbsent(cls, e0VarA);
        return e0Var2 != null ? e0Var2 : e0VarA;
    }
}
