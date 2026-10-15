package com.xiaomi.push;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class co {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f17147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17148c;

    public co() {
        this(0, 0L, 0L, null);
    }

    public int a() {
        return this.f17146a;
    }

    public co(int i9, long j, long j8, Exception exc) {
        this.f17146a = i9;
        this.f188a = j;
        this.f17148c = j8;
        this.f17147b = System.currentTimeMillis();
        if (exc != null) {
            this.f189a = exc.getClass().getSimpleName();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public JSONObject m160a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f188a);
        jSONObject.put("size", this.f17148c);
        jSONObject.put("ts", this.f17147b);
        jSONObject.put("wt", this.f17146a);
        jSONObject.put("expt", this.f189a);
        return jSONObject;
    }

    public co a(JSONObject jSONObject) {
        this.f188a = jSONObject.getLong("cost");
        this.f17148c = jSONObject.getLong("size");
        this.f17147b = jSONObject.getLong("ts");
        this.f17146a = jSONObject.getInt("wt");
        this.f189a = jSONObject.optString("expt");
        return this;
    }
}
