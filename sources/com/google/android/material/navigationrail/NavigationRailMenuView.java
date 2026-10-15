package com.google.android.material.navigationrail;

import android.view.View;
import com.google.android.material.navigation.NavigationBarMenuView;

/* JADX INFO: loaded from: classes.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    public int t;

    public final int a(int i9, int i10, int i11, View view) {
        int iMakeMeasureSpec;
        int measuredHeight;
        if (view == null) {
            int iMax = i10 / Math.max(1, i11);
            int size = this.t;
            if (size == -1) {
                size = View.MeasureSpec.getSize(i9);
            }
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i9, iMakeMeasureSpec);
                    measuredHeight = childAt.getMeasuredHeight();
                } else {
                    measuredHeight = 0;
                }
                i12 += measuredHeight;
            }
        }
        return i12;
    }

    public int getItemMinimumHeight() {
        return this.t;
    }

    public int getMenuGravity() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int i13 = i11 - i9;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                childAt.layout(0, i14, i13, measuredHeight);
                i14 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        int iA;
        int labelVisibilityMode;
        int measuredHeight;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = getMenu().l().size();
        if (size2 <= 1 || ((labelVisibilityMode = getLabelVisibilityMode()) != -1 ? labelVisibilityMode != 0 : size2 <= 3)) {
            iA = a(i9, size, size2, null);
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            if (childAt != null) {
                int iMax = size / Math.max(1, size2);
                int size3 = this.t;
                if (size3 == -1) {
                    size3 = View.MeasureSpec.getSize(i9);
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(size3, iMax), 0);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i9, iMakeMeasureSpec);
                    measuredHeight = childAt.getMeasuredHeight();
                } else {
                    measuredHeight = 0;
                }
                size -= measuredHeight;
                size2--;
            } else {
                measuredHeight = 0;
            }
            iA = a(i9, size, size2, childAt) + measuredHeight;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i9), View.resolveSizeAndState(iA, i10, 0));
    }

    public void setItemMinimumHeight(int i9) {
        if (this.t != i9) {
            this.t = i9;
            requestLayout();
        }
    }

    public void setMenuGravity(int i9) {
        throw null;
    }
}
