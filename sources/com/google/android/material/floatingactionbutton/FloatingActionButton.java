package com.google.android.material.floatingactionbutton;

import A5.d;
import H5.l;
import H5.p;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.C0495g;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.c;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements p202z5.a, p, CoordinatorLayout.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f13405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f13406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f13407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f13408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f13409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13412i;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public class b<T extends FloatingActionButton> implements com.google.android.material.floatingactionbutton.b.a {
        @Override // com.google.android.material.floatingactionbutton.b.a
        public final void a() {
            throw null;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            ((b) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }
    }

    private com.google.android.material.floatingactionbutton.b getImpl() {
        return null;
    }

    @Override // p202z5.a
    public final boolean a() {
        throw null;
    }

    public final void b() {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        if (impl.f13432n == null) {
            impl.f13432n = new ArrayList<>();
        }
        impl.f13432n.add(null);
    }

    public final void c(com.google.android.material.bottomappbar.a aVar) {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        if (impl.f13431m == null) {
            impl.f13431m = new ArrayList<>();
        }
        impl.f13431m.add(aVar);
    }

    public final void d() {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        b bVar = new b();
        if (impl.f13433o == null) {
            impl.f13433o = new ArrayList<>();
        }
        impl.f13433o.add(bVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        getDrawableState();
        impl.getClass();
        throw null;
    }

    public final int e(int i9) {
        int i10 = this.f13411h;
        if (i10 != 0) {
            return i10;
        }
        Resources resources = getResources();
        if (i9 != -1) {
            return i9 != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? e(1) : e(0);
    }

    public final void f(com.google.android.material.bottomappbar.b bVar, boolean z8) {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        if (bVar != null) {
            new com.google.android.material.floatingactionbutton.a(this, bVar);
        }
        impl.getClass();
        throw null;
    }

    public final boolean g() {
        getImpl().getClass();
        throw null;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f13405b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f13406c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        getImpl().getClass();
        throw null;
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f13423d;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f13424e;
    }

    public Drawable getContentBackground() {
        getImpl().getClass();
        return null;
    }

    public int getCustomSize() {
        return this.f13411h;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public p110o5.b getHideMotionSpec() {
        return getImpl().f13427h;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f13409f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f13409f;
    }

    public l getShapeAppearanceModel() {
        l lVar = getImpl().f13420a;
        lVar.getClass();
        return lVar;
    }

    public p110o5.b getShowMotionSpec() {
        return getImpl().f13426g;
    }

    public int getSize() {
        return this.f13410g;
    }

    public int getSizeDimension() {
        return e(this.f13410g);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f13407d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f13408e;
    }

    public boolean getUseCompatPadding() {
        return this.f13412i;
    }

    public final boolean h() {
        getImpl().getClass();
        throw null;
    }

    public final void i() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f13407d;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f13408e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(C0495g.c(colorForState, mode));
    }

    public final void j(com.google.android.material.bottomappbar.b.a aVar, boolean z8) {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        if (aVar != null) {
            new com.google.android.material.floatingactionbutton.a(this, aVar);
        }
        impl.getClass();
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().getClass();
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        impl.getClass();
        if (!(impl instanceof d)) {
            throw null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().getClass();
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i9, int i10) {
        getSizeDimension();
        getImpl().f();
        throw null;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.f7147a);
        extendableSavedState.f13713c.get("expandableWidgetHelper").getClass();
        throw null;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        new ExtendableSavedState(parcelableOnSaveInstanceState);
        throw null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i9) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f13405b != colorStateList) {
            this.f13405b = colorStateList;
            getImpl().getClass();
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f13406c != mode) {
            this.f13406c = mode;
            getImpl().getClass();
        }
    }

    public void setCompatElevation(float f6) {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        if (impl.f13422c != f6) {
            impl.f13422c = f6;
            impl.d(f6, impl.f13423d, impl.f13424e);
        }
    }

    public void setCompatElevationResource(int i9) {
        setCompatElevation(getResources().getDimension(i9));
    }

    public void setCompatHoveredFocusedTranslationZ(float f6) {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        if (impl.f13423d != f6) {
            impl.f13423d = f6;
            impl.d(impl.f13422c, f6, impl.f13424e);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i9) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i9));
    }

    public void setCompatPressedTranslationZ(float f6) {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        if (impl.f13424e != f6) {
            impl.f13424e = f6;
            impl.d(impl.f13422c, impl.f13423d, f6);
        }
    }

    public void setCompatPressedTranslationZResource(int i9) {
        setCompatPressedTranslationZ(getResources().getDimension(i9));
    }

    public void setCustomSize(int i9) {
        if (i9 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i9 != this.f13411h) {
            this.f13411h = i9;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        getImpl().getClass();
    }

    public void setEnsureMinTouchTargetSize(boolean z8) {
        if (z8 != getImpl().f13421b) {
            getImpl().f13421b = z8;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i9) {
        throw null;
    }

    public void setHideMotionSpec(p110o5.b bVar) {
        getImpl().f13427h = bVar;
    }

    public void setHideMotionSpecResource(int i9) {
        setHideMotionSpec(p110o5.b.a(getContext(), i9));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() == drawable) {
            return;
        }
        super.setImageDrawable(drawable);
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        float f6 = impl.j;
        impl.j = f6;
        impl.a(f6, null);
        throw null;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i9) {
        throw null;
    }

    public void setMaxImageSize(int i9) {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        if (impl.f13429k == i9) {
            return;
        }
        impl.f13429k = i9;
        float f6 = impl.j;
        impl.j = f6;
        impl.a(f6, null);
        throw null;
    }

    public void setRippleColor(int i9) {
        setRippleColor(ColorStateList.valueOf(i9));
    }

    @Override // android.view.View
    public void setScaleX(float f6) {
        super.setScaleX(f6);
        ArrayList<com.google.android.material.floatingactionbutton.b.a> arrayList = getImpl().f13433o;
        if (arrayList != null) {
            Iterator<com.google.android.material.floatingactionbutton.b.a> it = arrayList.iterator();
            if (it.hasNext()) {
                it.next().a();
                throw null;
            }
        }
    }

    @Override // android.view.View
    public void setScaleY(float f6) {
        super.setScaleY(f6);
        ArrayList<com.google.android.material.floatingactionbutton.b.a> arrayList = getImpl().f13433o;
        if (arrayList != null) {
            Iterator<com.google.android.material.floatingactionbutton.b.a> it = arrayList.iterator();
            if (it.hasNext()) {
                it.next().a();
                throw null;
            }
        }
    }

    public void setShadowPaddingEnabled(boolean z8) {
        com.google.android.material.floatingactionbutton.b impl = getImpl();
        impl.getClass();
        impl.f();
        throw null;
    }

    @Override // H5.p
    public void setShapeAppearanceModel(l lVar) {
        getImpl().f13420a = lVar;
    }

    public void setShowMotionSpec(p110o5.b bVar) {
        getImpl().f13426g = bVar;
    }

    public void setShowMotionSpecResource(int i9) {
        setShowMotionSpec(p110o5.b.a(getContext(), i9));
    }

    public void setSize(int i9) {
        this.f13411h = 0;
        if (i9 != this.f13410g) {
            this.f13410g = i9;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f13407d != colorStateList) {
            this.f13407d = colorStateList;
            i();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f13408e != mode) {
            this.f13408e = mode;
            i();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f6) {
        super.setTranslationX(f6);
        getImpl().e();
    }

    @Override // android.view.View
    public void setTranslationY(float f6) {
        super.setTranslationY(f6);
        getImpl().e();
    }

    @Override // android.view.View
    public void setTranslationZ(float f6) {
        super.setTranslationZ(f6);
        getImpl().e();
    }

    public void setUseCompatPadding(boolean z8) {
        if (this.f13412i == z8) {
            return;
        }
        this.f13412i = z8;
        getImpl().getClass();
        throw null;
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f13413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13414b;

        public BaseBehavior() {
            this.f13414b = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean a(View view) {
            ((FloatingActionButton) view).getLeft();
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void c(CoordinatorLayout.f fVar) {
            if (fVar.f7044h == 0) {
                fVar.f7044h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                s(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f7037a instanceof BottomSheetBehavior : false) {
                    t(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList arrayListD = coordinatorLayout.d(floatingActionButton);
            int size = arrayListD.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view2 = (View) arrayListD.get(i10);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f7037a instanceof BottomSheetBehavior : false) && t(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (s(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.k(floatingActionButton, i9);
            return true;
        }

        public final boolean s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!(this.f13414b && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).f7042f == appBarLayout.getId() && floatingActionButton.getUserSetVisibility() == 0)) {
                return false;
            }
            if (this.f13413a == null) {
                this.f13413a = new Rect();
            }
            Rect rect = this.f13413a;
            c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.f(null, false);
            } else {
                floatingActionButton.j(null, false);
            }
            return true;
        }

        public final boolean t(View view, FloatingActionButton floatingActionButton) {
            if (!(this.f13414b && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).f7042f == view.getId() && floatingActionButton.getUserSetVisibility() == 0)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.f(null, false);
            } else {
                floatingActionButton.j(null, false);
            }
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p103n5.a.j);
            this.f13414b = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f13409f != colorStateList) {
            this.f13409f = colorStateList;
            getImpl().getClass();
        }
    }

    public static abstract class a {
        public void b() {
        }

        public void a(FloatingActionButton floatingActionButton) {
        }
    }
}
