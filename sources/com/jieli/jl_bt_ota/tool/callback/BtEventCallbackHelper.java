package com.jieli.jl_bt_ota.tool.callback;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* JADX INFO: loaded from: classes.dex */
public class BtEventCallbackHelper extends BaseCallbackHelper<IBluetoothCallback> implements IBluetoothCallback {
    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onA2dpStatus(BluetoothDevice bluetoothDevice, int i9) {
        callbackEvent(new h(bluetoothDevice, i9, 0));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onAdapterStatus(boolean z8, boolean z9) {
        callbackEvent(new c(z8, z9, 1));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onBleDataBlockChanged(BluetoothDevice bluetoothDevice, int i9, int i10) {
        callbackEvent(new e(bluetoothDevice, i9, i10, 0));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onBtDeviceConnection(BluetoothDevice bluetoothDevice, int i9) {
        callbackEvent(new d(bluetoothDevice, i9, 1));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onConnection(BluetoothDevice bluetoothDevice, int i9) {
        callbackEvent(new a(bluetoothDevice, i9, 2));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
        callbackEvent(new com.google.gson.internal.d(2, bluetoothDevice, bleScanMessage));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onDiscoveryStatus(final boolean z8, final boolean z9) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.callback.f
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onDiscoveryStatus(z8, z9);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onError(BaseError baseError) {
        callbackEvent(new R3.c(4, baseError));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
    public void onHfpStatus(BluetoothDevice bluetoothDevice, int i9) {
        callbackEvent(new a(bluetoothDevice, i9, 3));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onMandatoryUpgrade(BluetoothDevice bluetoothDevice) {
        callbackEvent(new g(bluetoothDevice, 0));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback
    public void onReceiveCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        callbackEvent(new com.google.gson.internal.d(1, bluetoothDevice, commandBase));
    }
}
