package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: classes.dex */
public class SecurityCommonException extends Exception {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f15967c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15969b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.f15969b;
    }

    public String getRetCd() {
        return this.f15968a;
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f15969b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f15968a = str;
        this.f15969b = str2;
    }
}
