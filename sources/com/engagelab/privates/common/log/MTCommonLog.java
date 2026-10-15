package com.engagelab.privates.common.log;

import A.a;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.engagelab.privates.common.BuildConfig;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MTCommonLog {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void d(String str, String str2) {
        MTLogCache.getInstance().d(str, str2);
        if (MTGlobal.getDebugMode()) {
            Log.d(getTag(), "[" + str + "] " + str2);
        }
    }

    public static void dd(String str, String str2) {
        MTLogCache.getInstance().d(str, str2);
    }

    public static void debug(String str, String str2) {
        MTLogCache.getInstance().debug(str, str2);
        if (MTGlobal.getDebugMode()) {
            Log.d(getTag(), "d-[" + str + "] " + str2);
        }
    }

    public static void debugOnly(String str, String str2) {
        if (MTGlobal.getDebugMode()) {
            Log.d(getTag(), "o-[" + str + "] " + str2);
        }
    }

    public static void e(String str, String str2) {
        Log.e(getTag(), "[" + str + "] " + str2);
        MTLogCache.getInstance().e(str, str2);
    }

    public static void ee(String str, String str2) {
        MTLogCache.getInstance().e(str, str2);
    }

    public static List<File> getAllClosedLogFiles() {
        return MTLogCache.getInstance().getAllClosedLogFiles();
    }

    private static String getLogTag() {
        try {
            String name = Thread.currentThread().getName();
            if (TextUtils.isEmpty(name)) {
                return MTCommonConstants.getLogTag() + "SDK";
            }
            if (TextUtils.equals(name, Looper.getMainLooper().getThread().getName())) {
                return MTCommonConstants.getLogTag() + "MAIN";
            }
            if (name.startsWith(MTCommonConstants.getLogTag())) {
                return name;
            }
            return MTCommonConstants.getLogTag() + name;
        } catch (Throwable unused) {
            return MTCommonConstants.getLogTag() + "SDK";
        }
    }

    private static String getTag() {
        return a.j(new StringBuilder(), getLogTag(), BuildConfig.LOG_TAG);
    }

    public static void i(String str, String str2) {
        Log.i(getTag(), "[" + str + "] " + str2);
        MTLogCache.getInstance().i(str, str2);
    }

    public static void ii(String str, String str2) {
        MTLogCache.getInstance().i(str, str2);
    }

    public static void initLogCache(Context context) {
        if (context == null) {
            Log.e(getTag(), "initLogCache: context is null");
        } else {
            MTLogCache.getInstance().init(context);
        }
    }

    public static boolean isLogCacheEnabled() {
        return MTLogCache.getInstance().isEnabled();
    }

    public static boolean isProcessTypeSet() {
        return MTLogCache.getInstance().isProcessTypeSet();
    }

    public static void setLogCacheEnabled(boolean z8) {
        MTLogCache.getInstance().setEnabled(z8);
    }

    public static void setLogCacheEnabledAll(boolean z8) {
        MTLogCache.getInstance().setEnabledAll(z8);
    }

    public static void setMaxTotalSize(long j) {
        MTLogCache.getInstance().setMaxTotalSize(j);
    }

    public static void setProcessType(boolean z8) {
        MTLogCache.getInstance().setProcessType(z8);
    }

    public static void setReuseActiveFile(boolean z8) {
        MTLogCache.getInstance().setReuseActiveFile(z8);
    }

    public static String toLogString(Bundle bundle) {
        if (bundle == null) {
            return "null";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{ ");
            for (String str : bundle.keySet()) {
                sb.append(str);
                sb.append(Constants.COLON_SEPARATOR);
                sb.append(bundle.get(str));
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        } catch (Throwable unused) {
            return bundle.toString();
        }
    }

    public static void w(String str, String str2) {
        MTLogCache.getInstance().w(str, str2);
        if (MTGlobal.getDebugMode()) {
            Log.w(getTag(), "[" + str + "] " + str2);
        }
    }

    public static void ww(String str, String str2) {
        MTLogCache.getInstance().w(str, str2);
    }

    public static String toLogString(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "null";
        }
        try {
            return LINE_SEPARATOR + jSONObject.toString(2);
        } catch (Throwable unused) {
            return jSONObject.toString();
        }
    }

    public static void debugOnlyDD(String str, String str2) {
    }
}
