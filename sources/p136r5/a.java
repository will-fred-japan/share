package p136r5;

import H5.h;
import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: BottomSheetBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f21152a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f21152a = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        h hVar = this.f21152a.f12994i;
        if (hVar != null) {
            h.b bVar = hVar.f2420a;
            if (bVar.f2450i != fFloatValue) {
                bVar.f2450i = fFloatValue;
                hVar.f2424e = true;
                hVar.invalidateSelf();
            }
        }
    }
}
