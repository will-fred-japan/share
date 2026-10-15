package com.engagelab.privates.push.utils;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.engagelab.privates.common.component.MTCommonActivity;
import com.engagelab.privates.common.g1;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.q0;
import com.engagelab.privates.push.api.NotificationLayout;
import com.engagelab.privates.push.api.NotificationMessage;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.starburst.sdk.req.GuiControlRequest;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.Adler32;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NotificationUtil {
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    private static final String JMESSAGE_EXTRA_KEY = "MTInAppExtra";
    public static final String NOTIFICATION_ICON = "mtpush_notification_icon";
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String TAG = "NotificationUtil";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, String> f12423a = new HashMap();

        static {
            a();
        }

        public static int a(int i9) {
            if (i9 == 0 || i9 == 1) {
                return -2;
            }
            if (i9 != 2) {
                return (i9 == 4 || i9 == 5) ? 1 : 0;
            }
            return -1;
        }

        public static int b(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("n_importance");
            if (jSONObjectOptJSONObject != null) {
                String str = Build.MANUFACTURER;
                if (str == null) {
                    return a(jSONObject, -1);
                }
                String str2 = f12423a.get(str.toLowerCase());
                if (str2 != null) {
                    int iOptInt = jSONObjectOptJSONObject.optInt(str2, -1);
                    MTCommonLog.d(NotificationUtil.TAG, "im_v:" + iOptInt);
                    return iOptInt;
                }
            }
            return a(jSONObject, -1);
        }

        public static int c(JSONObject jSONObject) {
            int iA;
            int iOptInt = jSONObject.optInt("n_priority", 0);
            int iB = b(jSONObject);
            return (-1 != iB && iOptInt > (iA = a(iB))) ? iA : iOptInt;
        }

        public static int a(JSONObject jSONObject, int i9) {
            return i9;
        }

        public static void a() {
            Map<String, String> map = f12423a;
            map.put("google".toLowerCase(), "fc");
            map.put(MTPushConstants.Manufacturer.HUAWEI.toLowerCase(), "hw");
            map.put(MTPushConstants.Manufacturer.HONOR.toLowerCase(), "hn");
            map.put(MTPushConstants.Manufacturer.MEIZU.toLowerCase(), "mz");
            map.put(MTPushConstants.Manufacturer.VIVO.toLowerCase(), "vi");
            map.put(MTPushConstants.Manufacturer.OPPO.toLowerCase(), "op");
            map.put(MTPushConstants.Manufacturer.REALME.toLowerCase(), "op");
            map.put(MTPushConstants.Manufacturer.ONEPLUS.toLowerCase(), "op");
            map.put(MTPushConstants.Manufacturer.XIAOMI.toLowerCase(), "xm");
            map.put(MTPushConstants.Manufacturer.BLACKSHARK.toLowerCase(), "xm");
        }
    }

    public static boolean checkValidUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strTrim = str.trim();
        boolean zMatches = strTrim.matches("^[http|https]+://.*");
        if (!zMatches) {
            MTCommonLog.w(TAG, "Invalid url - ".concat(strTrim));
        }
        return zMatches;
    }

    public static String[] convertJsonToArray(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            String[] strArr = new String[jSONObject.length()];
            int i9 = 0;
            while (itKeys.hasNext()) {
                strArr[i9] = jSONObject.optString(itKeys.next());
                i9++;
            }
            return strArr;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("convertJsonToArray failed "), TAG);
            return null;
        }
    }

    public static Bundle convertJsonToBundle(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(jSONObject.toString())) {
                return null;
            }
            Bundle bundle = new Bundle();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle.putString(next, jSONObject.optString(next));
            }
            return bundle;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("convertJsonToBundle failed "), TAG);
            return null;
        }
    }

    public static Bundle convertMapToBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    public static Notification.BigPictureStyle getBigPictureStyle(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            Bitmap pictureBitmap = getPictureBitmap(context, str);
            if (pictureBitmap == null) {
                return null;
            }
            return bigPictureStyle.bigPicture(pictureBitmap);
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("get bigPictureStyle failed "), TAG);
            return null;
        }
    }

    public static Notification.BigTextStyle getBigTextStyle(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new Notification.BigTextStyle().bigText(str);
    }

    public static String getContent(Context context, NotificationMessage notificationMessage) {
        return TextUtils.isEmpty(notificationMessage.getContent()) ? context.getApplicationInfo().loadLabel(context.getPackageManager()).toString() : notificationMessage.getContent();
    }

    public static int getDefaults(Context context, boolean z8, NotificationMessage notificationMessage) {
        if (z8) {
            return (notificationMessage.getDefaults() & 1) == 0 ? notificationMessage.getDefaults() : notificationMessage.getDefaults() - 1;
        }
        switch (notificationMessage.getDefaults()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return notificationMessage.getDefaults();
            default:
                return -1;
        }
    }

    public static String getGroup(Context context, NotificationMessage notificationMessage) {
        return TextUtils.isEmpty(notificationMessage.getGroupId()) ? "group" : notificationMessage.getGroupId();
    }

    public static Notification.InboxStyle getInboxStyle(Context context, String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                    for (String str : strArr) {
                        inboxStyle.addLine(str);
                    }
                    inboxStyle.setSummaryText(" + " + strArr.length + " new messages");
                    return inboxStyle;
                }
            } catch (Throwable th) {
                H2.a.k(th, new StringBuilder("getInboxStyle failed "), TAG);
            }
        }
        return null;
    }

    public static Bitmap getLargeIcon(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getPictureBitmap(context, str);
    }

    private static String getLaunchActivityClassName(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null && launchIntentForPackage.getComponent() != null) {
                return launchIntentForPackage.getComponent().getClassName();
            }
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity == null) {
                resolveInfoResolveActivity = packageManager.resolveActivity(launchIntentForPackage, 0);
            }
            return resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.name : "";
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getLaunchActivityClassName failed "), TAG);
            return "";
        }
    }

    public static String getMessageId(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("ad_id");
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = jSONObject.optString("msg_id");
        }
        return TextUtils.isEmpty(strOptString) ? jSONObject.optString("_jmsgid_") : strOptString;
    }

    public static int getNotificationId(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            MTCommonLog.d(TAG, "the messageId [" + str + "] will convert to adler32");
            try {
                Adler32 adler32 = new Adler32();
                adler32.update(str.getBytes());
                int value = (int) adler32.getValue();
                return value < 0 ? Math.abs(value) : value;
            } catch (Throwable th) {
                H2.a.k(th, new StringBuilder("getNotificationId failed "), TAG);
                return 0;
            }
        }
    }

    public static int getNotificationImportance(JSONObject jSONObject) {
        return a.b(jSONObject);
    }

    public static RemoteViews getNotificationLayout(Context context, NotificationMessage notificationMessage) {
        try {
            NotificationLayout notificationLayoutA = q0.a().a(context, notificationMessage.getBuilderId());
            if (notificationLayoutA == null) {
                MTCommonLog.d(TAG, "getNotificationLayout builderId:" + notificationMessage.getBuilderId() + ", notificationLayout is null");
                return null;
            }
            MTCommonLog.d(TAG, "getNotificationLayout builderId:" + notificationMessage.getBuilderId() + ", notificationLayout:" + notificationLayoutA.toString());
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), notificationLayoutA.getLayoutId());
            if (notificationLayoutA.getIconViewId() > 0) {
                remoteViews.setImageViewResource(notificationLayoutA.getIconViewId(), getSmallIcon(context));
                Icon smallIcon = getSmallIcon(context, notificationMessage);
                if (smallIcon != null) {
                    remoteViews.setImageViewIcon(notificationLayoutA.getIconViewId(), smallIcon);
                }
            }
            if (notificationLayoutA.getTitleViewId() > 0) {
                remoteViews.setTextViewText(notificationLayoutA.getTitleViewId(), getTitle(context, notificationMessage));
            }
            if (notificationLayoutA.getContentViewId() > 0) {
                remoteViews.setTextViewText(notificationLayoutA.getContentViewId(), getContent(context, notificationMessage));
            }
            if (notificationLayoutA.getTimeViewId() > 0) {
                remoteViews.setLong(notificationLayoutA.getTimeViewId(), "setTime", System.currentTimeMillis());
            }
            return remoteViews;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getNotificationLayout failed "), TAG);
            return null;
        }
    }

    public static NotificationMessage getNotificationMessage(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            String messageId = getMessageId(jSONObject);
            if (TextUtils.isEmpty(messageId)) {
                MTCommonLog.d(TAG, "notificationMessage's messageId is null, can't show this notification");
                return null;
            }
            String strOptString = jSONObject.optString("override_msg_id");
            int notificationId = TextUtils.isEmpty(strOptString) ? getNotificationId(messageId) : getNotificationId(strOptString);
            String strOptString2 = jSONObject.optString("appkey");
            int iOptInt = jSONObject.optInt("n_builder_id");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("m_content");
            if (jSONObjectOptJSONObject == null) {
                MTCommonLog.d(TAG, "onMessage failed, can't parse content");
                return null;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("inapp");
            long jOptLong = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optLong("inapp_end_time", 0L) : 0L;
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("n_target_event");
            String string = (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) ? "" : jSONArrayOptJSONArray.toString();
            String strOptString3 = jSONObjectOptJSONObject.optString("n_title");
            String strOptString4 = jSONObjectOptJSONObject.optString("n_content");
            Bundle bundleConvertJsonToBundle = convertJsonToBundle(jSONObjectOptJSONObject.optJSONObject("n_extras"));
            String strOptString5 = jSONObjectOptJSONObject.optString("n_small_icon");
            String strOptString6 = jSONObjectOptJSONObject.optString("n_color");
            String strOptString7 = jSONObjectOptJSONObject.optString("n_large_icon");
            try {
                int iOptInt2 = jSONObjectOptJSONObject.optInt("n_alert_type", -1);
                int priority = getPriority(jSONObjectOptJSONObject);
                String str2 = string;
                int notificationImportance = getNotificationImportance(jSONObjectOptJSONObject);
                long j = jOptLong;
                String strOptString8 = jSONObjectOptJSONObject.optString("n_category");
                int iOptInt3 = jSONObjectOptJSONObject.optInt("n_style");
                String strOptString9 = jSONObjectOptJSONObject.optString("n_big_text");
                String strOptString10 = jSONObjectOptJSONObject.optString("n_big_pic_path");
                String[] strArrConvertJsonToArray = convertJsonToArray(jSONObjectOptJSONObject.optString("n_inbox"));
                String strOptString11 = jSONObjectOptJSONObject.optString("n_channel_id");
                String strOptString12 = jSONObjectOptJSONObject.optString("n_group_id");
                boolean z8 = true;
                if (jSONObjectOptJSONObject.optInt("n_is_fold", 0) != 1) {
                    z8 = false;
                }
                return new NotificationMessage().setMessageId(messageId).setOverrideMessageId(strOptString).setDisplayForeground(jSONObjectOptJSONObject.optString("n_display_foreground")).setPlatform((byte) 0).setNotificationId(notificationId).setSmallIcon(strOptString5).setLargeIcon(strOptString7).setTitle(strOptString3).setContent(strOptString4).setColor(strOptString6).setBuilderId(iOptInt).setExtras(bundleConvertJsonToBundle).setStyle(iOptInt3).setBigText(strOptString9).setInbox(strArrConvertJsonToArray).setBigPicture(strOptString10).setDefaults(iOptInt2).setPriority(priority).setImportance(notificationImportance).setCategory(strOptString8).setSound(jSONObjectOptJSONObject.optString("n_sound")).setChannelId(strOptString11).setGroupId(strOptString12).setGroupSummary(z8).setIntentUri(jSONObjectOptJSONObject.optString("intent_uri")).setBadge(jSONObjectOptJSONObject.optInt("n_badge_add_num")).setInAppEndTime(j).setTargetEvent(str2).setAppkey(strOptString2);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static Intent getNotificationMessageIntent(Context context, String str, NotificationMessage notificationMessage) {
        Intent intent = new Intent();
        intent.setClass(context, MTCommonActivity.class);
        intent.setAction(str);
        intent.addFlags(276824064);
        Bundle bundle = new Bundle();
        bundle.putParcelable("message", notificationMessage);
        intent.putExtras(bundle);
        return intent;
    }

    public static boolean getNotificationState(Context context) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager == null) {
                return false;
            }
            return notificationManager.areNotificationsEnabled();
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getNotificationState failed "), TAG);
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i9 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class cls2 = Integer.TYPE;
                Method method = cls.getMethod(CHECK_OP_NO_THROW, cls2, cls2, String.class);
                Integer num = (Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class);
                num.intValue();
                return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i9), packageName)).intValue() == 0;
            } catch (Throwable th2) {
                H2.a.k(th2, new StringBuilder("getNotificationState failed "), TAG);
                return false;
            }
        }
    }

    public static PendingIntent getPendingIntent(Context context, String str, NotificationMessage notificationMessage) {
        return PendingIntent.getActivity(context, notificationMessage.getNotificationId(), getNotificationMessageIntent(context, str, notificationMessage), 67108864);
    }

    public static Bitmap getPictureBitmap(Context context, String str) {
        try {
            if (!checkValidUrl(str)) {
                Bitmap bitmapFromLocalResource = ResourceHelper.getBitmapFromLocalResource(context, str);
                Runtime.getRuntime().gc();
                return bitmapFromLocalResource;
            }
            byte[] bArr = HttpUtils.get(context, str, false);
            if (bArr == null) {
                MTCommonLog.d(TAG, "getPicture bytes is null");
                Runtime.getRuntime().gc();
                return null;
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Runtime.getRuntime().gc();
            return bitmapDecodeByteArray;
        } catch (Throwable th) {
            try {
                MTCommonLog.w(TAG, "get pictureBitmap failed " + th.getMessage());
                return null;
            } finally {
                Runtime.getRuntime().gc();
            }
        }
    }

    public static int getPriority(Context context, boolean z8, NotificationMessage notificationMessage) {
        if (z8) {
            return -1;
        }
        int priority = notificationMessage.getPriority();
        if (priority == -2 || priority == -1 || priority == 0 || priority == 1 || priority == 2) {
            return notificationMessage.getPriority();
        }
        return 0;
    }

    public static int getSmallIcon(Context context) {
        int identifier = context.getResources().getIdentifier(NOTIFICATION_ICON, "drawable", context.getPackageName());
        if (identifier > 0) {
            return identifier;
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).icon;
        } catch (Throwable th) {
            MTCommonLog.w(TAG, "get getSmallIcon failed " + th.getMessage());
            MTCommonLog.e(TAG, "please put icon [mtpush_notification_icon] in res/drawable");
            return 0;
        }
    }

    public static Uri getSoundUri(Context context, boolean z8, NotificationMessage notificationMessage) {
        if (z8) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(notificationMessage.getSound())) {
                return null;
            }
            if (context.getResources().getIdentifier(notificationMessage.getSound(), "raw", context.getPackageName()) == 0) {
                MTCommonLog.d(TAG, "there are no sound resource");
                return null;
            }
            return Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + notificationMessage.getSound());
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getSoundUri failed "), TAG);
            return null;
        }
    }

    public static Notification.Style getStyle(Context context, NotificationMessage notificationMessage) {
        int style = notificationMessage.getStyle();
        if (style == 1) {
            return getBigTextStyle(context, notificationMessage.getBigText());
        }
        if (style == 2) {
            return getInboxStyle(context, notificationMessage.getInbox());
        }
        if (style != 3) {
            return null;
        }
        return getBigPictureStyle(context, notificationMessage.getBigPicture());
    }

    public static String getTitle(Context context, NotificationMessage notificationMessage) {
        return TextUtils.isEmpty(notificationMessage.getTitle()) ? context.getApplicationInfo().loadLabel(context.getPackageManager()).toString() : notificationMessage.getTitle();
    }

    public static int getVisibility(Context context, boolean z8, NotificationMessage notificationMessage) {
        int priority;
        if (z8 || (priority = notificationMessage.getPriority()) == -2 || priority == -1) {
            return -1;
        }
        return (priority == 1 || priority == 2) ? 1 : 0;
    }

    public static boolean goToAppNotificationSettings(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", context.getApplicationInfo().uid);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("goToAppNotificationSettings failed "), TAG);
            return false;
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean jumpDeepLink(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return str.startsWith(GuiControlRequest.IMAGE_TYPE_HTTP) ? jumpWebUrl(context, str, str2) : jumpDeepLinkUrl(context, str, str2);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean jumpDeepLinkUrl(Context context, String str, String str2) {
        try {
            Intent uri = parseUri(str);
            uri.setFlags(268435456);
            if (context.getPackageManager().resolveActivity(uri, 0) == null) {
                return false;
            }
            uri.putExtra(JMESSAGE_EXTRA_KEY, str2);
            context.startActivity(uri);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean jumpWebUrl(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                webJumpIntent(context, parseUri(str), str2);
                return true;
            } catch (ActivityNotFoundException unused) {
                webJumpIntent(context, parseUri(str), str2);
                return true;
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static Bundle notificationMessageToInApp(NotificationMessage notificationMessage, Bundle bundle) {
        try {
            String string = bundle.getString("message");
            if (TextUtils.isEmpty(string)) {
                MTCommonLog.w(TAG, "notificationMessageToInApp message is null");
                return null;
            }
            if (notificationMessage == null) {
                MTCommonLog.w(TAG, "notificationMessageToInApp notificationMessage is null");
                return null;
            }
            long inAppEndTime = notificationMessage.getInAppEndTime();
            if (inAppEndTime <= 0) {
                MTCommonLog.w(TAG, "notificationMessageToInApp expired is " + inAppEndTime);
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_notification", true);
            jSONObject.put("expired", inAppEndTime);
            jSONObject.put("delay", BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT);
            jSONObject.put(MTPushConstants.Geofence.KEY_INTERVAL, BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT);
            jSONObject.put("duration", 10000);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 2);
            jSONObject2.put("action", notificationMessage.getIntentUri());
            jSONObject.put("click", jSONObject2);
            jSONObject.put("type", 10);
            jSONObject.put("extras", new JSONObject(string));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("small_image", notificationMessage.getLargeIcon());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("text", notificationMessage.getTitle());
            jSONObject3.put("title", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("text", notificationMessage.getContent());
            jSONObject3.put("content", jSONObject5);
            jSONObject.put("banner", jSONObject3);
            jSONObject.put("location", 0);
            String string2 = jSONObject.toString();
            MTCommonLog.w(TAG, "valueInApp:" + string2);
            bundle.putString("message", string2);
            return bundle;
        } catch (Throwable th) {
            H2.a.i("notificationMessageToInApp failed:", TAG, th);
            return null;
        }
    }

    public static void onClickInAppNotification(Context context, String str) {
        try {
            String strValueOf = String.valueOf(3003);
            NotificationMessage notificationMessage = getNotificationMessage(str);
            if (notificationMessage == null) {
                MTCommonLog.d(TAG, "notificationMessage  is null, can't onClick notification");
            } else {
                context.startActivity(getNotificationMessageIntent(context, strValueOf, notificationMessage));
            }
        } catch (Throwable th) {
            H2.a.i("onClickInAppNotification failed ", TAG, th);
        }
    }

    public static Intent parseUri(String str) throws URISyntaxException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent uri = Intent.parseUri(str, 4);
        Intent intent = new Intent(uri);
        uri.addCategory("android.intent.category.BROWSABLE");
        uri.setComponent(null);
        uri.setSelector(null);
        return intent;
    }

    public static boolean setHonorBadge(Context context, int i9) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
            if (TextUtils.isEmpty(contentResolver.getType(uri))) {
                uri = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                if (TextUtils.isEmpty(contentResolver.getType(uri))) {
                    MTCommonLog.e(TAG, " setHonorBadge fail, uri is null");
                    return false;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString("class", getLaunchActivityClassName(context));
            bundle.putInt("badgenumber", i9);
            contentResolver.call(uri, "change_badge", (String) null, bundle);
            return true;
        } catch (Throwable th) {
            H2.a.i(" setHonorBadge wrong error:", TAG, th);
            return false;
        }
    }

    public static void setHuaweiBadgeNumber(Context context, int i9) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            String launchActivityClassName = getLaunchActivityClassName(context);
            if (TextUtils.isEmpty(launchActivityClassName)) {
                return;
            }
            MTCommonLog.d(TAG, "setHuaweiBadgeNumber " + i9);
            bundle.putString("class", launchActivityClassName);
            bundle.putInt("badgenumber", i9);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("setHuaweiBadgeNumber failed "), TAG);
        }
    }

    public static void setNotificationBadge(Context context, Notification notification, int i9) {
        if (i9 == 0) {
            return;
        }
        int iA = q0.a().a(context);
        int i10 = iA + i9;
        g1.b(context, i10);
        MTCommonLog.d(TAG, "setNotificationBadge cacheNotificationBadge[" + iA + "]+currentNotificationBadge[" + i9 + "]");
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        lowerCase.getClass();
        switch (lowerCase) {
            case "huawei":
                setHuaweiBadgeNumber(context, i10);
                break;
            case "xiaomi":
                setXiaomiBadgeNumber(context, notification, i9);
                break;
            case "honor":
                setHonorBadge(context, i10);
                break;
        }
    }

    public static void setXiaomiBadgeNumber(Context context, Notification notification, int i9) {
        if (notification == null) {
            return;
        }
        if (i9 <= 0) {
            i9 = 0;
        }
        try {
            Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
            obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i9));
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("setXiaomiBadgeNumber failed "), TAG);
        }
    }

    private static void webJumpIntent(Context context, Intent intent, String str) {
        intent.setFlags(268435456);
        intent.putExtra(JMESSAGE_EXTRA_KEY, str);
        context.startActivity(intent);
    }

    public static int getPriority(JSONObject jSONObject) {
        return a.c(jSONObject);
    }

    public static Icon getSmallIcon(Context context, NotificationMessage notificationMessage) {
        Bitmap pictureBitmap;
        try {
            if (TextUtils.isEmpty(notificationMessage.getSmallIcon()) || (pictureBitmap = getPictureBitmap(context, notificationMessage.getSmallIcon())) == null) {
                return null;
            }
            return Icon.createWithBitmap(pictureBitmap);
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("getSmallIcon failed "), TAG);
            return null;
        }
    }
}
