package com.jieli.jl_bt_ota.interfaces.command;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* JADX INFO: loaded from: classes.dex */
public interface OnDataHandlerListener {
    void onRCSPError(BluetoothDevice bluetoothDevice, BaseError baseError);

    void onReceivedCmd(BluetoothDevice bluetoothDevice, CommandBase commandBase);
}
