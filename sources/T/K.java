package T;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class K implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4333b;

    public /* synthetic */ K(androidx.appcompat.app.s.c cVar, View view) {
        this.f4332a = 0;
        this.f4333b = cVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f4332a) {
            case 0:
                ((View) ((androidx.appcompat.app.s.c) this.f4333b).f6036a.f6014d.getParent()).invalidate();
                break;
            case 1:
                com.google.android.material.textfield.c cVar = (com.google.android.material.textfield.c) this.f4333b;
                cVar.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CheckableImageButton checkableImageButton = cVar.f13898d;
                checkableImageButton.setScaleX(fFloatValue);
                checkableImageButton.setScaleY(fFloatValue);
                break;
            default:
                com.google.android.material.textfield.i iVar = (com.google.android.material.textfield.i) this.f4333b;
                iVar.getClass();
                iVar.f13898d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }

    public /* synthetic */ K(com.google.android.material.textfield.k kVar, int i9) {
        this.f4332a = i9;
        this.f4333b = kVar;
    }
}
