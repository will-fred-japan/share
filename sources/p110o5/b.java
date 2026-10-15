package p110o5;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import p155u.g;

/* JADX INFO: compiled from: MotionSpec.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<String, c> f20708a = new g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g<String, PropertyValuesHolder[]> f20709b = new g<>();

    public static b a(Context context, int i9) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i9);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return b(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return b(arrayList);
        } catch (Exception e9) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i9), e9);
            return null;
        }
    }

    public static b b(ArrayList arrayList) {
        b bVar = new b();
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            Animator animator = (Animator) arrayList.get(i9);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            bVar.f20709b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = a.f20704b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = a.f20705c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = a.f20706d;
            }
            c cVar = new c();
            cVar.f20713d = 0;
            cVar.f20714e = 1;
            cVar.f20710a = startDelay;
            cVar.f20711b = duration;
            cVar.f20712c = interpolator;
            cVar.f20713d = objectAnimator.getRepeatCount();
            cVar.f20714e = objectAnimator.getRepeatMode();
            bVar.f20708a.put(propertyName, cVar);
        }
        return bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f20708a.equals(((b) obj).f20708a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f20708a.hashCode();
    }

    public final String toString() {
        return "\n" + b.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f20708a + "}\n";
    }
}
