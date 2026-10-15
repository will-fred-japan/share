package com.engagelab.privates.common.sentry.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.sentry.entity.DeviceOrientation;
import com.engagelab.privates.common.utils.DateUtil;
import com.engagelab.privates.common.utils.DeviceUtil;
import com.engagelab.privates.common.utils.SystemUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p130r.b;

/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    private static final String SENTRY_ANDROID_CORE_SDK_PACKAGE = "maven:io.sentry:sentry-android-core";
    private static final String SENTRY_ANDROID_SDK_NAME = "sentry.java.android";
    private static final String SENTRY_SDK_PACKAGE = "maven:io.sentry:sentry";
    private static final String SENTRY_SDK_VERSION = "5.0.1";
    private static final String TAG = "SentryUtils";

    private Utils() {
    }

    public static JSONObject getApp(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_build", Long.toString(DeviceUtil.getAppVersionCode(context)));
            jSONObject.put("app_identifier", DeviceUtil.getPackageName(context));
            jSONObject.put("app_name", DeviceUtil.getAppLabel(context));
            jSONObject.put("app_start_time", DateUtil.getTimestamp(new Date(DeviceUtil.getProcessStartWallTimeMillis())));
            jSONObject.put(Constants.EXTRA_KEY_APP_VERSION, DeviceUtil.getAppVersionName(context));
            return jSONObject;
        } catch (Exception e9) {
            MTCommonLog.d(TAG, "Error getting App." + e9);
            return null;
        }
    }

    public static JSONObject getDevice(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("arch", DeviceUtil.getPrimaryCpuAbi());
            String model = DeviceUtil.getModel();
            jSONObject.put(MTCommonConstants.Network.KEY_NAME, model);
            jSONObject.put("manufacturer", DeviceUtil.getManufacturer());
            jSONObject.put(Constants.PHONE_BRAND, DeviceUtil.getBrand());
            String strInferDeviceFamilyName = DeviceUtil.inferDeviceFamilyName();
            if (!TextUtils.isEmpty(strInferDeviceFamilyName)) {
                jSONObject.put("family", strInferDeviceFamilyName);
            }
            jSONObject.put("model", model);
            jSONObject.put("model_id", Build.ID);
            Intent intentRegisterBatteryStickyIntent = DeviceUtil.registerBatteryStickyIntent(context);
            if (intentRegisterBatteryStickyIntent != null) {
                Float batteryLevelPercent = DeviceUtil.getBatteryLevelPercent(intentRegisterBatteryStickyIntent);
                if (batteryLevelPercent != null) {
                    jSONObject.put("battery_level", batteryLevelPercent);
                }
                Boolean boolIsBatteryCharging = DeviceUtil.isBatteryCharging(intentRegisterBatteryStickyIntent);
                if (boolIsBatteryCharging != null) {
                    jSONObject.put("charging", boolIsBatteryCharging);
                }
                Float batteryTemperatureCelsius = DeviceUtil.getBatteryTemperatureCelsius(intentRegisterBatteryStickyIntent);
                if (batteryTemperatureCelsius != null) {
                    jSONObject.put("battery_temperature", batteryTemperatureCelsius);
                }
            }
            jSONObject.put(b.ONLINE_EXTRAS_KEY, SystemUtil.isNetworkConnecting(context));
            DeviceOrientation.Orientation orientation = getOrientation(context);
            if (orientation != null) {
                jSONObject.put("orientation", orientation.name().toLowerCase(Locale.ROOT));
            }
            jSONObject.put("simulator", false);
            ActivityManager.MemoryInfo memoryInfoQueryMemoryInfo = DeviceUtil.queryMemoryInfo(context);
            if (memoryInfoQueryMemoryInfo != null) {
                jSONObject.put("memory_size", DeviceUtil.getTotalMemBytes(memoryInfoQueryMemoryInfo));
                jSONObject.put("free_memory", memoryInfoQueryMemoryInfo.availMem);
                jSONObject.put("low_memory", memoryInfoQueryMemoryInfo.lowMemory);
            }
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                Long lDirectoryStatTotalBytes = DeviceUtil.directoryStatTotalBytes(externalFilesDir);
                if (lDirectoryStatTotalBytes != null) {
                    jSONObject.put("storage_size", lDirectoryStatTotalBytes);
                }
                Long lDirectoryStatAvailableBytes = DeviceUtil.directoryStatAvailableBytes(externalFilesDir);
                if (lDirectoryStatAvailableBytes != null) {
                    jSONObject.put("free_storage", lDirectoryStatAvailableBytes);
                }
                Long lNonPrimaryExternalTotalBytes = DeviceUtil.nonPrimaryExternalTotalBytes(externalFilesDir, context);
                if (lNonPrimaryExternalTotalBytes != null) {
                    jSONObject.put("external_storage_size", lNonPrimaryExternalTotalBytes);
                }
                Long lNonPrimaryExternalAvailableBytes = DeviceUtil.nonPrimaryExternalAvailableBytes(externalFilesDir, context);
                if (lNonPrimaryExternalAvailableBytes != null) {
                    jSONObject.put("external_free_storage", lNonPrimaryExternalAvailableBytes);
                }
            }
            DisplayMetrics displayMetricsOrNull = DeviceUtil.getDisplayMetricsOrNull(context);
            if (displayMetricsOrNull != null) {
                jSONObject.put("screen_width_pixels", displayMetricsOrNull.widthPixels);
                jSONObject.put("screen_height_pixels", displayMetricsOrNull.heightPixels);
                jSONObject.put("screen_density", displayMetricsOrNull.density);
                jSONObject.put("screen_dpi", displayMetricsOrNull.densityDpi);
            }
            jSONObject.put("boot_time", DateUtil.getTimestamp(new Date(System.currentTimeMillis() - SystemClock.elapsedRealtime())));
            jSONObject.put("timezone", DeviceUtil.getTimeZoneId());
            String deviceId = MTGlobal.getDeviceId(context);
            if (!TextUtils.isEmpty(deviceId)) {
                jSONObject.put("id", deviceId);
            }
            jSONObject.put("language", DeviceUtil.getLanguage(context));
            jSONObject.put("connection_type", SystemUtil.getNetworkConnectionType(context));
            return jSONObject;
        } catch (JSONException e9) {
            MTCommonLog.d(TAG, "Error getting Device." + e9);
            return null;
        }
    }

    public static JSONObject getOperatingSystem(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("build", Build.DISPLAY);
            jSONObject.put("kernel_version", DeviceUtil.getKernelVersion());
            jSONObject.put(MTCommonConstants.Network.KEY_NAME, "Android");
            jSONObject.put("rooted", false);
            jSONObject.put("version", DeviceUtil.getSystemVersionRelease());
            return jSONObject;
        } catch (JSONException e9) {
            MTCommonLog.d(TAG, "Error getting OperatingSystem." + e9);
            return null;
        }
    }

    private static DeviceOrientation.Orientation getOrientation(Context context) {
        try {
            DeviceOrientation.Orientation orientation = DeviceOrientation.getOrientation(context.getResources().getConfiguration().orientation);
            if (orientation != null) {
                return orientation;
            }
            MTCommonLog.i(TAG, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)");
            return null;
        } catch (Exception e9) {
            MTCommonLog.d(TAG, "Error getting device orientation." + e9);
            return null;
        }
    }

    public static JSONObject getSdkVersion() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MTCommonConstants.Network.KEY_NAME, SENTRY_ANDROID_SDK_NAME);
            jSONObject.put("version", SENTRY_SDK_VERSION);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MTCommonConstants.Network.KEY_NAME, SENTRY_SDK_PACKAGE);
            jSONObject2.put("version", SENTRY_SDK_VERSION);
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MTCommonConstants.Network.KEY_NAME, SENTRY_ANDROID_CORE_SDK_PACKAGE);
            jSONObject3.put("version", SENTRY_SDK_VERSION);
            jSONArray.put(jSONObject3);
            jSONObject.put("packages", jSONArray);
            return jSONObject;
        } catch (JSONException e9) {
            MTCommonLog.d(TAG, "Error getting SDK version." + e9);
            return null;
        }
    }

    public static JSONObject getUser(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", MTGlobal.getAppKey(context) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + MTGlobal.getDeviceId(context));
            return jSONObject;
        } catch (JSONException e9) {
            MTCommonLog.d(TAG, "Error getting user." + e9);
            return null;
        }
    }
}
