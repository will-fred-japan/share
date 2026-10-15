package com.google.android.material.bottomnavigation;

import T.G;
import T.L;
import android.view.View;
import androidx.appcompat.view.menu.f;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    public boolean t;

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int i13 = i11 - i9;
        int i14 = i12 - i10;
        int measuredWidth = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                if (getLayoutDirection() == 1) {
                    int i16 = i13 - measuredWidth;
                    childAt.layout(i16 - childAt.getMeasuredWidth(), 0, i16, i14);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i14);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        f menu = getMenu();
        View.MeasureSpec.getSize(i9);
        menu.l().size();
        getChildCount();
        throw null;
    }

    public void setItemHorizontalTranslationEnabled(boolean z8) {
        this.t = z8;
    }
}
