package com.starburst.sdk.identity.system;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class SystemDeviceIdentifierProvider {
    private boolean isValid(String str) {
        return (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str)) ? false : true;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public String getDeviceIdentifier(Context context) {
        try {
            String serial = Build.getSerial();
            if (isValid(serial)) {
                return serial;
            }
            return null;
        } catch (Exception unused) {
        }
    }
}
