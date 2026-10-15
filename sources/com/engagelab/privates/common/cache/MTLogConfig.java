package com.engagelab.privates.common.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.engagelab.privates.common.global.MTGlobal;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MTLogConfig {
    private static final String CTRL_CONFIG_CONTENT = "ctrl_config_content";
    private static final String CTRL_CONFIG_UPDATE_TIME = "ctrl_config_update_time";
    private static final String NAME = "com.engagelab.privates.common.prefs.log";
    private static Map<String, SharedPreferences> mapSharedPreferences = new HashMap();

    public static String getCtrlConfigContent(Context context) {
        return getSP(context).getString(CTRL_CONFIG_CONTENT, "");
    }

    public static long getCtrlConfigUpdateTime(Context context) {
        return getSP(context).getLong(CTRL_CONFIG_UPDATE_TIME, 0L);
    }

    private static SharedPreferences getSP(Context context) {
        String str = "com.engagelab.privates.common.prefs.log." + MTGlobal.getAppKey(context);
        SharedPreferences sharedPreferences = mapSharedPreferences.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        mapSharedPreferences.put(str, sharedPreferences2);
        return sharedPreferences2;
    }

    public static void setCtrlConfigContent(Context context, String str) {
        getSP(context).edit().putString(CTRL_CONFIG_CONTENT, str).commit();
    }

    public static void setCtrlConfigUpdateTime(Context context, long j) {
        getSP(context).edit().putLong(CTRL_CONFIG_UPDATE_TIME, j).commit();
    }
}
