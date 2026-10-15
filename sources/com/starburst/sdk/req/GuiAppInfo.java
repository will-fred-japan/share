package com.starburst.sdk.req;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class GuiAppInfo {

    @SerializedName("appName")
    private String appName;
    private String description;

    @SerializedName("packageName")
    private String packageName;

    public GuiAppInfo() {
    }

    public String getAppName() {
        return this.appName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public GuiAppInfo(String str, String str2, String str3) {
        this.appName = str;
        this.packageName = str2;
        this.description = str3;
    }
}
