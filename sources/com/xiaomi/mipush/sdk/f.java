package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.ah;
import com.xiaomi.push.ax;
import com.xiaomi.push.bh;
import com.xiaomi.push.bl;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.aq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.f$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16974a;

        static {
            int[] iArr = new int[d.values().length];
            f16974a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16974a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16974a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16974a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m57a(Context context, d dVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iA = a(context, dVar, str);
        if (iA == 0) {
            com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH : send token upload, check:" + iA);
        a(context, str);
        v vVarM61a = g.m61a(dVar);
        if (vVarM61a == null) {
            return;
        }
        u.a(context).a((String) null, vVarM61a, dVar, "upload");
    }

    public static void b(final Context context, final d dVar, final String str) {
        ah.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.f.1
            @Override // java.lang.Runnable
            public void run() {
                String strSubstring;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String[] strArrSplit = str.split(Constants.WAVE_SEPARATOR);
                int length = strArrSplit.length;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        strSubstring = "";
                        break;
                    }
                    String str2 = strArrSplit[i9];
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                        strSubstring = str2.substring(str2.indexOf(Constants.COLON_SEPARATOR) + 1);
                        break;
                    }
                    i9++;
                }
                if (TextUtils.isEmpty(strSubstring)) {
                    com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH : receive incorrect token");
                    return;
                }
                com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH : receive correct token");
                f.d(context, dVar, strSubstring);
                f.m55a(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context, d dVar, String str) {
        String strA = a(dVar);
        if (TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putString(strA, str).putString("last_check_token", b.m35a(context).m43c());
        if (m60a(dVar)) {
            editorEdit.putInt(b(dVar), a());
        }
        editorEdit.putString("syncingToken", "");
        com.xiaomi.push.q.a(editorEdit);
        com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH : update sp file success!  " + str);
    }

    public static void b(Context context) {
        e.a(context).register();
    }

    public static void c(Context context) {
        e.a(context).unregister();
    }

    public static String b(d dVar) {
        return a(dVar) + "_version";
    }

    public static String c(d dVar) {
        int i9 = AnonymousClass2.f16974a[dVar.ordinal()];
        if (i9 == 1) {
            return "hms_push_error";
        }
        if (i9 == 2) {
            return "fcm_push_error";
        }
        if (i9 == 3) {
            return "cos_push_error";
        }
        if (i9 != 4) {
            return null;
        }
        return "ftos_push_error";
    }

    private static int a(Context context, d dVar, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String strA = a(dVar);
        String string = sharedPreferences.getString(strA, "");
        String strM43c = b.m35a(context).m43c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        }
        if (TextUtils.isEmpty(string)) {
            return 1;
        }
        if (!string.equals(str)) {
            return 2;
        }
        if (!TextUtils.equals(strM43c, string2)) {
            return 3;
        }
        if (m60a(dVar)) {
            if (a() != sharedPreferences.getInt(b(dVar), 0)) {
                return 4;
            }
        }
        return 0;
    }

    public static String a(Context context, d dVar) {
        return a(context, dVar, false);
    }

    public static boolean a(iq iqVar, d dVar) {
        String str;
        if (iqVar == null || iqVar.m552a() == null || iqVar.m552a().m519a() == null) {
            return false;
        }
        if (dVar == d.ASSEMBLE_PUSH_FCM) {
            str = "FCM";
        } else {
            str = "";
        }
        return str.equalsIgnoreCase(iqVar.m552a().m519a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, iq iqVar, d dVar) {
        if (a(iqVar, dVar)) {
            return bl.m126a(a(context, dVar));
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m55a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String strA = a(d.ASSEMBLE_PUSH_HUAWEI);
        String strA2 = a(d.ASSEMBLE_PUSH_FCM);
        if (TextUtils.isEmpty(sharedPreferences.getString(strA, "")) || !TextUtils.isEmpty(sharedPreferences.getString(strA2, ""))) {
            return;
        }
        u.a(context).a(2, strA);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m56a(Context context, d dVar) {
        String strA = a(dVar);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        com.xiaomi.push.q.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(strA, ""));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m59a(Context context, d dVar) {
        if (g.m62a(dVar) != null) {
            return aq.a(context).a(g.m62a(dVar).a(), true);
        }
        return false;
    }

    public static void a(String str, int i9) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, W5.e.i(i9, "error code = "));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m58a(Context context) {
        if (context == null) {
            return false;
        }
        return ax.m111a(context);
    }

    private static synchronized void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putString("syncingToken", str);
        editorEdit.apply();
    }

    public static synchronized String a(Context context, d dVar, boolean z8) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        if (z8) {
            String string = sharedPreferences.getString("syncingToken", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String strA = a(dVar);
        if (!TextUtils.isEmpty(strA)) {
            return sharedPreferences.getString(strA, "");
        }
        return "";
    }

    public static PushMessageReceiver a(Context context) {
        ResolveInfo next;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (listQueryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    ActivityInfo activityInfo = next.activityInfo;
                    if (activityInfo == null || !activityInfo.packageName.equals(context.getPackageName())) {
                    }
                }
                next = null;
            } else {
                next = null;
            }
            if (next != null) {
                return (PushMessageReceiver) com.xiaomi.push.t.a(context, next.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.d(e9.toString());
            return null;
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has(com.heytap.mcssdk.constant.b.f14292i)) {
                    miPushMessage.setDescription(jSONObject.getString(com.heytap.mcssdk.constant.b.f14292i));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has(MTPushConstants.Operation.KEY_ALIAS)) {
                    miPushMessage.setAlias(jSONObject.getString(MTPushConstants.Operation.KEY_ALIAS));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has(JThirdPlatFormInterface.KEY_EXTRA)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(JThirdPlatFormInterface.KEY_EXTRA);
                    Iterator<String> itKeys = jSONObject2.keys();
                    HashMap map = new HashMap();
                    while (itKeys != null && itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject2.getString(next));
                    }
                    if (map.size() > 0) {
                        miPushMessage.setExtra(map);
                        return miPushMessage;
                    }
                }
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.d(e9.toString());
            }
        }
        return miPushMessage;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static HashMap<String, String> m54a(Context context, d dVar) {
        HashMap<String, String> map = new HashMap<>();
        int i9 = AnonymousClass2.f16974a[dVar.ordinal()];
        String string = null;
        ApplicationInfo applicationInfo = null;
        if (i9 == 1) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.d(e9.toString());
            }
            string = new com.xiaomi.push.u.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, q.HUAWEI.name()).a("token", a(context, dVar, true)).a(Constants.PACKAGE_NAME, context.getPackageName()).a("app_id", Integer.valueOf(applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1)).toString();
        } else if (i9 == 2) {
            com.xiaomi.push.u.a aVarA = new com.xiaomi.push.u.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, q.FCM.name()).a("token", a(context, dVar, false)).a(Constants.PACKAGE_NAME, context.getPackageName());
            int iA = a();
            if (iA != 0) {
                aVarA.a("version", Integer.valueOf(iA));
            } else {
                aVarA.a("version", Integer.valueOf(BuildConfig.VERSION_CODE));
            }
            string = aVarA.toString();
        } else if (i9 == 3) {
            string = new com.xiaomi.push.u.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, q.OPPO.name()).a("token", a(context, dVar, true)).a(Constants.PACKAGE_NAME, context.getPackageName()).toString();
        } else if (i9 == 4) {
            com.xiaomi.push.u.a aVarA2 = new com.xiaomi.push.u.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, q.VIVO.name()).a("token", a(context, dVar, true)).a(Constants.PACKAGE_NAME, context.getPackageName());
            int iA2 = a();
            if (iA2 != 0) {
                aVarA2.a("version", Integer.valueOf(iA2));
            }
            string = aVarA2.toString();
        }
        map.put(Constants.ASSEMBLE_PUSH_REG_INFO, string);
        return map;
    }

    public static int a() {
        Integer num = (Integer) bh.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m60a(d dVar) {
        return dVar == d.ASSEMBLE_PUSH_FTOS || dVar == d.ASSEMBLE_PUSH_FCM;
    }

    public static String a(d dVar) {
        int i9 = AnonymousClass2.f16974a[dVar.ordinal()];
        if (i9 == 1) {
            return "hms_push_token";
        }
        if (i9 == 2) {
            return "fcm_push_token_v2";
        }
        if (i9 == 3) {
            return "cos_push_token";
        }
        if (i9 != 4) {
            return null;
        }
        return "ftos_push_token";
    }
}
