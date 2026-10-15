package cn.jpush.android.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.view.View;
import cn.jpush.android.helper.Logger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: cn.jpush.android.r.a$a, reason: collision with other inner class name */
    public interface InterfaceC0145a {
        void a();
    }

    public static void a(View view, Point point, long j, final InterfaceC0145a interfaceC0145a) {
        if (view == null) {
            Logger.w("InAppAnimator", "[slideOutOfView] view is null");
        } else {
            view.animate().translationX(point.x).translationY(point.y).setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    try {
                        InterfaceC0145a interfaceC0145a2 = interfaceC0145a;
                        if (interfaceC0145a2 != null) {
                            interfaceC0145a2.a();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void a(final View view, Point point, final Point point2, final long j, final InterfaceC0145a interfaceC0145a) {
        if (view == null) {
            Logger.w("InAppAnimator", "[slideIntoView] view is null");
        } else {
            view.setAlpha(0.0f);
            view.animate().translationX(point.x).translationY(point.y).setDuration(10L).setListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.a.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    try {
                        view.animate().translationX(point2.x).translationY(point2.y).alpha(1.0f).setDuration(j).setListener(null);
                        InterfaceC0145a interfaceC0145a2 = interfaceC0145a;
                        if (interfaceC0145a2 != null) {
                            interfaceC0145a2.a();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
