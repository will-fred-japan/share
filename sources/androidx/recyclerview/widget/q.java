package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class q extends s {
    @Override // androidx.recyclerview.widget.s
    public final int b(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f8325a.getClass();
        return view.getRight() + ((RecyclerView.m) view.getLayoutParams()).f8075b.right + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int c(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f8325a.getClass();
        return RecyclerView.l.A(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int d(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f8325a.getClass();
        return RecyclerView.l.z(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int e(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f8325a.getClass();
        return (view.getLeft() - ((RecyclerView.m) view.getLayoutParams()).f8075b.left) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int f() {
        return this.f8325a.f8066n;
    }

    @Override // androidx.recyclerview.widget.s
    public final int g() {
        RecyclerView.l lVar = this.f8325a;
        return lVar.f8066n - lVar.F();
    }

    @Override // androidx.recyclerview.widget.s
    public final int h() {
        return this.f8325a.F();
    }

    @Override // androidx.recyclerview.widget.s
    public final int i() {
        return this.f8325a.f8064l;
    }

    @Override // androidx.recyclerview.widget.s
    public final int j() {
        return this.f8325a.f8065m;
    }

    @Override // androidx.recyclerview.widget.s
    public final int k() {
        return this.f8325a.E();
    }

    @Override // androidx.recyclerview.widget.s
    public final int l() {
        RecyclerView.l lVar = this.f8325a;
        return (lVar.f8066n - lVar.E()) - lVar.F();
    }

    @Override // androidx.recyclerview.widget.s
    public final int m(View view) {
        RecyclerView.l lVar = this.f8325a;
        Rect rect = this.f8327c;
        lVar.K(view, rect);
        return rect.right;
    }

    @Override // androidx.recyclerview.widget.s
    public final int n(View view) {
        RecyclerView.l lVar = this.f8325a;
        Rect rect = this.f8327c;
        lVar.K(view, rect);
        return rect.left;
    }

    @Override // androidx.recyclerview.widget.s
    public final void o(int i9) {
        this.f8325a.O(i9);
    }
}
