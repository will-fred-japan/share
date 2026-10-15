package Z6;

import android.view.LayoutInflater;
import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LayoutInflater.Factory2 f5560b;

    public /* synthetic */ c(LayoutInflater.Factory2 factory2, int i9) {
        this.f5559a = i9;
        this.f5560b = factory2;
    }

    public final void onBackInvoked() {
        switch (this.f5559a) {
            case 0:
                ((e) this.f5560b).onBackPressed();
                break;
            default:
                ((AppCompatDelegateImpl) this.f5560b).T();
                break;
        }
    }
}
