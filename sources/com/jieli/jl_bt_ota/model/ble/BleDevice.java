package com.jieli.jl_bt_ota.model.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import defpackage.f;

/* JADX INFO: loaded from: classes.dex */
public class BleDevice {
    private static final int RETRY_LIMIT = 2;
    private int bleMtu;
    private BluetoothGatt bluetoothGatt;
    private final BleConnectParam connectParam;
    private int connection;
    private final BluetoothDevice device;
    private boolean isUsing;
    private int retryCount;
    private final int retryLimit;

    public BleDevice(BluetoothDevice bluetoothDevice, BleConnectParam bleConnectParam) {
        this(bluetoothDevice, bleConnectParam, 2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof BleDevice) {
            return this.device.equals(((BleDevice) obj).device);
        }
        return false;
    }

    public int getBleMtu() {
        return this.bleMtu;
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.bluetoothGatt;
    }

    public BleConnectParam getConnectParam() {
        return this.connectParam;
    }

    public int getConnection() {
        return this.connection;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public int getRetryLimit() {
        return this.retryLimit;
    }

    public int hashCode() {
        return this.device.hashCode();
    }

    public boolean isConnectATT() {
        return this.connectParam.getTransport() == 1;
    }

    public boolean isConnected() {
        return this.connection == 2 && this.bluetoothGatt != null;
    }

    public boolean isOverRetryLimit() {
        int i9 = this.retryCount + 1;
        this.retryCount = i9;
        return i9 >= this.retryLimit;
    }

    public boolean isUsing() {
        return this.isUsing;
    }

    @SuppressLint({"Range"})
    public BleDevice setBleMtu(int i9) {
        if (i9 >= 128) {
            i9 -= 6;
        }
        this.bleMtu = i9;
        return this;
    }

    public BleDevice setBluetoothGatt(BluetoothGatt bluetoothGatt) {
        this.bluetoothGatt = bluetoothGatt;
        return this;
    }

    public BleDevice setConnection(int i9) {
        this.connection = i9;
        if (i9 != 2) {
            setUsing(false);
            return this;
        }
        this.retryCount = 0;
        this.connectParam.resetRetryCount();
        return this;
    }

    public BleDevice setUsing(boolean z8) {
        this.isUsing = z8;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BleDevice{device=");
        sb.append(this.device);
        sb.append(", \nconnectParam=");
        sb.append(this.connectParam);
        sb.append(", \nbluetoothGatt=");
        sb.append(this.bluetoothGatt);
        sb.append(", bleMtu=");
        sb.append(this.bleMtu);
        sb.append(", connection=");
        sb.append(BluetoothUtil.printBtConnectionState(this.connection));
        sb.append(", isUsing=");
        return f.g(sb, this.isUsing, '}');
    }

    public BleDevice(BluetoothDevice bluetoothDevice, BleConnectParam bleConnectParam, int i9) {
        this.bleMtu = 20;
        this.connection = 0;
        this.device = bluetoothDevice;
        this.connectParam = bleConnectParam;
        this.retryLimit = i9;
        bleConnectParam.resetRetryCount();
    }
}
