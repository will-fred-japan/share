package T;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class V extends p027d5.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Window f4398i;

    public V(Window window, C0437y c0437y) {
        this.f4398i = window;
    }

    public final void F(int i9) {
        View decorView = this.f4398i.getDecorView();
        decorView.setSystemUiVisibility(i9 | decorView.getSystemUiVisibility());
    }

    public final void G(int i9) {
        View decorView = this.f4398i.getDecorView();
        decorView.setSystemUiVisibility((~i9) & decorView.getSystemUiVisibility());
    }
}
