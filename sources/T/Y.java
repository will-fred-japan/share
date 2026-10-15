package T;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class Y extends p027d5.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WindowInsetsController f4399i;
    public Window j;

    public Y(WindowInsetsController windowInsetsController, C0437y c0437y) {
        new p155u.g();
        this.f4399i = windowInsetsController;
    }

    public final void F(int i9, int i10, boolean z8) {
        Window window = this.j;
        if (window == null) {
            if (z8) {
                this.f4399i.setSystemBarsAppearance(i10, i10);
                return;
            } else {
                this.f4399i.setSystemBarsAppearance(0, i10);
                return;
            }
        }
        if (z8) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(i9 | decorView.getSystemUiVisibility());
        } else {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility((~i9) & decorView2.getSystemUiVisibility());
        }
    }

    @Override // p027d5.a
    public void x(boolean z8) {
        F(16, 16, z8);
    }

    @Override // p027d5.a
    public void y(boolean z8) {
        F(8192, 8, z8);
    }
}
