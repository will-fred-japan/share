package com.starburst.sdk.core.auth.api;

import com.starburst.sdk.core.auth.callback.IRegisterCallback;
import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;

/* JADX INFO: loaded from: classes.dex */
public interface IAuthApi {
    void addLpConnectStateCallback(IConnectCallback iConnectCallback);

    void disconnect(BluetoothDeviceBean bluetoothDeviceBean);

    void doConnect(BluetoothDeviceBean bluetoothDeviceBean, String str, String str2, String str3);

    void doRegister(BluetoothDeviceBean bluetoothDeviceBean, String str, String str2, String str3, String str4, String str5, IRegisterCallback iRegisterCallback);

    String getBusinessSign();

    void onSignUpdated(BluetoothDeviceBean bluetoothDeviceBean, String str);

    void updateToken(IAuthInfoUpdateCallback iAuthInfoUpdateCallback);
}
