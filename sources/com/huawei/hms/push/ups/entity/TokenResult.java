package com.huawei.hms.push.ups.entity;

/* JADX INFO: loaded from: classes.dex */
public class TokenResult extends CodeResult {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15488c;

    public TokenResult() {
    }

    public String getToken() {
        return this.f15488c;
    }

    public void setToken(String str) {
        this.f15488c = str;
    }

    public TokenResult(int i9) {
        super(i9);
    }

    public TokenResult(int i9, String str) {
        super(i9, str);
    }

    public TokenResult(String str) {
        this.f15488c = str;
    }
}
