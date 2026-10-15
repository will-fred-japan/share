package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class y0 extends t0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f15330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f15331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f15332h;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f15332h);
        jSONObject.put("_emui_ver", this.f15313a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f15330f);
        jSONObject.put("_mnc", this.f15331g);
        jSONObject.put("_package_name", this.f15314b);
        jSONObject.put("_app_ver", this.f15315c);
        jSONObject.put("_lib_ver", "2.2.0.315");
        jSONObject.put("_channel", this.f15316d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f15317e);
        return jSONObject;
    }

    public void f(String str) {
        this.f15330f = str;
    }

    public void g(String str) {
        this.f15331g = str;
    }

    public void h(String str) {
        this.f15332h = str;
    }
}
