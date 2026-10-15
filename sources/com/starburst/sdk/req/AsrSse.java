package com.starburst.sdk.req;

import H2.a;

/* JADX INFO: loaded from: classes.dex */
public class AsrSse {
    private int code;
    private boolean complete;
    private String contextId;
    private String failReason;
    private int inputToken;
    private String llmResponse;
    private String msg;
    private int outputToken;
    private String requestId;

    public int getCode() {
        return this.code;
    }

    public String getContextId() {
        return this.contextId;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public int getInputToken() {
        return this.inputToken;
    }

    public String getLlmResponse() {
        return this.llmResponse;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getOutputToken() {
        return this.outputToken;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public void setCode(int i9) {
        this.code = i9;
    }

    public void setComplete(boolean z8) {
        this.complete = z8;
    }

    public void setContextId(String str) {
        this.contextId = str;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setInputToken(int i9) {
        this.inputToken = i9;
    }

    public void setLlmResponse(String str) {
        this.llmResponse = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setOutputToken(int i9) {
        this.outputToken = i9;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AsrSse{code=");
        sb.append(this.code);
        sb.append(", msg='");
        sb.append(this.msg);
        sb.append("', failReason='");
        sb.append(this.failReason);
        sb.append("', requestId='");
        sb.append(this.requestId);
        sb.append("', llmResponse='");
        sb.append(this.llmResponse);
        sb.append("', complete=");
        sb.append(this.complete);
        sb.append(", contextId='");
        sb.append(this.contextId);
        sb.append("', inputToken=");
        sb.append(this.inputToken);
        sb.append(", outputToken=");
        return a.a(sb, this.outputToken, '}');
    }
}
