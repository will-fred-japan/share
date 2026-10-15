package com.huawei.hms.hatool;

import android.text.TextUtils;
import cn.jpush.android.api.InAppSlotParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b1 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15169f;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f15164a);
        jSONObject.put("eventtime", this.f15167d);
        jSONObject.put(InAppSlotParams.SLOT_KEY.EVENT, this.f15165b);
        jSONObject.put("event_session_name", this.f15168e);
        jSONObject.put("first_session_event", this.f15169f);
        if (TextUtils.isEmpty(this.f15166c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f15166c));
        return jSONObject;
    }

    public String b() {
        return this.f15167d;
    }

    public String c() {
        return this.f15164a;
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObjectA = a();
        jSONObjectA.put("properties", n.b(this.f15166c, o0.d().a()));
        return jSONObjectA;
    }

    public void e(String str) {
        this.f15169f = str;
    }

    public void f(String str) {
        this.f15168e = str;
    }

    public void a(String str) {
        this.f15166c = str;
    }

    public void b(String str) {
        this.f15165b = str;
    }

    public void c(String str) {
        this.f15167d = str;
    }

    public void d(String str) {
        this.f15164a = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f15165b = jSONObject.optString(InAppSlotParams.SLOT_KEY.EVENT);
        this.f15166c = n.a(jSONObject.optString("properties"), o0.d().a());
        this.f15164a = jSONObject.optString("type");
        this.f15167d = jSONObject.optString("eventtime");
        this.f15168e = jSONObject.optString("event_session_name");
        this.f15169f = jSONObject.optString("first_session_event");
    }
}
