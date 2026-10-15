package com.starburst.sdk.core.device.bt.api;

import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;

/* JADX INFO: loaded from: classes.dex */
public interface IOnBtInitStateListener {
    void onFail(BluetoothDeviceBean bluetoothDeviceBean);

    void onSuccess(BluetoothDeviceBean bluetoothDeviceBean);
}
