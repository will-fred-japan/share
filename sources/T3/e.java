package T3;

import android.view.View;

/* JADX INFO: compiled from: ConnectionOverlayController.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pl.droidsonroids.gif.d f4494a;

    public e(pl.droidsonroids.gif.d dVar) {
        this.f4494a = dVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        pl.droidsonroids.gif.d dVar = this.f4494a;
        if (dVar.a()) {
            return;
        }
        dVar.stop();
        dVar.b();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
