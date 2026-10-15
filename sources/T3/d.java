package T3;

import android.view.View;
import com.google.android.material.textfield.i;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4493b;

    public /* synthetic */ d(int i9, Object obj) {
        this.f4492a = i9;
        this.f4493b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4492a) {
            case 0:
                f fVar = (f) this.f4493b;
                fVar.getClass();
                view.setEnabled(false);
                fVar.i(true);
                break;
            default:
                ((i) this.f4493b).u();
                break;
        }
    }
}
