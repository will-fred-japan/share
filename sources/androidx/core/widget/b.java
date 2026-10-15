package androidx.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* JADX INFO: compiled from: EdgeEffectCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: EdgeEffectCompat.java */
    public static class a {
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f6, float f9) {
            try {
                return edgeEffect.onPullDistance(f6, f9);
            } catch (Throwable unused) {
                edgeEffect.onPull(f6, f9);
                return 0.0f;
            }
        }
    }

    public static float a(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return a.b(edgeEffect);
        }
        return 0.0f;
    }

    public static float b(EdgeEffect edgeEffect, float f6, float f9) {
        if (Build.VERSION.SDK_INT >= 31) {
            return a.c(edgeEffect, f6, f9);
        }
        edgeEffect.onPull(f6, f9);
        return f6;
    }
}
