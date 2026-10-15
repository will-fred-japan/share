package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.gq;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.internal.http2.Http2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f18410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f1156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f18411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f18412c;

    public interface a {
        void a();
    }

    static {
        Charset charset = StandardCharsets.UTF_8;
        f1157a = new String("1000271".getBytes(), charset);
        f18411b = new String("420100086271".getBytes(), charset);
        f18412c = new String("cn.register.xmpush.xiaomi.com".getBytes(), charset);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized u m826a(Context context) {
        u uVar = f18410a;
        if (uVar != null) {
            return uVar;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
        String string = sharedPreferences.getString("uuid", null);
        String string2 = sharedPreferences.getString("token", null);
        String string3 = sharedPreferences.getString("security", null);
        String string4 = sharedPreferences.getString("app_id", null);
        String string5 = sharedPreferences.getString("app_token", null);
        String string6 = sharedPreferences.getString(Constants.PACKAGE_NAME, null);
        int i9 = sharedPreferences.getInt("env_type", 1);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
            return null;
        }
        u uVar2 = new u(string, string2, string3, string4, string5, string6, i9);
        f18410a = uVar2;
        return uVar2;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0318  */
    /* JADX WARN: Code duplicated, block: B:13:0x0048  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [int] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static synchronized u a(Context context, String str, String str2, String str3) {
        String strSubstring;
        PackageInfo packageInfo;
        boolean z8;
        com.xiaomi.push.av avVarA;
        ?? r8;
        ?? r9;
        try {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", com.xiaomi.push.j.a(context, false));
            u uVar = f18410a;
            if (uVar == null || TextUtils.isEmpty(uVar.f1155a)) {
                strSubstring = null;
            } else {
                treeMap.put("uuid", f18410a.f1155a);
                int iLastIndexOf = f18410a.f1155a.lastIndexOf("/");
                if (iLastIndexOf != -1) {
                    strSubstring = f18410a.f1155a.substring(iLastIndexOf + 1);
                } else {
                    strSubstring = null;
                }
            }
            com.xiaomi.push.aq.a(context).a(treeMap);
            String str4 = m829a(context) ? f1157a : str2;
            String str5 = m829a(context) ? f18411b : str3;
            String str6 = m829a(context) ? "com.xiaomi.xmsf" : str;
            treeMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, str4);
            treeMap.put("apptoken", str5);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str6, Http2.INITIAL_MAX_FRAME_SIZE);
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo != null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(BuildConfig.VERSION_CODE));
            treeMap.put("packagename", str6);
            treeMap.put("model", com.xiaomi.push.l.a());
            treeMap.put("board", Build.BOARD);
            if (!com.xiaomi.push.k.m656e()) {
                String strB = com.xiaomi.push.j.b(context);
                String str7 = TextUtils.isEmpty(strB) ? "" : "" + com.xiaomi.push.bm.a(strB);
                String strD = com.xiaomi.push.j.d(context);
                if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(strD)) {
                    str7 = str7 + Constants.ACCEPT_TIME_SEPARATOR_SP + strD;
                }
                if (!TextUtils.isEmpty(str7)) {
                    treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, str7);
                }
            }
            treeMap.put("os", Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.xiaomi.push.k.e());
            int iA = com.xiaomi.push.j.a();
            if (iA >= 0) {
                treeMap.put("space_id", Integer.toString(iA));
            }
            treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
            treeMap.put("ram", com.xiaomi.push.j.m607a());
            treeMap.put("rom", com.xiaomi.push.j.m612b());
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : treeMap.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e10) {
                    com.xiaomi.channel.commonutils.logger.c.d("failed to add data in json format: k=" + ((String) entry.getKey()) + ",v=" + ((String) entry.getValue()) + ". " + e10);
                }
            }
            String strA = bg.a(jSONObject.toString());
            TreeMap treeMap2 = new TreeMap();
            treeMap2.put("requestData", strA);
            treeMap2.put("keyPairVer", "1");
            if (a(context) >= 2 || TextUtils.isEmpty(strA)) {
                z8 = false;
            } else {
                com.xiaomi.channel.commonutils.logger.c.m9a("r.data = " + strA);
                z8 = true;
            }
            String strA2 = a(context, z8);
            if (TextUtils.isEmpty(strA2)) {
                return null;
            }
            if (z8) {
                treeMap = treeMap2;
            }
            try {
                avVarA = com.xiaomi.push.ax.a(context, strA2, treeMap);
            } catch (IOException e11) {
                com.xiaomi.channel.commonutils.logger.c.d("device registration request failed. " + e11);
                avVarA = null;
            }
            if (avVarA == null || avVarA.f17062a != 200) {
                r8 = z8;
            } else {
                String strA3 = avVarA.a();
                if (TextUtils.isEmpty(strA3)) {
                    r8 = z8;
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(strA3);
                        r9 = jSONObject2.getInt("code");
                        try {
                            if (r9 == 0) {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                                String string = jSONObject3.getString("ssecurity");
                                String string2 = jSONObject3.getString("token");
                                String string3 = jSONObject3.getString("userId");
                                if (TextUtils.isEmpty(strSubstring)) {
                                    strSubstring = "an" + com.xiaomi.push.bm.a(6);
                                }
                                u uVar2 = new u(string3 + "@xiaomi.com/" + strSubstring, string2, string, str4, str5, str6, com.xiaomi.push.z.a());
                                a(context, uVar2);
                                f18410a = uVar2;
                                a(context, 0);
                                com.xiaomi.channel.commonutils.logger.c.m9a("device registration is successful. " + string3);
                                return uVar2;
                            }
                            r8 = z8;
                            y.a(context, jSONObject2.getInt("code"), jSONObject2.optString(com.heytap.mcssdk.constant.b.f14292i));
                            com.xiaomi.channel.commonutils.logger.c.m9a("device registration resp: " + strA3);
                        } catch (JSONException e12) {
                            e = e12;
                            com.xiaomi.channel.commonutils.logger.c.d("failed to parse respone json data. " + e);
                            r8 = r9;
                        } catch (Throwable th) {
                            th = th;
                            com.xiaomi.channel.commonutils.logger.c.d("unknow throwable. " + th);
                            r8 = r9;
                        }
                    } catch (JSONException e13) {
                        e = e13;
                        r9 = z8;
                    } catch (Throwable th2) {
                        th = th2;
                        r9 = z8;
                    }
                    com.xiaomi.channel.commonutils.logger.c.d("failed to parse respone json data. " + e);
                    r8 = r9;
                }
            }
            if (r8 != 0 && com.xiaomi.push.ax.b(context)) {
                a(context, a(context) + 1);
            }
            com.xiaomi.channel.commonutils.logger.c.m9a("fail to register push account. meet error.");
            return null;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    private static String a(Context context, boolean z8) {
        String strA = c.a(context).a();
        String str = z8 ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (com.xiaomi.push.z.b()) {
            return W5.f.k(new StringBuilder(JPushConstants.HTTP_PRE), gq.f17546b, ":9085", str);
        }
        if (com.xiaomi.push.o.China.name().equals(strA)) {
            return A.a.j(new StringBuilder(JPushConstants.HTTPS_PRE), f18412c, str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m829a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static void a(Context context, int i9) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putInt("enc_req_fail_count", i9);
        editorEdit.commit();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    public static void a(Context context, u uVar) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putString("uuid", uVar.f1155a);
        editorEdit.putString("security", uVar.f18406c);
        editorEdit.putString("token", uVar.f18405b);
        editorEdit.putString("app_id", uVar.f18407d);
        editorEdit.putString(Constants.PACKAGE_NAME, uVar.f18409f);
        editorEdit.putString("app_token", uVar.f18408e);
        editorEdit.putInt("env_type", uVar.f18404a);
        editorEdit.commit();
        u.a(uVar.f1155a);
        a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m828a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f18410a = null;
        u.a("-1");
        a();
    }

    public static void a(a aVar) {
        f1156a = aVar;
    }

    public static void a() {
        a aVar = f1156a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m827a(Context context) {
        u uVarM826a = m826a(context);
        if (uVarM826a == null || TextUtils.isEmpty(uVarM826a.f1155a)) {
            return null;
        }
        String[] strArrSplit = uVarM826a.f1155a.split("@");
        if (strArrSplit.length > 0) {
            return strArrSplit[0];
        }
        return null;
    }
}
