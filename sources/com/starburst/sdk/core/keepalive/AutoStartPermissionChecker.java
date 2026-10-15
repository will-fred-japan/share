package com.starburst.sdk.core.keepalive;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import com.engagelab.privates.push.constants.MTPushConstants;

/* JADX INFO: loaded from: classes.dex */
public class AutoStartPermissionChecker {
    private static boolean checkHuawei(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
        return isActivityExists(context, intent);
    }

    private static boolean checkMeizu(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("packageName", context.getPackageName());
        return isActivityExists(context, intent);
    }

    private static boolean checkOppo(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        StringBuilder sb = new StringBuilder("op_auto_start_");
        sb.append(context.getPackageName());
        return Settings.Secure.getInt(contentResolver, sb.toString(), 0) == 1;
    }

    private static boolean checkSamsung(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.sm", "com.samsung.android.sm.app.dashboard.SmartManagerDashBoardActivity");
        return isActivityExists(context, intent);
    }

    private static boolean checkVivo(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity");
        return isActivityExists(context, intent);
    }

    private static boolean checkXiaomi(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        StringBuilder sb = new StringBuilder("auto_start_");
        sb.append(context.getPackageName());
        return Settings.Secure.getInt(contentResolver, sb.toString(), 0) == 1;
    }

    private static boolean isActivityExists(Context context, Intent intent) {
        return context.getPackageManager().resolveActivity(intent, 65536) != null;
    }

    public static boolean isAutoStartEnabled(Context context) {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        try {
            if (lowerCase.contains(MTPushConstants.Manufacturer.XIAOMI)) {
                return checkXiaomi(context);
            }
            if (lowerCase.contains(MTPushConstants.Manufacturer.HUAWEI)) {
                return checkHuawei(context);
            }
            if (lowerCase.contains(MTPushConstants.Manufacturer.OPPO)) {
                return checkOppo(context);
            }
            if (lowerCase.contains(MTPushConstants.Manufacturer.VIVO)) {
                return checkVivo(context);
            }
            if (lowerCase.contains("samsung")) {
                return checkSamsung(context);
            }
            if (lowerCase.contains(MTPushConstants.Manufacturer.MEIZU)) {
                return checkMeizu(context);
            }
            return true;
        } catch (Exception e9) {
            e9.printStackTrace();
            return true;
        }
    }
}
