package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: UnknownFieldSchema.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0<T, B> {
    public abstract void a(B b9, int i9, int i10);

    public abstract void b(Object obj, long j, int i9);

    public abstract void c(int i9, Object obj, Object obj2);

    public abstract void d(B b9, int i9, AbstractC0513g abstractC0513g);

    public abstract void e(Object obj, long j, int i9);

    public abstract n0 f(Object obj);

    public abstract n0 g(Object obj);

    public abstract int h(T t);

    public abstract int i(T t);

    public abstract void j(Object obj);

    public abstract n0 k(Object obj, Object obj2);

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l(int i9, C0515i c0515i, Object obj) throws C0531z {
        int i10 = c0515i.f7250b;
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        if (i12 == 0) {
            c0515i.w(0);
            e(obj, c0515i.f7249a.n(), i11);
            return true;
        }
        if (i12 == 1) {
            c0515i.w(1);
            b(obj, c0515i.f7249a.k(), i11);
            return true;
        }
        if (i12 == 2) {
            d(obj, i11, c0515i.e());
            return true;
        }
        if (i12 != 3) {
            if (i12 == 4) {
                return false;
            }
            if (i12 != 5) {
                throw C0531z.b();
            }
            c0515i.w(5);
            a(obj, i11, c0515i.f7249a.j());
            return true;
        }
        n0 n0VarM = m();
        int i13 = (i11 << 3) | 4;
        int i14 = i9 + 1;
        if (i14 >= 100) {
            throw new C0531z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (c0515i.a() != Integer.MAX_VALUE && l(i14, c0515i, n0VarM)) {
        }
        if (i13 != c0515i.f7250b) {
            throw new C0531z("Protocol message end-group tag did not match expected tag.");
        }
        c(i11, obj, p(n0VarM));
        return true;
    }

    public abstract n0 m();

    public abstract void n(Object obj, B b9);

    public abstract void o(Object obj, T t);

    public abstract n0 p(Object obj);

    public abstract void q(T t, t0 t0Var);

    public abstract void r(T t, t0 t0Var);
}
