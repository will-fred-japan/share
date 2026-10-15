package com.google.android.material.bottomnavigation;

import cn.ikaile.ruoshui.client.R;
import com.google.android.material.navigation.NavigationBarItemView;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationItemView extends NavigationBarItemView {
    @Override // com.google.android.material.navigation.NavigationBarItemView
    public int getItemDefaultMarginResId() {
        return R.dimen.design_bottom_navigation_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    public int getItemLayoutResId() {
        return R.layout.design_bottom_navigation_item;
    }
}
