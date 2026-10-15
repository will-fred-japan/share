package p179w7;

import A6.a;
import G6.b;
import N6.RunnableC0333d;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.os.Build;
import android.util.Log;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e.o f22251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p096m7.k f22252c;

    public /* synthetic */ k(e.o oVar, p096m7.k kVar, int i9) {
        this.f22250a = i9;
        this.f22251b = oVar;
        this.f22252c = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f22250a) {
            case 0:
                e eVar = e.this;
                ArrayList arrayList = new ArrayList();
                try {
                    eVar.h(arrayList, eVar.j(), "A2DP");
                } catch (Exception e9) {
                    Log.w("FlutterBluePlugin", "Cannot query A2DP devices: " + e9.getMessage());
                }
                try {
                    eVar.h(arrayList, eVar.k(), "HEADSET");
                } catch (Exception e10) {
                    Log.w("FlutterBluePlugin", "Cannot query HEADSET devices: " + e10.getMessage());
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    try {
                        BluetoothProfile bluetoothProfileL = eVar.l();
                        if (bluetoothProfileL != null) {
                            eVar.h(arrayList, bluetoothProfileL, "LE_AUDIO");
                        }
                    } catch (Exception e11) {
                        Log.w("FlutterBluePlugin", "Cannot query LE Audio devices: " + e11.getMessage());
                    }
                }
                e.d(eVar, new a(11, this.f22252c, arrayList));
                break;
            default:
                p096m7.k kVar = this.f22252c;
                e eVar2 = e.this;
                try {
                    ArrayList arrayList2 = new ArrayList();
                    for (BluetoothDevice bluetoothDevice : eVar2.j().getConnectedDevices()) {
                        HashMap map = new HashMap();
                        map.put("address", bluetoothDevice.getAddress());
                        map.put(MTCommonConstants.Network.KEY_NAME, bluetoothDevice.getName());
                        map.put("type", Integer.valueOf(bluetoothDevice.getType()));
                        map.put("isConnected", Boolean.TRUE);
                        map.put("bondState", Integer.valueOf(bluetoothDevice.getBondState()));
                        arrayList2.add(map);
                    }
                    e.d(eVar2, new RunnableC0333d(7, kVar, arrayList2));
                } catch (Exception e12) {
                    e.d(eVar2, new b(17, kVar, e12));
                }
                break;
        }
    }
}
