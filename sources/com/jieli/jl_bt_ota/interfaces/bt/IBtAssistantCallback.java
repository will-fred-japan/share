package com.jieli.jl_bt_ota.interfaces.bt;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.model.BleScanMessage;

/* JADX INFO: loaded from: classes.dex */
public interface IBtAssistantCallback {
    void onA2dpStatus(BluetoothDevice bluetoothDevice, int i9);

    void onAdapterStatus(boolean z8, boolean z9);

    void onBtDeviceConnection(BluetoothDevice bluetoothDevice, int i9);

    void onDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage);

    void onDiscoveryStatus(boolean z8, boolean z9);

    void onHfpStatus(BluetoothDevice bluetoothDevice, int i9);
}
