package com.google.android.material.divider;

import T.G;
import T.L;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialDivider extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13401d;

    public int getDividerColor() {
        return this.f13399b;
    }

    public int getDividerInsetEnd() {
        return this.f13401d;
    }

    public int getDividerInsetStart() {
        return this.f13400c;
    }

    public int getDividerThickness() {
        return this.f13398a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (getLayoutDirection() != 1) {
        }
        getWidth();
        getBottom();
        getTop();
        throw null;
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        int mode = View.MeasureSpec.getMode(i10);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i11 = this.f13398a;
            if (i11 > 0 && measuredHeight != i11) {
                measuredHeight = i11;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i9) {
        if (this.f13399b == i9) {
            return;
        }
        this.f13399b = i9;
        ColorStateList.valueOf(i9);
        throw null;
    }

    public void setDividerColorResource(int i9) {
        setDividerColor(getContext().getColor(i9));
    }

    public void setDividerInsetEnd(int i9) {
        this.f13401d = i9;
    }

    public void setDividerInsetEndResource(int i9) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i9));
    }

    public void setDividerInsetStart(int i9) {
        this.f13400c = i9;
    }

    public void setDividerInsetStartResource(int i9) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i9));
    }

    public void setDividerThickness(int i9) {
        if (this.f13398a != i9) {
            this.f13398a = i9;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i9) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i9));
    }
}
