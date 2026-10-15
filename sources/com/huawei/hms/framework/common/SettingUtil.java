package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class SettingUtil {
    private static final String TAG = "SettingUtil";

    public static int getSecureInt(ContentResolver contentResolver, String str, int i9) {
        try {
            return Settings.Secure.getInt(contentResolver, str, i9);
        } catch (RuntimeException e9) {
            Logger.e(TAG, "Settings Secure getInt throwFromSystemServer:", e9);
            return i9;
        }
    }

    public static int getSystemInt(ContentResolver contentResolver, String str, int i9) {
        try {
            return Settings.System.getInt(contentResolver, str, i9);
        } catch (RuntimeException e9) {
            Logger.e(TAG, "Settings System getInt throwFromSystemServer:", e9);
            return i9;
        }
    }
}
