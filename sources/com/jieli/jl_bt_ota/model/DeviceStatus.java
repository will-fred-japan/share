package com.jieli.jl_bt_ota.model;

import A.a;
import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;

/* JADX INFO: loaded from: classes.dex */
public class DeviceStatus {
    private boolean isAuthDevice;
    private boolean isEnterLowPowerMode;
    private boolean isMandatoryUpgrade;
    private String mDevMD5;
    private TargetInfoResponse mTargetInfo;
    private int status;

    public String getDevMD5() {
        return this.mDevMD5;
    }

    public int getStatus() {
        return this.status;
    }

    public TargetInfoResponse getTargetInfo() {
        return this.mTargetInfo;
    }

    public boolean isAuthDevice() {
        return this.isAuthDevice;
    }

    public boolean isEnterLowPowerMode() {
        return this.isEnterLowPowerMode;
    }

    public boolean isMandatoryUpgrade() {
        return this.isMandatoryUpgrade;
    }

    public DeviceStatus setAuthDevice(boolean z8) {
        this.isAuthDevice = z8;
        return this;
    }

    public DeviceStatus setDevMD5(String str) {
        this.mDevMD5 = str;
        return this;
    }

    public DeviceStatus setEnterLowPowerMode(boolean z8) {
        this.isEnterLowPowerMode = z8;
        return this;
    }

    public DeviceStatus setMandatoryUpgrade(boolean z8) {
        this.isMandatoryUpgrade = z8;
        return this;
    }

    public DeviceStatus setStatus(int i9) {
        this.status = i9;
        return this;
    }

    public DeviceStatus setTargetInfo(TargetInfoResponse targetInfoResponse) {
        this.mTargetInfo = targetInfoResponse;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceStatus{status=");
        sb.append(this.status);
        sb.append(", isAuthDevice=");
        sb.append(this.isAuthDevice);
        sb.append(", isEnterLowPowerMode=");
        sb.append(this.isEnterLowPowerMode);
        sb.append(", isMandatoryUpgrade=");
        sb.append(this.isMandatoryUpgrade);
        sb.append(", mTargetInfo=");
        sb.append(this.mTargetInfo);
        sb.append(", mDevMD5='");
        return a.j(sb, this.mDevMD5, "'}");
    }
}
