package com.huawei.hms.framework.network.grs.local.model;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f15141b;

    public Map<String, String> a() {
        return this.f15141b;
    }

    public String b() {
        return this.f15140a;
    }

    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("countryGroup", this.f15140a);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.f15141b.keySet()) {
            jSONObject2.put(str, this.f15141b.get(str));
        }
        jSONObject.put("addresses", jSONObject2);
        return jSONObject;
    }

    public void a(String str) {
        this.f15140a = str;
    }

    public void a(Map<String, String> map) {
        this.f15141b = map;
    }
}
