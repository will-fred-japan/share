package com.starburst.sdk.core.auth.model;

import A.a;

/* JADX INFO: loaded from: classes.dex */
public class DeviceRegisterRespBean {
    private int code;
    private String deviceName;
    private String deviceSecret;
    private String failReason;
    private String msg;
    private String productKey;
    private String requestId;

    public int getCode() {
        return this.code;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceSecret() {
        return this.deviceSecret;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getProductKey() {
        return this.productKey;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setCode(int i9) {
        this.code = i9;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceSecret(String str) {
        this.deviceSecret = str;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setProductKey(String str) {
        this.productKey = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceResponse{code=");
        sb.append(this.code);
        sb.append(", msg='");
        sb.append(this.msg);
        sb.append("', failReason='");
        sb.append(this.failReason);
        sb.append("', requestId='");
        sb.append(this.requestId);
        sb.append("', productKey='");
        sb.append(this.productKey);
        sb.append("', deviceName='");
        sb.append(this.deviceName);
        sb.append("', deviceSecret='");
        return a.j(sb, this.deviceSecret, "'}");
    }
}
