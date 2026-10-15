package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f6465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f6466c;

    /* JADX INFO: compiled from: ViewUtils.java */
    public static class a {
        public static void a(View view, Rect rect, Rect rect2) {
            Insets systemWindowInsets = view.computeSystemWindowInsets(new WindowInsets.Builder().setSystemWindowInsets(Insets.of(rect)).build(), rect2).getSystemWindowInsets();
            rect.set(systemWindowInsets.left, systemWindowInsets.top, systemWindowInsets.right, systemWindowInsets.bottom);
        }
    }

    static {
        f6466c = Build.VERSION.SDK_INT >= 27;
    }
}
