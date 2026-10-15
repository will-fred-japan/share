package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.y f8220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f8221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f8222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f8223d;

    public g(View view, ViewPropertyAnimator viewPropertyAnimator, k kVar, RecyclerView.y yVar) {
        this.f8223d = kVar;
        this.f8220a = yVar;
        this.f8221b = view;
        this.f8222c = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f8221b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f8222c.setListener(null);
        k kVar = this.f8223d;
        RecyclerView.y yVar = this.f8220a;
        kVar.c(yVar);
        kVar.f8245o.remove(yVar);
        kVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f8223d.getClass();
    }
}
