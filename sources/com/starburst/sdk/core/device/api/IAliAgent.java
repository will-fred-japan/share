package com.starburst.sdk.core.device.api;

import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;
import com.starburst.sdk.core.device.bt.api.IAliBt;
import com.starburst.sdk.core.device.bt.callback.IFgsStateCheckCallback;

/* JADX INFO: loaded from: classes.dex */
public interface IAliAgent {
    void checkFgsState(BluetoothDeviceBean bluetoothDeviceBean, IFgsStateCheckCallback iFgsStateCheckCallback);

    void customBtImpl(IAliBt iAliBt);

    void deviceConnect(BluetoothDeviceBean bluetoothDeviceBean);

    void disconnectLp(BluetoothDeviceBean bluetoothDeviceBean);

    void getSignByTokenFromDevice(BluetoothDeviceBean bluetoothDeviceBean, String str, String str2, String str3);
}
