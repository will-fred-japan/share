package com.jieli.jl_bt_ota.model;

import H2.a;
import com.jieli.jl_bt_ota.util.CHexConver;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BleScanMessage implements Serializable {
    private int battery;
    private int deviceType;
    private int deviceVersion;
    private String identify;
    private boolean isEnableConnect = true;
    private boolean isOTA;
    private String oldBleAddress;
    private int pid;
    private byte[] rawData;
    private int rssi;
    private int uid;
    private int version;
    private int vid;

    public int getBattery() {
        return this.battery;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getDeviceVersion() {
        return this.deviceVersion;
    }

    public String getIdentify() {
        return this.identify;
    }

    public String getOldBleAddress() {
        return this.oldBleAddress;
    }

    public int getPid() {
        return this.pid;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public int getRssi() {
        return this.rssi;
    }

    public int getUid() {
        return this.uid;
    }

    public int getVersion() {
        return this.version;
    }

    public int getVid() {
        return this.vid;
    }

    public boolean isEnableConnect() {
        return this.isEnableConnect;
    }

    public boolean isOTA() {
        return this.isOTA;
    }

    public BleScanMessage setBattery(int i9) {
        this.battery = i9;
        return this;
    }

    public BleScanMessage setDeviceType(int i9) {
        this.deviceType = i9;
        return this;
    }

    public BleScanMessage setDeviceVersion(int i9) {
        this.deviceVersion = i9;
        return this;
    }

    public BleScanMessage setEnableConnect(boolean z8) {
        this.isEnableConnect = z8;
        return this;
    }

    public BleScanMessage setIdentify(String str) {
        this.identify = str;
        return this;
    }

    public BleScanMessage setOTA(boolean z8) {
        this.isOTA = z8;
        return this;
    }

    public BleScanMessage setOldBleAddress(String str) {
        this.oldBleAddress = str;
        return this;
    }

    public BleScanMessage setPid(int i9) {
        this.pid = i9;
        return this;
    }

    public BleScanMessage setRawData(byte[] bArr) {
        this.rawData = bArr;
        return this;
    }

    public BleScanMessage setRssi(int i9) {
        this.rssi = i9;
        return this;
    }

    public BleScanMessage setUid(int i9) {
        this.uid = i9;
        return this;
    }

    public BleScanMessage setVersion(int i9) {
        this.version = i9;
        return this;
    }

    public BleScanMessage setVid(int i9) {
        this.vid = i9;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BleScanMessage{rawData=");
        sb.append(CHexConver.byte2HexStr(this.rawData));
        sb.append(", rssi=");
        sb.append(this.rssi);
        sb.append(", isEnableConnect=");
        sb.append(this.isEnableConnect);
        sb.append(", vid=");
        sb.append(this.vid);
        sb.append(", uid=");
        sb.append(this.uid);
        sb.append(", pid=");
        sb.append(this.pid);
        sb.append(", identify='");
        sb.append(this.identify);
        sb.append("', version=");
        sb.append(this.version);
        sb.append(", oldBleAddress='");
        sb.append(this.oldBleAddress);
        sb.append("', isOTA=");
        sb.append(this.isOTA);
        sb.append(", deviceType=");
        sb.append(this.deviceType);
        sb.append(", deviceVersion=");
        sb.append(this.deviceVersion);
        sb.append(", battery=");
        return a.a(sb, this.battery, '}');
    }
}
