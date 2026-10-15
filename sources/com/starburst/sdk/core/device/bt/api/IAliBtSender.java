package com.starburst.sdk.core.device.bt.api;

import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;
import com.starburst.sdk.core.device.bt.callback.ISend2BtCallback;

/* JADX INFO: loaded from: classes.dex */
public interface IAliBtSender {
    void sendData(BluetoothDeviceBean bluetoothDeviceBean, byte[] bArr, ISend2BtCallback iSend2BtCallback);
}
