package com.jieli.jl_bt_ota.interfaces.bt;

import android.bluetooth.BluetoothDevice;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public interface OnBleSendDataCallback {
    void onResult(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, boolean z8, byte[] bArr);
}
