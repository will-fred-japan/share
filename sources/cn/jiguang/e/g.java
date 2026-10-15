package cn.jiguang.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f10513a;

    public static void a(Context context, int i9) {
        f(context).edit().putInt("log_ref_count", i9).apply();
    }

    public static long b(Context context) {
        return f(context).getLong("log_last_timestamp", 0L);
    }

    public static int c(Context context) {
        return f(context).getInt("log_ref_count", 0);
    }

    public static boolean d(Context context) {
        return f(context).getBoolean("local_upload_enable", false);
    }

    public static int e(Context context) {
        return f(context).getInt("server_upload_state", 2);
    }

    private static synchronized SharedPreferences f(Context context) {
        SharedPreferences sharedPreferences;
        try {
            try {
                String strA = cn.jiguang.aw.a.a(context);
                if (!TextUtils.isEmpty(strA) && !TextUtils.equals(strA, context.getPackageName())) {
                    String str = strA.split(Constants.COLON_SEPARATOR)[1];
                    if (f10513a == null) {
                        sharedPreferences = context.getSharedPreferences("cn.jiguang.sdk.log_config_" + str, 0);
                        f10513a = sharedPreferences;
                    }
                } else if (f10513a == null) {
                    sharedPreferences = context.getSharedPreferences("cn.jiguang.sdk.log_config", 0);
                    f10513a = sharedPreferences;
                }
            } catch (Throwable th) {
                cn.jiguang.x.f.i("SpConfig", "getSharedPreferences failed, e: " + th.getMessage());
                if (f10513a == null) {
                    f10513a = context.getSharedPreferences("cn.jiguang.sdk.log_config", 0);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f10513a;
    }

    public static void a(Context context, long j) {
        f(context).edit().putLong("log_last_timestamp", j).apply();
    }

    public static void b(Context context, int i9) {
        f(context).edit().putInt("server_upload_state", i9).apply();
    }

    public static void a(Context context, boolean z8) {
        A.f.l(f(context), "external_log_enabled", z8);
    }

    public static void b(Context context, boolean z8) {
        A.f.l(f(context), "local_upload_enable", z8);
    }

    public static boolean a(Context context) {
        return f(context).getBoolean("external_log_enabled", false);
    }
}
