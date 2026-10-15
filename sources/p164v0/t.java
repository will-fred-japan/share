package p164v0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi23.java */
/* JADX INFO: loaded from: classes.dex */
public class t extends s {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f21857g = true;

    /* JADX INFO: compiled from: ViewUtilsApi23.java */
    public static class a {
        public static void a(View view, int i9) {
            view.setTransitionVisibility(i9);
        }
    }

    @Override // p164v0.q
    @SuppressLint({"NewApi"})
    public void c(View view, int i9) {
        if (Build.VERSION.SDK_INT == 28) {
            super.c(view, i9);
        } else if (f21857g) {
            try {
                a.a(view, i9);
            } catch (NoSuchMethodError unused) {
                f21857g = false;
            }
        }
    }
}
