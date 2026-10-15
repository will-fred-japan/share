package com.google.gson.internal;

import android.bluetooth.BluetoothDevice;
import com.google.gson.InstanceCreator;
import com.jieli.jl_bt_ota.interfaces.bt.IBluetoothCallback;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements ObjectConstructor, BaseCallbackHelper.ICallbackHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f14194c;

    public /* synthetic */ d(int i9, Object obj, Object obj2) {
        this.f14192a = i9;
        this.f14193b = obj;
        this.f14194c = obj2;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        return ((InstanceCreator) this.f14193b).createInstance((Type) this.f14194c);
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public void onHandle(Object obj) {
        IBluetoothCallback iBluetoothCallback = (IBluetoothCallback) obj;
        switch (this.f14192a) {
            case 1:
                iBluetoothCallback.onReceiveCommand((BluetoothDevice) this.f14193b, (CommandBase) this.f14194c);
                break;
            default:
                iBluetoothCallback.onDiscovery((BluetoothDevice) this.f14193b, (BleScanMessage) this.f14194c);
                break;
        }
    }
}
