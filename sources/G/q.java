package G;

import android.app.Notification;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class q extends w {

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class a {
        public static Notification.Style a() {
            return new Notification.DecoratedCustomViewStyle();
        }
    }

    @Override // G.w
    public final void b(x xVar) {
        xVar.f2183b.setStyle(a.a());
    }

    @Override // G.w
    public final String c() {
        return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
    }
}
