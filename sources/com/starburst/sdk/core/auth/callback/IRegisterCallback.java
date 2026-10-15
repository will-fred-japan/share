package com.starburst.sdk.core.auth.callback;

import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;

/* JADX INFO: loaded from: classes.dex */
public interface IRegisterCallback {
    void onRegisterFailed(BluetoothDeviceBean bluetoothDeviceBean, String str, int i9);

    void onRegisterSuccess(BluetoothDeviceBean bluetoothDeviceBean, String str, String str2, String str3, String str4, String str5);
}
