package androidx.recyclerview.widget;

import T.C0414a;
import T.C0428o;
import T.G;
import T.InterfaceC0427n;
import T.L;
import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import androidx.datastore.preferences.protobuf.C0524s;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements InterfaceC0427n {

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public static final int[] f7974D0 = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public static final Class<?>[] f7975E0;
    public static final b F0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f7976A;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public final ArrayList f7977A0;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f7978B;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public final a f7979B0;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public h f7980C;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public final c f7981C0;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public EdgeEffect f7982D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public EdgeEffect f7983E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public EdgeEffect f7984F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public EdgeEffect f7985G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public i f7986H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f7987I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f7988J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public VelocityTracker f7989K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int f7990L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public int f7991M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public int f7992N;
    public int O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public int f7993P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public n f7994Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public final int f7995R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final int f7996S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final float f7997T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final float f7998U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f7999V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final x f8000W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f8001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f8002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SavedState f8003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0549a f8004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0550b f8005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C f8006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f8008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f8009i;
    public final RectF j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f8010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l f8011l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public androidx.recyclerview.widget.m f8012l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<k> f8013m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final androidx.recyclerview.widget.m.b f8014m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<o> f8015n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final v f8016n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o f8017o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public p f8018o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f8019p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public ArrayList f8020p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f8021q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f8022q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8023r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f8024r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f8025s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final j f8026s0;
    public boolean t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f8027t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8028u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public androidx.recyclerview.widget.x f8029u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f8030v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final int[] f8031v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8032w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public C0428o f8033w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AccessibilityManager f8034x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final int[] f8035x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f8036y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final int[] f8037y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f8038z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final int[] f8039z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Parcelable f8040c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i9) {
                return new SavedState[i9];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8040c = parcel.readParcelable(classLoader == null ? l.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeParcelable(this.f8040c, 0);
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long j;
            RecyclerView recyclerView = RecyclerView.this;
            i iVar = recyclerView.f7986H;
            if (iVar != null) {
                androidx.recyclerview.widget.k kVar = (androidx.recyclerview.widget.k) iVar;
                ArrayList<y> arrayList = kVar.f8239h;
                boolean zIsEmpty = arrayList.isEmpty();
                ArrayList<androidx.recyclerview.widget.k.b> arrayList2 = kVar.j;
                boolean zIsEmpty2 = arrayList2.isEmpty();
                ArrayList<androidx.recyclerview.widget.k.a> arrayList3 = kVar.f8241k;
                boolean zIsEmpty3 = arrayList3.isEmpty();
                ArrayList<y> arrayList4 = kVar.f8240i;
                boolean zIsEmpty4 = arrayList4.isEmpty();
                if (!zIsEmpty || !zIsEmpty2 || !zIsEmpty4 || !zIsEmpty3) {
                    Iterator<y> it = arrayList.iterator();
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        j = kVar.f8048d;
                        if (!zHasNext) {
                            break;
                        }
                        y next = it.next();
                        View view = next.f8129a;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        kVar.f8247q.add(next);
                        viewPropertyAnimatorAnimate.setDuration(j).alpha(0.0f).setListener(new androidx.recyclerview.widget.f(view, viewPropertyAnimatorAnimate, kVar, next)).start();
                        arrayList = arrayList;
                    }
                    arrayList.clear();
                    if (!zIsEmpty2) {
                        ArrayList<androidx.recyclerview.widget.k.b> arrayList5 = new ArrayList<>();
                        arrayList5.addAll(arrayList2);
                        kVar.f8243m.add(arrayList5);
                        arrayList2.clear();
                        RunnableC0551c runnableC0551c = new RunnableC0551c(kVar, arrayList5);
                        if (zIsEmpty) {
                            runnableC0551c.run();
                        } else {
                            View view2 = arrayList5.get(0).f8255a.f8129a;
                            WeakHashMap<View, L> weakHashMap = G.f4313a;
                            view2.postOnAnimationDelayed(runnableC0551c, j);
                        }
                    }
                    if (!zIsEmpty3) {
                        ArrayList<androidx.recyclerview.widget.k.a> arrayList6 = new ArrayList<>();
                        arrayList6.addAll(arrayList3);
                        kVar.f8244n.add(arrayList6);
                        arrayList3.clear();
                        androidx.recyclerview.widget.d dVar = new androidx.recyclerview.widget.d(kVar, arrayList6);
                        if (zIsEmpty) {
                            dVar.run();
                        } else {
                            View view3 = arrayList6.get(0).f8249a.f8129a;
                            WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                            view3.postOnAnimationDelayed(dVar, j);
                        }
                    }
                    if (!zIsEmpty4) {
                        ArrayList<y> arrayList7 = new ArrayList<>();
                        arrayList7.addAll(arrayList4);
                        kVar.f8242l.add(arrayList7);
                        arrayList4.clear();
                        androidx.recyclerview.widget.e eVar = new androidx.recyclerview.widget.e(kVar, arrayList7);
                        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
                            eVar.run();
                        } else {
                            if (zIsEmpty) {
                                j = 0;
                            }
                            long jMax = Math.max(!zIsEmpty2 ? kVar.f8049e : 0L, zIsEmpty3 ? 0L : kVar.f8050f) + j;
                            View view4 = arrayList7.get(0).f8129a;
                            WeakHashMap<View, L> weakHashMap3 = G.f4313a;
                            view4.postOnAnimationDelayed(eVar, jMax);
                        }
                    }
                }
            }
            recyclerView.f8027t0 = false;
        }
    }

    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f6) {
            float f9 = f6 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    }

    public class c {
        public c() {
        }

        public final void a(y yVar, i.b bVar, i.b bVar2) {
            boolean zG;
            int i9;
            int i10;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.getClass();
            yVar.n(false);
            z zVar = (z) recyclerView.f7986H;
            zVar.getClass();
            if (bVar == null || ((i9 = bVar.f8051a) == (i10 = bVar2.f8051a) && bVar.f8052b == bVar2.f8052b)) {
                androidx.recyclerview.widget.k kVar = (androidx.recyclerview.widget.k) zVar;
                kVar.l(yVar);
                yVar.f8129a.setAlpha(0.0f);
                kVar.f8240i.add(yVar);
                zG = true;
            } else {
                zG = zVar.g(yVar, i9, bVar.f8052b, i10, bVar2.f8052b);
            }
            if (zG) {
                recyclerView.S();
            }
        }

        public final void b(y yVar, i.b bVar, i.b bVar2) {
            boolean zG;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f8002b.j(yVar);
            recyclerView.f(yVar);
            yVar.n(false);
            z zVar = (z) recyclerView.f7986H;
            zVar.getClass();
            int i9 = bVar.f8051a;
            int i10 = bVar.f8052b;
            View view = yVar.f8129a;
            int left = bVar2 == null ? view.getLeft() : bVar2.f8051a;
            int top = bVar2 == null ? view.getTop() : bVar2.f8052b;
            if (yVar.h() || (i9 == left && i10 == top)) {
                androidx.recyclerview.widget.k kVar = (androidx.recyclerview.widget.k) zVar;
                kVar.l(yVar);
                kVar.f8239h.add(yVar);
                zG = true;
            } else {
                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                zG = zVar.g(yVar, i9, i10, left, top);
            }
            if (zG) {
                recyclerView.S();
            }
        }
    }

    public static abstract class d<VH extends y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f8043a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8044b = false;

        public abstract int a();

        public long b(int i9) {
            return -1L;
        }

        public abstract void c(VH vh, int i9);

        public abstract y d(ViewGroup viewGroup);
    }

    public static class e extends Observable<f> {
        public final boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public final void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((f) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    public interface g {
    }

    public static class h {
    }

    public static abstract class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f8045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<a> f8046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8049e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8050f;

        public interface a {
            void a();
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8051a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8052b;

            public final void a(y yVar) {
                View view = yVar.f8129a;
                this.f8051a = view.getLeft();
                this.f8052b = view.getTop();
                view.getRight();
                view.getBottom();
            }
        }

        public static void b(y yVar) {
            RecyclerView recyclerView;
            int i9 = yVar.j;
            if (yVar.f() || (i9 & 4) != 0 || (recyclerView = yVar.f8145r) == null) {
                return;
            }
            recyclerView.F(yVar);
        }

        public abstract boolean a(y yVar, y yVar2, b bVar, b bVar2);

        public final void c(y yVar) {
            j jVar = this.f8045a;
            if (jVar != null) {
                boolean z8 = true;
                yVar.n(true);
                if (yVar.f8136h != null && yVar.f8137i == null) {
                    yVar.f8136h = null;
                }
                yVar.f8137i = null;
                if ((yVar.j & 16) != 0) {
                    return;
                }
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.b0();
                C0550b c0550b = recyclerView.f8005e;
                androidx.recyclerview.widget.v vVar = c0550b.f8205a;
                RecyclerView recyclerView2 = vVar.f8331a;
                View view = yVar.f8129a;
                int iIndexOfChild = recyclerView2.indexOfChild(view);
                if (iIndexOfChild == -1) {
                    c0550b.j(view);
                } else {
                    C0550b.a aVar = c0550b.f8206b;
                    if (aVar.d(iIndexOfChild)) {
                        aVar.f(iIndexOfChild);
                        c0550b.j(view);
                        vVar.a(iIndexOfChild);
                    } else {
                        z8 = false;
                    }
                }
                if (z8) {
                    y yVarI = RecyclerView.I(view);
                    r rVar = recyclerView.f8002b;
                    rVar.j(yVarI);
                    rVar.g(yVarI);
                }
                recyclerView.c0(!z8);
                if (z8 || !yVar.j()) {
                    return;
                }
                recyclerView.removeDetachedView(view, false);
            }
        }

        public abstract void d(y yVar);

        public abstract void e();

        public abstract boolean f();
    }

    public class j {
        public j() {
        }
    }

    public static abstract class n {
    }

    public interface o {
        void a(MotionEvent motionEvent);

        boolean b(MotionEvent motionEvent);
    }

    public static class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray<a> f8078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8079b;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList<y> f8080a = new ArrayList<>();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f8081b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f8082c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f8083d = 0;
        }

        public final a a(int i9) {
            SparseArray<a> sparseArray = this.f8078a;
            a aVar = sparseArray.get(i9);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            sparseArray.put(i9, aVar2);
            return aVar2;
        }
    }

    public final class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<y> f8084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<y> f8085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<y> f8086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<y> f8087d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8088e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8089f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public q f8090g;

        public r() {
            ArrayList<y> arrayList = new ArrayList<>();
            this.f8084a = arrayList;
            this.f8085b = null;
            this.f8086c = new ArrayList<>();
            this.f8087d = Collections.unmodifiableList(arrayList);
            this.f8088e = 2;
            this.f8089f = 2;
        }

        public final void a(y yVar, boolean z8) {
            RecyclerView.j(yVar);
            RecyclerView recyclerView = RecyclerView.this;
            androidx.recyclerview.widget.x xVar = recyclerView.f8029u0;
            if (xVar != null) {
                androidx.recyclerview.widget.x.a aVar = xVar.f8334e;
                View view = yVar.f8129a;
                G.m(view, aVar != null ? (C0414a) aVar.f8336e.remove(view) : null);
            }
            if (z8 && recyclerView.f8016n0 != null) {
                recyclerView.f8006f.d(yVar);
            }
            yVar.f8145r = null;
            q qVarC = c();
            qVarC.getClass();
            int i9 = yVar.f8134f;
            ArrayList<y> arrayList = qVarC.a(i9).f8080a;
            if (qVarC.f8078a.get(i9).f8081b <= arrayList.size()) {
                return;
            }
            yVar.m();
            arrayList.add(yVar);
        }

        public final int b(int i9) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i9 >= 0 && i9 < recyclerView.f8016n0.b()) {
                return !recyclerView.f8016n0.f8114g ? i9 : recyclerView.f8004d.e(i9, 0);
            }
            StringBuilder sbA = C0524s.a(i9, "invalid position ", ". State item count is ");
            sbA.append(recyclerView.f8016n0.b());
            sbA.append(recyclerView.y());
            throw new IndexOutOfBoundsException(sbA.toString());
        }

        public final q c() {
            if (this.f8090g == null) {
                q qVar = new q();
                qVar.f8078a = new SparseArray<>();
                qVar.f8079b = 0;
                this.f8090g = qVar;
            }
            return this.f8090g;
        }

        public final void d() {
            ArrayList<y> arrayList = this.f8086c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                e(size);
            }
            arrayList.clear();
            int[] iArr = RecyclerView.f7974D0;
            androidx.recyclerview.widget.m.b bVar = RecyclerView.this.f8014m0;
            int[] iArr2 = bVar.f8301c;
            if (iArr2 != null) {
                Arrays.fill(iArr2, -1);
            }
            bVar.f8302d = 0;
        }

        public final void e(int i9) {
            ArrayList<y> arrayList = this.f8086c;
            a(arrayList.get(i9), true);
            arrayList.remove(i9);
        }

        public final void f(View view) {
            y yVarI = RecyclerView.I(view);
            boolean zJ = yVarI.j();
            RecyclerView recyclerView = RecyclerView.this;
            if (zJ) {
                recyclerView.removeDetachedView(view, false);
            }
            if (yVarI.i()) {
                yVarI.f8141n.j(yVarI);
            } else if (yVarI.p()) {
                yVarI.j &= -33;
            }
            g(yVarI);
            if (recyclerView.f7986H == null || yVarI.g()) {
                return;
            }
            recyclerView.f7986H.d(yVarI);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0030  */
        /* JADX WARN: Code duplicated, block: B:40:0x0075  */
        /* JADX WARN: Code duplicated, block: B:42:0x0083  */
        /* JADX WARN: Code duplicated, block: B:44:0x008a  */
        /* JADX WARN: Code duplicated, block: B:47:0x0093 A[LOOP:2: B:43:0x0088->B:47:0x0093, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:74:0x0096 A[EDGE_INSN: B:74:0x0096->B:48:0x0096 BREAK  A[LOOP:1: B:39:0x0073->B:46:0x0090], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:75:0x0096 A[EDGE_INSN: B:75:0x0096->B:48:0x0096 BREAK  A[LOOP:1: B:39:0x0073->B:46:0x0090, LOOP_LABEL: LOOP:1: B:39:0x0073->B:46:0x0090], SYNTHETIC] */
        public final void g(y yVar) {
            boolean z8;
            boolean z9;
            int i9;
            int i10;
            androidx.recyclerview.widget.m.b bVar;
            int i11;
            int i12;
            boolean zI = yVar.i();
            boolean z10 = false;
            boolean z11 = true;
            RecyclerView recyclerView = RecyclerView.this;
            View view = yVar.f8129a;
            if (zI || view.getParent() != null) {
                StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(yVar.i());
                sb.append(" isAttached:");
                sb.append(view.getParent() != null);
                sb.append(recyclerView.y());
                throw new IllegalArgumentException(sb.toString());
            }
            if (yVar.j()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + yVar + recyclerView.y());
            }
            if (yVar.o()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + recyclerView.y());
            }
            if ((yVar.j & 16) == 0) {
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                if (view.hasTransientState()) {
                    z8 = true;
                } else {
                    z8 = false;
                }
            } else {
                z8 = false;
            }
            d dVar = recyclerView.f8010k;
            if (yVar.g()) {
                if (this.f8089f <= 0 || (yVar.j & 526) != 0) {
                    z9 = false;
                } else {
                    ArrayList<y> arrayList = this.f8086c;
                    int size = arrayList.size();
                    if (size >= this.f8089f && size > 0) {
                        e(0);
                        size--;
                    }
                    int[] iArr = RecyclerView.f7974D0;
                    if (size > 0) {
                        androidx.recyclerview.widget.m.b bVar2 = recyclerView.f8014m0;
                        int i13 = yVar.f8131c;
                        if (bVar2.f8301c != null) {
                            int i14 = bVar2.f8302d * 2;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= i14) {
                                    i9 = size - 1;
                                    loop1: while (i9 >= 0) {
                                        i10 = arrayList.get(i9).f8131c;
                                        bVar = recyclerView.f8014m0;
                                        if (bVar.f8301c != null) {
                                            break;
                                        }
                                        i11 = bVar.f8302d * 2;
                                        i12 = 0;
                                        while (true) {
                                            if (i12 < i11) {
                                                break loop1;
                                            } else if (bVar.f8301c[i12] == i10) {
                                                break;
                                            } else {
                                                i12 += 2;
                                            }
                                        }
                                        i9--;
                                    }
                                    size = i9 + 1;
                                } else if (bVar2.f8301c[i15] != i13) {
                                    i15 += 2;
                                }
                            }
                        } else {
                            i9 = size - 1;
                            loop1: while (i9 >= 0) {
                                i10 = arrayList.get(i9).f8131c;
                                bVar = recyclerView.f8014m0;
                                if (bVar.f8301c != null) {
                                    break;
                                    break;
                                }
                                i11 = bVar.f8302d * 2;
                                i12 = 0;
                                while (true) {
                                    if (i12 < i11) {
                                        break loop1;
                                        break loop1;
                                    } else if (bVar.f8301c[i12] == i10) {
                                        break;
                                    } else {
                                        i12 += 2;
                                    }
                                }
                                i9--;
                            }
                            size = i9 + 1;
                        }
                    }
                    arrayList.add(size, yVar);
                    z9 = true;
                }
                if (z9) {
                    z11 = false;
                } else {
                    a(yVar, true);
                }
                z10 = z9;
            } else {
                z11 = false;
            }
            recyclerView.f8006f.d(yVar);
            if (z10 || z11 || !z8) {
                return;
            }
            yVar.f8145r = null;
        }

        public final void h(View view) {
            i iVar;
            y yVarI = RecyclerView.I(view);
            boolean z8 = (yVarI.j & 12) != 0;
            RecyclerView recyclerView = RecyclerView.this;
            if (!z8 && yVarI.k() && (iVar = recyclerView.f7986H) != null) {
                androidx.recyclerview.widget.k kVar = (androidx.recyclerview.widget.k) iVar;
                if (yVarI.c().isEmpty() && kVar.f8337g && !yVarI.f()) {
                    if (this.f8085b == null) {
                        this.f8085b = new ArrayList<>();
                    }
                    yVarI.f8141n = this;
                    yVarI.f8142o = true;
                    this.f8085b.add(yVarI);
                    return;
                }
            }
            if (yVarI.f() && !yVarI.h() && !recyclerView.f8010k.f8044b) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + recyclerView.y());
            }
            yVarI.f8141n = this;
            yVarI.f8142o = false;
            this.f8084a.add(yVarI);
        }

        /* JADX WARN: Code duplicated, block: B:110:0x01cf  */
        /* JADX WARN: Code duplicated, block: B:111:0x01d1  */
        /* JADX WARN: Code duplicated, block: B:176:0x0317 A[EDGE_INSN: B:176:0x0317->B:177:0x0318 BREAK  A[LOOP:4: B:171:0x02fe->B:175:0x0314]] */
        /* JADX WARN: Code duplicated, block: B:221:0x03d3  */
        /* JADX WARN: Code duplicated, block: B:222:0x03d6  */
        /* JADX WARN: Code duplicated, block: B:224:0x03d9  */
        /* JADX WARN: Code duplicated, block: B:226:0x03e1  */
        /* JADX WARN: Code duplicated, block: B:232:0x0406  */
        /* JADX WARN: Code duplicated, block: B:234:0x040c  */
        /* JADX WARN: Code duplicated, block: B:236:0x0412  */
        /* JADX WARN: Code duplicated, block: B:237:0x0415  */
        /* JADX WARN: Code duplicated, block: B:239:0x0418  */
        /* JADX WARN: Code duplicated, block: B:245:0x0438  */
        /* JADX WARN: Code duplicated, block: B:247:0x0444  */
        /* JADX WARN: Code duplicated, block: B:251:0x044f  */
        /* JADX WARN: Code duplicated, block: B:253:0x045a  */
        /* JADX WARN: Code duplicated, block: B:256:0x0479  */
        /* JADX WARN: Code duplicated, block: B:259:0x048a  */
        /* JADX WARN: Code duplicated, block: B:263:0x04a7  */
        /* JADX WARN: Code duplicated, block: B:266:0x04b2  */
        /* JADX WARN: Code duplicated, block: B:269:0x04ba  */
        /* JADX WARN: Code duplicated, block: B:271:0x04bd  */
        /* JADX WARN: Code duplicated, block: B:273:0x04c6  */
        /* JADX WARN: Code duplicated, block: B:277:0x04ce  */
        /* JADX WARN: Code duplicated, block: B:279:0x04d2  */
        /* JADX WARN: Code duplicated, block: B:281:0x04d8  */
        /* JADX WARN: Code duplicated, block: B:282:0x04db  */
        /* JADX WARN: Code duplicated, block: B:284:0x04df  */
        /* JADX WARN: Code duplicated, block: B:285:0x04e4  */
        /* JADX WARN: Code duplicated, block: B:287:0x04ec A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:290:0x04f7  */
        /* JADX WARN: Code duplicated, block: B:293:0x04fc  */
        /* JADX WARN: Code duplicated, block: B:297:0x0505  */
        /* JADX WARN: Code duplicated, block: B:298:0x050f  */
        /* JADX WARN: Code duplicated, block: B:300:0x0515  */
        /* JADX WARN: Code duplicated, block: B:301:0x051f  */
        /* JADX WARN: Code duplicated, block: B:304:0x0525 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:306:0x0529  */
        /* JADX WARN: Code duplicated, block: B:35:0x007d A[EDGE_INSN: B:35:0x007d->B:36:0x007e BREAK  A[LOOP:0: B:14:0x0027->B:20:0x0041]] */
        /* JADX WARN: Code duplicated, block: B:77:0x0126  */
        public final y i(int i9, long j) {
            boolean z8;
            y yVarD;
            boolean z9;
            long j8;
            C0414a c0414a;
            boolean z10;
            View view;
            boolean z11;
            int iE;
            int i10;
            long nanoTime;
            d dVar;
            ArrayList arrayList;
            ViewGroup.LayoutParams layoutParams;
            long nanoTime2;
            long j9;
            AccessibilityManager accessibilityManager;
            boolean z12;
            boolean z13;
            boolean z14;
            androidx.recyclerview.widget.x xVar;
            androidx.recyclerview.widget.x.a aVar;
            View.AccessibilityDelegate accessibilityDelegateD;
            C0414a c0414a2;
            long j10;
            boolean z15;
            ViewGroup.LayoutParams layoutParams2;
            m mVar;
            boolean z16;
            int i11;
            boolean z17;
            View view2;
            int iB;
            d dVar2;
            boolean z18;
            int size;
            int iE2;
            boolean z19 = true;
            RecyclerView recyclerView = RecyclerView.this;
            if (i9 < 0 || i9 >= recyclerView.f8016n0.b()) {
                StringBuilder sbG = H2.a.g(i9, i9, "Invalid item position ", "(", "). Item count:");
                sbG.append(recyclerView.f8016n0.b());
                sbG.append(recyclerView.y());
                throw new IndexOutOfBoundsException(sbG.toString());
            }
            v vVar = recyclerView.f8016n0;
            if (vVar.f8114g) {
                ArrayList<y> arrayList2 = this.f8085b;
                if (arrayList2 != null && (size = arrayList2.size()) != 0) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= size) {
                            if (recyclerView.f8010k.f8044b && (iE2 = recyclerView.f8004d.e(i9, 0)) > 0 && iE2 < recyclerView.f8010k.a()) {
                                long jB = recyclerView.f8010k.b(iE2);
                                int i13 = 0;
                                while (true) {
                                    if (i13 >= size) {
                                        yVarD = null;
                                        break;
                                    }
                                    y yVar = this.f8085b.get(i13);
                                    if (!yVar.p() && yVar.f8133e == jB) {
                                        yVar.a(32);
                                        yVarD = yVar;
                                        break;
                                    }
                                    i13++;
                                }
                            } else {
                                yVarD = null;
                                break;
                            }
                        } else {
                            yVarD = this.f8085b.get(i12);
                            if (!yVarD.p() && yVarD.b() == i9) {
                                yVarD.a(32);
                                break;
                            }
                            i12++;
                        }
                    }
                } else {
                    yVarD = null;
                    break;
                }
                z8 = yVarD != null;
            } else {
                z8 = false;
                yVarD = null;
            }
            ArrayList<y> arrayList3 = this.f8086c;
            ArrayList<y> arrayList4 = this.f8084a;
            if (yVarD == null) {
                int size2 = arrayList4.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size2) {
                        ArrayList arrayList5 = recyclerView.f8005e.f8207c;
                        int size3 = arrayList5.size();
                        int i15 = 0;
                        while (true) {
                            if (i15 >= size3) {
                                z9 = z19;
                                view2 = null;
                                break;
                            }
                            view2 = (View) arrayList5.get(i15);
                            y yVarI = RecyclerView.I(view2);
                            z9 = z19;
                            if (yVarI.b() == i9 && !yVarI.f() && !yVarI.h()) {
                                break;
                            }
                            i15++;
                            z19 = z9;
                        }
                        if (view2 == null) {
                            int size4 = arrayList3.size();
                            int i16 = 0;
                            while (true) {
                                if (i16 >= size4) {
                                    yVarD = null;
                                    break;
                                }
                                y yVar2 = arrayList3.get(i16);
                                if (!yVar2.f() && yVar2.b() == i9 && !yVar2.d()) {
                                    arrayList3.remove(i16);
                                    yVarD = yVar2;
                                    break;
                                }
                                i16++;
                            }
                        } else {
                            y yVarI2 = RecyclerView.I(view2);
                            C0550b c0550b = recyclerView.f8005e;
                            int iIndexOfChild = c0550b.f8205a.f8331a.indexOfChild(view2);
                            if (iIndexOfChild < 0) {
                                throw new IllegalArgumentException("view is not a child, cannot hide " + view2);
                            }
                            C0550b.a aVar2 = c0550b.f8206b;
                            if (!aVar2.d(iIndexOfChild)) {
                                throw new RuntimeException("trying to unhide a view that was not hidden" + view2);
                            }
                            aVar2.a(iIndexOfChild);
                            c0550b.j(view2);
                            C0550b c0550b2 = recyclerView.f8005e;
                            int iIndexOfChild2 = c0550b2.f8205a.f8331a.indexOfChild(view2);
                            if (iIndexOfChild2 == -1) {
                                iB = -1;
                            } else {
                                C0550b.a aVar3 = c0550b2.f8206b;
                                if (aVar3.d(iIndexOfChild2)) {
                                    iB = -1;
                                } else {
                                    iB = iIndexOfChild2 - aVar3.b(iIndexOfChild2);
                                }
                            }
                            if (iB == -1) {
                                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + yVarI2 + recyclerView.y());
                            }
                            recyclerView.f8005e.c(iB);
                            h(view2);
                            yVarI2.a(8224);
                            yVarD = yVarI2;
                            break;
                        }
                    } else {
                        y yVar3 = arrayList4.get(i14);
                        if (!yVar3.p() && yVar3.b() == i9 && !yVar3.f() && (vVar.f8114g || !yVar3.h())) {
                            yVar3.a(32);
                            z9 = true;
                            yVarD = yVar3;
                            break;
                        }
                        i14++;
                    }
                }
                if (yVarD != null) {
                    if (yVarD.h()) {
                        z18 = vVar.f8114g;
                    } else {
                        int i17 = yVarD.f8131c;
                        if (i17 < 0 || i17 >= recyclerView.f8010k.a()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + yVarD + recyclerView.y());
                        }
                        if (vVar.f8114g) {
                            dVar2 = recyclerView.f8010k;
                            if (dVar2.f8044b) {
                            }
                            z18 = z9;
                        } else {
                            recyclerView.f8010k.getClass();
                            if (yVarD.f8134f != 0) {
                                z18 = false;
                            } else {
                                dVar2 = recyclerView.f8010k;
                                if (dVar2.f8044b || yVarD.f8133e == dVar2.b(yVarD.f8131c)) {
                                    z18 = z9;
                                } else {
                                    z18 = false;
                                }
                            }
                        }
                    }
                    if (z18) {
                        z8 = z9;
                    } else {
                        yVarD.a(4);
                        if (yVarD.i()) {
                            recyclerView.removeDetachedView(yVarD.f8129a, false);
                            yVarD.f8141n.j(yVarD);
                        } else if (yVarD.p()) {
                            yVarD.j &= -33;
                        }
                        g(yVarD);
                        yVarD = null;
                    }
                }
            } else {
                z9 = true;
            }
            if (yVarD == null) {
                int iE3 = recyclerView.f8004d.e(i9, 0);
                if (iE3 < 0 || iE3 >= recyclerView.f8010k.a()) {
                    StringBuilder sbG2 = H2.a.g(i9, iE3, "Inconsistency detected. Invalid item position ", "(offset:", ").state:");
                    sbG2.append(vVar.b());
                    sbG2.append(recyclerView.y());
                    throw new IndexOutOfBoundsException(sbG2.toString());
                }
                recyclerView.f8010k.getClass();
                d dVar3 = recyclerView.f8010k;
                j8 = 3;
                if (dVar3.f8044b) {
                    long jB2 = dVar3.b(iE3);
                    int size5 = arrayList4.size() - 1;
                    while (true) {
                        if (size5 < 0) {
                            int size6 = arrayList3.size() - 1;
                            while (true) {
                                if (size6 >= 0) {
                                    y yVar4 = arrayList3.get(size6);
                                    if (yVar4.f8133e != jB2 || yVar4.d()) {
                                        size6--;
                                    } else {
                                        if (yVar4.f8134f == 0) {
                                            arrayList3.remove(size6);
                                            yVarD = yVar4;
                                            break;
                                        }
                                        e(size6);
                                    }
                                }
                                yVarD = null;
                                break;
                            }
                        }
                        yVarD = arrayList4.get(size5);
                        if (yVarD.f8133e == jB2 && !yVarD.p()) {
                            if (yVarD.f8134f == 0) {
                                yVarD.a(32);
                                if (!yVarD.h() || vVar.f8114g) {
                                    break;
                                    break;
                                }
                                yVarD.j = (yVarD.j & (-15)) | 2;
                                break;
                            }
                            arrayList4.remove(size5);
                            View view3 = yVarD.f8129a;
                            recyclerView.removeDetachedView(view3, false);
                            y yVarI3 = RecyclerView.I(view3);
                            yVarI3.f8141n = null;
                            yVarI3.f8142o = false;
                            yVarI3.j &= -33;
                            g(yVarI3);
                        }
                        size5--;
                    }
                    if (yVarD != null) {
                        yVarD.f8131c = iE3;
                        z8 = z9;
                    }
                }
                if (yVarD == null) {
                    q.a aVar4 = c().f8078a.get(0);
                    if (aVar4 == null) {
                        yVarD = null;
                        break;
                    }
                    ArrayList<y> arrayList6 = aVar4.f8080a;
                    if (!arrayList6.isEmpty()) {
                        int size7 = arrayList6.size() - 1;
                        while (true) {
                            if (size7 < 0) {
                                yVarD = null;
                                break;
                            }
                            if (!arrayList6.get(size7).d()) {
                                yVarD = arrayList6.remove(size7);
                                break;
                            }
                            size7--;
                        }
                    } else {
                        yVarD = null;
                        break;
                    }
                    if (yVarD != null) {
                        yVarD.m();
                        int[] iArr = RecyclerView.f7974D0;
                    }
                }
                if (yVarD == null) {
                    long nanoTime3 = recyclerView.getNanoTime();
                    if (j != Long.MAX_VALUE) {
                        long j11 = this.f8090g.a(0).f8082c;
                        if (!((j11 == 0 || j11 + nanoTime3 < j) ? z9 : false)) {
                            return null;
                        }
                    }
                    c0414a = null;
                    d dVar4 = recyclerView.f8010k;
                    dVar4.getClass();
                    try {
                        int i18 = P.g.f3603a;
                        Trace.beginSection("RV CreateView");
                        yVarD = dVar4.d(recyclerView);
                        View view4 = yVarD.f8129a;
                        if (view4.getParent() != null) {
                            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                        }
                        yVarD.f8134f = 0;
                        Trace.endSection();
                        int[] iArr2 = RecyclerView.f7974D0;
                        RecyclerView recyclerViewD = RecyclerView.D(view4);
                        if (recyclerViewD != null) {
                            yVarD.f8130b = new WeakReference<>(recyclerViewD);
                        }
                        long nanoTime4 = recyclerView.getNanoTime() - nanoTime3;
                        q.a aVarA = this.f8090g.a(0);
                        long j12 = aVarA.f8082c;
                        if (j12 != 0) {
                            nanoTime4 = (nanoTime4 / 4) + ((j12 / 4) * 3);
                        }
                        aVarA.f8082c = nanoTime4;
                    } catch (Throwable th) {
                        int i19 = P.g.f3603a;
                        Trace.endSection();
                        throw th;
                    }
                }
                if (z8 && !vVar.f8114g) {
                    i11 = yVarD.j;
                    if ((i11 & 8192) != 0) {
                        z17 = z9;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        yVarD.j = i11 & (-8193);
                        if (vVar.j) {
                            i.b(yVarD);
                            i iVar = recyclerView.f7986H;
                            yVarD.c();
                            iVar.getClass();
                            i.b bVar = new i.b();
                            bVar.a(yVarD);
                            recyclerView.U(yVarD, bVar);
                        }
                    }
                }
                z10 = vVar.f8114g;
                view = yVarD.f8129a;
                if (z10 || !yVarD.e()) {
                    if (yVarD.e()) {
                        if ((yVarD.j & 2) != 0) {
                            z15 = z9;
                        } else {
                            z15 = false;
                        }
                        if (!z15 || yVarD.f()) {
                        }
                        layoutParams2 = view.getLayoutParams();
                        if (layoutParams2 == null) {
                            mVar = (m) recyclerView.generateDefaultLayoutParams();
                            view.setLayoutParams(mVar);
                        } else if (recyclerView.checkLayoutParams(layoutParams2)) {
                            mVar = (m) layoutParams2;
                        } else {
                            mVar = (m) recyclerView.generateLayoutParams(layoutParams2);
                            view.setLayoutParams(mVar);
                        }
                        mVar.f8074a = yVarD;
                        if (z8 || !z14) {
                            z16 = z11;
                        } else {
                            z16 = z13;
                        }
                        mVar.f8077d = z16;
                        return yVarD;
                    }
                    z11 = false;
                    iE = recyclerView.f8004d.e(i9, 0);
                    yVarD.f8145r = recyclerView;
                    i10 = yVarD.f8134f;
                    nanoTime = recyclerView.getNanoTime();
                    if (j != Long.MAX_VALUE) {
                        j10 = this.f8090g.a(i10).f8083d;
                        if (j10 != 0 || j10 + nanoTime < j) {
                            dVar = recyclerView.f8010k;
                            dVar.getClass();
                            yVarD.f8131c = iE;
                            if (dVar.f8044b) {
                                yVarD.f8133e = dVar.b(iE);
                            }
                            yVarD.j = (yVarD.j & (-520)) | 1;
                            int i20 = P.g.f3603a;
                            Trace.beginSection("RV OnBindView");
                            yVarD.c();
                            dVar.c(yVarD, iE);
                            arrayList = yVarD.f8138k;
                            if (arrayList != null) {
                                arrayList.clear();
                            }
                            yVarD.j &= -1025;
                            layoutParams = view.getLayoutParams();
                            if (layoutParams instanceof m) {
                                ((m) layoutParams).f8076c = z9;
                            }
                            Trace.endSection();
                            nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                            q.a aVarA2 = this.f8090g.a(yVarD.f8134f);
                            j9 = aVarA2.f8083d;
                            if (j9 != 0) {
                                nanoTime2 = (nanoTime2 / 4) + ((j9 / 4) * j8);
                            }
                            aVarA2.f8083d = nanoTime2;
                            accessibilityManager = recyclerView.f8034x;
                            if (accessibilityManager == null && accessibilityManager.isEnabled()) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                                WeakHashMap<View, L> weakHashMap = G.f4313a;
                                z13 = true;
                                if (view.getImportantForAccessibility() == 0) {
                                    view.setImportantForAccessibility(1);
                                }
                                xVar = recyclerView.f8029u0;
                                if (xVar != null) {
                                    aVar = xVar.f8334e;
                                    if (aVar != null) {
                                        accessibilityDelegateD = G.d(view);
                                        if (accessibilityDelegateD == null) {
                                            c0414a2 = c0414a;
                                        } else if (accessibilityDelegateD instanceof C0414a.C0052a) {
                                            c0414a2 = ((C0414a.C0052a) accessibilityDelegateD).f4403a;
                                        } else {
                                            c0414a2 = new C0414a(accessibilityDelegateD);
                                        }
                                        if (c0414a2 != null && c0414a2 != aVar) {
                                            aVar.f8336e.put(view, c0414a2);
                                        }
                                    }
                                    G.m(view, aVar);
                                }
                            } else {
                                z13 = true;
                            }
                            if (vVar.f8114g) {
                                yVarD.f8135g = i9;
                            }
                            z14 = z13;
                        } else {
                            z14 = false;
                            z13 = z9;
                        }
                    } else {
                        dVar = recyclerView.f8010k;
                        dVar.getClass();
                        yVarD.f8131c = iE;
                        if (dVar.f8044b) {
                            yVarD.f8133e = dVar.b(iE);
                        }
                        yVarD.j = (yVarD.j & (-520)) | 1;
                        int i21 = P.g.f3603a;
                        Trace.beginSection("RV OnBindView");
                        yVarD.c();
                        dVar.c(yVarD, iE);
                        arrayList = yVarD.f8138k;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        yVarD.j &= -1025;
                        layoutParams = view.getLayoutParams();
                        if (layoutParams instanceof m) {
                            ((m) layoutParams).f8076c = z9;
                        }
                        Trace.endSection();
                        nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                        q.a aVarA3 = this.f8090g.a(yVarD.f8134f);
                        j9 = aVarA3.f8083d;
                        if (j9 != 0) {
                            nanoTime2 = (nanoTime2 / 4) + ((j9 / 4) * j8);
                        }
                        aVarA3.f8083d = nanoTime2;
                        accessibilityManager = recyclerView.f8034x;
                        if (accessibilityManager == null) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                            z13 = true;
                            if (view.getImportantForAccessibility() == 0) {
                                view.setImportantForAccessibility(1);
                            }
                            xVar = recyclerView.f8029u0;
                            if (xVar != null) {
                                aVar = xVar.f8334e;
                                if (aVar != null) {
                                    accessibilityDelegateD = G.d(view);
                                    if (accessibilityDelegateD == null) {
                                        c0414a2 = c0414a;
                                    } else if (accessibilityDelegateD instanceof C0414a.C0052a) {
                                        c0414a2 = ((C0414a.C0052a) accessibilityDelegateD).f4403a;
                                    } else {
                                        c0414a2 = new C0414a(accessibilityDelegateD);
                                    }
                                    if (c0414a2 != null) {
                                        aVar.f8336e.put(view, c0414a2);
                                    }
                                }
                                G.m(view, aVar);
                            }
                        } else {
                            z13 = true;
                        }
                        if (vVar.f8114g) {
                            yVarD.f8135g = i9;
                        }
                        z14 = z13;
                    }
                    layoutParams2 = view.getLayoutParams();
                    if (layoutParams2 == null) {
                        mVar = (m) recyclerView.generateDefaultLayoutParams();
                        view.setLayoutParams(mVar);
                    } else if (recyclerView.checkLayoutParams(layoutParams2)) {
                        mVar = (m) recyclerView.generateLayoutParams(layoutParams2);
                        view.setLayoutParams(mVar);
                    } else {
                        mVar = (m) layoutParams2;
                    }
                    mVar.f8074a = yVarD;
                    if (z8) {
                        z16 = z11;
                    } else {
                        z16 = z11;
                    }
                    mVar.f8077d = z16;
                    return yVarD;
                }
                yVarD.f8135g = i9;
                z13 = z9;
                z14 = false;
                z11 = false;
                layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null) {
                    mVar = (m) recyclerView.generateDefaultLayoutParams();
                    view.setLayoutParams(mVar);
                } else if (recyclerView.checkLayoutParams(layoutParams2)) {
                    mVar = (m) recyclerView.generateLayoutParams(layoutParams2);
                    view.setLayoutParams(mVar);
                } else {
                    mVar = (m) layoutParams2;
                }
                mVar.f8074a = yVarD;
                if (z8) {
                    z16 = z11;
                } else {
                    z16 = z11;
                }
                mVar.f8077d = z16;
                return yVarD;
            }
            j8 = 3;
            c0414a = null;
            if (z8) {
                i11 = yVarD.j;
                if ((i11 & 8192) != 0) {
                    z17 = z9;
                } else {
                    z17 = false;
                }
                if (z17) {
                    yVarD.j = i11 & (-8193);
                    if (vVar.j) {
                        i.b(yVarD);
                        i iVar2 = recyclerView.f7986H;
                        yVarD.c();
                        iVar2.getClass();
                        i.b bVar2 = new i.b();
                        bVar2.a(yVarD);
                        recyclerView.U(yVarD, bVar2);
                    }
                }
            }
            z10 = vVar.f8114g;
            view = yVarD.f8129a;
            if (z10) {
                if (yVarD.e()) {
                    if ((yVarD.j & 2) != 0) {
                        z15 = z9;
                    } else {
                        z15 = false;
                    }
                    if (!z15) {
                    }
                }
                z11 = false;
                iE = recyclerView.f8004d.e(i9, 0);
                yVarD.f8145r = recyclerView;
                i10 = yVarD.f8134f;
                nanoTime = recyclerView.getNanoTime();
                if (j != Long.MAX_VALUE) {
                    j10 = this.f8090g.a(i10).f8083d;
                    if (j10 != 0) {
                        dVar = recyclerView.f8010k;
                        dVar.getClass();
                        yVarD.f8131c = iE;
                        if (dVar.f8044b) {
                            yVarD.f8133e = dVar.b(iE);
                        }
                        yVarD.j = (yVarD.j & (-520)) | 1;
                        int i22 = P.g.f3603a;
                        Trace.beginSection("RV OnBindView");
                        yVarD.c();
                        dVar.c(yVarD, iE);
                        arrayList = yVarD.f8138k;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        yVarD.j &= -1025;
                        layoutParams = view.getLayoutParams();
                        if (layoutParams instanceof m) {
                            ((m) layoutParams).f8076c = z9;
                        }
                        Trace.endSection();
                        nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                        q.a aVarA4 = this.f8090g.a(yVarD.f8134f);
                        j9 = aVarA4.f8083d;
                        if (j9 != 0) {
                            nanoTime2 = (nanoTime2 / 4) + ((j9 / 4) * j8);
                        }
                        aVarA4.f8083d = nanoTime2;
                        accessibilityManager = recyclerView.f8034x;
                        if (accessibilityManager == null) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            WeakHashMap<View, L> weakHashMap3 = G.f4313a;
                            z13 = true;
                            if (view.getImportantForAccessibility() == 0) {
                                view.setImportantForAccessibility(1);
                            }
                            xVar = recyclerView.f8029u0;
                            if (xVar != null) {
                                aVar = xVar.f8334e;
                                if (aVar != null) {
                                    accessibilityDelegateD = G.d(view);
                                    if (accessibilityDelegateD == null) {
                                        c0414a2 = c0414a;
                                    } else if (accessibilityDelegateD instanceof C0414a.C0052a) {
                                        c0414a2 = ((C0414a.C0052a) accessibilityDelegateD).f4403a;
                                    } else {
                                        c0414a2 = new C0414a(accessibilityDelegateD);
                                    }
                                    if (c0414a2 != null) {
                                        aVar.f8336e.put(view, c0414a2);
                                    }
                                }
                                G.m(view, aVar);
                            }
                        } else {
                            z13 = true;
                        }
                        if (vVar.f8114g) {
                            yVarD.f8135g = i9;
                        }
                        z14 = z13;
                    } else {
                        dVar = recyclerView.f8010k;
                        dVar.getClass();
                        yVarD.f8131c = iE;
                        if (dVar.f8044b) {
                            yVarD.f8133e = dVar.b(iE);
                        }
                        yVarD.j = (yVarD.j & (-520)) | 1;
                        int i23 = P.g.f3603a;
                        Trace.beginSection("RV OnBindView");
                        yVarD.c();
                        dVar.c(yVarD, iE);
                        arrayList = yVarD.f8138k;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        yVarD.j &= -1025;
                        layoutParams = view.getLayoutParams();
                        if (layoutParams instanceof m) {
                            ((m) layoutParams).f8076c = z9;
                        }
                        Trace.endSection();
                        nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                        q.a aVarA5 = this.f8090g.a(yVarD.f8134f);
                        j9 = aVarA5.f8083d;
                        if (j9 != 0) {
                            nanoTime2 = (nanoTime2 / 4) + ((j9 / 4) * j8);
                        }
                        aVarA5.f8083d = nanoTime2;
                        accessibilityManager = recyclerView.f8034x;
                        if (accessibilityManager == null) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            WeakHashMap<View, L> weakHashMap4 = G.f4313a;
                            z13 = true;
                            if (view.getImportantForAccessibility() == 0) {
                                view.setImportantForAccessibility(1);
                            }
                            xVar = recyclerView.f8029u0;
                            if (xVar != null) {
                                aVar = xVar.f8334e;
                                if (aVar != null) {
                                    accessibilityDelegateD = G.d(view);
                                    if (accessibilityDelegateD == null) {
                                        c0414a2 = c0414a;
                                    } else if (accessibilityDelegateD instanceof C0414a.C0052a) {
                                        c0414a2 = ((C0414a.C0052a) accessibilityDelegateD).f4403a;
                                    } else {
                                        c0414a2 = new C0414a(accessibilityDelegateD);
                                    }
                                    if (c0414a2 != null) {
                                        aVar.f8336e.put(view, c0414a2);
                                    }
                                }
                                G.m(view, aVar);
                            }
                        } else {
                            z13 = true;
                        }
                        if (vVar.f8114g) {
                            yVarD.f8135g = i9;
                        }
                        z14 = z13;
                    }
                } else {
                    dVar = recyclerView.f8010k;
                    dVar.getClass();
                    yVarD.f8131c = iE;
                    if (dVar.f8044b) {
                        yVarD.f8133e = dVar.b(iE);
                    }
                    yVarD.j = (yVarD.j & (-520)) | 1;
                    int i24 = P.g.f3603a;
                    Trace.beginSection("RV OnBindView");
                    yVarD.c();
                    dVar.c(yVarD, iE);
                    arrayList = yVarD.f8138k;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    yVarD.j &= -1025;
                    layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof m) {
                        ((m) layoutParams).f8076c = z9;
                    }
                    Trace.endSection();
                    nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                    q.a aVarA6 = this.f8090g.a(yVarD.f8134f);
                    j9 = aVarA6.f8083d;
                    if (j9 != 0) {
                        nanoTime2 = (nanoTime2 / 4) + ((j9 / 4) * j8);
                    }
                    aVarA6.f8083d = nanoTime2;
                    accessibilityManager = recyclerView.f8034x;
                    if (accessibilityManager == null) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        WeakHashMap<View, L> weakHashMap5 = G.f4313a;
                        z13 = true;
                        if (view.getImportantForAccessibility() == 0) {
                            view.setImportantForAccessibility(1);
                        }
                        xVar = recyclerView.f8029u0;
                        if (xVar != null) {
                            aVar = xVar.f8334e;
                            if (aVar != null) {
                                accessibilityDelegateD = G.d(view);
                                if (accessibilityDelegateD == null) {
                                    c0414a2 = c0414a;
                                } else if (accessibilityDelegateD instanceof C0414a.C0052a) {
                                    c0414a2 = ((C0414a.C0052a) accessibilityDelegateD).f4403a;
                                } else {
                                    c0414a2 = new C0414a(accessibilityDelegateD);
                                }
                                if (c0414a2 != null) {
                                    aVar.f8336e.put(view, c0414a2);
                                }
                            }
                            G.m(view, aVar);
                        }
                    } else {
                        z13 = true;
                    }
                    if (vVar.f8114g) {
                        yVarD.f8135g = i9;
                    }
                    z14 = z13;
                }
            } else {
                if (yVarD.e()) {
                    if ((yVarD.j & 2) != 0) {
                        z15 = z9;
                    } else {
                        z15 = false;
                    }
                    if (!z15) {
                    }
                }
                z11 = false;
                iE = recyclerView.f8004d.e(i9, 0);
                yVarD.f8145r = recyclerView;
                i10 = yVarD.f8134f;
                nanoTime = recyclerView.getNanoTime();
                if (j != Long.MAX_VALUE) {
                    j10 = this.f8090g.a(i10).f8083d;
                    if (j10 != 0) {
                        dVar = recyclerView.f8010k;
                        dVar.getClass();
                        yVarD.f8131c = iE;
                        if (dVar.f8044b) {
                            yVarD.f8133e = dVar.b(iE);
                        }
                        yVarD.j = (yVarD.j & (-520)) | 1;
                        int i25 = P.g.f3603a;
                        Trace.beginSection("RV OnBindView");
                        yVarD.c();
                        dVar.c(yVarD, iE);
                        arrayList = yVarD.f8138k;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        yVarD.j &= -1025;
                        layoutParams = view.getLayoutParams();
                        if (layoutParams instanceof m) {
                            ((m) layoutParams).f8076c = z9;
                        }
                        Trace.endSection();
                        nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                        q.a aVarA7 = this.f8090g.a(yVarD.f8134f);
                        j9 = aVarA7.f8083d;
                        if (j9 != 0) {
                            nanoTime2 = (nanoTime2 / 4) + ((j9 / 4) * j8);
                        }
                        aVarA7.f8083d = nanoTime2;
                        accessibilityManager = recyclerView.f8034x;
                        if (accessibilityManager == null) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            WeakHashMap<View, L> weakHashMap6 = G.f4313a;
                            z13 = true;
                            if (view.getImportantForAccessibility() == 0) {
                                view.setImportantForAccessibility(1);
                            }
                            xVar = recyclerView.f8029u0;
                            if (xVar != null) {
                                aVar = xVar.f8334e;
                                if (aVar != null) {
                                    accessibilityDelegateD = G.d(view);
                                    if (accessibilityDelegateD == null) {
                                        c0414a2 = c0414a;
                                    } else if (accessibilityDelegateD instanceof C0414a.C0052a) {
                                        c0414a2 = ((C0414a.C0052a) accessibilityDelegateD).f4403a;
                                    } else {
                                        c0414a2 = new C0414a(accessibilityDelegateD);
                                    }
                                    if (c0414a2 != null) {
                                        aVar.f8336e.put(view, c0414a2);
                                    }
                                }
                                G.m(view, aVar);
                            }
                        } else {
                            z13 = true;
                        }
                        if (vVar.f8114g) {
                            yVarD.f8135g = i9;
                        }
                        z14 = z13;
                    } else {
                        dVar = recyclerView.f8010k;
                        dVar.getClass();
                        yVarD.f8131c = iE;
                        if (dVar.f8044b) {
                            yVarD.f8133e = dVar.b(iE);
                        }
                        yVarD.j = (yVarD.j & (-520)) | 1;
                        int i26 = P.g.f3603a;
                        Trace.beginSection("RV OnBindView");
                        yVarD.c();
                        dVar.c(yVarD, iE);
                        arrayList = yVarD.f8138k;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        yVarD.j &= -1025;
                        layoutParams = view.getLayoutParams();
                        if (layoutParams instanceof m) {
                            ((m) layoutParams).f8076c = z9;
                        }
                        Trace.endSection();
                        nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                        q.a aVarA8 = this.f8090g.a(yVarD.f8134f);
                        j9 = aVarA8.f8083d;
                        if (j9 != 0) {
                            nanoTime2 = (nanoTime2 / 4) + ((j9 / 4) * j8);
                        }
                        aVarA8.f8083d = nanoTime2;
                        accessibilityManager = recyclerView.f8034x;
                        if (accessibilityManager == null) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            WeakHashMap<View, L> weakHashMap7 = G.f4313a;
                            z13 = true;
                            if (view.getImportantForAccessibility() == 0) {
                                view.setImportantForAccessibility(1);
                            }
                            xVar = recyclerView.f8029u0;
                            if (xVar != null) {
                                aVar = xVar.f8334e;
                                if (aVar != null) {
                                    accessibilityDelegateD = G.d(view);
                                    if (accessibilityDelegateD == null) {
                                        c0414a2 = c0414a;
                                    } else if (accessibilityDelegateD instanceof C0414a.C0052a) {
                                        c0414a2 = ((C0414a.C0052a) accessibilityDelegateD).f4403a;
                                    } else {
                                        c0414a2 = new C0414a(accessibilityDelegateD);
                                    }
                                    if (c0414a2 != null) {
                                        aVar.f8336e.put(view, c0414a2);
                                    }
                                }
                                G.m(view, aVar);
                            }
                        } else {
                            z13 = true;
                        }
                        if (vVar.f8114g) {
                            yVarD.f8135g = i9;
                        }
                        z14 = z13;
                    }
                } else {
                    dVar = recyclerView.f8010k;
                    dVar.getClass();
                    yVarD.f8131c = iE;
                    if (dVar.f8044b) {
                        yVarD.f8133e = dVar.b(iE);
                    }
                    yVarD.j = (yVarD.j & (-520)) | 1;
                    int i27 = P.g.f3603a;
                    Trace.beginSection("RV OnBindView");
                    yVarD.c();
                    dVar.c(yVarD, iE);
                    arrayList = yVarD.f8138k;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    yVarD.j &= -1025;
                    layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof m) {
                        ((m) layoutParams).f8076c = z9;
                    }
                    Trace.endSection();
                    nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                    q.a aVarA9 = this.f8090g.a(yVarD.f8134f);
                    j9 = aVarA9.f8083d;
                    if (j9 != 0) {
                        nanoTime2 = (nanoTime2 / 4) + ((j9 / 4) * j8);
                    }
                    aVarA9.f8083d = nanoTime2;
                    accessibilityManager = recyclerView.f8034x;
                    if (accessibilityManager == null) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        WeakHashMap<View, L> weakHashMap8 = G.f4313a;
                        z13 = true;
                        if (view.getImportantForAccessibility() == 0) {
                            view.setImportantForAccessibility(1);
                        }
                        xVar = recyclerView.f8029u0;
                        if (xVar != null) {
                            aVar = xVar.f8334e;
                            if (aVar != null) {
                                accessibilityDelegateD = G.d(view);
                                if (accessibilityDelegateD == null) {
                                    c0414a2 = c0414a;
                                } else if (accessibilityDelegateD instanceof C0414a.C0052a) {
                                    c0414a2 = ((C0414a.C0052a) accessibilityDelegateD).f4403a;
                                } else {
                                    c0414a2 = new C0414a(accessibilityDelegateD);
                                }
                                if (c0414a2 != null) {
                                    aVar.f8336e.put(view, c0414a2);
                                }
                            }
                            G.m(view, aVar);
                        }
                    } else {
                        z13 = true;
                    }
                    if (vVar.f8114g) {
                        yVarD.f8135g = i9;
                    }
                    z14 = z13;
                }
            }
            layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                mVar = (m) recyclerView.generateDefaultLayoutParams();
                view.setLayoutParams(mVar);
            } else if (recyclerView.checkLayoutParams(layoutParams2)) {
                mVar = (m) recyclerView.generateLayoutParams(layoutParams2);
                view.setLayoutParams(mVar);
            } else {
                mVar = (m) layoutParams2;
            }
            mVar.f8074a = yVarD;
            if (z8) {
                z16 = z11;
            } else {
                z16 = z11;
            }
            mVar.f8077d = z16;
            return yVarD;
        }

        public final void j(y yVar) {
            if (yVar.f8142o) {
                this.f8085b.remove(yVar);
            } else {
                this.f8084a.remove(yVar);
            }
            yVar.f8141n = null;
            yVar.f8142o = false;
            yVar.j &= -33;
        }

        public final void k() {
            l lVar = RecyclerView.this.f8011l;
            this.f8089f = this.f8088e + (lVar != null ? lVar.j : 0);
            ArrayList<y> arrayList = this.f8086c;
            for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f8089f; size--) {
                e(size);
            }
        }
    }

    public interface s {
    }

    public class t extends f {
        public t() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f
        public final void a() {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.i(null);
            recyclerView.f8016n0.f8113f = true;
            recyclerView.T(true);
            if (recyclerView.f8004d.f()) {
                return;
            }
            recyclerView.requestLayout();
        }
    }

    public static abstract class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8093a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f8094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public l f8095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8097e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f8098f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f8099g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8100h;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8101a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8102b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f8103c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f8104d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public BaseInterpolator f8105e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f8106f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f8107g;

            public final void a(RecyclerView recyclerView) {
                int i9 = this.f8104d;
                if (i9 >= 0) {
                    this.f8104d = -1;
                    recyclerView.M(i9);
                    this.f8106f = false;
                    return;
                }
                if (!this.f8106f) {
                    this.f8107g = 0;
                    return;
                }
                BaseInterpolator baseInterpolator = this.f8105e;
                if (baseInterpolator != null && this.f8103c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                int i10 = this.f8103c;
                if (i10 < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
                recyclerView.f8000W.b(this.f8101a, this.f8102b, i10, baseInterpolator);
                int i11 = this.f8107g + 1;
                this.f8107g = i11;
                if (i11 > 10) {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                this.f8106f = false;
            }
        }

        public interface b {
            PointF a(int i9);
        }

        public u() {
            a aVar = new a();
            aVar.f8104d = -1;
            aVar.f8106f = false;
            aVar.f8107g = 0;
            aVar.f8101a = 0;
            aVar.f8102b = 0;
            aVar.f8103c = Integer.MIN_VALUE;
            aVar.f8105e = null;
            this.f8099g = aVar;
        }

        public PointF a(int i9) {
            Object obj = this.f8095c;
            if (obj instanceof b) {
                return ((b) obj).a(i9);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:50:0x00fb  */
        public final void b(int i9, int i10) {
            PointF pointFA;
            RecyclerView recyclerView = this.f8094b;
            if (this.f8093a == -1 || recyclerView == null) {
                d();
            }
            if (this.f8096d && this.f8098f == null && this.f8095c != null && (pointFA = a(this.f8093a)) != null) {
                float f6 = pointFA.x;
                if (f6 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.Y((int) Math.signum(f6), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f8096d = false;
            View view = this.f8098f;
            a aVar = this.f8099g;
            if (view != null) {
                this.f8094b.getClass();
                y yVarI = RecyclerView.I(view);
                if ((yVarI != null ? yVarI.b() : -1) == this.f8093a) {
                    View view2 = this.f8098f;
                    v vVar = recyclerView.f8016n0;
                    c(view2, aVar);
                    aVar.a(recyclerView);
                    d();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f8098f = null;
                }
            }
            if (this.f8097e) {
                v vVar2 = recyclerView.f8016n0;
                androidx.recyclerview.widget.o oVar = (androidx.recyclerview.widget.o) this;
                if (oVar.f8094b.f8011l.v() == 0) {
                    oVar.d();
                } else {
                    int i11 = oVar.f8322o;
                    int i12 = i11 - i9;
                    if (i11 * i12 <= 0) {
                        i12 = 0;
                    }
                    oVar.f8322o = i12;
                    int i13 = oVar.f8323p;
                    int i14 = i13 - i10;
                    if (i13 * i14 <= 0) {
                        i14 = 0;
                    }
                    oVar.f8323p = i14;
                    if (i12 == 0 && i14 == 0) {
                        PointF pointFA2 = oVar.a(oVar.f8093a);
                        if (pointFA2 != null) {
                            float f9 = pointFA2.x;
                            if (f9 == 0.0f && pointFA2.y == 0.0f) {
                                aVar.f8104d = oVar.f8093a;
                                oVar.d();
                            } else {
                                float f10 = pointFA2.y;
                                float fSqrt = (float) Math.sqrt((f10 * f10) + (f9 * f9));
                                float f11 = pointFA2.x / fSqrt;
                                pointFA2.x = f11;
                                float f12 = pointFA2.y / fSqrt;
                                pointFA2.y = f12;
                                oVar.f8318k = pointFA2;
                                oVar.f8322o = (int) (f11 * 10000.0f);
                                oVar.f8323p = (int) (f12 * 10000.0f);
                                int i15 = oVar.i(10000);
                                int i16 = (int) (oVar.f8322o * 1.2f);
                                int i17 = (int) (oVar.f8323p * 1.2f);
                                LinearInterpolator linearInterpolator = oVar.f8317i;
                                aVar.f8101a = i16;
                                aVar.f8102b = i17;
                                aVar.f8103c = (int) (i15 * 1.2f);
                                aVar.f8105e = linearInterpolator;
                                aVar.f8106f = true;
                            }
                        } else {
                            aVar.f8104d = oVar.f8093a;
                            oVar.d();
                        }
                    }
                }
                boolean z8 = aVar.f8104d >= 0;
                aVar.a(recyclerView);
                if (z8 && this.f8097e) {
                    this.f8096d = true;
                    recyclerView.f8000W.a();
                }
            }
        }

        public abstract void c(View view, a aVar);

        public final void d() {
            if (this.f8097e) {
                this.f8097e = false;
                androidx.recyclerview.widget.o oVar = (androidx.recyclerview.widget.o) this;
                oVar.f8323p = 0;
                oVar.f8322o = 0;
                oVar.f8318k = null;
                this.f8094b.f8016n0.f8108a = -1;
                this.f8098f = null;
                this.f8093a = -1;
                this.f8096d = false;
                l lVar = this.f8095c;
                if (lVar.f8058e == this) {
                    lVar.f8058e = null;
                }
                this.f8095c = null;
                this.f8094b = null;
            }
        }
    }

    public static class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8110c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8111d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8112e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8113f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f8114g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8115h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8116i;
        public boolean j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f8117k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f8118l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f8119m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f8120n;

        public final void a(int i9) {
            if ((this.f8111d & i9) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i9) + " but it is " + Integer.toBinaryString(this.f8111d));
        }

        public final int b() {
            return this.f8114g ? this.f8109b - this.f8110c : this.f8112e;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("State{mTargetPosition=");
            sb.append(this.f8108a);
            sb.append(", mData=null, mItemCount=");
            sb.append(this.f8112e);
            sb.append(", mIsMeasuring=");
            sb.append(this.f8116i);
            sb.append(", mPreviousLayoutItemCount=");
            sb.append(this.f8109b);
            sb.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sb.append(this.f8110c);
            sb.append(", mStructureChanged=");
            sb.append(this.f8113f);
            sb.append(", mInPreLayout=");
            sb.append(this.f8114g);
            sb.append(", mRunSimpleAnimations=");
            sb.append(this.j);
            sb.append(", mRunPredictiveAnimations=");
            return defpackage.f.g(sb, this.f8117k, '}');
        }
    }

    public static abstract class w {
    }

    public class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OverScroller f8123c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Interpolator f8124d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8125e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8126f;

        public x() {
            b bVar = RecyclerView.F0;
            this.f8124d = bVar;
            this.f8125e = false;
            this.f8126f = false;
            this.f8123c = new OverScroller(RecyclerView.this.getContext(), bVar);
        }

        public final void a() {
            if (this.f8125e) {
                this.f8126f = true;
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.removeCallbacks(this);
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            recyclerView.postOnAnimation(this);
        }

        public final void b(int i9, int i10, int i11, BaseInterpolator baseInterpolator) {
            int iRound;
            RecyclerView recyclerView = RecyclerView.this;
            if (i11 == Integer.MIN_VALUE) {
                int iAbs = Math.abs(i9);
                int iAbs2 = Math.abs(i10);
                boolean z8 = iAbs > iAbs2;
                int iSqrt = (int) Math.sqrt(0);
                int iSqrt2 = (int) Math.sqrt((i10 * i10) + (i9 * i9));
                int width = z8 ? recyclerView.getWidth() : recyclerView.getHeight();
                int i12 = width / 2;
                float f6 = width;
                float f9 = i12;
                float fSin = (((float) Math.sin((Math.min(1.0f, (iSqrt2 * 1.0f) / f6) - 0.5f) * 0.47123894f)) * f9) + f9;
                if (iSqrt > 0) {
                    iRound = Math.round(Math.abs(fSin / iSqrt) * 1000.0f) * 4;
                } else {
                    if (!z8) {
                        iAbs = iAbs2;
                    }
                    iRound = (int) (((iAbs / f6) + 1.0f) * 300.0f);
                }
                i11 = Math.min(iRound, 2000);
            }
            int i13 = i11;
            Interpolator interpolator = baseInterpolator;
            if (baseInterpolator == null) {
                interpolator = RecyclerView.F0;
            }
            if (this.f8124d != interpolator) {
                this.f8124d = interpolator;
                this.f8123c = new OverScroller(recyclerView.getContext(), interpolator);
            }
            this.f8122b = 0;
            this.f8121a = 0;
            recyclerView.setScrollState(2);
            this.f8123c.startScroll(0, 0, i9, i10, i13);
            a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f8011l == null) {
                recyclerView.removeCallbacks(this);
                this.f8123c.abortAnimation();
                return;
            }
            this.f8126f = false;
            this.f8125e = true;
            recyclerView.m();
            OverScroller overScroller = this.f8123c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i14 = currX - this.f8121a;
                int i15 = currY - this.f8122b;
                this.f8121a = currX;
                this.f8122b = currY;
                int[] iArr = recyclerView.f8039z0;
                iArr[0] = 0;
                iArr[1] = 0;
                boolean zR = recyclerView.r(i14, i15, iArr, null, 1);
                int[] iArr2 = recyclerView.f8039z0;
                if (zR) {
                    i9 = i14 - iArr2[0];
                    i10 = i15 - iArr2[1];
                } else {
                    i9 = i14;
                    i10 = i15;
                }
                if (recyclerView.getOverScrollMode() != 2) {
                    recyclerView.l(i9, i10);
                }
                if (recyclerView.f8010k != null) {
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    recyclerView.Y(i9, i10, iArr2);
                    i11 = iArr2[0];
                    i12 = iArr2[1];
                    i9 -= i11;
                    i10 -= i12;
                    androidx.recyclerview.widget.o oVar = recyclerView.f8011l.f8058e;
                    if (oVar != null && !oVar.f8096d && oVar.f8097e) {
                        int iB = recyclerView.f8016n0.b();
                        if (iB == 0) {
                            oVar.d();
                        } else if (oVar.f8093a >= iB) {
                            oVar.f8093a = iB - 1;
                            oVar.b(i11, i12);
                        } else {
                            oVar.b(i11, i12);
                        }
                    }
                } else {
                    i11 = 0;
                    i12 = 0;
                }
                if (!recyclerView.f8013m.isEmpty()) {
                    recyclerView.invalidate();
                }
                int[] iArr3 = recyclerView.f8039z0;
                iArr3[0] = 0;
                iArr3[1] = 0;
                recyclerView.s(i11, i12, i9, i10, null, 1, iArr3);
                int i16 = i9 - iArr2[0];
                int i17 = i10 - iArr2[1];
                if (i11 != 0 || i12 != 0) {
                    recyclerView.t(i11, i12);
                }
                if (!recyclerView.awakenScrollBars()) {
                    recyclerView.invalidate();
                }
                boolean z8 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i16 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i17 != 0));
                androidx.recyclerview.widget.o oVar2 = recyclerView.f8011l.f8058e;
                if ((oVar2 == null || !oVar2.f8096d) && z8) {
                    if (recyclerView.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i16 < 0) {
                            i13 = -currVelocity;
                        } else {
                            i13 = i16 > 0 ? currVelocity : 0;
                        }
                        if (i17 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i17 <= 0) {
                            currVelocity = 0;
                        }
                        if (i13 < 0) {
                            recyclerView.v();
                            if (recyclerView.f7982D.isFinished()) {
                                recyclerView.f7982D.onAbsorb(-i13);
                            }
                        } else if (i13 > 0) {
                            recyclerView.w();
                            if (recyclerView.f7984F.isFinished()) {
                                recyclerView.f7984F.onAbsorb(i13);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView.x();
                            if (recyclerView.f7983E.isFinished()) {
                                recyclerView.f7983E.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView.u();
                            if (recyclerView.f7985G.isFinished()) {
                                recyclerView.f7985G.onAbsorb(currVelocity);
                            }
                        }
                        if (i13 != 0 || currVelocity != 0) {
                            WeakHashMap<View, L> weakHashMap = G.f4313a;
                            recyclerView.postInvalidateOnAnimation();
                        }
                    }
                    androidx.recyclerview.widget.m.b bVar = recyclerView.f8014m0;
                    int[] iArr4 = bVar.f8301c;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    bVar.f8302d = 0;
                } else {
                    a();
                    androidx.recyclerview.widget.m mVar = recyclerView.f8012l0;
                    if (mVar != null) {
                        mVar.a(recyclerView, i11, i12);
                    }
                }
            }
            androidx.recyclerview.widget.o oVar3 = recyclerView.f8011l.f8058e;
            if (oVar3 != null && oVar3.f8096d) {
                oVar3.b(0, 0);
            }
            this.f8125e = false;
            if (!this.f8126f) {
                recyclerView.setScrollState(0);
                recyclerView.d0(1);
            } else {
                recyclerView.removeCallbacks(this);
                WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                recyclerView.postOnAnimation(this);
            }
        }
    }

    public static abstract class y {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final List<Object> f8128s = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f8129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<RecyclerView> f8130b;
        public int j;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public RecyclerView f8145r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8131c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8132d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8133e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8134f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8135g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public y f8136h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public y f8137i = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ArrayList f8138k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final List<Object> f8139l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f8140m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public r f8141n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f8142o = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f8143p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f8144q = -1;

        public y(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f8129a = view;
        }

        public final void a(int i9) {
            this.j = i9 | this.j;
        }

        public final int b() {
            int i9 = this.f8135g;
            return i9 == -1 ? this.f8131c : i9;
        }

        public final List<Object> c() {
            ArrayList arrayList;
            return ((this.j & 1024) != 0 || (arrayList = this.f8138k) == null || arrayList.size() == 0) ? f8128s : this.f8139l;
        }

        public final boolean d() {
            View view = this.f8129a;
            return (view.getParent() == null || view.getParent() == this.f8145r) ? false : true;
        }

        public final boolean e() {
            return (this.j & 1) != 0;
        }

        public final boolean f() {
            return (this.j & 4) != 0;
        }

        public final boolean g() {
            if ((this.j & 16) != 0) {
                return false;
            }
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            return !this.f8129a.hasTransientState();
        }

        public final boolean h() {
            return (this.j & 8) != 0;
        }

        public final boolean i() {
            return this.f8141n != null;
        }

        public final boolean j() {
            return (this.j & 256) != 0;
        }

        public final boolean k() {
            return (this.j & 2) != 0;
        }

        public final void l(int i9, boolean z8) {
            if (this.f8132d == -1) {
                this.f8132d = this.f8131c;
            }
            if (this.f8135g == -1) {
                this.f8135g = this.f8131c;
            }
            if (z8) {
                this.f8135g += i9;
            }
            this.f8131c += i9;
            View view = this.f8129a;
            if (view.getLayoutParams() != null) {
                ((m) view.getLayoutParams()).f8076c = true;
            }
        }

        public final void m() {
            this.j = 0;
            this.f8131c = -1;
            this.f8132d = -1;
            this.f8133e = -1L;
            this.f8135g = -1;
            this.f8140m = 0;
            this.f8136h = null;
            this.f8137i = null;
            ArrayList arrayList = this.f8138k;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.j &= -1025;
            this.f8143p = 0;
            this.f8144q = -1;
            RecyclerView.j(this);
        }

        public final void n(boolean z8) {
            int i9 = this.f8140m;
            int i10 = z8 ? i9 - 1 : i9 + 1;
            this.f8140m = i10;
            if (i10 < 0) {
                this.f8140m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z8 && i10 == 1) {
                this.j |= 16;
            } else if (z8 && i10 == 0) {
                this.j &= -17;
            }
        }

        public final boolean o() {
            return (this.j & 128) != 0;
        }

        public final boolean p() {
            return (this.j & 32) != 0;
        }

        public final String toString() {
            StringBuilder sbC = p171w.a.c(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            sbC.append(Integer.toHexString(hashCode()));
            sbC.append(" position=");
            sbC.append(this.f8131c);
            sbC.append(" id=");
            sbC.append(this.f8133e);
            sbC.append(", oldPos=");
            sbC.append(this.f8132d);
            sbC.append(", pLpos:");
            sbC.append(this.f8135g);
            StringBuilder sb = new StringBuilder(sbC.toString());
            if (i()) {
                sb.append(" scrap ");
                sb.append(this.f8142o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (f()) {
                sb.append(" invalid");
            }
            if (!e()) {
                sb.append(" unbound");
            }
            if ((this.j & 2) != 0) {
                sb.append(" update");
            }
            if (h()) {
                sb.append(" removed");
            }
            if (o()) {
                sb.append(" ignored");
            }
            if (j()) {
                sb.append(" tmpDetached");
            }
            if (!g()) {
                sb.append(" not recyclable(" + this.f8140m + ")");
            }
            if ((this.j & 512) != 0 || f()) {
                sb.append(" undefined adapter position");
            }
            if (this.f8129a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static {
        Class cls = Integer.TYPE;
        f7975E0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        F0 = new b();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, cn.ikaile.ruoshui.client.R.attr.recyclerViewStyle);
    }

    public static RecyclerView D(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            RecyclerView recyclerViewD = D(viewGroup.getChildAt(i9));
            if (recyclerViewD != null) {
                return recyclerViewD;
            }
        }
        return null;
    }

    public static y I(View view) {
        if (view == null) {
            return null;
        }
        return ((m) view.getLayoutParams()).f8074a;
    }

    private C0428o getScrollingChildHelper() {
        if (this.f8033w0 == null) {
            this.f8033w0 = new C0428o(this);
        }
        return this.f8033w0;
    }

    public static void j(y yVar) {
        WeakReference<RecyclerView> weakReference = yVar.f8130b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == yVar.f8129a) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            yVar.f8130b = null;
        }
    }

    public final View A(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean B(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList<o> arrayList = this.f8015n;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            o oVar = arrayList.get(i9);
            if (oVar.b(motionEvent) && action != 3) {
                this.f8017o = oVar;
                return true;
            }
        }
        return false;
    }

    public final void C(int[] iArr) {
        int iE = this.f8005e.e();
        if (iE == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i9 = Integer.MAX_VALUE;
        int i10 = Integer.MIN_VALUE;
        for (int i11 = 0; i11 < iE; i11++) {
            y yVarI = I(this.f8005e.d(i11));
            if (!yVarI.o()) {
                int iB = yVarI.b();
                if (iB < i9) {
                    i9 = iB;
                }
                if (iB > i10) {
                    i10 = iB;
                }
            }
        }
        iArr[0] = i9;
        iArr[1] = i10;
    }

    public final y E(int i9) {
        y yVar = null;
        if (this.f8036y) {
            return null;
        }
        int iH = this.f8005e.h();
        for (int i10 = 0; i10 < iH; i10++) {
            y yVarI = I(this.f8005e.g(i10));
            if (yVarI != null && !yVarI.h() && F(yVarI) == i9) {
                if (!this.f8005e.f8207c.contains(yVarI.f8129a)) {
                    return yVarI;
                }
                yVar = yVarI;
            }
        }
        return yVar;
    }

    public final int F(y yVar) {
        if (((yVar.j & 524) != 0) || !yVar.e()) {
            return -1;
        }
        C0549a c0549a = this.f8004d;
        int i9 = yVar.f8131c;
        ArrayList<C0549a.C0110a> arrayList = c0549a.f8198b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            C0549a.C0110a c0110a = arrayList.get(i10);
            int i11 = c0110a.f8202a;
            if (i11 != 1) {
                if (i11 == 2) {
                    int i12 = c0110a.f8203b;
                    if (i12 <= i9) {
                        int i13 = c0110a.f8204c;
                        if (i12 + i13 > i9) {
                            return -1;
                        }
                        i9 -= i13;
                    } else {
                        continue;
                    }
                } else if (i11 == 8) {
                    int i14 = c0110a.f8203b;
                    if (i14 == i9) {
                        i9 = c0110a.f8204c;
                    } else {
                        if (i14 < i9) {
                            i9--;
                        }
                        if (c0110a.f8204c <= i9) {
                            i9++;
                        }
                    }
                }
            } else if (c0110a.f8203b <= i9) {
                i9 += c0110a.f8204c;
            }
        }
        return i9;
    }

    public final long G(y yVar) {
        return this.f8010k.f8044b ? yVar.f8133e : yVar.f8131c;
    }

    public final y H(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return I(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect J(View view) {
        m mVar = (m) view.getLayoutParams();
        boolean z8 = mVar.f8076c;
        Rect rect = mVar.f8075b;
        if (!z8 || (this.f8016n0.f8114g && (mVar.f8074a.k() || mVar.f8074a.f()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList<k> arrayList = this.f8013m;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            Rect rect2 = this.f8008h;
            rect2.set(0, 0, 0, 0);
            arrayList.get(i9).getClass();
            ((m) view.getLayoutParams()).f8074a.getClass();
            rect2.set(0, 0, 0, 0);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        mVar.f8076c = false;
        return rect;
    }

    public final boolean K() {
        return !this.f8023r || this.f8036y || this.f8004d.f();
    }

    public final boolean L() {
        return this.f7976A > 0;
    }

    public final void M(int i9) {
        if (this.f8011l == null) {
            return;
        }
        setScrollState(2);
        this.f8011l.n0(i9);
        awakenScrollBars();
    }

    public final void N() {
        int iH = this.f8005e.h();
        for (int i9 = 0; i9 < iH; i9++) {
            ((m) this.f8005e.g(i9).getLayoutParams()).f8076c = true;
        }
        ArrayList<y> arrayList = this.f8002b.f8086c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10).f8129a.getLayoutParams();
            if (mVar != null) {
                mVar.f8076c = true;
            }
        }
    }

    public final void O(int i9, int i10, boolean z8) {
        int i11 = i9 + i10;
        int iH = this.f8005e.h();
        for (int i12 = 0; i12 < iH; i12++) {
            y yVarI = I(this.f8005e.g(i12));
            if (yVarI != null && !yVarI.o()) {
                int i13 = yVarI.f8131c;
                v vVar = this.f8016n0;
                if (i13 >= i11) {
                    yVarI.l(-i10, z8);
                    vVar.f8113f = true;
                } else if (i13 >= i9) {
                    yVarI.a(8);
                    yVarI.l(-i10, z8);
                    yVarI.f8131c = i9 - 1;
                    vVar.f8113f = true;
                }
            }
        }
        r rVar = this.f8002b;
        ArrayList<y> arrayList = rVar.f8086c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            y yVar = arrayList.get(size);
            if (yVar != null) {
                int i14 = yVar.f8131c;
                if (i14 >= i11) {
                    yVar.l(-i10, z8);
                } else if (i14 >= i9) {
                    yVar.a(8);
                    rVar.e(size);
                }
            }
        }
        requestLayout();
    }

    public final void P() {
        this.f7976A++;
    }

    public final void Q(boolean z8) {
        int i9;
        AccessibilityManager accessibilityManager;
        int i10 = this.f7976A - 1;
        this.f7976A = i10;
        if (i10 < 1) {
            this.f7976A = 0;
            if (z8) {
                int i11 = this.f8032w;
                this.f8032w = 0;
                if (i11 != 0 && (accessibilityManager = this.f8034x) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(OpusCodecConfig.APPLICATION_VOIP);
                    accessibilityEventObtain.setContentChangeTypes(i11);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.f7977A0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    y yVar = (y) arrayList.get(size);
                    if (yVar.f8129a.getParent() == this && !yVar.o() && (i9 = yVar.f8144q) != -1) {
                        WeakHashMap<View, L> weakHashMap = G.f4313a;
                        yVar.f8129a.setImportantForAccessibility(i9);
                        yVar.f8144q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void R(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f7988J) {
            int i9 = actionIndex == 0 ? 1 : 0;
            this.f7988J = motionEvent.getPointerId(i9);
            int x8 = (int) (motionEvent.getX(i9) + 0.5f);
            this.f7992N = x8;
            this.f7990L = x8;
            int y8 = (int) (motionEvent.getY(i9) + 0.5f);
            this.O = y8;
            this.f7991M = y8;
        }
    }

    public final void S() {
        if (this.f8027t0 || !this.f8019p) {
            return;
        }
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        postOnAnimation(this.f7979B0);
        this.f8027t0 = true;
    }

    public final void T(boolean z8) {
        this.f8038z = z8 | this.f8038z;
        this.f8036y = true;
        int iH = this.f8005e.h();
        for (int i9 = 0; i9 < iH; i9++) {
            y yVarI = I(this.f8005e.g(i9));
            if (yVarI != null && !yVarI.o()) {
                yVarI.a(6);
            }
        }
        N();
        r rVar = this.f8002b;
        ArrayList<y> arrayList = rVar.f8086c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            y yVar = arrayList.get(i10);
            if (yVar != null) {
                yVar.a(6);
                yVar.a(1024);
            }
        }
        d dVar = RecyclerView.this.f8010k;
        if (dVar == null || !dVar.f8044b) {
            rVar.d();
        }
    }

    public final void U(y yVar, i.b bVar) {
        yVar.j &= -8193;
        boolean z8 = this.f8016n0.f8115h;
        C c5 = this.f8006f;
        if (z8 && yVar.k() && !yVar.h() && !yVar.o()) {
            c5.f7920b.d(G(yVar), yVar);
        }
        p155u.g<y, C.a> gVar = c5.f7919a;
        C.a aVarA = gVar.get(yVar);
        if (aVarA == null) {
            aVarA = C.a.a();
            gVar.put(yVar, aVarA);
        }
        aVarA.f7923b = bVar;
        aVarA.f7922a |= 4;
    }

    public final void V(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f8008h;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof m) {
            m mVar = (m) layoutParams;
            if (!mVar.f8076c) {
                int i9 = rect.left;
                Rect rect2 = mVar.f8075b;
                rect.left = i9 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f8011l.k0(this, view, this.f8008h, !this.f8023r, view2 == null);
    }

    public final void W() {
        VelocityTracker velocityTracker = this.f7989K;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        d0(0);
        EdgeEffect edgeEffect = this.f7982D;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f7982D.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f7983E;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f7983E.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f7984F;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f7984F.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f7985G;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f7985G.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fb A[DONT_INVERT, PHI: r7
  0x00fb: PHI (r7v10 boolean) = (r7v8 boolean), (r7v11 boolean) binds: [B:34:0x00e2, B:32:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:41:0x0105  */
    public final boolean X(int i9, int i10, MotionEvent motionEvent) {
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z8;
        boolean z9;
        m();
        d dVar = this.f8010k;
        int[] iArr = this.f8039z0;
        if (dVar != null) {
            iArr[0] = 0;
            iArr[1] = 0;
            Y(i9, i10, iArr);
            i11 = iArr[0];
            i12 = iArr[1];
            i13 = i9 - i11;
            i14 = i10 - i12;
        } else {
            i11 = 0;
            i12 = 0;
            i13 = 0;
            i14 = 0;
        }
        if (!this.f8013m.isEmpty()) {
            invalidate();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        s(i11, i12, i13, i14, this.f8035x0, 0, iArr);
        int i15 = iArr[0];
        int i16 = i13 - i15;
        int i17 = iArr[1];
        int i18 = i14 - i17;
        boolean z10 = (i15 == 0 && i17 == 0) ? false : true;
        int i19 = this.f7992N;
        int[] iArr2 = this.f8035x0;
        int i20 = iArr2[0];
        this.f7992N = i19 - i20;
        int i21 = this.O;
        int i22 = iArr2[1];
        this.O = i21 - i22;
        int[] iArr3 = this.f8037y0;
        iArr3[0] = iArr3[0] + i20;
        iArr3[1] = iArr3[1] + i22;
        if (getOverScrollMode() != 2) {
            if (motionEvent == null || (motionEvent.getSource() & ErrorCode.SUB_ERR_SCAN_DEVICE_FAILED) == 8194) {
                z8 = true;
            } else {
                float x8 = motionEvent.getX();
                float f6 = i16;
                float y8 = motionEvent.getY();
                float f9 = i18;
                if (f6 < 0.0f) {
                    v();
                    z8 = true;
                    this.f7982D.onPull((-f6) / getWidth(), 1.0f - (y8 / getHeight()));
                } else {
                    z8 = true;
                    if (f6 > 0.0f) {
                        w();
                        this.f7984F.onPull(f6 / getWidth(), y8 / getHeight());
                    } else {
                        z9 = false;
                    }
                    if (f9 < 0.0f) {
                        x();
                        this.f7983E.onPull((-f9) / getHeight(), x8 / getWidth());
                    } else if (f9 > 0.0f) {
                        u();
                        this.f7985G.onPull(f9 / getHeight(), 1.0f - (x8 / getWidth()));
                    } else if (z9 || f6 != 0.0f || f9 != 0.0f) {
                        WeakHashMap<View, L> weakHashMap = G.f4313a;
                        postInvalidateOnAnimation();
                    }
                    z9 = z8;
                    if (z9) {
                        WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                        postInvalidateOnAnimation();
                    } else {
                        WeakHashMap<View, L> weakHashMap3 = G.f4313a;
                        postInvalidateOnAnimation();
                    }
                }
                z9 = z8;
                if (f9 < 0.0f) {
                    x();
                    this.f7983E.onPull((-f9) / getHeight(), x8 / getWidth());
                } else if (f9 > 0.0f) {
                    u();
                    this.f7985G.onPull(f9 / getHeight(), 1.0f - (x8 / getWidth()));
                } else if (z9) {
                    WeakHashMap<View, L> weakHashMap4 = G.f4313a;
                    postInvalidateOnAnimation();
                } else {
                    WeakHashMap<View, L> weakHashMap5 = G.f4313a;
                    postInvalidateOnAnimation();
                }
                z9 = z8;
                if (z9) {
                    WeakHashMap<View, L> weakHashMap6 = G.f4313a;
                    postInvalidateOnAnimation();
                } else {
                    WeakHashMap<View, L> weakHashMap7 = G.f4313a;
                    postInvalidateOnAnimation();
                }
            }
            l(i9, i10);
        } else {
            z8 = true;
        }
        if (i11 != 0 || i12 != 0) {
            t(i11, i12);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z10 && i11 == 0 && i12 == 0) {
            return false;
        }
        return z8;
    }

    public final void Y(int i9, int i10, int[] iArr) {
        y yVar;
        C0550b c0550b = this.f8005e;
        b0();
        P();
        int i11 = P.g.f3603a;
        Trace.beginSection("RV Scroll");
        v vVar = this.f8016n0;
        z(vVar);
        r rVar = this.f8002b;
        int iM0 = i9 != 0 ? this.f8011l.m0(i9, rVar, vVar) : 0;
        int iO0 = i10 != 0 ? this.f8011l.o0(i10, rVar, vVar) : 0;
        Trace.endSection();
        int iE = c0550b.e();
        for (int i12 = 0; i12 < iE; i12++) {
            View viewD = c0550b.d(i12);
            y yVarH = H(viewD);
            if (yVarH != null && (yVar = yVarH.f8137i) != null) {
                int left = viewD.getLeft();
                int top = viewD.getTop();
                View view = yVar.f8129a;
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        Q(true);
        c0(false);
        if (iArr != null) {
            iArr[0] = iM0;
            iArr[1] = iO0;
        }
    }

    public final void Z(int i9) {
        androidx.recyclerview.widget.o oVar;
        if (this.f8028u) {
            return;
        }
        setScrollState(0);
        x xVar = this.f8000W;
        RecyclerView.this.removeCallbacks(xVar);
        xVar.f8123c.abortAnimation();
        l lVar = this.f8011l;
        if (lVar != null && (oVar = lVar.f8058e) != null) {
            oVar.d();
        }
        l lVar2 = this.f8011l;
        if (lVar2 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            lVar2.n0(i9);
            awakenScrollBars();
        }
    }

    public final void a0(int i9, int i10, boolean z8) {
        l lVar = this.f8011l;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f8028u) {
            return;
        }
        if (!lVar.d()) {
            i9 = 0;
        }
        if (!this.f8011l.e()) {
            i10 = 0;
        }
        if (i9 == 0 && i10 == 0) {
            return;
        }
        if (z8) {
            int i11 = i9 != 0 ? 1 : 0;
            if (i10 != 0) {
                i11 |= 2;
            }
            getScrollingChildHelper().g(i11, 1);
        }
        this.f8000W.b(i9, i10, Integer.MIN_VALUE, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i9, int i10) {
        l lVar = this.f8011l;
        if (lVar != null) {
            lVar.getClass();
        }
        super.addFocusables(arrayList, i9, i10);
    }

    public final void b0() {
        int i9 = this.f8025s + 1;
        this.f8025s = i9;
        if (i9 != 1 || this.f8028u) {
            return;
        }
        this.t = false;
    }

    public final void c0(boolean z8) {
        if (this.f8025s < 1) {
            this.f8025s = 1;
        }
        if (!z8 && !this.f8028u) {
            this.t = false;
        }
        if (this.f8025s == 1) {
            if (z8 && this.t && !this.f8028u && this.f8011l != null && this.f8010k != null) {
                o();
            }
            if (!this.f8028u) {
                this.t = false;
            }
        }
        this.f8025s--;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof m) && this.f8011l.f((m) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        l lVar = this.f8011l;
        if (lVar != null && lVar.d()) {
            return this.f8011l.j(this.f8016n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        l lVar = this.f8011l;
        if (lVar != null && lVar.d()) {
            return this.f8011l.k(this.f8016n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        l lVar = this.f8011l;
        if (lVar != null && lVar.d()) {
            return this.f8011l.l(this.f8016n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        l lVar = this.f8011l;
        if (lVar != null && lVar.e()) {
            return this.f8011l.m(this.f8016n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        l lVar = this.f8011l;
        if (lVar != null && lVar.e()) {
            return this.f8011l.n(this.f8016n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        l lVar = this.f8011l;
        if (lVar != null && lVar.e()) {
            return this.f8011l.o(this.f8016n0);
        }
        return 0;
    }

    public final void d0(int i9) {
        getScrollingChildHelper().h(i9);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f6, float f9, boolean z8) {
        return getScrollingChildHelper().a(f6, f9, z8);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f6, float f9) {
        return getScrollingChildHelper().b(f6, f9);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i9, int i10, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i9, i10, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i9, int i10, int i11, int i12, int[] iArr) {
        return getScrollingChildHelper().d(i9, i10, i11, i12, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z8;
        super.draw(canvas);
        ArrayList<k> arrayList = this.f8013m;
        int size = arrayList.size();
        boolean z9 = false;
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.get(i9).d(canvas, this);
        }
        EdgeEffect edgeEffect = this.f7982D;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z8 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f8007g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f7982D;
            z8 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f7983E;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f8007g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f7983E;
            z8 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f7984F;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f8007g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f7984F;
            z8 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f7985G;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f8007g) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f7985G;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z9 = true;
            }
            z8 |= z9;
            canvas.restoreToCount(iSave4);
        }
        if ((z8 || this.f7986H == null || arrayList.size() <= 0 || !this.f7986H.f()) ? z8 : true) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j8) {
        return super.drawChild(canvas, view, j8);
    }

    public final void f(y yVar) {
        View view = yVar.f8129a;
        boolean z8 = view.getParent() == this;
        this.f8002b.j(H(view));
        if (yVar.j()) {
            this.f8005e.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z8) {
            this.f8005e.a(view, -1, true);
            return;
        }
        C0550b c0550b = this.f8005e;
        int iIndexOfChild = c0550b.f8205a.f8331a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            c0550b.f8206b.h(iIndexOfChild);
            c0550b.i(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0161  */
    /* JADX WARN: Code duplicated, block: B:136:0x0198 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:137:0x0199  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i9) {
        View viewS;
        int i10;
        byte b9;
        boolean z8;
        this.f8011l.getClass();
        boolean z9 = true;
        boolean z10 = (this.f8010k == null || this.f8011l == null || L() || this.f8028u) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        v vVar = this.f8016n0;
        r rVar = this.f8002b;
        if (z10 && (i9 == 2 || i9 == 1)) {
            if (this.f8011l.e()) {
                if (focusFinder.findNextFocus(this, view, i9 == 2 ? 130 : 33) == null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
            } else {
                z8 = false;
            }
            if (!z8 && this.f8011l.d()) {
                z8 = focusFinder.findNextFocus(this, view, (this.f8011l.C() == 1) ^ (i9 == 2) ? 66 : 17) == null;
            }
            if (z8) {
                m();
                if (A(view) != null) {
                    b0();
                    this.f8011l.S(view, i9, rVar, vVar);
                    c0(false);
                }
                return null;
            }
            viewS = focusFinder.findNextFocus(this, view, i9);
            if (viewS == null) {
            }
            if (viewS != null) {
                z9 = false;
            } else {
                z9 = false;
            }
            if (z9) {
                return viewS;
            }
            return super.focusSearch(view, i9);
        }
        View viewFindNextFocus = focusFinder.findNextFocus(this, view, i9);
        if (viewFindNextFocus == null && z10) {
            m();
            if (A(view) != null) {
                b0();
                viewS = this.f8011l.S(view, i9, rVar, vVar);
                c0(false);
            }
            return null;
        }
        viewS = viewFindNextFocus;
        if (viewS == null && !viewS.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i9);
            }
            V(viewS, null);
            return view;
        }
        if (viewS != null || viewS == this) {
            z9 = false;
        } else if (A(viewS) == null) {
            z9 = false;
        } else if (view != null && A(view) != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            Rect rect = this.f8008h;
            rect.set(0, 0, width, height);
            int width2 = viewS.getWidth();
            int height2 = viewS.getHeight();
            Rect rect2 = this.f8009i;
            rect2.set(0, 0, width2, height2);
            offsetDescendantRectToMyCoords(view, rect);
            offsetDescendantRectToMyCoords(viewS, rect2);
            int i11 = this.f8011l.C() == 1 ? -1 : 1;
            int i12 = rect.left;
            int i13 = rect2.left;
            if ((i12 < i13 || rect.right <= i13) && rect.right < rect2.right) {
                i10 = 1;
            } else {
                int i14 = rect.right;
                int i15 = rect2.right;
                i10 = ((i14 > i15 || i12 >= i15) && i12 > i13) ? -1 : 0;
            }
            int i16 = rect.top;
            int i17 = rect2.top;
            if ((i16 < i17 || rect.bottom <= i17) && rect.bottom < rect2.bottom) {
                b9 = 1;
            } else {
                int i18 = rect.bottom;
                int i19 = rect2.bottom;
                b9 = ((i18 > i19 || i16 >= i19) && i16 > i17) ? (byte) -1 : (byte) 0;
            }
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 17) {
                        if (i9 != 33) {
                            if (i9 != 66) {
                                if (i9 != 130) {
                                    throw new IllegalArgumentException("Invalid direction: " + i9 + y());
                                }
                                if (b9 <= 0) {
                                    z9 = false;
                                }
                            } else if (i10 <= 0) {
                                z9 = false;
                            }
                        } else if (b9 >= 0) {
                            z9 = false;
                        }
                    } else if (i10 >= 0) {
                        z9 = false;
                    }
                } else if (b9 <= 0 && (b9 != 0 || i10 * i11 < 0)) {
                    z9 = false;
                }
            } else if (b9 >= 0 && (b9 != 0 || i10 * i11 > 0)) {
                z9 = false;
            }
        }
        if (z9) {
            return viewS;
        }
        return super.focusSearch(view, i9);
    }

    public final void g(k kVar) {
        l lVar = this.f8011l;
        if (lVar != null) {
            lVar.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList<k> arrayList = this.f8013m;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(kVar);
        N();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        l lVar = this.f8011l;
        if (lVar != null) {
            return lVar.r();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + y());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        l lVar = this.f8011l;
        if (lVar != null) {
            return lVar.s(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + y());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public d getAdapter() {
        return this.f8010k;
    }

    @Override // android.view.View
    public int getBaseline() {
        l lVar = this.f8011l;
        if (lVar == null) {
            return super.getBaseline();
        }
        lVar.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i9, int i10) {
        return super.getChildDrawingOrder(i9, i10);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f8007g;
    }

    public androidx.recyclerview.widget.x getCompatAccessibilityDelegate() {
        return this.f8029u0;
    }

    public h getEdgeEffectFactory() {
        return this.f7980C;
    }

    public i getItemAnimator() {
        return this.f7986H;
    }

    public int getItemDecorationCount() {
        return this.f8013m.size();
    }

    public l getLayoutManager() {
        return this.f8011l;
    }

    public int getMaxFlingVelocity() {
        return this.f7996S;
    }

    public int getMinFlingVelocity() {
        return this.f7995R;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public n getOnFlingListener() {
        return this.f7994Q;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f7999V;
    }

    public q getRecycledViewPool() {
        return this.f8002b.c();
    }

    public int getScrollState() {
        return this.f7987I;
    }

    public final void h(p pVar) {
        if (this.f8020p0 == null) {
            this.f8020p0 = new ArrayList();
        }
        this.f8020p0.add(pVar);
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i(String str) {
        if (L()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + y());
        }
        if (this.f7978B > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + y()));
        }
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f8019p;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f8028u;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f4448d;
    }

    public final void k() {
        int iH = this.f8005e.h();
        for (int i9 = 0; i9 < iH; i9++) {
            y yVarI = I(this.f8005e.g(i9));
            if (!yVarI.o()) {
                yVarI.f8132d = -1;
                yVarI.f8135g = -1;
            }
        }
        r rVar = this.f8002b;
        ArrayList<y> arrayList = rVar.f8086c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            y yVar = arrayList.get(i10);
            yVar.f8132d = -1;
            yVar.f8135g = -1;
        }
        ArrayList<y> arrayList2 = rVar.f8084a;
        int size2 = arrayList2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            y yVar2 = arrayList2.get(i11);
            yVar2.f8132d = -1;
            yVar2.f8135g = -1;
        }
        ArrayList<y> arrayList3 = rVar.f8085b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i12 = 0; i12 < size3; i12++) {
                y yVar3 = rVar.f8085b.get(i12);
                yVar3.f8132d = -1;
                yVar3.f8135g = -1;
            }
        }
    }

    public final void l(int i9, int i10) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f7982D;
        if (edgeEffect == null || edgeEffect.isFinished() || i9 <= 0) {
            zIsFinished = false;
        } else {
            this.f7982D.onRelease();
            zIsFinished = this.f7982D.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f7984F;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i9 < 0) {
            this.f7984F.onRelease();
            zIsFinished |= this.f7984F.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f7983E;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i10 > 0) {
            this.f7983E.onRelease();
            zIsFinished |= this.f7983E.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f7985G;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i10 < 0) {
            this.f7985G.onRelease();
            zIsFinished |= this.f7985G.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            postInvalidateOnAnimation();
        }
    }

    public final void m() {
        C0549a c0549a = this.f8004d;
        if (!this.f8023r || this.f8036y) {
            int i9 = P.g.f3603a;
            Trace.beginSection("RV FullInvalidate");
            o();
            Trace.endSection();
            return;
        }
        if (c0549a.f()) {
            c0549a.getClass();
            if (c0549a.f()) {
                int i10 = P.g.f3603a;
                Trace.beginSection("RV FullInvalidate");
                o();
                Trace.endSection();
            }
        }
    }

    public final void n(int i9, int i10) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        setMeasuredDimension(l.g(i9, paddingRight, getMinimumWidth()), l.g(i10, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    /* JADX WARN: Code duplicated, block: B:157:0x0329  */
    /* JADX WARN: Code duplicated, block: B:176:0x036d  */
    /* JADX WARN: Code duplicated, block: B:178:0x0370  */
    /* JADX WARN: Code duplicated, block: B:184:0x0385  */
    /* JADX WARN: Code duplicated, block: B:186:0x038d  */
    /* JADX WARN: Code duplicated, block: B:188:0x0391  */
    /* JADX WARN: Code duplicated, block: B:191:0x0399  */
    /* JADX WARN: Code duplicated, block: B:194:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:197:0x03aa A[LOOP:4: B:190:0x0397->B:197:0x03aa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:200:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:203:0x03be  */
    /* JADX WARN: Code duplicated, block: B:206:0x03c8 A[LOOP:5: B:199:0x03b5->B:206:0x03c8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:208:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:238:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:239:0x03a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x03cb A[EDGE_INSN: B:242:0x03cb->B:207:0x03cb BREAK  A[LOOP:5: B:199:0x03b5->B:206:0x03c8], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x03c6 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void o() {
        boolean z8;
        long j8;
        y yVar;
        int i9;
        int iB;
        int i10;
        int iMin;
        y yVarE;
        View view;
        y yVarE2;
        View view2;
        int i11;
        View viewFindViewById;
        ArrayList arrayList;
        View view3;
        boolean z9;
        i.b bVar;
        ?? r8;
        boolean zG;
        boolean z10;
        if (this.f8010k == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f8011l == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        v vVar = this.f8016n0;
        boolean z11 = false;
        vVar.f8116i = false;
        boolean z12 = true;
        if (vVar.f8111d == 1) {
            p();
            this.f8011l.p0(this);
            q();
        } else {
            C0549a c0549a = this.f8004d;
            if ((c0549a.f8199c.isEmpty() || c0549a.f8198b.isEmpty()) && this.f8011l.f8066n == getWidth() && this.f8011l.f8067o == getHeight()) {
                this.f8011l.p0(this);
            } else {
                this.f8011l.p0(this);
                q();
            }
        }
        vVar.a(4);
        b0();
        P();
        vVar.f8111d = 1;
        boolean z13 = vVar.j;
        r rVar = this.f8002b;
        C c5 = this.f8006f;
        if (z13) {
            int iE = this.f8005e.e() - 1;
            while (iE >= 0) {
                y yVarI = I(this.f8005e.d(iE));
                if (yVarI.o()) {
                    z10 = z12;
                } else {
                    long jG = G(yVarI);
                    this.f7986H.getClass();
                    i.b bVar2 = new i.b();
                    bVar2.a(yVarI);
                    y yVarB = c5.f7920b.b(jG);
                    if (yVarB == null || yVarB.o()) {
                        z10 = z12;
                        c5.a(yVarI, bVar2);
                    } else {
                        p155u.g<y, C.a> gVar = c5.f7919a;
                        z10 = z12;
                        C.a aVar = gVar.get(yVarB);
                        boolean z14 = (aVar == null || (aVar.f7922a & 1) == 0) ? false : z10;
                        C.a aVar2 = gVar.get(yVarI);
                        boolean z15 = (aVar2 == null || (aVar2.f7922a & 1) == 0) ? false : z10;
                        if (z14 && yVarB == yVarI) {
                            c5.a(yVarI, bVar2);
                        } else {
                            i.b bVarB = c5.b(yVarB, 4);
                            c5.a(yVarI, bVar2);
                            i.b bVarB2 = c5.b(yVarI, 8);
                            if (bVarB == null) {
                                int iE2 = this.f8005e.e();
                                for (int i12 = 0; i12 < iE2; i12++) {
                                    y yVarI2 = I(this.f8005e.d(i12));
                                    if (yVarI2 != yVarI && G(yVarI2) == jG) {
                                        d dVar = this.f8010k;
                                        if (dVar == null || !dVar.f8044b) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + yVarI2 + " \n View Holder 2:" + yVarI + y());
                                        }
                                        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + yVarI2 + " \n View Holder 2:" + yVarI + y());
                                    }
                                }
                                Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + yVarB + " cannot be found but it is necessary for " + yVarI + y());
                            } else {
                                yVarB.n(false);
                                if (z14) {
                                    f(yVarB);
                                }
                                if (yVarB != yVarI) {
                                    if (z15) {
                                        f(yVarI);
                                    }
                                    yVarB.f8136h = yVarI;
                                    f(yVarB);
                                    rVar.j(yVarB);
                                    yVarI.n(false);
                                    yVarI.f8137i = yVarB;
                                }
                                if (this.f7986H.a(yVarB, yVarI, bVarB, bVarB2)) {
                                    S();
                                }
                            }
                        }
                    }
                }
                iE--;
                z12 = z10;
            }
            z8 = z12;
            p155u.g<y, C.a> gVar2 = c5.f7919a;
            int i13 = gVar2.f21660c - 1;
            while (i13 >= 0) {
                y yVarF = gVar2.f(i13);
                C.a aVarG = gVar2.g(i13);
                int i14 = aVarG.f7922a;
                int i15 = i14 & 3;
                c cVar = this.f7981C0;
                if (i15 == 3) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.f8011l.i0(yVarF.f8129a, recyclerView.f8002b);
                    r8 = z11;
                } else if ((i14 & 1) != 0) {
                    i.b bVar3 = aVarG.f7923b;
                    if (bVar3 == null) {
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.f8011l.i0(yVarF.f8129a, recyclerView2.f8002b);
                        r8 = z11;
                    } else {
                        cVar.b(yVarF, bVar3, aVarG.f7924c);
                        r8 = z11;
                    }
                } else if ((i14 & 14) == 14) {
                    cVar.a(yVarF, aVarG.f7923b, aVarG.f7924c);
                    r8 = z11;
                } else {
                    if ((i14 & 12) == 12) {
                        i.b bVar4 = aVarG.f7923b;
                        i.b bVar5 = aVarG.f7924c;
                        cVar.getClass();
                        yVarF.n(z11);
                        RecyclerView recyclerView3 = RecyclerView.this;
                        if (!recyclerView3.f8036y) {
                            z zVar = (z) recyclerView3.f7986H;
                            zVar.getClass();
                            int i16 = bVar4.f8051a;
                            int i17 = bVar5.f8051a;
                            if (i16 == i17 && bVar4.f8052b == bVar5.f8052b) {
                                zVar.c(yVarF);
                                zG = false;
                            } else {
                                zG = zVar.g(yVarF, i16, bVar4.f8052b, i17, bVar5.f8052b);
                            }
                            if (zG) {
                                recyclerView3.S();
                            }
                        } else if (recyclerView3.f7986H.a(yVarF, yVarF, bVar4, bVar5)) {
                            recyclerView3.S();
                        }
                        r8 = 0;
                    } else {
                        if ((i14 & 4) != 0) {
                            bVar = null;
                            cVar.b(yVarF, aVarG.f7923b, null);
                        } else {
                            bVar = null;
                            if ((i14 & 8) != 0) {
                                cVar.a(yVarF, aVarG.f7923b, aVarG.f7924c);
                            }
                        }
                        r8 = 0;
                    }
                    aVarG.f7922a = r8;
                    aVarG.f7923b = bVar;
                    aVarG.f7924c = bVar;
                    C.a.f7921d.f(aVarG);
                    i13--;
                    z11 = false;
                }
                bVar = null;
                aVarG.f7922a = r8;
                aVarG.f7923b = bVar;
                aVarG.f7924c = bVar;
                C.a.f7921d.f(aVarG);
                i13--;
                z11 = false;
            }
        } else {
            z8 = true;
        }
        View view4 = null;
        this.f8011l.h0(rVar);
        vVar.f8109b = vVar.f8112e;
        this.f8036y = false;
        this.f8038z = false;
        vVar.j = false;
        vVar.f8117k = false;
        this.f8011l.f8059f = false;
        ArrayList<y> arrayList2 = rVar.f8085b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        l lVar = this.f8011l;
        if (lVar.f8063k) {
            lVar.j = 0;
            lVar.f8063k = false;
            rVar.k();
        }
        this.f8011l.c0(vVar);
        boolean z16 = z8;
        Q(z16);
        c0(false);
        c5.f7919a.clear();
        c5.f7920b.a();
        int[] iArr = this.f8031v0;
        int i18 = iArr[0];
        int i19 = iArr[z16 ? 1 : 0];
        C(iArr);
        if ((iArr[0] == i18 && iArr[z16 ? 1 : 0] == i19) ? false : true) {
            t(0, 0);
        }
        if (this.f7999V && this.f8010k != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
            if (isFocused()) {
                j8 = vVar.f8119m;
                if (j8 == -1) {
                    yVar = null;
                } else {
                    yVar = null;
                }
                if (yVar != null) {
                    arrayList = this.f8005e.f8207c;
                    view3 = yVar.f8129a;
                    if (!arrayList.contains(view3)) {
                        if (this.f8005e.e() > 0) {
                            int i20 = vVar.f8118l;
                            if (i20 != -1) {
                            }
                            iB = vVar.b();
                            i10 = i9;
                            while (true) {
                                if (i10 < iB) {
                                    yVarE2 = E(i10);
                                    if (yVarE2 != null) {
                                        view2 = yVarE2.f8129a;
                                        if (view2.hasFocusable()) {
                                            view4 = view2;
                                        } else {
                                            i10++;
                                        }
                                    }
                                }
                                for (iMin = Math.min(iB, i9) - 1; iMin >= 0; iMin--) {
                                    yVarE = E(iMin);
                                    if (yVarE == null) {
                                        break;
                                        break;
                                    }
                                    view = yVarE.f8129a;
                                    if (view.hasFocusable()) {
                                        view4 = view;
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (this.f8005e.e() > 0) {
                        int i21 = vVar.f8118l;
                        if (i21 != -1) {
                        }
                        iB = vVar.b();
                        i10 = i9;
                        while (true) {
                            if (i10 < iB) {
                                yVarE2 = E(i10);
                                if (yVarE2 != null) {
                                    view2 = yVarE2.f8129a;
                                    if (view2.hasFocusable()) {
                                        view4 = view2;
                                    } else {
                                        i10++;
                                    }
                                }
                            }
                            while (iMin >= 0) {
                                yVarE = E(iMin);
                                if (yVarE == null) {
                                    break;
                                    break;
                                }
                                view = yVarE.f8129a;
                                if (view.hasFocusable()) {
                                    view4 = view;
                                    break;
                                }
                            }
                        }
                    }
                } else if (this.f8005e.e() > 0) {
                    int i22 = vVar.f8118l;
                    if (i22 != -1) {
                    }
                    iB = vVar.b();
                    i10 = i9;
                    while (true) {
                        if (i10 < iB) {
                            yVarE2 = E(i10);
                            if (yVarE2 != null) {
                                view2 = yVarE2.f8129a;
                                if (view2.hasFocusable()) {
                                    view4 = view2;
                                } else {
                                    i10++;
                                }
                            }
                        }
                        while (iMin >= 0) {
                            yVarE = E(iMin);
                            if (yVarE == null) {
                                break;
                                break;
                            }
                            view = yVarE.f8129a;
                            if (view.hasFocusable()) {
                                view4 = view;
                                break;
                            }
                        }
                    }
                }
                if (view4 != null) {
                    i11 = vVar.f8120n;
                    if (i11 != -1) {
                        view4 = viewFindViewById;
                    }
                    view4.requestFocus();
                }
            } else if (this.f8005e.f8207c.contains(getFocusedChild())) {
                j8 = vVar.f8119m;
                if (j8 == -1 && (z9 = this.f8010k.f8044b) && z9) {
                    int iH = this.f8005e.h();
                    yVar = null;
                    for (int i23 = 0; i23 < iH; i23++) {
                        y yVarI3 = I(this.f8005e.g(i23));
                        if (yVarI3 != null && !yVarI3.h() && yVarI3.f8133e == j8) {
                            if (!this.f8005e.f8207c.contains(yVarI3.f8129a)) {
                                yVar = yVarI3;
                                break;
                            }
                            yVar = yVarI3;
                        }
                    }
                } else {
                    yVar = null;
                }
                if (yVar != null) {
                    arrayList = this.f8005e.f8207c;
                    view3 = yVar.f8129a;
                    if (!arrayList.contains(view3) && view3.hasFocusable()) {
                        view4 = view3;
                    } else if (this.f8005e.e() > 0) {
                        int i24 = vVar.f8118l;
                        i9 = i24 != -1 ? i24 : 0;
                        iB = vVar.b();
                        i10 = i9;
                        while (true) {
                            if (i10 < iB) {
                                yVarE2 = E(i10);
                                if (yVarE2 != null) {
                                    view2 = yVarE2.f8129a;
                                    if (view2.hasFocusable()) {
                                        view4 = view2;
                                    } else {
                                        i10++;
                                    }
                                }
                            }
                            while (iMin >= 0) {
                                yVarE = E(iMin);
                                if (yVarE == null) {
                                    break;
                                }
                                view = yVarE.f8129a;
                                if (view.hasFocusable()) {
                                    view4 = view;
                                    break;
                                }
                            }
                        }
                    }
                } else if (this.f8005e.e() > 0) {
                    int i25 = vVar.f8118l;
                    if (i25 != -1) {
                    }
                    iB = vVar.b();
                    i10 = i9;
                    while (true) {
                        if (i10 < iB) {
                            yVarE2 = E(i10);
                            if (yVarE2 != null) {
                                view2 = yVarE2.f8129a;
                                if (view2.hasFocusable()) {
                                    view4 = view2;
                                } else {
                                    i10++;
                                }
                            }
                        }
                        while (iMin >= 0) {
                            yVarE = E(iMin);
                            if (yVarE == null) {
                                break;
                                break;
                            }
                            view = yVarE.f8129a;
                            if (view.hasFocusable()) {
                                view4 = view;
                                break;
                            }
                        }
                    }
                }
                if (view4 != null) {
                    i11 = vVar.f8120n;
                    if (i11 != -1 && (viewFindViewById = view4.findViewById(i11)) != null && viewFindViewById.isFocusable()) {
                        view4 = viewFindViewById;
                    }
                    view4.requestFocus();
                }
            }
        }
        vVar.f8119m = -1L;
        vVar.f8118l = -1;
        vVar.f8120n = -1;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004f  */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.f7976A = 0;
        this.f8019p = true;
        this.f8023r = this.f8023r && !isLayoutRequested();
        l lVar = this.f8011l;
        if (lVar != null) {
            lVar.f8060g = true;
            lVar.Q(this);
        }
        this.f8027t0 = false;
        ThreadLocal<androidx.recyclerview.widget.m> threadLocal = androidx.recyclerview.widget.m.f8293e;
        androidx.recyclerview.widget.m mVar = threadLocal.get();
        this.f8012l0 = mVar;
        if (mVar == null) {
            this.f8012l0 = new androidx.recyclerview.widget.m();
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            Display display = getDisplay();
            if (isInEditMode() || display == null) {
                refreshRate = 60.0f;
            } else {
                refreshRate = display.getRefreshRate();
                if (refreshRate < 30.0f) {
                    refreshRate = 60.0f;
                }
            }
            androidx.recyclerview.widget.m mVar2 = this.f8012l0;
            mVar2.f8297c = (long) (1.0E9f / refreshRate);
            threadLocal.set(mVar2);
        }
        this.f8012l0.f8295a.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        androidx.recyclerview.widget.o oVar;
        super.onDetachedFromWindow();
        i iVar = this.f7986H;
        if (iVar != null) {
            iVar.e();
        }
        setScrollState(0);
        x xVar = this.f8000W;
        RecyclerView.this.removeCallbacks(xVar);
        xVar.f8123c.abortAnimation();
        l lVar = this.f8011l;
        if (lVar != null && (oVar = lVar.f8058e) != null) {
            oVar.d();
        }
        this.f8019p = false;
        l lVar2 = this.f8011l;
        if (lVar2 != null) {
            lVar2.f8060g = false;
            lVar2.R(this);
        }
        this.f7977A0.clear();
        removeCallbacks(this.f7979B0);
        this.f8006f.getClass();
        while (C.a.f7921d.d() != null) {
        }
        androidx.recyclerview.widget.m mVar = this.f8012l0;
        if (mVar != null) {
            mVar.f8295a.remove(this);
            this.f8012l0 = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList<k> arrayList = this.f8013m;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.get(i9).c(canvas, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0064  */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f6;
        float axisValue;
        if (this.f8011l != null && !this.f8028u && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f6 = this.f8011l.e() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.f8011l.d() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.f8011l.e()) {
                    f6 = -axisValue2;
                } else if (this.f8011l.d()) {
                    axisValue = axisValue2;
                    f6 = 0.0f;
                } else {
                    f6 = 0.0f;
                    axisValue = 0.0f;
                }
            } else {
                f6 = 0.0f;
                axisValue = 0.0f;
            }
            if (f6 != 0.0f || axisValue != 0.0f) {
                X((int) (axisValue * this.f7997T), (int) (f6 * this.f7998U), motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z8;
        if (!this.f8028u) {
            this.f8017o = null;
            if (B(motionEvent)) {
                W();
                setScrollState(0);
                return true;
            }
            l lVar = this.f8011l;
            if (lVar != null) {
                boolean zD = lVar.d();
                boolean zE = this.f8011l.e();
                if (this.f7989K == null) {
                    this.f7989K = VelocityTracker.obtain();
                }
                this.f7989K.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.f8030v) {
                        this.f8030v = false;
                    }
                    this.f7988J = motionEvent.getPointerId(0);
                    int x8 = (int) (motionEvent.getX() + 0.5f);
                    this.f7992N = x8;
                    this.f7990L = x8;
                    int y8 = (int) (motionEvent.getY() + 0.5f);
                    this.O = y8;
                    this.f7991M = y8;
                    if (this.f7987I == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        d0(1);
                    }
                    int[] iArr = this.f8037y0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i9 = zD;
                    if (zE) {
                        i9 = (zD ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i9, 0);
                } else if (actionMasked == 1) {
                    this.f7989K.clear();
                    d0(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f7988J);
                    if (iFindPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f7988J + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x9 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y9 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.f7987I != 1) {
                        int i10 = x9 - this.f7990L;
                        int i11 = y9 - this.f7991M;
                        if (!zD || Math.abs(i10) <= this.f7993P) {
                            z8 = false;
                        } else {
                            this.f7992N = x9;
                            z8 = true;
                        }
                        if (zE && Math.abs(i11) > this.f7993P) {
                            this.O = y9;
                            z8 = true;
                        }
                        if (z8) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    W();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.f7988J = motionEvent.getPointerId(actionIndex);
                    int x10 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.f7992N = x10;
                    this.f7990L = x10;
                    int y10 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.O = y10;
                    this.f7991M = y10;
                } else if (actionMasked == 6) {
                    R(motionEvent);
                }
                if (this.f7987I == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int i13 = P.g.f3603a;
        Trace.beginSection("RV OnLayout");
        o();
        Trace.endSection();
        this.f8023r = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        l lVar = this.f8011l;
        if (lVar == null) {
            n(i9, i10);
            return;
        }
        boolean zL = lVar.L();
        v vVar = this.f8016n0;
        if (!zL) {
            if (this.f8021q) {
                this.f8011l.f8055b.n(i9, i10);
                return;
            }
            if (vVar.f8117k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            d dVar = this.f8010k;
            if (dVar != null) {
                vVar.f8112e = dVar.a();
            } else {
                vVar.f8112e = 0;
            }
            b0();
            this.f8011l.f8055b.n(i9, i10);
            c0(false);
            vVar.f8114g = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i9);
        int mode2 = View.MeasureSpec.getMode(i10);
        this.f8011l.f8055b.n(i9, i10);
        if ((mode == 1073741824 && mode2 == 1073741824) || this.f8010k == null) {
            return;
        }
        if (vVar.f8111d == 1) {
            p();
        }
        this.f8011l.q0(i9, i10);
        vVar.f8116i = true;
        q();
        this.f8011l.s0(i9, i10);
        if (this.f8011l.v0()) {
            this.f8011l.q0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            vVar.f8116i = true;
            q();
            this.f8011l.s0(i9, i10);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i9, Rect rect) {
        if (L()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i9, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f8003c = savedState;
        super.onRestoreInstanceState(savedState.f7147a);
        l lVar = this.f8011l;
        if (lVar == null || (parcelable2 = this.f8003c.f8040c) == null) {
            return;
        }
        lVar.d0(parcelable2);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f8003c;
        if (savedState2 != null) {
            savedState.f8040c = savedState2.f8040c;
            return savedState;
        }
        l lVar = this.f8011l;
        if (lVar != null) {
            savedState.f8040c = lVar.e0();
            return savedState;
        }
        savedState.f8040c = null;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        if (i9 == i11 && i10 == i12) {
            return;
        }
        this.f7985G = null;
        this.f7983E = null;
        this.f7984F = null;
        this.f7982D = null;
    }

    /* JADX WARN: Code duplicated, block: B:152:0x0255  */
    /* JADX WARN: Code duplicated, block: B:215:0x031b  */
    /* JADX WARN: Code duplicated, block: B:217:0x0321 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:218:0x0323  */
    /* JADX WARN: Code duplicated, block: B:219:0x0326  */
    /* JADX WARN: Code duplicated, block: B:222:0x0355  */
    /* JADX WARN: Code duplicated, block: B:56:0x00fd A[PHI: r1
  0x00fd: PHI (r1v65 int) = (r1v50 int), (r1v69 int) binds: [B:50:0x00e6, B:54:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [androidx.recyclerview.widget.A, androidx.recyclerview.widget.u] */
    /* JADX WARN: Type inference failed for: r11v3, types: [androidx.recyclerview.widget.RecyclerView$l] */
    /* JADX WARN: Type inference failed for: r1v17, types: [T.o] */
    /* JADX WARN: Type inference failed for: r1v22, types: [T.o] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zB;
        ?? r9;
        ?? r22;
        int i9;
        ?? r8;
        x xVar;
        RecyclerView recyclerView;
        Interpolator interpolator;
        b bVar;
        int minFlingVelocity;
        boolean z8;
        androidx.recyclerview.widget.s sVarE;
        boolean z9;
        int iH;
        PointF pointFA;
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        if (!this.f8028u && !this.f8030v) {
            o oVar = this.f8017o;
            if (oVar == null) {
                zB = motionEvent.getAction() == 0 ? false : B(motionEvent);
            } else {
                oVar.a(motionEvent);
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.f8017o = null;
                }
                zB = true;
            }
            if (zB) {
                W();
                setScrollState(0);
                return true;
            }
            l lVar = this.f8011l;
            if (lVar != null) {
                boolean zD = lVar.d();
                boolean zE = this.f8011l.e();
                if (this.f7989K == null) {
                    this.f7989K = VelocityTracker.obtain();
                }
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                int[] iArr = this.f8037y0;
                if (actionMasked == 0) {
                    iArr[1] = 0;
                    iArr[0] = 0;
                }
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.offsetLocation(iArr[0], iArr[1]);
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        this.f7989K.addMovement(motionEventObtain);
                        VelocityTracker velocityTracker = this.f7989K;
                        int i12 = this.f7996S;
                        velocityTracker.computeCurrentVelocity(1000, i12);
                        float f6 = zD ? -this.f7989K.getXVelocity(this.f7988J) : 0.0f;
                        float f9 = zE ? -this.f7989K.getYVelocity(this.f7988J) : 0.0f;
                        if (f6 == 0.0f && f9 == 0.0f) {
                            i11 = 0;
                        } else {
                            int i13 = (int) f6;
                            int i14 = (int) f9;
                            l lVar2 = this.f8011l;
                            if (lVar2 == null) {
                                Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                            } else if (!this.f8028u) {
                                boolean zD2 = lVar2.d();
                                boolean zE2 = this.f8011l.e();
                                int i15 = this.f7995R;
                                if (!zD2 || Math.abs(i13) < i15) {
                                    i13 = 0;
                                }
                                if (!zE2 || Math.abs(i14) < i15) {
                                    i14 = 0;
                                }
                                if (i13 != 0 || i14 != 0) {
                                    float f10 = i13;
                                    float f11 = i14;
                                    if (!dispatchNestedPreFling(f10, f11)) {
                                        boolean z12 = zD2 || zE2;
                                        dispatchNestedFling(f10, f11, z12);
                                        n nVar = this.f7994Q;
                                        if (nVar != null) {
                                            A a3 = (A) nVar;
                                            ?? layoutManager = a3.f7908a.getLayoutManager();
                                            if (layoutManager == 0 || a3.f7908a.getAdapter() == null || ((Math.abs(i14) <= (minFlingVelocity = a3.f7908a.getMinFlingVelocity()) && Math.abs(i13) <= minFlingVelocity) || !((z8 = layoutManager instanceof u.b)))) {
                                                r22 = zD2;
                                                i9 = 1;
                                                if (z12) {
                                                    if (zE2) {
                                                        r8 = r22 | 2;
                                                    } else {
                                                        r8 = r22;
                                                    }
                                                    getScrollingChildHelper().g(r8, i9);
                                                    int i16 = -i12;
                                                    int iMax = Math.max(i16, Math.min(i13, i12));
                                                    int iMax2 = Math.max(i16, Math.min(i14, i12));
                                                    xVar = this.f8000W;
                                                    recyclerView = RecyclerView.this;
                                                    recyclerView.setScrollState(2);
                                                    xVar.f8122b = 0;
                                                    xVar.f8121a = 0;
                                                    interpolator = xVar.f8124d;
                                                    bVar = F0;
                                                    if (interpolator != bVar) {
                                                        xVar.f8124d = bVar;
                                                        xVar.f8123c = new OverScroller(recyclerView.getContext(), bVar);
                                                    }
                                                    xVar.f8123c.fling(0, 0, iMax, iMax2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                                    xVar.a();
                                                }
                                            } else {
                                                ?? r10 = (androidx.recyclerview.widget.u) a3;
                                                androidx.recyclerview.widget.t tVar = !z8 ? null : new androidx.recyclerview.widget.t(r10, r10.f7908a.getContext());
                                                if (tVar == null) {
                                                    r22 = zD2;
                                                    i9 = 1;
                                                } else {
                                                    int iB = layoutManager.B();
                                                    if (iB != 0) {
                                                        if (layoutManager.e()) {
                                                            sVarE = r10.f(layoutManager);
                                                        } else {
                                                            sVarE = layoutManager.d() ? r10.e(layoutManager) : null;
                                                        }
                                                        if (sVarE == null) {
                                                            z9 = zD2;
                                                            i9 = 1;
                                                        } else {
                                                            int iV = layoutManager.v();
                                                            int i17 = Integer.MIN_VALUE;
                                                            int i18 = Integer.MAX_VALUE;
                                                            View view = null;
                                                            View view2 = null;
                                                            i9 = 1;
                                                            int i19 = 0;
                                                            while (i19 < iV) {
                                                                boolean z13 = zD2;
                                                                View viewU = layoutManager.u(i19);
                                                                if (viewU == null) {
                                                                    i10 = i19;
                                                                } else {
                                                                    i10 = i19;
                                                                    int iC = androidx.recyclerview.widget.u.c(viewU, sVarE);
                                                                    if (iC <= 0 && iC > i17) {
                                                                        view2 = viewU;
                                                                        i17 = iC;
                                                                    }
                                                                    if (iC >= 0 && iC < i18) {
                                                                        view = viewU;
                                                                        i18 = iC;
                                                                    }
                                                                }
                                                                i19 = i10 + 1;
                                                                zD2 = z13;
                                                            }
                                                            z9 = zD2;
                                                            boolean z14 = !layoutManager.d() ? i14 <= 0 : i13 <= 0;
                                                            if (z14 && view != null) {
                                                                iH = l.H(view);
                                                                z10 = z9;
                                                            } else if (z14 || view2 == null) {
                                                                if (z14) {
                                                                    view = view2;
                                                                }
                                                                if (view != null) {
                                                                    iH = ((z8 && (pointFA = ((u.b) layoutManager).a(layoutManager.B() + (-1))) != null && ((pointFA.x > 0.0f ? 1 : (pointFA.x == 0.0f ? 0 : -1)) < 0 || (pointFA.y > 0.0f ? 1 : (pointFA.y == 0.0f ? 0 : -1)) < 0)) == z14 ? -1 : 1) + l.H(view);
                                                                    z10 = z9;
                                                                    if (iH < 0 || iH >= iB) {
                                                                    }
                                                                }
                                                            } else {
                                                                iH = l.H(view2);
                                                                z10 = z9;
                                                            }
                                                        }
                                                        iH = -1;
                                                        z10 = z9;
                                                    } else {
                                                        z9 = zD2;
                                                        i9 = 1;
                                                        iH = -1;
                                                        z10 = z9;
                                                    }
                                                    r22 = z10;
                                                    if (iH != -1) {
                                                        tVar.f8093a = iH;
                                                        layoutManager.y0(tVar);
                                                    }
                                                }
                                                if (z12) {
                                                    if (zE2) {
                                                        r8 = r22 | 2;
                                                    } else {
                                                        r8 = r22;
                                                    }
                                                    getScrollingChildHelper().g(r8, i9);
                                                    int i110 = -i12;
                                                    int iMax3 = Math.max(i110, Math.min(i13, i12));
                                                    int iMax4 = Math.max(i110, Math.min(i14, i12));
                                                    xVar = this.f8000W;
                                                    recyclerView = RecyclerView.this;
                                                    recyclerView.setScrollState(2);
                                                    xVar.f8122b = 0;
                                                    xVar.f8121a = 0;
                                                    interpolator = xVar.f8124d;
                                                    bVar = F0;
                                                    if (interpolator != bVar) {
                                                        xVar.f8124d = bVar;
                                                        xVar.f8123c = new OverScroller(recyclerView.getContext(), bVar);
                                                    }
                                                    xVar.f8123c.fling(0, 0, iMax3, iMax4, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                                    xVar.a();
                                                }
                                            }
                                        } else {
                                            r22 = zD2;
                                            i9 = 1;
                                            if (z12) {
                                                if (zE2) {
                                                    r8 = r22 | 2;
                                                } else {
                                                    r8 = r22;
                                                }
                                                getScrollingChildHelper().g(r8, i9);
                                                int i111 = -i12;
                                                int iMax5 = Math.max(i111, Math.min(i13, i12));
                                                int iMax6 = Math.max(i111, Math.min(i14, i12));
                                                xVar = this.f8000W;
                                                recyclerView = RecyclerView.this;
                                                recyclerView.setScrollState(2);
                                                xVar.f8122b = 0;
                                                xVar.f8121a = 0;
                                                interpolator = xVar.f8124d;
                                                bVar = F0;
                                                if (interpolator != bVar) {
                                                    xVar.f8124d = bVar;
                                                    xVar.f8123c = new OverScroller(recyclerView.getContext(), bVar);
                                                }
                                                xVar.f8123c.fling(0, 0, iMax5, iMax6, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                                xVar.a();
                                            }
                                        }
                                        W();
                                    }
                                }
                            }
                            i11 = 0;
                        }
                        setScrollState(i11);
                        W();
                    } else if (actionMasked == 2) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(this.f7988J);
                        if (iFindPointerIndex < 0) {
                            Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f7988J + " not found. Did any MotionEvents get skipped?");
                            return false;
                        }
                        int x8 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                        int y8 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                        int iMax7 = this.f7992N - x8;
                        int iMax8 = this.O - y8;
                        if (this.f7987I != 1) {
                            if (zD) {
                                iMax7 = iMax7 > 0 ? Math.max(0, iMax7 - this.f7993P) : Math.min(0, iMax7 + this.f7993P);
                                if (iMax7 != 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                            } else {
                                z11 = false;
                            }
                            if (zE) {
                                iMax8 = iMax8 > 0 ? Math.max(0, iMax8 - this.f7993P) : Math.min(0, iMax8 + this.f7993P);
                                if (iMax8 != 0) {
                                    z11 = true;
                                }
                            }
                            if (z11) {
                                setScrollState(1);
                            }
                        }
                        int i20 = iMax7;
                        int i21 = iMax8;
                        if (this.f7987I == 1) {
                            int[] iArr2 = this.f8039z0;
                            iArr2[0] = 0;
                            iArr2[1] = 0;
                            boolean zR = r(zD ? i20 : 0, zE ? i21 : 0, iArr2, this.f8035x0, 0);
                            int[] iArr3 = this.f8035x0;
                            if (zR) {
                                i20 -= iArr2[0];
                                i21 -= iArr2[1];
                                iArr[0] = iArr[0] + iArr3[0];
                                iArr[1] = iArr[1] + iArr3[1];
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            int i22 = i21;
                            this.f7992N = x8 - iArr3[0];
                            this.O = y8 - iArr3[1];
                            if (X(zD ? i20 : 0, zE ? i22 : 0, motionEvent)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            androidx.recyclerview.widget.m mVar = this.f8012l0;
                            if (mVar != null && (i20 != 0 || i22 != 0)) {
                                mVar.a(this, i20, i22);
                            }
                        }
                    } else if (actionMasked == 3) {
                        W();
                        setScrollState(0);
                    } else if (actionMasked == 5) {
                        this.f7988J = motionEvent.getPointerId(actionIndex);
                        int x9 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                        this.f7992N = x9;
                        this.f7990L = x9;
                        int y9 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                        this.O = y9;
                        this.f7991M = y9;
                    } else if (actionMasked == 6) {
                        R(motionEvent);
                    }
                    motionEventObtain.recycle();
                    return true;
                }
                this.f7988J = motionEvent.getPointerId(0);
                int x10 = (int) (motionEvent.getX() + 0.5f);
                this.f7992N = x10;
                this.f7990L = x10;
                int y10 = (int) (motionEvent.getY() + 0.5f);
                this.O = y10;
                this.f7991M = y10;
                if (zE) {
                    r9 = zD;
                    r9 = (zD ? 1 : 0) | 2;
                }
                r9 = zD;
                getScrollingChildHelper().g(r9, 0);
                this.f7989K.addMovement(motionEventObtain);
                motionEventObtain.recycle();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:253:0x0396  */
    /* JADX WARN: Code duplicated, block: B:344:0x0209 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00be  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e7  */
    public final void p() {
        int iF;
        C.a aVar;
        View viewA;
        boolean z8;
        int i9;
        int i10;
        boolean z9;
        boolean z10;
        byte b9;
        boolean z11;
        boolean z12;
        C0549a.C0110a c0110aG;
        int i11;
        int i12;
        int i13;
        C0549a.C0110a c0110a;
        v vVar = this.f8016n0;
        vVar.a(1);
        z(vVar);
        vVar.f8116i = false;
        b0();
        C c5 = this.f8006f;
        c5.f7919a.clear();
        p155u.d<y> dVar = c5.f7920b;
        dVar.a();
        P();
        if (this.f8036y) {
            C0549a c0549a = this.f8004d;
            c0549a.i(c0549a.f8198b);
            c0549a.i(c0549a.f8199c);
            if (this.f8038z) {
                this.f8011l.X();
            }
        }
        if (this.f7986H == null || !this.f8011l.z0()) {
            this.f8004d.b();
        } else {
            C0549a c0549a2 = this.f8004d;
            ArrayList<C0549a.C0110a> arrayList = c0549a2.f8198b;
            androidx.recyclerview.widget.p pVar = c0549a2.f8201e;
            pVar.getClass();
            while (true) {
                int size = arrayList.size() - 1;
                boolean z13 = false;
                while (true) {
                    i9 = 8;
                    if (size < 0) {
                        size = -1;
                        break;
                    }
                    if (arrayList.get(size).f8202a == 8) {
                        if (z13) {
                            break;
                        }
                    } else {
                        z13 = true;
                    }
                    size--;
                }
                if (size == -1) {
                    break;
                }
                int i14 = size + 1;
                C0549a.C0110a c0110a2 = arrayList.get(size);
                C0549a.C0110a c0110a3 = arrayList.get(i14);
                int i15 = c0110a3.f8202a;
                if (i15 != 1) {
                    C0549a c0549a3 = pVar.f8324a;
                    C0549a.C0110a c0110aG2 = null;
                    if (i15 == 2) {
                        int i16 = c0110a2.f8203b;
                        int i17 = c0110a2.f8204c;
                        if (i16 < i17) {
                            if (c0110a3.f8203b == i16 && c0110a3.f8204c == i17 - i16) {
                                z11 = false;
                                z12 = true;
                            } else {
                                z11 = false;
                                z12 = false;
                            }
                        } else if (c0110a3.f8203b == i17 + 1 && c0110a3.f8204c == i16 - i17) {
                            z11 = true;
                            z12 = true;
                        } else {
                            z11 = true;
                            z12 = false;
                        }
                        int i18 = c0110a3.f8203b;
                        if (i17 < i18) {
                            c0110a3.f8203b = i18 - 1;
                        } else {
                            int i19 = c0110a3.f8204c;
                            if (i17 < i18 + i19) {
                                c0110a3.f8204c = i19 - 1;
                                c0110a2.f8202a = 2;
                                c0110a2.f8204c = 1;
                                if (c0110a3.f8204c == 0) {
                                    arrayList.remove(i14);
                                    c0549a3.f8197a.f(c0110a3);
                                }
                            }
                        }
                        int i20 = c0110a2.f8203b;
                        int i21 = c0110a3.f8203b;
                        if (i20 <= i21) {
                            c0110a3.f8203b = i21 + 1;
                        } else {
                            int i22 = i21 + c0110a3.f8204c;
                            if (i20 < i22) {
                                c0110aG2 = c0549a3.g(2, i20 + 1, i22 - i20);
                                c0110a3.f8204c = c0110a2.f8203b - c0110a3.f8203b;
                            }
                        }
                        C0549a.C0110a c0110a4 = c0110aG2;
                        if (z12) {
                            arrayList.set(size, c0110a3);
                            arrayList.remove(i14);
                            c0549a3.f8197a.f(c0110a2);
                        } else {
                            if (z11) {
                                if (c0110a4 != null) {
                                    int i23 = c0110a2.f8203b;
                                    if (i23 > c0110a4.f8203b) {
                                        c0110a2.f8203b = i23 - c0110a4.f8204c;
                                    }
                                    int i24 = c0110a2.f8204c;
                                    if (i24 > c0110a4.f8203b) {
                                        c0110a2.f8204c = i24 - c0110a4.f8204c;
                                    }
                                }
                                int i25 = c0110a2.f8203b;
                                if (i25 > c0110a3.f8203b) {
                                    c0110a2.f8203b = i25 - c0110a3.f8204c;
                                }
                                int i26 = c0110a2.f8204c;
                                if (i26 > c0110a3.f8203b) {
                                    c0110a2.f8204c = i26 - c0110a3.f8204c;
                                }
                            } else {
                                if (c0110a4 != null) {
                                    int i27 = c0110a2.f8203b;
                                    if (i27 >= c0110a4.f8203b) {
                                        c0110a2.f8203b = i27 - c0110a4.f8204c;
                                    }
                                    int i28 = c0110a2.f8204c;
                                    if (i28 >= c0110a4.f8203b) {
                                        c0110a2.f8204c = i28 - c0110a4.f8204c;
                                    }
                                }
                                int i29 = c0110a2.f8203b;
                                if (i29 >= c0110a3.f8203b) {
                                    c0110a2.f8203b = i29 - c0110a3.f8204c;
                                }
                                int i30 = c0110a2.f8204c;
                                if (i30 >= c0110a3.f8203b) {
                                    c0110a2.f8204c = i30 - c0110a3.f8204c;
                                }
                            }
                            arrayList.set(size, c0110a3);
                            if (c0110a2.f8203b != c0110a2.f8204c) {
                                arrayList.set(i14, c0110a2);
                            } else {
                                arrayList.remove(i14);
                            }
                            if (c0110a4 != null) {
                                arrayList.add(size, c0110a4);
                            }
                        }
                    } else if (i15 == 4) {
                        int i31 = c0110a2.f8204c;
                        int i32 = c0110a3.f8203b;
                        if (i31 < i32) {
                            c0110a3.f8203b = i32 - 1;
                        } else {
                            int i33 = c0110a3.f8204c;
                            if (i31 < i32 + i33) {
                                c0110a3.f8204c = i33 - 1;
                                c0110aG = c0549a3.g(4, c0110a2.f8203b, 1);
                            }
                            i11 = c0110a2.f8203b;
                            i12 = c0110a3.f8203b;
                            if (i11 <= i12) {
                                c0110a3.f8203b = i12 + 1;
                            } else {
                                i13 = i12 + c0110a3.f8204c;
                                if (i11 < i13) {
                                    int i34 = i13 - i11;
                                    c0110aG2 = c0549a3.g(4, i11 + 1, i34);
                                    c0110a3.f8204c -= i34;
                                }
                            }
                            c0110a = c0110aG2;
                            arrayList.set(i14, c0110a2);
                            if (c0110a3.f8204c > 0) {
                                arrayList.set(size, c0110a3);
                            } else {
                                arrayList.remove(size);
                                c0549a3.f8197a.f(c0110a3);
                            }
                            if (c0110aG != null) {
                                arrayList.add(size, c0110aG);
                            }
                            if (c0110a != null) {
                                arrayList.add(size, c0110a);
                            }
                        }
                        c0110aG = null;
                        i11 = c0110a2.f8203b;
                        i12 = c0110a3.f8203b;
                        if (i11 <= i12) {
                            c0110a3.f8203b = i12 + 1;
                        } else {
                            i13 = i12 + c0110a3.f8204c;
                            if (i11 < i13) {
                                int i35 = i13 - i11;
                                c0110aG2 = c0549a3.g(4, i11 + 1, i35);
                                c0110a3.f8204c -= i35;
                            }
                        }
                        c0110a = c0110aG2;
                        arrayList.set(i14, c0110a2);
                        if (c0110a3.f8204c > 0) {
                            arrayList.set(size, c0110a3);
                        } else {
                            arrayList.remove(size);
                            c0549a3.f8197a.f(c0110a3);
                        }
                        if (c0110aG != null) {
                            arrayList.add(size, c0110aG);
                        }
                        if (c0110a != null) {
                            arrayList.add(size, c0110a);
                        }
                    }
                } else {
                    int i36 = c0110a2.f8204c;
                    int i37 = c0110a3.f8203b;
                    int i38 = i36 < i37 ? -1 : 0;
                    int i39 = c0110a2.f8203b;
                    if (i39 < i37) {
                        i38++;
                    }
                    if (i37 <= i39) {
                        c0110a2.f8203b = i39 + c0110a3.f8204c;
                    }
                    int i40 = c0110a3.f8203b;
                    if (i40 <= i36) {
                        c0110a2.f8204c = i36 + c0110a3.f8204c;
                    }
                    c0110a3.f8203b = i40 + i38;
                    arrayList.set(size, c0110a3);
                    arrayList.set(i14, c0110a2);
                }
            }
            int size2 = arrayList.size();
            int i41 = 0;
            while (i41 < size2) {
                C0549a.C0110a c0110aG3 = arrayList.get(i41);
                int i42 = c0110aG3.f8202a;
                if (i42 != 1) {
                    S.c cVar = c0549a2.f8197a;
                    androidx.recyclerview.widget.w wVar = c0549a2.f8200d;
                    if (i42 == 2) {
                        i10 = size2;
                        int i43 = c0110aG3.f8203b;
                        int i44 = c0110aG3.f8204c + i43;
                        int i45 = i43;
                        int i46 = 0;
                        byte b10 = -1;
                        while (i45 < i44) {
                            if (wVar.b(i45) != null || c0549a2.a(i45)) {
                                if (b10 == 0) {
                                    c0549a2.c(c0549a2.g(2, i43, i46));
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                z10 = z9;
                                b9 = 1;
                            } else {
                                if (b10 == 1) {
                                    c0549a2.h(c0549a2.g(2, i43, i46));
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                b9 = 0;
                            }
                            if (z10) {
                                i45 -= i46;
                                i44 -= i46;
                                i46 = 1;
                            } else {
                                i46++;
                            }
                            i45++;
                            b10 = b9;
                        }
                        if (i46 != c0110aG3.f8204c) {
                            cVar.f(c0110aG3);
                            c0110aG3 = c0549a2.g(2, i43, i46);
                        }
                        if (b10 == 0) {
                            c0549a2.c(c0110aG3);
                        } else {
                            c0549a2.h(c0110aG3);
                        }
                    } else if (i42 != 4) {
                        if (i42 == i9) {
                            c0549a2.h(c0110aG3);
                        }
                        i10 = size2;
                    } else {
                        int i47 = c0110aG3.f8203b;
                        int i48 = c0110aG3.f8204c + i47;
                        int i49 = i47;
                        byte b11 = -1;
                        int i50 = 0;
                        while (i47 < i48) {
                            if (wVar.b(i47) != null || c0549a2.a(i47)) {
                                if (b11 == 0) {
                                    c0549a2.c(c0549a2.g(4, i49, i50));
                                    i49 = i47;
                                    i50 = 0;
                                }
                                b11 = 1;
                            } else {
                                if (b11 == 1) {
                                    c0549a2.h(c0549a2.g(4, i49, i50));
                                    i49 = i47;
                                    i50 = 0;
                                }
                                b11 = 0;
                            }
                            i50++;
                            i47++;
                            size2 = size2;
                        }
                        i10 = size2;
                        if (i50 != c0110aG3.f8204c) {
                            cVar.f(c0110aG3);
                            c0110aG3 = c0549a2.g(4, i49, i50);
                        }
                        if (b11 == 0) {
                            c0549a2.c(c0110aG3);
                        } else {
                            c0549a2.h(c0110aG3);
                        }
                    }
                } else {
                    i10 = size2;
                    c0549a2.h(c0110aG3);
                }
                i41++;
                size2 = i10;
                i9 = 8;
            }
            arrayList.clear();
        }
        boolean z14 = this.f8022q0 || this.f8024r0;
        boolean z15 = this.f8023r && this.f7986H != null && ((z8 = this.f8036y) || z14 || this.f8011l.f8059f) && (!z8 || this.f8010k.f8044b);
        v vVar2 = this.f8016n0;
        vVar2.j = z15;
        vVar2.f8117k = z15 && z14 && !this.f8036y && this.f7986H != null && this.f8011l.z0();
        y yVarH = null;
        View focusedChild = (this.f7999V && hasFocus() && this.f8010k != null) ? getFocusedChild() : null;
        if (focusedChild != null && (viewA = A(focusedChild)) != null) {
            yVarH = H(viewA);
        }
        if (yVarH == null) {
            vVar.f8119m = -1L;
            vVar.f8118l = -1;
            vVar.f8120n = -1;
        } else {
            vVar.f8119m = this.f8010k.f8044b ? yVarH.f8133e : -1L;
            if (this.f8036y) {
                iF = -1;
            } else if (yVarH.h()) {
                iF = yVarH.f8132d;
            } else {
                RecyclerView recyclerView = yVarH.f8145r;
                if (recyclerView == null) {
                    iF = -1;
                } else {
                    iF = recyclerView.F(yVarH);
                }
            }
            vVar.f8118l = iF;
            View focusedChild2 = yVarH.f8129a;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            vVar.f8120n = id;
        }
        vVar.f8115h = vVar.j && this.f8024r0;
        this.f8024r0 = false;
        this.f8022q0 = false;
        vVar.f8114g = vVar.f8117k;
        vVar.f8112e = this.f8010k.a();
        C(this.f8031v0);
        boolean z16 = vVar.j;
        p155u.g<y, C.a> gVar = c5.f7919a;
        if (z16) {
            int iE = this.f8005e.e();
            for (int i51 = 0; i51 < iE; i51++) {
                y yVarI = I(this.f8005e.d(i51));
                if (!yVarI.o() && (!yVarI.f() || this.f8010k.f8044b)) {
                    i iVar = this.f7986H;
                    i.b(yVarI);
                    yVarI.c();
                    iVar.getClass();
                    i.b bVar = new i.b();
                    bVar.a(yVarI);
                    C.a aVarA = gVar.get(yVarI);
                    if (aVarA == null) {
                        aVarA = C.a.a();
                        gVar.put(yVarI, aVarA);
                    }
                    aVarA.f7923b = bVar;
                    aVarA.f7922a |= 4;
                    if (vVar.f8115h && yVarI.k() && !yVarI.h() && !yVarI.o() && !yVarI.f()) {
                        dVar.d(G(yVarI), yVarI);
                    }
                }
            }
        }
        if (vVar.f8117k) {
            int iH = this.f8005e.h();
            for (int i52 = 0; i52 < iH; i52++) {
                y yVarI2 = I(this.f8005e.g(i52));
                if (!yVarI2.o() && yVarI2.f8132d == -1) {
                    yVarI2.f8132d = yVarI2.f8131c;
                }
            }
            boolean z17 = vVar.f8113f;
            vVar.f8113f = false;
            this.f8011l.b0(this.f8002b, vVar);
            vVar.f8113f = z17;
            for (int i53 = 0; i53 < this.f8005e.e(); i53++) {
                y yVarI3 = I(this.f8005e.d(i53));
                if (!yVarI3.o() && ((aVar = gVar.get(yVarI3)) == null || (aVar.f7922a & 4) == 0)) {
                    i.b(yVarI3);
                    boolean z18 = (yVarI3.j & 8192) != 0;
                    i iVar2 = this.f7986H;
                    yVarI3.c();
                    iVar2.getClass();
                    i.b bVar2 = new i.b();
                    bVar2.a(yVarI3);
                    if (z18) {
                        U(yVarI3, bVar2);
                    } else {
                        C.a aVarA2 = gVar.get(yVarI3);
                        if (aVarA2 == null) {
                            aVarA2 = C.a.a();
                            gVar.put(yVarI3, aVarA2);
                        }
                        aVarA2.f7922a |= 2;
                        aVarA2.f7923b = bVar2;
                    }
                }
            }
            k();
        } else {
            k();
        }
        Q(true);
        c0(false);
        vVar.f8111d = 2;
    }

    public final void q() {
        b0();
        P();
        v vVar = this.f8016n0;
        vVar.a(6);
        this.f8004d.b();
        vVar.f8112e = this.f8010k.a();
        vVar.f8110c = 0;
        vVar.f8114g = false;
        this.f8011l.b0(this.f8002b, vVar);
        vVar.f8113f = false;
        this.f8003c = null;
        vVar.j = vVar.j && this.f7986H != null;
        vVar.f8111d = 4;
        Q(true);
        c0(false);
    }

    public final boolean r(int i9, int i10, int[] iArr, int[] iArr2, int i11) {
        return getScrollingChildHelper().c(i9, i10, iArr, iArr2, i11);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z8) {
        y yVarI = I(view);
        if (yVarI != null) {
            if (yVarI.j()) {
                yVarI.j &= -257;
            } else if (!yVarI.o()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + yVarI + y());
            }
        }
        view.clearAnimation();
        I(view);
        super.removeDetachedView(view, z8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        androidx.recyclerview.widget.o oVar = this.f8011l.f8058e;
        if ((oVar == null || !oVar.f8097e) && !L() && view2 != null) {
            V(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z8) {
        return this.f8011l.k0(this, view, rect, z8, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z8) {
        ArrayList<o> arrayList = this.f8015n;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.get(i9).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z8);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f8025s != 0 || this.f8028u) {
            this.t = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s(int i9, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        getScrollingChildHelper().d(i9, i10, i11, i12, iArr, i13, iArr2);
    }

    @Override // android.view.View
    public final void scrollBy(int i9, int i10) {
        l lVar = this.f8011l;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f8028u) {
            return;
        }
        boolean zD = lVar.d();
        boolean zE = this.f8011l.e();
        if (zD || zE) {
            if (!zD) {
                i9 = 0;
            }
            if (!zE) {
                i10 = 0;
            }
            X(i9, i10, null);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i9, int i10) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!L()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.f8032w |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.x xVar) {
        this.f8029u0 = xVar;
        G.m(this, xVar);
    }

    public void setAdapter(d dVar) {
        setLayoutFrozen(false);
        d dVar2 = this.f8010k;
        t tVar = this.f8001a;
        if (dVar2 != null) {
            dVar2.f8043a.unregisterObserver(tVar);
            this.f8010k.getClass();
        }
        i iVar = this.f7986H;
        if (iVar != null) {
            iVar.e();
        }
        l lVar = this.f8011l;
        r rVar = this.f8002b;
        if (lVar != null) {
            lVar.g0(rVar);
            this.f8011l.h0(rVar);
        }
        rVar.f8084a.clear();
        rVar.d();
        C0549a c0549a = this.f8004d;
        c0549a.i(c0549a.f8198b);
        c0549a.i(c0549a.f8199c);
        d dVar3 = this.f8010k;
        this.f8010k = dVar;
        if (dVar != null) {
            dVar.f8043a.registerObserver(tVar);
        }
        d dVar4 = this.f8010k;
        rVar.f8084a.clear();
        rVar.d();
        q qVarC = rVar.c();
        if (dVar3 != null) {
            qVarC.f8079b--;
        }
        if (qVarC.f8079b == 0) {
            int i9 = 0;
            while (true) {
                SparseArray<q.a> sparseArray = qVarC.f8078a;
                if (i9 >= sparseArray.size()) {
                    break;
                }
                sparseArray.valueAt(i9).f8080a.clear();
                i9++;
            }
        }
        if (dVar4 != null) {
            qVarC.f8079b++;
        }
        this.f8016n0.f8113f = true;
        T(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(g gVar) {
        if (gVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z8) {
        if (z8 != this.f8007g) {
            this.f7985G = null;
            this.f7983E = null;
            this.f7984F = null;
            this.f7982D = null;
        }
        this.f8007g = z8;
        super.setClipToPadding(z8);
        if (this.f8023r) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(h hVar) {
        hVar.getClass();
        this.f7980C = hVar;
        this.f7985G = null;
        this.f7983E = null;
        this.f7984F = null;
        this.f7982D = null;
    }

    public void setHasFixedSize(boolean z8) {
        this.f8021q = z8;
    }

    public void setItemAnimator(i iVar) {
        i iVar2 = this.f7986H;
        if (iVar2 != null) {
            iVar2.e();
            this.f7986H.f8045a = null;
        }
        this.f7986H = iVar;
        if (iVar != null) {
            iVar.f8045a = this.f8026s0;
        }
    }

    public void setItemViewCacheSize(int i9) {
        r rVar = this.f8002b;
        rVar.f8088e = i9;
        rVar.k();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z8) {
        suppressLayout(z8);
    }

    public void setLayoutManager(l lVar) {
        RecyclerView recyclerView;
        androidx.recyclerview.widget.o oVar;
        if (lVar == this.f8011l) {
            return;
        }
        setScrollState(0);
        x xVar = this.f8000W;
        RecyclerView.this.removeCallbacks(xVar);
        xVar.f8123c.abortAnimation();
        l lVar2 = this.f8011l;
        if (lVar2 != null && (oVar = lVar2.f8058e) != null) {
            oVar.d();
        }
        l lVar3 = this.f8011l;
        r rVar = this.f8002b;
        if (lVar3 != null) {
            i iVar = this.f7986H;
            if (iVar != null) {
                iVar.e();
            }
            this.f8011l.g0(rVar);
            this.f8011l.h0(rVar);
            rVar.f8084a.clear();
            rVar.d();
            if (this.f8019p) {
                l lVar4 = this.f8011l;
                lVar4.f8060g = false;
                lVar4.R(this);
            }
            this.f8011l.t0(null);
            this.f8011l = null;
        } else {
            rVar.f8084a.clear();
            rVar.d();
        }
        C0550b c0550b = this.f8005e;
        c0550b.f8206b.g();
        ArrayList arrayList = c0550b.f8207c;
        int size = arrayList.size() - 1;
        while (true) {
            recyclerView = c0550b.f8205a.f8331a;
            if (size < 0) {
                break;
            }
            y yVarI = I((View) arrayList.get(size));
            if (yVarI != null) {
                int i9 = yVarI.f8143p;
                if (recyclerView.L()) {
                    yVarI.f8144q = i9;
                    recyclerView.f7977A0.add(yVarI);
                } else {
                    WeakHashMap<View, L> weakHashMap = G.f4313a;
                    yVarI.f8129a.setImportantForAccessibility(i9);
                }
                yVarI.f8143p = 0;
            }
            arrayList.remove(size);
            size--;
        }
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            I(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f8011l = lVar;
        if (lVar != null) {
            if (lVar.f8055b != null) {
                throw new IllegalArgumentException("LayoutManager " + lVar + " is already attached to a RecyclerView:" + lVar.f8055b.y());
            }
            lVar.t0(this);
            if (this.f8019p) {
                l lVar5 = this.f8011l;
                lVar5.f8060g = true;
                lVar5.Q(this);
            }
        }
        rVar.k();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z8) {
        C0428o scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f4448d) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            scrollingChildHelper.f4447c.stopNestedScroll();
        }
        scrollingChildHelper.f4448d = z8;
    }

    public void setOnFlingListener(n nVar) {
        this.f7994Q = nVar;
    }

    @Deprecated
    public void setOnScrollListener(p pVar) {
        this.f8018o0 = pVar;
    }

    public void setPreserveFocusAfterLayout(boolean z8) {
        this.f7999V = z8;
    }

    public void setRecycledViewPool(q qVar) {
        r rVar = this.f8002b;
        q qVar2 = rVar.f8090g;
        if (qVar2 != null) {
            qVar2.f8079b--;
        }
        rVar.f8090g = qVar;
        if (qVar == null || RecyclerView.this.getAdapter() == null) {
            return;
        }
        rVar.f8090g.f8079b++;
    }

    public void setScrollState(int i9) {
        androidx.recyclerview.widget.o oVar;
        if (i9 == this.f7987I) {
            return;
        }
        this.f7987I = i9;
        if (i9 != 2) {
            x xVar = this.f8000W;
            RecyclerView.this.removeCallbacks(xVar);
            xVar.f8123c.abortAnimation();
            l lVar = this.f8011l;
            if (lVar != null && (oVar = lVar.f8058e) != null) {
                oVar.d();
            }
        }
        l lVar2 = this.f8011l;
        if (lVar2 != null) {
            lVar2.f0(i9);
        }
        p pVar = this.f8018o0;
        if (pVar != null) {
            pVar.a(this, i9);
        }
        ArrayList arrayList = this.f8020p0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((p) this.f8020p0.get(size)).a(this, i9);
            }
        }
    }

    public void setScrollingTouchSlop(int i9) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i9 != 0) {
            if (i9 == 1) {
                this.f7993P = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i9 + "; using default value");
        }
        this.f7993P = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(w wVar) {
        this.f8002b.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i9) {
        return getScrollingChildHelper().g(i9, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z8) {
        androidx.recyclerview.widget.o oVar;
        if (z8 != this.f8028u) {
            i("Do not suppressLayout in layout or scroll");
            if (!z8) {
                this.f8028u = false;
                if (this.t && this.f8011l != null && this.f8010k != null) {
                    requestLayout();
                }
                this.t = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f8028u = true;
            this.f8030v = true;
            setScrollState(0);
            x xVar = this.f8000W;
            RecyclerView.this.removeCallbacks(xVar);
            xVar.f8123c.abortAnimation();
            l lVar = this.f8011l;
            if (lVar == null || (oVar = lVar.f8058e) == null) {
                return;
            }
            oVar.d();
        }
    }

    public final void t(int i9, int i10) {
        this.f7978B++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i9, scrollY - i10);
        p pVar = this.f8018o0;
        if (pVar != null) {
            pVar.b(this, i9, i10);
        }
        ArrayList arrayList = this.f8020p0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((p) this.f8020p0.get(size)).b(this, i9, i10);
            }
        }
        this.f7978B--;
    }

    public final void u() {
        if (this.f7985G != null) {
            return;
        }
        this.f7980C.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f7985G = edgeEffect;
        if (this.f8007g) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void v() {
        if (this.f7982D != null) {
            return;
        }
        this.f7980C.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f7982D = edgeEffect;
        if (this.f8007g) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void w() {
        if (this.f7984F != null) {
            return;
        }
        this.f7980C.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f7984F = edgeEffect;
        if (this.f8007g) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void x() {
        if (this.f7983E != null) {
            return;
        }
        this.f7980C.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f7983E = edgeEffect;
        if (this.f8007g) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String y() {
        return " " + super.toString() + ", adapter:" + this.f8010k + ", layout:" + this.f8011l + ", context:" + getContext();
    }

    public final void z(v vVar) {
        if (getScrollState() != 2) {
            vVar.getClass();
            return;
        }
        OverScroller overScroller = this.f8000W.f8123c;
        overScroller.getFinalX();
        overScroller.getCurrX();
        vVar.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i9) {
        int i10;
        Constructor constructor;
        Object[] objArr;
        super(context, attributeSet, i9);
        this.f8001a = new t();
        this.f8002b = new r();
        this.f8006f = new C();
        this.f8008h = new Rect();
        this.f8009i = new Rect();
        this.j = new RectF();
        this.f8013m = new ArrayList<>();
        this.f8015n = new ArrayList<>();
        this.f8025s = 0;
        this.f8036y = false;
        this.f8038z = false;
        this.f7976A = 0;
        this.f7978B = 0;
        this.f7980C = new h();
        androidx.recyclerview.widget.k kVar = new androidx.recyclerview.widget.k();
        kVar.f8045a = null;
        kVar.f8046b = new ArrayList<>();
        kVar.f8047c = 120L;
        kVar.f8048d = 120L;
        kVar.f8049e = 250L;
        kVar.f8050f = 250L;
        kVar.f8337g = true;
        kVar.f8239h = new ArrayList<>();
        kVar.f8240i = new ArrayList<>();
        kVar.j = new ArrayList<>();
        kVar.f8241k = new ArrayList<>();
        kVar.f8242l = new ArrayList<>();
        kVar.f8243m = new ArrayList<>();
        kVar.f8244n = new ArrayList<>();
        kVar.f8245o = new ArrayList<>();
        kVar.f8246p = new ArrayList<>();
        kVar.f8247q = new ArrayList<>();
        kVar.f8248r = new ArrayList<>();
        this.f7986H = kVar;
        this.f7987I = 0;
        this.f7988J = -1;
        this.f7997T = Float.MIN_VALUE;
        this.f7998U = Float.MIN_VALUE;
        this.f7999V = true;
        this.f8000W = new x();
        this.f8014m0 = new androidx.recyclerview.widget.m.b();
        v vVar = new v();
        vVar.f8108a = -1;
        vVar.f8109b = 0;
        vVar.f8110c = 0;
        vVar.f8111d = 1;
        vVar.f8112e = 0;
        vVar.f8113f = false;
        vVar.f8114g = false;
        vVar.f8115h = false;
        vVar.f8116i = false;
        vVar.j = false;
        vVar.f8117k = false;
        this.f8016n0 = vVar;
        this.f8022q0 = false;
        this.f8024r0 = false;
        j jVar = new j();
        this.f8026s0 = jVar;
        this.f8027t0 = false;
        this.f8031v0 = new int[2];
        this.f8035x0 = new int[2];
        this.f8037y0 = new int[2];
        this.f8039z0 = new int[2];
        this.f7977A0 = new ArrayList();
        this.f7979B0 = new a();
        this.f7981C0 = new c();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7993P = viewConfiguration.getScaledTouchSlop();
        this.f7997T = viewConfiguration.getScaledHorizontalScrollFactor();
        this.f7998U = viewConfiguration.getScaledVerticalScrollFactor();
        this.f7995R = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7996S = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f7986H.f8045a = jVar;
        this.f8004d = new C0549a(new androidx.recyclerview.widget.w(this));
        this.f8005e = new C0550b(new androidx.recyclerview.widget.v(this));
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (G.g.a(this) == 0) {
            G.g.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.f8034x = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.x(this));
        int[] iArr = p123q0.a.f20876a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i9, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i9, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION);
        }
        this.f8007g = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + y());
            }
            Resources resources = getContext().getResources();
            i10 = 4;
            new androidx.recyclerview.widget.l(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(cn.ikaile.ruoshui.client.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(cn.ikaile.ruoshui.client.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(cn.ikaile.ruoshui.client.R.dimen.fastscroll_margin));
        } else {
            i10 = 4;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(l.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(f7975E0);
                        objArr = new Object[i10];
                        objArr[0] = context;
                        objArr[1] = attributeSet;
                        objArr[2] = Integer.valueOf(i9);
                        objArr[3] = 0;
                    } catch (NoSuchMethodException e9) {
                        try {
                            constructor = clsAsSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e10) {
                            e10.initCause(e9);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e10);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((l) constructor.newInstance(objArr));
                } catch (ClassCastException e11) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e11);
                } catch (ClassNotFoundException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e12);
                } catch (IllegalAccessException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e13);
                } catch (InstantiationException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e14);
                } catch (InvocationTargetException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e15);
                }
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        int[] iArr2 = f7974D0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i9, 0);
        if (i11 >= 29) {
            saveAttributeDataForStyleable(context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i9, 0);
        }
        boolean z8 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z8);
    }

    public static class m extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y f8074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f8075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8077d;

        public m(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8075b = new Rect();
            this.f8076c = true;
            this.f8077d = false;
        }

        public m(int i9, int i10) {
            super(i9, i10);
            this.f8075b = new Rect();
            this.f8076c = true;
            this.f8077d = false;
        }

        public m(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8075b = new Rect();
            this.f8076c = true;
            this.f8077d = false;
        }

        public m(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8075b = new Rect();
            this.f8076c = true;
            this.f8077d = false;
        }

        public m(m mVar) {
            super((ViewGroup.LayoutParams) mVar);
            this.f8075b = new Rect();
            this.f8076c = true;
            this.f8077d = false;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        l lVar = this.f8011l;
        if (lVar != null) {
            return lVar.t(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + y());
    }

    public static abstract class f {
        public void a() {
        }
    }

    public static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0550b f8054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f8055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final B f8056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final B f8057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.recyclerview.widget.o f8058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8059f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f8060g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f8061h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f8062i;
        public int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f8063k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f8064l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f8065m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f8066n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f8067o;

        public class a implements B.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.B.b
            public final int a() {
                l lVar = l.this;
                return lVar.f8066n - lVar.F();
            }

            @Override // androidx.recyclerview.widget.B.b
            public final int b(View view) {
                return (view.getLeft() - ((m) view.getLayoutParams()).f8075b.left) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.B.b
            public final View c(int i9) {
                return l.this.u(i9);
            }

            @Override // androidx.recyclerview.widget.B.b
            public final int d() {
                return l.this.E();
            }

            @Override // androidx.recyclerview.widget.B.b
            public final int e(View view) {
                return view.getRight() + ((m) view.getLayoutParams()).f8075b.right + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).rightMargin;
            }
        }

        public class b implements B.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.B.b
            public final int a() {
                l lVar = l.this;
                return lVar.f8067o - lVar.D();
            }

            @Override // androidx.recyclerview.widget.B.b
            public final int b(View view) {
                return (view.getTop() - ((m) view.getLayoutParams()).f8075b.top) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.B.b
            public final View c(int i9) {
                return l.this.u(i9);
            }

            @Override // androidx.recyclerview.widget.B.b
            public final int d() {
                return l.this.G();
            }

            @Override // androidx.recyclerview.widget.B.b
            public final int e(View view) {
                return view.getBottom() + ((m) view.getLayoutParams()).f8075b.bottom + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).bottomMargin;
            }
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8070a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8071b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f8072c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f8073d;
        }

        public l() {
            a aVar = new a();
            b bVar = new b();
            this.f8056c = new B(aVar);
            this.f8057d = new B(bVar);
            this.f8059f = false;
            this.f8060g = false;
            this.f8061h = true;
            this.f8062i = true;
        }

        public static int A(View view) {
            Rect rect = ((m) view.getLayoutParams()).f8075b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public static int H(View view) {
            return ((m) view.getLayoutParams()).f8074a.b();
        }

        public static c I(Context context, AttributeSet attributeSet, int i9, int i10) {
            c cVar = new c();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p123q0.a.f20876a, i9, i10);
            cVar.f8070a = typedArrayObtainStyledAttributes.getInt(0, 1);
            cVar.f8071b = typedArrayObtainStyledAttributes.getInt(10, 1);
            cVar.f8072c = typedArrayObtainStyledAttributes.getBoolean(9, false);
            cVar.f8073d = typedArrayObtainStyledAttributes.getBoolean(11, false);
            typedArrayObtainStyledAttributes.recycle();
            return cVar;
        }

        public static boolean M(int i9, int i10, int i11) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            if (i11 > 0 && i9 != i11) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i9;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i9;
            }
            return true;
        }

        public static void N(View view, int i9, int i10, int i11, int i12) {
            m mVar = (m) view.getLayoutParams();
            Rect rect = mVar.f8075b;
            view.layout(i9 + rect.left + ((ViewGroup.MarginLayoutParams) mVar).leftMargin, i10 + rect.top + ((ViewGroup.MarginLayoutParams) mVar).topMargin, (i11 - rect.right) - ((ViewGroup.MarginLayoutParams) mVar).rightMargin, (i12 - rect.bottom) - ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        }

        public static int g(int i9, int i10, int i11) {
            int mode = View.MeasureSpec.getMode(i9);
            int size = View.MeasureSpec.getSize(i9);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i10, i11) : size;
            }
            return Math.min(size, Math.max(i10, i11));
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001a  */
        /* JADX WARN: Code duplicated, block: B:14:0x0022  */
        /* JADX WARN: Code duplicated, block: B:5:0x0010  */
        public static int w(int i9, int i10, int i11, int i12, boolean z8) {
            int iMax = Math.max(0, i9 - i11);
            if (z8) {
                if (i12 >= 0) {
                    i10 = 1073741824;
                } else if (i12 != -1 || (i10 != Integer.MIN_VALUE && (i10 == 0 || i10 != 1073741824))) {
                    i10 = 0;
                    i12 = 0;
                } else {
                    i12 = iMax;
                }
            } else if (i12 >= 0) {
                i10 = 1073741824;
            } else if (i12 == -1) {
                i12 = iMax;
            } else if (i12 != -2) {
                i10 = 0;
                i12 = 0;
            } else if (i10 == Integer.MIN_VALUE || i10 == 1073741824) {
                i12 = iMax;
                i10 = Integer.MIN_VALUE;
            } else {
                i12 = iMax;
                i10 = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(i12, i10);
        }

        public static int z(View view) {
            Rect rect = ((m) view.getLayoutParams()).f8075b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public final int B() {
            RecyclerView recyclerView = this.f8055b;
            d adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.a();
            }
            return 0;
        }

        public final int C() {
            RecyclerView recyclerView = this.f8055b;
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            return recyclerView.getLayoutDirection();
        }

        public final int D() {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public final int E() {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public final int F() {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public final int G() {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int J(r rVar, v vVar) {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView == null || recyclerView.f8010k == null || !e()) {
                return 1;
            }
            return this.f8055b.f8010k.a();
        }

        public final void K(View view, Rect rect) {
            Matrix matrix;
            Rect rect2 = ((m) view.getLayoutParams()).f8075b;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            if (this.f8055b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f8055b.j;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean L() {
            return false;
        }

        public void O(int i9) {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView != null) {
                int iE = recyclerView.f8005e.e();
                for (int i10 = 0; i10 < iE; i10++) {
                    recyclerView.f8005e.d(i10).offsetLeftAndRight(i9);
                }
            }
        }

        public void P(int i9) {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView != null) {
                int iE = recyclerView.f8005e.e();
                for (int i10 = 0; i10 < iE; i10++) {
                    recyclerView.f8005e.d(i10).offsetTopAndBottom(i9);
                }
            }
        }

        public View S(View view, int i9, r rVar, v vVar) {
            return null;
        }

        public void T(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f8055b;
            r rVar = recyclerView.f8002b;
            v vVar = recyclerView.f8016n0;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z8 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f8055b.canScrollVertically(-1) && !this.f8055b.canScrollHorizontally(-1) && !this.f8055b.canScrollHorizontally(1)) {
                z8 = false;
            }
            accessibilityEvent.setScrollable(z8);
            d dVar = this.f8055b.f8010k;
            if (dVar != null) {
                accessibilityEvent.setItemCount(dVar.a());
            }
        }

        public final void U(View view, U.f fVar) {
            y yVarI = RecyclerView.I(view);
            if (yVarI == null || yVarI.h() || this.f8054a.f8207c.contains(yVarI.f8129a)) {
                return;
            }
            RecyclerView recyclerView = this.f8055b;
            V(recyclerView.f8002b, recyclerView.f8016n0, view, fVar);
        }

        public void V(r rVar, v vVar, View view, U.f fVar) {
            fVar.h(U.f.g.a(e() ? H(view) : 0, 1, d() ? H(view) : 0, 1, false));
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0063  */
        public final void b(View view, int i9, boolean z8) {
            int iB;
            y yVarI = RecyclerView.I(view);
            if (z8 || yVarI.h()) {
                p155u.g<y, C.a> gVar = this.f8055b.f8006f.f7919a;
                C.a aVarA = gVar.get(yVarI);
                if (aVarA == null) {
                    aVarA = C.a.a();
                    gVar.put(yVarI, aVarA);
                }
                aVarA.f7922a |= 1;
            } else {
                this.f8055b.f8006f.c(yVarI);
            }
            m mVar = (m) view.getLayoutParams();
            if (yVarI.p() || yVarI.i()) {
                if (yVarI.i()) {
                    yVarI.f8141n.j(yVarI);
                } else {
                    yVarI.j &= -33;
                }
                this.f8054a.b(view, i9, view.getLayoutParams(), false);
            } else {
                if (view.getParent() == this.f8055b) {
                    C0550b c0550b = this.f8054a;
                    int iIndexOfChild = c0550b.f8205a.f8331a.indexOfChild(view);
                    if (iIndexOfChild == -1) {
                        iB = -1;
                    } else {
                        C0550b.a aVar = c0550b.f8206b;
                        if (aVar.d(iIndexOfChild)) {
                            iB = -1;
                        } else {
                            iB = iIndexOfChild - aVar.b(iIndexOfChild);
                        }
                    }
                    if (i9 == -1) {
                        i9 = this.f8054a.e();
                    }
                    if (iB == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f8055b.indexOfChild(view) + this.f8055b.y());
                    }
                    if (iB != i9) {
                        l lVar = this.f8055b.f8011l;
                        View viewU = lVar.u(iB);
                        if (viewU == null) {
                            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iB + lVar.f8055b.toString());
                        }
                        lVar.u(iB);
                        lVar.f8054a.c(iB);
                        m mVar2 = (m) viewU.getLayoutParams();
                        y yVarI2 = RecyclerView.I(viewU);
                        if (yVarI2.h()) {
                            p155u.g<y, C.a> gVar2 = lVar.f8055b.f8006f.f7919a;
                            C.a aVarA2 = gVar2.get(yVarI2);
                            if (aVarA2 == null) {
                                aVarA2 = C.a.a();
                                gVar2.put(yVarI2, aVarA2);
                            }
                            aVarA2.f7922a = 1 | aVarA2.f7922a;
                        } else {
                            lVar.f8055b.f8006f.c(yVarI2);
                        }
                        lVar.f8054a.b(viewU, i9, mVar2, yVarI2.h());
                    }
                } else {
                    this.f8054a.a(view, i9, false);
                    mVar.f8076c = true;
                    androidx.recyclerview.widget.o oVar = this.f8058e;
                    if (oVar != null && oVar.f8097e) {
                        oVar.f8094b.getClass();
                        y yVarI3 = RecyclerView.I(view);
                        if ((yVarI3 != null ? yVarI3.b() : -1) == oVar.f8093a) {
                            oVar.f8098f = view;
                        }
                    }
                }
            }
            if (mVar.f8077d) {
                yVarI.f8129a.invalidate();
                mVar.f8077d = false;
            }
        }

        public void b0(r rVar, v vVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void c(String str) {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView != null) {
                recyclerView.i(str);
            }
        }

        public boolean d() {
            return false;
        }

        public boolean e() {
            return false;
        }

        public Parcelable e0() {
            return null;
        }

        public boolean f(m mVar) {
            return mVar != null;
        }

        public final void g0(r rVar) {
            for (int iV = v() - 1; iV >= 0; iV--) {
                if (!RecyclerView.I(u(iV)).o()) {
                    View viewU = u(iV);
                    j0(iV);
                    rVar.f(viewU);
                }
            }
        }

        public final void h0(r rVar) {
            ArrayList<y> arrayList;
            int size = rVar.f8084a.size();
            int i9 = size - 1;
            while (true) {
                arrayList = rVar.f8084a;
                if (i9 < 0) {
                    break;
                }
                View view = arrayList.get(i9).f8129a;
                y yVarI = RecyclerView.I(view);
                if (!yVarI.o()) {
                    yVarI.n(false);
                    if (yVarI.j()) {
                        this.f8055b.removeDetachedView(view, false);
                    }
                    i iVar = this.f8055b.f7986H;
                    if (iVar != null) {
                        iVar.d(yVarI);
                    }
                    yVarI.n(true);
                    y yVarI2 = RecyclerView.I(view);
                    yVarI2.f8141n = null;
                    yVarI2.f8142o = false;
                    yVarI2.j &= -33;
                    rVar.g(yVarI2);
                }
                i9--;
            }
            arrayList.clear();
            ArrayList<y> arrayList2 = rVar.f8085b;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (size > 0) {
                this.f8055b.invalidate();
            }
        }

        public final void i0(View view, r rVar) {
            C0550b c0550b = this.f8054a;
            androidx.recyclerview.widget.v vVar = c0550b.f8205a;
            int iIndexOfChild = vVar.f8331a.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (c0550b.f8206b.f(iIndexOfChild)) {
                    c0550b.j(view);
                }
                vVar.a(iIndexOfChild);
            }
            rVar.f(view);
        }

        public int j(v vVar) {
            return 0;
        }

        public final void j0(int i9) {
            if (u(i9) != null) {
                C0550b c0550b = this.f8054a;
                int iF = c0550b.f(i9);
                androidx.recyclerview.widget.v vVar = c0550b.f8205a;
                View childAt = vVar.f8331a.getChildAt(iF);
                if (childAt == null) {
                    return;
                }
                if (c0550b.f8206b.f(iF)) {
                    c0550b.j(childAt);
                }
                vVar.a(iF);
            }
        }

        public int k(v vVar) {
            return 0;
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:33:0x00b6  */
        /* JADX WARN: Code duplicated, block: B:35:0x00ba  */
        public boolean k0(RecyclerView recyclerView, View view, Rect rect, boolean z8, boolean z9) {
            int iE = E();
            int iG = G();
            int iF = this.f8066n - F();
            int iD = this.f8067o - D();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i9 = left - iE;
            int iMin = Math.min(0, i9);
            int i10 = top - iG;
            int iMin2 = Math.min(0, i10);
            int i11 = iWidth - iF;
            int iMax = Math.max(0, i11);
            int iMax2 = Math.max(0, iHeight - iD);
            if (C() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i9, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i11);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i10, iMax2);
            }
            int[] iArr = {iMax, iMin2};
            int i12 = iArr[0];
            int i13 = iArr[1];
            if (z9) {
                View focusedChild = recyclerView.getFocusedChild();
                if (focusedChild != null) {
                    int iE2 = E();
                    int iG2 = G();
                    int iF2 = this.f8066n - F();
                    int iD2 = this.f8067o - D();
                    Rect rect2 = this.f8055b.f8008h;
                    y(focusedChild, rect2);
                    if (rect2.left - i12 < iF2 && rect2.right - i12 > iE2 && rect2.top - i13 < iD2 && rect2.bottom - i13 > iG2) {
                        if (i12 == 0) {
                        }
                        if (z8) {
                            recyclerView.scrollBy(i12, i13);
                            return true;
                        }
                        recyclerView.a0(i12, i13, false);
                        return true;
                    }
                }
            } else if (i12 == 0 || i13 != 0) {
                if (z8) {
                    recyclerView.scrollBy(i12, i13);
                    return true;
                }
                recyclerView.a0(i12, i13, false);
                return true;
            }
            return false;
        }

        public int l(v vVar) {
            return 0;
        }

        public final void l0() {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int m(v vVar) {
            return 0;
        }

        public int m0(int i9, r rVar, v vVar) {
            return 0;
        }

        public int n(v vVar) {
            return 0;
        }

        public int o(v vVar) {
            return 0;
        }

        public int o0(int i9, r rVar, v vVar) {
            return 0;
        }

        public final void p(r rVar) {
            for (int iV = v() - 1; iV >= 0; iV--) {
                View viewU = u(iV);
                y yVarI = RecyclerView.I(viewU);
                if (!yVarI.o()) {
                    if (!yVarI.f() || yVarI.h() || this.f8055b.f8010k.f8044b) {
                        u(iV);
                        this.f8054a.c(iV);
                        rVar.h(viewU);
                        this.f8055b.f8006f.c(yVarI);
                    } else {
                        j0(iV);
                        rVar.g(yVarI);
                    }
                }
            }
        }

        public final void p0(RecyclerView recyclerView) {
            q0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public View q(int i9) {
            int iV = v();
            for (int i10 = 0; i10 < iV; i10++) {
                View viewU = u(i10);
                y yVarI = RecyclerView.I(viewU);
                if (yVarI != null && yVarI.b() == i9 && !yVarI.o() && (this.f8055b.f8016n0.f8114g || !yVarI.h())) {
                    return viewU;
                }
            }
            return null;
        }

        public final void q0(int i9, int i10) {
            this.f8066n = View.MeasureSpec.getSize(i9);
            int mode = View.MeasureSpec.getMode(i9);
            this.f8064l = mode;
            if (mode == 0) {
                int[] iArr = RecyclerView.f7974D0;
            }
            this.f8067o = View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i10);
            this.f8065m = mode2;
            if (mode2 == 0) {
                int[] iArr2 = RecyclerView.f7974D0;
            }
        }

        public abstract m r();

        public void r0(Rect rect, int i9, int i10) {
            int iF = F() + E() + rect.width();
            int iD = D() + G() + rect.height();
            RecyclerView recyclerView = this.f8055b;
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            this.f8055b.setMeasuredDimension(g(i9, iF, recyclerView.getMinimumWidth()), g(i10, iD, this.f8055b.getMinimumHeight()));
        }

        public m s(Context context, AttributeSet attributeSet) {
            return new m(context, attributeSet);
        }

        public final void s0(int i9, int i10) {
            int iV = v();
            if (iV == 0) {
                this.f8055b.n(i9, i10);
                return;
            }
            int i11 = Integer.MIN_VALUE;
            int i12 = Integer.MAX_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MAX_VALUE;
            for (int i15 = 0; i15 < iV; i15++) {
                View viewU = u(i15);
                Rect rect = this.f8055b.f8008h;
                y(viewU, rect);
                int i16 = rect.left;
                if (i16 < i14) {
                    i14 = i16;
                }
                int i17 = rect.right;
                if (i17 > i11) {
                    i11 = i17;
                }
                int i18 = rect.top;
                if (i18 < i12) {
                    i12 = i18;
                }
                int i19 = rect.bottom;
                if (i19 > i13) {
                    i13 = i19;
                }
            }
            this.f8055b.f8008h.set(i14, i12, i11, i13);
            r0(this.f8055b.f8008h, i9, i10);
        }

        public m t(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof m) {
                return new m((m) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new m((ViewGroup.MarginLayoutParams) layoutParams) : new m(layoutParams);
        }

        public final void t0(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f8055b = null;
                this.f8054a = null;
                this.f8066n = 0;
                this.f8067o = 0;
            } else {
                this.f8055b = recyclerView;
                this.f8054a = recyclerView.f8005e;
                this.f8066n = recyclerView.getWidth();
                this.f8067o = recyclerView.getHeight();
            }
            this.f8064l = 1073741824;
            this.f8065m = 1073741824;
        }

        public final View u(int i9) {
            C0550b c0550b = this.f8054a;
            if (c0550b != null) {
                return c0550b.d(i9);
            }
            return null;
        }

        public final boolean u0(View view, int i9, int i10, m mVar) {
            return (!view.isLayoutRequested() && this.f8061h && M(view.getWidth(), i9, ((ViewGroup.MarginLayoutParams) mVar).width) && M(view.getHeight(), i10, ((ViewGroup.MarginLayoutParams) mVar).height)) ? false : true;
        }

        public final int v() {
            C0550b c0550b = this.f8054a;
            if (c0550b != null) {
                return c0550b.e();
            }
            return 0;
        }

        public boolean v0() {
            return false;
        }

        public final boolean w0(View view, int i9, int i10, m mVar) {
            return (this.f8061h && M(view.getMeasuredWidth(), i9, ((ViewGroup.MarginLayoutParams) mVar).width) && M(view.getMeasuredHeight(), i10, ((ViewGroup.MarginLayoutParams) mVar).height)) ? false : true;
        }

        public int x(r rVar, v vVar) {
            RecyclerView recyclerView = this.f8055b;
            if (recyclerView == null || recyclerView.f8010k == null || !d()) {
                return 1;
            }
            return this.f8055b.f8010k.a();
        }

        public void x0(RecyclerView recyclerView, int i9) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void y(View view, Rect rect) {
            int[] iArr = RecyclerView.f7974D0;
            m mVar = (m) view.getLayoutParams();
            Rect rect2 = mVar.f8075b;
            rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        }

        public final void y0(androidx.recyclerview.widget.o oVar) {
            androidx.recyclerview.widget.o oVar2 = this.f8058e;
            if (oVar2 != null && oVar != oVar2 && oVar2.f8097e) {
                oVar2.d();
            }
            this.f8058e = oVar;
            RecyclerView recyclerView = this.f8055b;
            x xVar = recyclerView.f8000W;
            RecyclerView.this.removeCallbacks(xVar);
            xVar.f8123c.abortAnimation();
            if (oVar.f8100h) {
                Log.w("RecyclerView", "An instance of " + oVar.getClass().getSimpleName() + " was started more than once. Each instance of" + oVar.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            oVar.f8094b = recyclerView;
            oVar.f8095c = this;
            int i9 = oVar.f8093a;
            if (i9 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f8016n0.f8108a = i9;
            oVar.f8097e = true;
            oVar.f8096d = true;
            oVar.f8098f = recyclerView.f8011l.q(i9);
            oVar.f8094b.f8000W.a();
            oVar.f8100h = true;
        }

        public boolean z0() {
            return false;
        }

        public void X() {
        }

        public void Q(RecyclerView recyclerView) {
        }

        public void R(RecyclerView recyclerView) {
        }

        public void c0(v vVar) {
        }

        public void d0(Parcelable parcelable) {
        }

        public void f0(int i9) {
        }

        public void n0(int i9) {
        }

        public void W(int i9, int i10) {
        }

        public void Y(int i9, int i10) {
        }

        public void Z(int i9, int i10) {
        }

        public void a0(int i9, int i10) {
        }

        public void i(int i9, androidx.recyclerview.widget.m.b bVar) {
        }

        public void h(int i9, int i10, v vVar, androidx.recyclerview.widget.m.b bVar) {
        }
    }

    public void setRecyclerListener(s sVar) {
    }

    public static abstract class k {
        public void c(Canvas canvas, RecyclerView recyclerView) {
        }

        public void d(Canvas canvas, RecyclerView recyclerView) {
        }
    }

    public static abstract class p {
        public void a(RecyclerView recyclerView, int i9) {
        }

        public void b(RecyclerView recyclerView, int i9, int i10) {
        }
    }
}
