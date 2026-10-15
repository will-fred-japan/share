package com.huawei.hms.hatool;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15244b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15245c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15246d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15247e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f15248f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f15249g;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f15312a);
        jSONObject.put("oaid", this.f15249g);
        jSONObject.put("uuid", this.f15248f);
        jSONObject.put("upid", this.f15247e);
        jSONObject.put("imei", this.f15244b);
        jSONObject.put("sn", this.f15245c);
        jSONObject.put("udid", this.f15246d);
        return jSONObject;
    }

    public void b(String str) {
        this.f15244b = str;
    }

    public void c(String str) {
        this.f15249g = str;
    }

    public void d(String str) {
        this.f15245c = str;
    }

    public void e(String str) {
        this.f15246d = str;
    }

    public void f(String str) {
        this.f15247e = str;
    }

    public void g(String str) {
        this.f15248f = str;
    }
}
