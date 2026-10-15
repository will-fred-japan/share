package com.jieli.jl_bt_ota.interfaces.bt;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* JADX INFO: loaded from: classes.dex */
public interface IBluetoothCallback extends IBtAssistantCallback {
    void onBleDataBlockChanged(BluetoothDevice bluetoothDevice, int i9, int i10);

    void onConnection(BluetoothDevice bluetoothDevice, int i9);

    void onError(BaseError baseError);

    void onMandatoryUpgrade(BluetoothDevice bluetoothDevice);

    void onReceiveCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase);
}
