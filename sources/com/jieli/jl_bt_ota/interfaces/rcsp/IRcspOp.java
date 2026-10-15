package com.jieli.jl_bt_ota.interfaces.rcsp;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.model.BluetoothOTAConfigure;
import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;

/* JADX INFO: loaded from: classes.dex */
public interface IRcspOp {
    void configure(BluetoothOTAConfigure bluetoothOTAConfigure);

    BluetoothOTAConfigure getBluetoothOption();

    TargetInfoResponse getDeviceInfo(BluetoothDevice bluetoothDevice);

    BluetoothDevice getTargetDevice();

    void registerOnRcspCallback(OnRcspCallback onRcspCallback);

    void release();

    <T extends CommandBase<? extends BaseParameter, ? extends CommonResponse>> void sendCommandAsync(BluetoothDevice bluetoothDevice, T t, int i9, CommandCallback<T> commandCallback);

    <T extends CommandBase<? extends BaseParameter, ? extends CommonResponse>> void sendCommandResponse(BluetoothDevice bluetoothDevice, T t, CommandCallback<T> commandCallback);

    void unregisterOnRcspCallback(OnRcspCallback onRcspCallback);
}
