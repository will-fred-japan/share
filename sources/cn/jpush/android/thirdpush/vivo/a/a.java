package cn.jpush.android.thirdpush.vivo.a;

import W5.f;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.huawei.hms.framework.common.BundleUtil;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f11607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f11608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f11609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Bundle f11610e;

    public class b implements IPushActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11612a;

        public b(Context context) {
            this.f11612a = context;
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i9) {
            Logger.kd("VivoPushHelper", "register state:" + i9);
            if (a.k(this.f11612a)) {
                a.a(this.f11612a, String.valueOf(i9));
            }
        }
    }

    private static boolean b(Context context) {
        try {
            if (PushClient.getInstance(context).isSupport()) {
                return c(context);
            }
            Logger.kd("VivoPushHelper", "should not Use Vivo Push");
            return false;
        } catch (Throwable th) {
            Logger.ke("VivoPushHelper", "Please check *.jar files your project depends on, can't load class - com.vivo.push.PushClient \nerror:" + th);
            throw new RuntimeException("Please check *.jar files your project depends on.", th);
        }
    }

    private static boolean c(Context context) {
        ActivityInfo activityInfoA = a(context, context.getPackageName(), OpenClientPushMessageReceiver.class);
        if (activityInfoA == null) {
            Logger.ww("VivoPushHelper", "AndroidManifest.xml missing receiver extends vivo's OpenClientPushMessageReceiver");
            return false;
        }
        Logger.d("VivoPushHelper", "found receiver:" + activityInfoA.name);
        return true;
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(f11609d)) {
            n(context);
        }
        return f11609d;
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(f11608c)) {
            n(context);
        }
        return f11608c;
    }

    public static byte f(Context context) {
        return (byte) 5;
    }

    public static String g(Context context) {
        try {
            PushClient.getInstance(context).getRegId(new C0148a(context.getApplicationContext()));
            Logger.kd("VivoPushHelper", "VIVO regId:null");
            return null;
        } catch (Throwable th) {
            Logger.kw("VivoPushHelper", "get Token error#" + th);
            return null;
        }
    }

    public static String h(Context context) {
        try {
            return PushClient.getInstance(context).getVersion() + BundleUtil.UNDERLINE_TAG + PushClient.getInstance(context).getVersion();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int i(Context context) {
        if (!m(context)) {
            return 1;
        }
        try {
            boolean zIsPushSupport = PushClient.getInstance(context).isPushSupport(MiPushSdk.FLAG_SUPPORT_CALLKIT);
            Logger.kd("VivoPushHelper", "vivo VoIP support status: " + zIsPushSupport);
            return zIsPushSupport ? 2 : 1;
        } catch (Throwable th) {
            f.r(th, new StringBuilder("getVoipSupportStatus error: "), "VivoPushHelper");
            return 0;
        }
    }

    public static void j(Context context) {
        String str;
        if (f11606a) {
            return;
        }
        if (context == null) {
            Logger.d("VivoPushHelper", "context is null");
            return;
        }
        try {
            str = Build.MANUFACTURER;
        } catch (Throwable th) {
            defpackage.f.p("get MANUFACTURER failed - error:", "VivoPushHelper", th);
            str = "";
        }
        if ("VIVO".equalsIgnoreCase(str) && b(context)) {
            f11607b = true;
        }
        Logger.kd("VivoPushHelper", (f11607b ? "support " : "not support ").concat("VIVO"));
        f11606a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k(Context context) {
        try {
            Class<?> cls = Class.forName("cn.jpush.android.util.AndroidUtil");
            return TextUtils.equals((String) cls.getDeclaredMethod("getCurProcessName", Context.class).invoke(cls, context), context.getPackageName());
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean l(Context context) {
        String strE = e(context);
        String strD = d(context);
        if (TextUtils.isEmpty(strD) || TextUtils.isEmpty(strE)) {
            Logger.ii("VivoPushHelper", "VIVOappkey or appid is empty,need not clear plugin rid");
            return false;
        }
        String appKey = JCoreHelper.getAppKey(context);
        if (TextUtils.isEmpty(appKey)) {
            Logger.ii("VivoPushHelper", "jpush appkey is empty,need not clear plugin rid");
            return false;
        }
        String str = (String) Sp.get(context, Key.ThirdPush_ClearFlag());
        String hash = JThirdPlatFormInterface.toHash(strE + strD + appKey + JCoreHelper.getJCoreSDKVersionInt() + JCoreHelper.getJPushSDKVersionInt());
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

    public static boolean m(Context context) {
        j(context);
        return f11607b;
    }

    private static void n(Context context) {
        if (context == null) {
            Logger.w("VivoPushHelper", "context was null");
            return;
        }
        try {
            Bundle bundle = f11610e;
            if (bundle != null) {
                f11608c = bundle.getString("VIVO_APPKEY");
                f11609d = f11610e.getString("VIVO_APPID");
                if (!TextUtils.isEmpty(f11608c) && !TextUtils.isEmpty(f11609d)) {
                    Logger.d("VivoPushHelper", "use config data, appkey: " + f11608c + ", appid: " + f11609d);
                    o(context);
                    return;
                }
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                Logger.w("VivoPushHelper", "metadata: Can not get metaData from ApplicationInfo");
                return;
            }
            Bundle bundle2 = applicationInfo.metaData;
            if (bundle2 == null) {
                Logger.d("VivoPushHelper", "NO meta data defined in manifest.");
                return;
            }
            f11608c = bundle2.getString("com.vivo.push.api_key");
            Object obj = bundle2.get("com.vivo.push.app_id");
            f11609d = obj == null ? null : String.valueOf(obj);
            if (TextUtils.isEmpty(f11608c)) {
                Logger.w("VivoPushHelper", "metadata: com.vivo.push.api_key - not defined in manifest");
                f11608c = null;
            }
            if (TextUtils.isEmpty(f11609d)) {
                Logger.w("VivoPushHelper", "metadata: com.vivo.push.app_id - not defined in manifest");
                f11609d = null;
            }
            Logger.kd("VivoPushHelper", "com.vivo.push.api_key value:" + f11608c);
            Logger.kd("VivoPushHelper", "com.vivo.push.app_id value:" + f11609d);
        } catch (Throwable th) {
            defpackage.f.o("load plugin sdk config info error:", "VivoPushHelper", th);
        }
    }

    private static void o(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (TextUtils.isEmpty(f11608c) || TextUtils.isEmpty(f11609d) || (sharedPreferences = context.getSharedPreferences("com.vivo.push_preferences.appconfig_v1", 0)) == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putString("APP_APIKEY", f11608c);
        editorEdit.putString("APP_APPID", f11609d);
        editorEdit.putString("com.vivo.push.api_key", f11608c);
        editorEdit.putString("com.vivo.push.app_id", f11609d);
        editorEdit.putString("api_key", f11608c);
        editorEdit.putString("app_id", f11609d);
        editorEdit.commit();
        Logger.d("VivoPushHelper", "update appkey config success");
    }

    private static ActivityInfo a(Context context, String str, Class cls) {
        ActivityInfo[] activityInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("VivoPushHelper", "Action - hasComponent, invalid param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            PackageInfo packageInfo = JCoreHelper.getPackageInfo(context, str, 2);
            if (packageInfo != null && (activityInfoArr = packageInfo.receivers) != null && activityInfoArr.length != 0) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    try {
                        if (cls.isAssignableFrom(Class.forName(activityInfo.name, false, cls.getClassLoader())) && activityInfo.enabled) {
                            return activityInfo;
                        }
                    } catch (Throwable unused) {
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            defpackage.f.p("getReceiver error:", "VivoPushHelper", th);
        }
    }

    /* JADX INFO: renamed from: cn.jpush.android.thirdpush.vivo.a.a$a, reason: collision with other inner class name */
    public class C0148a implements IPushQueryActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11611a;

        public C0148a(Context context) {
            this.f11611a = context;
        }

        @Override // com.vivo.push.listener.IPushRequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            a.a(this.f11611a, "0");
            Logger.kd("VivoPushHelper", "getRegId Vivo success token:" + str);
            a.a(str, this.f11611a);
        }

        @Override // com.vivo.push.listener.IPushRequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onFail(Integer num) {
            a.a(this.f11611a, num + "");
            StringBuilder sb = new StringBuilder("getRegId Vivo failed code=");
            sb.append(num);
            Logger.kd("VivoPushHelper", sb.toString());
        }
    }

    public static void a(Context context, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("code", str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, String.valueOf(5));
            jSONObject.put(JThirdPlatFormInterface.KEY_PLUGIN_SDK_VER, "6.1.0");
            jSONObject.put(JThirdPlatFormInterface.KEY_VENDOR_SDK_VER, h(context));
            bundle.putString(JThirdPlatFormInterface.KEY_EXTRA, jSONObject.toString());
            JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_SEND_EXCEPTION, bundle);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, Bundle bundle) {
        j(context);
        try {
            f11610e = bundle;
            n(context);
            String strE = e(context);
            String strD = d(context);
            Logger.d("VivoPushHelper", "vivoAppKey:" + String.valueOf(strE) + ",vivoAppId:" + String.valueOf(strD));
            if (!TextUtils.isEmpty(strE) && !TextUtils.isEmpty(strD)) {
                PushClient.getInstance(context).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());
                PushClient.getInstance(context).turnOnPush(new b(context));
                return;
            }
            a(context, JThirdPlatFormInterface.KEY_VENDOR_PUSH_APP_KEY_MISS);
            Logger.ke("VivoPushHelper", "vivo sdk appkey or appid was empty,please check your manifest config");
        } catch (Throwable th) {
            a(context, JThirdPlatFormInterface.KEY_VENDOR_PUSH_INIT_UNKNOWN_EXCEPTION);
            Logger.ee("VivoPushHelper", "register error#" + th);
        }
    }

    public static void a(String str, Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("token", str);
        bundle.putByte("platform", (byte) 5);
        bundle.putInt(JThirdPlatFormInterface.KEY_VOIP_STATUS, i(context));
        JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_RREGISTER_TTOKEN, bundle);
    }
}
