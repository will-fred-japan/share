package cn.jpush.android.helper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JCoreHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Integer f11401a;

    private static void a(Context context, String str, int i9, int i10, long j, long j8, byte[] bArr, boolean z8) {
        Bundle bundle = new Bundle();
        bundle.putInt(MTCoreConstants.Protocol.KEY_CMD, i9);
        bundle.putInt("ver", i10);
        bundle.putLong("rid", j);
        bundle.putLong("timeout", j8);
        bundle.putByteArray("body", bArr);
        JCoreManager.onEvent(context, str, z8 ? 17 : 16, null, bundle, new Object[0]);
    }

    public static Boolean checkSdkBanned(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 82, null, null, new Object[0]);
        return objOnEvent instanceof Boolean ? (Boolean) objOnEvent : Boolean.FALSE;
    }

    public static void execue(Context context, String str, Runnable runnable) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 11, str, null, runnable);
    }

    public static JSONObject fillBase(Context context, JSONObject jSONObject, String str) {
        Object objOnEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 26, "", null, jSONObject, str);
        if (objOnEvent instanceof JSONObject) {
            return (JSONObject) objOnEvent;
        }
        return null;
    }

    public static void futureExecutor(Context context, Runnable runnable) {
        futureExecutor(context, "FUTURE", runnable);
    }

    public static boolean geoEnable(Context context) {
        try {
            if (JConstants.SDK_VERSION_INT >= 490) {
                Bundle bundle = new Bundle();
                bundle.putInt("configID", 1502);
                bundle.putBoolean("isFromJCore", true);
                Object objOnEvent = JCoreManager.onEvent(null, null, 116, null, bundle, new Object[0]);
                if (objOnEvent instanceof Boolean) {
                    return ((Boolean) objOnEvent).booleanValue();
                }
            } else if (!cn.jpush.android.cache.a.s(context) && !cn.jpush.android.cache.a.o(context) && !cn.jpush.android.cache.a.q(context)) {
                return false;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public static String getAppKey(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, null, 7, null, null, new Object[0]);
        return objOnEvent instanceof String ? (String) objOnEvent : "";
    }

    public static String getDeviceId(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, null, 8, null, null, new Object[0]);
        return objOnEvent instanceof String ? (String) objOnEvent : "";
    }

    public static Object getDyInfo(Context context, int i9) {
        return JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 64, null, null, Integer.valueOf(i9));
    }

    public static int getJCoreSDKVersionInt() {
        Integer num = f11401a;
        if (num != null) {
            return num.intValue();
        }
        Object objOnEvent = JCoreManager.onEvent(null, null, 25, null, null, new Object[0]);
        if (!(objOnEvent instanceof Integer)) {
            return 0;
        }
        Integer num2 = (Integer) objOnEvent;
        num2.intValue();
        f11401a = num2;
        return num2.intValue();
    }

    public static int getJPushSDKVersionInt() {
        return cn.jpush.android.m.a.f11447a;
    }

    public static PackageInfo getPackageInfo(Context context, int i9) {
        if (context != null) {
            return getPackageInfo(context, context.getPackageName(), i9);
        }
        return null;
    }

    public static String getRegistrationID(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 4, null, null, new Object[0]);
        return objOnEvent instanceof String ? (String) objOnEvent : "";
    }

    public static long getUid(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, null, 20, null, null, null);
        if (objOnEvent instanceof Long) {
            return ((Long) objOnEvent).longValue();
        }
        return 0L;
    }

    public static void initSdkType(Context context) {
        if (JConstants.SDK_VERSION_INT < 520) {
            JCoreManager.init(context);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("jg_init_sdk_type", JPushConstants.SDK_TYPE);
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 132, null, bundle, new Object[0]);
        JCoreManager.init(context, bundle);
    }

    public static boolean isAuth(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, null, 98, null, null, new Object[0]);
        if (objOnEvent instanceof Boolean) {
            return ((Boolean) objOnEvent).booleanValue();
        }
        return true;
    }

    public static boolean isContinueBusiness(Context context) {
        if (cn.jpush.android.m.a.f11451e < 470) {
            return true;
        }
        Object objOnEvent = JCoreManager.onEvent(context, null, 123, null, null, new Object[0]);
        if (objOnEvent instanceof Boolean) {
            return ((Boolean) objOnEvent).booleanValue();
        }
        return false;
    }

    public static boolean isIpv6Priority(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 121, null, null, new Object[0]);
        if (objOnEvent instanceof Boolean) {
            return ((Boolean) objOnEvent).booleanValue();
        }
        return false;
    }

    public static void majorExecutor(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.m.a.f11451e >= 238) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 75, null, null, runnable);
        } else {
            execue(context, str, runnable);
        }
    }

    public static void netMonitor(Context context, String str, String str2, long j, int i9) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteMessageConst.Notification.URL, str);
        bundle.putString("type", str2);
        bundle.putLong(HiAnalyticsConstant.Direction.REQUEST, j);
        bundle.putLong("res", i9);
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 122, null, bundle, new Object[0]);
    }

    public static void normalExecutor(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.m.a.f11451e >= 238) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 77, null, null, runnable);
        } else {
            execue(context, str, runnable);
        }
    }

    public static void openLog(Context context, Bundle bundle) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 105, null, bundle, new Object[0]);
    }

    public static void registerSdkType(Context context, String str) {
        if (JConstants.SDK_VERSION_INT < 520) {
            JCoreManager.register(context, str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("jg_init_sdk_type", JPushConstants.SDK_TYPE);
        JCoreManager.register(context, str, bundle);
    }

    public static void reportSdkType(Context context, String str, int i9, int i10, int i11) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 72, true, null, null, str, Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public static void runActionWithService(Context context, String str, String str2, Bundle bundle) {
        JCoreManager.onEvent(context, str, 3, str2, bundle, new Object[0]);
    }

    public static void saEvent(Context context, String str, Object obj) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 56, str, null, obj);
    }

    public static void sendData(Context context, String str, int i9, int i10, long j, byte[] bArr) {
        a(context, str, i9, i10, j, 0L, bArr, false);
    }

    public static void sendRequest(Context context, String str, int i9, int i10, long j, long j8, byte[] bArr) {
        a(context, str, i9, i10, j, j8, bArr, true);
    }

    public static void setChannel(Context context, String str) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 9, str, null, new Object[0]);
    }

    public static void syncKeepLongConnInBackground(Context context) {
        try {
            if (JConstants.SDK_VERSION_INT < 540) {
                return;
            }
            boolean zG = cn.jpush.android.cache.a.g(context);
            Bundle bundle = new Bundle();
            bundle.putBoolean("keep_tcp_in_bg", zG);
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 135, null, bundle, new Object[0]);
        } catch (Throwable th) {
            W5.f.r(th, new StringBuilder("syncKeepLongConnectionInBackgroundToJCore: "), "JCoreHelper");
        }
    }

    public static void triggerSceneCheck(Context context) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 29, null, null, 3);
    }

    public static void updateDy(Context context, int i9) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 65, null, null, Integer.valueOf(i9));
    }

    public static void futureExecutor(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.m.a.f11451e >= 238) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 76, null, null, runnable);
        } else {
            execue(context, str, runnable);
        }
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i9) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && i9 >= 0) {
                    if (JConstants.SDK_VERSION_INT < 332) {
                        return context.getPackageManager().getPackageInfo(str, i9);
                    }
                    Object objOnEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 99, null, null, str, Integer.valueOf(i9));
                    if (objOnEvent instanceof PackageInfo) {
                        return (PackageInfo) objOnEvent;
                    }
                    return null;
                }
            } catch (Throwable th) {
                W5.f.r(th, new StringBuilder("get p info failed, error: "), "JCoreHelper");
            }
        }
        Logger.d("JCoreHelper", "get p info failed, because param is illegal");
        return null;
    }
}
