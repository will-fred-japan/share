package p186x5;

import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import java.util.Arrays;

/* JADX INFO: compiled from: DrawableUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: x5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DrawableUtils.java */
    public static class C0282a {
        public static void a(Outline outline, Path path) {
            outline.setConvexPath(path);
        }
    }

    /* JADX INFO: compiled from: DrawableUtils.java */
    public static class b {
        public static void a(Outline outline, Path path) {
            outline.setPath(path);
        }
    }

    public static Drawable a(Drawable drawable, Drawable drawable2, int i9, int i10) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        if (i9 == -1 && (i9 = drawable2.getIntrinsicWidth()) == -1) {
            i9 = drawable.getIntrinsicWidth();
        }
        if (i10 == -1 && (i10 = drawable2.getIntrinsicHeight()) == -1) {
            i10 = drawable.getIntrinsicHeight();
        }
        if (i9 > drawable.getIntrinsicWidth() || i10 > drawable.getIntrinsicHeight()) {
            float f6 = i9 / i10;
            if (f6 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                i10 = (int) (intrinsicWidth / f6);
                i9 = intrinsicWidth;
            } else {
                i10 = drawable.getIntrinsicHeight();
                i9 = (int) (f6 * i10);
            }
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        layerDrawable.setLayerSize(1, i9, i10);
        layerDrawable.setLayerGravity(1, 17);
        return layerDrawable;
    }

    public static Drawable b(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            drawable = drawable.mutate();
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        return drawable;
    }

    public static int[] c(int[] iArr) {
        for (int i9 = 0; i9 < iArr.length; i9++) {
            int i10 = iArr[i9];
            if (i10 == 16842912) {
                return iArr;
            }
            if (i10 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i9] = 16842912;
                return iArr2;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArr.length] = 16842912;
        return iArrCopyOf;
    }

    public static ColorStateList d(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !com.huawei.hms.framework.common.a.m(drawable)) {
            return null;
        }
        return e6.a.a(drawable).getColorStateList();
    }
}
