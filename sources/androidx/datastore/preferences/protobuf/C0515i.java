package androidx.datastore.preferences.protobuf;

import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CodedInputStreamReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0515i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0514h f7249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7252d = 0;

    public C0515i(AbstractC0514h abstractC0514h) {
        C0530y.a(abstractC0514h, "input");
        this.f7249a = abstractC0514h;
        abstractC0514h.f7235d = this;
    }

    public static void y(int i9) throws C0531z {
        if ((i9 & 3) != 0) {
            throw new C0531z("Failed to parse the message.");
        }
    }

    public static void z(int i9) throws C0531z {
        if ((i9 & 7) != 0) {
            throw new C0531z("Failed to parse the message.");
        }
    }

    public final int a() {
        int i9 = this.f7252d;
        if (i9 != 0) {
            this.f7250b = i9;
            this.f7252d = 0;
        } else {
            this.f7250b = this.f7249a.u();
        }
        int i10 = this.f7250b;
        if (i10 == 0 || i10 == this.f7251c) {
            return Integer.MAX_VALUE;
        }
        return i10 >>> 3;
    }

    public final <T> void b(T t, f0<T> f0Var, C0520n c0520n) {
        int i9 = this.f7251c;
        this.f7251c = ((this.f7250b >>> 3) << 3) | 4;
        try {
            f0Var.h(t, this, c0520n);
            if (this.f7250b != this.f7251c) {
                throw new C0531z("Failed to parse the message.");
            }
            this.f7251c = i9;
        } catch (Throwable th) {
            this.f7251c = i9;
            throw th;
        }
    }

    public final <T> void c(T t, f0<T> f0Var, C0520n c0520n) throws C0531z {
        AbstractC0514h abstractC0514h = this.f7249a;
        int iV = abstractC0514h.v();
        if (abstractC0514h.f7232a >= abstractC0514h.f7233b) {
            throw new C0531z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iE = abstractC0514h.e(iV);
        abstractC0514h.f7232a++;
        f0Var.h(t, this, c0520n);
        abstractC0514h.a(0);
        abstractC0514h.f7232a--;
        abstractC0514h.d(iE);
    }

    public final void d(List<Boolean> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof C0511e;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 0) {
                do {
                    list.add(Boolean.valueOf(abstractC0514h.f()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iB = abstractC0514h.b() + abstractC0514h.v();
            do {
                list.add(Boolean.valueOf(abstractC0514h.f()));
            } while (abstractC0514h.b() < iB);
            v(iB);
            return;
        }
        C0511e c0511e = (C0511e) list;
        int i10 = this.f7250b & 7;
        if (i10 == 0) {
            do {
                c0511e.g(abstractC0514h.f());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iB2 = abstractC0514h.b() + abstractC0514h.v();
        do {
            c0511e.g(abstractC0514h.f());
        } while (abstractC0514h.b() < iB2);
        v(iB2);
    }

    public final AbstractC0513g e() throws C0531z.a {
        w(2);
        return this.f7249a.g();
    }

    public final void f(List<AbstractC0513g> list) throws C0531z.a {
        int iU;
        if ((this.f7250b & 7) != 2) {
            throw C0531z.b();
        }
        do {
            list.add(e());
            AbstractC0514h abstractC0514h = this.f7249a;
            if (abstractC0514h.c()) {
                return;
            } else {
                iU = abstractC0514h.u();
            }
        } while (iU == this.f7250b);
        this.f7252d = iU;
    }

    public final void g(List<Double> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof C0518l;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 1) {
                do {
                    list.add(Double.valueOf(abstractC0514h.h()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iV = abstractC0514h.v();
            z(iV);
            int iB = abstractC0514h.b() + iV;
            do {
                list.add(Double.valueOf(abstractC0514h.h()));
            } while (abstractC0514h.b() < iB);
            return;
        }
        C0518l c0518l = (C0518l) list;
        int i10 = this.f7250b & 7;
        if (i10 == 1) {
            do {
                c0518l.g(abstractC0514h.h());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iV2 = abstractC0514h.v();
        z(iV2);
        int iB2 = abstractC0514h.b() + iV2;
        do {
            c0518l.g(abstractC0514h.h());
        } while (abstractC0514h.b() < iB2);
    }

    public final void h(List<Integer> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof C0529x;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0514h.i()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iB = abstractC0514h.b() + abstractC0514h.v();
            do {
                list.add(Integer.valueOf(abstractC0514h.i()));
            } while (abstractC0514h.b() < iB);
            v(iB);
            return;
        }
        C0529x c0529x = (C0529x) list;
        int i10 = this.f7250b & 7;
        if (i10 == 0) {
            do {
                c0529x.g(abstractC0514h.i());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iB2 = abstractC0514h.b() + abstractC0514h.v();
        do {
            c0529x.g(abstractC0514h.i());
        } while (abstractC0514h.b() < iB2);
        v(iB2);
    }

    public final Object i(r0 r0Var, Class<?> cls, C0520n c0520n) throws C0531z {
        int iOrdinal = r0Var.ordinal();
        AbstractC0514h abstractC0514h = this.f7249a;
        switch (iOrdinal) {
            case 0:
                w(1);
                return Double.valueOf(abstractC0514h.h());
            case 1:
                w(5);
                return Float.valueOf(abstractC0514h.l());
            case 2:
                w(0);
                return Long.valueOf(abstractC0514h.n());
            case 3:
                w(0);
                return Long.valueOf(abstractC0514h.w());
            case 4:
                w(0);
                return Integer.valueOf(abstractC0514h.m());
            case 5:
                w(1);
                return Long.valueOf(abstractC0514h.k());
            case 6:
                w(5);
                return Integer.valueOf(abstractC0514h.j());
            case 7:
                w(0);
                return Boolean.valueOf(abstractC0514h.f());
            case 8:
                w(2);
                return abstractC0514h.t();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                w(2);
                f0 f0VarA = c0.f7206c.a(cls);
                Object objNewInstance = f0VarA.newInstance();
                c(objNewInstance, f0VarA, c0520n);
                f0VarA.b(objNewInstance);
                return objNewInstance;
            case 11:
                return e();
            case 12:
                w(0);
                return Integer.valueOf(abstractC0514h.v());
            case 13:
                w(0);
                return Integer.valueOf(abstractC0514h.i());
            case 14:
                w(5);
                return Integer.valueOf(abstractC0514h.o());
            case 15:
                w(1);
                return Long.valueOf(abstractC0514h.p());
            case 16:
                w(0);
                return Integer.valueOf(abstractC0514h.q());
            case 17:
                w(0);
                return Long.valueOf(abstractC0514h.r());
        }
    }

    public final void j(List<Integer> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof C0529x;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 2) {
                int iV = abstractC0514h.v();
                y(iV);
                int iB = abstractC0514h.b() + iV;
                do {
                    list.add(Integer.valueOf(abstractC0514h.j()));
                } while (abstractC0514h.b() < iB);
                return;
            }
            if (i9 != 5) {
                throw C0531z.b();
            }
            do {
                list.add(Integer.valueOf(abstractC0514h.j()));
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU = abstractC0514h.u();
                }
            } while (iU == this.f7250b);
            this.f7252d = iU;
            return;
        }
        C0529x c0529x = (C0529x) list;
        int i10 = this.f7250b & 7;
        if (i10 == 2) {
            int iV2 = abstractC0514h.v();
            y(iV2);
            int iB2 = abstractC0514h.b() + iV2;
            do {
                c0529x.g(abstractC0514h.j());
            } while (abstractC0514h.b() < iB2);
            return;
        }
        if (i10 != 5) {
            throw C0531z.b();
        }
        do {
            c0529x.g(abstractC0514h.j());
            if (abstractC0514h.c()) {
                return;
            } else {
                iU2 = abstractC0514h.u();
            }
        } while (iU2 == this.f7250b);
        this.f7252d = iU2;
    }

    public final void k(List<Long> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof H;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 1) {
                do {
                    list.add(Long.valueOf(abstractC0514h.k()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iV = abstractC0514h.v();
            z(iV);
            int iB = abstractC0514h.b() + iV;
            do {
                list.add(Long.valueOf(abstractC0514h.k()));
            } while (abstractC0514h.b() < iB);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f7250b & 7;
        if (i10 == 1) {
            do {
                h9.g(abstractC0514h.k());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iV2 = abstractC0514h.v();
        z(iV2);
        int iB2 = abstractC0514h.b() + iV2;
        do {
            h9.g(abstractC0514h.k());
        } while (abstractC0514h.b() < iB2);
    }

    public final void l(List<Float> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof C0526u;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 2) {
                int iV = abstractC0514h.v();
                y(iV);
                int iB = abstractC0514h.b() + iV;
                do {
                    list.add(Float.valueOf(abstractC0514h.l()));
                } while (abstractC0514h.b() < iB);
                return;
            }
            if (i9 != 5) {
                throw C0531z.b();
            }
            do {
                list.add(Float.valueOf(abstractC0514h.l()));
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU = abstractC0514h.u();
                }
            } while (iU == this.f7250b);
            this.f7252d = iU;
            return;
        }
        C0526u c0526u = (C0526u) list;
        int i10 = this.f7250b & 7;
        if (i10 == 2) {
            int iV2 = abstractC0514h.v();
            y(iV2);
            int iB2 = abstractC0514h.b() + iV2;
            do {
                c0526u.g(abstractC0514h.l());
            } while (abstractC0514h.b() < iB2);
            return;
        }
        if (i10 != 5) {
            throw C0531z.b();
        }
        do {
            c0526u.g(abstractC0514h.l());
            if (abstractC0514h.c()) {
                return;
            } else {
                iU2 = abstractC0514h.u();
            }
        } while (iU2 == this.f7250b);
        this.f7252d = iU2;
    }

    public final void m(List<Integer> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof C0529x;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0514h.m()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iB = abstractC0514h.b() + abstractC0514h.v();
            do {
                list.add(Integer.valueOf(abstractC0514h.m()));
            } while (abstractC0514h.b() < iB);
            v(iB);
            return;
        }
        C0529x c0529x = (C0529x) list;
        int i10 = this.f7250b & 7;
        if (i10 == 0) {
            do {
                c0529x.g(abstractC0514h.m());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iB2 = abstractC0514h.b() + abstractC0514h.v();
        do {
            c0529x.g(abstractC0514h.m());
        } while (abstractC0514h.b() < iB2);
        v(iB2);
    }

    public final void n(List<Long> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof H;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 0) {
                do {
                    list.add(Long.valueOf(abstractC0514h.n()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iB = abstractC0514h.b() + abstractC0514h.v();
            do {
                list.add(Long.valueOf(abstractC0514h.n()));
            } while (abstractC0514h.b() < iB);
            v(iB);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f7250b & 7;
        if (i10 == 0) {
            do {
                h9.g(abstractC0514h.n());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iB2 = abstractC0514h.b() + abstractC0514h.v();
        do {
            h9.g(abstractC0514h.n());
        } while (abstractC0514h.b() < iB2);
        v(iB2);
    }

    public final void o(List<Integer> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof C0529x;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 2) {
                int iV = abstractC0514h.v();
                y(iV);
                int iB = abstractC0514h.b() + iV;
                do {
                    list.add(Integer.valueOf(abstractC0514h.o()));
                } while (abstractC0514h.b() < iB);
                return;
            }
            if (i9 != 5) {
                throw C0531z.b();
            }
            do {
                list.add(Integer.valueOf(abstractC0514h.o()));
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU = abstractC0514h.u();
                }
            } while (iU == this.f7250b);
            this.f7252d = iU;
            return;
        }
        C0529x c0529x = (C0529x) list;
        int i10 = this.f7250b & 7;
        if (i10 == 2) {
            int iV2 = abstractC0514h.v();
            y(iV2);
            int iB2 = abstractC0514h.b() + iV2;
            do {
                c0529x.g(abstractC0514h.o());
            } while (abstractC0514h.b() < iB2);
            return;
        }
        if (i10 != 5) {
            throw C0531z.b();
        }
        do {
            c0529x.g(abstractC0514h.o());
            if (abstractC0514h.c()) {
                return;
            } else {
                iU2 = abstractC0514h.u();
            }
        } while (iU2 == this.f7250b);
        this.f7252d = iU2;
    }

    public final void p(List<Long> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof H;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 1) {
                do {
                    list.add(Long.valueOf(abstractC0514h.p()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iV = abstractC0514h.v();
            z(iV);
            int iB = abstractC0514h.b() + iV;
            do {
                list.add(Long.valueOf(abstractC0514h.p()));
            } while (abstractC0514h.b() < iB);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f7250b & 7;
        if (i10 == 1) {
            do {
                h9.g(abstractC0514h.p());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iV2 = abstractC0514h.v();
        z(iV2);
        int iB2 = abstractC0514h.b() + iV2;
        do {
            h9.g(abstractC0514h.p());
        } while (abstractC0514h.b() < iB2);
    }

    public final void q(List<Integer> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof C0529x;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0514h.q()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iB = abstractC0514h.b() + abstractC0514h.v();
            do {
                list.add(Integer.valueOf(abstractC0514h.q()));
            } while (abstractC0514h.b() < iB);
            v(iB);
            return;
        }
        C0529x c0529x = (C0529x) list;
        int i10 = this.f7250b & 7;
        if (i10 == 0) {
            do {
                c0529x.g(abstractC0514h.q());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iB2 = abstractC0514h.b() + abstractC0514h.v();
        do {
            c0529x.g(abstractC0514h.q());
        } while (abstractC0514h.b() < iB2);
        v(iB2);
    }

    public final void r(List<Long> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof H;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 0) {
                do {
                    list.add(Long.valueOf(abstractC0514h.r()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iB = abstractC0514h.b() + abstractC0514h.v();
            do {
                list.add(Long.valueOf(abstractC0514h.r()));
            } while (abstractC0514h.b() < iB);
            v(iB);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f7250b & 7;
        if (i10 == 0) {
            do {
                h9.g(abstractC0514h.r());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iB2 = abstractC0514h.b() + abstractC0514h.v();
        do {
            h9.g(abstractC0514h.r());
        } while (abstractC0514h.b() < iB2);
        v(iB2);
    }

    public final void s(List<String> list, boolean z8) throws C0531z.a {
        String strS;
        int iU;
        int iU2;
        if ((this.f7250b & 7) != 2) {
            throw C0531z.b();
        }
        boolean z9 = list instanceof D;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (z9 && !z8) {
            D d9 = (D) list;
            do {
                e();
                d9.d();
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        do {
            if (z8) {
                w(2);
                strS = abstractC0514h.t();
            } else {
                w(2);
                strS = abstractC0514h.s();
            }
            list.add(strS);
            if (abstractC0514h.c()) {
                return;
            } else {
                iU = abstractC0514h.u();
            }
        } while (iU == this.f7250b);
        this.f7252d = iU;
    }

    public final void t(List<Integer> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof C0529x;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0514h.v()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iB = abstractC0514h.b() + abstractC0514h.v();
            do {
                list.add(Integer.valueOf(abstractC0514h.v()));
            } while (abstractC0514h.b() < iB);
            v(iB);
            return;
        }
        C0529x c0529x = (C0529x) list;
        int i10 = this.f7250b & 7;
        if (i10 == 0) {
            do {
                c0529x.g(abstractC0514h.v());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iB2 = abstractC0514h.b() + abstractC0514h.v();
        do {
            c0529x.g(abstractC0514h.v());
        } while (abstractC0514h.b() < iB2);
        v(iB2);
    }

    public final void u(List<Long> list) throws C0531z {
        int iU;
        int iU2;
        boolean z8 = list instanceof H;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (!z8) {
            int i9 = this.f7250b & 7;
            if (i9 == 0) {
                do {
                    list.add(Long.valueOf(abstractC0514h.w()));
                    if (abstractC0514h.c()) {
                        return;
                    } else {
                        iU = abstractC0514h.u();
                    }
                } while (iU == this.f7250b);
                this.f7252d = iU;
                return;
            }
            if (i9 != 2) {
                throw C0531z.b();
            }
            int iB = abstractC0514h.b() + abstractC0514h.v();
            do {
                list.add(Long.valueOf(abstractC0514h.w()));
            } while (abstractC0514h.b() < iB);
            v(iB);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f7250b & 7;
        if (i10 == 0) {
            do {
                h9.g(abstractC0514h.w());
                if (abstractC0514h.c()) {
                    return;
                } else {
                    iU2 = abstractC0514h.u();
                }
            } while (iU2 == this.f7250b);
            this.f7252d = iU2;
            return;
        }
        if (i10 != 2) {
            throw C0531z.b();
        }
        int iB2 = abstractC0514h.b() + abstractC0514h.v();
        do {
            h9.g(abstractC0514h.w());
        } while (abstractC0514h.b() < iB2);
        v(iB2);
    }

    public final void v(int i9) throws C0531z {
        if (this.f7249a.b() != i9) {
            throw C0531z.e();
        }
    }

    public final void w(int i9) throws C0531z.a {
        if ((this.f7250b & 7) != i9) {
            throw C0531z.b();
        }
    }

    public final boolean x() {
        int i9;
        AbstractC0514h abstractC0514h = this.f7249a;
        if (abstractC0514h.c() || (i9 = this.f7250b) == this.f7251c) {
            return false;
        }
        return abstractC0514h.x(i9);
    }
}
