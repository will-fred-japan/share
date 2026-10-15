package com.engagelab.privates.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.AESUtil;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, SharedPreferences> f12404a = new HashMap();

    public static void a(Context context, JSONArray jSONArray) {
        n(context).edit().putString("tcp_address_l", jSONArray != null ? jSONArray.toString() : null).commit();
    }

    public static void b(Context context, JSONArray jSONArray) {
        n(context).edit().putString("tcp_address_ssl_l", jSONArray != null ? jSONArray.toString() : null).commit();
    }

    public static void c(Context context, Set<String> set) {
        n(context).edit().putStringSet("udp_address", set).commit();
    }

    public static Set<String> d(Context context) {
        return n(context).getStringSet(MTCoreGlobal.getServiceNode() == MTCoreConstants.ServiceNode.REGION_CHINA ? "g_s_ar_cn" : "g_s_ar", new LinkedHashSet());
    }

    public static void e(Context context, int i9) {
        n(context).edit().putInt("tcp_address_ssl_c_v", i9).commit();
    }

    public static int f(Context context) {
        return n(context).getInt("login_code", -1);
    }

    public static String g(Context context) {
        return n(context).getString("oversea_info_hash", "");
    }

    public static String h(Context context) {
        SharedPreferences sharedPreferencesN = n(context);
        String string = sharedPreferencesN.getString("p_w_d_enc", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return AESUtil.decryptWithKeystoreAesGcm(string);
            } catch (Throwable th) {
                MTCommonLog.w("MTCoreConfig", "getPassword decrypt failed:" + th);
                return "";
            }
        }
        String string2 = sharedPreferencesN.getString("p_w_d", "");
        if (TextUtils.isEmpty(string2)) {
            return "";
        }
        try {
            sharedPreferencesN.edit().putString("p_w_d_enc", AESUtil.encryptWithKeystoreAesGcm(string2)).remove("p_w_d").commit();
            return string2;
        } catch (Throwable th2) {
            MTCommonLog.w("MTCoreConfig", "getPassword migrate failed, keep legacy:" + th2);
            return string2;
        }
    }

    public static byte i(Context context) {
        return (byte) n(context).getInt("platform_state", 0);
    }

    public static int j(Context context) {
        return n(context).getInt("register_code", -1);
    }

    public static String k(Context context) {
        return n(context).getString(MTCoreConstants.Register.KEY_REGISTRATION_ID, "");
    }

    public static int l(Context context) {
        return n(context).getInt(MTCoreConstants.Login.KEY_SEED_ID, 0);
    }

    public static long m(Context context) {
        return n(context).getLong(MTCoreConstants.Login.KEY_SERVER_TIME, 0L);
    }

    public static SharedPreferences n(Context context) {
        String str = "com.engagelab.privates.core.prefs." + MTGlobal.getAppKey(context);
        SharedPreferences sharedPreferences = f12404a.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        f12404a.put(str, sharedPreferences2);
        return sharedPreferences2;
    }

    public static List<String> o(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            String string = n(context).getString("tcp_address_l", null);
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                    arrayList.add(jSONArray.getString(i9));
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static List<String> p(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            String string = n(context).getString("tcp_address_ssl_l", null);
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                    arrayList.add(jSONArray.getString(i9));
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static int q(Context context) {
        return n(context).getInt("tcp_address_ssl_c_v", -1);
    }

    public static Set<String> r(Context context) {
        return n(context).getStringSet("udp_address", new LinkedHashSet());
    }

    public static long s(Context context) {
        return n(context).getLong(MTCoreConstants.Register.KEY_USER_ID, 0L);
    }

    public static String t(Context context) {
        return n(context).getString("user_language", "");
    }

    public static void c(Context context, int i9) {
        n(context).edit().putInt("register_code", i9).commit();
    }

    public static Set<String> e(Context context) {
        return n(context).getStringSet("http_address", new LinkedHashSet());
    }

    public static void a(Context context, Set<String> set) {
        n(context).edit().putStringSet(MTCoreGlobal.getServiceNode() == MTCoreConstants.ServiceNode.REGION_CHINA ? "g_s_ar_cn" : "g_s_ar", set).commit();
    }

    public static void b(Context context, Set<String> set) {
        n(context).edit().putStringSet("http_address", set).commit();
    }

    public static void c(Context context, String str) {
        SharedPreferences.Editor editorEdit = n(context).edit();
        if (TextUtils.isEmpty(str)) {
            editorEdit.remove("p_w_d_enc").remove("p_w_d").commit();
            return;
        }
        try {
            editorEdit.putString("p_w_d_enc", AESUtil.encryptWithKeystoreAesGcm(str)).remove("p_w_d").commit();
        } catch (Throwable th) {
            MTCommonLog.w("MTCoreConfig", "setPassword encrypt failed, skip write:" + th);
        }
    }

    public static void e(Context context, String str) {
        n(context).edit().putString("user_language", str).commit();
    }

    public static void b(Context context, long j) {
        n(context).edit().putLong(MTCoreConstants.Register.KEY_USER_ID, j).commit();
    }

    public static void d(Context context, String str) {
        n(context).edit().putString(MTCoreConstants.Register.KEY_REGISTRATION_ID, str).commit();
    }

    public static void b(Context context, int i9) {
        n(context).edit().putInt("login_code", i9).commit();
    }

    public static void d(Context context, int i9) {
        n(context).edit().putInt(MTCoreConstants.Login.KEY_SEED_ID, i9).commit();
    }

    public static void a(Context context, long j) {
        n(context).edit().putLong(MTCoreConstants.Login.KEY_SERVER_TIME, j).commit();
    }

    public static int b(Context context) {
        return n(context).getInt("connect_ssl_c_v", -1);
    }

    public static void a(Context context, boolean z8) {
        n(context).edit().putBoolean("connect_state", z8).commit();
    }

    public static void b(Context context, String str) {
        n(context).edit().putString("oversea_info_hash", str).commit();
    }

    public static void a(Context context, byte b9) {
        n(context).edit().putInt("platform_state", b9).commit();
    }

    public static void a(Context context, int i9) {
        n(context).edit().putInt("connect_ssl_c_v", i9).commit();
    }

    public static boolean c(Context context) {
        return n(context).getBoolean("connect_state", true);
    }

    public static String a(Context context) {
        return n(context).getString("connect_ssl_crt", "");
    }

    public static void a(Context context, String str) {
        n(context).edit().putString("connect_ssl_crt", str).commit();
    }
}
