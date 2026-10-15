package com.starburst.sdk.resp;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class AuthInfoRes {
    public static final String DEFAULT_SIGN_METHOD = "hmacsha256";

    @SerializedName("appId")
    private String appId;
    private String businessSign;
    private String deviceName;

    @SerializedName("expireTime")
    private Long expireTime;
    private String productKey;
    private String signMethod;
    private String timestamp;

    @SerializedName("token")
    private String token;

    public String getAppId() {
        return this.appId;
    }

    public String getBusinessSign() {
        String str = this.businessSign;
        return str == null ? "" : str;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public Long getExpireTime() {
        return this.expireTime;
    }

    public String getProductKey() {
        return this.productKey;
    }

    public String getSignMethod() {
        String str = this.signMethod;
        return str == null ? DEFAULT_SIGN_METHOD : str;
    }

    public String getTimestamp() {
        String str = this.timestamp;
        return str == null ? "" : str;
    }

    public String getToken() {
        return this.token;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBusinessSign(String str) {
        this.businessSign = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setExpireTime(Long l8) {
        this.expireTime = l8;
    }

    public void setProductKey(String str) {
        this.productKey = str;
    }

    public void setSignMethod(String str) {
        this.signMethod = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
