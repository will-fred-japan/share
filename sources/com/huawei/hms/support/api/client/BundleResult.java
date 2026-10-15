package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class BundleResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f15520b;

    public BundleResult(int i9, Bundle bundle) {
        this.f15519a = i9;
        this.f15520b = bundle;
    }

    public int getResultCode() {
        return this.f15519a;
    }

    public Bundle getRspBody() {
        return this.f15520b;
    }

    public void setResultCode(int i9) {
        this.f15519a = i9;
    }

    public void setRspBody(Bundle bundle) {
        this.f15520b = bundle;
    }
}
