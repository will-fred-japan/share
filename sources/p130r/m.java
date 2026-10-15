package p130r;

import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: PrefetchOptions.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static void a(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 33) {
        }
        bundle.getBoolean("androidx.browser.customtabs.PrefetchOptions.KEY_REQUIRES_ANONYMOUS_IP_WHEN_CROSS_ORIGIN");
    }
}
