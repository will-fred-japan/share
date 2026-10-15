package com.hihonor.push.sdk.common;

import com.hihonor.push.sdk.e;
import com.hihonor.push.sdk.i;

/* JADX INFO: loaded from: classes.dex */
public class RequestHeader implements e {

    @i
    private String AAID;

    @i
    private String appId;

    @i
    private String certificateFingerprint;

    @i
    private String packageName;

    @i
    private String pushToken;

    @i
    private int sdkVersion;

    public String getAAID() {
        return this.AAID;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getCertificateFingerprint() {
        return this.certificateFingerprint;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public int getSdkVersion() {
        return this.sdkVersion;
    }

    public void setAAID(String str) {
        this.AAID = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCertificateFingerprint(String str) {
        this.certificateFingerprint = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPushToken(String str) {
        this.pushToken = str;
    }

    public void setSdkVersion(int i9) {
        this.sdkVersion = i9;
    }
}
