package p067j0;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: LookupTableInterpolator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f19836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f19837b;

    public d(float[] fArr) {
        this.f19836a = fArr;
        this.f19837b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f6) {
        if (f6 >= 1.0f) {
            return 1.0f;
        }
        if (f6 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f19836a;
        int iMin = Math.min((int) ((fArr.length - 1) * f6), fArr.length - 2);
        float f9 = this.f19837b;
        float f10 = (f6 - (iMin * f9)) / f9;
        float f11 = fArr[iMin];
        return ((fArr[iMin + 1] - f11) * f10) + f11;
    }
}
