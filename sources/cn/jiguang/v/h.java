package cn.jiguang.v;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10818a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f10819b;

    public static String a(Context context) {
        Bundle bundle;
        if (TextUtils.isEmpty(f10818a)) {
            f10818a = f.c();
        }
        if (TextUtils.isEmpty(f10818a)) {
            try {
                if (context != null) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String strA = a(bundle, "JPUSH_APPKEY");
                        f10818a = strA;
                        if (!TextUtils.isEmpty(strA)) {
                            f10818a = f10818a.toLowerCase(Locale.getDefault());
                        }
                    }
                } else {
                    cn.jiguang.u.b.b("MetaInfoFetcher", "[getAppKey] context is null");
                }
            } catch (Throwable unused) {
            }
        }
        return f10818a;
    }

    public static String b(Context context) {
        StringBuilder sb;
        Bundle bundle;
        if (f10819b == null && context != null) {
            try {
                String strD = f.d(context);
                f10819b = strD;
                if (strD != null) {
                    sb = new StringBuilder("get option channel - ");
                    sb.append(f10819b);
                } else {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String strA = a(bundle, "JPUSH_CHANNEL");
                        f10819b = strA;
                        if (!TextUtils.isEmpty(strA)) {
                            f10819b = j.b(f10819b);
                        }
                    }
                    sb = new StringBuilder("manifest:channel - ");
                    sb.append(f10819b);
                }
                cn.jiguang.u.b.c("MetaInfoFetcher", sb.toString());
            } catch (Throwable unused) {
            }
        }
        return f10819b;
    }

    public static String a(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }
}
