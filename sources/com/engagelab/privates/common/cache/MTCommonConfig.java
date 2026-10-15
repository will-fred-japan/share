package com.engagelab.privates.common.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.engagelab.privates.common.global.MTGlobal;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MTCommonConfig {
    private static final String DEVICE_ID = "device_id";
    private static final String NAME = "com.engagelab.privates.common.prefs";
    private static Map<String, SharedPreferences> mapSharedPreferences = new HashMap();

    public static String getDeviceId(Context context) {
        return getSP(context).getString(DEVICE_ID, "");
    }

    private static SharedPreferences getSP(Context context) {
        String str = "com.engagelab.privates.common.prefs." + MTGlobal.getAppKey(context);
        SharedPreferences sharedPreferences = mapSharedPreferences.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        mapSharedPreferences.put(str, sharedPreferences2);
        return sharedPreferences2;
    }

    public static void setDeviceId(Context context, String str) {
        getSP(context).edit().putString(DEVICE_ID, str).commit();
    }
}
