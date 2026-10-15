package com.starburst.sdk.core.device.bt.api;

import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;

/* JADX INFO: loaded from: classes.dex */
public interface IBtReceiverCallback {
    void onReceicerData(BluetoothDeviceBean bluetoothDeviceBean, byte[] bArr);
}
