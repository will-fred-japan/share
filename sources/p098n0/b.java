package p098n0;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    @SuppressLint({"MissingPermission"})
    public static Notification.MediaStyle a(Notification.MediaStyle mediaStyle, CharSequence charSequence, int i9, PendingIntent pendingIntent, Boolean bool) {
        if (bool.booleanValue()) {
            mediaStyle.setRemotePlaybackInfo(charSequence, i9, pendingIntent);
        }
        return mediaStyle;
    }
}
