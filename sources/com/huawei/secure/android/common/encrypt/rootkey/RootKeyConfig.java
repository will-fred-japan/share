package com.huawei.secure.android.common.encrypt.rootkey;

/* JADX INFO: loaded from: classes.dex */
public class RootKeyConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f15768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f15771g;

    public RootKeyConfig(String str, String str2, String str3, byte[] bArr, int i9, int i10, boolean z8) {
        this.f15765a = str;
        this.f15766b = str2;
        this.f15767c = str3;
        this.f15768d = bArr;
        this.f15769e = i9;
        this.f15770f = i10;
        this.f15771g = z8;
    }

    public int getExportLen() {
        return this.f15770f;
    }

    public String getFirst() {
        return this.f15765a;
    }

    public int getIteration() {
        return this.f15769e;
    }

    public byte[] getSalt() {
        return this.f15768d;
    }

    public String getSecond() {
        return this.f15766b;
    }

    public String getThird() {
        return this.f15767c;
    }

    public boolean isSha256() {
        return this.f15771g;
    }

    public void setExportLen(int i9) {
        this.f15770f = i9;
    }

    public void setFirst(String str) {
        this.f15765a = str;
    }

    public void setIteration(int i9) {
        this.f15769e = i9;
    }

    public void setSalt(byte[] bArr) {
        this.f15768d = bArr;
    }

    public void setSecond(String str) {
        this.f15766b = str;
    }

    public void setSha256(boolean z8) {
        this.f15771g = z8;
    }

    public void setThird(String str) {
        this.f15767c = str;
    }
}
