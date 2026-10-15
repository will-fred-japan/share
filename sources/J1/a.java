package J1;

import android.content.IntentFilter;
import android.os.BatteryManager;

/* JADX INFO: compiled from: ThorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BatteryManager f2662a;

    static {
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }
}
