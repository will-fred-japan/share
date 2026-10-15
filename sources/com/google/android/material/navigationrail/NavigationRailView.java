package com.google.android.material.navigationrail;

import android.view.View;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: loaded from: classes.dex */
public class NavigationRailView extends NavigationBarView {
    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    public View getHeaderView() {
        return null;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        getNavigationRailMenuView().getClass();
        throw null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i9) != 1073741824 && suggestedMinimumWidth > 0) {
            i9 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i9), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), 1073741824);
        }
        super.onMeasure(i9, i10);
    }

    public void setItemMinimumHeight(int i9) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i9);
    }

    public void setMenuGravity(int i9) {
        getNavigationRailMenuView().setMenuGravity(i9);
    }
}
