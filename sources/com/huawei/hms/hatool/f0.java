package com.huawei.hms.hatool;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f0 extends k0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f15188g = "";

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "3");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f15241d);
        jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.f15238a);
        jSONObject.put("hmac", this.f15188g);
        jSONObject.put("chifer", this.f15243f);
        jSONObject.put("timestamp", this.f15239b);
        jSONObject.put("servicetag", this.f15240c);
        jSONObject.put("requestid", this.f15242e);
        return jSONObject;
    }

    public void g(String str) {
        this.f15188g = str;
    }
}
