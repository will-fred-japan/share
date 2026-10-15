package cn.jpush.android.thirdpush.huawei.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.hihonor.push.sdk.HonorPushClient;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.RemoteMessage;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.f;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11581a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f11582b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f11583c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Bundle f11584d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f11585e = "[^0-9]";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f11586f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Bundle f11587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Boolean f11588h;

    /* JADX INFO: renamed from: cn.jpush.android.thirdpush.huawei.a.a$a, reason: collision with other inner class name */
    public static class C0147a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Context f11589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11590d;

        public C0147a(Context context, boolean z8) {
            this.f11589c = context;
            this.f11591a = "TokenTask";
            this.f11590d = z8;
        }

        @Override // cn.jpush.android.thirdpush.huawei.a.b
        public void a() {
            try {
                Context context = this.f11589c;
                if (context == null) {
                    Logger.d("HWPushHelper", "context is null");
                    return;
                }
                String strC = a.c(context);
                Logger.ki("HWPushHelper", "get huawei appId:" + strC);
                String token = HmsInstanceId.getInstance(this.f11589c).getToken(strC, HmsMessaging.DEFAULT_TOKEN_SCOPE);
                Logger.ki("HWPushHelper", "get huawei token:" + token);
                Logger.ki("HWPushHelper", "isNeedReport:" + this.f11590d);
                a.c(this.f11589c, "0");
                if (!this.f11590d || TextUtils.isEmpty(token)) {
                    return;
                }
                a.d(this.f11589c, token);
            } catch (Throwable th) {
                String strB = a.b(th);
                if (!TextUtils.isEmpty(strB)) {
                    a.c(this.f11589c, strB);
                }
                Logger.kw("HWPushHelper", "get huawei token error:" + th.getMessage());
            }
        }
    }

    private static String b(Context context, String str) {
        try {
            if (f11587g == null) {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null) {
                    Logger.w("HWPushHelper", "metadata: Can not get metaData from ApplicationInfo");
                    return null;
                }
                f11587g = applicationInfo.metaData;
            }
            Bundle bundle = f11587g;
            if (bundle != null) {
                Object obj = bundle.get(str);
                return obj != null ? String.valueOf(obj) : "";
            }
            Logger.w("HWPushHelper", "NO meta data defined in manifest.");
            return "";
        } catch (Throwable th) {
            f.p("get  meta error:", "HWPushHelper", th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        a(context, str, "");
    }

    public static void d(Context context, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("token", str);
            bundle.putByte("platform", (byte) 2);
            bundle.putInt(JThirdPlatFormInterface.KEY_VOIP_STATUS, g(context));
            JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_RREGISTER_TTOKEN, bundle);
        } catch (Throwable th) {
            W5.f.r(th, new StringBuilder("sendToken error:"), "HWPushHelper");
        }
    }

    public static byte e(Context context) {
        return (byte) 2;
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(f11586f)) {
            return f11586f;
        }
        try {
            f11586f = String.valueOf(b(context, "com.huawei.hms.client.service.name:push")).split(Constants.COLON_SEPARATOR)[1];
        } catch (Throwable th) {
            f.p("get huawei version from meta error:", "HWPushHelper", th);
        }
        return f11586f;
    }

    public static int g(Context context) {
        return !j(context) ? 1 : 2;
    }

    public static synchronized void h(Context context) {
        if (f11582b) {
            return;
        }
        if (context == null) {
            Logger.d("HWPushHelper", "context is null");
            return;
        }
        f11583c = k(context);
        StringBuilder sb = new StringBuilder();
        sb.append(f11583c ? "support " : "not support ");
        sb.append(MTPushConstants.Manufacturer.HUAWEI);
        Logger.kd("HWPushHelper", sb.toString());
        f11582b = true;
    }

    public static boolean i(Context context) {
        String appKey = JCoreHelper.getAppKey(context);
        if (TextUtils.isEmpty(appKey)) {
            Logger.ii("HWPushHelper", "jpush appkey is empty,need not clear plugin rid");
            return false;
        }
        String str = (String) Sp.get(context, Key.ThirdPush_ClearFlag());
        StringBuilder sbB = p171w.a.b(appKey);
        sbB.append(JCoreHelper.getJCoreSDKVersionInt());
        sbB.append(JCoreHelper.getJPushSDKVersionInt());
        String hash = JThirdPlatFormInterface.toHash(sbB.toString());
        if (TextUtils.isEmpty(str)) {
            Sp.set(context, Key.ThirdPush_ClearFlag().set(hash));
            return false;
        }
        if (TextUtils.isEmpty(hash)) {
            return true;
        }
        if (TextUtils.equals(str, hash)) {
            return false;
        }
        Sp.set(context, Key.ThirdPush_ClearFlag().set(hash));
        return true;
    }

    public static boolean j(Context context) {
        h(context);
        return f11583c;
    }

    private static boolean k(Context context) {
        String lowerCase;
        try {
            lowerCase = Build.MANUFACTURER;
            try {
                lowerCase = lowerCase.toLowerCase();
            } catch (Throwable th) {
                th = th;
                f.p("get manufacturer error:", "HWPushHelper", th);
            }
        } catch (Throwable th2) {
            th = th2;
            lowerCase = "";
        }
        if (!TextUtils.isEmpty(lowerCase)) {
            if (MTPushConstants.Manufacturer.HUAWEI.equals(lowerCase) || (MTPushConstants.Manufacturer.HONOR.equals(lowerCase) && !l(context) && b())) {
                boolean z8 = a() && a(context) && b(context);
                if (z8) {
                    AutoInitHelper.setAutoInitEnabled(context, false);
                }
                return z8;
            }
            if (!TextUtils.equals(lowerCase, MTPushConstants.Manufacturer.MEIZU) && !TextUtils.equals(lowerCase, MTPushConstants.Manufacturer.HONOR) && !TextUtils.equals(lowerCase, MTPushConstants.Manufacturer.OPPO) && !TextUtils.equals(lowerCase, MTPushConstants.Manufacturer.REALME) && !TextUtils.equals(lowerCase, MTPushConstants.Manufacturer.ONEPLUS) && !TextUtils.equals(lowerCase, MTPushConstants.Manufacturer.VIVO) && !TextUtils.equals(lowerCase, MTPushConstants.Manufacturer.XIAOMI) && !TextUtils.equals(lowerCase, MTPushConstants.Manufacturer.BLACKSHARK) && !l(context) && a(context) && b(context)) {
                AutoInitHelper.setAutoInitEnabled(context, false);
                a(context, JThirdPlatFormInterface.KEY_VENDOR_PUSH_MANUFACTURE_UNKNOWN, "hw: " + lowerCase);
                return true;
            }
        }
        return false;
    }

    private static boolean l(Context context) {
        try {
            HonorPushClient honorPushClient = HonorPushClient.f14424a;
            boolean zBooleanValue = ((Boolean) HonorPushClient.class.getMethod("checkSupportHonorPush", Context.class).invoke(HonorPushClient.class.getMethod("getInstance", null).invoke(null, null), context)).booleanValue();
            Logger.d("HWPushHelper", "isSupportHonorPush =" + zBooleanValue);
            return zBooleanValue;
        } catch (Throwable th) {
            Logger.e("HWPushHelper", " isSupportHonorPush error:" + th);
            return false;
        }
    }

    private static String m(Context context) {
        String string = "";
        try {
            string = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
            Logger.kd("HWPushHelper", "get huawei appId from json:" + string);
            return string;
        } catch (Throwable th) {
            Logger.kw("HWPushHelper", "get huawei appId from json error:" + th);
            return string;
        }
    }

    private static String n(Context context) {
        String strB;
        String str = "";
        try {
            strB = b(context, Constants.HUAWEI_HMS_CLIENT_APPID);
            try {
                if (!TextUtils.isEmpty(strB) && strB.startsWith("appid=")) {
                    strB = strB.replace("appid=", "");
                }
            } catch (Throwable th) {
                th = th;
                str = strB;
                f.p("get huawei appId from meta error:", "HWPushHelper", th);
                strB = str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        Logger.kd("HWPushHelper", "get huawei appId from meta - com.huawei.hms.client.appid value:" + strB);
        return strB;
    }

    private static void o(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (TextUtils.isEmpty(f11581a) || (sharedPreferences = context.getSharedPreferences("push_config_huawei", 0)) == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putString(Constants.HUAWEI_HMS_CLIENT_APPID, f11581a);
        editorEdit.apply();
        Logger.d("HWPushHelper", "update appkey config success");
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(f11581a)) {
            return f11581a;
        }
        if (context == null) {
            Logger.ww("HWPushHelper", "getAppID error context was null");
            return null;
        }
        Bundle bundle = f11584d;
        if (bundle != null) {
            f11581a = bundle.getString("HW_APPID");
            Logger.d("HWPushHelper", "use config data, app_id: " + f11581a);
            o(context);
        }
        if (TextUtils.isEmpty(f11581a)) {
            String strM = m(context);
            f11581a = strM;
            if (TextUtils.isEmpty(strM)) {
                f11581a = n(context);
            }
        }
        return f11581a;
    }

    private static void a(Context context, String str, String str2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("code", str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, String.valueOf(2));
            jSONObject.put(JThirdPlatFormInterface.KEY_PLUGIN_SDK_VER, "6.1.0");
            jSONObject.put(JThirdPlatFormInterface.KEY_VENDOR_SDK_VER, f(context));
            jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, str2);
            bundle.putString(JThirdPlatFormInterface.KEY_EXTRA, jSONObject.toString());
            JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_SEND_EXCEPTION, bundle);
        } catch (Throwable unused) {
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            Logger.d("HWPushHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            StringBuilder sbI = f.i(" get ", str, "wrong error:");
            sbI.append(th.getMessage());
            Logger.e("HWPushHelper", sbI.toString());
            return "";
        }
    }

    private static synchronized boolean d(Context context) {
        Boolean bool = f11588h;
        if (bool != null) {
            return bool.booleanValue();
        }
        f11588h = Boolean.TRUE;
        if ("false".equals(b(context, "hw_check_app_installed"))) {
            f11588h = Boolean.FALSE;
        }
        return f11588h.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Throwable th) {
        try {
            return Pattern.compile(f11585e).matcher(th.getMessage()).replaceAll("").trim();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean b() {
        String strA = a("ro.build.version.emui");
        Logger.kd("HWPushHelper", "isEmotionOs name:" + strA);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String lowerCase = strA.toLowerCase();
        if (!lowerCase.contains("magicui") && !lowerCase.contains("magicos")) {
            return false;
        }
        Logger.kd("HWPushHelper", "isEmotionOs true");
        return true;
    }

    private static boolean b(Context context) {
        try {
            ServiceInfo serviceInfoA = a(context, context.getPackageName(), HmsMessageService.class);
            if (serviceInfoA != null) {
                Logger.dd("HWPushHelper", "found service:" + serviceInfoA.name);
                return true;
            }
            Logger.ww("HWPushHelper", "AndroidManifest.xml missing service extends huawei's PushService");
            return false;
        } catch (Throwable th) {
            f.p("checkService error:", "HWPushHelper", th);
            return false;
        }
    }

    private static ServiceInfo a(Context context, String str, Class cls) {
        ServiceInfo[] serviceInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("HWPushHelper", "Action - hasComponent, invalid param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            PackageInfo packageInfo = JCoreHelper.getPackageInfo(context, str, 4);
            if (packageInfo != null && (serviceInfoArr = packageInfo.services) != null && serviceInfoArr.length != 0) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    try {
                        if (cls.isAssignableFrom(Class.forName(serviceInfo.name, false, cls.getClassLoader())) && serviceInfo.enabled) {
                            return serviceInfo;
                        }
                    } catch (Throwable unused) {
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            f.p("getReceiver error:", "HWPushHelper", th);
        }
    }

    public static void a(Context context, Bundle bundle) {
        f11584d = bundle;
        h(context);
    }

    public static String a(Context context, boolean z8) {
        try {
            if (context == null) {
                Logger.d("HWPushHelper", "context is null");
                return null;
            }
            if (JCoreHelper.getJCoreSDKVersionInt() >= 238 && JCoreHelper.getJPushSDKVersionInt() >= 366) {
                JCoreHelper.futureExecutor(context.getApplicationContext(), new C0147a(context, z8));
            } else {
                new Thread(new C0147a(context, z8)).start();
            }
            return null;
        } catch (Throwable th) {
            W5.f.r(th, new StringBuilder("get token error:"), "HWPushHelper");
        }
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            Logger.i("HWPushHelper", "get EMUI version is:" + str);
            return !TextUtils.isEmpty(str) && a(str.toLowerCase().replace("emotionui_", ""), "4.1") >= 0;
        } catch (Throwable th) {
            Logger.e("HWPushHelper", " getEMUIVersion error:" + th);
        }
        return false;
    }

    private static boolean a(Context context) {
        try {
            if (d(context)) {
                return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context) == 0;
            }
            Logger.ww("HWPushHelper", "checkAppInstalled is false");
            return true;
        } catch (Throwable th) {
            Logger.ee("HWPushHelper", "Please check *.jar files your project depends on, can't load class - com.huawei.hms.api.HuaweiApiAvailability \nerror:" + th);
            throw new RuntimeException("Please check *.jar files your project depends on.", th);
        }
    }

    private static int a(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        try {
            String[] strArrSplit = str.split("[._]");
            String[] strArrSplit2 = str2.split("[._]");
            if (strArrSplit.length > strArrSplit2.length) {
                strArrSplit2 = (String[]) Arrays.copyOf(strArrSplit2, strArrSplit.length);
            } else if (strArrSplit.length < strArrSplit2.length) {
                strArrSplit = (String[]) Arrays.copyOf(strArrSplit, strArrSplit2.length);
            }
            for (int i9 = 0; i9 < strArrSplit.length; i9++) {
                long j = (TextUtils.isEmpty(strArrSplit[i9]) ? 0L : Long.parseLong(strArrSplit[i9])) - (TextUtils.isEmpty(strArrSplit2[i9]) ? 0L : Long.parseLong(strArrSplit2[i9]));
                if (j > 0) {
                    return 1;
                }
                if (j < 0) {
                    return -1;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return str.compareTo(str2);
        }
    }

    public static void a(Context context, RemoteMessage.Notification notification, String str) {
        try {
            if (notification == null) {
                Logger.d("HWPushHelper", "notification is null");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String intentUri = notification.getIntentUri();
            if (TextUtils.isEmpty(intentUri)) {
                Logger.ww("HWPushHelper", "intentUri is null");
                return;
            }
            Logger.dd("HWPushHelper", "intentUri is :" + intentUri);
            Intent uri = Intent.parseUri(intentUri, 0);
            Intent intent = new Intent(uri);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            uri.setSelector(null);
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                Logger.ww("HWPushHelper", "content is null");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putByte("platform", (byte) 2);
            bundle.putInt(JThirdPlatFormInterface.KEY_NOTI_ID, notification.getNotifyId());
            bundle.putString("data", dataString);
            JThirdPlatFormInterface.doAction(context, str, bundle);
        } catch (Throwable th) {
            W5.f.q(th, new StringBuilder("doHWPushMessage error:"), "HWPushHelper");
        }
    }
}
