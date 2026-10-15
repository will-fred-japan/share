package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CodedInputStreamReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0571j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0570i f14108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14111d = 0;

    public C0571j(AbstractC0570i abstractC0570i) {
        C0585y.a(abstractC0570i, "input");
        this.f14108a = abstractC0570i;
        abstractC0570i.f14094e = this;
    }

    public static void x(int i9) throws C0586z {
        if ((i9 & 3) != 0) {
            throw C0586z.f();
        }
    }

    public static void y(int i9) throws C0586z {
        if ((i9 & 7) != 0) {
            throw C0586z.f();
        }
    }

    public final int a() {
        int i9 = this.f14111d;
        if (i9 != 0) {
            this.f14109b = i9;
            this.f14111d = 0;
        } else {
            this.f14109b = this.f14108a.x();
        }
        int i10 = this.f14109b;
        if (i10 == 0 || i10 == this.f14110c) {
            return Integer.MAX_VALUE;
        }
        return i10 >>> 3;
    }

    public final <T> void b(T t, e0<T> e0Var, C0576o c0576o) {
        int i9 = this.f14110c;
        this.f14110c = ((this.f14109b >>> 3) << 3) | 4;
        try {
            e0Var.g(t, this, c0576o);
            if (this.f14109b != this.f14110c) {
                throw C0586z.f();
            }
            this.f14110c = i9;
        } catch (Throwable th) {
            this.f14110c = i9;
            throw th;
        }
    }

    public final <T> void c(T t, e0<T> e0Var, C0576o c0576o) throws C0586z {
        AbstractC0570i abstractC0570i = this.f14108a;
        int iY = abstractC0570i.y();
        if (abstractC0570i.f14090a + abstractC0570i.f14091b >= abstractC0570i.f14092c) {
            throw new C0586z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iH = abstractC0570i.h(iY);
        abstractC0570i.f14090a++;
        e0Var.g(t, this, c0576o);
        abstractC0570i.a(0);
        abstractC0570i.f14090a--;
        abstractC0570i.g(iH);
    }

    public final void d(List<Boolean> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof C0567f;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 0) {
                do {
                    list.add(Boolean.valueOf(abstractC0570i.i()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iD = abstractC0570i.d() + abstractC0570i.y();
            do {
                list.add(Boolean.valueOf(abstractC0570i.i()));
            } while (abstractC0570i.d() < iD);
            u(iD);
            return;
        }
        C0567f c0567f = (C0567f) list;
        int i10 = this.f14109b & 7;
        if (i10 == 0) {
            do {
                c0567f.g(abstractC0570i.i());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iD2 = abstractC0570i.d() + abstractC0570i.y();
        do {
            c0567f.g(abstractC0570i.i());
        } while (abstractC0570i.d() < iD2);
        u(iD2);
    }

    public final AbstractC0569h e() throws C0586z.a {
        v(2);
        return this.f14108a.j();
    }

    public final void f(List<AbstractC0569h> list) throws C0586z.a {
        int iX;
        if ((this.f14109b & 7) != 2) {
            throw C0586z.c();
        }
        do {
            list.add(e());
            AbstractC0570i abstractC0570i = this.f14108a;
            if (abstractC0570i.e()) {
                return;
            } else {
                iX = abstractC0570i.x();
            }
        } while (iX == this.f14109b);
        this.f14111d = iX;
    }

    public final void g(List<Double> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof C0574m;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 1) {
                do {
                    list.add(Double.valueOf(abstractC0570i.k()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iY = abstractC0570i.y();
            y(iY);
            int iD = abstractC0570i.d() + iY;
            do {
                list.add(Double.valueOf(abstractC0570i.k()));
            } while (abstractC0570i.d() < iD);
            return;
        }
        C0574m c0574m = (C0574m) list;
        int i10 = this.f14109b & 7;
        if (i10 == 1) {
            do {
                c0574m.g(abstractC0570i.k());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iY2 = abstractC0570i.y();
        y(iY2);
        int iD2 = abstractC0570i.d() + iY2;
        do {
            c0574m.g(abstractC0570i.k());
        } while (abstractC0570i.d() < iD2);
    }

    public final void h(List<Integer> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof C0584x;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0570i.l()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iD = abstractC0570i.d() + abstractC0570i.y();
            do {
                list.add(Integer.valueOf(abstractC0570i.l()));
            } while (abstractC0570i.d() < iD);
            u(iD);
            return;
        }
        C0584x c0584x = (C0584x) list;
        int i10 = this.f14109b & 7;
        if (i10 == 0) {
            do {
                c0584x.g(abstractC0570i.l());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iD2 = abstractC0570i.d() + abstractC0570i.y();
        do {
            c0584x.g(abstractC0570i.l());
        } while (abstractC0570i.d() < iD2);
        u(iD2);
    }

    public final void i(List<Integer> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof C0584x;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 2) {
                int iY = abstractC0570i.y();
                x(iY);
                int iD = abstractC0570i.d() + iY;
                do {
                    list.add(Integer.valueOf(abstractC0570i.m()));
                } while (abstractC0570i.d() < iD);
                return;
            }
            if (i9 != 5) {
                throw C0586z.c();
            }
            do {
                list.add(Integer.valueOf(abstractC0570i.m()));
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX = abstractC0570i.x();
                }
            } while (iX == this.f14109b);
            this.f14111d = iX;
            return;
        }
        C0584x c0584x = (C0584x) list;
        int i10 = this.f14109b & 7;
        if (i10 == 2) {
            int iY2 = abstractC0570i.y();
            x(iY2);
            int iD2 = abstractC0570i.d() + iY2;
            do {
                c0584x.g(abstractC0570i.m());
            } while (abstractC0570i.d() < iD2);
            return;
        }
        if (i10 != 5) {
            throw C0586z.c();
        }
        do {
            c0584x.g(abstractC0570i.m());
            if (abstractC0570i.e()) {
                return;
            } else {
                iX2 = abstractC0570i.x();
            }
        } while (iX2 == this.f14109b);
        this.f14111d = iX2;
    }

    public final void j(List<Long> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof H;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 1) {
                do {
                    list.add(Long.valueOf(abstractC0570i.n()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iY = abstractC0570i.y();
            y(iY);
            int iD = abstractC0570i.d() + iY;
            do {
                list.add(Long.valueOf(abstractC0570i.n()));
            } while (abstractC0570i.d() < iD);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f14109b & 7;
        if (i10 == 1) {
            do {
                h9.g(abstractC0570i.n());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iY2 = abstractC0570i.y();
        y(iY2);
        int iD2 = abstractC0570i.d() + iY2;
        do {
            h9.g(abstractC0570i.n());
        } while (abstractC0570i.d() < iD2);
    }

    public final void k(List<Float> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof C0581u;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 2) {
                int iY = abstractC0570i.y();
                x(iY);
                int iD = abstractC0570i.d() + iY;
                do {
                    list.add(Float.valueOf(abstractC0570i.o()));
                } while (abstractC0570i.d() < iD);
                return;
            }
            if (i9 != 5) {
                throw C0586z.c();
            }
            do {
                list.add(Float.valueOf(abstractC0570i.o()));
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX = abstractC0570i.x();
                }
            } while (iX == this.f14109b);
            this.f14111d = iX;
            return;
        }
        C0581u c0581u = (C0581u) list;
        int i10 = this.f14109b & 7;
        if (i10 == 2) {
            int iY2 = abstractC0570i.y();
            x(iY2);
            int iD2 = abstractC0570i.d() + iY2;
            do {
                c0581u.g(abstractC0570i.o());
            } while (abstractC0570i.d() < iD2);
            return;
        }
        if (i10 != 5) {
            throw C0586z.c();
        }
        do {
            c0581u.g(abstractC0570i.o());
            if (abstractC0570i.e()) {
                return;
            } else {
                iX2 = abstractC0570i.x();
            }
        } while (iX2 == this.f14109b);
        this.f14111d = iX2;
    }

    public final void l(List<Integer> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof C0584x;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0570i.p()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iD = abstractC0570i.d() + abstractC0570i.y();
            do {
                list.add(Integer.valueOf(abstractC0570i.p()));
            } while (abstractC0570i.d() < iD);
            u(iD);
            return;
        }
        C0584x c0584x = (C0584x) list;
        int i10 = this.f14109b & 7;
        if (i10 == 0) {
            do {
                c0584x.g(abstractC0570i.p());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iD2 = abstractC0570i.d() + abstractC0570i.y();
        do {
            c0584x.g(abstractC0570i.p());
        } while (abstractC0570i.d() < iD2);
        u(iD2);
    }

    public final void m(List<Long> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof H;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 0) {
                do {
                    list.add(Long.valueOf(abstractC0570i.q()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iD = abstractC0570i.d() + abstractC0570i.y();
            do {
                list.add(Long.valueOf(abstractC0570i.q()));
            } while (abstractC0570i.d() < iD);
            u(iD);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f14109b & 7;
        if (i10 == 0) {
            do {
                h9.g(abstractC0570i.q());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iD2 = abstractC0570i.d() + abstractC0570i.y();
        do {
            h9.g(abstractC0570i.q());
        } while (abstractC0570i.d() < iD2);
        u(iD2);
    }

    public final void n(List<Integer> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof C0584x;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 2) {
                int iY = abstractC0570i.y();
                x(iY);
                int iD = abstractC0570i.d() + iY;
                do {
                    list.add(Integer.valueOf(abstractC0570i.r()));
                } while (abstractC0570i.d() < iD);
                return;
            }
            if (i9 != 5) {
                throw C0586z.c();
            }
            do {
                list.add(Integer.valueOf(abstractC0570i.r()));
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX = abstractC0570i.x();
                }
            } while (iX == this.f14109b);
            this.f14111d = iX;
            return;
        }
        C0584x c0584x = (C0584x) list;
        int i10 = this.f14109b & 7;
        if (i10 == 2) {
            int iY2 = abstractC0570i.y();
            x(iY2);
            int iD2 = abstractC0570i.d() + iY2;
            do {
                c0584x.g(abstractC0570i.r());
            } while (abstractC0570i.d() < iD2);
            return;
        }
        if (i10 != 5) {
            throw C0586z.c();
        }
        do {
            c0584x.g(abstractC0570i.r());
            if (abstractC0570i.e()) {
                return;
            } else {
                iX2 = abstractC0570i.x();
            }
        } while (iX2 == this.f14109b);
        this.f14111d = iX2;
    }

    public final void o(List<Long> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof H;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 1) {
                do {
                    list.add(Long.valueOf(abstractC0570i.s()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iY = abstractC0570i.y();
            y(iY);
            int iD = abstractC0570i.d() + iY;
            do {
                list.add(Long.valueOf(abstractC0570i.s()));
            } while (abstractC0570i.d() < iD);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f14109b & 7;
        if (i10 == 1) {
            do {
                h9.g(abstractC0570i.s());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iY2 = abstractC0570i.y();
        y(iY2);
        int iD2 = abstractC0570i.d() + iY2;
        do {
            h9.g(abstractC0570i.s());
        } while (abstractC0570i.d() < iD2);
    }

    public final void p(List<Integer> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof C0584x;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0570i.t()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iD = abstractC0570i.d() + abstractC0570i.y();
            do {
                list.add(Integer.valueOf(abstractC0570i.t()));
            } while (abstractC0570i.d() < iD);
            u(iD);
            return;
        }
        C0584x c0584x = (C0584x) list;
        int i10 = this.f14109b & 7;
        if (i10 == 0) {
            do {
                c0584x.g(abstractC0570i.t());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iD2 = abstractC0570i.d() + abstractC0570i.y();
        do {
            c0584x.g(abstractC0570i.t());
        } while (abstractC0570i.d() < iD2);
        u(iD2);
    }

    public final void q(List<Long> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof H;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 0) {
                do {
                    list.add(Long.valueOf(abstractC0570i.u()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iD = abstractC0570i.d() + abstractC0570i.y();
            do {
                list.add(Long.valueOf(abstractC0570i.u()));
            } while (abstractC0570i.d() < iD);
            u(iD);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f14109b & 7;
        if (i10 == 0) {
            do {
                h9.g(abstractC0570i.u());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iD2 = abstractC0570i.d() + abstractC0570i.y();
        do {
            h9.g(abstractC0570i.u());
        } while (abstractC0570i.d() < iD2);
        u(iD2);
    }

    public final void r(List<String> list, boolean z8) throws C0586z.a {
        String strV;
        int iX;
        int iX2;
        if ((this.f14109b & 7) != 2) {
            throw C0586z.c();
        }
        boolean z9 = list instanceof D;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (z9 && !z8) {
            D d9 = (D) list;
            do {
                e();
                d9.d();
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        do {
            if (z8) {
                v(2);
                strV = abstractC0570i.w();
            } else {
                v(2);
                strV = abstractC0570i.v();
            }
            list.add(strV);
            if (abstractC0570i.e()) {
                return;
            } else {
                iX = abstractC0570i.x();
            }
        } while (iX == this.f14109b);
        this.f14111d = iX;
    }

    public final void s(List<Integer> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof C0584x;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0570i.y()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iD = abstractC0570i.d() + abstractC0570i.y();
            do {
                list.add(Integer.valueOf(abstractC0570i.y()));
            } while (abstractC0570i.d() < iD);
            u(iD);
            return;
        }
        C0584x c0584x = (C0584x) list;
        int i10 = this.f14109b & 7;
        if (i10 == 0) {
            do {
                c0584x.g(abstractC0570i.y());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iD2 = abstractC0570i.d() + abstractC0570i.y();
        do {
            c0584x.g(abstractC0570i.y());
        } while (abstractC0570i.d() < iD2);
        u(iD2);
    }

    public final void t(List<Long> list) throws C0586z {
        int iX;
        int iX2;
        boolean z8 = list instanceof H;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (!z8) {
            int i9 = this.f14109b & 7;
            if (i9 == 0) {
                do {
                    list.add(Long.valueOf(abstractC0570i.z()));
                    if (abstractC0570i.e()) {
                        return;
                    } else {
                        iX = abstractC0570i.x();
                    }
                } while (iX == this.f14109b);
                this.f14111d = iX;
                return;
            }
            if (i9 != 2) {
                throw C0586z.c();
            }
            int iD = abstractC0570i.d() + abstractC0570i.y();
            do {
                list.add(Long.valueOf(abstractC0570i.z()));
            } while (abstractC0570i.d() < iD);
            u(iD);
            return;
        }
        H h9 = (H) list;
        int i10 = this.f14109b & 7;
        if (i10 == 0) {
            do {
                h9.g(abstractC0570i.z());
                if (abstractC0570i.e()) {
                    return;
                } else {
                    iX2 = abstractC0570i.x();
                }
            } while (iX2 == this.f14109b);
            this.f14111d = iX2;
            return;
        }
        if (i10 != 2) {
            throw C0586z.c();
        }
        int iD2 = abstractC0570i.d() + abstractC0570i.y();
        do {
            h9.g(abstractC0570i.z());
        } while (abstractC0570i.d() < iD2);
        u(iD2);
    }

    public final void u(int i9) throws C0586z {
        if (this.f14108a.d() != i9) {
            throw C0586z.g();
        }
    }

    public final void v(int i9) throws C0586z.a {
        if ((this.f14109b & 7) != i9) {
            throw C0586z.c();
        }
    }

    public final boolean w() {
        int i9;
        AbstractC0570i abstractC0570i = this.f14108a;
        if (abstractC0570i.e() || (i9 = this.f14109b) == this.f14110c) {
            return false;
        }
        return abstractC0570i.A(i9);
    }
}
