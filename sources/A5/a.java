package A5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.material.floatingactionbutton.a f1481c;

    public a(com.google.android.material.floatingactionbutton.b bVar, boolean z8, com.google.android.material.floatingactionbutton.a aVar) {
        this.f1480b = z8;
        this.f1481c = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f1479a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        throw null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        throw null;
    }
}
