package T;

import android.os.Build;
import android.view.Display;
import android.view.RoundedCorner;

/* JADX INFO: renamed from: T.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DisplayCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0418e {
    public static C0435w a(Display display, int i9) {
        RoundedCorner roundedCorner;
        int i10;
        if (Build.VERSION.SDK_INT < 31 || (roundedCorner = display.getRoundedCorner(i9)) == null) {
            return null;
        }
        int position = roundedCorner.getPosition();
        if (position != 0) {
            i10 = 1;
            if (position != 1) {
                i10 = 2;
                if (position != 2) {
                    i10 = 3;
                    if (position != 3) {
                        throw new IllegalArgumentException(W5.e.i(position, "Invalid position: "));
                    }
                }
            }
        } else {
            i10 = 0;
        }
        return new C0435w(i10, roundedCorner.getRadius(), roundedCorner.getCenter());
    }
}
