package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.a f8234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f8235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f8236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f8237d;

    public j(k kVar, k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f8237d = kVar;
        this.f8234a = aVar;
        this.f8235b = viewPropertyAnimator;
        this.f8236c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f8235b.setListener(null);
        View view = this.f8236c;
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        k.a aVar = this.f8234a;
        RecyclerView.y yVar = aVar.f8250b;
        k kVar = this.f8237d;
        kVar.c(yVar);
        kVar.f8248r.remove(aVar.f8250b);
        kVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        RecyclerView.y yVar = this.f8234a.f8250b;
        this.f8237d.getClass();
    }
}
