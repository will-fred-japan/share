package com.starburst.sdk.core.auth.model;

import A.a;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class GetTokenResponseBean {
    private String appId;
    private int code;
    private long expireTime;
    private String failReason;
    private String msg;
    private String ppeEnv;
    private String requestId;

    @SerializedName("Token")
    private String token;

    public String getAppId() {
        return this.appId;
    }

    public int getCode() {
        return this.code;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getPpeEnv() {
        return this.ppeEnv;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getToken() {
        return this.token;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCode(int i9) {
        this.code = i9;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setPpeEnv(String str) {
        this.ppeEnv = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthResponse{code=");
        sb.append(this.code);
        sb.append(", msg='");
        sb.append(this.msg);
        sb.append("', failReason='");
        sb.append(this.failReason);
        sb.append("', requestId='");
        sb.append(this.requestId);
        sb.append("', appId='");
        sb.append(this.appId);
        sb.append("', token='");
        sb.append(this.token);
        sb.append("', expireTime=");
        sb.append(this.expireTime);
        sb.append(", ppeEnv='");
        return a.j(sb, this.ppeEnv, "'}");
    }
}
