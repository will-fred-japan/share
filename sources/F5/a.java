package F5;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* JADX INFO: compiled from: RippleUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f2040a = {R.attr.state_pressed};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f2041b = {R.attr.state_focused};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f2042c = {R.attr.state_selected, R.attr.state_pressed};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f2043d = {R.attr.state_selected};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f2044e = {R.attr.state_enabled, R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f2045f = a.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        int[] iArr = f2041b;
        return new ColorStateList(new int[][]{f2043d, iArr, StateSet.NOTHING}, new int[]{b(colorStateList, f2042c), b(colorStateList, iArr), b(colorStateList, f2040a)});
    }

    public static int b(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return K.a.e(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f2044e, 0)) != 0) {
            Log.w(f2045f, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean d(int[] iArr) {
        boolean z8 = false;
        boolean z9 = false;
        for (int i9 : iArr) {
            if (i9 == 16842910) {
                z8 = true;
            } else if (i9 == 16842908 || i9 == 16842919 || i9 == 16843623) {
                z9 = true;
            }
        }
        return z8 && z9;
    }
}
