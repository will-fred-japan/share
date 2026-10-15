package com.starburst.sdk.resp;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class GuiControlResponse {
    private String action;
    private int code;
    private String interruptReason;
    private String msg;
    private boolean needUserConfirm;
    private String raw;
    private String requestId;

    @SerializedName("Summary")
    private String summary;

    public String getAction() {
        return this.action;
    }

    public int getCode() {
        return this.code;
    }

    public String getInterruptReason() {
        return this.interruptReason;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRaw() {
        return this.raw;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getSummary() {
        return this.summary;
    }

    public boolean isNeedUserConfirm() {
        return this.needUserConfirm;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setCode(int i9) {
        this.code = i9;
    }

    public void setInterruptReason(String str) {
        this.interruptReason = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setNeedUserConfirm(boolean z8) {
        this.needUserConfirm = z8;
    }

    public void setRaw(String str) {
        this.raw = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }
}
