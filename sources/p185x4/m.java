package p185x4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import p096m7.d;

/* JADX INFO: compiled from: LocationServiceStatusReceiver.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.b.a f22332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f22333b;

    public m(d.b.a aVar) {
        this.f22332a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.location.PROVIDERS_CHANGED".equals(intent.getAction())) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
            q qVar = q.f22345a;
            q qVar2 = q.f22346b;
            d.b.a aVar = this.f22332a;
            if (zIsProviderEnabled || zIsProviderEnabled2) {
                q qVar3 = this.f22333b;
                if (qVar3 == null || qVar3 == qVar) {
                    this.f22333b = qVar2;
                    aVar.success(1);
                    return;
                }
                return;
            }
            q qVar4 = this.f22333b;
            if (qVar4 == null || qVar4 == qVar2) {
                this.f22333b = qVar;
                aVar.success(0);
            }
        }
    }
}
