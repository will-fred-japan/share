package com.jieli.jl_bt_ota.interfaces.bt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.jieli.jl_bt_ota.interfaces.BtEventCallback;
import com.jieli.jl_bt_ota.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_bt_ota.model.base.BaseError;

/* JADX INFO: loaded from: classes.dex */
public interface IBluetoothManager {
    void addOnRcspCallback(OnRcspCallback onRcspCallback);

    void connectBluetoothDevice(BluetoothDevice bluetoothDevice);

    void disconnectBluetoothDevice(BluetoothDevice bluetoothDevice);

    BluetoothGatt getConnectedBluetoothGatt();

    BluetoothDevice getConnectedDevice();

    void onBtDeviceConnection(BluetoothDevice bluetoothDevice, int i9);

    void onError(BaseError baseError);

    void onMtuChanged(BluetoothGatt bluetoothGatt, int i9, int i10);

    void onReceiveDeviceData(BluetoothDevice bluetoothDevice, byte[] bArr);

    void registerBluetoothCallback(BtEventCallback btEventCallback);

    void removeRcspCallback(OnRcspCallback onRcspCallback);

    boolean sendDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr);

    void unregisterBluetoothCallback(BtEventCallback btEventCallback);
}
