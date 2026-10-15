package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16985a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f65a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return !TextUtils.isEmpty(nVar.f65a) && nVar.f65a.equals(this.f65a);
    }
}
