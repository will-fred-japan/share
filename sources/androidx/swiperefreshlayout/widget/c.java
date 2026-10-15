package androidx.swiperefreshlayout.widget;

import android.animation.Animator;

/* JADX INFO: compiled from: CircularProgressDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f8372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f8373b;

    public c(d dVar, d.a aVar) {
        this.f8373b = dVar;
        this.f8372a = aVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        d dVar = this.f8373b;
        d.a aVar = this.f8372a;
        dVar.a(1.0f, aVar, true);
        aVar.f8392k = aVar.f8387e;
        aVar.f8393l = aVar.f8388f;
        aVar.f8394m = aVar.f8389g;
        aVar.a((aVar.j + 1) % aVar.f8391i.length);
        if (!dVar.f8382f) {
            dVar.f8381e += 1.0f;
            return;
        }
        dVar.f8382f = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        if (aVar.f8395n) {
            aVar.f8395n = false;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f8373b.f8381e = 0.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }
}
