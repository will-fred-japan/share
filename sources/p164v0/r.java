package p164v0;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi21.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f21854d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f21855e = true;

    /* JADX INFO: compiled from: ViewUtilsApi21.java */
    public static class a {
        public static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        public static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        public static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    @SuppressLint({"NewApi"})
    public void d(View view, Matrix matrix) {
        if (f21854d) {
            try {
                a.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f21854d = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void e(View view, Matrix matrix) {
        if (f21855e) {
            try {
                a.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f21855e = false;
            }
        }
    }
}
