package T;

import android.view.ViewConfiguration;

/* JADX INFO: compiled from: ViewConfigurationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class I {
    public static int a(ViewConfiguration viewConfiguration, int i9, int i10, int i11) {
        return viewConfiguration.getScaledMaximumFlingVelocity(i9, i10, i11);
    }

    public static int b(ViewConfiguration viewConfiguration, int i9, int i10, int i11) {
        return viewConfiguration.getScaledMinimumFlingVelocity(i9, i10, i11);
    }
}
