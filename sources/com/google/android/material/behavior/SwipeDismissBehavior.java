package com.google.android.material.behavior;

import T.G;
import T.L;
import U.f;
import Y.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f12907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12910d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f12911e = 0.5f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f12912f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12913g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f12914h = new a();

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f12918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f12919b;

        public b(View view, boolean z8) {
            this.f12918a = view;
            this.f12919b = z8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = SwipeDismissBehavior.this.f12907a;
            View view = this.f12918a;
            if (cVar == null || !cVar.g()) {
                return;
            }
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            view.postOnAnimation(this);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean g(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        boolean zI = this.f12908b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zI = coordinatorLayout.i(v5, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f12908b = zI;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f12908b = false;
        }
        if (zI) {
            if (this.f12907a == null) {
                this.f12907a = new c(coordinatorLayout.getContext(), coordinatorLayout, this.f12914h);
            }
            if (!this.f12909c && this.f12907a.r(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean h(CoordinatorLayout coordinatorLayout, V v5, int i9) {
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (v5.getImportantForAccessibility() == 0) {
            v5.setImportantForAccessibility(1);
            G.j(v5, 1048576);
            G.h(v5, 0);
            if (s(v5)) {
                G.k(v5, f.a.j, new p128q5.b(this));
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean r(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        if (this.f12907a == null) {
            return false;
        }
        if (this.f12909c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f12907a.k(motionEvent);
        return true;
    }

    public boolean s(View view) {
        return true;
    }

    public class a extends c.AbstractC0075c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12916b = -1;

        public a() {
        }

        @Override // Y.c.AbstractC0075c
        public final int a(View view, int i9) {
            int width;
            int width2;
            int width3;
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            boolean z8 = view.getLayoutDirection() == 1;
            int i10 = SwipeDismissBehavior.this.f12910d;
            if (i10 == 0) {
                if (z8) {
                    width = this.f12915a - view.getWidth();
                    width2 = this.f12915a;
                } else {
                    width = this.f12915a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i10 != 1) {
                width = this.f12915a - view.getWidth();
                width2 = view.getWidth() + this.f12915a;
            } else if (z8) {
                width = this.f12915a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f12915a - view.getWidth();
                width2 = this.f12915a;
            }
            return Math.min(Math.max(width, i9), width2);
        }

        @Override // Y.c.AbstractC0075c
        public final int b(View view, int i9) {
            return view.getTop();
        }

        @Override // Y.c.AbstractC0075c
        public final int c(View view) {
            return view.getWidth();
        }

        @Override // Y.c.AbstractC0075c
        public final void e(View view, int i9) {
            this.f12916b = i9;
            this.f12915a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
                swipeDismissBehavior.f12909c = true;
                parent.requestDisallowInterceptTouchEvent(true);
                swipeDismissBehavior.f12909c = false;
            }
        }

        @Override // Y.c.AbstractC0075c
        public final void g(View view, int i9, int i10) {
            float width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            float f6 = width * swipeDismissBehavior.f12912f;
            float width2 = view.getWidth() * swipeDismissBehavior.f12913g;
            float fAbs = Math.abs(i9 - this.f12915a);
            if (fAbs <= f6) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f6) / (width2 - f6))), 1.0f));
            }
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0052  */
        /* JADX WARN: Code duplicated, block: B:29:0x0056  */
        /* JADX WARN: Code duplicated, block: B:32:0x005f  */
        /* JADX WARN: Code duplicated, block: B:33:0x0061  */
        /* JADX WARN: Code duplicated, block: B:34:0x0066  */
        @Override // Y.c.AbstractC0075c
        public final void h(View view, float f6, float f9) {
            int i9;
            int left;
            int i10;
            this.f12916b = -1;
            int width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            boolean z8 = true;
            if (f6 != 0.0f) {
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                boolean z9 = view.getLayoutDirection() == 1;
                int i11 = swipeDismissBehavior.f12910d;
                if (i11 != 2 && (i11 != 0 ? i11 != 1 || (!z9 ? f6 < 0.0f : f6 > 0.0f) : !z9 ? f6 > 0.0f : f6 < 0.0f)) {
                    i9 = this.f12915a;
                    z8 = false;
                } else if (f6 >= 0.0f) {
                    left = view.getLeft();
                    i10 = this.f12915a;
                    if (left < i10) {
                        i9 = this.f12915a - width;
                    } else {
                        i9 = i10 + width;
                    }
                } else {
                    i9 = this.f12915a - width;
                }
            } else {
                if (Math.abs(view.getLeft() - this.f12915a) < Math.round(view.getWidth() * swipeDismissBehavior.f12911e)) {
                    i9 = this.f12915a;
                    z8 = false;
                } else if (f6 >= 0.0f) {
                    left = view.getLeft();
                    i10 = this.f12915a;
                    if (left < i10) {
                        i9 = this.f12915a - width;
                    } else {
                        i9 = i10 + width;
                    }
                } else {
                    i9 = this.f12915a - width;
                }
            }
            if (swipeDismissBehavior.f12907a.q(i9, view.getTop())) {
                b bVar = new b(view, z8);
                WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                view.postOnAnimation(bVar);
            }
        }

        @Override // Y.c.AbstractC0075c
        public final boolean i(View view, int i9) {
            int i10 = this.f12916b;
            return (i10 == -1 || i10 == i9) && SwipeDismissBehavior.this.s(view);
        }

        @Override // Y.c.AbstractC0075c
        public final void f(int i9) {
        }
    }
}
