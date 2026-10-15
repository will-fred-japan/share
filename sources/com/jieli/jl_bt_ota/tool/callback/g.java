package com.jieli.jl_bt_ota.tool.callback;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtBleListener;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements BaseCallbackHelper.ICallbackHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f16256b;

    public /* synthetic */ g(BluetoothDevice bluetoothDevice, int i9) {
        this.f16255a = i9;
        this.f16256b = bluetoothDevice;
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public final void onHandle(Object obj) {
        switch (this.f16255a) {
            case 0:
                ((IBluetoothCallback) obj).onMandatoryUpgrade(this.f16256b);
                break;
            default:
                ((OnBtBleListener) obj).onSwitchBleDevice(this.f16256b);
                break;
        }
    }
}
