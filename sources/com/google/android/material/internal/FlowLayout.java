package com.google.android.material.internal;

import T.G;
import T.L;
import android.view.View;
import android.view.ViewGroup;
import cn.ikaile.ruoshui.client.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13447d;

    public boolean a() {
        return this.f13446c;
    }

    public int getItemSpacing() {
        return this.f13445b;
    }

    public int getLineSpacing() {
        return this.f13444a;
    }

    public int getRowCount() {
        return this.f13447d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int marginEnd;
        int marginStart;
        if (getChildCount() == 0) {
            this.f13447d = 0;
            return;
        }
        this.f13447d = 1;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        boolean z9 = getLayoutDirection() == 1;
        int paddingRight = z9 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z9 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i13 = (i11 - i9) - paddingLeft;
        int measuredWidth = paddingRight;
        int i14 = paddingTop;
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = marginLayoutParams.getMarginStart();
                    marginEnd = marginLayoutParams.getMarginEnd();
                } else {
                    marginEnd = 0;
                    marginStart = 0;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + measuredWidth + marginStart;
                if (!this.f13446c && measuredWidth2 > i13) {
                    i14 = this.f13444a + paddingTop;
                    this.f13447d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f13447d - 1));
                int i16 = measuredWidth + marginStart;
                int measuredWidth3 = childAt.getMeasuredWidth() + i16;
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                if (z9) {
                    childAt.layout(i13 - measuredWidth3, i14, (i13 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(i16, i14, measuredWidth3, measuredHeight);
                }
                measuredWidth += childAt.getMeasuredWidth() + marginStart + marginEnd + this.f13445b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int size = View.MeasureSpec.getSize(i9);
        int mode = View.MeasureSpec.getMode(i9);
        int size2 = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i9, i10);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = marginLayoutParams.leftMargin;
                    i12 = marginLayoutParams.rightMargin;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int i18 = i12;
                if (childAt.getMeasuredWidth() + paddingLeft + i13 > paddingRight && !a()) {
                    paddingLeft = getPaddingLeft();
                    i15 = paddingTop + this.f13444a;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i13;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i13 + i18 + this.f13445b + paddingLeft;
                if (i17 == getChildCount() - 1) {
                    i16 += i18;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i16;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            i11 = 1073741824;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            i11 = 1073741824;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != i11) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i9) {
        this.f13445b = i9;
    }

    public void setLineSpacing(int i9) {
        this.f13444a = i9;
    }

    public void setSingleLine(boolean z8) {
        this.f13446c = z8;
    }
}
