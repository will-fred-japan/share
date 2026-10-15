package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: CircularProgressDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f8370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f8371b;

    public b(d dVar, d.a aVar) {
        this.f8371b = dVar;
        this.f8370a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        d dVar = this.f8371b;
        dVar.getClass();
        d.a aVar = this.f8370a;
        d.d(fFloatValue, aVar);
        dVar.a(fFloatValue, aVar, false);
        dVar.invalidateSelf();
    }
}
