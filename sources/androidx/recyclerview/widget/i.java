package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.a f8230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f8231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f8232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f8233d;

    public i(k kVar, k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f8233d = kVar;
        this.f8230a = aVar;
        this.f8231b = viewPropertyAnimator;
        this.f8232c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f8231b.setListener(null);
        View view = this.f8232c;
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        k.a aVar = this.f8230a;
        RecyclerView.y yVar = aVar.f8249a;
        k kVar = this.f8233d;
        kVar.c(yVar);
        kVar.f8248r.remove(aVar.f8249a);
        kVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        RecyclerView.y yVar = this.f8230a.f8249a;
        this.f8233d.getClass();
    }
}
