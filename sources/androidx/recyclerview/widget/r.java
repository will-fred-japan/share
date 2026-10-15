package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class r extends s {
    @Override // androidx.recyclerview.widget.s
    public final int b(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f8325a.getClass();
        return view.getBottom() + ((RecyclerView.m) view.getLayoutParams()).f8075b.bottom + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int c(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f8325a.getClass();
        return RecyclerView.l.z(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int d(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f8325a.getClass();
        return RecyclerView.l.A(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int e(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f8325a.getClass();
        return (view.getTop() - ((RecyclerView.m) view.getLayoutParams()).f8075b.top) - ((ViewGroup.MarginLayoutParams) mVar).topMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int f() {
        return this.f8325a.f8067o;
    }

    @Override // androidx.recyclerview.widget.s
    public final int g() {
        RecyclerView.l lVar = this.f8325a;
        return lVar.f8067o - lVar.D();
    }

    @Override // androidx.recyclerview.widget.s
    public final int h() {
        return this.f8325a.D();
    }

    @Override // androidx.recyclerview.widget.s
    public final int i() {
        return this.f8325a.f8065m;
    }

    @Override // androidx.recyclerview.widget.s
    public final int j() {
        return this.f8325a.f8064l;
    }

    @Override // androidx.recyclerview.widget.s
    public final int k() {
        return this.f8325a.G();
    }

    @Override // androidx.recyclerview.widget.s
    public final int l() {
        RecyclerView.l lVar = this.f8325a;
        return (lVar.f8067o - lVar.G()) - lVar.D();
    }

    @Override // androidx.recyclerview.widget.s
    public final int m(View view) {
        RecyclerView.l lVar = this.f8325a;
        Rect rect = this.f8327c;
        lVar.K(view, rect);
        return rect.bottom;
    }

    @Override // androidx.recyclerview.widget.s
    public final int n(View view) {
        RecyclerView.l lVar = this.f8325a;
        Rect rect = this.f8327c;
        lVar.K(view, rect);
        return rect.top;
    }

    @Override // androidx.recyclerview.widget.s
    public final void o(int i9) {
        this.f8325a.P(i9);
    }
}
