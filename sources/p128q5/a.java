package p128q5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;

/* JADX INFO: compiled from: HideBottomViewOnScrollBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HideBottomViewOnScrollBehavior f20985a;

    public a(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.f20985a = hideBottomViewOnScrollBehavior;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f20985a.f12906h = null;
    }
}
