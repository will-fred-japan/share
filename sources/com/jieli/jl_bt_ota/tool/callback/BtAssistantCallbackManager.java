package com.jieli.jl_bt_ota.tool.callback;

import U5.B;
import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtAssistantCallback;
import com.jieli.jl_bt_ota.model.BleScanMessage;

/* JADX INFO: loaded from: classes.dex */
public class BtAssistantCallbackManager extends BaseCallbackHelper<OnBtAssistantCallback> {
    public void onA2dpStatus(BluetoothDevice bluetoothDevice, int i9) {
        callbackEvent(new a(bluetoothDevice, i9, 0));
    }

    public void onAdapterStatus(boolean z8, boolean z9) {
        callbackEvent(new c(z8, z9, 0));
    }

    public void onBtDeviceConnection(BluetoothDevice bluetoothDevice, int i9) {
        callbackEvent(new a(bluetoothDevice, i9, 1));
    }

    public void onDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
        callbackEvent(new B(bluetoothDevice, bleScanMessage));
    }

    public void onDiscoveryStatus(final boolean z8, final boolean z9) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.callback.b
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((OnBtAssistantCallback) obj).onDiscoveryStatus(z8, z9);
            }
        });
    }

    public void onHfpStatus(BluetoothDevice bluetoothDevice, int i9) {
        callbackEvent(new d(bluetoothDevice, i9, 0));
    }
}
