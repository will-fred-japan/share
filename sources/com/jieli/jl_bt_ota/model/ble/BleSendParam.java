package com.jieli.jl_bt_ota.model.ble;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.bt.OnBleSendDataCallback;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.UuidUtil;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class BleSendParam {
    public static final int RE_SEND_LIMIT = 3;
    private OnBleSendDataCallback callback;
    private final UUID characteristicUUID;
    private final byte[] data;
    private final BluetoothDevice device;
    private final int retryLimit;
    private final UUID serviceUUID;
    private final int writeType;

    public BleSendParam(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr) {
        this(bluetoothDevice, uuid, uuid2, bArr, 3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BleSendParam bleSendParam = (BleSendParam) obj;
            if (this.device.equals(bleSendParam.device) && this.serviceUUID.equals(bleSendParam.serviceUUID) && this.characteristicUUID.equals(bleSendParam.characteristicUUID)) {
                return true;
            }
        }
        return false;
    }

    public OnBleSendDataCallback getCallback() {
        return this.callback;
    }

    public UUID getCharacteristicUUID() {
        return this.characteristicUUID;
    }

    public byte[] getData() {
        return this.data;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public int getRetryLimit() {
        return this.retryLimit;
    }

    public UUID getServiceUUID() {
        return this.serviceUUID;
    }

    public int getWriteType() {
        return this.writeType;
    }

    public int hashCode() {
        return Objects.hash(this.device, this.serviceUUID, this.characteristicUUID);
    }

    public BleSendParam setCallback(OnBleSendDataCallback onBleSendDataCallback) {
        this.callback = onBleSendDataCallback;
        return this;
    }

    public String toString() {
        return "BleSendParam{device=" + this.device + ", serviceUUID=" + UuidUtil.read16BitUUID(this.serviceUUID) + ", characteristicUUID=" + UuidUtil.read16BitUUID(this.characteristicUUID) + ", writeType=" + this.writeType + ", data=" + CHexConver.byte2HexStr(this.data) + ", retryLimit=" + this.retryLimit + ", callback=" + this.callback + '}';
    }

    public BleSendParam(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr, OnBleSendDataCallback onBleSendDataCallback) {
        this(bluetoothDevice, uuid, uuid2, 0, bArr, 3, onBleSendDataCallback);
    }

    public BleSendParam(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr, int i9, OnBleSendDataCallback onBleSendDataCallback) {
        this(bluetoothDevice, uuid, uuid2, 0, bArr, i9, onBleSendDataCallback);
    }

    public BleSendParam(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, int i9, byte[] bArr, int i10, OnBleSendDataCallback onBleSendDataCallback) {
        this.device = bluetoothDevice;
        this.serviceUUID = uuid;
        this.characteristicUUID = uuid2;
        this.writeType = i9;
        this.data = bArr;
        this.retryLimit = i10;
        setCallback(onBleSendDataCallback);
    }
}
