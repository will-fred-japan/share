package com.vivo.push.model;

import android.text.TextUtils;
import com.vivo.push.util.t;
import com.vivo.push.util.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UnvarnishedMessage {
    private static final String TAG = "UnvarnishedMessage";
    private String mMessage;
    private long mMsgId;
    private int mTargetType;
    private String mTragetContent;
    private Map<String, String> mParams = new HashMap();
    private int mTransmissionMessageEventType = 0;

    public UnvarnishedMessage() {
    }

    private void packToObj(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                w.a(TAG, "unvarnishedMsg pack to obj is null");
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.mTargetType = jSONArray.optInt(0);
            this.mTragetContent = jSONArray.getString(1);
            this.mMessage = jSONArray.getString(2);
            this.mParams = t.a(new JSONObject(jSONArray.getString(3)));
        } catch (JSONException e9) {
            w.a(TAG, "unvarnishedMsg pack to obj error", e9);
        }
    }

    public String getMessage() {
        return this.mMessage;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public int getTargetType() {
        return this.mTargetType;
    }

    public String getTragetContent() {
        return this.mTragetContent;
    }

    public boolean isCallMessage() {
        return this.mTransmissionMessageEventType == 2;
    }

    public boolean isTransMsgArrive() {
        return this.mTransmissionMessageEventType == 0;
    }

    public boolean isTransMsgExpired() {
        return this.mTransmissionMessageEventType == 1;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setMsgId(long j) {
        this.mMsgId = j;
    }

    public void setParams(Map<String, String> map) {
        this.mParams = map;
    }

    public void setTargetType(int i9) {
        this.mTargetType = i9;
    }

    public void setTragetContent(String str) {
        this.mTragetContent = str;
    }

    public void setTransmissionMessageEventType(int i9) {
        this.mTransmissionMessageEventType = i9;
    }

    public String unpackToJson() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.mTargetType);
        jSONArray.put(this.mTragetContent);
        jSONArray.put(this.mMessage);
        Object map = this.mParams;
        if (map == null) {
            map = new HashMap();
        }
        jSONArray.put(map);
        return jSONArray.toString();
    }

    public UnvarnishedMessage(String str) {
        packToObj(str);
    }
}
