package p110o5;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import p067j0.b;
import p067j0.c;

/* JADX INFO: compiled from: AnimationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f20703a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f20704b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p067j0.a f20705c = new p067j0.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f20706d = new c(c.f19835c);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f20707e = new DecelerateInterpolator();

    public static float a(float f6, float f9, float f10) {
        return ((f9 - f6) * f10) + f6;
    }

    public static float b(float f6, float f9, float f10, float f11, float f12) {
        if (f12 <= f10) {
            return f6;
        }
        return f12 >= f11 ? f9 : a(f6, f9, (f12 - f10) / (f11 - f10));
    }

    public static int c(int i9, int i10, float f6) {
        return Math.round(f6 * (i10 - i9)) + i9;
    }
}
