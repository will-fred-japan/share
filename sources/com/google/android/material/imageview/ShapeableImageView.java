package com.google.android.material.imageview;

import H5.l;
import H5.p;
import I.a;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f13435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f13436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f13437f;

    public int getContentPaddingBottom() {
        return 0;
    }

    public final int getContentPaddingEnd() {
        return 0;
    }

    public int getContentPaddingLeft() {
        if (getLayoutDirection() == 1) {
            return 0;
        }
        getLayoutDirection();
        return 0;
    }

    public int getContentPaddingRight() {
        if (getLayoutDirection() == 1) {
            return 0;
        }
        getLayoutDirection();
        return 0;
    }

    public final int getContentPaddingStart() {
        return 0;
    }

    public int getContentPaddingTop() {
        return 0;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public l getShapeAppearanceModel() {
        return this.f13436e;
    }

    public ColorStateList getStrokeColor() {
        return this.f13435d;
    }

    public float getStrokeWidth() {
        return this.f13437f;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(null, null);
        if (this.f13435d != null) {
            throw null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        getPaddingLeft();
        getPaddingTop();
        getPaddingRight();
        getPaddingBottom();
        throw null;
    }

    @Override // android.view.View
    public final void setPadding(int i9, int i10, int i11, int i12) {
        super.setPadding(getContentPaddingLeft() + i9, getContentPaddingTop() + i10, getContentPaddingRight() + i11, getContentPaddingBottom() + i12);
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i9, int i10, int i11, int i12) {
        super.setPaddingRelative(getContentPaddingStart() + i9, getContentPaddingTop() + i10, getContentPaddingEnd() + i11, getContentPaddingBottom() + i12);
    }

    @Override // H5.p
    public void setShapeAppearanceModel(l lVar) {
        this.f13436e = lVar;
        getWidth();
        getHeight();
        getPaddingLeft();
        getPaddingTop();
        getPaddingRight();
        getPaddingBottom();
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f13435d = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i9) {
        setStrokeColor(a.b(getContext(), i9));
    }

    public void setStrokeWidth(float f6) {
        if (this.f13437f != f6) {
            this.f13437f = f6;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i9) {
        setStrokeWidth(getResources().getDimensionPixelSize(i9));
    }
}
