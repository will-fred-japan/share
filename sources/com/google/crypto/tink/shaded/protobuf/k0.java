package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: UnknownFieldSchema.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k0<T, B> {
    public abstract void a(B b9, int i9, int i10);

    public abstract void b(Object obj, long j, int i9);

    public abstract void c(int i9, Object obj, Object obj2);

    public abstract void d(B b9, int i9, AbstractC0569h abstractC0569h);

    public abstract void e(Object obj, long j, int i9);

    public abstract l0 f(Object obj);

    public abstract l0 g(Object obj);

    public abstract int h(T t);

    public abstract int i(T t);

    public abstract void j(Object obj);

    public abstract l0 k(Object obj, Object obj2);

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l(int i9, C0571j c0571j, Object obj) throws C0586z {
        int i10 = c0571j.f14109b;
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        if (i12 == 0) {
            c0571j.v(0);
            e(obj, c0571j.f14108a.q(), i11);
            return true;
        }
        if (i12 == 1) {
            c0571j.v(1);
            b(obj, c0571j.f14108a.n(), i11);
            return true;
        }
        if (i12 == 2) {
            d(obj, i11, c0571j.e());
            return true;
        }
        if (i12 != 3) {
            if (i12 == 4) {
                if (i9 != 0) {
                    return false;
                }
                throw new C0586z("Protocol message end-group tag did not match expected tag.");
            }
            if (i12 != 5) {
                throw C0586z.c();
            }
            c0571j.v(5);
            a(obj, i11, c0571j.f14108a.m());
            return true;
        }
        l0 l0VarM = m();
        int i13 = (i11 << 3) | 4;
        int i14 = i9 + 1;
        if (i14 >= 100) {
            throw new C0586z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (c0571j.a() != Integer.MAX_VALUE && l(i14, c0571j, l0VarM)) {
        }
        if (i13 != c0571j.f14109b) {
            throw new C0586z("Protocol message end-group tag did not match expected tag.");
        }
        c(i11, obj, p(l0VarM));
        return true;
    }

    public abstract l0 m();

    public abstract void n(Object obj, B b9);

    public abstract void o(Object obj, T t);

    public abstract l0 p(Object obj);

    public abstract void q(T t, r0 r0Var);

    public abstract void r(T t, r0 r0Var);
}
