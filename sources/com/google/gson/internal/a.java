package com.google.gson.internal;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.google.gson.InstanceCreator;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtBleListener;
import com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ObjectConstructor, BaseCallbackHelper.ICallbackHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f14186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14187b;

    public /* synthetic */ a(Object obj, Object obj2) {
        this.f14186a = obj;
        this.f14187b = obj2;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        return ((InstanceCreator) this.f14186a).createInstance((Type) this.f14187b);
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public void onHandle(Object obj) {
        ((OnBtBleListener) obj).onCharacteristicChanged((BluetoothGatt) this.f14186a, (BluetoothGattCharacteristic) this.f14187b);
    }
}
