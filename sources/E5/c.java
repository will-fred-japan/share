package E5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.K;
import p056h5.C0598e;

/* JADX INFO: compiled from: MaterialResources.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i9) {
        int resourceId;
        ColorStateList colorStateListB;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0 || (colorStateListB = I.a.b(context, resourceId)) == null) ? typedArray.getColorStateList(i9) : colorStateListB;
    }

    public static ColorStateList b(Context context, K k7, int i9) {
        int resourceId;
        ColorStateList colorStateListB;
        TypedArray typedArray = k7.f6420b;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0 || (colorStateListB = I.a.b(context, resourceId)) == null) ? k7.a(i9) : colorStateListB;
    }

    public static Drawable c(Context context, TypedArray typedArray, int i9) {
        int resourceId;
        Drawable drawableV;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0 || (drawableV = C0598e.v(context, resourceId)) == null) ? typedArray.getDrawable(i9) : drawableV;
    }

    public static boolean d(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }
}
