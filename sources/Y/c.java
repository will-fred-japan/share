package Y;

import T.G;
import T.L;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ViewDragHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f5199v = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5201b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f5203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f5204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f5205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f5206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f5207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f5208i;
    public int[] j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f5210l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f5211m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f5212n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f5213o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OverScroller f5214p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AbstractC0075c f5215q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f5216r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f5217s;
    public final CoordinatorLayout t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5202c = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f5218u = new b();

    /* JADX INFO: compiled from: ViewDragHelper.java */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f6) {
            float f9 = f6 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: ViewDragHelper.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.p(0);
        }
    }

    public c(Context context, CoordinatorLayout coordinatorLayout, AbstractC0075c abstractC0075c) {
        if (coordinatorLayout == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0075c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.t = coordinatorLayout;
        this.f5215q = abstractC0075c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5213o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f5201b = viewConfiguration.getScaledTouchSlop();
        this.f5211m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f5212n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5214p = new OverScroller(context, f5199v);
    }

    public final void a() {
        this.f5202c = -1;
        float[] fArr = this.f5203d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f5204e, 0.0f);
            Arrays.fill(this.f5205f, 0.0f);
            Arrays.fill(this.f5206g, 0.0f);
            Arrays.fill(this.f5207h, 0);
            Arrays.fill(this.f5208i, 0);
            Arrays.fill(this.j, 0);
            this.f5209k = 0;
        }
        VelocityTracker velocityTracker = this.f5210l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5210l = null;
        }
    }

    public final void b(View view, int i9) {
        ViewParent parent = view.getParent();
        CoordinatorLayout coordinatorLayout = this.t;
        if (parent != coordinatorLayout) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + coordinatorLayout + ")");
        }
        this.f5216r = view;
        this.f5202c = i9;
        this.f5215q.e(view, i9);
        p(1);
    }

    public final boolean c(float f6, float f9, int i9, int i10) {
        Math.abs(f6);
        Math.abs(f9);
        int i11 = this.f5207h[i9];
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0044 A[RETURN] */
    public final boolean d(View view, float f6, float f9) {
        if (view != null) {
            AbstractC0075c abstractC0075c = this.f5215q;
            boolean z8 = abstractC0075c.c(view) > 0;
            boolean z9 = abstractC0075c.d() > 0;
            if (z8 && z9) {
                float f10 = (f9 * f9) + (f6 * f6);
                int i9 = this.f5201b;
                if (f10 > i9 * i9) {
                    return true;
                }
            } else if (!z8 ? !(!z9 || Math.abs(f9) <= this.f5201b) : Math.abs(f6) > this.f5201b) {
                return true;
            }
        }
        return false;
    }

    public final void e(int i9) {
        float[] fArr = this.f5203d;
        if (fArr != null) {
            int i10 = this.f5209k;
            int i11 = 1 << i9;
            if ((i10 & i11) != 0) {
                fArr[i9] = 0.0f;
                this.f5204e[i9] = 0.0f;
                this.f5205f[i9] = 0.0f;
                this.f5206g[i9] = 0.0f;
                this.f5207h[i9] = 0;
                this.f5208i[i9] = 0;
                this.j[i9] = 0;
                this.f5209k = (~i11) & i10;
            }
        }
    }

    public final int f(int i9, int i10, int i11) {
        if (i9 == 0) {
            return 0;
        }
        int width = this.t.getWidth();
        float f6 = width / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i9) / width) - 0.5f) * 0.47123894f)) * f6) + f6;
        int iAbs = Math.abs(i10);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i9) / i11) + 1.0f) * 256.0f), 600);
    }

    public final boolean g() {
        if (this.f5200a == 2) {
            OverScroller overScroller = this.f5214p;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f5216r.getLeft();
            int top = currY - this.f5216r.getTop();
            if (left != 0) {
                View view = this.f5216r;
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f5216r;
                WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f5215q.g(this.f5216r, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.t.post(this.f5218u);
            }
        }
        return this.f5200a == 2;
    }

    public final View h(int i9, int i10) {
        CoordinatorLayout coordinatorLayout = this.t;
        for (int childCount = coordinatorLayout.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f5215q.getClass();
            View childAt = coordinatorLayout.getChildAt(childCount);
            if (i9 >= childAt.getLeft() && i9 < childAt.getRight() && i10 >= childAt.getTop() && i10 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean i(int i9, int i10, int i11, int i12) {
        float f6;
        float f9;
        float f10;
        float f11;
        int left = this.f5216r.getLeft();
        int top = this.f5216r.getTop();
        int i13 = i9 - left;
        int i14 = i10 - top;
        OverScroller overScroller = this.f5214p;
        if (i13 == 0 && i14 == 0) {
            overScroller.abortAnimation();
            p(0);
            return false;
        }
        View view = this.f5216r;
        int i15 = (int) this.f5212n;
        int i16 = (int) this.f5211m;
        int iAbs = Math.abs(i11);
        if (iAbs < i15) {
            i11 = 0;
        } else if (iAbs > i16) {
            i11 = i11 > 0 ? i16 : -i16;
        }
        int iAbs2 = Math.abs(i12);
        if (iAbs2 < i15) {
            i12 = 0;
        } else if (iAbs2 > i16) {
            i12 = i12 > 0 ? i16 : -i16;
        }
        int iAbs3 = Math.abs(i13);
        int iAbs4 = Math.abs(i14);
        int iAbs5 = Math.abs(i11);
        int iAbs6 = Math.abs(i12);
        int i17 = iAbs5 + iAbs6;
        int i18 = iAbs3 + iAbs4;
        if (i11 != 0) {
            f6 = iAbs5;
            f9 = i17;
        } else {
            f6 = iAbs3;
            f9 = i18;
        }
        float f12 = f6 / f9;
        if (i12 != 0) {
            f10 = iAbs6;
            f11 = i17;
        } else {
            f10 = iAbs4;
            f11 = i18;
        }
        float f13 = f10 / f11;
        AbstractC0075c abstractC0075c = this.f5215q;
        overScroller.startScroll(left, top, i13, i14, (int) ((f(i14, i12, abstractC0075c.d()) * f13) + (f(i13, i11, abstractC0075c.c(view)) * f12)));
        p(2);
        return true;
    }

    public final boolean j(int i9) {
        if ((this.f5209k & (1 << i9)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i9 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void k(MotionEvent motionEvent) {
        int i9;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f5210l == null) {
            this.f5210l = VelocityTracker.obtain();
        }
        this.f5210l.addMovement(motionEvent);
        int i10 = 0;
        if (actionMasked == 0) {
            float x8 = motionEvent.getX();
            float y8 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewH = h((int) x8, (int) y8);
            n(x8, y8, pointerId);
            s(viewH, pointerId);
            int i11 = this.f5207h[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.f5200a == 1) {
                l();
            }
            a();
            return;
        }
        AbstractC0075c abstractC0075c = this.f5215q;
        if (actionMasked == 2) {
            if (this.f5200a != 1) {
                int pointerCount = motionEvent.getPointerCount();
                while (i10 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i10);
                    if (j(pointerId2)) {
                        float x9 = motionEvent.getX(i10);
                        float y9 = motionEvent.getY(i10);
                        float f6 = x9 - this.f5203d[pointerId2];
                        float f9 = y9 - this.f5204e[pointerId2];
                        m(f6, f9, pointerId2);
                        if (this.f5200a != 1) {
                            View viewH2 = h((int) x9, (int) y9);
                            if (d(viewH2, f6, f9) && s(viewH2, pointerId2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i10++;
                }
                o(motionEvent);
                return;
            }
            if (j(this.f5202c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f5202c);
                float x10 = motionEvent.getX(iFindPointerIndex);
                float y10 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f5205f;
                int i12 = this.f5202c;
                int i13 = (int) (x10 - fArr[i12]);
                int i14 = (int) (y10 - this.f5206g[i12]);
                int left = this.f5216r.getLeft() + i13;
                int top = this.f5216r.getTop() + i14;
                int left2 = this.f5216r.getLeft();
                int top2 = this.f5216r.getTop();
                if (i13 != 0) {
                    left = abstractC0075c.a(this.f5216r, left);
                    WeakHashMap<View, L> weakHashMap = G.f4313a;
                    this.f5216r.offsetLeftAndRight(left - left2);
                }
                if (i14 != 0) {
                    top = abstractC0075c.b(this.f5216r, top);
                    WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                    this.f5216r.offsetTopAndBottom(top - top2);
                }
                if (i13 != 0 || i14 != 0) {
                    abstractC0075c.g(this.f5216r, left, top);
                }
                o(motionEvent);
                return;
            }
            return;
        }
        if (actionMasked == 3) {
            if (this.f5200a == 1) {
                this.f5217s = true;
                abstractC0075c.h(this.f5216r, 0.0f, 0.0f);
                this.f5217s = false;
                if (this.f5200a == 1) {
                    p(0);
                }
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x11 = motionEvent.getX(actionIndex);
            float y11 = motionEvent.getY(actionIndex);
            n(x11, y11, pointerId3);
            if (this.f5200a == 0) {
                s(h((int) x11, (int) y11), pointerId3);
                int i15 = this.f5207h[pointerId3];
                return;
            }
            int i16 = (int) x11;
            int i17 = (int) y11;
            View view = this.f5216r;
            if (view != null && i16 >= view.getLeft() && i16 < view.getRight() && i17 >= view.getTop() && i17 < view.getBottom()) {
                s(this.f5216r, pointerId3);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f5200a == 1 && pointerId4 == this.f5202c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i10 >= pointerCount2) {
                    i9 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i10);
                if (pointerId5 != this.f5202c) {
                    View viewH3 = h((int) motionEvent.getX(i10), (int) motionEvent.getY(i10));
                    View view2 = this.f5216r;
                    if (viewH3 == view2 && s(view2, pointerId5)) {
                        i9 = this.f5202c;
                        break;
                    }
                }
                i10++;
            }
            if (i9 == -1) {
                l();
            }
        }
        e(pointerId4);
    }

    public final void l() {
        VelocityTracker velocityTracker = this.f5210l;
        float f6 = this.f5211m;
        velocityTracker.computeCurrentVelocity(1000, f6);
        float xVelocity = this.f5210l.getXVelocity(this.f5202c);
        float f9 = this.f5212n;
        float fAbs = Math.abs(xVelocity);
        if (fAbs < f9) {
            xVelocity = 0.0f;
        } else if (fAbs > f6) {
            xVelocity = xVelocity > 0.0f ? f6 : -f6;
        }
        float yVelocity = this.f5210l.getYVelocity(this.f5202c);
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 < f9) {
            f6 = 0.0f;
        } else if (fAbs2 <= f6) {
            f6 = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f6 = -f6;
        }
        this.f5217s = true;
        this.f5215q.h(this.f5216r, xVelocity, f6);
        this.f5217s = false;
        if (this.f5200a == 1) {
            p(0);
        }
    }

    public final void m(float f6, float f9, int i9) {
        c(f6, f9, i9, 1);
        c(f9, f6, i9, 4);
        c(f6, f9, i9, 2);
        c(f9, f6, i9, 8);
    }

    public final void n(float f6, float f9, int i9) {
        float[] fArr = this.f5203d;
        if (fArr == null || fArr.length <= i9) {
            int i10 = i9 + 1;
            float[] fArr2 = new float[i10];
            float[] fArr3 = new float[i10];
            float[] fArr4 = new float[i10];
            float[] fArr5 = new float[i10];
            int[] iArr = new int[i10];
            int[] iArr2 = new int[i10];
            int[] iArr3 = new int[i10];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f5204e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f5205f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f5206g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f5207h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f5208i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f5203d = fArr2;
            this.f5204e = fArr3;
            this.f5205f = fArr4;
            this.f5206g = fArr5;
            this.f5207h = iArr;
            this.f5208i = iArr2;
            this.j = iArr3;
        }
        float[] fArr9 = this.f5203d;
        this.f5205f[i9] = f6;
        fArr9[i9] = f6;
        float[] fArr10 = this.f5204e;
        this.f5206g[i9] = f9;
        fArr10[i9] = f9;
        int[] iArr7 = this.f5207h;
        int i11 = (int) f6;
        int i12 = (int) f9;
        CoordinatorLayout coordinatorLayout = this.t;
        int i13 = i11 < coordinatorLayout.getLeft() + this.f5213o ? 1 : 0;
        if (i12 < coordinatorLayout.getTop() + this.f5213o) {
            i13 |= 4;
        }
        if (i11 > coordinatorLayout.getRight() - this.f5213o) {
            i13 |= 2;
        }
        if (i12 > coordinatorLayout.getBottom() - this.f5213o) {
            i13 |= 8;
        }
        iArr7[i9] = i13;
        this.f5209k |= 1 << i9;
    }

    public final void o(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i9 = 0; i9 < pointerCount; i9++) {
            int pointerId = motionEvent.getPointerId(i9);
            if (j(pointerId)) {
                float x8 = motionEvent.getX(i9);
                float y8 = motionEvent.getY(i9);
                this.f5205f[pointerId] = x8;
                this.f5206g[pointerId] = y8;
            }
        }
    }

    public final void p(int i9) {
        this.t.removeCallbacks(this.f5218u);
        if (this.f5200a != i9) {
            this.f5200a = i9;
            this.f5215q.f(i9);
            if (this.f5200a == 0) {
                this.f5216r = null;
            }
        }
    }

    public final boolean q(int i9, int i10) {
        if (this.f5217s) {
            return i(i9, i10, (int) this.f5210l.getXVelocity(this.f5202c), (int) this.f5210l.getYVelocity(this.f5202c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ed  */
    public final boolean r(MotionEvent motionEvent) {
        View viewH;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f5210l == null) {
            this.f5210l = VelocityTracker.obtain();
        }
        this.f5210l.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x8 = motionEvent.getX();
            float y8 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            n(x8, y8, pointerId);
            View viewH2 = h((int) x8, (int) y8);
            if (viewH2 == this.f5216r && this.f5200a == 2) {
                s(viewH2, pointerId);
            }
            int i9 = this.f5207h[pointerId];
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                a();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x9 = motionEvent.getX(actionIndex);
                float y9 = motionEvent.getY(actionIndex);
                n(x9, y9, pointerId2);
                int i10 = this.f5200a;
                if (i10 == 0) {
                    int i11 = this.f5207h[pointerId2];
                } else if (i10 == 2 && (viewH = h((int) x9, (int) y9)) == this.f5216r) {
                    s(viewH, pointerId2);
                }
            } else if (actionMasked == 6) {
                e(motionEvent.getPointerId(actionIndex));
            }
        } else if (this.f5203d != null && this.f5204e != null) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i12 = 0; i12 < pointerCount; i12++) {
                int pointerId3 = motionEvent.getPointerId(i12);
                if (j(pointerId3)) {
                    float x10 = motionEvent.getX(i12);
                    float y10 = motionEvent.getY(i12);
                    float f6 = x10 - this.f5203d[pointerId3];
                    float f9 = y10 - this.f5204e[pointerId3];
                    View viewH3 = h((int) x10, (int) y10);
                    boolean z8 = viewH3 != null && d(viewH3, f6, f9);
                    if (!z8) {
                        m(f6, f9, pointerId3);
                        if (this.f5200a != 1) {
                            break;
                        }
                    } else {
                        int left = viewH3.getLeft();
                        AbstractC0075c abstractC0075c = this.f5215q;
                        int iA = abstractC0075c.a(viewH3, ((int) f6) + left);
                        int top = viewH3.getTop();
                        int iB = abstractC0075c.b(viewH3, ((int) f9) + top);
                        int iC = abstractC0075c.c(viewH3);
                        int iD = abstractC0075c.d();
                        if ((iC == 0 || (iC > 0 && iA == left)) && (iD == 0 || (iD > 0 && iB == top))) {
                            break;
                        }
                        m(f6, f9, pointerId3);
                        if (this.f5200a != 1 || (z8 && s(viewH3, pointerId3))) {
                            break;
                        }
                    }
                }
            }
            o(motionEvent);
        }
        return this.f5200a == 1;
    }

    public final boolean s(View view, int i9) {
        if (view == this.f5216r && this.f5202c == i9) {
            return true;
        }
        if (view == null || !this.f5215q.i(view, i9)) {
            return false;
        }
        this.f5202c = i9;
        b(view, i9);
        return true;
    }

    /* JADX INFO: renamed from: Y.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewDragHelper.java */
    public static abstract class AbstractC0075c {
        public abstract int a(View view, int i9);

        public abstract int b(View view, int i9);

        public int c(View view) {
            return 0;
        }

        public int d() {
            return 0;
        }

        public abstract void f(int i9);

        public abstract void g(View view, int i9, int i10);

        public abstract void h(View view, float f6, float f9);

        public abstract boolean i(View view, int i9);

        public void e(View view, int i9) {
        }
    }
}
