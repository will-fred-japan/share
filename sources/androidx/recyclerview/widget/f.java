package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.y f8216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f8217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f8218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f8219d;

    public f(View view, ViewPropertyAnimator viewPropertyAnimator, k kVar, RecyclerView.y yVar) {
        this.f8219d = kVar;
        this.f8216a = yVar;
        this.f8217b = viewPropertyAnimator;
        this.f8218c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f8217b.setListener(null);
        this.f8218c.setAlpha(1.0f);
        k kVar = this.f8219d;
        RecyclerView.y yVar = this.f8216a;
        kVar.c(yVar);
        kVar.f8247q.remove(yVar);
        kVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f8219d.getClass();
    }
}
