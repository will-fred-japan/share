package com.jieli.jl_bt_ota.interfaces;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* JADX INFO: loaded from: classes.dex */
public abstract class BtEventCallback implements IBluetoothCallback {
    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onError(BaseError baseError) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onMandatoryUpgrade(BluetoothDevice bluetoothDevice) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onA2dpStatus(BluetoothDevice bluetoothDevice, int i9) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onAdapterStatus(boolean z8, boolean z9) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onBtDeviceConnection(BluetoothDevice bluetoothDevice, int i9) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onConnection(BluetoothDevice bluetoothDevice, int i9) {
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

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onReceiveCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onBleDataBlockChanged(BluetoothDevice bluetoothDevice, int i9, int i10) {
    }
}
