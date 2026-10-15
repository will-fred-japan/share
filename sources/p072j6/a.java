package p072j6;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtBleListener;
import com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements BaseCallbackHelper.ICallbackHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f19869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothGattDescriptor f19870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f19871d;

    public /* synthetic */ a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i9, int i10) {
        this.f19868a = i10;
        this.f19869b = bluetoothGatt;
        this.f19870c = bluetoothGattDescriptor;
        this.f19871d = i9;
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public final void onHandle(Object obj) {
        OnBtBleListener onBtBleListener = (OnBtBleListener) obj;
        switch (this.f19868a) {
            case 0:
                onBtBleListener.onDescriptorWrite(this.f19869b, this.f19870c, this.f19871d);
                break;
            default:
                onBtBleListener.onDescriptorRead(this.f19869b, this.f19870c, this.f19871d);
                break;
        }
    }
}
