package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f12949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f12951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f12952e;

    public c(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i9, boolean z8) {
        this.f12952e = bottomAppBar;
        this.f12949b = actionMenuView;
        this.f12950c = i9;
        this.f12951d = z8;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f12948a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f12948a) {
            return;
        }
        this.f12952e.E(this.f12949b, this.f12950c, this.f12951d, false);
    }
}
