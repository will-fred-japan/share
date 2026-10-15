package com.jieli.jl_bt_ota.model.ble;

import com.jieli.jl_bt_ota.util.UuidUtil;
import defpackage.f;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class BleCharacteristic {
    private static final int RETRY_LIMIT = 2;
    private final UUID characteristicUUID;
    private boolean enable;
    private final int requiredProperty;
    private int retryCount;
    private final int retryLimit;
    private final UUID serviceUUID;

    public BleCharacteristic(UUID uuid, UUID uuid2, int i9) {
        this(uuid, uuid2, i9, 2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BleCharacteristic)) {
            return false;
        }
        BleCharacteristic bleCharacteristic = (BleCharacteristic) obj;
        return this.serviceUUID.equals(bleCharacteristic.getServiceUUID()) && this.characteristicUUID.equals(bleCharacteristic.getCharacteristicUUID());
    }

    public UUID getCharacteristicUUID() {
        return this.characteristicUUID;
    }

    public int getRequiredProperty() {
        return this.requiredProperty;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public int getRetryLimit() {
        return this.retryLimit;
    }

    public UUID getServiceUUID() {
        return this.serviceUUID;
    }

    public boolean hasProperty(int i9) {
        return (this.requiredProperty & i9) == i9;
    }

    public int hashCode() {
        return this.characteristicUUID.hashCode() + this.serviceUUID.hashCode();
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isOverLimit() {
        int i9 = this.retryCount + 1;
        this.retryCount = i9;
        return i9 > this.retryLimit;
    }

    public BleCharacteristic setEnable(boolean z8) {
        this.enable = z8;
        return this;
    }

    public BleCharacteristic setRetryCount(int i9) {
        this.retryCount = i9;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BleCharacteristic{serviceUUID=");
        sb.append(UuidUtil.read16BitUUID(this.serviceUUID));
        sb.append(", characteristicUUID=");
        sb.append(UuidUtil.read16BitUUID(this.characteristicUUID));
        sb.append(", requiredProperty=");
        sb.append(this.requiredProperty);
        sb.append(", retryLimit=");
        sb.append(this.retryLimit);
        sb.append(", retryCount=");
        sb.append(this.retryCount);
        sb.append(", enable=");
        return f.g(sb, this.enable, '}');
    }

    public BleCharacteristic(UUID uuid, UUID uuid2, int i9, int i10) {
        this.enable = true;
        this.serviceUUID = uuid;
        this.characteristicUUID = uuid2;
        this.requiredProperty = i9;
        this.retryLimit = i10;
    }
}
