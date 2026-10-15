package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.l f8325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8326b = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f8327c = new Rect();

    public s(RecyclerView.l lVar) {
        this.f8325a = lVar;
    }

    public static s a(RecyclerView.l lVar, int i9) {
        if (i9 == 0) {
            return new q(lVar);
        }
        if (i9 == 1) {
            return new r(lVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m(View view);

    public abstract int n(View view);

    public abstract void o(int i9);
}
