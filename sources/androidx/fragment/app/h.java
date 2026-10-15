package androidx.fragment.app;

import T.ViewTreeObserverOnPreDrawListenerC0434v;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: FragmentAnim.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static int a(Context context, int i9) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i9});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    /* JADX INFO: compiled from: FragmentAnim.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f7620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AnimatorSet f7621b;

        public a(Animation animation) {
            this.f7620a = animation;
            this.f7621b = null;
        }

        public a(Animator animator) {
            this.f7620a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.f7621b = animatorSet;
            animatorSet.play(animator);
        }
    }

    /* JADX INFO: compiled from: FragmentAnim.java */
    public static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f7622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f7623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7626e;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f7626e = true;
            this.f7622a = viewGroup;
            this.f7623b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public final boolean getTransformation(long j, Transformation transformation) {
            this.f7626e = true;
            if (this.f7624c) {
                return !this.f7625d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f7624c = true;
                ViewTreeObserverOnPreDrawListenerC0434v.a(this.f7622a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z8 = this.f7624c;
            ViewGroup viewGroup = this.f7622a;
            if (z8 || !this.f7626e) {
                viewGroup.endViewTransition(this.f7623b);
                this.f7625d = true;
            } else {
                this.f7626e = false;
                viewGroup.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public final boolean getTransformation(long j, Transformation transformation, float f6) {
            this.f7626e = true;
            if (this.f7624c) {
                return !this.f7625d;
            }
            if (!super.getTransformation(j, transformation, f6)) {
                this.f7624c = true;
                ViewTreeObserverOnPreDrawListenerC0434v.a(this.f7622a, this);
            }
            return true;
        }
    }
}
