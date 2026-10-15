package T;

import android.os.Build;
import android.view.View;

/* JADX INFO: renamed from: T.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SoftwareKeyboardControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0437y {

    /* JADX INFO: renamed from: T.y$a */
    /* JADX INFO: compiled from: SoftwareKeyboardControllerCompat.java */
    public static class a extends c {
        public a(View view) {
        }
    }

    /* JADX INFO: renamed from: T.y$b */
    /* JADX INFO: compiled from: SoftwareKeyboardControllerCompat.java */
    public static class b extends a {
    }

    /* JADX INFO: renamed from: T.y$c */
    /* JADX INFO: compiled from: SoftwareKeyboardControllerCompat.java */
    public static class c {
    }

    public C0437y(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            new b(view);
        } else {
            new a(view);
        }
    }
}
