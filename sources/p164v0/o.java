package p164v0;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ViewGroupUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21848a = true;

    /* JADX INFO: compiled from: ViewGroupUtils.java */
    public static class a {
        public static int a(ViewGroup viewGroup, int i9) {
            return viewGroup.getChildDrawingOrder(i9);
        }

        public static void b(ViewGroup viewGroup, boolean z8) {
            viewGroup.suppressLayout(z8);
        }
    }

    public static void a(ViewGroup viewGroup, boolean z8) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.b(viewGroup, z8);
        } else if (f21848a) {
            try {
                a.b(viewGroup, z8);
            } catch (NoSuchMethodError unused) {
                f21848a = false;
            }
        }
    }
}
