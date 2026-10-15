package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: ScrollbarHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public static int a(RecyclerView.v vVar, s sVar, View view, View view2, RecyclerView.l lVar, boolean z8) {
        if (lVar.v() == 0 || vVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z8) {
            return Math.abs(RecyclerView.l.H(view) - RecyclerView.l.H(view2)) + 1;
        }
        return Math.min(sVar.l(), sVar.b(view2) - sVar.e(view));
    }

    public static int b(RecyclerView.v vVar, s sVar, View view, View view2, RecyclerView.l lVar, boolean z8, boolean z9) {
        if (lVar.v() == 0 || vVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z9 ? Math.max(0, (vVar.b() - Math.max(RecyclerView.l.H(view), RecyclerView.l.H(view2))) - 1) : Math.max(0, Math.min(RecyclerView.l.H(view), RecyclerView.l.H(view2)));
        if (z8) {
            return Math.round((iMax * (Math.abs(sVar.b(view2) - sVar.e(view)) / (Math.abs(RecyclerView.l.H(view) - RecyclerView.l.H(view2)) + 1))) + (sVar.k() - sVar.e(view)));
        }
        return iMax;
    }

    public static int c(RecyclerView.v vVar, s sVar, View view, View view2, RecyclerView.l lVar, boolean z8) {
        if (lVar.v() == 0 || vVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z8) {
            return vVar.b();
        }
        return (int) (((sVar.b(view2) - sVar.e(view)) / (Math.abs(RecyclerView.l.H(view) - RecyclerView.l.H(view2)) + 1)) * vVar.b());
    }
}
