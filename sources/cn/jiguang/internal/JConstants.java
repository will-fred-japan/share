package cn.jiguang.internal;

import android.content.Context;
import cn.jiguang.android.BuildConfig;
import cn.jiguang.api.JAnalyticsAction;
import cn.jiguang.aw.d;
import cn.jiguang.x.f;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class JConstants {
    public static final byte AES_CBC = 1;
    public static String APP_KEY = "";
    public static final String DATA_PROVIDER_SUFFIX = ".DataProvider";
    public static final long DAY = 86400000;
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final long HOUR = 3600000;
    public static final boolean INTERNAL_USE = false;
    public static final boolean IS_FOR_GOOGLE_PLAY_USE = false;
    public static final boolean IS_FOR_GOOGLE_PURE_USE = false;
    public static final boolean IS_FOR_JBASIC = false;
    public static final boolean LOG_ENABLE = true;
    public static final int LOG_ENABLED_LEVEL = 2;
    public static final boolean LOG_FILE_ENABLE = true;
    public static final long MIN = 60000;
    public static final boolean REPORT_SUPPORT_HTTP = false;
    public static final boolean REPORT_USE_HTTPS = true;
    public static final String SDK_TYPE = "JCore";
    public static final long SECOND = 1000;
    public static final byte SM4_CBC = 2;
    public static final boolean SUPPORT_DY = true;
    private static final String TAG = "JConstants";
    public static final String USER_SERVICE_ACTION = "cn.jiguang.user.service.action";
    public static JAnalyticsAction jAnalyticsAction;
    public static int tcpSessionId;
    public static String testJOperateBaseUrl;
    public static LinkedList<String> TUU = new LinkedList<>();
    public static boolean AT_I = false;
    public static String SDK_NAME = "";
    public static String SDK_VERSION = BuildConfig.VERSION_NAME;
    public static int SDK_VERSION_INT = BuildConfig.VERSION_CODE;
    public static boolean DEBUG_MODE = false;
    public static boolean CMD_TO_PRINT_ALL_LOG = false;
    public static boolean isInstrumentationHookFailed = true;
    public static AtomicBoolean isCallInit = new AtomicBoolean();
    public static int DEFAULT_HEARTBEAT_INTERVAL = 285;
    public static int DEFAULT_ALARM_DELAY = 285 + 5;
    public static byte tcpAlgorithm = 1;
    private static boolean testEnv = false;
    public static String testCountry = "";
    public static String testBannedConfigUrl = "";
    public static String testLimitConfigUrl = "";
    private static boolean isTestAndroidQ = false;
    private static final AtomicReference<Context> mApplicationContext = new AtomicReference<>();

    public static Context getAppContext() {
        return getAppContext(null);
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
            boolean r3 = cn.jiguang.internal.JConstants.isTestAndroidQ
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
            boolean r4 = cn.jiguang.internal.JConstants.isTestAndroidQ
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
            if (r0 == 0) goto L40
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "is Android Q, msg: "
            r3.<init>(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "JConstants"
            cn.jiguang.x.f.c(r4, r3)
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.internal.JConstants.isAndroidQ(android.content.Context, boolean, java.lang.String):boolean");
    }

    public static boolean isTestEnv() {
        return false;
    }

    public static void testAndroidQ() {
        f.c(TAG, "call testAndroidQ");
        isTestAndroidQ = true;
    }

    public static Context getAppContext(Context context) {
        AtomicReference<Context> atomicReference = mApplicationContext;
        Context applicationContext = atomicReference.get();
        if (applicationContext == null) {
            if (context != null) {
                applicationContext = context.getApplicationContext();
            }
            atomicReference.set(applicationContext);
        }
        if (applicationContext != null) {
            d.a(applicationContext);
        }
        return applicationContext;
    }

    public static void setTestEnv(boolean z8) {
    }
}
