package com.starburst.sdk.core.device.bt.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class AuthCache implements Serializable {
    private String appId;
    private String ds;
    private long expiretime;
    private String ppeEnv;
    private boolean ppeEnvCached;
    private String sign2;
    private String timestamp2;
    private String token;

    public String getAppId() {
        return this.appId;
    }

    public String getDs() {
        return this.ds;
    }

    public long getExpiretime() {
        return this.expiretime;
    }

    public String getPpeEnv() {
        return this.ppeEnv;
    }

    public String getSign2() {
        return this.sign2;
    }

    public String getTimestamp2() {
        return this.timestamp2;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isPpeEnvCached() {
        return this.ppeEnvCached;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setDs(String str) {
        this.ds = str;
    }

    public void setExpiretime(long j) {
        this.expiretime = j;
    }

    public void setPpeEnv(String str) {
        this.ppeEnv = str;
    }

    public void setPpeEnvCached(boolean z8) {
        this.ppeEnvCached = z8;
    }

    public void setSign2(String str) {
        this.sign2 = str;
    }

    public void setTimestamp2(String str) {
        this.timestamp2 = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
