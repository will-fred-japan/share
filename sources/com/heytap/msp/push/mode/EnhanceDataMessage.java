package com.heytap.msp.push.mode;

import A.a;
import com.heytap.mcssdk.constant.MessageConstant;

/* JADX INFO: loaded from: classes.dex */
public class EnhanceDataMessage extends BaseMode {
    private String mAppPackage;
    private String mContent;
    private String mMessageID;
    private int mMessageType;

    public EnhanceDataMessage(String str, String str2, String str3, int i9) {
        this.mAppPackage = str;
        this.mMessageID = str2;
        this.mContent = str3;
        this.mMessageType = i9;
    }

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getMessageID() {
        return this.mMessageID;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return MessageConstant.MessageType.MESSAGE_SPT_ENHANCED_DATA;
    }

    public void setAppPackage(String str) {
        this.mAppPackage = str;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setMessageID(String str) {
        this.mMessageID = str;
    }

    public void setMessageType(int i9) {
        this.mMessageType = i9;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EnhanceDataMessage{mAppPackage='");
        sb.append(this.mAppPackage);
        sb.append("', mMessageID='");
        sb.append(this.mMessageID);
        sb.append("', mContent='");
        return a.j(sb, this.mContent, "'}");
    }
}
