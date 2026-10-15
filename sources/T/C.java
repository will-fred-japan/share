package T;

import android.view.View;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C extends G.b<Boolean> {
    @Override // T.G.b
    public final Boolean a(View view) {
        return Boolean.valueOf(G.h.c(view));
    }

    @Override // T.G.b
    public final void b(View view, Boolean bool) {
        G.h.f(view, bool.booleanValue());
    }

    @Override // T.G.b
    public final boolean d(Boolean bool, Boolean bool2) {
        Boolean bool3 = bool;
        Boolean bool4 = bool2;
        return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
    }
}
