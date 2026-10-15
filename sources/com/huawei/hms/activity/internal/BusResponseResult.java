package com.huawei.hms.activity.internal;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class BusResponseResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f14731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14732b;

    public int getCode() {
        return this.f14732b;
    }

    public Intent getIntent() {
        return this.f14731a;
    }

    public void setCode(int i9) {
        this.f14732b = i9;
    }

    public void setIntent(Intent intent) {
        this.f14731a = intent;
    }
}
