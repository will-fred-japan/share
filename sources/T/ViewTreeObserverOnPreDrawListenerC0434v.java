package T;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: T.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: OneShotPreDrawListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0434v implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f4452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f4453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f4454c;

    public ViewTreeObserverOnPreDrawListenerC0434v(View view, Runnable runnable) {
        this.f4452a = view;
        this.f4453b = view.getViewTreeObserver();
        this.f4454c = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        ViewTreeObserverOnPreDrawListenerC0434v viewTreeObserverOnPreDrawListenerC0434v = new ViewTreeObserverOnPreDrawListenerC0434v(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0434v);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0434v);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.f4453b.isAlive();
        View view = this.f4452a;
        if (zIsAlive) {
            this.f4453b.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f4454c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f4453b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.f4453b.isAlive();
        View view2 = this.f4452a;
        if (zIsAlive) {
            this.f4453b.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
