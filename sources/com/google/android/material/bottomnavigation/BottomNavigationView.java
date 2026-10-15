package com.google.android.material.bottomnavigation;

import android.view.View;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends NavigationBarView {

    @Deprecated
    public interface a extends NavigationBarView.a {
    }

    @Deprecated
    public interface b extends NavigationBarView.b {
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i10) != 1073741824 && suggestedMinimumHeight > 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), getPaddingBottom() + getPaddingTop() + suggestedMinimumHeight), 1073741824);
        }
        super.onMeasure(i9, i10);
    }

    public void setItemHorizontalTranslationEnabled(boolean z8) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.t == z8) {
            return;
        }
        bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z8);
        getPresenter();
        throw null;
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(a aVar) {
        setOnItemReselectedListener(aVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(b bVar) {
        setOnItemSelectedListener(bVar);
    }
}
