package p164v0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f21828a;

    public i(g gVar) {
        this.f21828a = gVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f21828a.l();
        animator.removeListener(this);
    }
}
