package cn.jiguang.commons.a;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes.dex */
public final class hc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f10140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f10142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BluetoothClass f10143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10144e;

    public hc(BluetoothDevice bluetoothDevice, int i9, byte[] bArr) {
        this(bluetoothDevice, i9, bArr, null, null);
    }

    public hc(BluetoothDevice bluetoothDevice, int i9, byte[] bArr, BluetoothClass bluetoothClass, String str) {
        this.f10140a = bluetoothDevice;
        this.f10141b = i9;
        this.f10142c = bArr;
        this.f10143d = bluetoothClass;
        this.f10144e = str;
    }
}
