package com.jieli.jl_bt_ota.interfaces.rcsp;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnRcspCallback {
    public void onMandatoryUpgrade(BluetoothDevice bluetoothDevice) {
    }

    public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i9) {
    }

    public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
    }

    public void onRcspError(BluetoothDevice bluetoothDevice, BaseError baseError) {
    }

    public void onRcspInit(BluetoothDevice bluetoothDevice, boolean z8) {
    }
}
