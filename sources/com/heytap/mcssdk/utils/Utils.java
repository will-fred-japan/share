package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.mcssdk.PushService;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static String getString(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i9 : iArr) {
            sb.append((char) i9);
        }
        return sb.toString();
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e9) {
            e.b("getVersionCode--Exception:" + e9.getMessage());
            return 0;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e9) {
            e.b("getVersionName--Exception:" + e9.getMessage());
            return "0";
        }
    }

    public static boolean isExistPackage(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e9) {
            e.e("isExistPackage NameNotFoundException:" + e9.getMessage());
            return false;
        }
    }

    public static boolean isSupportPush(Context context, String str, String str2) {
        StringBuilder sb;
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            return (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.getBoolean(str2, false)) ? false : true;
        } catch (PackageManager.NameNotFoundException e9) {
            e = e9;
            sb = new StringBuilder("isSupportPush NameNotFoundException:");
            sb.append(e.getMessage());
            e.e(sb.toString());
            return false;
        } catch (Exception e10) {
            e = e10;
            sb = new StringBuilder("isSupportPush Exception:");
            sb.append(e.getMessage());
            e.e(sb.toString());
            return false;
        }
    }

    public static boolean isSupportPushByClient(Context context) {
        return PushService.getInstance().isSupportPushByClient(context);
    }

    public static int parseInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e9) {
            e.e("parseInt--NumberFormatException" + e9.getMessage());
            return -1;
        }
    }

    public static int getVersionCode(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e9) {
            e.b("getVersionCode--Exception:" + e9.getMessage());
            return 0;
        }
    }

    public static String getVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e9) {
            e.b("getVersionName--Exception:" + e9.getMessage());
            return null;
        }
    }
}
