package G0;

import U7.r;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements S.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2232b;

    public /* synthetic */ h(int i9, Object obj) {
        this.f2231a = i9;
        this.f2232b = obj;
    }

    @Override // S.a
    public final void accept(Object obj) {
        switch (this.f2231a) {
            case 0:
                ((r) this.f2232b).s((j) obj);
                break;
            case 1:
                ((androidx.fragment.app.g) this.f2232b).lambda$init$2((Intent) obj);
                break;
            default:
                Integer num = (Integer) obj;
                FragmentManager fragmentManager = (FragmentManager) this.f2232b;
                if (fragmentManager.L() && num.intValue() == 80) {
                    fragmentManager.m(false);
                    break;
                }
                break;
        }
    }
}
