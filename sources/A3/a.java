package A3;

import Z.Y;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.SystemClock;

/* JADX INFO: compiled from: BatteryInfoManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PowerManager f1446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BatteryManager f1447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1451h;

    public final synchronized void c() {
        boolean z8;
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f1451h;
            if (j == 0 || jElapsedRealtime - j >= com.heytap.mcssdk.constant.a.f14256r) {
                this.f1451h = jElapsedRealtime;
                Intent intentRegisterReceiver = ((Context) this.f5347a).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver == null) {
                    return;
                }
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                if (intExtra == 2) {
                    z8 = true;
                } else {
                    if (intExtra == 5) {
                        BatteryManager batteryManager = this.f1447d;
                        if (batteryManager != null ? batteryManager.isCharging() : false) {
                            z8 = true;
                        }
                    }
                    z8 = false;
                }
                this.f1448e = z8;
                this.f1449f = intentRegisterReceiver.getIntExtra("level", 0);
                this.f1450g = intentRegisterReceiver.getIntExtra("temperature", 0) / 10.0f;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
