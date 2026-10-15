package p164v0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import p155u.a;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f21826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f21827b;

    public h(g gVar, a aVar) {
        this.f21827b = gVar;
        this.f21826a = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f21826a.remove(animator);
        this.f21827b.f21804n.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f21827b.f21804n.add(animator);
    }
}
