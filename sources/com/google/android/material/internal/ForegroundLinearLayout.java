package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f13448p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f13449q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f13450r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13451s;
    public final boolean t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f13452u;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f13448p;
        if (drawable != null) {
            if (this.f13452u) {
                this.f13452u = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z8 = this.t;
                Rect rect = this.f13449q;
                if (z8) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i9 = this.f13451s;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.f13450r;
                Gravity.apply(i9, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public final void drawableHotspotChanged(float f6, float f9) {
        super.drawableHotspotChanged(f6, f9);
        Drawable drawable = this.f13448p;
        if (drawable != null) {
            drawable.setHotspot(f6, f9);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f13448p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f13448p.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f13448p;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f13451s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f13448p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        this.f13452u = z8 | this.f13452u;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        this.f13452u = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f13448p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f13448p);
            }
            this.f13448p = drawable;
            this.f13452u = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f13451s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i9) {
        if (this.f13451s != i9) {
            if ((8388615 & i9) == 0) {
                i9 |= 8388611;
            }
            if ((i9 & 112) == 0) {
                i9 |= 48;
            }
            this.f13451s = i9;
            if (i9 == 119 && this.f13448p != null) {
                this.f13448p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f13448p;
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, 0);
        this.f13449q = new Rect();
        this.f13450r = new Rect();
        this.f13451s = 119;
        this.t = true;
        this.f13452u = false;
        int[] iArr = p103n5.a.f20598k;
        h.a(context, attributeSet, 0, 0);
        h.b(context, attributeSet, iArr, 0, 0, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        this.f13451s = typedArrayObtainStyledAttributes.getInt(1, this.f13451s);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.t = typedArrayObtainStyledAttributes.getBoolean(2, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
