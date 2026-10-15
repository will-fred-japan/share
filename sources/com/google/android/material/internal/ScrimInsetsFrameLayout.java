package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f13466a;

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        getWidth();
        getHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f13466a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f13466a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f13466a = drawable;
    }

    public void setDrawBottomInsetForeground(boolean z8) {
    }

    public void setDrawLeftInsetForeground(boolean z8) {
    }

    public void setDrawRightInsetForeground(boolean z8) {
    }

    public void setDrawTopInsetForeground(boolean z8) {
    }
}
