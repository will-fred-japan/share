package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.y f8224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f8226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f8227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f8228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k f8229f;

    public h(k kVar, RecyclerView.y yVar, int i9, View view, int i10, ViewPropertyAnimator viewPropertyAnimator) {
        this.f8229f = kVar;
        this.f8224a = yVar;
        this.f8225b = i9;
        this.f8226c = view;
        this.f8227d = i10;
        this.f8228e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i9 = this.f8225b;
        View view = this.f8226c;
        if (i9 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f8227d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f8228e.setListener(null);
        k kVar = this.f8229f;
        RecyclerView.y yVar = this.f8224a;
        kVar.c(yVar);
        kVar.f8246p.remove(yVar);
        kVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f8229f.getClass();
    }
}
