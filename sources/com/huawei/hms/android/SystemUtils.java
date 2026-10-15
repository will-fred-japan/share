package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.AndroidException;
import com.heytap.mcssdk.utils.d;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public class SystemUtils {
    public static final String PRODUCT_BRAND = "ro.product.brand";
    public static final String PRODUCT_HONOR = "HONOR";
    public static final String PRODUCT_HUAWEI = "HUAWEI";
    public static final String UNKNOWN = "unknown";

    private static String a() {
        return getSystemProperties("ro.product.locale", "");
    }

    private static String b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static String getAndoridVersion() {
        return getSystemProperties("ro.build.version.release", "unknown");
    }

    public static String getLocalCountry() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static String getManufacturer() {
        return getSystemProperties("ro.product.manufacturer", "unknown");
    }

    public static long getMegabyte(double d9) {
        return (long) (d9 * 1000.0d * 1000.0d);
    }

    public static String getNetType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? "" : activeNetworkInfo.getTypeName();
    }

    public static String getPhoneModel() {
        return getSystemProperties("ro.product.model", "unknown");
    }

    public static String getSystemProperties(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    @Deprecated
    public static boolean isChinaROM() {
        String strB = b();
        if (!TextUtils.isEmpty(strB)) {
            return "cn".equalsIgnoreCase(strB);
        }
        String strA = a();
        if (!TextUtils.isEmpty(strA)) {
            return strA.toLowerCase(Locale.US).contains("cn");
        }
        String localCountry = getLocalCountry();
        if (TextUtils.isEmpty(localCountry)) {
            return false;
        }
        return "cn".equalsIgnoreCase(localCountry);
    }

    public static boolean isEMUI() {
        StringBuilder sb = new StringBuilder("is Emui :");
        int i9 = HwBuildEx.VERSION.EMUI_SDK_INT;
        sb.append(i9);
        HMSLog.i("SystemUtils", sb.toString());
        return i9 > 0;
    }

    public static boolean isHuawei() {
        String systemProperties = getSystemProperties(PRODUCT_BRAND, "unknown");
        return PRODUCT_HUAWEI.equalsIgnoreCase(systemProperties) || PRODUCT_HONOR.equalsIgnoreCase(systemProperties);
    }

    public static boolean isSystemApp(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null) {
            HMSLog.w("SystemUtils", "isSystemApp context is null");
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, Http2.INITIAL_MAX_FRAME_SIZE);
        } catch (AndroidException e9) {
            HMSLog.e("SystemUtils", "isSystemApp Exception: " + e9);
            packageInfo = null;
        } catch (RuntimeException e10) {
            HMSLog.e("SystemUtils", "isSystemApp RuntimeException:" + e10);
            packageInfo = null;
        }
        return packageInfo != null && (packageInfo.applicationInfo.flags & 1) > 0;
    }

    public static boolean isTVDevice() {
        return getSystemProperties(d.f14376d, "default").equalsIgnoreCase("tv");
    }
}
