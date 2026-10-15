package com.jieli.jl_bt_ota.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ErrorMsg {
    private static final String KEY_CODE = "code";
    private static final String KEY_DESC = "desc";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_SUB_CODE = "sub_code";
    private final int code;
    private final String codeDesc;
    private final int subCode;
    private String subMessage;

    public ErrorMsg(int i9, String str, int i10, String str2) {
        this.code = i9;
        this.codeDesc = str;
        this.subCode = i10;
        this.subMessage = str2;
    }

    public static ErrorMsg parseJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code") && jSONObject.has(KEY_SUB_CODE)) {
                return new ErrorMsg(jSONObject.getInt("code"), jSONObject.has(KEY_DESC) ? jSONObject.getString(KEY_DESC) : null, jSONObject.getInt(KEY_SUB_CODE), jSONObject.has("message") ? jSONObject.getString("message") : null);
            }
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
        return null;
    }

    private String toJsonString() {
        StringBuilder sb = new StringBuilder("{\"code\":");
        sb.append(this.code);
        if (!TextUtils.isEmpty(this.codeDesc)) {
            sb.append(", \"desc\":\"");
            sb.append(this.codeDesc);
            sb.append("\"");
        }
        sb.append(", \"sub_code\":");
        sb.append(this.subCode);
        if (!TextUtils.isEmpty(this.subMessage)) {
            sb.append(", \"message\":\"");
            sb.append(this.subMessage);
            sb.append("\"");
        }
        sb.append("}");
        return sb.toString();
    }

    public Integer getCode() {
        return Integer.valueOf(this.code);
    }

    public String getCodeDesc() {
        return this.codeDesc;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public String getSubMessage() {
        return this.subMessage;
    }

    public void setSubMessage(String str) {
        this.subMessage = str;
    }

    public String toString() {
        return toJsonString();
    }
}
