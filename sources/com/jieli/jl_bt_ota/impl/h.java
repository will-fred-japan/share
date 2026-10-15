package com.jieli.jl_bt_ota.impl;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.bt.IBtProxy;
import com.jieli.jl_bt_ota.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements BaseCallbackHelper.ICallbackHandler, RcspAuth.IRcspAuthOp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f16168a;

    public /* synthetic */ h(Object obj) {
        this.f16168a = obj;
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public void onHandle(Object obj) {
        ((OnRcspCallback) obj).onMandatoryUpgrade((BluetoothDevice) this.f16168a);
    }

    @Override // com.jieli.jl_bt_ota.impl.RcspAuth.IRcspAuthOp
    public boolean sendAuthDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
        return ((IBtProxy) this.f16168a).writeData(bluetoothDevice, bArr);
    }
}
