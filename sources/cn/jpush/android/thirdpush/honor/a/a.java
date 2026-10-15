package cn.jpush.android.thirdpush.honor.a;

import android.content.Context;
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
import com.hihonor.push.sdk.HonorMessageService;
import com.hihonor.push.sdk.HonorPushCallback;
import com.hihonor.push.sdk.HonorPushClient;
import defpackage.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11573a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f11574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f11575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Bundle f11576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f11577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Bundle f11578f;

    /* JADX INFO: renamed from: cn.jpush.android.thirdpush.honor.a.a$a, reason: collision with other inner class name */
    public class C0146a implements HonorPushCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f11579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f11580b;

        public C0146a(boolean z8, Context context) {
            this.f11579a = z8;
            this.f11580b = context;
        }

        @Override // com.hihonor.push.sdk.HonorPushCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            Logger.ki("HonorPushHelper", "get honor token success:" + str);
            Logger.ki("HonorPushHelper", "isNeedReport:" + this.f11579a);
            if (this.f11579a && !TextUtils.isEmpty(str)) {
                a.d(this.f11580b, str);
            }
            a.c(this.f11580b, "0");
        }

        @Override // com.hihonor.push.sdk.HonorPushCallback
        public void onFailure(int i9, String str) {
            Logger.ki("HonorPushHelper", "get honor token onFailure code=" + i9 + " msg=" + str);
            a.c(this.f11580b, String.valueOf(i9));
        }
    }

    private static boolean b(Context context) {
        try {
            ServiceInfo serviceInfoA = a(context, context.getPackageName(), HonorMessageService.class);
            if (serviceInfoA == null) {
                Logger.ww("HonorPushHelper", "AndroidManifest.xml missing service extends honor's PushService");
                return false;
            }
            Logger.dd("HonorPushHelper", "found service:" + serviceInfoA.name);
            return true;
        } catch (Throwable th) {
            f.p("checkService error:", "HonorPushHelper", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        a(context, str, "");
    }

    public static byte d(Context context) {
        return (byte) 7;
    }

    public static String e(Context context) {
        if (!TextUtils.isEmpty(f11577e)) {
            return f11577e;
        }
        try {
            f11577e = b(context, "com.hihonor.push.sdk_version");
        } catch (Throwable th) {
            f.p("get honor version from meta error:", "HonorPushHelper", th);
        }
        return f11577e;
    }

    public static int f(Context context) {
        if (i(context)) {
            return ((Integer) Sp.get(context, Key.VoipStatus((byte) 7))).intValue();
        }
        return 2;
    }

    public static synchronized void g(Context context) {
        if (f11574b) {
            return;
        }
        if (context == null) {
            Logger.d("HonorPushHelper", "context is null");
            return;
        }
        String str = "";
        try {
            str = Build.MANUFACTURER;
        } catch (Throwable th) {
            Logger.ww("HonorPushHelper", "get manufacturer error:" + th);
        }
        if (a(context)) {
            f11575c = true;
            if (!MTPushConstants.Manufacturer.HONOR.equalsIgnoreCase(str)) {
                a(context, JThirdPlatFormInterface.KEY_VENDOR_PUSH_MANUFACTURE_UNKNOWN, "hr: " + str);
            }
        }
        Logger.kd("HonorPushHelper", (f11575c ? "support " : "not support ").concat(MTPushConstants.Manufacturer.HONOR));
        f11574b = true;
    }

    public static boolean h(Context context) {
        String appKey = JCoreHelper.getAppKey(context);
        if (TextUtils.isEmpty(appKey)) {
            Logger.ii("HonorPushHelper", "jpush appkey is empty,need not clear plugin rid");
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

    public static boolean i(Context context) {
        g(context);
        return f11575c;
    }

    private static String j(Context context) {
        String strB;
        String str = "";
        try {
            Bundle bundle = f11576d;
            if (bundle != null) {
                String string = bundle.getString("HONOR_APPID");
                f11573a = string;
                if (!TextUtils.isEmpty(string)) {
                    if (f11573a.startsWith("appid=")) {
                        f11573a = "".replace("appid=", "");
                    }
                    Logger.d("HonorPushHelper", "use config data, appid: " + f11573a);
                    k(context);
                    return f11573a;
                }
            }
            strB = b(context, "com.hihonor.push.app_id");
            try {
                if (!TextUtils.isEmpty(strB) && strB.startsWith("appid=")) {
                    strB = strB.replace("appid=", "");
                }
            } catch (Throwable th) {
                str = strB;
                th = th;
                f.p("get honor appId from meta error:", "HonorPushHelper", th);
                strB = str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        Logger.kd("HonorPushHelper", "get honor appId from meta - com.hihonor.push.app_id value:" + strB);
        return strB;
    }

    private static void k(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (TextUtils.isEmpty(f11573a) || (sharedPreferences = context.getSharedPreferences("com.honor.push_preferences.appconfig_v1", 0)) == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putString("hihonor_app_id", f11573a);
        editorEdit.apply();
        Logger.d("HonorPushHelper", "update appkey config success");
    }

    private static boolean a(Context context) {
        try {
            boolean zCheckSupportHonorPush = HonorPushClient.getInstance().checkSupportHonorPush(context);
            Logger.d("HonorPushHelper", "isSupport=" + zCheckSupportHonorPush);
            if (zCheckSupportHonorPush) {
                return b(context);
            }
            return false;
        } catch (Throwable th) {
            Logger.ee("HonorPushHelper", "Please check *.jar files your project depends on, can't load class - com.hihonor.push.sdk.HonorInstanceId \nerror:" + th);
            throw new RuntimeException("Please check *.jar files your project depends on.", th);
        }
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(f11573a)) {
            return f11573a;
        }
        if (context == null) {
            Logger.ww("HonorPushHelper", "getAppID error context was null");
            return null;
        }
        String strJ = j(context);
        f11573a = strJ;
        return strJ;
    }

    public static void d(Context context, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("token", str);
            bundle.putByte("platform", (byte) 7);
            bundle.putInt(JThirdPlatFormInterface.KEY_VOIP_STATUS, f(context));
            JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_RREGISTER_TTOKEN, bundle);
        } catch (Throwable th) {
            W5.f.r(th, new StringBuilder("sendToken error:"), "HonorPushHelper");
        }
    }

    private static ServiceInfo a(Context context, String str, Class cls) {
        ServiceInfo[] serviceInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("HonorPushHelper", "Action - hasComponent, invalid param, context:" + context + ",packageName:" + str + ",cls:" + cls);
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
            f.p("getReceiver error:", "HonorPushHelper", th);
        }
    }

    private static String b(Context context, String str) {
        try {
            if (f11578f == null) {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null) {
                    Logger.w("HonorPushHelper", "metadata: Can not get metaData from ApplicationInfo");
                    return null;
                }
                f11578f = applicationInfo.metaData;
            }
            Bundle bundle = f11578f;
            if (bundle == null) {
                Logger.w("HonorPushHelper", "NO meta data defined in manifest.");
                return "";
            }
            Object obj = bundle.get(str);
            if (obj != null) {
                return String.valueOf(obj);
            }
            return "";
        } catch (Throwable th) {
            f.p("get  meta error:", "HonorPushHelper", th);
            return "";
        }
    }

    public static void a(Context context, Bundle bundle) {
        try {
            f11576d = bundle;
            g(context);
            if (TextUtils.isEmpty(c(context))) {
                c(context, JThirdPlatFormInterface.KEY_VENDOR_PUSH_APP_KEY_MISS);
                Logger.ke("HonorPushHelper", "honor sdk  appid was empty,please check your manifest config");
            } else {
                HonorPushClient.getInstance().init(context, false);
            }
        } catch (Throwable th) {
            c(context, JThirdPlatFormInterface.KEY_VENDOR_PUSH_INIT_UNKNOWN_EXCEPTION);
            Logger.e("HonorPushHelper", "#unexpected - register error:", th);
        }
    }

    public static String a(Context context, boolean z8) {
        try {
            if (context == null) {
                Logger.d("HonorPushHelper", "context is null");
                return null;
            }
            if (TextUtils.isEmpty(c(context))) {
                return null;
            }
            HonorPushClient.getInstance().getPushToken(new C0146a(z8, context));
            return null;
        } catch (Throwable th) {
            Logger.kw("HonorPushHelper", "get token error:" + th.getMessage());
        }
    }

    private static void a(Context context, String str, String str2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("code", str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, String.valueOf(7));
            jSONObject.put(JThirdPlatFormInterface.KEY_PLUGIN_SDK_VER, "6.1.0");
            jSONObject.put(JThirdPlatFormInterface.KEY_VENDOR_SDK_VER, e(context));
            jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, str2);
            bundle.putString(JThirdPlatFormInterface.KEY_EXTRA, jSONObject.toString());
            JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_SEND_EXCEPTION, bundle);
        } catch (Throwable unused) {
        }
    }
}
