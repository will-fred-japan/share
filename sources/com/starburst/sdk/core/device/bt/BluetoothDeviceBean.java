package com.starburst.sdk.core.device.bt;

import A.a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothDeviceBean implements Serializable {
    private String deviceId;
    private String deviceName;
    private BluetoothDeviceType deviceType;

    public BluetoothDeviceBean(String str, BluetoothDeviceType bluetoothDeviceType) {
        this.deviceId = str;
        this.deviceType = bluetoothDeviceType;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public BluetoothDeviceType getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(BluetoothDeviceType bluetoothDeviceType) {
        this.deviceType = bluetoothDeviceType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BluetoothDeviceBean{deviceType=");
        sb.append(this.deviceType);
        sb.append(", deviceName='");
        return a.j(sb, this.deviceName, "'}");
    }
}
