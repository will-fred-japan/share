package com.starburst.sdk.core.device.bt.callback;

import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;

/* JADX INFO: loaded from: classes.dex */
public interface IHandlerCallback {
    void onFgsCheckFailed(BluetoothDeviceBean bluetoothDeviceBean, String str, int i9);

    void onFgsCheckSuccess(BluetoothDeviceBean bluetoothDeviceBean);
}
