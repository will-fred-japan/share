package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f12944b;

    public /* synthetic */ a(BottomAppBar bottomAppBar, int i9) {
        this.f12943a = i9;
        this.f12944b = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f12943a) {
            case 0:
                BottomAppBar bottomAppBar = this.f12944b;
                int i9 = BottomAppBar.f12921t0;
                bottomAppBar.f12923V = null;
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f12943a) {
            case 0:
                int i9 = BottomAppBar.f12921t0;
                return;
            default:
                this.f12944b.getClass();
                throw null;
        }
    }
}
