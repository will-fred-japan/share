package cn.jiguang.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.aw.b;
import cn.jiguang.aw.q;
import cn.jiguang.d.a;
import cn.jiguang.e.d;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jiguang.w.h;
import cn.jiguang.x.f;
import com.jieli.jl_bt_ota.constant.GattError;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class JCoreManager {
    private static final String TAG = "JCoreManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9369a = 0;
    private static final AtomicBoolean isInited = new AtomicBoolean();
    private static int DEFAULT_CMD = -1;

    public static void addActivityLifeCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        a.a(activityLifecycleCallbacks);
    }

    public static void addDispatchAction(String str, String str2) {
        a.a(str, str2);
    }

    public static Context getAppContext(Context context) {
        return JConstants.getAppContext(context);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        Object objOnEvent = JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 67, false, null, null, new Object[0]);
        if (objOnEvent instanceof Boolean) {
            return ((Boolean) objOnEvent).booleanValue();
        }
        return false;
    }

    public static boolean getDebugMode() {
        return JConstants.DEBUG_MODE;
    }

    public static long getStartId(Context context) {
        return JCoreInternalHelper.getInstance().getStartId();
    }

    public static void init(Context context) {
        init(context, null);
    }

    public static void initCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 70, true, null, null, new Object[0]);
    }

    public static boolean isInternal() {
        return false;
    }

    public static boolean isTestEnv() {
        return JConstants.isTestEnv();
    }

    public static Object onEvent(Context context, String str, int i9, String str2, Bundle bundle, Object... objArr) {
        boolean z8;
        switch (i9) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 18:
            case 19:
            case 20:
            case 21:
            case 25:
            case 26:
            case 32:
            case 33:
            case 34:
            case 42:
            case 43:
            case 45:
            case 46:
            case 47:
            case 49:
            case 53:
            case 58:
            case 60:
            case 63:
            case 64:
            case 67:
            case 68:
            case 69:
            case 75:
            case 76:
            case 77:
            case 78:
            case 82:
            case 83:
            case 90:
            case 91:
            case 92:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 108:
            case 109:
            case 110:
            case 119:
            case 120:
            case 121:
            case 123:
            case 130:
            case GattError.GATT_ERROR /* 133 */:
            case 136:
            case 138:
                z8 = false;
                break;
            default:
                z8 = true;
                break;
        }
        return onEvent(context, str, i9, z8, str2, bundle, objArr);
    }

    public static void reRegister(Context context) {
        try {
            JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "tcp_a29", null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void register(Context context, String str) {
        try {
            register(context, str, null);
        } catch (Throwable unused) {
        }
    }

    public static void removeActivityLifeCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        a.b(activityLifecycleCallbacks);
    }

    public static void reportWakedData(Context context, Bundle bundle, int i9) {
        if (context == null) {
            f.j(TAG, "[reportWakedData] context was null");
            return;
        }
        if (bundle == null) {
            f.j(TAG, "[reportWakedData] bundle was null");
            return;
        }
        int i10 = bundle.getInt("type", -1);
        if (i10 != -1) {
            i9 = i10;
        }
        if (i9 != 1 && i9 != 2 && i9 != 4 && i9 != 8 && i9 != 16 && i9 != 32) {
            f.j(TAG, "[reportWakedData] wrong type:" + i9);
        } else {
            bundle.putInt("type", i9);
            f.c(TAG, "action - reportWakedData" + bundle.toString());
            onEvent(context, null, 74, null, bundle, new Object[0]);
        }
    }

    public static void requestPermission(Context context) {
        String str;
        if (context == null) {
            str = "[requestPermission] context was null";
        } else if (!(context instanceof Activity)) {
            str = "[requestPermission] context must instanceof Activity";
        } else {
            if (context.getApplicationInfo().targetSdkVersion >= 23) {
                if (context.getApplicationInfo().targetSdkVersion >= 23) {
                    try {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                        linkedList.add("android.permission.READ_EXTERNAL_STORAGE");
                        linkedList.add("android.permission.ACCESS_FINE_LOCATION");
                        linkedList.add("android.permission.READ_PHONE_STATE");
                        if (JConstants.isAndroidQ(context, false, "will request background location permission")) {
                            linkedList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                        }
                        List<String> listA = q.a(context, linkedList);
                        if (listA != null && !listA.isEmpty()) {
                            f.a(TAG, "lackPermissions:" + listA);
                            Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, listA.toArray(new String[listA.size()]), 1);
                            return;
                        }
                        return;
                    } catch (Exception e9) {
                        f.j(TAG, "#unexcepted - requestPermission e:" + e9);
                        return;
                    }
                }
                return;
            }
            str = "[requestPermission] app targetSdkVersion<23";
        }
        f.j(TAG, str);
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        JConstants.jAnalyticsAction = jAnalyticsAction;
    }

    public static void setDebugMode(boolean z8) {
        JConstants.DEBUG_MODE = z8;
    }

    public static void setLBSEnable(Context context, boolean z8) {
        f.c(TAG, "action - setLBSEnable-control:" + z8);
        f.j(TAG, "Since the SDK has provided a new geographical location control interface, part of the control logic has become invalid, and this interface will be gradually deprecated. Please adapt to the new interface as soon as possible.");
        if (!z8) {
            try {
                cn.jiguang.e.f.a(context, (d<?>[]) new d[]{d.aq().a(Boolean.FALSE)});
            } catch (Throwable unused) {
            }
        }
        onEvent(context, null, 27, null, null, Boolean.valueOf(z8));
    }

    public static void setSDKConfigs(Context context, Bundle bundle) {
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 55, true, null, bundle, new Object[0]);
    }

    public static void setStartId(Context context) {
        JCoreInternalHelper.getInstance().setStartId(context);
    }

    public static void stopCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 71, true, null, null, new Object[0]);
    }

    public static void unRegister(Context context) {
        JConstants.isCallInit.set(true);
        a.a(context);
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "tcp_a23", null, new Object[0]);
    }

    public static void init(Context context, int i9, Bundle bundle) {
        Context appContext = JConstants.getAppContext(context);
        if (appContext == null) {
            return;
        }
        if (!b.a()) {
            f.l(TAG, "user don't auth, so return init");
            return;
        }
        JConstants.isCallInit.set(true);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putLong("jg_init_start_time", System.currentTimeMillis());
        f.d(TAG, "init cmd:" + i9);
        AtomicBoolean atomicBoolean = isInited;
        if (atomicBoolean.get()) {
            if (96 == i9) {
                JCoreInternalHelper.getInstance().onEvent(appContext, JConstants.SDK_TYPE, 10, true, "tcp_a1", bundle2, new Object[0]);
                return;
            }
            return;
        }
        atomicBoolean.set(true);
        try {
            if (h.a(appContext)) {
                atomicBoolean.set(false);
                JConstants.isCallInit.set(false);
            } else {
                a.a(appContext);
                JCoreInternalHelper.getInstance().onEvent(appContext, JConstants.SDK_TYPE, 10, true, "tcp_a1", bundle2, new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }

    public static Object onEvent(Context context, String str, int i9, boolean z8, String str2, Bundle bundle, Object... objArr) {
        if (96 == i9) {
            try {
                boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                f.d(TAG, "saveAuth：" + zBooleanValue);
                b.a(zBooleanValue, true);
            } catch (Throwable unused) {
            }
        }
        if (!cn.jiguang.c.b.f9575a.contains(Integer.valueOf(i9))) {
            init(context, i9, bundle);
        }
        return JCoreInternalHelper.getInstance().onEvent(context, str, i9, z8, str2, bundle, objArr);
    }

    public static void register(Context context, String str, Bundle bundle) {
        try {
            String strB = cn.jiguang.w.a.b(context);
            if (TextUtils.isEmpty(strB) || strB.equals(str)) {
                JConstants.APP_KEY = str;
            } else {
                f.j(TAG, "[register] not same appkey with manifest,please check it");
            }
            f.e(TAG, "[register]  appkey =" + JConstants.APP_KEY + " originKep=" + str);
            if (h.a(context)) {
                JConstants.isCallInit.set(false);
                return;
            }
            JConstants.isCallInit.set(true);
            a.a(context);
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            bundle2.putString("appkey", str);
            bundle2.putLong("jg_init_start_time", System.currentTimeMillis());
            JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "a5", bundle2, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void init(Context context, Bundle bundle) {
        init(context, DEFAULT_CMD, bundle);
    }

    public static void changeLiveStatus(boolean z8) {
    }
}
