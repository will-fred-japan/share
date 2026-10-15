package p164v0;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: ViewUtilsApi19.java */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21851a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f21852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f21853c;

    /* JADX INFO: compiled from: ViewUtilsApi19.java */
    public static class a {
        public static float a(View view) {
            return view.getTransitionAlpha();
        }

        public static void b(View view, float f6) {
            view.setTransitionAlpha(f6);
        }
    }

    @SuppressLint({"NewApi"})
    public float a(View view) {
        if (f21851a) {
            try {
                return a.a(view);
            } catch (NoSuchMethodError unused) {
                f21851a = false;
            }
        }
        return view.getAlpha();
    }

    @SuppressLint({"NewApi"})
    public void b(View view, float f6) {
        if (f21851a) {
            try {
                a.b(view, f6);
                return;
            } catch (NoSuchMethodError unused) {
                f21851a = false;
            }
        }
        view.setAlpha(f6);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public void c(View view, int i9) {
        if (!f21853c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f21852b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f21853c = true;
        }
        Field field = f21852b;
        if (field != null) {
            try {
                f21852b.setInt(view, i9 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }
}
