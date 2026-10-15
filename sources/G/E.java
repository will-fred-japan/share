package G;

import android.app.Notification;
import com.starburst.sdk.core.keepalive.KeepAliveManager;

/* JADX INFO: compiled from: ServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class E {
    public static void a(KeepAliveManager.KeepAliveService keepAliveService, Notification notification, int i9) {
        if (i9 == 0 || i9 == -1) {
            keepAliveService.startForeground(1001, notification, i9);
        } else {
            keepAliveService.startForeground(1001, notification, i9 & 255);
        }
    }
}
