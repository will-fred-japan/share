package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class HonorPushDataMsg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14425a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14426b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14428d;

    public String getData() {
        return this.f14428d;
    }

    public long getMsgId() {
        return this.f14427c;
    }

    public int getType() {
        return this.f14426b;
    }

    public int getVersion() {
        return this.f14425a;
    }

    public void setData(String str) {
        this.f14428d = str;
    }

    public void setMsgId(long j) {
        this.f14427c = j;
    }

    public void setType(int i9) {
        this.f14426b = i9;
    }

    public void setVersion(int i9) {
        this.f14425a = i9;
    }
}
