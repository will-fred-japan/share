package androidx.fragment.app;

import android.content.res.Configuration;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements S.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7639b;

    public /* synthetic */ n(int i9, Object obj) {
        this.f7638a = i9;
        this.f7639b = obj;
    }

    @Override // S.a
    public final void accept(Object obj) {
        switch (this.f7638a) {
            case 0:
                FragmentManager fragmentManager = (FragmentManager) this.f7639b;
                if (fragmentManager.L()) {
                    fragmentManager.i(false);
                }
                break;
            case 1:
                G.C c5 = (G.C) obj;
                FragmentManager fragmentManager2 = (FragmentManager) this.f7639b;
                if (fragmentManager2.L()) {
                    boolean z8 = c5.f2058a;
                    fragmentManager2.s(false);
                }
                break;
            default:
                ((g) this.f7639b).lambda$init$1((Configuration) obj);
                break;
        }
    }
}
