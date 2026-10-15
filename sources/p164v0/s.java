package p164v0;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi22.java */
/* JADX INFO: loaded from: classes.dex */
public class s extends r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f21856f = true;

    /* JADX INFO: compiled from: ViewUtilsApi22.java */
    public static class a {
        public static void a(View view, int i9, int i10, int i11, int i12) {
            view.setLeftTopRightBottom(i9, i10, i11, i12);
        }
    }

    @SuppressLint({"NewApi"})
    public void f(View view, int i9, int i10, int i11, int i12) {
        if (f21856f) {
            try {
                a.a(view, i9, i10, i11, i12);
            } catch (NoSuchMethodError unused) {
                f21856f = false;
            }
        }
    }
}
