package G;

import android.app.Notification;
import android.content.Context;
import com.starburst.sdk.core.keepalive.KeepAliveManager;

/* JADX INFO: renamed from: G.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppOpsManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0316g {
    public static String a(Context context) {
        return context.getOpPackageName();
    }

    public static void b(KeepAliveManager.KeepAliveService keepAliveService, Notification notification, int i9) {
        if (i9 == 0 || i9 == -1) {
            keepAliveService.startForeground(1001, notification, i9);
        } else {
            keepAliveService.startForeground(1001, notification, i9 & 1073745919);
        }
    }
}
