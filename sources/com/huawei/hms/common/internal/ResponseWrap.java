package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ResponseWrap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ResponseHeader f14981b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f14981b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.f14981b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f14981b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.f14981b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.f14981b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f14981b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f14981b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f14981b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f14981b.setPkgName(JsonUtil.getStringValue(jSONObject, "pkg_name"));
            this.f14981b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.f14981b.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
            this.f14981b.setResolution(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.HAS_RESOLUTION));
            this.f14980a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e9) {
            HMSLog.e("ResponseWrap", "fromJson failed: " + e9.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f14980a)) {
            this.f14980a = new JSONObject().toString();
        }
        return this.f14980a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f14981b;
    }

    public void setBody(String str) {
        this.f14980a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f14981b = responseHeader;
    }

    public String toJson() {
        if (this.f14981b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.f14981b.getStatusCode());
            jSONObject.put("error_code", this.f14981b.getErrorCode());
            jSONObject.put("error_reason", this.f14981b.getErrorReason());
            jSONObject.put("srv_name", this.f14981b.getSrvName());
            jSONObject.put("api_name", this.f14981b.getApiName());
            jSONObject.put("app_id", this.f14981b.getAppID());
            jSONObject.put("pkg_name", this.f14981b.getPkgName());
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.f14981b.getTransactionId());
            jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, this.f14981b.getResolution());
            String sessionId = this.f14981b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!TextUtils.isEmpty(this.f14980a)) {
                jSONObject.put("body", this.f14980a);
            }
        } catch (JSONException e9) {
            HMSLog.e("ResponseWrap", "toJson failed: " + e9.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f14980a + "', responseHeader=" + this.f14981b + '}';
    }
}
