package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import defpackage.f;

/* JADX INFO: loaded from: classes.dex */
public class EnableConsentReq implements IMessageEntity {

    @Packed
    private boolean enable;

    @Packed
    private String packageName;

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z8) {
        this.enable = z8;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConsentReq{packageName:");
        sb.append(this.packageName);
        sb.append(", enable:");
        return f.g(sb, this.enable, '}');
    }
}
