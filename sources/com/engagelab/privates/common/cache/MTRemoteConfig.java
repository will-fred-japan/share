package com.engagelab.privates.common.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.engagelab.privates.common.global.MTGlobal;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MTRemoteConfig {
    private static final String CRASH_COUNT_ENABLE = "crash_count_enable";
    private static final String INIT_TIME_MONITOR_ENABLE = "init_time_monitor_enable";
    private static final String LAST_UPDATE_TIME = "remote_config_last_update_time";
    private static final String NAME = "com.engagelab.privates.common.prefs.remote_config";
    private static final String RESPONSE_STRING = "remote_config_response_string";
    private static final String SENTRY_CRASH_LOG_ENABLE = "sentry_crash_log_enable";
    private static final String VERSION = "remote_config_version";
    private static Map<String, SharedPreferences> mapSharedPreferences = new HashMap();

    public enum InitTimeMonitorState {
        UNKNOWN,
        ENABLED,
        DISABLED
    }

    public static long getLastUpdateTime(Context context) {
        return getSP(context).getLong(LAST_UPDATE_TIME, 0L);
    }

    public static String getResponseString(Context context) {
        return getSP(context).getString(RESPONSE_STRING, "");
    }

    private static SharedPreferences getSP(Context context) {
        String str = "com.engagelab.privates.common.prefs.remote_config." + MTGlobal.getAppKey(context);
        SharedPreferences sharedPreferences = mapSharedPreferences.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        mapSharedPreferences.put(str, sharedPreferences2);
        return sharedPreferences2;
    }

    public static String getVersion(Context context) {
        return getSP(context).getString(VERSION, "0");
    }

    public static boolean isCrashCountEnable(Context context) {
        return getSP(context).getBoolean(CRASH_COUNT_ENABLE, true);
    }

    public static InitTimeMonitorState isInitTimeMonitorEnable(Context context) {
        if (getSP(context).contains(INIT_TIME_MONITOR_ENABLE)) {
            return getSP(context).getBoolean(INIT_TIME_MONITOR_ENABLE, false) ? InitTimeMonitorState.ENABLED : InitTimeMonitorState.DISABLED;
        }
        return InitTimeMonitorState.UNKNOWN;
    }

    public static boolean isSentryCrashLogEnable(Context context) {
        return getSP(context).getBoolean(SENTRY_CRASH_LOG_ENABLE, false);
    }

    public static void setCrashCountEnable(Context context, boolean z8) {
        getSP(context).edit().putBoolean(CRASH_COUNT_ENABLE, z8).commit();
    }

    public static void setInitTimeMonitorEnable(Context context, boolean z8) {
        getSP(context).edit().putBoolean(INIT_TIME_MONITOR_ENABLE, z8).commit();
    }

    public static void setLastUpdateTime(Context context, long j) {
        getSP(context).edit().putLong(LAST_UPDATE_TIME, j).commit();
    }

    public static void setResponseString(Context context, String str) {
        getSP(context).edit().putString(RESPONSE_STRING, str).commit();
    }

    public static void setSentryCrashLogEnable(Context context, boolean z8) {
        getSP(context).edit().putBoolean(SENTRY_CRASH_LOG_ENABLE, z8).commit();
    }

    public static void setVersion(Context context, String str) {
        getSP(context).edit().putString(VERSION, str).commit();
    }
}
