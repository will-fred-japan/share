package W;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: SystemBarStateMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f4994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.C0065a f4995b;

    public b(ViewGroup viewGroup, a.C0065a c0065a) {
        this.f4994a = viewGroup;
        this.f4995b = c0065a;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f4994a.addView(this.f4995b, 0);
        view.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f4994a.addView(this.f4995b, 0);
        view.removeOnAttachStateChangeListener(this);
    }
}
