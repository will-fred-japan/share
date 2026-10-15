package com.engagelab.privates.core.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.annotation.AllAPI;
import com.engagelab.privates.common.annotation.EngagelabAPI;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObservable;
import com.engagelab.privates.common.v;
import com.engagelab.privates.common.x;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;

/* JADX INFO: loaded from: classes.dex */
@AllAPI
public class MTCorePrivatesApi {

    @AllAPI
    public static final int SDK_VERSION_CODE = 542;

    @AllAPI
    public static final String SDK_VERSION_NAME = "5.4.2";
    private static final String TAG = "MTCorePrivatesApi";

    @AllAPI
    public static void configAppChannel(Context context, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "configAppChannel context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "configAppChannel appChannel can't be empty, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putString(MTCoreConstants.Config.APP_CHANNEL, str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.SET_CONFIG, bundle);
            MTGlobal.setAppChannel(str);
        }
    }

    @AllAPI
    public static void configAppKey(Context context, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "configAppKey context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "configAppKey appKey can't be empty, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putString(MTCoreConstants.Config.APP_KEY, str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.SET_CONFIG, bundle);
            MTGlobal.setAppKey(str);
            MTCoreGlobal.setRegistrationId("");
            MTCoreGlobal.setUserId(0L);
            MTCoreGlobal.setPassword("");
            MTCoreGlobal.setLoginCode(-1);
            MTCoreGlobal.setRegisterCode(-1);
        }
    }

    @AllAPI
    public static void configAppSiteName(Context context, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "configAppSiteName context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "configAppSiteName appSiteName can't be empty, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putString(MTCoreConstants.Config.APP_SITE_NAME, str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.SET_CONFIG, bundle);
            MTGlobal.setAppSiteName(str);
        }
    }

    @AllAPI
    public static void configConnectRetryCount(Context context, int i9) {
        if (context == null) {
            MTCoreGlobal.setConnectRetryCount(i9);
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCoreGlobal.setConnectRetryCount(i9);
        }
    }

    @AllAPI
    public static void configDebugMode(Context context, boolean z8) {
        if (context == null) {
            MTGlobal.setDebugMode(z8);
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MTCoreConstants.Config.DEBUG_MODE, z8);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.SET_CONFIG, bundle);
            MTGlobal.setDebugMode(z8);
        }
    }

    @AllAPI
    public static void configHeartbeatInterval(Context context, long j) {
        if (context == null) {
            MTCoreGlobal.setHeartbeatInterval(j);
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCoreGlobal.setHeartbeatInterval(j);
        }
    }

    @AllAPI
    public static void configSM4(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "configSM4 context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTGlobal.setEncryptType(2);
        }
    }

    @AllAPI
    public static void configWakeAndBeWake(Context context, boolean z8) {
        if (context == null) {
            MTCommonLog.e(TAG, "configWakeAndBeWake context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCoreGlobal.setWakeAndBeWakeState(z8);
        }
    }

    @AllAPI
    public static int getLoginCode(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getLoginCode context can't be null, please check it");
            return 0;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getLoginCode(context);
        }
        if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            return x.f(context.getApplicationContext());
        }
        return 0;
    }

    @AllAPI
    public static String getPassword(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getPassword context can't be null, please check it");
            return "";
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getPassword(context);
        }
        return MTGlobal.isRemoteProcess(context.getApplicationContext()) ? x.h(context.getApplicationContext()) : "";
    }

    @AllAPI
    public static int getRegisterCode(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getRegisterCode context can't be null, please check it");
            return 0;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getRegisterCode(context);
        }
        if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            return x.j(context.getApplicationContext());
        }
        return 0;
    }

    @AllAPI
    public static String getRegistrationId(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getRegistrationId context can't be null, please check it");
            return "";
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getRegistrationId(context);
        }
        return MTGlobal.isRemoteProcess(context.getApplicationContext()) ? x.k(context.getApplicationContext()) : "";
    }

    @AllAPI
    public static int getSeedId(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getSeedId context can't be null, please check it");
            return 0;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getSeedId(context);
        }
        if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            return x.l(context.getApplicationContext());
        }
        return 0;
    }

    @AllAPI
    public static long getServerTime(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getServerTime context can't be null, please check it");
            return 0L;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getServerTime(context);
        }
        if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            return x.m(context.getApplicationContext());
        }
        return 0L;
    }

    @AllAPI
    public static long getUserId(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getUserId context can't be null, please check it");
            return 0L;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getUserId(context);
        }
        if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            return x.s(context.getApplicationContext());
        }
        return 0L;
    }

    @AllAPI
    public static boolean isConnectContinue(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "isConnectContinue context can't be null, please check it");
            return false;
        }
        if (!MTGlobal.isMainProcess(context.getApplicationContext()) && !MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            return false;
        }
        for (String str : MTObservable.getInstance().observeNameQueue) {
            if (TextUtils.equals(str, "com.engagelab.privates.push.MTPush") || TextUtils.equals(str, "com.engagelab.privates.message.MTMessage")) {
                return true;
            }
        }
        return false;
    }

    @AllAPI
    public static void setEnableResetOnDeviceChange(Context context, boolean z8) {
        if (context == null) {
            MTCommonLog.e(TAG, "setEnableResetOnDeviceChange context can't be null, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MTCoreConstants.Config.DEVICE_MIGRATION, z8);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.SET_CONFIG, bundle);
            MTCoreGlobal.setResetOnDeviceChangeEnabled(z8);
        }
    }

    public static void setEnableUdp(Context context, boolean z8) {
        if (MTGlobal.IS_FOR_ENGAGELAB) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MTCoreConstants.Config.ENABLE_UDP, z8);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.SET_CONFIG, bundle);
            MTGlobal.setUdpEnable(z8);
        }
    }

    @AllAPI
    public static void setLCCapacity(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "setLCCapacity context can't be null, please check it");
            return;
        }
        if (i9 < 5) {
            MTCommonLog.e(TAG, "setLCCapacity capacity must be at least 5M, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCommonLog.d(TAG, "setLCCapacity: " + i9);
            Bundle bundle = new Bundle();
            bundle.putInt(MTCoreConstants.Config.LOG_COLLECTION_CAPACITY, i9);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.SET_CONFIG, bundle);
            MTCommonLog.setMaxTotalSize(i9);
        }
    }

    @AllAPI
    public static void setLCOn(Context context, boolean z8) {
        if (context == null) {
            MTCommonLog.e(TAG, "setLCOn context can't be null, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCommonLog.d(TAG, "setLCOn: " + z8);
            Bundle bundle = new Bundle();
            bundle.putBoolean(MTCoreConstants.Config.LOG_COLLECTION_ON, z8);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.SET_CONFIG, bundle);
            MTCommonLog.setLogCacheEnabled(z8);
        }
    }

    @AllAPI
    public static void setReportCacheFileMaximum(int i9) {
        if (i9 >= 0) {
            v.f12384d = i9;
        }
    }

    @EngagelabAPI
    @Deprecated
    public static void setTcpSSl(boolean z8) {
        if (MTGlobal.IS_FOR_ENGAGELAB) {
            MTGlobal.setTcpSSL(z8);
        }
    }

    @AllAPI
    @Deprecated
    public static void setWakeAndBeWakeEnable(Context context, boolean z8) {
        configWakeAndBeWake(context, z8);
    }

    public static void testConfigGoogle(Context context, boolean z8) {
        if (context == null) {
            MTCommonLog.e(TAG, "testConfigGoogle context can't be null, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCommonLog.e(TAG, "testConfigGoogle, Can only be used in the debugging version, please do not call the release version");
            if (z8) {
                MTGlobal.setCountryCode("US");
            } else {
                MTGlobal.setCountryCode("CN");
            }
        }
    }

    public static void setTcpSSl(Context context, boolean z8) {
        if (MTGlobal.IS_FOR_ENGAGELAB) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MTCoreConstants.Config.IS_SSL, z8);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.SET_CONFIG, bundle);
            MTGlobal.setTcpSSL(z8);
        }
    }
}
