package kotlin.jvm.internal;

import java.util.List;

/* JADX INFO: compiled from: TypeIntrinsics.java */
/* JADX INFO: loaded from: classes2.dex */
public final class B {
    public static List a(Object obj) {
        if ((obj instanceof L7.a) && !(obj instanceof L7.b)) {
            d(obj, "kotlin.collections.MutableList");
            throw null;
        }
        try {
            return (List) obj;
        } catch (ClassCastException e9) {
            k.g(e9, B.class.getName());
            throw e9;
        }
    }

    public static void b(int i9, Object obj) {
        if (obj == null || c(i9, obj)) {
            return;
        }
        d(obj, "kotlin.jvm.functions.Function" + i9);
        throw null;
    }

    public static boolean c(int i9, Object obj) {
        int arity;
        if (obj instanceof p188x7.a) {
            if (obj instanceof h) {
                arity = ((h) obj).getArity();
            } else if (obj instanceof K7.a) {
                arity = 0;
            } else if (obj instanceof K7.l) {
                arity = 1;
            } else if (obj instanceof K7.p) {
                arity = 2;
            } else if (obj instanceof K7.q) {
                arity = 3;
            } else if (obj instanceof K7.r) {
                arity = 4;
            } else if (obj instanceof K7.s) {
                arity = 5;
            } else if (obj instanceof K7.t) {
                arity = 6;
            } else if (obj instanceof K7.u) {
                arity = 7;
            } else if (obj instanceof K7.v) {
                arity = 8;
            } else if (obj instanceof K7.w) {
                arity = 9;
            } else if (obj instanceof K7.b) {
                arity = 10;
            } else if (obj instanceof K7.c) {
                arity = 11;
            } else if (obj instanceof K7.d) {
                arity = 12;
            } else if (obj instanceof K7.e) {
                arity = 13;
            } else if (obj instanceof K7.f) {
                arity = 14;
            } else if (obj instanceof K7.g) {
                arity = 15;
            } else if (obj instanceof K7.h) {
                arity = 16;
            } else if (obj instanceof K7.i) {
                arity = 17;
            } else if (obj instanceof K7.j) {
                arity = 18;
            } else if (obj instanceof K7.k) {
                arity = 19;
            } else if (obj instanceof K7.m) {
                arity = 20;
            } else if (obj instanceof K7.n) {
                arity = 21;
            } else {
                arity = obj instanceof K7.o ? 22 : -1;
            }
            if (arity == i9) {
                return true;
            }
        }
        return false;
    }

    public static void d(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(p171w.a.a(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        k.g(classCastException, B.class.getName());
        throw classCastException;
    }
}
