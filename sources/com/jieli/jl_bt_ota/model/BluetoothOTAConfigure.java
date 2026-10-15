package com.jieli.jl_bt_ota.model;

import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.jieli.jl_bt_ota.interfaces.rcsp.ICmdSnGenerator;
import com.jieli.jl_bt_ota.model.ble.BleConnectParam;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothOTAConfigure {
    public static final int PREFER_BLE = 0;
    public static final int PREFER_SPP = 1;
    private BleConnectParam bleConnectParam;
    private byte[] firmwareFileData;
    private String firmwareFilePath;
    private int priority;

    @Deprecated
    private String scanFilterData;
    private ICmdSnGenerator snGenerator;
    private boolean isUseReconnect = false;
    private boolean isUseAuthDevice = true;

    @Deprecated
    private int bleIntervalMs = 500;
    private int timeoutMs = BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT;

    @Deprecated
    private boolean isUseJLServer = false;
    private boolean isPriorityCallbackOtaFinish = false;
    private boolean isNeedChangeMtu = false;
    private int mtu = 20;
    private int bleScanMode = 1;

    public static BluetoothOTAConfigure createDefault() {
        return new BluetoothOTAConfigure();
    }

    public BleConnectParam getBleConnectParam() {
        return this.bleConnectParam;
    }

    @Deprecated
    public int getBleIntervalMs() {
        return this.bleIntervalMs;
    }

    public int getBleScanMode() {
        return this.bleScanMode;
    }

    public byte[] getFirmwareFileData() {
        return this.firmwareFileData;
    }

    public String getFirmwareFilePath() {
        return this.firmwareFilePath;
    }

    public int getMtu() {
        return this.mtu;
    }

    public int getPriority() {
        return this.priority;
    }

    @Deprecated
    public String getScanFilterData() {
        return this.scanFilterData;
    }

    public ICmdSnGenerator getSnGenerator() {
        return this.snGenerator;
    }

    public int getTimeoutMs() {
        return this.timeoutMs;
    }

    public boolean isAutoConnectBle() {
        BleConnectParam bleConnectParam;
        return (this.isUseReconnect || (bleConnectParam = this.bleConnectParam) == null || !bleConnectParam.isValid()) ? false : true;
    }

    public boolean isNeedChangeMtu() {
        return this.isNeedChangeMtu;
    }

    public boolean isPriorityCallbackOtaFinish() {
        return this.isPriorityCallbackOtaFinish;
    }

    public boolean isUseAuthDevice() {
        return this.isUseAuthDevice;
    }

    @Deprecated
    public boolean isUseJLServer() {
        return this.isUseJLServer;
    }

    public boolean isUseReconnect() {
        return this.isUseReconnect;
    }

    public BluetoothOTAConfigure setBleConnectParam(BleConnectParam bleConnectParam) {
        this.bleConnectParam = bleConnectParam;
        return this;
    }

    @Deprecated
    public BluetoothOTAConfigure setBleIntervalMs(int i9) {
        this.bleIntervalMs = i9;
        return this;
    }

    public BluetoothOTAConfigure setBleScanMode(int i9) {
        this.bleScanMode = i9;
        return this;
    }

    public BluetoothOTAConfigure setFirmwareFileData(byte[] bArr) {
        this.firmwareFileData = bArr;
        return this;
    }

    public BluetoothOTAConfigure setFirmwareFilePath(String str) {
        this.firmwareFilePath = str;
        return this;
    }

    public BluetoothOTAConfigure setMtu(int i9) {
        this.mtu = i9;
        return this;
    }

    public BluetoothOTAConfigure setNeedChangeMtu(boolean z8) {
        this.isNeedChangeMtu = z8;
        return this;
    }

    public BluetoothOTAConfigure setPriority(int i9) {
        this.priority = i9;
        return this;
    }

    public BluetoothOTAConfigure setPriorityCallbackOtaFinish(boolean z8) {
        this.isPriorityCallbackOtaFinish = z8;
        return this;
    }

    @Deprecated
    public BluetoothOTAConfigure setScanFilterData(String str) {
        this.scanFilterData = str;
        return this;
    }

    public BluetoothOTAConfigure setSnGenerator(ICmdSnGenerator iCmdSnGenerator) {
        this.snGenerator = iCmdSnGenerator;
        return this;
    }

    public BluetoothOTAConfigure setTimeoutMs(int i9) {
        if (i9 < 500) {
            i9 = 500;
        }
        this.timeoutMs = i9;
        return this;
    }

    public BluetoothOTAConfigure setUseAuthDevice(boolean z8) {
        this.isUseAuthDevice = z8;
        return this;
    }

    @Deprecated
    public BluetoothOTAConfigure setUseJLServer(boolean z8) {
        this.isUseJLServer = z8;
        return this;
    }

    public BluetoothOTAConfigure setUseReconnect(boolean z8) {
        this.isUseReconnect = z8;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BluetoothOTAConfigure{priority=");
        sb.append(this.priority);
        sb.append(", isUseReconnect=");
        sb.append(this.isUseReconnect);
        sb.append(", isUseAuthDevice=");
        sb.append(this.isUseAuthDevice);
        sb.append(", timeoutMs=");
        sb.append(this.timeoutMs);
        sb.append(",\n firmwareFilePath='");
        sb.append(this.firmwareFilePath);
        sb.append("',\n firmwareFileData= ");
        byte[] bArr = this.firmwareFileData;
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(", isNeedChangeMtu=");
        sb.append(this.isNeedChangeMtu);
        sb.append(", mtu=");
        sb.append(this.mtu);
        sb.append(", bleScanMode=");
        sb.append(this.bleScanMode);
        sb.append(", isPriorityCallbackOtaFinish=");
        sb.append(this.isPriorityCallbackOtaFinish);
        sb.append(",\n snGenerator=");
        sb.append(this.snGenerator);
        sb.append(",\n bleConnectParam=");
        sb.append(this.bleConnectParam);
        sb.append('}');
        return sb.toString();
    }
}
