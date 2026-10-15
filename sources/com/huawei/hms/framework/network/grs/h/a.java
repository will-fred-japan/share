package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a() {
        return "8.0.1.304";
    }

    public static String b(Context context, String str, String str2) {
        return a(context, str, str2);
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), Http2.INITIAL_MAX_FRAME_SIZE).versionName;
        } catch (PackageManager.NameNotFoundException | RuntimeException e9) {
            Logger.w("AgentUtil", "", e9);
            return "";
        }
    }

    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return String.format(Locale.ROOT, W5.e.u(str, "/%s"), a());
        }
        String packageName = (ContextHolder.getAppContext() == null ? context : ContextHolder.getAppContext()).getPackageName();
        String strA = a(context);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        Locale locale = Locale.ROOT;
        String strI = A.a.i("%s/%s (Linux; Android %s; %s) ", str, "/%s %s");
        String strA2 = a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        return String.format(locale, strI, packageName, strA, str3, str4, strA2, str2);
    }
}
