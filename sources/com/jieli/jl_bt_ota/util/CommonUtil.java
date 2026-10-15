package com.jieli.jl_bt_ota.util;

import I.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.model.base.BaseError;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CommonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static WeakReference<Context> f16326a = null;
    public static final boolean isSupportAndroid12 = true;

    private static void a() {
        WeakReference<Context> weakReference = f16326a;
        if (weakReference != null) {
            weakReference.clear();
            System.gc();
        }
    }

    public static <T> void callbackError(String str, String str2, IActionCallback<T> iActionCallback, BaseError baseError) {
        if (baseError == null) {
            return;
        }
        JL_Log.w(str, str2, baseError.toString());
        if (iActionCallback != null) {
            iActionCallback.onError(baseError);
        }
    }

    public static void checkAllNotNull(Object... objArr) {
        for (Object obj : objArr) {
            obj.getClass();
        }
    }

    public static boolean checkHasConnectPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return checkHasPermission(context, "android.permission.BLUETOOTH_CONNECT");
        }
        return true;
    }

    public static boolean checkHasLocationPermission(Context context) {
        return Build.VERSION.SDK_INT >= 31 || checkHasPermission(context, "android.permission.ACCESS_FINE_LOCATION") || checkHasPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
    }

    public static boolean checkHasPermission(Context context, String str) {
        return context != null && a.a(context, str) == 0;
    }

    public static boolean checkHasScanPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return checkHasPermission(context, "android.permission.BLUETOOTH_SCAN");
        }
        return true;
    }

    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    public static String formatInt(int i9) {
        return formatString("%d(0x%X)", Integer.valueOf(i9), Integer.valueOf(i9));
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public static Context getMainContext() {
        WeakReference<Context> weakReference = f16326a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static void setMainContext(Context context) {
        f16326a = new WeakReference<>((Context) checkNotNull(context));
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
