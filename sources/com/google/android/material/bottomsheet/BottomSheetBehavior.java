package com.google.android.material.bottomsheet;

import H5.h;
import H5.l;
import T.C0414a;
import T.G;
import T.L;
import U.f;
import W5.e;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.internal.j;
import com.google.android.material.internal.k;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final BottomSheetBehavior<V>.d f12957A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final ValueAnimator f12958B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final int f12959C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f12960D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f12961E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final float f12962F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f12963G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final float f12964H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f12965I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f12966J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final boolean f12967K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int f12968L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public Y.c f12969M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f12970N;
    public int O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f12971P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final float f12972Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f12973R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public int f12974S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f12975T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public WeakReference<V> f12976U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public WeakReference<View> f12977V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public WeakReference<View> f12978W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public final ArrayList<c> f12979X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public VelocityTracker f12980Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public int f12981Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12982a;
    public int a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12983b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f12984b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f12985c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public HashMap f12986c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12987d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final SparseIntArray f12988d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12989e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final b f12990e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f12994i;
    public final ColorStateList j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f12995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f12996l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12997m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f12998n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f12999o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f13000p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f13001q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f13002r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f13003s;
    public final boolean t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f13004u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13005v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13006w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f13007x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l f13008y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f13009z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f13015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13016b;

        public a(View view, int i9) {
            this.f13015a = view;
            this.f13016b = i9;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomSheetBehavior.this.H(this.f13015a, this.f13016b, false);
        }
    }

    public class b extends Y.c.AbstractC0075c {
        public b() {
        }

        @Override // Y.c.AbstractC0075c
        public final int a(View view, int i9) {
            return view.getLeft();
        }

        @Override // Y.c.AbstractC0075c
        public final int b(View view, int i9) {
            return p027d5.a.n(i9, BottomSheetBehavior.this.z(), d());
        }

        @Override // Y.c.AbstractC0075c
        public final int d() {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.f12965I ? bottomSheetBehavior.f12975T : bottomSheetBehavior.f12963G;
        }

        @Override // Y.c.AbstractC0075c
        public final void f(int i9) {
            if (i9 == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f12967K) {
                    bottomSheetBehavior.F(1);
                }
            }
        }

        @Override // Y.c.AbstractC0075c
        public final void g(View view, int i9, int i10) {
            BottomSheetBehavior.this.w(i10);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x004c  */
        /* JADX WARN: Code duplicated, block: B:34:0x0085  */
        /* JADX WARN: Code duplicated, block: B:6:0x000d  */
        @Override // Y.c.AbstractC0075c
        public final void h(View view, float f6, float f9) {
            int i9 = 6;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (f9 < 0.0f) {
                if (bottomSheetBehavior.f12983b) {
                    i9 = 3;
                } else {
                    int top = view.getTop();
                    System.currentTimeMillis();
                    bottomSheetBehavior.getClass();
                    if (top <= bottomSheetBehavior.f12961E) {
                        i9 = 3;
                    }
                }
            } else if (bottomSheetBehavior.f12965I && bottomSheetBehavior.G(view, f9)) {
                if (Math.abs(f6) >= Math.abs(f9) || f9 <= bottomSheetBehavior.f12987d) {
                    if (view.getTop() > (bottomSheetBehavior.z() + bottomSheetBehavior.f12975T) / 2) {
                        i9 = 5;
                    } else if (bottomSheetBehavior.f12983b || Math.abs(view.getTop() - bottomSheetBehavior.z()) < Math.abs(view.getTop() - bottomSheetBehavior.f12961E)) {
                        i9 = 3;
                    }
                } else {
                    i9 = 5;
                }
            } else if (f9 == 0.0f || Math.abs(f6) > Math.abs(f9)) {
                int top2 = view.getTop();
                if (!bottomSheetBehavior.f12983b) {
                    int i10 = bottomSheetBehavior.f12961E;
                    if (top2 < i10) {
                        if (top2 < Math.abs(top2 - bottomSheetBehavior.f12963G)) {
                            i9 = 3;
                        } else {
                            bottomSheetBehavior.getClass();
                        }
                    } else if (Math.abs(top2 - i10) < Math.abs(top2 - bottomSheetBehavior.f12963G)) {
                        bottomSheetBehavior.getClass();
                    } else {
                        i9 = 4;
                    }
                } else if (Math.abs(top2 - bottomSheetBehavior.f12960D) < Math.abs(top2 - bottomSheetBehavior.f12963G)) {
                    i9 = 3;
                } else {
                    i9 = 4;
                }
            } else if (bottomSheetBehavior.f12983b) {
                i9 = 4;
            } else {
                int top3 = view.getTop();
                if (Math.abs(top3 - bottomSheetBehavior.f12961E) < Math.abs(top3 - bottomSheetBehavior.f12963G)) {
                    bottomSheetBehavior.getClass();
                } else {
                    i9 = 4;
                }
            }
            bottomSheetBehavior.getClass();
            bottomSheetBehavior.H(view, i9, true);
        }

        @Override // Y.c.AbstractC0075c
        public final boolean i(View view, int i9) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i10 = bottomSheetBehavior.f12968L;
            if (i10 == 1 || bottomSheetBehavior.f12984b0) {
                return false;
            }
            if (i10 == 3 && bottomSheetBehavior.f12981Z == i9) {
                WeakReference<View> weakReference = bottomSheetBehavior.f12978W;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            System.currentTimeMillis();
            WeakReference<V> weakReference2 = bottomSheetBehavior.f12976U;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    public static abstract class c {
        public abstract void a();

        public abstract void b();
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f13021c = new a();

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d dVar = d.this;
                dVar.f13020b = false;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                Y.c cVar = bottomSheetBehavior.f12969M;
                if (cVar != null && cVar.g()) {
                    dVar.a(dVar.f13019a);
                } else if (bottomSheetBehavior.f12968L == 2) {
                    bottomSheetBehavior.F(dVar.f13019a);
                }
            }
        }

        public d() {
        }

        public final void a(int i9) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            WeakReference<V> weakReference = bottomSheetBehavior.f12976U;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f13019a = i9;
            if (this.f13020b) {
                return;
            }
            V v5 = bottomSheetBehavior.f12976U.get();
            a aVar = this.f13021c;
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            v5.postOnAnimation(aVar);
            this.f13020b = true;
        }
    }

    public BottomSheetBehavior() {
        this.f12982a = 0;
        this.f12983b = true;
        this.f12995k = -1;
        this.f12996l = -1;
        this.f12957A = new d();
        this.f12962F = 0.5f;
        this.f12964H = -1.0f;
        this.f12967K = true;
        this.f12968L = 4;
        this.f12972Q = 0.1f;
        this.f12979X = new ArrayList<>();
        this.a0 = -1;
        this.f12988d0 = new SparseIntArray();
        this.f12990e0 = new b();
    }

    public static View x(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View viewX = x(viewGroup.getChildAt(i9));
            if (viewX != null) {
                return viewX;
            }
        }
        return null;
    }

    public static int y(int i9, int i10, int i11, int i12) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i9, i10, i12);
        if (i11 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i11), 1073741824);
        }
        if (size != 0) {
            i11 = Math.min(size, i11);
        }
        return View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE);
    }

    public final int A(int i9) {
        if (i9 == 3) {
            return z();
        }
        if (i9 == 4) {
            return this.f12963G;
        }
        if (i9 == 5) {
            return this.f12975T;
        }
        if (i9 == 6) {
            return this.f12961E;
        }
        throw new IllegalArgumentException(e.i(i9, "Invalid state to get top offset: "));
    }

    public final boolean B() {
        WeakReference<V> weakReference = this.f12976U;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            this.f12976U.get().getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void C(BottomSheetDragHandleView bottomSheetDragHandleView) {
        WeakReference<View> weakReference;
        if (bottomSheetDragHandleView != null || (weakReference = this.f12977V) == null) {
            this.f12977V = new WeakReference<>(bottomSheetDragHandleView);
            J(bottomSheetDragHandleView, 1);
        } else {
            v(weakReference.get(), 1);
            this.f12977V = null;
        }
    }

    public final void D(int i9) {
        if (i9 == -1) {
            if (this.f12991f) {
                return;
            } else {
                this.f12991f = true;
            }
        } else {
            if (!this.f12991f && this.f12989e == i9) {
                return;
            }
            this.f12991f = false;
            this.f12989e = Math.max(0, i9);
        }
        M();
    }

    public final void E(int i9) {
        if (i9 == 1 || i9 == 2) {
            throw new IllegalArgumentException(A.a.j(new StringBuilder("STATE_"), i9 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.f12965I && i9 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i9);
            return;
        }
        int i10 = (i9 == 6 && this.f12983b && A(i9) <= this.f12960D) ? 3 : i9;
        WeakReference<V> weakReference = this.f12976U;
        if (weakReference == null || weakReference.get() == null) {
            F(i9);
            return;
        }
        V v5 = this.f12976U.get();
        a aVar = new a(v5, i10);
        ViewParent parent = v5.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            if (v5.isAttachedToWindow()) {
                v5.post(aVar);
                return;
            }
        }
        aVar.run();
    }

    public final void F(int i9) {
        if (this.f12968L == i9) {
            return;
        }
        this.f12968L = i9;
        if (i9 != 4 && i9 != 3 && i9 != 6) {
            boolean z8 = this.f12965I;
        }
        WeakReference<V> weakReference = this.f12976U;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        int i10 = 0;
        if (i9 == 3) {
            L(true);
        } else if (i9 == 6 || i9 == 5 || i9 == 4) {
            L(false);
        }
        K(i9, true);
        while (true) {
            ArrayList<c> arrayList = this.f12979X;
            if (i10 >= arrayList.size()) {
                I();
                return;
            } else {
                arrayList.get(i10).b();
                i10++;
            }
        }
    }

    public final boolean G(View view, float f6) {
        if (this.f12966J) {
            return true;
        }
        if (view.getTop() < this.f12963G) {
            return false;
        }
        return Math.abs(((f6 * this.f12972Q) + ((float) view.getTop())) - ((float) this.f12963G)) / ((float) u()) > 0.5f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        F(2);
        K(r4, true);
        r2.f12957A.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r1.q(r3.getLeft(), r0) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            int r0 = r2.A(r4)
            Y.c r1 = r2.f12969M
            if (r1 == 0) goto L40
            if (r5 == 0) goto L15
            int r3 = r3.getLeft()
            boolean r3 = r1.q(r3, r0)
            if (r3 == 0) goto L40
            goto L32
        L15:
            int r5 = r3.getLeft()
            r1.f5216r = r3
            r3 = -1
            r1.f5202c = r3
            r3 = 0
            boolean r3 = r1.i(r5, r0, r3, r3)
            if (r3 != 0) goto L30
            int r5 = r1.f5200a
            if (r5 != 0) goto L30
            android.view.View r5 = r1.f5216r
            if (r5 == 0) goto L30
            r5 = 0
            r1.f5216r = r5
        L30:
            if (r3 == 0) goto L40
        L32:
            r3 = 2
            r2.F(r3)
            r3 = 1
            r2.K(r4, r3)
            com.google.android.material.bottomsheet.BottomSheetBehavior<V>$d r3 = r2.f12957A
            r3.a(r4)
            return
        L40:
            r2.F(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.H(android.view.View, int, boolean):void");
    }

    public final void I() {
        WeakReference<V> weakReference = this.f12976U;
        if (weakReference != null) {
            J(weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.f12977V;
        if (weakReference2 != null) {
            J(weakReference2.get(), 1);
        }
    }

    public final void J(View view, int i9) {
        int iA;
        int i10;
        if (view == null) {
            return;
        }
        v(view, i9);
        if (!this.f12983b && this.f12968L != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            p136r5.c cVar = new p136r5.c(this, 6);
            ArrayList arrayListF = G.f(view);
            int i11 = 0;
            while (true) {
                if (i11 >= arrayListF.size()) {
                    int i12 = -1;
                    for (int i13 = 0; i13 < 32 && i12 == -1; i13++) {
                        int i14 = G.f4316d[i13];
                        boolean z8 = true;
                        for (int i15 = 0; i15 < arrayListF.size(); i15++) {
                            z8 &= ((f.a) arrayListF.get(i15)).a() != i14;
                        }
                        if (z8) {
                            i12 = i14;
                        }
                    }
                    iA = i12;
                    break;
                }
                if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((f.a) arrayListF.get(i11)).f4586a).getLabel())) {
                    iA = ((f.a) arrayListF.get(i11)).a();
                    break;
                }
                i11++;
            }
            if (iA != -1) {
                i10 = iA;
                f.a aVar = new f.a(null, i10, string, cVar, null);
                View.AccessibilityDelegate accessibilityDelegateD = G.d(view);
                C0414a c0414a = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof C0414a.C0052a ? ((C0414a.C0052a) accessibilityDelegateD).f4403a : new C0414a(accessibilityDelegateD);
                if (c0414a == null) {
                    c0414a = new C0414a();
                }
                G.m(view, c0414a);
                G.j(view, aVar.a());
                G.f(view).add(aVar);
                G.h(view, 0);
            } else {
                i10 = iA;
            }
            this.f12988d0.put(i9, i10);
        }
        if (this.f12965I && this.f12968L != 5) {
            G.k(view, f.a.j, new p136r5.c(this, 5));
        }
        int i16 = this.f12968L;
        if (i16 == 3) {
            G.k(view, f.a.f4583i, new p136r5.c(this, this.f12983b ? 4 : 6));
            return;
        }
        if (i16 == 4) {
            G.k(view, f.a.f4582h, new p136r5.c(this, this.f12983b ? 3 : 6));
        } else {
            if (i16 != 6) {
                return;
            }
            G.k(view, f.a.f4583i, new p136r5.c(this, 4));
            G.k(view, f.a.f4582h, new p136r5.c(this, 3));
        }
    }

    public final void K(int i9, boolean z8) {
        h hVar = this.f12994i;
        ValueAnimator valueAnimator = this.f12958B;
        if (i9 == 2) {
            return;
        }
        boolean z9 = this.f12968L == 3 && (this.f13007x || B());
        if (this.f13009z == z9 || hVar == null) {
            return;
        }
        this.f13009z = z9;
        if (z8 && valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            } else {
                valueAnimator.setFloatValues(hVar.f2420a.f2450i, z9 ? t() : 1.0f);
                valueAnimator.start();
                return;
            }
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        float fT = this.f13009z ? t() : 1.0f;
        h.b bVar = hVar.f2420a;
        if (bVar.f2450i != fT) {
            bVar.f2450i = fT;
            hVar.f2424e = true;
            hVar.invalidateSelf();
        }
    }

    public final void L(boolean z8) {
        WeakReference<V> weakReference = this.f12976U;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z8) {
                if (this.f12986c0 != null) {
                    return;
                } else {
                    this.f12986c0 = new HashMap(childCount);
                }
            }
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = coordinatorLayout.getChildAt(i9);
                if (childAt != this.f12976U.get() && z8) {
                    this.f12986c0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z8) {
                return;
            }
            this.f12986c0 = null;
        }
    }

    public final void M() {
        V v5;
        if (this.f12976U != null) {
            s();
            if (this.f12968L != 4 || (v5 = this.f12976U.get()) == null) {
                return;
            }
            v5.requestLayout();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void c(CoordinatorLayout.f fVar) {
        this.f12976U = null;
        this.f12969M = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void f() {
        this.f12976U = null;
        this.f12969M = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean g(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        int i9;
        Y.c cVar;
        if (!v5.isShown() || !this.f12967K) {
            this.f12970N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f12981Z = -1;
            this.a0 = -1;
            VelocityTracker velocityTracker = this.f12980Y;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f12980Y = null;
            }
        }
        if (this.f12980Y == null) {
            this.f12980Y = VelocityTracker.obtain();
        }
        this.f12980Y.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x8 = (int) motionEvent.getX();
            this.a0 = (int) motionEvent.getY();
            if (this.f12968L != 2) {
                WeakReference<View> weakReference = this.f12978W;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.i(view, x8, this.a0)) {
                    this.f12981Z = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f12984b0 = true;
                }
            }
            this.f12970N = this.f12981Z == -1 && !coordinatorLayout.i(v5, x8, this.a0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f12984b0 = false;
            this.f12981Z = -1;
            if (this.f12970N) {
                this.f12970N = false;
                return false;
            }
        }
        if (this.f12970N || (cVar = this.f12969M) == null || !cVar.r(motionEvent)) {
            WeakReference<View> weakReference2 = this.f12978W;
            View view2 = weakReference2 != null ? weakReference2.get() : null;
            if (actionMasked != 2 || view2 == null || this.f12970N || this.f12968L == 1 || coordinatorLayout.i(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f12969M == null || (i9 = this.a0) == -1 || Math.abs(i9 - motionEvent.getY()) <= this.f12969M.f5201b) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean h(CoordinatorLayout coordinatorLayout, V v5, int i9) {
        int i10 = this.f12996l;
        h hVar = this.f12994i;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (coordinatorLayout.getFitsSystemWindows() && !v5.getFitsSystemWindows()) {
            v5.setFitsSystemWindows(true);
        }
        int i11 = 0;
        if (this.f12976U == null) {
            this.f12992g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z8 = (Build.VERSION.SDK_INT < 29 || this.f12998n || this.f12991f) ? false : true;
            if (this.f12999o || this.f13000p || this.f13001q || this.f13003s || this.t || this.f13004u || z8) {
                p136r5.b bVar = new p136r5.b(this, z8);
                int paddingStart = v5.getPaddingStart();
                v5.getPaddingTop();
                int paddingEnd = v5.getPaddingEnd();
                int paddingBottom = v5.getPaddingBottom();
                com.google.android.material.internal.l.a aVar = new com.google.android.material.internal.l.a();
                aVar.f13549a = paddingStart;
                aVar.f13550b = paddingEnd;
                aVar.f13551c = paddingBottom;
                G.d.c(v5, new j(bVar, aVar));
                if (v5.isAttachedToWindow()) {
                    v5.requestApplyInsets();
                } else {
                    v5.addOnAttachStateChangeListener(new k());
                }
            }
            G.o(v5, new p136r5.d(v5));
            this.f12976U = new WeakReference<>(v5);
            Context context = v5.getContext();
            C5.c.d(context, R.attr.motionEasingStandardDecelerateInterpolator, new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));
            C5.c.c(context, R.attr.motionDurationMedium2, 300);
            C5.c.c(context, R.attr.motionDurationShort3, 150);
            C5.c.c(context, R.attr.motionDurationShort2, 100);
            Resources resources = v5.getResources();
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
            if (hVar != null) {
                v5.setBackground(hVar);
                float elevation = this.f12964H;
                if (elevation == -1.0f) {
                    elevation = v5.getElevation();
                }
                hVar.j(elevation);
            } else {
                ColorStateList colorStateList = this.j;
                if (colorStateList != null) {
                    v5.setBackgroundTintList(colorStateList);
                }
            }
            I();
            if (v5.getImportantForAccessibility() == 0) {
                v5.setImportantForAccessibility(1);
            }
        }
        if (this.f12969M == null) {
            this.f12969M = new Y.c(coordinatorLayout.getContext(), coordinatorLayout, this.f12990e0);
        }
        int top = v5.getTop();
        coordinatorLayout.k(v5, i9);
        this.f12974S = coordinatorLayout.getWidth();
        this.f12975T = coordinatorLayout.getHeight();
        int height = v5.getHeight();
        this.f12973R = height;
        int iMin = this.f12975T;
        int i12 = iMin - height;
        int i13 = this.f13006w;
        if (i12 < i13) {
            if (this.f13002r) {
                if (i10 != -1) {
                    iMin = Math.min(iMin, i10);
                }
                this.f12973R = iMin;
            } else {
                int iMin2 = iMin - i13;
                if (i10 != -1) {
                    iMin2 = Math.min(iMin2, i10);
                }
                this.f12973R = iMin2;
            }
        }
        this.f12960D = Math.max(0, this.f12975T - this.f12973R);
        this.f12961E = (int) ((1.0f - this.f12962F) * this.f12975T);
        s();
        int i14 = this.f12968L;
        if (i14 == 3) {
            v5.offsetTopAndBottom(z());
        } else if (i14 == 6) {
            v5.offsetTopAndBottom(this.f12961E);
        } else if (this.f12965I && i14 == 5) {
            v5.offsetTopAndBottom(this.f12975T);
        } else if (i14 == 4) {
            v5.offsetTopAndBottom(this.f12963G);
        } else if (i14 == 1 || i14 == 2) {
            v5.offsetTopAndBottom(top - v5.getTop());
        }
        K(this.f12968L, false);
        this.f12978W = new WeakReference<>(x(v5));
        while (true) {
            ArrayList<c> arrayList = this.f12979X;
            if (i11 >= arrayList.size()) {
                return true;
            }
            arrayList.get(i11).getClass();
            i11++;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(y(i9, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, this.f12995k, marginLayoutParams.width), y(i11, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f12996l, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean j(View view) {
        WeakReference<View> weakReference = this.f12978W;
        return (weakReference == null || view != weakReference.get() || this.f12968L == 3) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void k(CoordinatorLayout coordinatorLayout, V v5, View view, int i9, int i10, int[] iArr, int i11) {
        boolean z8 = this.f12967K;
        if (i11 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.f12978W;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v5.getTop();
        int i12 = top - i10;
        if (i10 > 0) {
            if (i12 < z()) {
                int iZ = top - z();
                iArr[1] = iZ;
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                v5.offsetTopAndBottom(-iZ);
                F(3);
            } else {
                if (!z8) {
                    return;
                }
                iArr[1] = i10;
                WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                v5.offsetTopAndBottom(-i10);
                F(1);
            }
        } else if (i10 < 0 && !view.canScrollVertically(-1)) {
            int i13 = this.f12963G;
            if (i12 > i13 && !this.f12965I) {
                int i14 = top - i13;
                iArr[1] = i14;
                WeakHashMap<View, L> weakHashMap3 = G.f4313a;
                v5.offsetTopAndBottom(-i14);
                F(4);
            } else {
                if (!z8) {
                    return;
                }
                iArr[1] = i10;
                WeakHashMap<View, L> weakHashMap4 = G.f4313a;
                v5.offsetTopAndBottom(-i10);
                F(1);
            }
        }
        w(v5.getTop());
        this.O = i10;
        this.f12971P = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void n(View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i9 = this.f12982a;
        if (i9 != 0) {
            if (i9 == -1 || (i9 & 1) == 1) {
                this.f12989e = savedState.f13011d;
            }
            if (i9 == -1 || (i9 & 2) == 2) {
                this.f12983b = savedState.f13012e;
            }
            if (i9 == -1 || (i9 & 4) == 4) {
                this.f12965I = savedState.f13013f;
            }
            if (i9 == -1 || (i9 & 8) == 8) {
                this.f12966J = savedState.f13014g;
            }
        }
        int i10 = savedState.f13010c;
        if (i10 == 1 || i10 == 2) {
            this.f12968L = 4;
        } else {
            this.f12968L = i10;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final Parcelable o(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new SavedState(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean p(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i9, int i10) {
        this.O = 0;
        this.f12971P = false;
        return (i9 & 2) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:45:0x0093  */
    /* JADX WARN: Code duplicated, block: B:47:0x0097  */
    /* JADX WARN: Code duplicated, block: B:48:0x0099  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ae  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void q(CoordinatorLayout coordinatorLayout, V v5, View view, int i9) {
        int top;
        int top2;
        int i10;
        float yVelocity;
        int i11 = 3;
        if (v5.getTop() == z()) {
            F(3);
            return;
        }
        WeakReference<View> weakReference = this.f12978W;
        if (weakReference != null && view == weakReference.get() && this.f12971P) {
            if (this.O > 0) {
                if (!this.f12983b && v5.getTop() > this.f12961E) {
                    i11 = 6;
                }
            } else if (this.f12965I) {
                VelocityTracker velocityTracker = this.f12980Y;
                if (velocityTracker == null) {
                    yVelocity = 0.0f;
                } else {
                    velocityTracker.computeCurrentVelocity(1000, this.f12985c);
                    yVelocity = this.f12980Y.getYVelocity(this.f12981Z);
                }
                if (G(v5, yVelocity)) {
                    i11 = 5;
                } else if (this.O == 0) {
                    top2 = v5.getTop();
                    if (this.f12983b) {
                        i10 = this.f12961E;
                        if (top2 < i10) {
                            if (top2 >= Math.abs(top2 - this.f12963G)) {
                            }
                        } else if (Math.abs(top2 - i10) < Math.abs(top2 - this.f12963G)) {
                            i11 = 4;
                        }
                        i11 = 6;
                    } else if (Math.abs(top2 - this.f12960D) >= Math.abs(top2 - this.f12963G)) {
                        i11 = 4;
                    }
                } else {
                    if (!this.f12983b) {
                        top = v5.getTop();
                        if (Math.abs(top - this.f12961E) < Math.abs(top - this.f12963G)) {
                            i11 = 6;
                        }
                    }
                    i11 = 4;
                }
            } else if (this.O == 0) {
                top2 = v5.getTop();
                if (this.f12983b) {
                    i10 = this.f12961E;
                    if (top2 < i10) {
                        if (top2 >= Math.abs(top2 - this.f12963G)) {
                        }
                    } else if (Math.abs(top2 - i10) < Math.abs(top2 - this.f12963G)) {
                        i11 = 4;
                    }
                    i11 = 6;
                } else if (Math.abs(top2 - this.f12960D) >= Math.abs(top2 - this.f12963G)) {
                    i11 = 4;
                }
            } else {
                if (!this.f12983b) {
                    top = v5.getTop();
                    if (Math.abs(top - this.f12961E) < Math.abs(top - this.f12963G)) {
                        i11 = 6;
                    }
                }
                i11 = 4;
            }
            H(v5, i11, false);
            this.f12971P = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean r(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        if (!v5.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i9 = this.f12968L;
        if (i9 == 1 && actionMasked == 0) {
            return true;
        }
        Y.c cVar = this.f12969M;
        if (cVar != null && (this.f12967K || i9 == 1)) {
            cVar.k(motionEvent);
        }
        if (actionMasked == 0) {
            this.f12981Z = -1;
            this.a0 = -1;
            VelocityTracker velocityTracker = this.f12980Y;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f12980Y = null;
            }
        }
        if (this.f12980Y == null) {
            this.f12980Y = VelocityTracker.obtain();
        }
        this.f12980Y.addMovement(motionEvent);
        if (this.f12969M != null && ((this.f12967K || this.f12968L == 1) && actionMasked == 2 && !this.f12970N)) {
            float fAbs = Math.abs(this.a0 - motionEvent.getY());
            Y.c cVar2 = this.f12969M;
            if (fAbs > cVar2.f5201b) {
                cVar2.b(v5, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f12970N;
    }

    public final void s() {
        int iU = u();
        if (this.f12983b) {
            this.f12963G = Math.max(this.f12975T - iU, this.f12960D);
        } else {
            this.f12963G = this.f12975T - iU;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    public final float t() {
        WeakReference<V> weakReference;
        WindowInsets rootWindowInsets;
        float f6;
        float f9 = 0.0f;
        if (this.f12994i != null && (weakReference = this.f12976U) != null && weakReference.get() != null && Build.VERSION.SDK_INT >= 31) {
            V v5 = this.f12976U.get();
            if (B() && (rootWindowInsets = v5.getRootWindowInsets()) != null) {
                h hVar = this.f12994i;
                float fA = hVar.f2420a.f2442a.f2463e.a(hVar.g());
                RoundedCorner roundedCorner = rootWindowInsets.getRoundedCorner(0);
                if (roundedCorner != null) {
                    float radius = roundedCorner.getRadius();
                    if (radius <= 0.0f || fA <= 0.0f) {
                        f6 = 0.0f;
                    } else {
                        f6 = radius / fA;
                    }
                } else {
                    f6 = 0.0f;
                }
                h hVar2 = this.f12994i;
                float fA2 = hVar2.f2420a.f2442a.f2464f.a(hVar2.g());
                RoundedCorner roundedCorner2 = rootWindowInsets.getRoundedCorner(1);
                if (roundedCorner2 != null) {
                    float radius2 = roundedCorner2.getRadius();
                    if (radius2 > 0.0f && fA2 > 0.0f) {
                        f9 = radius2 / fA2;
                    }
                }
                return Math.max(f6, f9);
            }
        }
        return 0.0f;
    }

    public final int u() {
        int i9;
        if (this.f12991f) {
            return Math.min(Math.max(this.f12992g, this.f12975T - ((this.f12974S * 9) / 16)), this.f12973R) + this.f13005v;
        }
        return (this.f12998n || this.f12999o || (i9 = this.f12997m) <= 0) ? this.f12989e + this.f13005v : Math.max(this.f12989e, i9 + this.f12993h);
    }

    public final void v(View view, int i9) {
        if (view == null) {
            return;
        }
        G.j(view, MiPushSdk.FLAG_SUPPORT_CALLKIT);
        G.h(view, 0);
        G.j(view, MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION);
        G.h(view, 0);
        G.j(view, 1048576);
        G.h(view, 0);
        SparseIntArray sparseIntArray = this.f12988d0;
        int i10 = sparseIntArray.get(i9, -1);
        if (i10 != -1) {
            G.j(view, i10);
            G.h(view, 0);
            sparseIntArray.delete(i9);
        }
    }

    public final void w(int i9) {
        if (this.f12976U.get() != null) {
            ArrayList<c> arrayList = this.f12979X;
            if (arrayList.isEmpty()) {
                return;
            }
            int i10 = this.f12963G;
            if (i9 <= i10 && i10 != z()) {
                z();
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                arrayList.get(i11).a();
            }
        }
    }

    public final int z() {
        if (this.f12983b) {
            return this.f12960D;
        }
        return Math.max(this.f12959C, this.f13002r ? 0 : this.f13006w);
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f13011d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f13012e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f13013f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f13014g;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            this.f13010c = parcel.readInt();
            this.f13011d = parcel.readInt();
            this.f13012e = parcel.readInt() == 1;
            this.f13013f = parcel.readInt() == 1;
            this.f13014g = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeInt(this.f13010c);
            parcel.writeInt(this.f13011d);
            parcel.writeInt(this.f13012e ? 1 : 0);
            parcel.writeInt(this.f13013f ? 1 : 0);
            parcel.writeInt(this.f13014g ? 1 : 0);
        }

        public SavedState(BottomSheetBehavior bottomSheetBehavior) {
            super(AbsSavedState.EMPTY_STATE);
            this.f13010c = bottomSheetBehavior.f12968L;
            this.f13011d = bottomSheetBehavior.f12989e;
            this.f13012e = bottomSheetBehavior.f12983b;
            this.f13013f = bottomSheetBehavior.f12965I;
            this.f13014g = bottomSheetBehavior.f12966J;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i9;
        super(context, attributeSet);
        this.f12982a = 0;
        this.f12983b = true;
        this.f12995k = -1;
        this.f12996l = -1;
        this.f12957A = new d();
        this.f12962F = 0.5f;
        this.f12964H = -1.0f;
        this.f12967K = true;
        this.f12968L = 4;
        this.f12972Q = 0.1f;
        this.f12979X = new ArrayList<>();
        this.a0 = -1;
        this.f12988d0 = new SparseIntArray();
        this.f12990e0 = new b();
        this.f12993h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p103n5.a.f20591c);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.j = E5.c.a(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            this.f13008y = l.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        l lVar = this.f13008y;
        if (lVar != null) {
            h hVar = new h(lVar);
            this.f12994i = hVar;
            hVar.i(context);
            ColorStateList colorStateList = this.j;
            if (colorStateList != null) {
                this.f12994i.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f12994i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(t(), 1.0f);
        this.f12958B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f12958B.addUpdateListener(new p136r5.a(this));
        this.f12964H = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f12995k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f12996l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(9);
        if (typedValuePeekValue != null && (i9 = typedValuePeekValue.data) == -1) {
            D(i9);
        } else {
            D(typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -1));
        }
        boolean z8 = typedArrayObtainStyledAttributes.getBoolean(8, false);
        if (this.f12965I != z8) {
            this.f12965I = z8;
            if (!z8 && this.f12968L == 5) {
                E(4);
            }
            I();
        }
        this.f12998n = typedArrayObtainStyledAttributes.getBoolean(13, false);
        boolean z9 = typedArrayObtainStyledAttributes.getBoolean(6, true);
        if (this.f12983b != z9) {
            this.f12983b = z9;
            if (this.f12976U != null) {
                s();
            }
            F((this.f12983b && this.f12968L == 6) ? 3 : this.f12968L);
            K(this.f12968L, true);
            I();
        }
        this.f12966J = typedArrayObtainStyledAttributes.getBoolean(12, false);
        this.f12967K = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.f12982a = typedArrayObtainStyledAttributes.getInt(10, 0);
        float f6 = typedArrayObtainStyledAttributes.getFloat(7, 0.5f);
        if (f6 > 0.0f && f6 < 1.0f) {
            this.f12962F = f6;
            if (this.f12976U != null) {
                this.f12961E = (int) ((1.0f - f6) * this.f12975T);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(5);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i10 = typedValuePeekValue2.data;
                if (i10 >= 0) {
                    this.f12959C = i10;
                    K(this.f12968L, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
                if (dimensionPixelOffset >= 0) {
                    this.f12959C = dimensionPixelOffset;
                    K(this.f12968L, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f12987d = typedArrayObtainStyledAttributes.getInt(11, 500);
            this.f12999o = typedArrayObtainStyledAttributes.getBoolean(17, false);
            this.f13000p = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.f13001q = typedArrayObtainStyledAttributes.getBoolean(19, false);
            this.f13002r = typedArrayObtainStyledAttributes.getBoolean(20, true);
            this.f13003s = typedArrayObtainStyledAttributes.getBoolean(14, false);
            this.t = typedArrayObtainStyledAttributes.getBoolean(15, false);
            this.f13004u = typedArrayObtainStyledAttributes.getBoolean(16, false);
            this.f13007x = typedArrayObtainStyledAttributes.getBoolean(23, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f12985c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11, int[] iArr) {
    }
}
