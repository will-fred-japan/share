package cn.jpush.android.api;

import A.f;

/* JADX INFO: loaded from: classes.dex */
public class CustomMessage {
    public String appId;
    public String contentType;
    public String extra;
    public String message;
    public String messageId;
    public byte platform;
    public String senderId;
    public String title;

    public String toString() {
        StringBuilder sb = new StringBuilder("CustomMessage{messageId='");
        sb.append(this.messageId);
        sb.append("', extra='");
        sb.append(this.extra);
        sb.append("', message='");
        sb.append(this.message);
        sb.append("', contentType='");
        sb.append(this.contentType);
        sb.append("', title='");
        sb.append(this.title);
        sb.append("', senderId='");
        sb.append(this.senderId);
        sb.append("', appId='");
        sb.append(this.appId);
        sb.append("', platform='");
        return f.i(sb, this.platform, "'}");
    }
}
