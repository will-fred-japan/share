package com.jieli.jl_bt_ota.tool.callback;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtAssistantCallback;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtBleListener;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements BaseCallbackHelper.ICallbackHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f16248c;

    public /* synthetic */ d(Object obj, int i9, int i10) {
        this.f16246a = i10;
        this.f16247b = obj;
        this.f16248c = i9;
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public final void onHandle(Object obj) {
        switch (this.f16246a) {
            case 0:
                ((OnBtAssistantCallback) obj).onHfpStatus((BluetoothDevice) this.f16247b, this.f16248c);
                break;
            case 1:
                ((IBluetoothCallback) obj).onBtDeviceConnection((BluetoothDevice) this.f16247b, this.f16248c);
                break;
            default:
                ((OnBtBleListener) obj).onServicesDiscovered((BluetoothGatt) this.f16247b, this.f16248c);
                break;
        }
    }
}
