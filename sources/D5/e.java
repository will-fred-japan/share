package D5;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.ArrayList;

/* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends Drawable implements Animatable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f1929f = new a(Float.class, "growFraction");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObjectAnimator f1930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObjectAnimator f1931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f1932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1934e;

    /* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
    public class a extends Property<e, Float> {
        @Override // android.util.Property
        public final Float get(e eVar) {
            eVar.getClass();
            throw null;
        }

        @Override // android.util.Property
        public final void set(e eVar, Float f6) {
            e eVar2 = eVar;
            float fFloatValue = f6.floatValue();
            if (eVar2.f1933d != fFloatValue) {
                eVar2.f1933d = fFloatValue;
                eVar2.invalidateSelf();
            }
        }
    }

    public boolean b(boolean z8) {
        int i9 = 0;
        ObjectAnimator objectAnimator = this.f1930a;
        a aVar = f1929f;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, aVar, 0.0f, 1.0f);
            this.f1930a = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f1930a.setInterpolator(p110o5.a.f20704b);
            ObjectAnimator objectAnimator2 = this.f1930a;
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.f1930a = objectAnimator2;
            objectAnimator2.addListener(new c(i9, this));
        }
        if (this.f1931b == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, aVar, 1.0f, 0.0f);
            this.f1931b = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f1931b.setInterpolator(p110o5.a.f20704b);
            ObjectAnimator objectAnimator3 = this.f1931b;
            if (objectAnimator3 != null && objectAnimator3.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.f1931b = objectAnimator3;
            objectAnimator3.addListener(new d(i9, this));
        }
        if (!isVisible() && !z8) {
            return false;
        }
        ObjectAnimator objectAnimator4 = z8 ? this.f1930a : this.f1931b;
        ObjectAnimator objectAnimator5 = z8 ? this.f1931b : this.f1930a;
        if (objectAnimator5.isRunning()) {
            new ValueAnimator[]{objectAnimator5}[0].cancel();
        }
        if (objectAnimator4.isRunning()) {
            objectAnimator4.end();
        } else {
            new ValueAnimator[]{objectAnimator4}[0].end();
        }
        return super.setVisible(z8, false);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f1934e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ObjectAnimator objectAnimator = this.f1930a;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return true;
        }
        ObjectAnimator objectAnimator2 = this.f1931b;
        return objectAnimator2 != null && objectAnimator2.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        this.f1934e = i9;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        throw null;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        b(true);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        b(false);
    }
}
