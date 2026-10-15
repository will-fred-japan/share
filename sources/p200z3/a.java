package p200z3;

import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: compiled from: AbnormalManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p193y3.a f22497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22499c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public final boolean a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f22499c;
        if (j == 0 || jElapsedRealtime - j >= com.heytap.mcssdk.constant.a.f14256r) {
            this.f22499c = jElapsedRealtime;
            p193y3.a aVar = this.f22497a;
            A3.a aVar2 = aVar.f22373a;
            aVar2.c();
            float f6 = aVar2.f1450g;
            A3.a aVar3 = aVar.f22373a;
            aVar3.c();
            int i9 = aVar3.f1449f;
            A3.a aVar4 = aVar.f22373a;
            aVar4.getClass();
            PowerManager powerManager = aVar4.f1446c;
            ?? IsPowerSaveMode = powerManager != null ? powerManager.isPowerSaveMode() : -1;
            aVar.f22377e.getClass();
            boolean z8 = f6 <= ((float) 37);
            aVar.f22377e.getClass();
            if (i9 < 30) {
                z8 = false;
            }
            boolean z9 = IsPowerSaveMode != 1 ? z8 : false;
            String str = "updateCpuSampleEnvironment:" + z9 + ", temp:" + f6 + ", level:" + i9 + ", powerSave:" + IsPowerSaveMode;
            boolean z10 = D3.a.f1909a;
            Log.i("watson_assist", str);
            this.f22498b = z9;
        }
        return this.f22498b;
    }
}
