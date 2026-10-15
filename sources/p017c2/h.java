package p017c2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import p199z2.b;

/* JADX INFO: compiled from: TemperatureDataManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f8757a;

    public h(i iVar) {
        this.f8757a = iVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        float intExtra = intent.getIntExtra("temperature", 0) / 10.0f;
        i iVar = this.f8757a;
        iVar.f8761d = intExtra;
        iVar.f8762e = intent.getIntExtra("status", 1);
        intent.getIntExtra("plugged", -1);
        iVar.getClass();
        int intExtra2 = intent.getIntExtra("level", -1);
        int intExtra3 = intent.getIntExtra("scale", -1);
        iVar.f8763f = (intExtra2 * 100) / intExtra3;
        Log.d("steven_battery", b.f(new String[]{"percent:" + iVar.f8763f + " level:" + intExtra2 + " scale:" + intExtra3}));
    }
}
