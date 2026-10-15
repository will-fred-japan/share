package io.flutter.plugin.platform;

import android.view.View;

/* JADX INFO: compiled from: VirtualDisplayController.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f19683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f19684b;

    /* JADX INFO: compiled from: VirtualDisplayController.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            w wVar = w.this;
            wVar.f19683a.postDelayed(wVar.f19684b, 128L);
        }
    }

    public w(View view, m mVar) {
        this.f19683a = view;
        this.f19684b = mVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        a aVar = new a();
        View view2 = this.f19683a;
        view2.getViewTreeObserver().addOnDrawListener(new v.b(view2, aVar));
        view2.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
