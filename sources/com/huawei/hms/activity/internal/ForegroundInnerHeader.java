package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundInnerHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14737c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f14735a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.f14736b = JsonUtil.getStringValue(jSONObject, "action");
            this.f14737c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e9) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e9.getMessage());
        }
    }

    public String getAction() {
        return this.f14736b;
    }

    public int getApkVersion() {
        return this.f14735a;
    }

    public String getResponseCallbackKey() {
        return this.f14737c;
    }

    public void setAction(String str) {
        this.f14736b = str;
    }

    public void setApkVersion(int i9) {
        this.f14735a = i9;
    }

    public void setResponseCallbackKey(String str) {
        this.f14737c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f14735a);
            jSONObject.put("action", this.f14736b);
            jSONObject.put("responseCallbackKey", this.f14737c);
        } catch (JSONException e9) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e9.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.f14735a + ", action:" + this.f14736b + ", responseCallbackKey:" + this.f14737c;
    }
}
