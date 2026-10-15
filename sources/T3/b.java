package T3;

import android.widget.LinearLayout;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f4489b;

    public /* synthetic */ b(f fVar, int i9) {
        this.f4488a = i9;
        this.f4489b = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4488a) {
            case 0:
                this.f4489b.i(false);
                break;
            default:
                f fVar = this.f4489b;
                LinearLayout linearLayout = fVar.f4498d;
                if (linearLayout != null) {
                    linearLayout.setLayerType(0, null);
                }
                fVar.g(true);
                break;
        }
    }
}
