package Q4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class E extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f3757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A6.e f3758b;

    public E(A6.e eVar) {
        this.f3758b = eVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            Object obj = this.f3758b.f1504b;
            throw null;
        }
    }
}
