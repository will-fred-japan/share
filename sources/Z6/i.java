package Z6;

import androidx.fragment.app.FragmentManager;
import io.flutter.embedding.android.FlutterView;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements S.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5585b;

    public /* synthetic */ i(int i9, Object obj) {
        this.f5584a = i9;
        this.f5585b = obj;
    }

    @Override // S.a
    public final void accept(Object obj) {
        switch (this.f5584a) {
            case 0:
                ((FlutterView) this.f5585b).setWindowInfoListenerDisplayFeatures((G0.j) obj);
                break;
            default:
                G.i iVar = (G.i) obj;
                FragmentManager fragmentManager = (FragmentManager) this.f5585b;
                if (fragmentManager.L()) {
                    boolean z8 = iVar.f2087a;
                    fragmentManager.n(false);
                }
                break;
        }
    }
}
