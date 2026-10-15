package G;

import android.app.Notification;
import android.os.Bundle;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f2110e;

    @Override // G.w
    public final void b(x xVar) {
        Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(xVar.f2183b).setBigContentTitle(this.f2179b).bigText(this.f2110e);
        if (this.f2181d) {
            bigTextStyleBigText.setSummaryText(this.f2180c);
        }
    }

    @Override // G.w
    public final String c() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }

    @Override // G.w
    public final void d(Bundle bundle) {
        super.d(bundle);
        this.f2110e = bundle.getCharSequence("android.bigText");
    }
}
