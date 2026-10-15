package com.huawei.hms.api;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class HuaweiServicesRepairableException extends UserRecoverableException {
    private final int statusCode;

    public HuaweiServicesRepairableException(int i9, String str, Intent intent) {
        super(str, intent);
        this.statusCode = i9;
    }

    public int getConnectionStatusCode() {
        return this.statusCode;
    }
}
