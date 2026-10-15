package com.starburst.sdk.api;

import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;

/* JADX INFO: loaded from: classes.dex */
public interface IConnectionCallback {
    void onAuthentication(BluetoothDeviceBean bluetoothDeviceBean);

    void onIotConnectFailure(BluetoothDeviceBean bluetoothDeviceBean, String str, int i9);

    void onIotConnected(BluetoothDeviceBean bluetoothDeviceBean);

    void onIotDisconnected(BluetoothDeviceBean bluetoothDeviceBean);
}
