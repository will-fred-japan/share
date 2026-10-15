package com.engagelab.privates.common.monitor;

import A.f;
import android.content.Context;
import android.content.SharedPreferences;
import com.engagelab.privates.common.global.MTGlobal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class CrashCountCache {
    private static final String KEY_ANR_COUNT = "anr_count";
    private static final String KEY_COLD_START_COUNT = "cold_start_count";
    private static final String KEY_CRASH_COUNT = "crash_count";
    private static final String KEY_FIRST_ANR_TIME = "first_anr_time";
    private static final String KEY_FIRST_COLD_START_TIME = "first_cold_start_time";
    private static final String KEY_FIRST_CRASH_TIME = "first_crash_time";
    private static final String KEY_LAST_REPORT_DAY = "last_report_day";
    private static final String NAME = "com.engagelab.privates.common.prefs.crash_count";
    private static final Map<String, SharedPreferences> mapSP = new ConcurrentHashMap();

    public static int getAnrCount(Context context) {
        return getSP(context).getInt(KEY_ANR_COUNT, 0);
    }

    public static int getColdStartCount(Context context) {
        return getSP(context).getInt(KEY_COLD_START_COUNT, 0);
    }

    public static int getCrashCount(Context context) {
        return getSP(context).getInt(KEY_CRASH_COUNT, 0);
    }

    public static long getFirstAnrTime(Context context) {
        return getSP(context).getLong(KEY_FIRST_ANR_TIME, 0L);
    }

    public static long getFirstColdStartTime(Context context) {
        return getSP(context).getLong(KEY_FIRST_COLD_START_TIME, 0L);
    }

    public static long getFirstCrashTime(Context context) {
        return getSP(context).getLong(KEY_FIRST_CRASH_TIME, 0L);
    }

    public static String getLastReportDay(Context context) {
        return getSP(context).getString(KEY_LAST_REPORT_DAY, "");
    }

    private static SharedPreferences getSP(Context context) {
        String str = "com.engagelab.privates.common.prefs.crash_count." + MTGlobal.getAppKey(context);
        Map<String, SharedPreferences> map = mapSP;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        return sharedPreferences2;
    }

    public static void incrementAnrCount(Context context) {
        SharedPreferences sp = getSP(context);
        SharedPreferences.Editor editorEdit = sp.edit();
        editorEdit.putInt(KEY_ANR_COUNT, sp.getInt(KEY_ANR_COUNT, 0) + 1);
        if (sp.getLong(KEY_FIRST_ANR_TIME, 0L) == 0) {
            editorEdit.putLong(KEY_FIRST_ANR_TIME, System.currentTimeMillis());
        }
        editorEdit.apply();
    }

    public static void incrementColdStartCount(Context context) {
        SharedPreferences sp = getSP(context);
        SharedPreferences.Editor editorEdit = sp.edit();
        editorEdit.putInt(KEY_COLD_START_COUNT, sp.getInt(KEY_COLD_START_COUNT, 0) + 1);
        if (sp.getLong(KEY_FIRST_COLD_START_TIME, 0L) == 0) {
            editorEdit.putLong(KEY_FIRST_COLD_START_TIME, System.currentTimeMillis());
        }
        editorEdit.apply();
    }

    public static void incrementCrashCount(Context context) {
        SharedPreferences sp = getSP(context);
        SharedPreferences.Editor editorEdit = sp.edit();
        editorEdit.putInt(KEY_CRASH_COUNT, sp.getInt(KEY_CRASH_COUNT, 0) + 1);
        if (sp.getLong(KEY_FIRST_CRASH_TIME, 0L) == 0) {
            editorEdit.putLong(KEY_FIRST_CRASH_TIME, System.currentTimeMillis());
        }
        editorEdit.apply();
    }

    public static void resetAnrCount(Context context) {
        getSP(context).edit().putInt(KEY_ANR_COUNT, 0).putLong(KEY_FIRST_ANR_TIME, 0L).apply();
    }

    public static void resetColdStartCount(Context context) {
        getSP(context).edit().putInt(KEY_COLD_START_COUNT, 0).putLong(KEY_FIRST_COLD_START_TIME, 0L).apply();
    }

    public static void resetCrashCount(Context context) {
        getSP(context).edit().putInt(KEY_CRASH_COUNT, 0).putLong(KEY_FIRST_CRASH_TIME, 0L).apply();
    }

    public static void setLastReportDay(Context context, String str) {
        f.k(getSP(context), KEY_LAST_REPORT_DAY, str);
    }

    public static String today() {
        return new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date());
    }
}
