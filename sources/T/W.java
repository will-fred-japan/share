package T;

import android.view.Window;

/* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class W extends V {
    @Override // p027d5.a
    public final void y(boolean z8) {
        if (!z8) {
            G(8192);
            return;
        }
        Window window = this.f4398i;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        F(8192);
    }
}
