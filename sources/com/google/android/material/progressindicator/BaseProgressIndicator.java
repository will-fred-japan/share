package com.google.android.material.progressindicator;

import D5.a;
import D5.b;
import D5.e;
import D5.f;
import D5.g;
import T.G;
import T.L;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;
import cn.ikaile.ruoshui.client.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;
import p011b4.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProgressIndicator<S> extends ProgressBar {
    private f<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            getIndeterminateDrawable().getClass();
            return null;
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        getProgressDrawable().getClass();
        return null;
    }

    public final boolean a() {
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (!isAttachedToWindow() || getWindowVisibility() != 0) {
            return false;
        }
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        throw null;
    }

    public int[] getIndicatorColor() {
        throw null;
    }

    public int getIndicatorTrackGapSize() {
        throw null;
    }

    public int getShowAnimationBehavior() {
        throw null;
    }

    public int getTrackColor() {
        throw null;
    }

    public int getTrackCornerRadius() {
        throw null;
    }

    public int getTrackThickness() {
        throw null;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable();
            throw null;
        }
        if (getProgressDrawable() != null) {
            b<S> progressDrawable = getProgressDrawable();
            if (progressDrawable.f1932c == null) {
                progressDrawable.f1932c = new ArrayList();
            }
            if (!progressDrawable.f1932c.contains(null)) {
                progressDrawable.f1932c.add(null);
            }
        }
        if (getIndeterminateDrawable() != null) {
            g<S> indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable.f1932c == null) {
                indeterminateDrawable.f1932c = new ArrayList();
            }
            if (!indeterminateDrawable.f1932c.contains(null)) {
                indeterminateDrawable.f1932c.add(null);
            }
        }
        if (a()) {
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(null);
        removeCallbacks(null);
        ((e) getCurrentDrawable()).getClass();
        throw null;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i9, int i10) {
        getCurrentDrawingDelegate();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i9) {
        super.onVisibilityChanged(view, i9);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i9) {
        super.onWindowVisibilityChanged(i9);
    }

    public void setAnimatorDurationScaleProvider(a aVar) {
        if (getProgressDrawable() != null) {
            getProgressDrawable().getClass();
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().getClass();
        }
    }

    public void setHideAnimationBehavior(int i9) {
        throw null;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z8) {
        if (z8 == isIndeterminate()) {
            return;
        }
        if (((e) getCurrentDrawable()) != null) {
            throw null;
        }
        super.setIndeterminate(z8);
        e eVar = (e) getCurrentDrawable();
        if (eVar != null) {
            a();
            throw null;
        }
        if ((eVar instanceof g) && a()) {
            throw null;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof g)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            throw null;
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{h.x(getContext(), R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            throw null;
        }
    }

    public void setIndicatorTrackGapSize(int i9) {
        throw null;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i9) {
        if (isIndeterminate()) {
            return;
        }
        if (!isIndeterminate()) {
            super.setProgress(i9);
            if (getProgressDrawable() != null) {
                getProgressDrawable().getClass();
                throw null;
            }
        } else if (getProgressDrawable() != null) {
            if (getIndeterminateDrawable().isVisible()) {
                getContext().getContentResolver();
                throw null;
            }
            getIndeterminateDrawable();
            throw null;
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof b)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            throw null;
        }
    }

    public void setShowAnimationBehavior(int i9) {
        throw null;
    }

    public void setTrackColor(int i9) {
        throw null;
    }

    public void setTrackCornerRadius(int i9) {
        throw null;
    }

    public void setTrackThickness(int i9) {
        throw null;
    }

    public void setVisibilityAfterHide(int i9) {
        if (i9 != 0 && i9 != 4 && i9 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
    }

    @Override // android.widget.ProgressBar
    public g<S> getIndeterminateDrawable() {
        return (g) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public b<S> getProgressDrawable() {
        return (b) super.getProgressDrawable();
    }
}
