package cn.jiguang.commons.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes.dex */
final class gu implements BluetoothAdapter.LeScanCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ gs f10133a;

    public gu(gs gsVar) {
        this.f10133a = gsVar;
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public final void onLeScan(BluetoothDevice bluetoothDevice, int i9, byte[] bArr) {
        if (!this.f10133a.f10120a.get() || bluetoothDevice == null) {
            return;
        }
        this.f10133a.f10121b.offer(new hc(bluetoothDevice, i9, bArr));
    }
}
