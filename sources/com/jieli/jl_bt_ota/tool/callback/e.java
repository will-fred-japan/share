package com.jieli.jl_bt_ota.tool.callback;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtBleListener;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements BaseCallbackHelper.ICallbackHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f16250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f16251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f16252d;

    public /* synthetic */ e(Object obj, int i9, int i10, int i11) {
        this.f16249a = i11;
        this.f16252d = obj;
        this.f16250b = i9;
        this.f16251c = i10;
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public final void onHandle(Object obj) {
        switch (this.f16249a) {
            case 0:
                ((IBluetoothCallback) obj).onBleDataBlockChanged((BluetoothDevice) this.f16252d, this.f16250b, this.f16251c);
                break;
            default:
                ((OnBtBleListener) obj).onConnectionStateChange((BluetoothGatt) this.f16252d, this.f16250b, this.f16251c);
                break;
        }
    }
}
