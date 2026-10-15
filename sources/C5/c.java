package C5;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Path;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: compiled from: MotionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static float a(String[] strArr, int i9) {
        float f6 = Float.parseFloat(strArr[i9]);
        if (f6 >= 0.0f && f6 <= 1.0f) {
            return f6;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f6);
    }

    public static boolean b(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static int c(Context context, int i9, int i10) {
        TypedValue typedValueA = E5.b.a(context, i9);
        return (typedValueA == null || typedValueA.type != 16) ? i10 : typedValueA.data;
    }

    public static TimeInterpolator d(Context context, int i9, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i9, typedValue, true)) {
            return interpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!b(strValueOf, "cubic-bezier") && !b(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (b(strValueOf, "cubic-bezier")) {
            String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (strArrSplit.length == 4) {
                return new PathInterpolator(a(strArrSplit, 0), a(strArrSplit, 1), a(strArrSplit, 2), a(strArrSplit, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
        }
        if (!b(strValueOf, "path")) {
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String strH = A.a.h(1, 5, strValueOf);
        Path path = new Path();
        try {
            K.c.a.b(K.c.b(strH), path);
            return new PathInterpolator(path);
        } catch (RuntimeException e9) {
            throw new RuntimeException("Error in parsing ".concat(strH), e9);
        }
    }
}
