package com.jieli.jl_bt_ota.interfaces.bt;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.model.BleScanMessage;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnBtAssistantCallback implements IBtAssistantCallback {
    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onA2dpStatus(BluetoothDevice bluetoothDevice, int i9) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onAdapterStatus(boolean z8, boolean z9) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onBtDeviceConnection(BluetoothDevice bluetoothDevice, int i9) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onDiscoveryStatus(boolean z8, boolean z9) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onHfpStatus(BluetoothDevice bluetoothDevice, int i9) {
    }
}
