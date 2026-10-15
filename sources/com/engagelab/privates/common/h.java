package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile h f12218b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12219a = null;

    public static h a() {
        if (f12218b == null) {
            synchronized (h.class) {
                try {
                    if (f12218b == null) {
                        f12218b = new h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12218b;
    }

    public void a(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey(MTCoreConstants.Config.APP_KEY)) {
            String string = bundle.getString(MTCoreConstants.Config.APP_KEY);
            MTCommonLog.d("MTConfigBusiness", "app_key:" + string);
            if (!TextUtils.isEmpty(string)) {
                MTCommonLog.d("MTConfigBusiness", "mAppKey:" + this.f12219a);
                MTGlobal.setAppKey(string);
                if (!string.equals(this.f12219a)) {
                    this.f12219a = string;
                    MTCommonLog.d("MTConfigBusiness", "stop and start connect");
                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.STOP_CONNECT, null);
                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.START_CONNECT, null);
                }
            }
        }
        if (bundle.containsKey(MTCoreConstants.Config.APP_CHANNEL)) {
            String string2 = bundle.getString(MTCoreConstants.Config.APP_CHANNEL);
            MTCommonLog.d("MTConfigBusiness", "app_channel:" + string2);
            if (!TextUtils.isEmpty(string2)) {
                MTGlobal.setAppChannel(string2);
            }
        }
        if (bundle.containsKey(MTCoreConstants.Config.APP_SITE_NAME)) {
            String string3 = bundle.getString(MTCoreConstants.Config.APP_SITE_NAME);
            MTCommonLog.d("MTConfigBusiness", "app_site_name:" + string3);
            if (!TextUtils.isEmpty(string3)) {
                MTGlobal.setAppSiteName(string3);
            }
        }
        if (bundle.containsKey(MTCoreConstants.Config.IS_SSL)) {
            boolean z8 = bundle.getBoolean(MTCoreConstants.Config.IS_SSL);
            MTCommonLog.d("MTConfigBusiness", "is_ssl:" + z8);
            MTGlobal.setTcpSSL(z8);
        }
        if (bundle.containsKey(MTCoreConstants.Config.ENABLE_UDP)) {
            boolean z9 = bundle.getBoolean(MTCoreConstants.Config.ENABLE_UDP);
            MTCommonLog.d("MTConfigBusiness", "enable_udp:" + z9);
            MTGlobal.setUdpEnable(z9);
        }
        if (bundle.containsKey(MTCoreConstants.Config.DEBUG_MODE)) {
            boolean z10 = bundle.getBoolean(MTCoreConstants.Config.DEBUG_MODE);
            MTGlobal.setDebugMode(z10);
            MTCommonLog.d("MTConfigBusiness", "debug_mode:" + z10);
        }
        if (bundle.containsKey(MTCoreConstants.Config.DEVICE_MIGRATION)) {
            boolean z11 = bundle.getBoolean(MTCoreConstants.Config.DEVICE_MIGRATION);
            MTCoreGlobal.setResetOnDeviceChangeEnabled(z11);
            MTCommonLog.d("MTConfigBusiness", "device_migration:" + z11);
        }
        if (bundle.containsKey(MTCoreConstants.Config.LOG_COLLECTION_ON)) {
            boolean z12 = bundle.getBoolean(MTCoreConstants.Config.LOG_COLLECTION_ON);
            MTCommonLog.setLogCacheEnabled(z12);
            MTCommonLog.d("MTConfigBusiness", "log_collection_on:" + z12);
        }
        if (bundle.containsKey(MTCoreConstants.Config.LOG_COLLECTION_CAPACITY)) {
            int i9 = bundle.getInt(MTCoreConstants.Config.LOG_COLLECTION_CAPACITY);
            MTCommonLog.setMaxTotalSize(i9);
            MTCommonLog.d("MTConfigBusiness", "log_collection_capacity:" + i9);
        }
        if (bundle.containsKey(MTCoreConstants.Config.SERVICE_NODE)) {
            String string4 = bundle.getString(MTCoreConstants.Config.SERVICE_NODE);
            MTCoreGlobal.setServiceNode(MTCoreConstants.ServiceNode.valueOf(string4));
            MTCommonLog.d("MTConfigBusiness", "service_node:" + string4);
        }
    }
}
