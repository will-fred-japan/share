package p106o0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.window.BackEvent;

/* JADX INFO: compiled from: NavigationEvent.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    @SuppressLint({"WrongConstant"})
    public static final b a(BackEvent backEvent) {
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        return new b(backEvent.getSwipeEdge(), backEvent.getProgress(), touchX, touchY, Build.VERSION.SDK_INT >= 36 ? backEvent.getFrameTimeMillis() : 0L);
    }
}
