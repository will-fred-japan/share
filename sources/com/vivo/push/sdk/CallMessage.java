package com.vivo.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class CallMessage {
    private String mMessage;
    private String mMsgId;

    public CallMessage(String str, String str2) {
        this.mMsgId = str;
        this.mMessage = str2;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getMsgId() {
        return this.mMsgId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CallMessage{mMsgId='");
        sb.append(this.mMsgId);
        sb.append("', mMessage='");
        return A.a.j(sb, this.mMessage, "'}");
    }
}
