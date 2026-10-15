package p119p5;

import T.G;
import T.L;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f20808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20811d;

    public d(View view) {
        this.f20808a = view;
    }

    public final void a() {
        int i9 = this.f20811d;
        View view = this.f20808a;
        int top = i9 - (view.getTop() - this.f20809b);
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f20810c));
    }

    public final boolean b(int i9) {
        if (this.f20811d == i9) {
            return false;
        }
        this.f20811d = i9;
        a();
        return true;
    }
}
