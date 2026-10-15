package com.google.android.material.tabs;

import android.view.View;

/* JADX INFO: compiled from: TabLayout.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f13745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabLayout.TabView f13746b;

    public a(TabLayout.TabView tabView, View view) {
        this.f13746b = tabView;
        this.f13745a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        View view2 = this.f13745a;
        if (view2.getVisibility() == 0) {
            int i17 = TabLayout.TabView.f13732i;
            this.f13746b.c(view2);
        }
    }
}
