package T;

import B0.C0301o;
import B0.C0302p;
import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: WindowInsetsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class Q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Q f4365b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f4366a;

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class c extends b {
        public c() {
        }

        @Override // T.Q.h
        public void d(int i9, K.b bVar) {
            this.f4372e.setInsets(s.a(i9), bVar.e());
        }

        public c(Q q8) {
            super(q8);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class d extends c {
        public d() {
        }

        public d(Q q8) {
            super(q8);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class e extends d {
        public e() {
        }

        @Override // T.Q.c, T.Q.h
        public void d(int i9, K.b bVar) {
            this.f4372e.setInsets(t.a(i9), bVar.e());
        }

        public e(Q q8) {
            super(q8);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class f extends e {
        public f() {
        }

        @Override // T.Q.e, T.Q.c, T.Q.h
        public void d(int i9, K.b bVar) {
            super.d(i9, bVar);
        }

        public f(Q q8) {
            super(q8);
            q8.f4366a.r();
        }

        @Override // T.Q.h
        public void c(Q q8) {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class g extends f {
        public g() {
        }

        public g(Q q8) {
            super(q8);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Q f4373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public K.b[] f4374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect[][] f4375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect[][] f4376d;

        public h() {
            this(new Q());
        }

        public final void a() {
            K.b[] bVarArr = this.f4374b;
            if (bVarArr != null) {
                K.b bVarH = bVarArr[0];
                K.b bVarH2 = bVarArr[1];
                Q q8 = this.f4373a;
                if (bVarH2 == null) {
                    bVarH2 = q8.f4366a.h(2);
                }
                if (bVarH == null) {
                    bVarH = q8.f4366a.h(1);
                }
                h(K.b.a(bVarH, bVarH2));
                K.b bVar = this.f4374b[r.a(16)];
                if (bVar != null) {
                    g(bVar);
                }
                K.b bVar2 = this.f4374b[r.a(32)];
                if (bVar2 != null) {
                    e(bVar2);
                }
                K.b bVar3 = this.f4374b[r.a(64)];
                if (bVar3 != null) {
                    i(bVar3);
                }
            }
        }

        public Q b() {
            throw null;
        }

        public void c(Q q8) {
            for (int i9 = 1; i9 <= 512; i9 <<= 1) {
                List<Rect> listE = q8.f4366a.e(i9);
                int iA = r.a(i9);
                this.f4375c[iA] = (Rect[]) listE.toArray(new Rect[listE.size()]);
                if (i9 != 8) {
                    List<Rect> listF = q8.f4366a.f(i9);
                    this.f4376d[iA] = (Rect[]) listF.toArray(new Rect[listF.size()]);
                }
            }
        }

        public void d(int i9, K.b bVar) {
            if (this.f4374b == null) {
                this.f4374b = new K.b[10];
            }
            for (int i10 = 1; i10 <= 512; i10 <<= 1) {
                if ((i9 & i10) != 0) {
                    this.f4374b[r.a(i10)] = bVar;
                }
            }
        }

        public void f(K.b bVar) {
            throw null;
        }

        public void h(K.b bVar) {
            throw null;
        }

        public h(Q q8) {
            this.f4375c = new Rect[10][];
            this.f4376d = new Rect[10][];
            this.f4373a = q8;
            c(q8);
        }

        public void e(K.b bVar) {
        }

        public void g(K.b bVar) {
        }

        public void i(K.b bVar) {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class j extends i {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public K.b f4391r;

        public j(Q q8, WindowInsets windowInsets) {
            super(q8, windowInsets);
            this.f4391r = null;
        }

        @Override // T.Q.q
        public Q b() {
            return Q.g(null, this.f4382c.consumeStableInsets());
        }

        @Override // T.Q.q
        public Q c() {
            return Q.g(null, this.f4382c.consumeSystemWindowInsets());
        }

        @Override // T.Q.q
        public final K.b k() {
            if (this.f4391r == null) {
                WindowInsets windowInsets = this.f4382c;
                this.f4391r = K.b.c(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
            }
            return this.f4391r;
        }

        @Override // T.Q.q
        public boolean r() {
            return this.f4382c.isConsumed();
        }

        @Override // T.Q.q
        public void x(K.b bVar) {
            this.f4391r = bVar;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class k extends j {
        public k(Q q8, WindowInsets windowInsets) {
            super(q8, windowInsets);
        }

        @Override // T.Q.q
        public Q a() {
            return Q.g(null, this.f4382c.consumeDisplayCutout());
        }

        @Override // T.Q.i, T.Q.q
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return Objects.equals(this.f4382c, kVar.f4382c) && Objects.equals(this.f4386g, kVar.f4386g) && i.L(this.f4387h, kVar.f4387h);
        }

        @Override // T.Q.q
        public C0419f g() {
            DisplayCutout displayCutout = this.f4382c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new C0419f(displayCutout);
        }

        @Override // T.Q.q
        public int hashCode() {
            return this.f4382c.hashCode();
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class n extends m {
        public n(Q q8, WindowInsets windowInsets) {
            super(q8, windowInsets);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static final class r {
        public static int a(int i9) {
            if (i9 == 1) {
                return 0;
            }
            if (i9 == 2) {
                return 1;
            }
            if (i9 == 4) {
                return 2;
            }
            if (i9 == 8) {
                return 3;
            }
            if (i9 == 16) {
                return 4;
            }
            if (i9 == 32) {
                return 5;
            }
            if (i9 == 64) {
                return 6;
            }
            if (i9 == 128) {
                return 7;
            }
            if (i9 == 256) {
                return 8;
            }
            if (i9 == 512) {
                return 9;
            }
            throw new IllegalArgumentException(W5.e.i(i9, "type needs to be >= FIRST and <= LAST, type="));
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static final class s {
        public static int a(int i9) {
            int iStatusBars;
            int i10 = 0;
            for (int i11 = 1; i11 <= 512; i11 <<= 1) {
                if ((i9 & i11) != 0) {
                    if (i11 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i11 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i11 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i11 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i11 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i11 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i11 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i11 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i10 |= iStatusBars;
                }
            }
            return i10;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static final class t {
        public static int a(int i9) {
            int iStatusBars;
            int i10 = 0;
            for (int i11 = 1; i11 <= 512; i11 <<= 1) {
                if ((i9 & i11) != 0) {
                    if (i11 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i11 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i11 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i11 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i11 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i11 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i11 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i11 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    } else if (i11 == 512) {
                        iStatusBars = WindowInsets.Type.systemOverlays();
                    }
                    i10 |= iStatusBars;
                }
            }
            return i10;
        }
    }

    static {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 34) {
            f4365b = o.f4395w;
        } else if (i9 >= 30) {
            f4365b = m.f4394v;
        } else {
            f4365b = q.f4396b;
        }
    }

    public Q(WindowInsets windowInsets) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 35) {
            this.f4366a = new p(this, windowInsets);
            return;
        }
        if (i9 >= 34) {
            this.f4366a = new o(this, windowInsets);
            return;
        }
        if (i9 >= 31) {
            this.f4366a = new n(this, windowInsets);
            return;
        }
        if (i9 >= 30) {
            this.f4366a = new m(this, windowInsets);
            return;
        }
        if (i9 >= 29) {
            this.f4366a = new l(this, windowInsets);
        } else if (i9 >= 28) {
            this.f4366a = new k(this, windowInsets);
        } else {
            this.f4366a = new j(this, windowInsets);
        }
    }

    public static K.b e(K.b bVar, int i9, int i10, int i11, int i12) {
        int iMax = Math.max(0, bVar.f2744a - i9);
        int iMax2 = Math.max(0, bVar.f2745b - i10);
        int iMax3 = Math.max(0, bVar.f2746c - i11);
        int iMax4 = Math.max(0, bVar.f2747d - i12);
        return (iMax == i9 && iMax2 == i10 && iMax3 == i11 && iMax4 == i12) ? bVar : K.b.c(iMax, iMax2, iMax3, iMax4);
    }

    public static Q g(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        Q q8 = new Q(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            Q qA = G.e.a(view);
            q qVar = q8.f4366a;
            qVar.w(qA);
            View rootView = view.getRootView();
            qVar.d(rootView);
            qVar.o(rootView);
            qVar.p();
            qVar.y(view.getWindowSystemUiVisibility());
        }
        return q8;
    }

    @Deprecated
    public final int a() {
        return this.f4366a.m().f2747d;
    }

    @Deprecated
    public final int b() {
        return this.f4366a.m().f2744a;
    }

    @Deprecated
    public final int c() {
        return this.f4366a.m().f2746c;
    }

    @Deprecated
    public final int d() {
        return this.f4366a.m().f2745b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q)) {
            return false;
        }
        return Objects.equals(this.f4366a, ((Q) obj).f4366a);
    }

    public final WindowInsets f() {
        q qVar = this.f4366a;
        if (qVar instanceof i) {
            return ((i) qVar).f4382c;
        }
        return null;
    }

    public final int hashCode() {
        q qVar = this.f4366a;
        if (qVar == null) {
            return 0;
        }
        return qVar.hashCode();
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class a extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Field f4367g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f4368h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Constructor<WindowInsets> f4369i = null;
        public static boolean j = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public WindowInsets f4370e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public K.b f4371f;

        public a() {
            this.f4370e = j();
        }

        private static WindowInsets j() {
            if (!f4368h) {
                try {
                    f4367g = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e9) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e9);
                }
                f4368h = true;
            }
            Field field = f4367g;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e10);
                }
            }
            if (!j) {
                try {
                    f4369i = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e11);
                }
                j = true;
            }
            Constructor<WindowInsets> constructor = f4369i;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e12);
                }
            }
            return null;
        }

        @Override // T.Q.h
        public Q b() {
            a();
            Q qG = Q.g(null, this.f4370e);
            K.b[] bVarArr = this.f4374b;
            q qVar = qG.f4366a;
            qVar.v(bVarArr);
            qVar.x(this.f4371f);
            qVar.u(null);
            qVar.z(this.f4375c);
            qVar.A(this.f4376d);
            return qG;
        }

        @Override // T.Q.h
        public void f(K.b bVar) {
            this.f4371f = bVar;
        }

        @Override // T.Q.h
        public void h(K.b bVar) {
            WindowInsets windowInsets = this.f4370e;
            if (windowInsets != null) {
                this.f4370e = windowInsets.replaceSystemWindowInsets(bVar.f2744a, bVar.f2745b, bVar.f2746c, bVar.f2747d);
            }
        }

        public a(Q q8) {
            super(q8);
            this.f4370e = q8.f();
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class b extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final WindowInsets.Builder f4372e;

        public b() {
            this.f4372e = C0301o.m();
        }

        @Override // T.Q.h
        public Q b() {
            a();
            Q qG = Q.g(null, this.f4372e.build());
            K.b[] bVarArr = this.f4374b;
            q qVar = qG.f4366a;
            qVar.v(bVarArr);
            qVar.u(null);
            qVar.z(this.f4375c);
            qVar.A(this.f4376d);
            return qG;
        }

        @Override // T.Q.h
        public void e(K.b bVar) {
            this.f4372e.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // T.Q.h
        public void f(K.b bVar) {
            this.f4372e.setStableInsets(bVar.e());
        }

        @Override // T.Q.h
        public void g(K.b bVar) {
            this.f4372e.setSystemGestureInsets(bVar.e());
        }

        @Override // T.Q.h
        public void h(K.b bVar) {
            this.f4372e.setSystemWindowInsets(bVar.e());
        }

        @Override // T.Q.h
        public void i(K.b bVar) {
            this.f4372e.setTappableElementInsets(bVar.e());
        }

        public b(Q q8) {
            WindowInsets.Builder builderM;
            super(q8);
            WindowInsets windowInsetsF = q8.f();
            if (windowInsetsF != null) {
                builderM = C0302p.n(windowInsetsF);
            } else {
                builderM = C0301o.m();
            }
            this.f4372e = builderM;
        }
    }

    public Q() {
        this.f4366a = new q(this);
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class p extends o {
        public p(Q q8, WindowInsets windowInsets) {
            super(q8, windowInsets);
        }

        @Override // T.Q.i, T.Q.q
        public List<Rect> e(int i9) {
            return this.f4382c.getBoundingRects(t.a(i9));
        }

        @Override // T.Q.i, T.Q.q
        public List<Rect> f(int i9) {
            return this.f4382c.getBoundingRectsIgnoringVisibility(t.a(i9));
        }

        @Override // T.Q.i, T.Q.q
        public void p() {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Q f4396b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Q f4397a;

        static {
            h bVar;
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 36) {
                bVar = new g();
            } else if (i9 >= 35) {
                bVar = new f();
            } else if (i9 >= 34) {
                bVar = new e();
            } else if (i9 >= 31) {
                bVar = new d();
            } else if (i9 >= 30) {
                bVar = new c();
            } else {
                bVar = i9 >= 29 ? new b() : new a();
            }
            f4396b = bVar.b().f4366a.a().f4366a.b().f4366a.c();
        }

        public q(Q q8) {
            this.f4397a = q8;
        }

        public Q a() {
            return this.f4397a;
        }

        public Q b() {
            return this.f4397a;
        }

        public Q c() {
            return this.f4397a;
        }

        public List<Rect> e(int i9) {
            return Collections.EMPTY_LIST;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof q)) {
                return false;
            }
            q qVar = (q) obj;
            return s() == qVar.s() && r() == qVar.r() && Objects.equals(m(), qVar.m()) && Objects.equals(k(), qVar.k()) && Objects.equals(g(), qVar.g());
        }

        public List<Rect> f(int i9) {
            return Collections.EMPTY_LIST;
        }

        public C0419f g() {
            return null;
        }

        public K.b h(int i9) {
            return K.b.f2743e;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(s()), Boolean.valueOf(r()), m(), k(), g());
        }

        public K.b i(int i9) {
            if ((i9 & 8) == 0) {
                return K.b.f2743e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public K.b j() {
            return m();
        }

        public K.b k() {
            return K.b.f2743e;
        }

        public K.b l() {
            return m();
        }

        public K.b m() {
            return K.b.f2743e;
        }

        public K.b n() {
            return m();
        }

        public Q q(int i9, int i10, int i11, int i12) {
            return f4396b;
        }

        public boolean r() {
            return false;
        }

        public boolean s() {
            return false;
        }

        public boolean t(int i9) {
            return true;
        }

        public void p() {
        }

        public void A(Rect[][] rectArr) {
        }

        public void d(View view) {
        }

        public void o(View view) {
        }

        public void u(C0420g c0420g) {
        }

        public void v(K.b[] bVarArr) {
        }

        public void w(Q q8) {
        }

        public void x(K.b bVar) {
        }

        public void y(int i9) {
        }

        public void z(Rect[][] rectArr) {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class i extends q {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static boolean f4377m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static Method f4378n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static Class<?> f4379o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static Field f4380p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static Field f4381q;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f4382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public K.b[] f4383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public K.b f4384e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Q f4385f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public K.b f4386g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4387h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4388i;
        public int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Rect[][] f4389k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Rect[][] f4390l;

        public i(Q q8, WindowInsets windowInsets) {
            super(q8);
            this.f4384e = null;
            this.f4389k = new Rect[10][];
            this.f4390l = new Rect[10][];
            this.f4382c = windowInsets;
        }

        private C0420g B(View view) {
            Display display;
            if (view == null || (display = view.getDisplay()) == null) {
                return null;
            }
            Point point = new Point();
            display.getRealSize(point);
            if (this.f4397a.f4366a.s()) {
                return C0420g.a(point.x, point.y, true, 0, 0, 0, 0);
            }
            C0435w c0435wA = C0418e.a(display, 0);
            C0435w c0435wA2 = C0418e.a(display, 1);
            C0435w c0435wA3 = C0418e.a(display, 2);
            C0435w c0435wA4 = C0418e.a(display, 3);
            return C0420g.a(point.x, point.y, false, c0435wA != null ? c0435wA.f4456b : 0, c0435wA2 != null ? c0435wA2.f4456b : 0, c0435wA3 != null ? c0435wA3.f4456b : 0, c0435wA4 != null ? c0435wA4.f4456b : 0);
        }

        private static List<Rect> C(Rect[][] rectArr, int i9) {
            Rect[] rectArr2;
            Rect[] rectArr3 = null;
            for (int i10 = 1; i10 <= 512; i10 <<= 1) {
                if ((i9 & i10) != 0 && (rectArr2 = rectArr[r.a(i10)]) != null) {
                    if (rectArr3 == null) {
                        rectArr3 = rectArr2;
                    } else {
                        Rect[] rectArr4 = new Rect[rectArr3.length + rectArr2.length];
                        System.arraycopy(rectArr3, 0, rectArr4, 0, rectArr3.length);
                        System.arraycopy(rectArr2, 0, rectArr4, rectArr3.length, rectArr2.length);
                        rectArr3 = rectArr4;
                    }
                }
            }
            return rectArr3 == null ? Collections.EMPTY_LIST : Arrays.asList(rectArr3);
        }

        private Rect[] D(K.b bVar) {
            ArrayList arrayList = new ArrayList();
            if (bVar.f2744a != 0) {
                arrayList.add(new Rect(0, 0, bVar.f2744a, this.f4388i));
            }
            int i9 = bVar.f2745b;
            if (i9 != 0) {
                arrayList.add(new Rect(0, 0, this.j, i9));
            }
            int i10 = bVar.f2746c;
            if (i10 != 0) {
                int i11 = this.j;
                arrayList.add(new Rect(i11 - i10, 0, i11, this.f4388i));
            }
            int i12 = bVar.f2747d;
            if (i12 != 0) {
                int i13 = this.f4388i;
                arrayList.add(new Rect(0, i13 - i12, this.j, i13));
            }
            return (Rect[]) arrayList.toArray(new Rect[arrayList.size()]);
        }

        @SuppressLint({"WrongConstant"})
        private K.b E(int i9, boolean z8) {
            K.b bVarA = K.b.f2743e;
            for (int i10 = 1; i10 <= 512; i10 <<= 1) {
                if ((i9 & i10) != 0) {
                    bVarA = K.b.a(bVarA, F(i10, z8));
                }
            }
            return bVarA;
        }

        private K.b G() {
            Q q8 = this.f4385f;
            return q8 != null ? q8.f4366a.k() : K.b.f2743e;
        }

        private K.b H(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f4377m) {
                J();
            }
            Method method = f4378n;
            if (method != null && f4379o != null && f4380p != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f4380p.get(f4381q.get(objInvoke));
                    if (rect != null) {
                        return K.b.c(rect.left, rect.top, rect.right, rect.bottom);
                    }
                    return null;
                } catch (ReflectiveOperationException e9) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e9.getMessage(), e9);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void J() {
            try {
                f4378n = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f4379o = cls;
                f4380p = cls.getDeclaredField("mVisibleInsets");
                f4381q = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f4380p.setAccessible(true);
                f4381q.setAccessible(true);
            } catch (ReflectiveOperationException e9) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e9.getMessage(), e9);
            }
            f4377m = true;
        }

        public static boolean L(int i9, int i10) {
            return (i9 & 6) == (i10 & 6);
        }

        @Override // T.Q.q
        public void A(Rect[][] rectArr) {
            Objects.requireNonNull(rectArr);
            this.f4390l = (Rect[][]) rectArr.clone();
        }

        public K.b F(int i9, boolean z8) {
            K.b bVarK;
            int i10;
            K.b bVar = K.b.f2743e;
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 == 8) {
                        K.b[] bVarArr = this.f4383d;
                        bVarK = bVarArr != null ? bVarArr[r.a(8)] : null;
                        if (bVarK != null) {
                            return bVarK;
                        }
                        K.b bVarM = m();
                        K.b bVarG = G();
                        int i11 = bVarM.f2747d;
                        if (i11 > bVarG.f2747d) {
                            return K.b.c(0, 0, 0, i11);
                        }
                        K.b bVar2 = this.f4386g;
                        if (bVar2 != null && !bVar2.equals(bVar) && (i10 = this.f4386g.f2747d) > bVarG.f2747d) {
                            return K.b.c(0, 0, 0, i10);
                        }
                    } else {
                        if (i9 == 16) {
                            return l();
                        }
                        if (i9 == 32) {
                            return j();
                        }
                        if (i9 == 64) {
                            return n();
                        }
                        if (i9 == 128) {
                            Q q8 = this.f4385f;
                            C0419f c0419fG = q8 != null ? q8.f4366a.g() : g();
                            if (c0419fG != null) {
                                int i12 = Build.VERSION.SDK_INT;
                                return K.b.c(i12 >= 28 ? C0419f.a.b(c0419fG.f4426a) : 0, i12 >= 28 ? C0419f.a.d(c0419fG.f4426a) : 0, i12 >= 28 ? C0419f.a.c(c0419fG.f4426a) : 0, i12 >= 28 ? C0419f.a.a(c0419fG.f4426a) : 0);
                            }
                        }
                    }
                } else {
                    if (z8) {
                        K.b bVarG2 = G();
                        K.b bVarK2 = k();
                        return K.b.c(Math.max(bVarG2.f2744a, bVarK2.f2744a), 0, Math.max(bVarG2.f2746c, bVarK2.f2746c), Math.max(bVarG2.f2747d, bVarK2.f2747d));
                    }
                    if ((this.f4387h & 2) == 0) {
                        K.b bVarM2 = m();
                        Q q9 = this.f4385f;
                        bVarK = q9 != null ? q9.f4366a.k() : null;
                        int iMin = bVarM2.f2747d;
                        if (bVarK != null) {
                            iMin = Math.min(iMin, bVarK.f2747d);
                        }
                        return K.b.c(bVarM2.f2744a, 0, bVarM2.f2746c, iMin);
                    }
                }
            } else {
                if (z8) {
                    return K.b.c(0, Math.max(G().f2745b, m().f2745b), 0, 0);
                }
                if ((this.f4387h & 4) == 0) {
                    return K.b.c(0, m().f2745b, 0, 0);
                }
            }
            return bVar;
        }

        public boolean I(int i9) {
            if (i9 != 1 && i9 != 2) {
                if (i9 == 4) {
                    return false;
                }
                if (i9 != 8 && i9 != 128) {
                    return true;
                }
            }
            return !F(i9, false).equals(K.b.f2743e);
        }

        public void K(K.b bVar) {
            this.f4386g = bVar;
        }

        @Override // T.Q.q
        public void d(View view) {
            this.j = view.getWidth();
            this.f4388i = view.getHeight();
            K.b bVarH = H(view);
            if (bVarH == null) {
                bVarH = K.b.f2743e;
            }
            K(bVarH);
        }

        @Override // T.Q.q
        public List<Rect> e(int i9) {
            return C(this.f4389k, i9);
        }

        @Override // T.Q.q
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f4386g, iVar.f4386g) && L(this.f4387h, iVar.f4387h);
        }

        @Override // T.Q.q
        public List<Rect> f(int i9) {
            return C(this.f4390l, i9);
        }

        @Override // T.Q.q
        public K.b h(int i9) {
            return E(i9, false);
        }

        @Override // T.Q.q
        public K.b i(int i9) {
            return E(i9, true);
        }

        @Override // T.Q.q
        public final K.b m() {
            if (this.f4384e == null) {
                WindowInsets windowInsets = this.f4382c;
                this.f4384e = K.b.c(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            return this.f4384e;
        }

        @Override // T.Q.q
        public void o(View view) {
            B(view);
        }

        @Override // T.Q.q
        @SuppressLint({"WrongConstant"})
        public void p() {
            for (int i9 = 1; i9 <= 512; i9 <<= 1) {
                int iA = r.a(i9);
                this.f4389k[iA] = D(h(i9));
                if (i9 != 8) {
                    this.f4390l[iA] = D(i(i9));
                }
            }
        }

        @Override // T.Q.q
        public Q q(int i9, int i10, int i11, int i12) {
            h bVar;
            Q qG = Q.g(null, this.f4382c);
            int i13 = Build.VERSION.SDK_INT;
            if (i13 >= 36) {
                bVar = new g(qG);
            } else if (i13 >= 35) {
                bVar = new f(qG);
            } else if (i13 >= 34) {
                bVar = new e(qG);
            } else if (i13 >= 31) {
                bVar = new d(qG);
            } else if (i13 >= 30) {
                bVar = new c(qG);
            } else {
                bVar = i13 >= 29 ? new b(qG) : new a(qG);
            }
            bVar.h(Q.e(m(), i9, i10, i11, i12));
            bVar.f(Q.e(k(), i9, i10, i11, i12));
            return bVar.b();
        }

        @Override // T.Q.q
        public boolean s() {
            return this.f4382c.isRound();
        }

        @Override // T.Q.q
        @SuppressLint({"WrongConstant"})
        public boolean t(int i9) {
            for (int i10 = 1; i10 <= 512; i10 <<= 1) {
                if ((i9 & i10) != 0 && !I(i10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // T.Q.q
        public void v(K.b[] bVarArr) {
            this.f4383d = bVarArr;
        }

        @Override // T.Q.q
        public void w(Q q8) {
            this.f4385f = q8;
        }

        @Override // T.Q.q
        public void y(int i9) {
            this.f4387h = i9;
        }

        @Override // T.Q.q
        public void z(Rect[][] rectArr) {
            Objects.requireNonNull(rectArr);
            this.f4389k = (Rect[][]) rectArr.clone();
        }

        @Override // T.Q.q
        public void u(C0420g c0420g) {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class l extends k {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public K.b f4392s;
        public K.b t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public K.b f4393u;

        public l(Q q8, WindowInsets windowInsets) {
            super(q8, windowInsets);
            this.f4392s = null;
            this.t = null;
            this.f4393u = null;
        }

        @Override // T.Q.q
        public K.b j() {
            if (this.t == null) {
                this.t = K.b.d(this.f4382c.getMandatorySystemGestureInsets());
            }
            return this.t;
        }

        @Override // T.Q.q
        public K.b l() {
            if (this.f4392s == null) {
                this.f4392s = K.b.d(this.f4382c.getSystemGestureInsets());
            }
            return this.f4392s;
        }

        @Override // T.Q.q
        public K.b n() {
            if (this.f4393u == null) {
                this.f4393u = K.b.d(this.f4382c.getTappableElementInsets());
            }
            return this.f4393u;
        }

        @Override // T.Q.i, T.Q.q
        public Q q(int i9, int i10, int i11, int i12) {
            return Q.g(null, this.f4382c.inset(i9, i10, i11, i12));
        }

        @Override // T.Q.j, T.Q.q
        public void x(K.b bVar) {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class m extends l {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final Q f4394v = Q.g(null, WindowInsets.CONSUMED);

        public m(Q q8, WindowInsets windowInsets) {
            super(q8, windowInsets);
        }

        @Override // T.Q.i, T.Q.q
        public K.b h(int i9) {
            return K.b.d(this.f4382c.getInsets(s.a(i9)));
        }

        @Override // T.Q.i, T.Q.q
        public K.b i(int i9) {
            return K.b.d(this.f4382c.getInsetsIgnoringVisibility(s.a(i9)));
        }

        @Override // T.Q.i, T.Q.q
        public boolean t(int i9) {
            return this.f4382c.isVisible(s.a(i9));
        }

        @Override // T.Q.i, T.Q.q
        public final void d(View view) {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static class o extends n {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final Q f4395w = Q.g(null, WindowInsets.CONSUMED);

        public o(Q q8, WindowInsets windowInsets) {
            super(q8, windowInsets);
        }

        @Override // T.Q.m, T.Q.i, T.Q.q
        public K.b h(int i9) {
            return K.b.d(this.f4382c.getInsets(t.a(i9)));
        }

        @Override // T.Q.m, T.Q.i, T.Q.q
        public K.b i(int i9) {
            return K.b.d(this.f4382c.getInsetsIgnoringVisibility(t.a(i9)));
        }

        @Override // T.Q.m, T.Q.i, T.Q.q
        public boolean t(int i9) {
            return this.f4382c.isVisible(t.a(i9));
        }

        @Override // T.Q.i, T.Q.q
        public void o(View view) {
        }
    }
}
