package cn.jpush.android.api;

import W5.f;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ab.b;
import cn.jpush.android.cache.a;
import cn.jpush.android.data.JPushCollectControl;
import cn.jpush.android.data.JPushConfig;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.c;
import cn.jpush.android.helper.e;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.v.d;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JPushInterface {
    public static final String ACTION_CONNECTION_CHANGE = "cn.jpush.android.intent.CONNECTION";
    public static final String ACTION_IN_APP_MSG_CLICK = "cn.jpush.android.intent.IN_APP_MSG_CLICK";
    public static final String ACTION_IN_APP_MSG_SHOW = "cn.jpush.android.intent.IN_APP_MSG_SHOW";
    public static final String ACTION_MESSAGE_RECEIVED = "cn.jpush.android.intent.MESSAGE_RECEIVED";
    public static final String ACTION_NOTIFICATION_CLICK_ACTION = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION";
    public static final String ACTION_NOTIFICATION_CLICK_ACTION_PROXY = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY";
    public static final String ACTION_NOTIFICATION_OPENED = "cn.jpush.android.intent.NOTIFICATION_OPENED";
    public static final String ACTION_NOTIFICATION_RECEIVED = "cn.jpush.android.intent.NOTIFICATION_RECEIVED";
    public static final String ACTION_NOTIFICATION_RECEIVED_PROXY = "cn.jpush.android.intent.NOTIFICATION_RECEIVED_PROXY";
    public static final String ACTION_REGISTRATION_ID = "cn.jpush.android.intent.REGISTRATION";
    public static final String ACTION_RICHPUSH_CALLBACK = "cn.jpush.android.intent.ACTION_RICHPUSH_CALLBACK";
    public static final String ACTION_VOIP_MESSAGE_RECEIVED = "cn.jpush.android.intent.VOIP_MESSAGE_RECEIVED";
    public static int DEFAULT_NOTIFICATION_NUM = 5;
    public static final String EXTRA_ACTIVITY_PARAM = "cn.jpush.android.ACTIVITY_PARAM";
    public static final String EXTRA_ALERT = "cn.jpush.android.ALERT";
    public static final String EXTRA_ALERT_TYPE = "cn.jpush.android.ALERT_TYPE";
    public static final String EXTRA_APP_KEY = "cn.jpush.android.APPKEY";
    public static final String EXTRA_BIG_PIC_PATH = "cn.jpush.android.BIG_PIC_PATH";
    public static final String EXTRA_BIG_TEXT = "cn.jpush.android.BIG_TEXT";
    public static final String EXTRA_CONNECTION_CHANGE = "cn.jpush.android.CONNECTION_CHANGE";
    public static final String EXTRA_CONTENT_TYPE = "cn.jpush.android.CONTENT_TYPE";
    public static final String EXTRA_EXTRA = "cn.jpush.android.EXTRA";
    public static final String EXTRA_INBOX = "cn.jpush.android.INBOX";
    public static final String EXTRA_MESSAGE = "cn.jpush.android.MESSAGE";
    public static final String EXTRA_MSG_ID = "cn.jpush.android.MSG_ID";
    public static final String EXTRA_NOTIFICATION_ACTION_EXTRA = "cn.jpush.android.NOTIFIACATION_ACTION_EXTRA";
    public static final String EXTRA_NOTIFICATION_DEVELOPER_ARG0 = "cn.jpush.android.NOTIFICATION_DEVELOPER_ARG0";
    public static final String EXTRA_NOTIFICATION_ID = "cn.jpush.android.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_LARGET_ICON = "cn.jpush.android.NOTIFICATION_LARGE_ICON";
    public static final String EXTRA_NOTIFICATION_SMALL_ICON = "cn.jpush.android.NOTIFICATION_SMALL_ICON";
    public static final String EXTRA_NOTIFICATION_TITLE = "cn.jpush.android.NOTIFICATION_CONTENT_TITLE";
    public static final String EXTRA_NOTIFICATION_URL = "cn.jpush.android.NOTIFICATION_URL";
    public static final String EXTRA_NOTI_CATEGORY = "cn.jpush.android.NOTI_CATEGORY";
    public static final String EXTRA_NOTI_IMPORTANCE = "cn.jpush.android.NOTI_IMPORTANCE";
    public static final String EXTRA_NOTI_PRIORITY = "cn.jpush.android.NOTI_PRIORITY";
    public static final String EXTRA_NOTI_TYPE = "cn.jpush.android.NOTIFICATION_TYPE";
    public static final String EXTRA_PUSH_ID = "cn.jpush.android.PUSH_ID";
    public static final String EXTRA_REGISTRATION_ID = "cn.jpush.android.REGISTRATION_ID";
    public static final String EXTRA_RICHPUSH_FILE_PATH = "cn.jpush.android.FILE_PATH";
    public static final String EXTRA_RICHPUSH_FILE_TYPE = "cn.jpush.android.FILE_TYPE";
    public static final String EXTRA_RICHPUSH_HTML_PATH = "cn.jpush.android.HTML_PATH";
    public static final String EXTRA_RICHPUSH_HTML_RES = "cn.jpush.android.HTML_RES";
    public static final String EXTRA_STATUS = "cn.jpush.android.STATUS";
    public static final String EXTRA_TITLE = "cn.jpush.android.TITLE";
    public static final String EXTRA_TYPE_PLATFORM = "cn.jpush.android.TYPE_PLATFORM";
    public static final String PUSH_MESSAGE_PERMISSION_POSTFIX = ".permission.JPUSH_MESSAGE";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Integer f11194a = 0;

    public static class ErrorCode {
        public static int ERROR_CODE_ALIAS_LIMIT = 6027;
        public static int ERROR_CODE_ALIAS_OPERATORING = 6022;
        public static int ERROR_CODE_APPKEY_NOT_AUTH_TO_SET_PROPERTY = 6036;
        public static int ERROR_CODE_BLACKLIST = 6015;
        public static int ERROR_CODE_GET_FAILED = 6019;
        public static int ERROR_CODE_INTERNEL_SERVER_ERROR = 6024;
        public static int ERROR_CODE_INVALIDREQ = 6017;
        public static int ERROR_CODE_INVALIDUSER = 6016;
        public static int ERROR_CODE_INVALID_MOBILENUMBER = 6023;
        public static int ERROR_CODE_MODE_NOT_MATCH = 6034;
        public static int ERROR_CODE_NOT_PULL_IN_BLOCK_LIST = 6035;
        public static int ERROR_CODE_NO_IN_APP_DATA = 6029;
        public static int ERROR_CODE_OVER_FREQUENCY = 6031;
        public static int ERROR_CODE_OVER_FREQUENCY_SRV = 6030;
        public static int ERROR_CODE_PROPERTIES_OPERATORING = 6038;
        public static int ERROR_CODE_PROPERTY_ERROR = 6037;
        public static int ERROR_CODE_SERVER_INTERNAL_ERROR = 6033;
        public static int ERROR_CODE_SERVER_UNAVAILABLE = 6020;
        public static int ERROR_CODE_STYLE_NOT_SUPPORT = 6032;
        public static int ERROR_CODE_TAG_OPERATORING = 6021;
        public static int ERROR_CODE_TOO_BUSY = 6014;
        public static int ERROR_CODE_TOO_LONG_MOBILENUMBER = 6025;
        public static int ERROR_CODE_TOO_MANY_TAGS = 6018;
        public static int HAS_IN_APP_DATA = 6028;
        public static int INCORRECT_TIME = 6013;
        public static int INVALID_ALIAS = 6003;
        public static int INVALID_JSON = 6010;
        public static int INVALID_TAGS = 6005;
        public static int INVOKE_TOO_SOON = 6011;
        public static int NULL_TAGANDALIAS = 6001;
        public static int PUSH_STOPED = 6012;
        public static int SUCCESS = 0;
        public static int TIMEOUT = 6002;
        public static int TOO_LONG_ALIAS = 6004;
        public static int TOO_LONG_TAGALIAS = 6008;
        public static int TOO_LONG_TAGS = 6006;
        public static int TOO_MANY_TAGS = 6007;
        public static int UNKNOWN_ERROR = 6009;
    }

    public static class InAppStyle {
        public static int STYLE_BANNER = 1;
        public static int STYLE_FLOAT = 4;
        public static int STYLE_MODAL = 2;
    }

    static {
        JCoreManager.addDispatchAction(JPushConstants.SDK_TYPE, c.class.getName());
        JPushConstants.addActivityLifeCallback();
    }

    public static void addLocalNotification(Context context, JPushLocalNotification jPushLocalNotification) {
        checkContext(context);
        d.a(context, jPushLocalNotification);
    }

    public static void addTags(Context context, int i9, Set<String> set) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i9, set, 1, 1);
    }

    public static void attachBaseContext(Context context) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod(AppAgent.ATTACH_BASE_CONTEXT, Context.class).invoke(null, context);
            Logger.d("JPushInterface", "use time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable unused) {
        }
    }

    private static void checkContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        JPushConstants.mApplicationContext = context.getApplicationContext();
    }

    private static boolean checkLengthOfTags(String str) {
        int length = !TextUtils.isEmpty(str) ? str.getBytes().length : 0;
        Logger.v("JPushInterface", "tags length:" + length);
        return length <= 7000;
    }

    public static void checkSupportVasMessage(Context context, int i9) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("type", i9);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "check_vas_integrate", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void checkTagBindState(Context context, int i9, String str) {
        HashSet hashSet;
        checkContext(context);
        if (TextUtils.isEmpty(str)) {
            hashSet = null;
        } else {
            hashSet = new HashSet();
            hashSet.add(str);
        }
        ActionHelper.getInstance().setTagsWithCallBack(context, i9, hashSet, 1, 6);
    }

    public static void cleanProperties(Context context, int i9) {
        checkContext(context);
        ActionHelper.getInstance().setPropertyWithCallBack(context, i9, new HashMap(), 3, 2);
    }

    public static void cleanTags(Context context, int i9) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i9, new HashSet(), 1, 4);
    }

    public static void clearAllNotifications(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "clear_all_notify", null);
        ActionHelper.getInstance().doSingleAction(context, "third_all_notify", null);
    }

    public static void clearLocalNotifications(Context context) {
        checkContext(context);
        d.a(context);
    }

    public static void clearNotificationById(Context context, int i9) {
        checkContext(context);
        if (i9 <= 0) {
            Logger.ee("JPushInterface", "Invalid notificationId, Give up action..");
            return;
        }
        ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(i9);
        Bundle bundle = new Bundle();
        bundle.putInt("id", i9);
        ActionHelper.getInstance().doSingleAction(context, "clear_by_id", bundle);
    }

    public static void deleteAlias(Context context, int i9) {
        checkContext(context);
        ActionHelper.getInstance().setAliasWithCallBack(context, i9, null, 2, 3);
    }

    public static void deleteGeofence(Context context, String str) {
        checkContext(context);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "delete_geo_fence", bundle);
    }

    public static void deleteProperties(Context context, int i9, Map<String, Object> map) {
        checkContext(context);
        ActionHelper.getInstance().setPropertyWithCallBack(context, i9, map, 3, 1);
    }

    public static void deleteTags(Context context, int i9, Set<String> set) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i9, set, 1, 3);
    }

    public static Set<String> filterValidTags(Set<String> set) {
        return b.a(set);
    }

    public static void getAlias(Context context, int i9) {
        checkContext(context);
        ActionHelper.getInstance().setAliasWithCallBack(context, i9, null, 2, 5);
    }

    public static void getAllTags(Context context, int i9) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i9, new HashSet(), 1, 5);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "get_connection", null);
        return JCoreManager.getConnectionState(context);
    }

    public static boolean getKeepLongConnInBackground(Context context) {
        checkContext(context);
        try {
            return a.g(context);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void getPushStatus(Context context) {
        Logger.kd("JPushInterface", "action:getPushStatus");
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "get_push_status", null);
    }

    public static String getRegistrationID(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "get_rid", null);
        return JCoreHelper.getRegistrationID(context);
    }

    public static String getStringTags(Set<String> set) {
        return b.b(set);
    }

    public static String getUdid(Context context) {
        checkContext(context);
        return JCoreHelper.getDeviceId(context);
    }

    public static void goToAppNotificationSettings(Context context) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "go_settings", null);
        if (cn.jpush.android.x.b.e(context)) {
            return;
        }
        cn.jpush.android.x.b.f(context);
    }

    public static void init(Context context) {
        Logger.ki("JPushInterface", "action:init - jpush, SdkVersion:" + JPushConstants.SDK_VERSION_NAME + ", build id:" + JPushConstants.BUILD_ID + ", build type:release, hash:" + JPushConstants.GIT_COMMIT_HASH);
        checkContext(context);
        if (cn.jpush.android.ad.b.h(context)) {
            Logger.kd("JPushInterface", "check config suceess!!! ");
            JPushConstants.init(context);
            JCoreHelper.initSdkType(context);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, TCPTimingCache.P_INIT, null);
        }
    }

    public static void initCrashHandler(Context context) {
        checkContext(context);
        JCoreManager.initCrashHandler(context);
    }

    public static int isNotificationEnabled(Context context) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "is_enable", null);
        return cn.jpush.android.x.b.d(context);
    }

    public static boolean isPushStopped(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "check_stop", null);
        return a.e(context, true);
    }

    public static void onFragmentPause(Context context, String str) {
        JCoreHelper.saEvent(context, "f_pause", str);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("JPushInterface", "fragmentName can not null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", str);
        bundle.putBoolean("state", false);
        ActionHelper.getInstance().doSingleAction(context, "sync_fragment_life", bundle);
    }

    public static void onFragmentResume(Context context, String str) {
        JCoreHelper.saEvent(context, "f_resume", str);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("JPushInterface", "fragmentName can not null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", str);
        bundle.putBoolean("state", true);
        ActionHelper.getInstance().doSingleAction(context, "sync_fragment_life", bundle);
    }

    public static void onKillProcess(Context context) {
        JCoreHelper.saEvent(context, "kill", null);
    }

    public static void onPause(Context context) {
        JCoreHelper.saEvent(context, "pause", null);
    }

    public static void onResume(Context context) {
        JCoreHelper.saEvent(context, "resume", null);
    }

    @Deprecated
    public static void pullInAppMessage(Context context, int i9) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sequence", i9);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void pullInAppMessageWithParams(Context context, InAppSlotParams inAppSlotParams) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            if (inAppSlotParams != null) {
                bundle.putString("inapp_param", inAppSlotParams.toJSONString());
            }
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void registerByKey(Context context, String str) {
        checkContext(context);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("JPushInterface", "devKey is not valid - " + str);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("dev_key", str);
            ActionHelper.getInstance().doSingleAction(context, "dy_register", bundle);
        }
    }

    public static void removeLocalNotification(Context context, long j) {
        checkContext(context);
        d.a(context, j);
    }

    public static void reportMessageOpened(Context context, String str, byte b9) {
        checkContext(context);
        if (!TextUtils.isEmpty(str)) {
            cn.jpush.android.helper.d.a(str, "", b9, 1028L, context);
            return;
        }
        Logger.ee("JPushInterface", "The msgId is not valid - " + str);
    }

    public static void reportNotificationOpened(Context context, String str) {
        checkContext(context);
        if (!TextUtils.isEmpty(str)) {
            cn.jpush.android.helper.d.a(str, 1028L, context);
            return;
        }
        Logger.ee("JPushInterface", "The msgId is not valid - " + str);
    }

    public static void reportWakedData(Context context, Bundle bundle, int i9) {
        checkContext(context);
        try {
            JCoreManager.reportWakedData(context, bundle, i9);
        } catch (Throwable unused) {
            Logger.ee("JPushInterface", "not found [reportWakedData] in jcore");
        }
    }

    public static void requestPermission(Context context) {
        if (context == null) {
            Logger.ww("JPushInterface", "[requestPermission] unexcepted - context was null");
        } else {
            JCoreManager.requestPermission(context);
        }
    }

    public static void requestRequiredPermission(Activity activity) {
        if (activity == null) {
            Logger.ww("JPushInterface", "[requestRequiredPermission] unexcepted - context was null");
        } else {
            cn.jpush.android.ad.b.l(activity);
        }
    }

    public static void resumePush(Context context) {
        Logger.kd("JPushInterface", "action:resumePush");
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "resume", null);
    }

    public static void setAlias(Context context, int i9, String str) {
        checkContext(context);
        ActionHelper.getInstance().setAliasWithCallBack(context, i9, str, 2, 2);
        Logger.kd("JPushInterface", "current use set alias is:" + str);
    }

    public static void setBadgeNumber(Context context, int i9) {
        Context appContext = JPushConstants.getAppContext(context);
        if (i9 < 0) {
            i9 = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", i9);
        JCoreHelper.runActionWithService(appContext, JPushConstants.SDK_TYPE, "set_badge", bundle);
    }

    public static void setChannel(Context context, String str) {
        JCoreHelper.setChannel(context, str);
    }

    public static void setCollectControl(Context context, JPushCollectControl jPushCollectControl) {
        checkContext(context);
        if (jPushCollectControl != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("enable_c_c", jPushCollectControl.getEnableDatas());
                bundle.putIntegerArrayList("disable_c_c", jPushCollectControl.getDisableDatas());
                JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 111, null, bundle, new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:15:0x0078 */
    public static void setDataInsightsEnable(Context context, boolean z8) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z8);
            bundle.putBoolean("enable_data_insights", z8);
            a.k(context, z8);
            try {
                if (JConstants.SDK_VERSION_INT >= 490) {
                    Logger.d("JPushInterface", "setDataInsightsEnable   bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                    ActionHelper.getInstance().doSingleAction(context, "enable_data_insights", bundle);
                } else {
                    Logger.d("JPushInterface", "setDataInsightsEnable  runActionWithService bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                    JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_data_insights", bundle);
                }
            } catch (Throwable unused) {
                Logger.d("JPushInterface", "setDataInsightsEnable  err runActionWithService bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_data_insights", bundle);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void setDebugMode(boolean z8) {
        JCoreManager.setDebugMode(z8);
    }

    private static void setDefaultNotifactionNumber(Context context) {
        setLatestNotificationNumber(context, DEFAULT_NOTIFICATION_NUM);
    }

    public static void setDefaultPushNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        if (pushNotificationBuilder == null) {
            throw new IllegalArgumentException("NULL notification");
        }
        Bundle bundle = new Bundle();
        bundle.putInt("buidler_id", f11194a.intValue());
        bundle.putString("buidler_string", pushNotificationBuilder.toString());
        JCoreHelper.runActionWithService(JPushConstants.mApplicationContext, JPushConstants.SDK_TYPE, "set_custom_notify", bundle);
    }

    /* JADX INFO: Removed unreachable split cross block B:15:0x0078 */
    public static void setGeofenceEnable(Context context, boolean z8) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z8);
            bundle.putBoolean("enable_geo_push", z8);
            a.i(context, z8);
            try {
                if (JConstants.SDK_VERSION_INT >= 490) {
                    Logger.d("JPushInterface", "setGeofenceEnable  for 129 bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                    ActionHelper.getInstance().doSingleAction(context, "enable_geo_push", bundle);
                } else {
                    Logger.d("JPushInterface", "setGeofenceEnable  runActionWithService bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                    JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_geo_push", bundle);
                }
            } catch (Throwable unused) {
                Logger.d("JPushInterface", "setGeofenceEnable  err runActionWithService bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_geo_push", bundle);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void setGeofenceInterval(Context context, long j) {
        checkContext(context);
        if (j < 180000 || j > 86400000) {
            Logger.ee("JPushInterface", "Invalid interval, it should be a ms number between 3 mins and 1 day!");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong(MTPushConstants.Geofence.KEY_INTERVAL, j);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "geo_interval", bundle);
    }

    public static void setHbPeriodEnable(Context context, boolean z8) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z8);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "set_hb_period_enable", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void setHeartbeatInterval(Context context, int i9) {
        JCoreManager.onEvent(context, null, 55, null, f.j(i9, "heartbeat_interval"), new Object[0]);
    }

    public static void setKeepLongConnInBackground(Context context, boolean z8) {
        Logger.dd("JPushInterface", "setKeepLongConnInBackground: " + z8);
        checkContext(context);
        try {
            if (JConstants.SDK_VERSION_INT >= 540) {
                a.g(context, z8);
                JCoreHelper.syncKeepLongConnInBackground(context);
            } else {
                Logger.d("JPushInterface", "setKeepLongConnInBackground ignored, jcore version: " + JConstants.SDK_VERSION_INT);
            }
        } catch (Throwable th) {
            f.r(th, new StringBuilder("setKeepLongConnInBackground: "), "JPushInterface");
        }
    }

    public static void setLatestNotificationNumber(Context context, int i9) {
        checkContext(context);
        Logger.dd("JPushInterface", "action:setLatestNotificationNumber : " + i9);
        if (i9 <= 0) {
            Logger.ee("JPushInterface", "maxNum should > 0, Give up action..");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", i9);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "max_num", bundle);
    }

    public static void setLinkMergeEnable(Context context, boolean z8) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z8);
            bundle.putBoolean("enable_link_push", z8);
            a.j(context, z8);
            JCoreInterface.setWakeEnable(context, z8);
            try {
                if (JConstants.SDK_VERSION_INT >= 490) {
                    Logger.d("JPushInterface", "setLinkMergeEnable  for 129 bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                    ActionHelper.getInstance().doSingleAction(context, "enable_link_push", bundle);
                } else {
                    Logger.d("JPushInterface", "setLinkMergeEnable  runActionWithService bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                    JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_link_push", bundle);
                }
            } catch (Throwable unused) {
                Logger.d("JPushInterface", "setLinkMergeEnable  err runActionWithService bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_link_push", bundle);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void setMaxGeofenceNumber(Context context, int i9) {
        checkContext(context);
        if (i9 < 1 || i9 > 100) {
            Logger.ee("JPushInterface", "Invalid maxNumber,it should be a number between 1 and 100!");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", i9);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "geo_fence_max_num", bundle);
    }

    public static void setMobileNumber(Context context, int i9, String str) {
        checkContext(context);
        e.a().a(context, i9, str);
    }

    public static void setNotificationCallBackEnable(Context context, boolean z8) {
        Logger.dd("JPushInterface", "setNotificationCallBackEnable");
        checkContext(context);
        try {
            a.l(context, z8);
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z8);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_notification_callback", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void setProperties(Context context, int i9, Map<String, Object> map) {
        checkContext(context);
        ActionHelper.getInstance().setPropertyWithCallBack(context, i9, map, 3, 0);
    }

    public static void setPushNotificationBuilder(Integer num, PushNotificationBuilder pushNotificationBuilder) {
        Logger.vv("JPushInterface", "action:setPushNotificationBuilder - id:" + num);
        if (pushNotificationBuilder == null) {
            throw new IllegalArgumentException("NULL pushNotificationBuilder");
        }
        if (num.intValue() < 1) {
            Logger.ee("JPushInterface", "id should be larger than 0");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("buidler_id", num.intValue());
        bundle.putString("buidler_string", pushNotificationBuilder.toString());
        JCoreHelper.runActionWithService(JPushConstants.mApplicationContext, JPushConstants.SDK_TYPE, "set_custom_notify", bundle);
    }

    public static void setPushTime(Context context, Set<Integer> set, int i9, int i10) {
        checkContext(context);
        if (!cn.jpush.android.ad.b.a(context)) {
            Logger.dd("JPushInterface", "检测到当前没有网络。此动作将在有网络时自动继续执行。");
        }
        if (set == null) {
            Bundle bundle = new Bundle();
            bundle.putString(CrashHianalyticsData.TIME, "0123456_0^23");
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "pushtime", bundle);
            return;
        }
        if (set.size() == 0 || set.isEmpty()) {
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "disable_push", null);
            return;
        }
        if (i9 > i10) {
            Logger.ee("JPushInterface", "Invalid time format - startHour should less than endHour");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : set) {
            if (num.intValue() > 6 || num.intValue() < 0) {
                Logger.ee("JPushInterface", "Invalid day format - " + num);
                return;
            }
            sb.append(num);
        }
        sb.append(BundleUtil.UNDERLINE_TAG);
        sb.append(i9);
        sb.append("^");
        sb.append(i10);
        Bundle bundle2 = new Bundle();
        bundle2.putString(CrashHianalyticsData.TIME, sb.toString());
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "pushtime", bundle2);
    }

    public static void setSilenceTime(Context context, int i9, int i10, int i11, int i12) {
        checkContext(context);
        if (i9 < 0 || i10 < 0 || i11 < 0 || i12 < 0 || i10 > 59 || i12 > 59 || i11 > 23 || i9 > 23) {
            Logger.ee("JPushInterface", "Invalid parameter format, startHour and endHour should between 0 ~ 23, startMins and endMins should between 0 ~ 59. ");
            return;
        }
        if (i9 == 0 && i10 == 0 && i11 == 0 && i12 == 0) {
            Bundle bundle = new Bundle();
            bundle.putString(CrashHianalyticsData.TIME, "");
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "silenceTime", bundle);
            Logger.dd("JPushInterface", "Remove the silence time!");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startHour", i9);
            jSONObject.put("startMins", i10);
            jSONObject.put("endHour", i11);
            jSONObject.put("endtMins", i12);
            Bundle bundle2 = new Bundle();
            bundle2.putString(CrashHianalyticsData.TIME, jSONObject.toString());
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "silenceTime", bundle2);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:15:0x0078 */
    public static void setSmartPushEnable(Context context, boolean z8) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z8);
            bundle.putBoolean("enable_smart_push", z8);
            a.m(context, z8);
            try {
                if (JConstants.SDK_VERSION_INT >= 490) {
                    Logger.d("JPushInterface", "setSmartPushEnable  for 129 bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                    ActionHelper.getInstance().doSingleAction(context, "enable_smart_push", bundle);
                } else {
                    Logger.d("JPushInterface", "setSmartPushEnable  runActionWithService bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                    JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_smart_push", bundle);
                }
            } catch (Throwable unused) {
                Logger.d("JPushInterface", "setSmartPushEnable  err runActionWithService bundle=" + bundle + " jcore version=" + JConstants.SDK_VERSION_INT);
                JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_smart_push", bundle);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void setTags(Context context, int i9, Set<String> set) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i9, set, 1, 2);
        Logger.kd("JPushInterface", "current use set tags is:" + set);
    }

    public static void setThirdPushEnable(Context context, boolean z8) {
        try {
            JPushConstants.THIRD_ENABLE = z8;
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z8);
            ActionHelper.getInstance().doSingleAction(context, "third_enable", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void setThirdToken(Context context, String str) {
        if (!JPushConstants.THIRD_ENABLE) {
            Logger.ee("JPushInterface", "thirdEnable is false,won't set third token");
            return;
        }
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("third_ttoken", str);
            ActionHelper.getInstance().doSingleAction(context, "set_tthird_ttoken", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void si(Context context, Bundle bundle) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "si", bundle);
    }

    public static void stopCrashHandler(Context context) {
        checkContext(context);
        JCoreManager.stopCrashHandler(context);
    }

    public static void stopPush(Context context) {
        Logger.kd("JPushInterface", "action:stopPush");
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "stop", null);
    }

    private static void taq() {
        JPushConstants.testAndroidQ();
    }

    public static void triggerInAppMsgByEvent(Context context, int i9, String str) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sequence", i9);
            bundle.putString("event_name", str);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "trigger_in_app_event", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void triggerNotificationStateCheck(Context context) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 29, null, null, 4);
    }

    @Deprecated
    public void setAliasAndTags(Context context, String str, Set<String> set) {
        checkContext(context);
        setAliasAndTags(context, str, set, null);
    }

    public static void init(Context context, JPushConfig jPushConfig) {
        Logger.ki("JPushInterface", "action:init - jpush, SdkVersion:" + JPushConstants.SDK_VERSION_NAME + ", build id:" + JPushConstants.BUILD_ID + ", build type:release, hash:" + JPushConstants.GIT_COMMIT_HASH);
        checkContext(context);
        if (cn.jpush.android.ad.b.h(context)) {
            Logger.kd("JPushInterface", "check config suceess!!!");
            if (jPushConfig == null) {
                Logger.kw("JPushInterface", "JPushConfig is null, return");
                return;
            }
            JPushConstants.init(context);
            Bundle bundle = new Bundle();
            bundle.putSerializable("config", jPushConfig);
            if (TextUtils.isEmpty(jPushConfig.getjAppKey())) {
                JCoreHelper.initSdkType(context);
                Logger.kw("JPushInterface", "init  initSdkType");
            } else {
                JCoreHelper.registerSdkType(context, jPushConfig.getjAppKey());
            }
            ActionHelper.getInstance().doSingleAction(context, "third_init", bundle);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, TCPTimingCache.P_INIT, bundle);
        }
    }

    @Deprecated
    public static void pullInAppMessage(Context context, int i9, int i10) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sequence", i9);
            bundle.putInt("type", i10);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void reportNotificationOpened(Context context, String str, byte b9) {
    }

    @Deprecated
    public static void setAlias(Context context, String str, TagAliasCallback tagAliasCallback) {
        checkContext(context);
        setAliasAndTags(context, str, null, tagAliasCallback);
    }

    @Deprecated
    public static void setAliasAndTags(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback) {
        checkContext(context);
        ActionHelper.getInstance().setAliasAndTagsWithCallBack(context, str, set, tagAliasCallback, 0, 0);
    }

    @Deprecated
    public static void setTags(Context context, Set<String> set, TagAliasCallback tagAliasCallback) {
        checkContext(context);
        setAliasAndTags(context, null, set, tagAliasCallback);
    }

    public static void pullInAppMessage(Context context, int i9, String str) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sequence", i9);
            bundle.putString("AdPositionKey", str);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void reportNotificationOpened(Context context, String str, byte b9, String str2) {
    }

    public static void setDaemonAction(String str) {
    }

    public static void setStatisticsEnable(boolean z8) {
    }

    public static void setStatisticsSessionTimeout(long j) {
    }

    public static void setPowerSaveMode(Context context, boolean z8) {
    }
}
