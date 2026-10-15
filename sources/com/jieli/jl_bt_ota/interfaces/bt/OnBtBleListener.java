package com.jieli.jl_bt_ota.interfaces.bt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnBtBleListener extends BluetoothGattCallback {
    public abstract void onBleConnection(BluetoothDevice bluetoothDevice, int i9);

    public void onSwitchBleDevice(BluetoothDevice bluetoothDevice) {
    }

    public void onConnectionUpdatedCallback(BluetoothGatt bluetoothGatt, int i9, int i10, int i11, int i12) {
    }
}
