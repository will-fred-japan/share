package com.jieli.jl_bt_ota.interfaces.bt;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes.dex */
public interface IBtProxy {
    void setOnBtListener(OnBtListener onBtListener);

    boolean writeData(BluetoothDevice bluetoothDevice, byte[] bArr);
}
