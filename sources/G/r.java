package G;

import android.app.Notification;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class r extends w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<CharSequence> f2153e = new ArrayList<>();

    @Override // G.w
    public final void b(x xVar) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(xVar.f2183b).setBigContentTitle(this.f2179b);
        if (this.f2181d) {
            bigContentTitle.setSummaryText(this.f2180c);
        }
        Iterator<CharSequence> it = this.f2153e.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    @Override // G.w
    public final String c() {
        return "androidx.core.app.NotificationCompat$InboxStyle";
    }

    @Override // G.w
    public final void d(Bundle bundle) {
        super.d(bundle);
        ArrayList<CharSequence> arrayList = this.f2153e;
        arrayList.clear();
        if (bundle.containsKey("android.textLines")) {
            Collections.addAll(arrayList, bundle.getCharSequenceArray("android.textLines"));
        }
    }
}
