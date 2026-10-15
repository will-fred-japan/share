package D5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

/* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1928b;

    public /* synthetic */ d(int i9, Object obj) {
        this.f1927a = i9;
        this.f1928b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Object obj = this.f1928b;
        switch (this.f1927a) {
            case 0:
                super.onAnimationEnd(animator);
                super/*android.graphics.drawable.Drawable*/.setVisible(false, false);
                break;
            case 1:
                int i9 = BottomAppBar.f12921t0;
                ((BottomAppBar) obj).f12924W = null;
                break;
            default:
                ((com.google.android.material.textfield.c) obj).f13896b.h(false);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f1927a) {
            case 1:
                int i9 = BottomAppBar.f12921t0;
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
