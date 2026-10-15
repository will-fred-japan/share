package cn.jiguang.commons.a;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;

/* JADX INFO: loaded from: classes.dex */
final class gq implements BluetoothProfile.ServiceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ gp f10119a;

    public gq(gp gpVar) {
        this.f10119a = gpVar;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceConnected(int i9, BluetoothProfile bluetoothProfile) {
        String str;
        if (i9 != 1) {
            if (i9 == 2) {
                this.f10119a.f10115a.set((BluetoothA2dp) bluetoothProfile);
                str = "A2DP profile connected";
            }
            if (this.f10119a.f10117c != null) {
                this.f10119a.f10117c.countDown();
            }
        }
        this.f10119a.f10116b.set((BluetoothHeadset) bluetoothProfile);
        str = "headset profile connected";
        ee.a("BluetoothProfileManager", str);
        if (this.f10119a.f10117c != null) {
            this.f10119a.f10117c.countDown();
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int i9) {
        String str;
        if (i9 == 1) {
            this.f10119a.f10116b.set(null);
            str = "headset profile disconnected";
        } else {
            if (i9 != 2) {
                return;
            }
            this.f10119a.f10115a.set(null);
            str = "A2DP profile disconnected";
        }
        ee.a("BluetoothProfileManager", str);
    }
}
