package com.starburst.sdk.core.device.bt.api;

import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;

/* JADX INFO: loaded from: classes.dex */
public interface IBtMsgCallback {
    void setReceivedCallBack(IBtReceiverCallback iBtReceiverCallback);

    void toSend(BluetoothDeviceBean bluetoothDeviceBean, byte[] bArr);
}
