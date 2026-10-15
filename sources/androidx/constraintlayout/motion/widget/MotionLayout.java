package androidx.constraintlayout.motion.widget;

import T.InterfaceC0430q;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements InterfaceC0430q {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f6766A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f6767B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public float f6768C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f6769D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public a f6770E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public c f6771F;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f6772s;
    public int t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6773u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f6774v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6775w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f6776x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b f6777y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p189y.b f6778z;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f6779a = Float.NaN;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f6780b = Float.NaN;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6781c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6782d = -1;

        public a() {
        }

        public final void a() {
            int i9 = this.f6781c;
            MotionLayout motionLayout = MotionLayout.this;
            if (i9 != -1 || this.f6782d != -1) {
                c cVar = c.f6784a;
                if (i9 == -1) {
                    motionLayout.m(this.f6782d);
                } else {
                    int i10 = this.f6782d;
                    if (i10 == -1) {
                        motionLayout.setState(cVar);
                        motionLayout.t = i9;
                        motionLayout.f6773u = -1;
                        C.a aVar = motionLayout.f6815k;
                        if (aVar != null) {
                            float f6 = -1;
                            int i11 = aVar.f1763b;
                            SparseArray<C.a.C0008a> sparseArray = aVar.f1765d;
                            int i12 = 0;
                            ConstraintLayout constraintLayout = aVar.f1762a;
                            if (i11 == i9) {
                                C.a.C0008a c0008aValueAt = i9 == -1 ? sparseArray.valueAt(0) : sparseArray.get(i11);
                                int i13 = aVar.f1764c;
                                if (i13 == -1 || !c0008aValueAt.f1768b.get(i13).a(f6, f6)) {
                                    while (true) {
                                        ArrayList<C.a.b> arrayList = c0008aValueAt.f1768b;
                                        if (i12 >= arrayList.size()) {
                                            i12 = -1;
                                            break;
                                        } else if (arrayList.get(i12).a(f6, f6)) {
                                            break;
                                        } else {
                                            i12++;
                                        }
                                    }
                                    if (aVar.f1764c != i12) {
                                        ArrayList<C.a.b> arrayList2 = c0008aValueAt.f1768b;
                                        androidx.constraintlayout.widget.b bVar = i12 == -1 ? null : arrayList2.get(i12).f1776f;
                                        if (i12 != -1) {
                                            int i14 = arrayList2.get(i12).f1775e;
                                        }
                                        if (bVar != null) {
                                            aVar.f1764c = i12;
                                            bVar.a(constraintLayout);
                                            constraintLayout.setConstraintSet(null);
                                            constraintLayout.requestLayout();
                                        }
                                    }
                                }
                            } else {
                                aVar.f1763b = i9;
                                C.a.C0008a c0008a = sparseArray.get(i9);
                                while (true) {
                                    ArrayList<C.a.b> arrayList3 = c0008a.f1768b;
                                    if (i12 >= arrayList3.size()) {
                                        i12 = -1;
                                        break;
                                    } else if (arrayList3.get(i12).a(f6, f6)) {
                                        break;
                                    } else {
                                        i12++;
                                    }
                                }
                                ArrayList<C.a.b> arrayList4 = c0008a.f1768b;
                                androidx.constraintlayout.widget.b bVar2 = i12 == -1 ? c0008a.f1770d : arrayList4.get(i12).f1776f;
                                if (i12 != -1) {
                                    int i15 = arrayList4.get(i12).f1775e;
                                }
                                if (bVar2 == null) {
                                    Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i9 + ", dim =-1.0, -1.0");
                                } else {
                                    aVar.f1764c = i12;
                                    bVar2.a(constraintLayout);
                                    constraintLayout.setConstraintSet(null);
                                    constraintLayout.requestLayout();
                                }
                            }
                        }
                    } else {
                        motionLayout.l(i9, i10);
                    }
                }
                motionLayout.setState(cVar);
            }
            if (Float.isNaN(this.f6780b)) {
                if (Float.isNaN(this.f6779a)) {
                    return;
                }
                motionLayout.setProgress(this.f6779a);
            } else {
                motionLayout.k(this.f6779a, this.f6780b);
                this.f6779a = Float.NaN;
                this.f6780b = Float.NaN;
                this.f6781c = -1;
                this.f6782d = -1;
            }
        }
    }

    public interface b {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f6785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f6786c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ c[] f6787d;

        /* JADX INFO: Fake field, exist only in values array */
        c EF0;

        static {
            c cVar = new c("UNDEFINED", 0);
            c cVar2 = new c("SETUP", 1);
            f6784a = cVar2;
            c cVar3 = new c("MOVING", 2);
            f6785b = cVar3;
            c cVar4 = new c("FINISHED", 3);
            f6786c = cVar4;
            f6787d = new c[]{cVar, cVar2, cVar3, cVar4};
        }

        public c() {
            throw null;
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f6787d.clone();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        boolean z8;
        if (this.f6776x == -1) {
            this.f6776x = getNanoTime();
        }
        float f6 = this.f6775w;
        if (f6 > 0.0f && f6 < 1.0f) {
            this.t = -1;
        }
        boolean z9 = false;
        if (this.f6766A) {
            float fSignum = Math.signum(1.0f - f6);
            long nanoTime = getNanoTime();
            float f9 = (((nanoTime - this.f6776x) * fSignum) * 1.0E-9f) / 0.0f;
            this.f6772s = f9;
            float f10 = this.f6775w + f9;
            if ((fSignum > 0.0f && f10 >= 1.0f) || (fSignum <= 0.0f && f10 <= 1.0f)) {
                f10 = 1.0f;
            }
            this.f6775w = f10;
            this.f6774v = f10;
            this.f6776x = nanoTime;
            if (Math.abs(f9) > 1.0E-5f) {
                setState(c.f6785b);
            }
            if ((fSignum > 0.0f && f10 >= 1.0f) || (fSignum <= 0.0f && f10 <= 1.0f)) {
                f10 = 1.0f;
            }
            c cVar = c.f6786c;
            if (f10 >= 1.0f || f10 <= 0.0f) {
                setState(cVar);
            }
            int childCount = getChildCount();
            this.f6766A = false;
            getNanoTime();
            if (childCount > 0) {
                getChildAt(0);
                throw null;
            }
            boolean z10 = (fSignum > 0.0f && f10 >= 1.0f) || (fSignum <= 0.0f && f10 <= 1.0f);
            if (!this.f6766A && z10) {
                setState(cVar);
            }
            boolean z11 = (!z10) | this.f6766A;
            this.f6766A = z11;
            if (f10 >= 1.0d) {
                int i9 = this.t;
                int i10 = this.f6773u;
                if (i9 != i10) {
                    this.t = i10;
                    throw null;
                }
            }
            if (z11) {
                invalidate();
            } else if ((fSignum > 0.0f && f10 == 1.0f) || (fSignum < 0.0f && f10 == 0.0f)) {
                setState(cVar);
            }
        }
        float f11 = this.f6775w;
        if (f11 < 1.0f) {
            if (f11 <= 0.0f) {
                z8 = this.t != -1;
                this.t = -1;
            }
            if (z9 && !this.f6769D) {
                super.requestLayout();
            }
            this.f6774v = this.f6775w;
            super.dispatchDraw(canvas);
        }
        int i11 = this.t;
        int i12 = this.f6773u;
        z8 = i11 != i12;
        this.t = i12;
        z9 = z8;
        if (z9) {
            super.requestLayout();
        }
        this.f6774v = this.f6775w;
        super.dispatchDraw(canvas);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public final void f(int i9) {
        this.f6815k = null;
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.t;
    }

    public ArrayList<androidx.constraintlayout.motion.widget.a.C0095a> getDefinedTransitions() {
        return null;
    }

    public p189y.b getDesignTool() {
        if (this.f6778z == null) {
            this.f6778z = new p189y.b();
        }
        return this.f6778z;
    }

    public int getEndState() {
        return this.f6773u;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f6775w;
    }

    public int getStartState() {
        return -1;
    }

    public float getTargetPosition() {
        return 1.0f;
    }

    public Bundle getTransitionState() {
        a aVar = this.f6770E;
        MotionLayout motionLayout = MotionLayout.this;
        aVar.f6782d = motionLayout.f6773u;
        aVar.f6781c = -1;
        aVar.f6780b = motionLayout.getVelocity();
        aVar.f6779a = motionLayout.getProgress();
        a aVar2 = this.f6770E;
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", aVar2.f6779a);
        bundle.putFloat("motion.velocity", aVar2.f6780b);
        bundle.putInt("motion.StartState", aVar2.f6781c);
        bundle.putInt("motion.EndState", aVar2.f6782d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        throw null;
    }

    public float getVelocity() {
        return this.f6772s;
    }

    public final void i() {
        if (this.f6777y == null) {
            throw null;
        }
        if (this.f6768C != this.f6774v) {
            if (this.f6767B != -1) {
                throw null;
            }
            this.f6767B = -1;
            this.f6768C = this.f6774v;
            throw null;
        }
    }

    public final void j() {
        if (this.f6777y == null) {
            throw null;
        }
        if (this.f6767B == -1) {
            this.f6767B = this.t;
            throw null;
        }
        if (this.f6777y != null) {
            throw null;
        }
        throw null;
    }

    public final void k(float f6, float f9) {
        if (super.isAttachedToWindow()) {
            setProgress(f6);
            setState(c.f6785b);
            this.f6772s = f9;
        } else {
            a aVar = this.f6770E;
            aVar.f6779a = f6;
            aVar.f6780b = f9;
        }
    }

    public final void l(int i9, int i10) {
        if (super.isAttachedToWindow()) {
            return;
        }
        if (this.f6770E == null) {
            this.f6770E = new a();
        }
        a aVar = this.f6770E;
        aVar.f6781c = i9;
        aVar.f6782d = i10;
    }

    public final void m(int i9) {
        if (!super.isAttachedToWindow()) {
            this.f6770E.f6782d = i9;
            return;
        }
        int i10 = this.t;
        if (i10 == i9 || -1 == i9 || this.f6773u == i9) {
            return;
        }
        this.f6773u = i9;
        if (i10 != -1) {
            l(i10, i9);
            this.f6775w = 0.0f;
        } else {
            this.f6774v = 0.0f;
            this.f6775w = 0.0f;
            this.f6776x = getNanoTime();
            getNanoTime();
            throw null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f6770E;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        this.f6769D = true;
        try {
            super.onLayout(z8, i9, i10, i11, i12);
        } finally {
            this.f6769D = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f6, float f9, boolean z8) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f6, float f9) {
        return false;
    }

    @Override // T.InterfaceC0429p
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12, int i13) {
    }

    @Override // T.InterfaceC0429p
    public final boolean onStartNestedScroll(View view, View view2, int i9, int i10) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            throw null;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
    }

    public void setDebugMode(int i9) {
        invalidate();
    }

    public void setInterpolatedProgress(float f6) {
        setProgress(f6);
    }

    public void setProgress(float f6) {
        if (f6 < 0.0f || f6 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!super.isAttachedToWindow()) {
            this.f6770E.f6779a = f6;
            return;
        }
        c cVar = c.f6786c;
        if (f6 <= 0.0f) {
            this.t = -1;
            if (this.f6775w == 0.0f) {
                setState(cVar);
                return;
            }
            return;
        }
        if (f6 < 1.0f) {
            this.t = -1;
            setState(c.f6785b);
        } else {
            this.t = this.f6773u;
            if (this.f6775w == 1.0f) {
                setState(cVar);
            }
        }
    }

    public void setScene(androidx.constraintlayout.motion.widget.a aVar) {
        e();
        throw null;
    }

    public void setState(c cVar) {
        c cVar2 = c.f6786c;
        if (cVar == cVar2 && this.t == -1) {
            return;
        }
        c cVar3 = this.f6771F;
        this.f6771F = cVar;
        c cVar4 = c.f6785b;
        if (cVar3 == cVar4 && cVar == cVar4) {
            i();
        }
        int iOrdinal = cVar3.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 && cVar == cVar2) {
                j();
                return;
            }
            return;
        }
        if (cVar == cVar4) {
            i();
        }
        if (cVar == cVar2) {
            j();
        }
    }

    public void setTransition(int i9) {
    }

    public void setTransitionDuration(int i9) {
        Log.e("MotionLayout", "MotionScene not defined");
    }

    public void setTransitionListener(b bVar) {
        this.f6777y = bVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f6770E == null) {
            this.f6770E = new a();
        }
        a aVar = this.f6770E;
        aVar.getClass();
        aVar.f6779a = bundle.getFloat("motion.progress");
        aVar.f6780b = bundle.getFloat("motion.velocity");
        aVar.f6781c = bundle.getInt("motion.StartState");
        aVar.f6782d = bundle.getInt("motion.EndState");
        if (super.isAttachedToWindow()) {
            this.f6770E.a();
        }
    }

    @Override // android.view.View
    public final String toString() {
        Context context = getContext();
        return p189y.a.a(context, -1) + "->" + p189y.a.a(context, this.f6773u) + " (pos:" + this.f6775w + " Dpos/Dt:" + this.f6772s;
    }

    @Override // T.InterfaceC0430q
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12, int i13, int[] iArr) {
        if (i9 == 0 && i10 == 0) {
            return;
        }
        iArr[0] = iArr[0] + i11;
        iArr[1] = iArr[1] + i12;
    }

    public void setTransition(androidx.constraintlayout.motion.widget.a.C0095a c0095a) {
        throw null;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i9) {
    }

    public void setInteractionEnabled(boolean z8) {
    }

    public void setOnHide(float f6) {
    }

    public void setOnShow(float f6) {
    }

    @Override // T.InterfaceC0429p
    public final void onStopNestedScroll(View view, int i9) {
    }

    @Override // T.InterfaceC0429p
    public final void onNestedScrollAccepted(View view, View view2, int i9, int i10) {
    }

    @Override // T.InterfaceC0429p
    public final void onNestedPreScroll(View view, int i9, int i10, int[] iArr, int i11) {
    }
}
