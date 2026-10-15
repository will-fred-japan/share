package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* JADX INFO: loaded from: classes.dex */
public class BaseException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ErrorEnum f15365b;

    public BaseException(int i9) {
        ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(i9);
        this.f15365b = errorEnumFromCode;
        this.f15364a = errorEnumFromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f15364a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f15365b.getMessage();
    }
}
