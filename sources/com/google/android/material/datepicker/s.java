package com.google.android.material.datepicker;

import T.InterfaceC0431s;
import T.Q;
import android.view.View;

/* JADX INFO: compiled from: MaterialDatePicker.java */
/* JADX INFO: loaded from: classes.dex */
public final class s implements InterfaceC0431s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f13375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13376c;

    public s(View view, int i9, int i10) {
        this.f13374a = i9;
        this.f13375b = view;
        this.f13376c = i10;
    }

    @Override // T.InterfaceC0431s
    public final Q b(View view, Q q8) {
        int i9 = q8.f4366a.h(519).f2745b;
        View view2 = this.f13375b;
        int i10 = this.f13374a;
        if (i10 >= 0) {
            view2.getLayoutParams().height = i10 + i9;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.f13376c + i9, view2.getPaddingRight(), view2.getPaddingBottom());
        return q8;
    }
}
