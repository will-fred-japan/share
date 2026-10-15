package K0;

import android.app.ApplicationExitInfo;
import android.view.WindowInsetsAnimation;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ ApplicationExitInfo e(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    public static /* synthetic */ WindowInsetsAnimation i(int i9, Interpolator interpolator, long j) {
        return new WindowInsetsAnimation(i9, interpolator, j);
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionInfo k(int i9) {
        return new AccessibilityNodeInfo.CollectionInfo(i9, 1, false);
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionItemInfo l(int i9, boolean z8) {
        return new AccessibilityNodeInfo.CollectionItemInfo(0, 1, i9, 1, z8);
    }
}
