package p128q5;

import T.G;
import T.L;
import U.h;
import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SwipeDismissBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f20986a;

    public b(SwipeDismissBehavior swipeDismissBehavior) {
        this.f20986a = swipeDismissBehavior;
    }

    @Override // U.h
    public final boolean c(View view) {
        SwipeDismissBehavior swipeDismissBehavior = this.f20986a;
        if (!swipeDismissBehavior.s(view)) {
            return false;
        }
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        boolean z8 = view.getLayoutDirection() == 1;
        int i9 = swipeDismissBehavior.f12910d;
        view.offsetLeftAndRight((!(i9 == 0 && z8) && (i9 != 1 || z8)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }
}
