package com.xiaomi.push;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class bq extends JSONArray implements bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17098a = 2;

    @Override // com.xiaomi.push.bp
    public int a() {
        return (length() - 1) + this.f17098a;
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object obj) {
        if (obj instanceof bp) {
            this.f17098a = ((bp) obj).a() + this.f17098a;
        }
        return super.put(obj);
    }
}
