package cn.jpush.android.k;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Context context, d dVar) {
        Logger.d("JAnalytics", "sendClickNotificationMessage");
        a(context, "jg_message_click", c(context, dVar));
    }

    public static void b(Context context, d dVar) {
        Logger.d("JAnalytics", "sendClearNotificationMessage");
        a(context, "jg_message_clean", c(context, dVar));
    }

    private static JSONObject c(Context context, d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            NotificationMessage notificationMessageB = dVar.b();
            if (TextUtils.isEmpty(notificationMessageB.appkey)) {
                notificationMessageB.appkey = JCoreHelper.getAppKey(context);
            }
            Logger.w("JAnalytics", "notificationMessage:" + notificationMessageB);
            jSONObject.put("jg_msg_id", notificationMessageB.msgId);
            jSONObject.put("jg_msg_title", notificationMessageB.notificationTitle);
            jSONObject.put("jg_msg_content", notificationMessageB.notificationContent);
            jSONObject.put("jg_msg_type", dVar.f11317a);
            jSONObject.put("jg_msg_url", notificationMessageB.deeplink);
            jSONObject.put("jg_target_event", notificationMessageB.notificationTargetEvent);
            String str = notificationMessageB.notificationExtras;
            if (str != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.put("jg_task_id", jSONObject2.optString("_jg_taskid", ""));
                    jSONObject.put("jg_plan_id", jSONObject2.optString("_jg_planid", ""));
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            Logger.ee("JAnalytics", "getJsonNotificationMessage:", th);
        }
        return jSONObject;
    }

    public static void a(Context context, String str, JSONObject jSONObject) {
        Logger.d("JAnalytics", "report eventId:" + str + ", eventProperty:" + jSONObject);
        Bundle bundle = new Bundle();
        bundle.putString("event_id", str);
        if (jSONObject != null) {
            bundle.putString("event_property", jSONObject.toString());
        }
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 89, "report_reserved", bundle, new Object[0]);
    }
}
