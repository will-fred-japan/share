package T;

import android.view.Window;

/* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class X extends W {
    @Override // p027d5.a
    public final void x(boolean z8) {
        if (!z8) {
            G(16);
            return;
        }
        Window window = this.f4398i;
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        F(16);
    }
}
