package com.engagelab.privates.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.view.View;
import com.engagelab.privates.common.log.MTCommonLog;

/* JADX INFO: loaded from: classes.dex */
public class e0 {

    public static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12197a;

        public a(c cVar) {
            this.f12197a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            try {
                c cVar = this.f12197a;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Point f12199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f12200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f12201d;

        public b(View view, Point point, long j, c cVar) {
            this.f12198a = view;
            this.f12199b = point;
            this.f12200c = j;
            this.f12201d = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            try {
                this.f12198a.animate().translationX(this.f12199b.x).translationY(this.f12199b.y).alpha(1.0f).setDuration(this.f12200c).setListener(null);
                c cVar = this.f12201d;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public interface c {
        void a();
    }

    public static void a(View view, Point point, long j, c cVar) {
        if (view == null) {
            MTCommonLog.w("InAppAnimator", "[slideOutOfView] view is null");
        } else {
            view.animate().translationX(point.x).translationY(point.y).setDuration(j).setListener(new a(cVar));
        }
    }

    public static void a(View view, Point point, Point point2, long j, c cVar) {
        if (view == null) {
            MTCommonLog.w("InAppAnimator", "[slideIntoView] view is null");
        } else {
            view.setAlpha(0.0f);
            view.animate().translationX(point.x).translationY(point.y).setDuration(10L).setListener(new b(view, point2, j, cVar));
        }
    }
}
