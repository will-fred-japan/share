package com.google.android.material.bottomappbar;

import T.G;
import T.L;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import p142s2.j;
import p155u.g;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final /* synthetic */ int f12921t0 = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public Integer f12922U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public AnimatorSet f12923V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public AnimatorSet f12924W;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f12925l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f12926m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f12927n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f12928o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f12929p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f12930q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f12931r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Behavior f12932s0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12938d;

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
            this.f12937c = parcel.readInt();
            this.f12938d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeInt(this.f12937c);
            parcel.writeInt(this.f12938d ? 1 : 0);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f12939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f12941c;

        public a(ActionMenuView actionMenuView, int i9, boolean z8) {
            this.f12939a = actionMenuView;
            this.f12940b = i9;
            this.f12941c = z8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i9 = this.f12940b;
            boolean z8 = this.f12941c;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            ActionMenuView actionMenuView = this.f12939a;
            actionMenuView.setTranslationX(bottomAppBar.A(actionMenuView, i9, z8));
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return 0;
    }

    private int getFabAlignmentAnimationDuration() {
        return C5.c.c(getContext(), R.attr.motionDurationLong2, 300);
    }

    private float getFabTranslationX() {
        return B(this.f12925l0);
    }

    private float getFabTranslationY() {
        if (this.f12927n0 == 1) {
            return -getTopEdgeTreatment().f12955c;
        }
        View viewZ = z();
        return viewZ != null ? (-((getMeasuredHeight() + getBottomInset()) - viewZ.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return 0;
    }

    private d getTopEdgeTreatment() {
        throw null;
    }

    public final int A(ActionMenuView actionMenuView, int i9, boolean z8) {
        int i10 = 0;
        if (this.f12929p0 != 1 && (i9 != 1 || !z8)) {
            return 0;
        }
        boolean zC = l.c(this);
        int measuredWidth = zC ? getMeasuredWidth() : 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if ((childAt.getLayoutParams() instanceof Toolbar.g) && (((Toolbar.g) childAt.getLayoutParams()).f5943a & 8388615) == 8388611) {
                measuredWidth = zC ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zC ? actionMenuView.getRight() : actionMenuView.getLeft();
        if (getNavigationIcon() == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
            i10 = zC ? dimensionPixelOffset : -dimensionPixelOffset;
        }
        return measuredWidth - (right + i10);
    }

    public final float B(int i9) {
        boolean zC = l.c(this);
        if (i9 != 1) {
            return 0.0f;
        }
        View viewZ = z();
        return ((getMeasuredWidth() / 2) - ((this.f12928o0 == -1 || viewZ == null) ? 0 : (viewZ.getMeasuredWidth() / 2) + this.f12928o0)) * (zC ? -1 : 1);
    }

    public final boolean C() {
        View viewZ = z();
        FloatingActionButton floatingActionButton = viewZ instanceof FloatingActionButton ? (FloatingActionButton) viewZ : null;
        return floatingActionButton != null && floatingActionButton.h();
    }

    public final void D() {
        d topEdgeTreatment = getTopEdgeTreatment();
        getFabTranslationX();
        topEdgeTreatment.getClass();
        if (this.f12931r0 && C()) {
            int i9 = this.f12927n0;
        }
        throw null;
    }

    public final void E(ActionMenuView actionMenuView, int i9, boolean z8, boolean z9) {
        a aVar = new a(actionMenuView, i9, z8);
        if (z9) {
            actionMenuView.post(aVar);
        } else {
            aVar.run();
        }
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f12955c;
    }

    public int getFabAlignmentMode() {
        return this.f12925l0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f12928o0;
    }

    public int getFabAnchorMode() {
        return this.f12927n0;
    }

    public int getFabAnimationMode() {
        return this.f12926m0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f12954b;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f12953a;
    }

    public boolean getHideOnScroll() {
        return this.f12930q0;
    }

    public int getMenuAlignmentMode() {
        return this.f12929p0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.y(this, null);
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        if (z8) {
            AnimatorSet animatorSet = this.f12924W;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.f12923V;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            D();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f12924W != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (C()) {
            E(actionMenuView, this.f12925l0, this.f12931r0, false);
        } else {
            E(actionMenuView, 0, false, false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f7147a);
        this.f12925l0 = savedState.f12937c;
        this.f12931r0 = savedState.f12938d;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12937c = this.f12925l0;
        savedState.f12938d = this.f12931r0;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setCradleVerticalOffset(float f6) {
        if (f6 != getCradleVerticalOffset()) {
            d topEdgeTreatment = getTopEdgeTreatment();
            if (f6 >= 0.0f) {
                topEdgeTreatment.f12955c = f6;
                throw null;
            }
            topEdgeTreatment.getClass();
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        throw null;
    }

    public void setFabAlignmentMode(int i9) {
        int i10;
        boolean z8 = this.f12931r0;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (isLaidOut()) {
            AnimatorSet animatorSet = this.f12924W;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (C()) {
                i10 = i9;
            } else {
                z8 = false;
                i10 = 0;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                objectAnimatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
                if (Math.abs(actionMenuView.getTranslationX() - A(actionMenuView, i10, z8)) > 1.0f) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    objectAnimatorOfFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
                    objectAnimatorOfFloat2.addListener(new c(this, actionMenuView, i10, z8));
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                    arrayList.add(animatorSet2);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(objectAnimatorOfFloat);
                }
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList);
            this.f12924W = animatorSet3;
            animatorSet3.addListener(new D5.d(1, this));
            this.f12924W.start();
        }
        if (this.f12925l0 != i9 && isLaidOut()) {
            AnimatorSet animatorSet4 = this.f12923V;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.f12926m0 == 1) {
                View viewZ = z();
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewZ instanceof FloatingActionButton ? (FloatingActionButton) viewZ : null, "translationX", B(i9));
                objectAnimatorOfFloat3.setDuration(getFabAlignmentAnimationDuration());
                arrayList2.add(objectAnimatorOfFloat3);
            } else {
                View viewZ2 = z();
                FloatingActionButton floatingActionButton = viewZ2 instanceof FloatingActionButton ? (FloatingActionButton) viewZ2 : null;
                if (floatingActionButton != null && !floatingActionButton.g()) {
                    floatingActionButton.f(new b(this, i9), true);
                }
            }
            AnimatorSet animatorSet5 = new AnimatorSet();
            animatorSet5.playTogether(arrayList2);
            animatorSet5.setInterpolator(C5.c.d(getContext(), R.attr.motionEasingEmphasizedInterpolator, p110o5.a.f20703a));
            this.f12923V = animatorSet5;
            animatorSet5.addListener(new com.google.android.material.bottomappbar.a(this, 0));
            this.f12923V.start();
        }
        this.f12925l0 = i9;
    }

    public void setFabAlignmentModeEndMargin(int i9) {
        if (this.f12928o0 == i9) {
            return;
        }
        this.f12928o0 = i9;
        D();
        throw null;
    }

    public void setFabAnchorMode(int i9) {
        this.f12927n0 = i9;
        D();
        throw null;
    }

    public void setFabAnimationMode(int i9) {
        this.f12926m0 = i9;
    }

    public void setFabCornerSize(float f6) {
        if (f6 == getTopEdgeTreatment().f12956d) {
            return;
        }
        getTopEdgeTreatment().f12956d = f6;
        throw null;
    }

    public void setFabCradleMargin(float f6) {
        if (f6 == getFabCradleMargin()) {
            return;
        }
        getTopEdgeTreatment().f12954b = f6;
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float f6) {
        if (f6 == getFabCradleRoundedCornerRadius()) {
            return;
        }
        getTopEdgeTreatment().f12953a = f6;
        throw null;
    }

    public void setHideOnScroll(boolean z8) {
        this.f12930q0 = z8;
    }

    public void setMenuAlignmentMode(int i9) {
        if (this.f12929p0 != i9) {
            this.f12929p0 = i9;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                E(actionMenuView, this.f12925l0, C(), false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f12922U != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.f12922U.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i9) {
        this.f12922U = Integer.valueOf(i9);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public final View z() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getParent();
        List list = (List) ((g) coordinatorLayout.f7017b.f1948d).get(this);
        ArrayList<View> arrayList = coordinatorLayout.f7019d;
        arrayList.clear();
        if (list != null) {
            arrayList.addAll(list);
        }
        for (View view : arrayList) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f12932s0 == null) {
            this.f12932s0 = new Behavior();
        }
        return this.f12932s0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Rect f12933i;
        public WeakReference<BottomAppBar> j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f12934k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final a f12935l;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
                Behavior behavior = Behavior.this;
                BottomAppBar bottomAppBar = behavior.j.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    behavior.f12933i.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                    throw null;
                }
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (behavior.f12934k == 0) {
                    if (bottomAppBar.f12927n0 == 1) {
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (l.c(view)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
                    }
                }
                int i17 = BottomAppBar.f12921t0;
                bottomAppBar.D();
                throw null;
            }
        }

        public Behavior() {
            this.f12935l = new a();
            this.f12933i = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.j = new WeakReference<>(bottomAppBar);
            int i10 = BottomAppBar.f12921t0;
            View viewZ = bottomAppBar.z();
            if (viewZ != null) {
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                if (!viewZ.isLaidOut()) {
                    CoordinatorLayout.f fVar = (CoordinatorLayout.f) viewZ.getLayoutParams();
                    fVar.f7040d = 17;
                    int i11 = bottomAppBar.f12927n0;
                    if (i11 == 1) {
                        fVar.f7040d = 49;
                    }
                    if (i11 == 0) {
                        fVar.f7040d |= 80;
                    }
                    this.f12934k = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) viewZ.getLayoutParams())).bottomMargin;
                    if (viewZ instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) viewZ;
                        if (floatingActionButton.getShowMotionSpec() == null) {
                            floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                        }
                        if (floatingActionButton.getHideMotionSpec() == null) {
                            floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                        }
                        floatingActionButton.b();
                        floatingActionButton.c(new com.google.android.material.bottomappbar.a(bottomAppBar, 1));
                        floatingActionButton.d();
                    }
                    viewZ.addOnLayoutChangeListener(this.f12935l);
                    bottomAppBar.D();
                    throw null;
                }
            }
            coordinatorLayout.k(bottomAppBar, i9);
            super.h(coordinatorLayout, bottomAppBar, i9);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i9, int i10) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.p(coordinatorLayout, bottomAppBar, view2, view3, i9, i10);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12935l = new a();
            this.f12933i = new Rect();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
