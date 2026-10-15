package com.jieli.jl_bt_ota.tool.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.google.gson.internal.a;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtBleListener;
import com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper;
import com.jieli.jl_bt_ota.tool.callback.d;
import com.jieli.jl_bt_ota.tool.callback.e;
import com.jieli.jl_bt_ota.tool.callback.g;
import com.jieli.jl_bt_ota.tool.callback.h;
import p072j6.f;

/* JADX INFO: loaded from: classes.dex */
public class BtBleCallbackManager extends BaseCallbackHelper<OnBtBleListener> {
    public void onBleConnection(BluetoothDevice bluetoothDevice, int i9) {
        callbackEvent(new h(bluetoothDevice, i9, 1));
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        callbackEvent(new a(bluetoothGatt, bluetoothGattCharacteristic));
    }

    public void onCharacteristicRead(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int i9) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: j6.i
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((OnBtBleListener) obj).onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i9);
            }
        });
    }

    public void onCharacteristicWrite(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int i9) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: j6.b
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((OnBtBleListener) obj).onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i9);
            }
        });
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i9, int i10) {
        callbackEvent(new e(bluetoothGatt, i9, i10, 1));
    }

    public void onConnectionUpdated(final BluetoothGatt bluetoothGatt, final int i9, final int i10, final int i11, final int i12) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: j6.c
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((OnBtBleListener) obj).onConnectionUpdatedCallback(bluetoothGatt, i9, i10, i11, i12);
            }
        });
    }

    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i9) {
        callbackEvent(new p072j6.a(bluetoothGatt, bluetoothGattDescriptor, i9, 1));
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i9) {
        callbackEvent(new p072j6.a(bluetoothGatt, bluetoothGattDescriptor, i9, 0));
    }

    public void onMtuChanged(final BluetoothGatt bluetoothGatt, final int i9, final int i10) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: j6.j
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((OnBtBleListener) obj).onMtuChanged(bluetoothGatt, i9, i10);
            }
        });
    }

    public void onPhyRead(final BluetoothGatt bluetoothGatt, final int i9, final int i10, final int i11) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: j6.d
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((OnBtBleListener) obj).onPhyRead(bluetoothGatt, i9, i10, i11);
            }
        });
    }

    public void onPhyUpdate(final BluetoothGatt bluetoothGatt, final int i9, final int i10, final int i11) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: j6.e
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((OnBtBleListener) obj).onPhyUpdate(bluetoothGatt, i9, i10, i11);
            }
        });
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i9) {
        callbackEvent(new d(bluetoothGatt, i9, 2));
    }

    public void onSwitchBleDevice(BluetoothDevice bluetoothDevice) {
        callbackEvent(new g(bluetoothDevice, 1));
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        callbackEvent(new f(bluetoothGatt, bluetoothGattCharacteristic, bArr));
    }

    public void onCharacteristicRead(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final int i9) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: j6.h
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((OnBtBleListener) obj).onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bArr, i9);
            }
        });
    }

    public void onDescriptorRead(final BluetoothGatt bluetoothGatt, final BluetoothGattDescriptor bluetoothGattDescriptor, final int i9, final byte[] bArr) {
        callbackEvent(new BaseCallbackHelper.ICallbackHandler() { // from class: j6.g
            @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
            public final void onHandle(Object obj) {
                ((OnBtBleListener) obj).onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i9, bArr);
            }
        });
    }
}
