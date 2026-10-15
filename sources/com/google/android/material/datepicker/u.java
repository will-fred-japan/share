package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: compiled from: MaterialTextInputPicker.java */
/* JADX INFO: loaded from: classes.dex */
public final class u<S> extends z<S> {

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public int f13377V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public DateSelector<S> f13378W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public CalendarConstraints f13379X;

    /* JADX INFO: compiled from: MaterialTextInputPicker.java */
    public class a extends y<S> {
        public a() {
        }

        @Override // com.google.android.material.datepicker.y
        public final void a() {
            Iterator<y<S>> it = u.this.f13397U.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.y
        public final void b(S s8) {
            Iterator<y<S>> it = u.this.f13397U.iterator();
            while (it.hasNext()) {
                it.next().b(s8);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void n(Bundle bundle) {
        super.n(bundle);
        if (bundle == null) {
            bundle = this.f7465f;
        }
        this.f13377V = bundle.getInt("THEME_RES_ID_KEY");
        this.f13378W = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f13379X = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View o(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f13378W.w(layoutInflater.cloneInContext(new ContextThemeWrapper(d(), this.f13377V)), viewGroup, this.f13379X, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public final void s(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f13377V);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f13378W);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f13379X);
    }
}
