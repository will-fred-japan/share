package T;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: WindowCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class N {
    public static void a(Window window, boolean z8) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z8 ? systemUiVisibility & (-257) : systemUiVisibility | 256);
        window.setDecorFitsSystemWindows(z8);
    }
}
