package com.engagelab.privates.flutter_plugin_engagelab;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.core.api.MTCorePrivatesApi;

/* JADX INFO: loaded from: classes.dex */
public class MTApplication extends Application {
    private static final String TAG = "ENGAGELAB-MTApplication";

    private static String getMetaData(Context context, String str) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            return (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get(str)) == null) ? "" : String.valueOf(obj);
        } catch (Throwable th) {
            Log.w(TAG, "getMetaData failed " + th.getMessage());
        }
        return "";
    }

    private static boolean isTrue(String str) {
        return "true".equals(str);
    }

    public static void setConfig(Context context) {
        String metaData = getMetaData(context, "APP_TCP_SSL");
        String metaData2 = getMetaData(context, "APP_DEBUG");
        Log.d(TAG, "APP_TCP_SSL:" + metaData);
        Log.d(TAG, "APP_DEBUG:" + metaData2);
        MTCorePrivatesApi.setTcpSSl(isTrue(metaData));
        MTCorePrivatesApi.configDebugMode(context, isTrue(metaData2));
        String metaData3 = getMetaData(context, "COUNTRY_CODE");
        Log.d(TAG, "COUNTRY_CODE:" + metaData3);
        if (TextUtils.isEmpty(metaData3)) {
            return;
        }
        MTGlobal.setCountryCode(metaData3);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        setConfig(getApplicationContext());
    }
}
