package p119p5;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: ViewOffsetBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f20806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20807b;

    public c() {
        this.f20807b = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, V v5, int i9) {
        u(coordinatorLayout, v5, i9);
        if (this.f20806a == null) {
            this.f20806a = new d(v5);
        }
        d dVar = this.f20806a;
        View view = dVar.f20808a;
        dVar.f20809b = view.getTop();
        dVar.f20810c = view.getLeft();
        this.f20806a.a();
        int i10 = this.f20807b;
        if (i10 == 0) {
            return true;
        }
        this.f20806a.b(i10);
        this.f20807b = 0;
        return true;
    }

    public final int s() {
        d dVar = this.f20806a;
        if (dVar != null) {
            return dVar.f20811d;
        }
        return 0;
    }

    public int t() {
        return s();
    }

    public void u(CoordinatorLayout coordinatorLayout, V v5, int i9) {
        coordinatorLayout.k(v5, i9);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20807b = 0;
    }
}
