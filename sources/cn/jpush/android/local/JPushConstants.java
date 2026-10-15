package cn.jpush.android.local;

import W5.f;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ad.b;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JPushConstants {
    public static int BUILD_ID = 155;
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final int FORE_GROUND = 0;
    public static final int FORE_GROUND_NO = 1;
    public static final int FORE_GROUND_UNKNOWN = -1;
    public static String GIT_COMMIT_HASH = "af5282e7";
    public static final String HTTPS_PRE = "https://";
    public static final String HTTP_PRE = "http://";
    public static final boolean IG = false;
    public static boolean IS_HB_PERIOD_ENABLE = true;
    public static String SDK_NAME = "";
    public static final String SDK_TYPE = "JPUSH";
    public static int SDK_VERSION_CODE = 610;
    public static String SDK_VERSION_NAME = "6.1.0";
    public static boolean SUPPORT_DY = true;
    private static final String TAG = "JPushConstants";
    public static boolean THIRD_ENABLE = true;
    private static final String USER_MESSAGE_RECEIVER_ACTION = "cn.jpush.android.intent.RECEIVER_MESSAGE";
    private static Bundle configBundle = null;
    public static int isForeGround = -1;
    private static boolean isInitLife = false;
    private static Boolean isSameProcessWithJCommonReceiver = null;
    private static boolean isTestAndroidQ = false;
    private static JPushMessageReceiver jPushMessageReceiver;
    public static Context mApplicationContext;
    private static String messageReceiverClass;
    private static String messageReceiverProcess;
    private static boolean tcpConnected;

    public static class TEST_CONFIG {
        public static String TEST_FILE_URL = "";
        public static String TEST_FILE_VERSION = "";
    }

    public static synchronized void addActivityLifeCallback() {
        if (isInitLife) {
            Logger.d(TAG, "ActivityLifeCallback already initialized");
            return;
        }
        try {
            isInitLife = true;
            JCoreManager.addActivityLifeCallback(ActivityLifeCallBack.getInstance());
            Logger.d(TAG, "addActivityLifeCallback init to JCore ");
        } catch (Throwable unused) {
            isInitLife = false;
        }
    }

    public static boolean canGetLbsInBackGround(Context context) {
        String str;
        if (isAndroidQ(context, true, "canGetLbsInBackGround")) {
            if (isForeGround != 1 || b.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                str = (isForeGround == -1 && !b.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) ? "app is unkonwn foreground stat and no android.permission.ACCESS_BACKGROUND_LOCATION" : "app is not in foreground and no android.permission.ACCESS_BACKGROUND_LOCATION";
            }
            Logger.ww(TAG, str);
            return false;
        }
        return true;
    }

    public static void changeForegroudStat(Context context, boolean z8) {
        Logger.d(TAG, "changeForegroudStat:" + z8);
        isForeGround = !z8 ? 1 : 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", z8);
        JCoreHelper.runActionWithService(context, SDK_TYPE, "change_foreground", bundle);
    }

    private static void defaultRegister(Context context, ActivityLifeCallBack activityLifeCallBack) {
        Activity activityK;
        if (context instanceof Application) {
            String strD = b.d(context);
            String packageName = context.getPackageName();
            if (strD == null || packageName == null || !context.getPackageName().equals(strD)) {
                Logger.d(TAG, "need not initPageLifecycle in other process :" + strD);
                d dVar = new d();
                dVar.f11334s = 1;
                cn.jpush.android.x.b.a(context, "sync_reg_lifecycle", dVar, (Intent) null);
                return;
            }
            ((Application) context).registerActivityLifecycleCallbacks(activityLifeCallBack);
            if (ActivityLifeCallBack.activityTaskCount == 0 && (activityK = b.k(context)) != null) {
                activityLifeCallBack.onActivityCreated(activityK, null);
                activityLifeCallBack.onActivityStarted(activityK);
                activityLifeCallBack.onActivityResumed(activityK);
            }
            Logger.d(TAG, "initPageLifecycle in main process, packageName:" + packageName + ", currentProcessName:" + strD);
        }
    }

    public static Context getAppContext(Context context) {
        if (mApplicationContext == null && context != null) {
            mApplicationContext = context.getApplicationContext();
        }
        return mApplicationContext;
    }

    public static Bundle getBundle() {
        return configBundle;
    }

    public static String getMessageReceiverClass(Context context) {
        String str = messageReceiverClass;
        if (str != null) {
            return str;
        }
        try {
            ComponentInfo componentInfoA = b.a(context, context.getPackageName(), (Class<?>) JPushMessageReceiver.class);
            if (componentInfoA != null) {
                messageReceiverClass = componentInfoA.name;
                messageReceiverProcess = componentInfoA.processName;
                Logger.ii(TAG, "found messageServiceClass :" + messageReceiverClass + " at " + messageReceiverProcess + " by getComponentInfo");
                String str2 = messageReceiverProcess;
                if (str2 != null && str2.equals(b.d(context))) {
                    jPushMessageReceiver = (JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance();
                }
            }
        } catch (Throwable unused) {
        }
        try {
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Intent intent = new Intent();
                intent.setAction(USER_MESSAGE_RECEIVER_ACTION);
                intent.setPackage(context.getPackageName());
                PackageManager packageManager = context.getPackageManager();
                for (ResolveInfo resolveInfo : (List) packageManager.getClass().getMethod(new String(Base64.decode("cXVlcnlCcm9hZGNhc3RSZWNlaXZlcnM=", 2)), Intent.class, Integer.TYPE).invoke(packageManager, intent, 0)) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null) {
                        String str3 = activityInfo.name;
                        if (!TextUtils.isEmpty(str3)) {
                            Class<?> cls = Class.forName(str3);
                            if (JPushMessageReceiver.class.isAssignableFrom(cls)) {
                                messageReceiverClass = str3;
                                messageReceiverProcess = resolveInfo.activityInfo.processName;
                                Logger.ii(TAG, "found messageReceiverClass :" + messageReceiverClass + " at " + messageReceiverProcess + " by getCommonReceiverNames");
                                try {
                                    String str4 = messageReceiverProcess;
                                    if (str4 == null || !str4.equals(b.d(context))) {
                                        break;
                                        break;
                                    }
                                    jPushMessageReceiver = (JPushMessageReceiver) cls.newInstance();
                                    break;
                                } catch (Throwable unused2) {
                                    break;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Logger.d(TAG, "getUserServiceClass failed:" + th.getMessage());
        }
        if (TextUtils.isEmpty(messageReceiverClass)) {
            messageReceiverClass = "";
        }
        if (TextUtils.isEmpty(messageReceiverProcess)) {
            messageReceiverProcess = "";
        }
        return messageReceiverClass;
    }

    public static JPushMessageReceiver getPushMessageReceiver(Context context) {
        getMessageReceiverClass(getAppContext(context));
        return jPushMessageReceiver;
    }

    public static void init(Context context) {
        getAppContext(context);
        initPageLifecycle(context);
    }

    private static synchronized void initPageLifecycle(Context context) {
        if (context == null) {
            Logger.w(TAG, "[initPageLifecycle] context is null");
            return;
        }
        Logger.d(TAG, "initPageLifecycle init, isInitLife: " + isInitLife);
        if (isInitLife) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            isInitLife = true;
            defaultRegister(applicationContext, ActivityLifeCallBack.getInstance());
            Logger.d(TAG, "initPageLifecycle init to JPush ");
        } catch (Throwable th) {
            Logger.ww(TAG, "registerActivityLifecycleCallbacks failed:" + th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:
    
        if (r3.getApplicationInfo().targetSdkVersion <= 28) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isAndroidQ(android.content.Context r3, boolean r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 1
            r2 = 28
            if (r4 != 0) goto L15
            boolean r3 = cn.jpush.android.local.JPushConstants.isTestAndroidQ
            if (r3 == 0) goto L10
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r2) goto L2b
        Le:
            r0 = r1
            goto L2b
        L10:
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 <= r2) goto L2b
            goto Le
        L15:
            boolean r4 = cn.jpush.android.local.JPushConstants.isTestAndroidQ
            if (r4 == 0) goto L1e
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r2) goto L2b
            goto L22
        L1e:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 <= r2) goto L2b
        L22:
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            if (r3 <= r2) goto L2b
            goto Le
        L2b:
            if (r0 == 0) goto L34
            java.lang.String r3 = "is Android Q, msg: "
            java.lang.String r4 = "JPushConstants"
            W5.e.r(r3, r5, r4)
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.local.JPushConstants.isAndroidQ(android.content.Context, boolean, java.lang.String):boolean");
    }

    public static boolean isSameProcessWithJCommonService(Context context) {
        Boolean bool;
        try {
            Boolean bool2 = isSameProcessWithJCommonReceiver;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            if (messageReceiverProcess == null) {
                getMessageReceiverClass(context);
            }
            ComponentInfo componentInfoA = b.a(context, context.getPackageName(), (Class<?>) JCommonService.class);
            if (componentInfoA == null) {
                return false;
            }
            if (componentInfoA.processName.equals(messageReceiverProcess)) {
                Logger.dd(TAG, "same process with JCommonService");
                bool = Boolean.TRUE;
            } else {
                Logger.dd(TAG, "is not same process with JCommonService");
                bool = Boolean.FALSE;
            }
            isSameProcessWithJCommonReceiver = bool;
            return isSameProcessWithJCommonReceiver.booleanValue();
        } catch (Throwable th) {
            f.r(th, new StringBuilder("call isSameProcessWithJCommonService failed:"), TAG);
            return false;
        }
    }

    public static boolean isTcpConnected() {
        return tcpConnected;
    }

    public static void setBundle(Bundle bundle) {
        configBundle = bundle;
    }

    public static void setTcpConnected(boolean z8) {
        tcpConnected = z8;
    }

    public static void testAndroidQ() {
    }
}
