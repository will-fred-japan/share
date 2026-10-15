package com.huawei.hms.push.ups.entity;

/* JADX INFO: loaded from: classes.dex */
public class CodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15487b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f15487b;
    }

    public int getReturnCode() {
        return this.f15486a;
    }

    public void setReason(String str) {
        this.f15487b = str;
    }

    public void setReturnCode(int i9) {
        this.f15486a = i9;
    }

    public CodeResult(int i9) {
        this.f15486a = i9;
    }

    public CodeResult(int i9, String str) {
        this.f15486a = i9;
        this.f15487b = str;
    }
}
