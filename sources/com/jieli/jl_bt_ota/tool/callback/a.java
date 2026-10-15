package com.jieli.jl_bt_ota.tool.callback;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtAssistantCallback;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements BaseCallbackHelper.ICallbackHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f16239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f16240c;

    public /* synthetic */ a(BluetoothDevice bluetoothDevice, int i9, int i10) {
        this.f16238a = i10;
        this.f16239b = bluetoothDevice;
        this.f16240c = i9;
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public final void onHandle(Object obj) {
        switch (this.f16238a) {
            case 0:
                ((OnBtAssistantCallback) obj).onA2dpStatus(this.f16239b, this.f16240c);
                break;
            case 1:
                ((OnBtAssistantCallback) obj).onBtDeviceConnection(this.f16239b, this.f16240c);
                break;
            case 2:
                ((IBluetoothCallback) obj).onConnection(this.f16239b, this.f16240c);
                break;
            default:
                ((IBluetoothCallback) obj).onHfpStatus(this.f16239b, this.f16240c);
                break;
        }
    }
}
