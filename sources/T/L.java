package T;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f4334a;

    public L(View view) {
        this.f4334a = new WeakReference<>(view);
    }

    public final void a(float f6) {
        View view = this.f4334a.get();
        if (view != null) {
            view.animate().alpha(f6);
        }
    }

    public final void b() {
        View view = this.f4334a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j) {
        View view = this.f4334a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
    }

    public final void d(M m8) {
        View view = this.f4334a.get();
        if (view != null) {
            if (m8 != null) {
                view.animate().setListener(new D5.c(m8, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f6) {
        View view = this.f4334a.get();
        if (view != null) {
            view.animate().translationY(f6);
        }
    }
}
