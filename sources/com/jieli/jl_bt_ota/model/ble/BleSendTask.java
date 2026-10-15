package com.jieli.jl_bt_ota.model.ble;

import H2.a;
import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.bt.OnBleSendDataCallback;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class BleSendTask {
    private int retryCount;
    private final BleSendParam sendParam;
    private int status;

    public BleSendTask(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr) {
        this(bluetoothDevice, uuid, uuid2, 0, bArr, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.sendParam.equals(((BleSendTask) obj).sendParam);
    }

    public OnBleSendDataCallback getCallback() {
        return this.sendParam.getCallback();
    }

    public UUID getCharacteristicUUID() {
        return this.sendParam.getCharacteristicUUID();
    }

    public byte[] getData() {
        return this.sendParam.getData();
    }

    public BluetoothDevice getDevice() {
        return this.sendParam.getDevice();
    }

    public BleSendParam getSendParam() {
        return this.sendParam;
    }

    public UUID getServiceUUID() {
        return this.sendParam.getServiceUUID();
    }

    public int getStatus() {
        return this.status;
    }

    public int getWriteType() {
        return this.sendParam.getWriteType();
    }

    public int hashCode() {
        return Objects.hash(this.sendParam);
    }

    public boolean isSendFailedOverLimit() {
        int i9 = this.retryCount + 1;
        this.retryCount = i9;
        if (i9 >= this.sendParam.getRetryLimit()) {
            return true;
        }
        this.status = -1;
        return false;
    }

    public BleSendTask setCallback(OnBleSendDataCallback onBleSendDataCallback) {
        this.sendParam.setCallback(onBleSendDataCallback);
        return this;
    }

    public BleSendTask setStatus(int i9) {
        this.status = i9;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BleSendTask{sendParam=");
        sb.append(this.sendParam);
        sb.append(", retryCount=");
        sb.append(this.retryCount);
        sb.append(", status=");
        return a.a(sb, this.status, '}');
    }

    public BleSendTask(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, int i9, byte[] bArr, OnBleSendDataCallback onBleSendDataCallback) {
        this(new BleSendParam(bluetoothDevice, uuid, uuid2, i9, bArr, 3, onBleSendDataCallback));
    }

    public BleSendTask(BleSendParam bleSendParam) {
        this.sendParam = bleSendParam;
        this.retryCount = 0;
        this.status = -1;
    }
}
