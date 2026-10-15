package cn.jiguang.g;

import W5.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.commons.j.c;
import cn.jiguang.commons.j.m;
import cn.jiguang.e.d;
import cn.jiguang.e.f;
import cn.jpush.android.data.JPushCollectControl;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLCredentialContract;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10519a = "DISABLE_DATA";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10520b = "ENABLE_DATA";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f10521c = "KEY_CHANNEL";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f10522d = "KEY_PLATFORM_TYPE";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f10523e = "KEY_PLATFORM_REGID";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static AtomicBoolean f10524f = new AtomicBoolean();

    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static volatile a f10525b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f10526a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Context f10527c;

        private a(Context context) {
            this.f10526a = false;
            this.f10527c = context;
            this.f10526a = ((Boolean) f.a(context, b(context))).booleanValue();
            cn.jiguang.x.f.c("DataCollectorDefaultApi", "isConfigControl:" + this.f10526a);
        }

        public static a a(Context context) {
            if (f10525b == null) {
                synchronized (a.class) {
                    try {
                        if (f10525b == null) {
                            f10525b = new a(context);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f10525b;
        }

        private static d<Boolean> b(Context context) {
            return new d<>("cn.jiguang.sdk.common.core_middle_common_" + cn.jiguang.w.d.b(context), "load_config", Boolean.FALSE);
        }

        private static String f() {
            try {
                cn.jiguang.x.f.c("DataCollectorDefaultApi", "getBaseBandApi");
                Object objA = b.a(2001, true);
                if (objA instanceof String) {
                    return (String) objA;
                }
                cn.jiguang.x.f.i("DataCollectorDefaultApi", "getBaseBandApi() returned non-String object: " + objA);
                return "";
            } catch (Throwable th) {
                e.t(th, new StringBuilder("Exception in getBaseBandApi: "), "DataCollectorDefaultApi");
                return "";
            }
        }

        private static String g() {
            try {
                cn.jiguang.x.f.c("DataCollectorDefaultApi", "getAndroidIdApi");
                Object objA = b.a(1001, true);
                if (objA instanceof String) {
                    return (String) objA;
                }
                cn.jiguang.x.f.i("DataCollectorDefaultApi", "getAndroidIdApi() returned non-String object: " + objA);
                return "";
            } catch (Throwable th) {
                e.t(th, new StringBuilder("Exception in getAndroidIdApi: "), "DataCollectorDefaultApi");
                return "";
            }
        }

        private static String h() {
            try {
                cn.jiguang.x.f.c("DataCollectorDefaultApi", "getAndroidIdApi");
                Object objA = b.a(MTCommonConstants.MainWhat.ON_FRAGMENT_RESUMED, true);
                if (objA instanceof String) {
                    return (String) objA;
                }
                cn.jiguang.x.f.i("DataCollectorDefaultApi", "getResolutioneApi() returned non-String object: " + objA);
                return "0*0";
            } catch (Throwable th) {
                e.t(th, new StringBuilder("Exception in getResolutioneApi: "), "DataCollectorDefaultApi");
                return "0*0";
            }
        }

        public String c() {
            if (this.f10526a) {
                return b.a();
            }
            cn.jiguang.x.f.c("DataCollectorDefaultApi", "getBaseBandApi:" + this.f10526a);
            return f();
        }

        public String d() {
            return this.f10526a ? b.l() : g();
        }

        public String e() {
            if (this.f10526a) {
                return b.g();
            }
            cn.jiguang.x.f.c("DataCollectorDefaultApi", "getResolutioneApi:" + this.f10526a);
            return h();
        }

        public void a() {
            cn.jiguang.x.f.c("DataCollectorDefaultApi", "setConfigControl:" + this.f10526a);
            if (this.f10526a) {
                return;
            }
            Context context = this.f10527c;
            f.a(context, (d<?>[]) new d[]{b(context).a(Boolean.TRUE)});
            this.f10526a = true;
        }

        public boolean b() {
            return this.f10526a;
        }
    }

    /* JADX INFO: renamed from: cn.jiguang.g.b$b, reason: collision with other inner class name */
    public static class C0132b {
        public static Object a(int i9, String str, Bundle bundle, Object... objArr) {
            cn.jiguang.x.f.c("JCommonHelper", "onEvent: " + i9 + ", action:" + str);
            return m.e(cn.jiguang.aw.d.a(), i9, str, bundle, objArr);
        }

        public static Object a(Context context, int i9, String str, Bundle bundle, Object... objArr) {
            cn.jiguang.x.f.c("JCommonHelper", "onEvent c: " + i9 + ", action:" + str);
            return m.e(context, i9, str, bundle, objArr);
        }

        public static void a(c cVar) {
            m.a(cVar);
        }
    }

    public static List<String> A() {
        try {
            Object objA = C0132b.a(20, null, null, new Object[0]);
            if (objA instanceof List) {
                return (List) objA;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getAppPackageNames() returned non-List object: " + objA);
            return null;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getAppPackageNames: "), "JCommonHelper");
            return null;
        }
    }

    public static JSONObject B() {
        return d(false);
    }

    public static JSONObject C() {
        try {
            Object objB = b(1029);
            if (objB instanceof JSONObject) {
                return (JSONObject) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getNcidBox() returned non-JSONObject object: " + objB);
            return null;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getNcidBox: "), "JCommonHelper");
            return null;
        }
    }

    public static JSONArray D() {
        try {
            Object objA = C0132b.a(14, null, null, 1022);
            if (objA != null && (objA instanceof JSONArray)) {
                return (JSONArray) objA;
            }
            return null;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in sendAction: "), "JCommonHelper");
            return null;
        }
    }

    public static PackageInfo a(String str, int i9) {
        try {
            return (PackageInfo) C0132b.a(17, null, null, str, Integer.valueOf(i9));
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getPackageInfo: "), "JCommonHelper");
            return null;
        }
    }

    public static Object b(int i9) {
        try {
            return C0132b.a(14, null, null, Integer.valueOf(i9));
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getData: "), "JCommonHelper");
            return null;
        }
    }

    public static String c() {
        try {
            Object objA = a(1013, true);
            if (objA instanceof String) {
                return (String) objA;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getModel() returned non-String object: " + objA);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getModel: "), "JCommonHelper");
            return "";
        }
    }

    public static String d() {
        try {
            Object objB = b(1020);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getScreenSize() returned non-String object: " + objB);
            return "0";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getScreenSize: "), "JCommonHelper");
            return "0";
        }
    }

    public static int e(int i9) {
        try {
            Object objA = C0132b.a(27, null, null, new Object[0]);
            if (objA instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) objA;
                if (jSONObject.optBoolean("isCharging")) {
                    return jSONObject.optInt("plugged", -1);
                }
                return -1;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getChargedStatus() returned non-Integer object: " + objA);
            return i9;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getChargedStatus: "), "JCommonHelper");
            return i9;
        }
    }

    public static String f() {
        try {
            Object objB = b(1601);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getLocalBssid() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getLocalBssid: "), "JCommonHelper");
            return "";
        }
    }

    public static long g(int i9) {
        JSONObject jSONObjectH = h(i9);
        if (jSONObjectH != null) {
            return jSONObjectH.optLong("sc");
        }
        return 0L;
    }

    public static String h() {
        try {
            Object objB = b(MTCommonConstants.MainWhat.ON_NETWORK_CHANGED);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getFingerprint() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getFingerprint: "), "JCommonHelper");
            return "";
        }
    }

    public static String i() {
        try {
            Object objB = b(MTCommonConstants.MainWhat.ON_ACTIVITY_STOPPED);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getProduct() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getProduct: "), "JCommonHelper");
            return "";
        }
    }

    public static String j() {
        try {
            Object objB = b(JPushCollectControl.IMSI);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getMac() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getMac: "), "JCommonHelper");
            return "";
        }
    }

    public static boolean k() {
        try {
            Object objB = b(2500);
            if (objB instanceof Boolean) {
                return ((Boolean) objB).booleanValue();
            }
            cn.jiguang.x.f.i("JCommonHelper", "getRootState() returned non-Boolean object: " + objB);
            return false;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getRootState: "), "JCommonHelper");
            return false;
        }
    }

    public static String l() {
        try {
            Object objB = b(1001);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getAndroidId() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getAndroidId: "), "JCommonHelper");
            return "";
        }
    }

    public static String m() {
        return c("");
    }

    public static String n() {
        return d("");
    }

    public static String o() {
        try {
            Object objB = b(MTCommonConstants.MainWhat.ON_ACTIVITY_PAUSED);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getOsVersionName() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getOsVersionName: "), "JCommonHelper");
            return "";
        }
    }

    public static String p() {
        try {
            Object objB = b(1026);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getTimeZone() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getTimeZone: "), "JCommonHelper");
            return "";
        }
    }

    public static String q() {
        try {
            Object objB = b(MTCommonConstants.MainWhat.ON_ACTIVITY_CREATED);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getManufacturer() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getManufacturer: "), "JCommonHelper");
            return "";
        }
    }

    public static String r() {
        try {
            Object objA = a(MTCommonConstants.MainWhat.ON_ACTIVITY_CREATED, true);
            if (objA instanceof String) {
                return (String) objA;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getManufacturerApi() returned non-String object: " + objA);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getManufacturerApi: "), "JCommonHelper");
            return "";
        }
    }

    public static String s() {
        try {
            Object objB = b(1009);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getLanguage() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getLanguage: "), "JCommonHelper");
            return "";
        }
    }

    public static String t() {
        try {
            Object objB = b(1002);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getBrand() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getBrand: "), "JCommonHelper");
            return "";
        }
    }

    public static String u() {
        try {
            Object objB = b(MTCommonConstants.MainWhat.ON_UPDATE_LOG_CACHE_CONFIG);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getRomVersion() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getRomVersion: "), "JCommonHelper");
            return "";
        }
    }

    public static String v() {
        try {
            Object objB = b(1900);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getOaid() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getOaid: "), "JCommonHelper");
            return "";
        }
    }

    public static String w() {
        try {
            Object objB = b(1901);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getGaid() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getGaid: "), "JCommonHelper");
            return "";
        }
    }

    public static String x() {
        return e("");
    }

    public static int y() {
        return e(-1);
    }

    public static Bundle z() {
        try {
            Object objA = C0132b.a(19, null, null, Boolean.FALSE);
            if (objA instanceof Bundle) {
                return (Bundle) objA;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getGps() returned non-Bundle object: " + objA);
            return null;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getGps: "), "JCommonHelper");
            return null;
        }
    }

    public static long g(String str) {
        return 0L;
    }

    public static String g() {
        try {
            Object objB = b(MTCommonConstants.MainWhat.ON_FRAGMENT_RESUMED);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getResolutione() returned non-String object: " + objB);
            return "0*0";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getResolutione: "), "JCommonHelper");
            return "0*0";
        }
    }

    public static Object a(int i9, boolean z8) {
        try {
            return C0132b.a(14, null, null, Integer.valueOf(i9), Boolean.valueOf(z8));
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getData: "), "JCommonHelper");
            return null;
        }
    }

    public static String b() {
        try {
            Object objB = b(1013);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getModel() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getModel: "), "JCommonHelper");
            return "";
        }
    }

    public static String c(String str) {
        try {
            Object objB = b(INotificationPermissionCallback.CODE_FREQUENT);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getImei() returned non-String object: " + objB);
            return str;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getImei: "), "JCommonHelper");
            return str;
        }
    }

    public static String d(String str) {
        try {
            Object objB = b(1032);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getFirstBoot() returned non-String object: " + objB);
            return str;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getFirstBoot: "), "JCommonHelper");
            return str;
        }
    }

    public static String e() {
        try {
            Object objB = b(1608);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getLocalSsid() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getLocalSsid: "), "JCommonHelper");
            return "";
        }
    }

    public static String f(String str) {
        try {
            Object objB = b(1504);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getIntNetworkType() returned non-Integer object: " + objB);
            return str;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getIntNetworkType: "), "JCommonHelper");
            return str;
        }
    }

    public static JSONObject h(int i9) {
        try {
            JSONObject jSONObject = (JSONObject) C0132b.a(24, null, null, Integer.valueOf(i9));
            cn.jiguang.x.f.c("JCommonHelper", "getConfig: " + jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getConfig: "), "JCommonHelper");
            return null;
        }
    }

    public static Object a(Bundle bundle, Object... objArr) {
        try {
            return C0132b.a(26, null, bundle, objArr);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in sendAction: "), "JCommonHelper");
            return null;
        }
    }

    public static String b(String str) {
        try {
            Object objB = b(INotificationPermissionCallback.CODE_UNSUPPORT);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getImsi() returned non-String object: " + objB);
            return str;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getImsi: "), "JCommonHelper");
            return str;
        }
    }

    public static void c(Bundle bundle) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "cm");
            C0132b.a(16, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in cm: "), "JCommonHelper");
        }
    }

    public static JSONObject d(boolean z8) {
        try {
            Object objA = C0132b.a(21, null, null, Boolean.valueOf(z8));
            if (objA instanceof JSONObject) {
                cn.jiguang.x.f.c("JCommonHelper", "getDeviceInfo: " + objA);
                return (JSONObject) objA;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getDeviceInfo() returned non-JSONObject object: " + objA);
            return null;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getDeviceInfo: "), "JCommonHelper");
            return null;
        }
    }

    public static String e(String str) {
        try {
            Object objB = b(1506);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getNetworkOperator() returned non-String object: " + objB);
            return str;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getNetworkOperator: "), "JCommonHelper");
            return str;
        }
    }

    public static List<String> f(int i9) {
        return a(false, i9);
    }

    public static void h(String str) {
    }

    public static String a() {
        try {
            Object objB = b(2001);
            if (objB instanceof String) {
                return (String) objB;
            }
            cn.jiguang.x.f.i("JCommonHelper", "getBaseBand() returned non-String object: " + objB);
            return "";
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getBaseBand: "), "JCommonHelper");
            return "";
        }
    }

    public static void b(Context context) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "initServerConfig");
            String strA = cn.jiguang.w.a.a(context);
            if (TextUtils.isEmpty(strA)) {
                cn.jiguang.x.f.i("JCommonHelper", "initServerConfig appKey: " + strA);
            } else {
                if (f10524f.get()) {
                    return;
                }
                f10524f.set(true);
                a(new cn.jiguang.g.a());
                a(context, strA, cn.jiguang.a.a.f8805c, cn.jiguang.a.a.f8806d);
            }
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in initServerConfig: "), "JCommonHelper");
        }
    }

    public static void c(boolean z8) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("auth", z8);
            C0132b.a(11, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in syncAuthState: "), "JCommonHelper");
        }
    }

    public static boolean d(int i9) {
        return b(i9, true);
    }

    public static List<String> a(boolean z8, int i9) {
        try {
            Object objA = C0132b.a(22, null, null, Boolean.valueOf(z8), Integer.valueOf(i9));
            if (objA != null && (objA instanceof List)) {
                return (List) objA;
            }
            return null;
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in getAppList: "), "JCommonHelper");
            return null;
        }
    }

    public static void b(Bundle bundle) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "si");
            C0132b.a(15, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in si: "), "JCommonHelper");
        }
    }

    public static boolean c(int i9) {
        return b(i9, true);
    }

    public static boolean c(int i9, boolean z8) {
        return a(i9, z8, true, true, false, false);
    }

    public static void a(int i9) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("init_state", i9);
            C0132b.a(11, null, bundle, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void b(boolean z8) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "syncConnectedState");
            Bundle bundle = new Bundle();
            bundle.putBoolean("connected", z8);
            C0132b.a(11, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in syncConnectedState: "), "JCommonHelper");
        }
    }

    public static void a(long j) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "onLogin");
            Bundle bundle = new Bundle();
            bundle.putLong("serverTime", j);
            C0132b.a(13, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in onLogin: "), "JCommonHelper");
        }
    }

    public static boolean b(int i9, boolean z8) {
        return a(i9, z8, true, false, false, false);
    }

    public static void a(long j, String str, String str2) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "onRegister");
            Bundle bundle = new Bundle();
            bundle.putLong("uid", j);
            bundle.putString("regId", str2);
            bundle.putString(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD, str);
            C0132b.a(12, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in onRegister: "), "JCommonHelper");
        }
    }

    public static void a(Context context) {
        try {
            C0132b.a(context, 23, null, null, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in init: "), "JCommonHelper");
        }
    }

    private static void a(Context context, String str, String str2, int i9) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "initServerConfig imp");
            Bundle bundle = new Bundle();
            bundle.putString(com.heytap.mcssdk.constant.b.f14307z, str);
            bundle.putString("jversion_name", str2);
            bundle.putInt("jversion", i9);
            C0132b.a(context, 10, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in init: "), "JCommonHelper");
        }
    }

    public static void a(Bundle bundle) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "syncUserConfig");
            C0132b.a(11, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in syncUserConfig: "), "JCommonHelper");
        }
    }

    private static void a(c cVar) {
        try {
            C0132b.a(cVar);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in addCallback: "), "JCommonHelper");
        }
    }

    public static void a(String str) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "syncChannel");
            Bundle bundle = new Bundle();
            bundle.putString(f10521c, str);
            C0132b.a(11, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in syncChannel: "), "JCommonHelper");
        }
    }

    public static void a(String str, Bundle bundle) {
        try {
            C0132b.a(25, str, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in sendAction: "), "JCommonHelper");
        }
    }

    public static void a(boolean z8) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", "syncForegroundState");
            Bundle bundle = new Bundle();
            bundle.putBoolean("isForeground", z8);
            C0132b.a(11, null, bundle, new Object[0]);
        } catch (Throwable th) {
            e.t(th, new StringBuilder("Exception in syncForegroundState: "), "JCommonHelper");
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean a(int i9, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        try {
            cn.jiguang.x.f.c("JCommonHelper", String.format("Checking isConfigEnable, params: configId=%d, useUserConfig=%b, useRegisterPro=%b, useForeground=%b, useMethodFrq=%b, useMethodCount=%b", Integer.valueOf(i9), Boolean.valueOf(z8), Boolean.valueOf(z9), Boolean.valueOf(z10), Boolean.valueOf(z11), Boolean.valueOf(z12)));
            Object objA = C0132b.a(18, null, null, Integer.valueOf(i9), Boolean.valueOf(z8), Boolean.valueOf(z9), Boolean.valueOf(z10), Boolean.valueOf(z11), Boolean.valueOf(z12));
            if (objA instanceof Boolean) {
                cn.jiguang.x.f.c("JCommonHelper", "isConfigEnable result: " + objA);
                return ((Boolean) objA).booleanValue();
            }
            cn.jiguang.x.f.i("JCommonHelper", "isConfigEnable returned non-Boolean: " + objA);
            return false;
        } catch (Throwable th) {
            cn.jiguang.x.f.i("JCommonHelper", String.format("Exception in isConfigEnable (configId=%d): %s", Integer.valueOf(i9), th.getMessage()));
            return false;
        }
    }
}
