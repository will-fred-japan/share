package E5;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;

/* JADX INFO: compiled from: TypefaceUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static Typeface a(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, p027d5.a.n(configuration.fontWeightAdjustment + typeface.getWeight(), 1, 1000), typeface.isItalic());
    }
}
