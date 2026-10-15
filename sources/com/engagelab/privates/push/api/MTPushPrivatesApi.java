package com.engagelab.privates.push.api;

import W5.f;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.annotation.AllAPI;
import com.engagelab.privates.common.annotation.AllClass;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.f1;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.helper.CollectControlHelper;
import com.engagelab.privates.common.helper.MTCollectControl;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.s0;
import com.engagelab.privates.common.t0;
import com.engagelab.privates.common.x;
import com.engagelab.privates.core.MTCore;
import com.engagelab.privates.push.MTPush;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.engagelab.privates.push.utils.ActivityUtil;
import com.engagelab.privates.push.utils.ApplicationContextUtil;
import com.engagelab.privates.push.utils.NotificationUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import p171w.a;

/* JADX INFO: loaded from: classes.dex */
@AllAPI
public class MTPushPrivatesApi {

    @AllAPI
    public static final byte PLATFORM_DEFAULT = 0;

    @AllAPI
    public static final byte PLATFORM_GOOGLE = 8;

    @AllAPI
    public static final byte PLATFORM_HONOR = 7;

    @AllAPI
    public static final byte PLATFORM_HUAWEI = 2;

    @AllAPI
    public static final byte PLATFORM_MEIZU = 3;

    @AllAPI
    public static final byte PLATFORM_OPPO = 4;

    @AllAPI
    public static final byte PLATFORM_VIVO = 5;

    @AllAPI
    public static final byte PLATFORM_XIAOMI = 1;

    @AllAPI
    public static int SDK_VERSION_CODE = 542;

    @AllAPI
    public static String SDK_VERSION_NAME = "5.4.2";

    @AllAPI
    private static final String TAG = "MTPushPrivatesApi";

    @AllClass
    public static class Code {
        public static int CONNECT_NOT_ENABLE = 6012;
        public static int INVALID_ALIAS = 6003;
        public static int INVALID_JSON = 6010;
        public static int INVALID_MOBILE_NUMBER = 6023;
        public static int INVALID_TAGS = 6005;
        public static int INVOKE_TOO_SOON = 6011;
        public static int NULL_TAG_AND_ALIAS = 6001;
        public static final int SUCCESS = 0;
        public static int TIMEOUT = 6002;
        public static int TOO_LONG_ALIAS = 6004;
        public static int TOO_LONG_TAG = 6006;
        public static int TOO_LONG_TAGS = 6008;
        public static int TOO_MANY_TAGS = 6007;
        public static int UNKNOWN_ERROR = 6009;
    }

    @AllAPI
    public static void addTag(Context context, int i9, String... strArr) {
        if (context == null) {
            MTCommonLog.e(TAG, "addTag context can't be null, please check it");
            return;
        }
        if (i9 == 0) {
            MTCommonLog.e(TAG, "addTag sequence can't be 0, please check it");
            return;
        }
        if (strArr == null) {
            MTCommonLog.e(TAG, "addTag tag can't be null, please check it");
            return;
        }
        if (strArr.length == 0) {
            MTCommonLog.e(TAG, "addTag tag can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundleJ = f.j(i9, "sequence");
            bundleJ.putStringArray("tag", strArr);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_ADD, bundleJ);
        }
    }

    @AllAPI
    public static void clearAlias(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "clearAlias context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ALIAS_CLEAR, f.j(i9, "sequence"));
        }
    }

    @AllAPI
    public static void clearNotification(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "clearNotification context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.CLEAR_NOTIFICATION, f.j(i9, MTPushConstants.Notification.KEY_NOTIFY_ID));
        }
    }

    public static void clearPlatformToken(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "clearPlatformToken context can't be null, please check it");
        } else {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_PLATFORM_CLEAR_TOKEN, null);
        }
    }

    @AllAPI
    @Deprecated
    public static void configOldPushVersion(Context context) {
        MTCommonLog.w(TAG, "configOldPushVersion is deprecated, please remove this call");
    }

    @AllAPI
    public static void configUserLanguage(Context context, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "configPushLanguage context can't be null, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            x.e(context, str);
            Bundle bundle = new Bundle();
            bundle.putString(MTPushConstants.SetData.SET_USER_LANGUAGE, str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.SET_USER_LANGUAGE, bundle);
        }
    }

    @AllAPI
    public static void deleteAllTag(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "deleteAllTag context can't be null, please check it");
            return;
        }
        if (i9 == 0) {
            MTCommonLog.e(TAG, "deleteAllTag sequence can't be 0, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_DELETE_ALL, f.j(i9, "sequence"));
        }
    }

    @AllAPI
    public static void deleteGeofence(Context context, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "deleteGeofence context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "deleteGeofence geofenceId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.DELETE_GEOFENCE, bundle);
        }
    }

    @AllAPI
    public static void deleteTag(Context context, int i9, String... strArr) {
        if (context == null) {
            MTCommonLog.e(TAG, "deleteTag context can't be null, please check it");
            return;
        }
        if (i9 == 0) {
            MTCommonLog.e(TAG, "deleteTag sequence can't be 0, please check it");
            return;
        }
        if (strArr == null) {
            MTCommonLog.e(TAG, "deleteTag tag can't be null, please check it");
            return;
        }
        if (strArr.length == 0) {
            MTCommonLog.e(TAG, "deleteTag tag can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundleJ = f.j(i9, "sequence");
            bundleJ.putStringArray("tag", strArr);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_DELETE, bundleJ);
        }
    }

    @AllAPI
    public static void getAlias(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "getAlias context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ALIAS_GET, f.j(i9, "sequence"));
        }
    }

    @AllAPI
    public static void goToAppNotificationSettings(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "goToAppNotificationSettings context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationUtil.goToAppNotificationSettings(context.getApplicationContext());
        }
    }

    @AllAPI
    public static void init(Context context) {
        MTCommonLog.d(TAG, "MTPushPrivatesApi.init 5.4.2");
        if (context == null) {
            MTCommonLog.e(TAG, "init context can't be null, please check it");
            return;
        }
        if (!MTGlobal.isMainProcess(context.getApplicationContext()) && !MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCommonLog.e(TAG, "Please call the MTPushPrivatesApi.init function in the main process or the push process");
            return;
        }
        MTCommonPrivatesApi.init(context.getApplicationContext(), true);
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            ApplicationContextUtil.init(context.getApplicationContext());
            ActivityUtil.registerActivityLifecycleCallbacks(context.getApplicationContext());
            MTCommonPrivatesApi.observer(context.getApplicationContext(), new MTCore());
            MTCommonPrivatesApi.observer(context.getApplicationContext(), new MTPush());
            s0.a().a(context.getApplicationContext());
            t0.a().a(context);
        }
    }

    @AllClass
    public static void onFragmentPause(Context context, String str) {
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            String strA = a.a(MTGlobal.getCurrentActivityName(), ContainerUtils.FIELD_DELIMITER, str);
            Bundle bundle = new Bundle();
            bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY, strA);
            MTCommonPrivatesApi.sendMessageToMainProcess(context.getApplicationContext(), 1018, bundle);
        }
    }

    @AllClass
    public static void onFragmentResume(Context context, String str) {
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            String strA = a.a(MTGlobal.getCurrentActivityName(), ContainerUtils.FIELD_DELIMITER, str);
            Bundle bundle = new Bundle();
            bundle.putString(MTCommonConstants.Lifecycle.KEY_ACTIVITY, strA);
            MTCommonPrivatesApi.sendMessageToMainProcess(context.getApplicationContext(), MTCommonConstants.MainWhat.ON_FRAGMENT_RESUMED, bundle);
        }
    }

    @AllAPI
    public static void queryAllTag(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "queryAllTag context can't be null, please check it");
            return;
        }
        if (i9 == 0) {
            MTCommonLog.e(TAG, "queryAllTag sequence can't be 0, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_QUERY_ALL, f.j(i9, "sequence"));
        }
    }

    @AllAPI
    public static void queryTag(Context context, int i9, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "queryTag context can't be null, please check it");
            return;
        }
        if (i9 == 0) {
            MTCommonLog.e(TAG, "queryTag sequence can't be 0, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "queryTag tag can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt("sequence", i9);
            bundle.putString("tag", str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_QUERY, bundle);
        }
    }

    @AllAPI
    public static void reportCustomClick(Context context, String str, byte b9, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportCustomClick context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportCustomClick messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            CustomMessage platformMessageId = new CustomMessage().setMessageId(str).setPlatform(b9).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_CUSTOM_CLICK, bundle);
        }
    }

    @AllAPI
    public static void reportCustomDisplay(Context context, String str, byte b9, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportCustomDisplay context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportCustomDisplay messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            CustomMessage platformMessageId = new CustomMessage().setMessageId(str).setPlatform(b9).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_CUSTOM_DISPLAY, bundle);
        }
    }

    @AllAPI
    public static void reportNotificationArrived(Context context, String str, byte b9, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportNotificationArrived context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportNotificationArrived messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationMessage platformMessageId = new NotificationMessage().setMessageId(str).setPlatform(b9).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_NOTIFICATION_ARRIVED, bundle);
        }
    }

    @AllAPI
    public static void reportNotificationClicked(Context context, String str, byte b9, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportNotificationClicked context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportNotificationClicked messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationMessage platformMessageId = new NotificationMessage().setMessageId(str).setPlatform(b9).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_NOTIFICATION_CLICKED, bundle);
        }
    }

    @AllAPI
    public static void reportNotificationDeleted(Context context, String str, byte b9, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportNotificationDeleted context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportNotificationDeleted messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationMessage platformMessageId = new NotificationMessage().setMessageId(str).setPlatform(b9).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_NOTIFICATION_DELETED, bundle);
        }
    }

    @AllAPI
    public static void reportNotificationOpened(Context context, String str, byte b9, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportNotificationOpened context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportNotificationOpened messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationMessage platformMessageId = new NotificationMessage().setMessageId(str).setPlatform(b9).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_NOTIFICATION_OPENED, bundle);
        }
    }

    @AllAPI
    public static void resetNotificationBadge(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationBadge context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_BADGE, null);
        }
    }

    @AllAPI
    public static void resetNotificationCount(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationCount context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_COUNT, null);
        }
    }

    @AllAPI
    public static void resetNotificationLayout(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationLayout context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_LAYOUT, f.j(i9, "id"));
        }
    }

    @AllAPI
    public static void resetNotificationShowTime(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationShowTime context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_SHOW_TIME, null);
        }
    }

    @AllAPI
    public static void resetNotificationSilenceTime(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationSilenceTime context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_SILENCE_TIME, null);
        }
    }

    @AllAPI
    public static void setAlias(Context context, int i9, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "setAlias context can't be null, please check it");
            return;
        }
        if (str == null) {
            MTCommonLog.e(TAG, "setAlias alias can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt("sequence", i9);
            bundle.putString(MTPushConstants.Operation.KEY_ALIAS, str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ALIAS_SET, bundle);
        }
    }

    @AllAPI
    public static void setCollectControl(MTPushCollectControl mTPushCollectControl) {
        MTCollectControl mTCollectControl = new MTCollectControl();
        mTCollectControl.setGAID(mTPushCollectControl.getGaid());
        mTCollectControl.setAID(false);
        CollectControlHelper.getInstance().setCollectControl(mTCollectControl);
    }

    @AllAPI
    public static void setEnablePushTextToSpeech(Context context, boolean z8) {
        if (context == null) {
            MTCommonLog.e(TAG, "setEnablePushTextToSpeech context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            f1.a().a(context, z8);
        }
    }

    @AllAPI
    public static void setGeofenceCount(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "setGeofenceCount context can't be null, please check it");
            return;
        }
        if (i9 <= 0 || i9 >= 100) {
            MTCommonLog.e(TAG, "setGeofenceCount count must between 0~100, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_GEOFENCE_COUNT, f.j(i9, MTPushConstants.Geofence.KEY_COUNT));
        }
    }

    @AllAPI
    public static void setGeofenceInterval(Context context, long j) {
        if (context == null) {
            MTCommonLog.e(TAG, "setGeofenceInterval context can't be null, please check it");
            return;
        }
        if (j < 180000 || j > 86400000) {
            MTCommonLog.e(TAG, "setGeofenceInterval interval must between 3 * 60 * 1000 ~ 24 * 60 * 60 * 1000, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putLong(MTPushConstants.Geofence.KEY_INTERVAL, j);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_GEOFENCE_INTERVAL, bundle);
        }
    }

    @AllAPI
    public static void setNotificationBadge(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationBadge context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_BADGE, f.j(i9, MTPushConstants.NotificationBadge.KEY_BADGE));
        }
    }

    @AllAPI
    public static void setNotificationCount(Context context, int i9) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationCount context can't be null, please check it");
            return;
        }
        if (i9 < 0) {
            MTCommonLog.e(TAG, "setNotificationCount count can't small than 0, please check it");
            return;
        }
        if (i9 == 0) {
            MTCommonLog.e(TAG, "setNotificationCount count can't equal with 0, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_COUNT, f.j(i9, MTPushConstants.NotificationCount.KEY_COUNT));
        }
    }

    @AllAPI
    public static void setNotificationLayout(Context context, int i9, NotificationLayout notificationLayout) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationLayout context can't be null, please check it");
            return;
        }
        if (notificationLayout == null) {
            MTCommonLog.e(TAG, "setNotificationLayout notificationLayout can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", i9);
            bundle.putParcelable(MTPushConstants.NotificationLayout.KEY_NOTIFICATION_LAYOUT, notificationLayout);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_LAYOUT, bundle);
        }
    }

    @AllAPI
    public static void setNotificationShowTime(Context context, int i9, int i10, int... iArr) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationShowTime context can't be null, please check it");
            return;
        }
        if (i9 < 0 || i9 > 23) {
            MTCommonLog.e(TAG, "setNotificationShowTime beginHour must between 0~23, please check it");
            return;
        }
        if (i10 < 0 || i10 > 23) {
            MTCommonLog.e(TAG, "setNotificationShowTime endHour must between 0~23, please check it");
            return;
        }
        if (i9 > i10) {
            MTCommonLog.e(TAG, "setNotificationShowTime beginHour can't large than endHour, please check it");
            return;
        }
        if (i9 == i10) {
            MTCommonLog.e(TAG, "setNotificationShowTime beginHour can't equal with endHour, please check it");
            return;
        }
        if (iArr.length > 7) {
            MTCommonLog.e(TAG, "setNotificationShowTime weekDays.length must between 0~7, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.NotificationTime.KEY_BEGIN_HOUR, i9);
            bundle.putInt(MTPushConstants.NotificationTime.KEY_END_HOUR, i10);
            bundle.putIntArray(MTPushConstants.NotificationTime.KEY_DAYS, iArr);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_SHOW_TIME, bundle);
        }
    }

    @AllAPI
    public static void setNotificationSilenceTime(Context context, int i9, int i10, int i11, int i12) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime context can't be null, please check it");
            return;
        }
        if (i9 < 0 || i9 > 23) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime beginHour must between 0~23, please check it");
            return;
        }
        if (i10 < 0 || i10 > 59) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime beginMinute must between 0~59, please check it");
            return;
        }
        if (i11 < 0 || i11 > 23) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime endHour must between 0~23, please check it");
            return;
        }
        if (i12 < 0 || i12 > 59) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime endMinute must between 0~59, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.NotificationTime.KEY_BEGIN_HOUR, i9);
            bundle.putInt(MTPushConstants.NotificationTime.KEY_BEGIN_MINUTE, i10);
            bundle.putInt(MTPushConstants.NotificationTime.KEY_END_HOUR, i11);
            bundle.putInt(MTPushConstants.NotificationTime.KEY_END_MINUTE, i12);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_SILENCE_TIME, bundle);
        }
    }

    @AllAPI
    public static void showNotification(Context context, NotificationMessage notificationMessage) {
        if (context == null) {
            MTCommonLog.e(TAG, "showNotification context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", notificationMessage);
            bundle.putBoolean(MTPushConstants.Message.KEY_MESSAGE_LIMIT, false);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SHOW_NOTIFICATION, bundle);
        }
    }

    @AllAPI
    public static void turnOffGeofenceSwitch(Context context) {
        if (context == null) {
            MTCommonLog.e("MTCommonPrivatesApi", "turnOffGeofenceSwitch context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TURN_OFF_GEOFENCESWITCH, null);
        } else {
            MTCommonLog.e("MTCommonPrivatesApi", "turnOffGeofenceSwitch should be called in main process");
        }
    }

    @AllAPI
    public static void turnOffPush(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "turnOffPush context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TURN_OFF_PUSH, null);
        }
    }

    @AllAPI
    public static void turnOnGeofenceSwitch(Context context) {
        if (context == null) {
            MTCommonLog.e("MTCommonPrivatesApi", "turnOnGeofenceSwitch context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TURN_ON_GEOFENCESWITCH, null);
        } else {
            MTCommonLog.e("MTCommonPrivatesApi", "turnOnGeofenceSwitch should be called in main process");
        }
    }

    @AllAPI
    public static void turnOnPush(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "turnOnPush context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TURN_ON_PUSH, null);
        }
    }

    @AllAPI
    public static void updateTag(Context context, int i9, String... strArr) {
        if (context == null) {
            MTCommonLog.e(TAG, "updateTag context can't be null, please check it");
            return;
        }
        if (i9 == 0) {
            MTCommonLog.e(TAG, "updateTag sequence can't be 0, please check it");
            return;
        }
        if (strArr == null) {
            MTCommonLog.e(TAG, "updateTag tag can't be null, please check it");
            return;
        }
        if (strArr.length == 0) {
            MTCommonLog.e(TAG, "updateTag tag can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundleJ = f.j(i9, "sequence");
            bundleJ.putStringArray("tag", strArr);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_UPDATE, bundleJ);
        }
    }

    @AllAPI
    public static void uploadMobileNumber(Context context, int i9, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "uploadMobileNumber context can't be null, please check it");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "uploadMobileNumber mobileNumber can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt("sequence", i9);
            bundle.putString(MTPushConstants.Operation.KEY_MOBILE_NUMBER, str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_MOBILE_NUMBER, bundle);
        }
    }

    @AllAPI
    public static void uploadPlatformToken(Context context, byte b9, String str, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "onPlatformToken context can't be null, please check it");
            return;
        }
        if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            PlatformTokenMessage isUserSettings = new PlatformTokenMessage().setPlatform(b9).setToken(str).setIsUserSettings(true);
            if (!TextUtils.isEmpty(str2)) {
                isUserSettings.setRegion(str2);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", isUserSettings);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_PLATFORM_TOKEN, bundle);
        }
    }

    @AllAPI
    public static void clearNotification(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "clearNotification context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.CLEAR_NOTIFICATION, null);
        }
    }
}
