package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.PackageManager;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public class PackageUtils {
    private static final String TAG = "PackageUtils";

    public static String getVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), Http2.INITIAL_MAX_FRAME_SIZE).versionName;
        } catch (PackageManager.NameNotFoundException | RuntimeException e9) {
            Logger.w(TAG, "", e9);
            return "";
        }
    }
}
