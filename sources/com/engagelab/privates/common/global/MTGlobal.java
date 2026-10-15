package com.engagelab.privates.common.global;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.cache.MTCommonConfig;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.component.MTCommonService;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.common.utils.SystemUtil;
import com.engagelab.privates.core.api.WakeMessage;
import com.engagelab.privates.push.api.AliasMessage;
import com.engagelab.privates.push.api.CustomMessage;
import com.engagelab.privates.push.api.InAppMessage;
import com.engagelab.privates.push.api.MobileNumberMessage;
import com.engagelab.privates.push.api.NotificationMessage;
import com.engagelab.privates.push.api.PlatformTokenMessage;
import com.engagelab.privates.push.api.TagMessage;
import com.huawei.hms.framework.common.BundleUtil;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class MTGlobal {
    private static final String APP_CHANNEL = "ENGAGELAB_PRIVATES_CHANNEL";
    private static final String APP_KEY = "ENGAGELAB_PRIVATES_APPKEY";
    private static final String APP_PROCESS = "ENGAGELAB_PRIVATES_PROCESS";
    public static final String APP_SITE_NAME_DEFAULT = "Singapore";
    private static final String APP_TRANSFER = "ENGAGELAB_PRIVATES_TRANSFER";
    private static final String INTENT_COMMON_RECEIVER = "com.engagelab.privates.intent.USER_RECEIVER";
    private static final String INTENT_COMMON_SERVICE = "com.engagelab.privates.intent.USER_SERVICE";
    public static boolean IS_FOR_BINANCE = false;
    public static boolean IS_FOR_CHINALIFE = false;
    public static boolean IS_FOR_ENGAGELAB = true;
    public static boolean IS_FOR_PINGANBANK = false;
    public static boolean IS_FOR_PINGANTECH = false;
    public static boolean IS_FOR_SGM = false;
    public static boolean IS_FOR_SPDBAND = false;
    private static AtomicBoolean IS_MAIN_PROCESS = null;
    private static final String TAG = "MTGlobal";
    private static String appChannel = null;
    private static String appKey = null;
    private static String appProcess = null;
    private static String appSiteName = null;
    private static String appTransfer = null;
    private static int appVersionCode = 0;
    private static String appVersionName = null;
    private static MTCommonReceiver commonReceiver = null;
    private static MTCommonService commonService = null;
    public static Context context = null;
    private static String countryCode = null;
    private static String currentActivityName = "";
    private static int encryptType = 2;
    private static boolean isDebugMode = false;
    public static boolean isNeedRemoteProcess = true;
    private static AtomicBoolean isRemoteProcess = null;
    private static boolean isTcpSSL = false;
    private static boolean isUdpEnable = true;
    private static boolean lifecycleState = false;
    private static String networkName = "unknown";
    private static String networkRadio = "";
    private static boolean networkState = false;
    private static int networkType;

    public static class a extends MTCommonReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<MTCommonReceiver> f12217a;

        public a(List<MTCommonReceiver> list) {
            this.f12217a = new ArrayList();
            if (list == null) {
                return;
            }
            this.f12217a = list;
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onAliasMessage(Context context, AliasMessage aliasMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onAliasMessage(context, aliasMessage);
                } catch (Throwable th) {
                    H2.a.i("onAliasMessage:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onConnectStatus(Context context, boolean z8) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onConnectStatus(context, z8);
                } catch (Throwable th) {
                    H2.a.i("onConnectStatus:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onCustomMessage(Context context, CustomMessage customMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onCustomMessage(context, customMessage);
                } catch (Throwable th) {
                    H2.a.i("onCustomMessage:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onInAppMessageClick(Context context, InAppMessage inAppMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onInAppMessageClick(context, inAppMessage);
                } catch (Throwable th) {
                    H2.a.i("onInAppMessageClick:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onInAppMessageShow(Context context, InAppMessage inAppMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onInAppMessageShow(context, inAppMessage);
                } catch (Throwable th) {
                    H2.a.i("onInAppMessageShow:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onMobileNumber(Context context, MobileNumberMessage mobileNumberMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onMobileNumber(context, mobileNumberMessage);
                } catch (Throwable th) {
                    H2.a.i("onMobileNumber:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onNotificationArrived(Context context, NotificationMessage notificationMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onNotificationArrived(context, notificationMessage);
                } catch (Throwable th) {
                    H2.a.i("onNotificationArrived:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onNotificationClicked(Context context, NotificationMessage notificationMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onNotificationClicked(context, notificationMessage);
                } catch (Throwable th) {
                    H2.a.i("onNotificationClicked:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onNotificationDeleted(Context context, NotificationMessage notificationMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onNotificationDeleted(context, notificationMessage);
                } catch (Throwable th) {
                    H2.a.i("onNotificationDeleted:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onNotificationStatus(Context context, boolean z8) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onNotificationStatus(context, z8);
                } catch (Throwable th) {
                    H2.a.i("onNotificationStatus:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onNotificationUnShow(Context context, NotificationMessage notificationMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onNotificationUnShow(context, notificationMessage);
                } catch (Throwable th) {
                    H2.a.i("onNotificationUnShow:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onPlatformToken(Context context, PlatformTokenMessage platformTokenMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onPlatformToken(context, platformTokenMessage);
                } catch (Throwable th) {
                    H2.a.i("onPlatformToken:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onTagMessage(Context context, TagMessage tagMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onTagMessage(context, tagMessage);
                } catch (Throwable th) {
                    H2.a.i("onTagMessage:", MTGlobal.TAG, th);
                }
            }
        }

        @Override // com.engagelab.privates.common.component.MTCommonReceiver
        public void onWake(Context context, WakeMessage wakeMessage) {
            for (int i9 = 0; i9 < this.f12217a.size(); i9++) {
                try {
                    this.f12217a.get(i9).onWake(context, wakeMessage);
                } catch (Throwable th) {
                    H2.a.i("onWake:", MTGlobal.TAG, th);
                }
            }
        }
    }

    public static String getAppChannel(Context context2) {
        if (TextUtils.isEmpty(appChannel)) {
            appChannel = getMetaData(context2, APP_CHANNEL);
        }
        return appChannel;
    }

    public static String getAppKey(Context context2) {
        if (TextUtils.isEmpty(appKey)) {
            synchronized (MTGlobal.class) {
                try {
                    if (TextUtils.isEmpty(appKey)) {
                        appKey = getMetaData(context2, APP_KEY);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return appKey;
    }

    public static String getAppProcess(Context context2) {
        if (TextUtils.isEmpty(appProcess)) {
            appProcess = getMetaData(context2, APP_PROCESS);
        }
        return appProcess;
    }

    public static int getAppVersionCode(Context context2) {
        int i9 = appVersionCode;
        if (i9 != 0) {
            return i9;
        }
        try {
            int i10 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
            appVersionCode = i10;
            return i10;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getAppVersionCode failed: "), TAG);
            return 0;
        }
    }

    public static String getAppVersionName(Context context2) {
        if (!TextUtils.isEmpty(appVersionName)) {
            return appVersionName;
        }
        try {
            String str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
            appVersionName = str;
            return str;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getAppVersionName failed: "), TAG);
            return "";
        }
    }

    public static MTCommonReceiver getCommonReceiver(Context context2) {
        MTCommonReceiver commonReceiverImpl = getCommonReceiverImpl(context2);
        if (commonReceiverImpl == null) {
            MTCommonLog.w(TAG, "getCommonReceiver is null");
        }
        return commonReceiverImpl;
    }

    private static MTCommonReceiver getCommonReceiverImpl(Context context2) {
        MTCommonReceiver mTCommonReceiver = commonReceiver;
        if (mTCommonReceiver != null) {
            return mTCommonReceiver;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(INTENT_COMMON_RECEIVER);
            intent.setPackage(context2.getPackageName());
            List<ResolveInfo> listQueryBroadcastReceivers = context2.getPackageManager().queryBroadcastReceivers(intent, 0);
            ArrayList arrayList = new ArrayList();
            Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null) {
                    String str = activityInfo.name;
                    if (!TextUtils.isEmpty(str)) {
                        Class<?> cls = Class.forName(str);
                        if (MTCommonReceiver.class.isAssignableFrom(cls)) {
                            arrayList.add((MTCommonReceiver) cls.newInstance());
                        }
                    }
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            a aVar = new a(arrayList);
            commonReceiver = aVar;
            return aVar;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getCommonReceiver failed "), TAG);
            return null;
        }
    }

    public static MTCommonService getCommonService(Context context2) {
        MTCommonService commonServiceImpl = getCommonServiceImpl(context2);
        if (commonServiceImpl == null) {
            MTCommonLog.w(TAG, "getCommonService is null");
        }
        return commonServiceImpl;
    }

    private static MTCommonService getCommonServiceImpl(Context context2) {
        MTCommonService mTCommonService = commonService;
        if (mTCommonService != null) {
            return mTCommonService;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(INTENT_COMMON_SERVICE);
            intent.setPackage(context2.getPackageName());
            Iterator<ResolveInfo> it = context2.getPackageManager().queryIntentServices(intent, 0).iterator();
            while (it.hasNext()) {
                ServiceInfo serviceInfo = it.next().serviceInfo;
                if (serviceInfo != null) {
                    String str = serviceInfo.name;
                    if (!TextUtils.isEmpty(str)) {
                        Class<?> cls = Class.forName(str);
                        if (MTCommonService.class.isAssignableFrom(cls)) {
                            MTCommonService mTCommonService2 = (MTCommonService) cls.newInstance();
                            commonService = mTCommonService2;
                            return mTCommonService2;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getCommonService failed "), TAG);
            return null;
        }
    }

    public static String getCountryCode(Context context2) {
        if (TextUtils.isEmpty(countryCode)) {
            countryCode = SystemUtil.getCountry(context2);
        }
        return countryCode;
    }

    public static String getCurrentActivityName() {
        return currentActivityName;
    }

    private static String getCurrentProcessName(Context context2) {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i9;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getCurrentProcessName failed "), TAG);
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                    if (objInvoke instanceof String) {
                        return (String) objInvoke;
                    }
                    while (true) {
                        int i10 = fileInputStream.read();
                        if (i10 <= 0 || i9 >= 256) {
                            break;
                        }
                        bArr[i9] = (byte) i10;
                        i9++;
                    }
                } catch (Throwable th2) {
                    H2.a.k(th2, new StringBuilder("getCurrentProcessName failed "), TAG);
                }
                bArr = new byte[256];
                i9 = 0;
                if (i9 > 0) {
                    String str = new String(bArr, 0, i9, "UTF-8");
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        H2.a.k(th3, new StringBuilder("getCurrentProcessName failed "), TAG);
                    }
                    return str;
                }
                try {
                    fileInputStream.close();
                    return "";
                } catch (Throwable th4) {
                    H2.a.k(th4, new StringBuilder("getCurrentProcessName failed "), TAG);
                    return "";
                }
            } catch (Throwable th5) {
                th = th5;
                fileInputStream2 = fileInputStream;
                try {
                    MTCommonLog.w(TAG, "getCurrentProcessName failed " + th.getMessage());
                    if (fileInputStream2 == null) {
                        return "";
                    }
                    try {
                        return "";
                    } catch (Throwable th6) {
                        return "";
                    }
                } finally {
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable th7) {
                            H2.a.k(th7, new StringBuilder("getCurrentProcessName failed "), TAG);
                        }
                    }
                }
            }
            fileInputStream = new FileInputStream("/proc/self/cmdline");
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static boolean getDebugMode() {
        return isDebugMode;
    }

    public static String getDeviceId(Context context2) {
        String str;
        String deviceId = MTCommonConfig.getDeviceId(context2);
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        try {
            str = StringUtil.get32MD5String((Build.PRODUCT.toLowerCase() + BundleUtil.UNDERLINE_TAG + Build.TIME) + UUID.randomUUID().toString() + System.currentTimeMillis());
        } catch (Throwable unused) {
            str = StringUtil.get32MD5String(" " + UUID.randomUUID().toString() + System.currentTimeMillis() + " ");
        }
        MTCommonConfig.setDeviceId(context2, str);
        return str;
    }

    public static int getEncryptType() {
        return encryptType;
    }

    public static boolean getLifecycleState() {
        return lifecycleState;
    }

    private static String getMainProcessName(Context context2) {
        String str;
        try {
            str = context2.getPackageManager().getApplicationInfo(context2.getPackageName(), 128).processName;
        } catch (PackageManager.NameNotFoundException e9) {
            MTCommonLog.w(TAG, "getMainProcessName failed " + e9.getMessage());
            str = "";
        }
        return TextUtils.isEmpty(str) ? context2.getPackageName() : str;
    }

    public static String getMetaData(Context context2, String str) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context2.getPackageManager().getApplicationInfo(context2.getPackageName(), 128);
            return (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get(str)) == null) ? "" : String.valueOf(obj);
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getMetaData failed "), TAG);
        }
        return "";
    }

    public static String getNetworkName() {
        return networkName;
    }

    public static String getNetworkRadio() {
        return networkRadio;
    }

    public static boolean getNetworkState() {
        return networkState;
    }

    public static int getNetworkType() {
        return networkType;
    }

    private static String getRemoteProcessName(Context context2, Class<?> cls) {
        try {
            return context2.getPackageManager().getServiceInfo(new ComponentName(context2.getPackageName(), cls.getCanonicalName()), 128).processName;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getRemoteProcessName failed "), TAG);
            return "";
        }
    }

    public static boolean getTcpSSL() {
        return isTcpSSL;
    }

    public static String getTransfer(Context context2) {
        if (TextUtils.isEmpty(appTransfer)) {
            appTransfer = getMetaData(context2, APP_TRANSFER);
        }
        return appTransfer;
    }

    public static boolean getUdpEnable() {
        return isUdpEnable;
    }

    public static boolean hasPermission(Context context2, String str) {
        try {
            return context2.checkSelfPermission(str) == 0;
        } catch (Throwable unused) {
        }
    }

    public static boolean isMainProcess(Context context2) {
        AtomicBoolean atomicBoolean = IS_MAIN_PROCESS;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        IS_MAIN_PROCESS = new AtomicBoolean(false);
        try {
            if (TextUtils.equals(getCurrentProcessName(context2), getMainProcessName(context2))) {
                IS_MAIN_PROCESS.set(true);
            }
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("isMainProcess failed "), TAG);
        }
        return IS_MAIN_PROCESS.get();
    }

    public static boolean isRemoteProcess(Context context2) {
        AtomicBoolean atomicBoolean = isRemoteProcess;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        isRemoteProcess = new AtomicBoolean(false);
        try {
            String currentProcessName = getCurrentProcessName(context2);
            if (TextUtils.isEmpty(currentProcessName)) {
                isRemoteProcess.set(true);
            }
            if (TextUtils.equals(currentProcessName, getRemoteProcessName(context2, getCommonService(context2).getClass()))) {
                isRemoteProcess.set(true);
            }
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("isRemoteProcess failed "), TAG);
        }
        return isRemoteProcess.get();
    }

    public static void setAppChannel(String str) {
        appChannel = str;
    }

    public static void setAppKey(String str) {
        appKey = str;
    }

    public static void setAppSiteName(String str) {
        appSiteName = str;
    }

    public static void setCountryCode(String str) {
        MTCommonLog.d(TAG, "setCountryCode, country:" + str);
        countryCode = str;
    }

    public static void setCurrentActivityName(String str) {
        currentActivityName = str;
    }

    public static void setDebugMode(boolean z8) {
        isDebugMode = z8;
    }

    public static void setDeviceId(Context context2, String str) {
        MTCommonConfig.setDeviceId(context2, str);
    }

    public static void setEncryptType(int i9) {
        encryptType = i9;
    }

    public static void setLifecycleState(boolean z8) {
        lifecycleState = z8;
    }

    public static void setNetworkName(String str) {
        networkName = str;
    }

    public static void setNetworkRadio(String str) {
        networkRadio = str;
    }

    public static void setNetworkState(boolean z8) {
        networkState = z8;
    }

    public static void setNetworkType(int i9) {
        networkType = i9;
    }

    public static void setTcpSSL(boolean z8) {
        if (IS_FOR_ENGAGELAB) {
            isTcpSSL = z8;
        }
    }

    public static void setUdpEnable(boolean z8) {
        if (IS_FOR_ENGAGELAB) {
            isUdpEnable = z8;
        }
    }
}
