package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: RecyclerView.java */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f8331a;

    public v(RecyclerView recyclerView) {
        this.f8331a = recyclerView;
    }

    public final void a(int i9) {
        RecyclerView recyclerView = this.f8331a;
        View childAt = recyclerView.getChildAt(i9);
        if (childAt != null) {
            RecyclerView.I(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i9);
    }
}
