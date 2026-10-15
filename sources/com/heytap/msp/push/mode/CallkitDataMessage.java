package com.heytap.msp.push.mode;

import A.a;
import android.content.Intent;
import com.heytap.mcssdk.constant.b;

/* JADX INFO: loaded from: classes.dex */
public final class CallkitDataMessage extends BaseMode {
    private final String mAppId;
    private final String mContent;
    private final String mDescription;
    private final String mMessageId;
    private final String mMessagePathType;
    private final int mType;

    public CallkitDataMessage(Intent intent, int i9) {
        this.mAppId = safeDecrypt(intent.getStringExtra(b.f14302u));
        this.mMessageId = safeDecrypt(intent.getStringExtra(b.f14286c));
        this.mContent = safeDecrypt(intent.getStringExtra("content"));
        this.mDescription = safeDecrypt(intent.getStringExtra(b.f14292i));
        this.mMessagePathType = safeDecrypt(intent.getStringExtra(b.f14280F));
        this.mType = i9;
    }

    private static String safeDecrypt(String str) {
        try {
            return com.heytap.mcssdk.utils.b.d(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public String getAppID() {
        return this.mAppId;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getMessageID() {
        return this.mMessageId;
    }

    public String getMessagePathType() {
        return this.mMessagePathType;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return this.mType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CallkitDataMessage{messageId='");
        sb.append(this.mMessageId);
        sb.append("', appId='");
        sb.append(this.mAppId);
        sb.append("', content='");
        sb.append(this.mContent);
        sb.append("', description='");
        return a.j(sb, this.mDescription, "'}");
    }
}
