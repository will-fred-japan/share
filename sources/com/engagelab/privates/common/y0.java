package com.engagelab.privates.common;

import android.text.TextUtils;
import com.engagelab.privates.push.utils.NotificationUtil;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class y0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12407b;

    public y0(String str, String str2) {
        this.f12406a = str;
        this.f12407b = str2;
    }

    public static y0 a(JSONObject jSONObject, long j) {
        String messageId = NotificationUtil.getMessageId(jSONObject);
        if (TextUtils.isEmpty(messageId) && j > 0) {
            messageId = j + "";
        }
        return new y0(messageId, jSONObject.optString("override_msg_id"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        if (TextUtils.isEmpty(this.f12406a) || TextUtils.isEmpty(y0Var.f12406a) || !TextUtils.equals(this.f12406a, y0Var.f12406a)) {
            return false;
        }
        if (TextUtils.isEmpty(this.f12407b) && TextUtils.isEmpty(y0Var.f12407b)) {
            return true;
        }
        return (TextUtils.isEmpty(this.f12407b) || TextUtils.isEmpty(y0Var.f12407b) || !TextUtils.equals(this.f12407b, y0Var.f12407b)) ? false : true;
    }

    public String toString() {
        return "msg_id = " + this.f12406a + ",  override_msg_id = " + this.f12407b;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", this.f12406a);
            jSONObject.put("override_msg_id", this.f12407b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
