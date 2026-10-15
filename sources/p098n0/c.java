package p098n0;

import G.w;
import G.x;
import android.app.Notification;
import android.os.Build;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends w {
    @Override // G.w
    public final void b(x xVar) {
        int i9 = Build.VERSION.SDK_INT;
        Notification.Builder builder = xVar.f2183b;
        if (i9 >= 34) {
            a.d(builder, a.b(b.a(a.a(), null, 0, null, Boolean.FALSE), null, null));
        } else {
            a.d(builder, a.b(a.a(), null, null));
        }
    }
}
