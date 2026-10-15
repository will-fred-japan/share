package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.BundleUtil;
import com.starburst.sdk.api.GuiControlConfig;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f18046a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Set<String> f859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f18047b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f18048c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f18049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f18050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f18051f = String.valueOf((char) 2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String[] f860a = {"--", "a-", "u-", "v-", "o-", "g-", "d-"};

    static {
        HashSet hashSet = new HashSet();
        f859a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
    }

    private static double a(double d9) {
        int i9 = 1;
        while (true) {
            double d10 = i9;
            if (d10 >= d9) {
                return d10;
            }
            i9 <<= 1;
        }
    }

    @Deprecated
    public static String b(Context context) {
        return null;
    }

    @Deprecated
    public static String c(Context context) {
        return null;
    }

    @Deprecated
    public static String d(Context context) {
        return null;
    }

    @Deprecated
    public static String e(Context context) {
        return "";
    }

    public static String f(Context context) {
        return ((TelephonyManager) context.getSystemService(GuiControlConfig.DEVICE_PHONE)).getSimOperatorName();
    }

    private static String g(Context context) {
        String string = context.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strH = h(context);
        a(context, strH);
        return strH;
    }

    private static String h(Context context) {
        String str = Build.BRAND;
        String strA = l.a();
        int i9 = Build.VERSION.SDK_INT;
        String str2 = Build.VERSION.RELEASE;
        String strE = k.e();
        int iA = a();
        String packageName = context.getPackageName();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA2 = bm.a(16);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(BundleUtil.UNDERLINE_TAG);
        sb.append(strA);
        sb.append(BundleUtil.UNDERLINE_TAG);
        sb.append(i9);
        H2.a.j(sb, BundleUtil.UNDERLINE_TAG, str2, BundleUtil.UNDERLINE_TAG, strE);
        sb.append(BundleUtil.UNDERLINE_TAG);
        sb.append(iA);
        sb.append(BundleUtil.UNDERLINE_TAG);
        sb.append(packageName);
        sb.append(BundleUtil.UNDERLINE_TAG);
        sb.append(jCurrentTimeMillis);
        sb.append(BundleUtil.UNDERLINE_TAG);
        sb.append(strA2);
        return bj.a(sb.toString());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String m608a(int i9) {
        if (i9 > 0) {
            String[] strArr = f860a;
            if (i9 < strArr.length) {
                return strArr[i9];
            }
        }
        return f860a[0];
    }

    public static int b() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String[] strArrSplit;
        int i9 = 0;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                    try {
                        String line = bufferedReader.readLine();
                        if (!TextUtils.isEmpty(line) && (strArrSplit = line.split("\\s+")) != null && strArrSplit.length >= 2 && TextUtils.isDigitsOnly(strArrSplit[1])) {
                            i9 = Integer.parseInt(strArrSplit[1]);
                        }
                        bufferedReader.close();
                    } catch (Exception unused) {
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return i9;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (Exception unused4) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
        return i9;
    }

    public static String c() {
        return b() + "KB";
    }

    public static String d() {
        return W5.e.m(new StringBuilder(), a(Environment.getDataDirectory()) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, "KB");
    }

    public static synchronized String a(Context context, boolean z8) {
        int i9;
        try {
            if (f18049d == null) {
                String strMo95a = aq.a(context).mo95a();
                if (TextUtils.isEmpty(strMo95a) || strMo95a.startsWith("00000000-0000-0000-0000-000000000000")) {
                    strMo95a = a(context);
                    if (TextUtils.isEmpty(strMo95a)) {
                        strMo95a = g(context);
                        i9 = 6;
                    } else {
                        i9 = 5;
                    }
                } else {
                    i9 = 4;
                }
                com.xiaomi.channel.commonutils.logger.c.b("devid rule select:" + i9);
                if (i9 == 3) {
                    f18049d = strMo95a;
                } else {
                    f18049d = m608a(i9) + bm.b(strMo95a);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f18049d;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static String m612b() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    public static String a(Context context) {
        if (!k.m649a(context)) {
            return null;
        }
        String str = f18047b;
        if (str != null) {
            return str;
        }
        try {
            f18047b = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.c.m9a("failure to get androidId: " + th);
        }
        return f18047b;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m613b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    @TargetApi(17)
    public static int a() {
        Object objA = bh.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (objA == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(objA)).intValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m607a() {
        return a(b()) + "GB";
    }

    private static float a(int i9) {
        float f6 = (((((i9 + 102400) / MiPushSdk.FLAG_SUPPORT_CALLKIT) + 1) * MiPushSdk.FLAG_SUPPORT_CALLKIT) / 1024.0f) / 1024.0f;
        double d9 = f6;
        return d9 > 0.5d ? (float) Math.ceil(d9) : f6;
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m610a(Context context) {
        try {
            Intent intentA = n.a(context, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentA != null) {
                int intExtra = intentA.getIntExtra("status", -1);
                return intExtra == 2 || intExtra == 5;
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.b("DeviceInfo", "getChargingStatus error", e9);
        }
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m609a() {
        return a() <= 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m611a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) bh.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        return packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) != 8388608;
    }

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", null))) {
            A.f.k(sharedPreferences, "default_id", str);
        } else {
            com.xiaomi.channel.commonutils.logger.c.m9a("default_id exist,do not change it.");
        }
    }
}
