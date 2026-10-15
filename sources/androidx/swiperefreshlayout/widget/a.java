package androidx.swiperefreshlayout.widget;

import android.graphics.drawable.ShapeDrawable;
import android.view.animation.Animation;
import android.widget.ImageView;

/* JADX INFO: compiled from: CircleImageView.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animation.AnimationListener f8368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8369b;

    @Override // android.view.View
    public final void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f8368a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public final void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f8368a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i9) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i9);
            this.f8369b = i9;
        }
    }
}
