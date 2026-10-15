package cn.jpush.android.helper;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.local.JPushConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(Context context, String str, byte b9, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "", b9, 1000L, context, str2, null);
            return;
        }
        Logger.ee("JPushReportHelper", "The msgId is not valid - " + str);
    }

    public static void b(Context context, String str, byte b9, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "", b9, 1800L, context, str2, null);
            return;
        }
        Logger.ee("JPushReportHelper", "The msgId is not valid - " + str);
    }

    public static void a(Context context, String str, long j, int i9) {
        a(str, f.a(i9, j), (String) null, context);
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        Logger.d("JPushReportHelper", "action:reportOperation - content:" + jSONObject.toString());
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 14, null, null, jSONObject);
    }

    public static void a(String str, long j, Context context) {
        a(str, j, (String) null, context);
    }

    public static void a(String str, long j, String str2, Context context) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportActionResult - messageId: " + str + ", code: " + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f.a(j));
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("， report content: " + str2);
        }
        String strC = cn.jpush.android.d.d.c(str);
        if (!TextUtils.isEmpty(strC)) {
            stringBuffer.append("， report jData:" + strC);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", str);
            jSONObject.put("result", j);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("data", str2);
            }
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("_j_data_", strC);
            }
            JSONObject jSONObjectFillBase = JCoreHelper.fillBase(context, jSONObject, MTPushConstants.Message.TYPE_MESSAGE_STATE);
            if (jSONObjectFillBase != null) {
                jSONObjectFillBase.put("type", MTPushConstants.Message.TYPE_MESSAGE_STATE);
                a(context, jSONObjectFillBase);
            } else {
                Logger.ww("JPushReportHelper", "report msg json is null, code: " + j);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, byte b9, long j, Context context) {
        a(str, str2, b9, j, context, null, null);
    }

    public static void a(String str, String str2, byte b9, long j, Context context, String str3, String str4) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportThirdSDKMsgActionResult - messageId: " + str + ", code: " + j);
        if (!TextUtils.isEmpty(str4)) {
            stringBuffer.append("， report content: " + str4);
        }
        String strC = cn.jpush.android.d.d.c(str);
        if (TextUtils.isEmpty(strC) && !TextUtils.isEmpty(str3)) {
            try {
                strC = new JSONObject(str3).optString("_j_data_", "");
                Logger.d("JPushReportHelper", "get jdata from third push msg:" + strC);
            } catch (Throwable th) {
                Logger.d("JPushReportHelper", "get jdata from third push msg error:" + th.getMessage());
            }
        }
        if (!TextUtils.isEmpty(strC)) {
            stringBuffer.append("， report jData:" + strC);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", str);
            jSONObject.put("tmsg_id", str2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("data", str4);
            }
            jSONObject.put("result", j);
            jSONObject.put(HianalyticsBaseData.SDK_TYPE, (int) b9);
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("_j_data_", strC);
            }
            JSONObject jSONObjectFillBase = JCoreHelper.fillBase(context, jSONObject, MTPushConstants.Message.TYPE_PLATFORM_MESSAGE_STATE);
            if (jSONObjectFillBase != null) {
                jSONObjectFillBase.put("type", MTPushConstants.Message.TYPE_PLATFORM_MESSAGE_STATE);
                a(context, jSONObjectFillBase);
            } else {
                Logger.ww("JPushReportHelper", "report third sdk msg json is null, code: " + j);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, Map<String, Integer> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            JCoreHelper.fillBase(context, jSONObject, "api_record");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if ((value instanceof Integer) && value.intValue() != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("method", entry.getKey());
                    jSONObject2.put(MTPushConstants.Geofence.KEY_COUNT, value);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("record_list", jSONArray);
            a(context, jSONObject);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
